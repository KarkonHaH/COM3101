package Model;

import Controller.TeacherController;
import DTO.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TeacherModel {

    private static final String DB_NAME = "database.db";
    private Connection connection;

    private TeacherController teacherController;

    public void setTeacherController(TeacherController teacherController) {
        this.teacherController = teacherController;
    }

    //create connection with SQL database
    public void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //close connection with SQL database
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User processUserInfo(String userId) {
        User user = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            pstmt.setString(1, userId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String userGroup = rs.getString("user_group");
                String userPassword = rs.getString("user_password");
                String gender = rs.getString("gender");
                String userName = rs.getString("user_name");
                user = new User(userId, userPassword, userGroup, gender, userName);
            }
            rs.close();
            pstmt.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public class NonEditableTableModel extends DefaultTableModel {

        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public NonEditableTableModel processRegisteredCourses(String userId) {

        NonEditableTableModel model = new NonEditableTableModel(
                new Object[]{"Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"},
                0
        );

        // Connect to the database and retrieve the courses
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM courses WHERE (course_code, session) IN (SELECT course_code, session FROM course_registrations WHERE user_id='" + userId + "') ORDER BY course_code ASC, session ASC")) {
            // Loop through the result set and add the courses to the model
            while (resultSet.next()) {
                String courseCode = resultSet.getString("course_code");
                String session = resultSet.getString("session");
                String courseTitle = resultSet.getString("course_title");
                String teacher = resultSet.getString("teacher");
                String weekday = resultSet.getString("weekday");
                String startTime = resultSet.getString("start_time");
                String endTime = resultSet.getString("end_time");
                int capacity = resultSet.getInt("capacity");
                int applicants = resultSet.getInt("applicants");

                model.addRow(new Object[]{courseCode, session, courseTitle, teacher, weekday, startTime, endTime, capacity, applicants});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    public NonEditableTableModel processUnregisteredCourses(String searchKeyword, String userId) {

        NonEditableTableModel model = new NonEditableTableModel(
                new Object[]{"Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"},
                0
        );

        // Connect to the database and retrieve the courses
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM courses WHERE course_code LIKE '%" + searchKeyword + "%' AND (course_code, session) NOT IN (SELECT course_code, session FROM course_registrations WHERE user_id='" + userId + "') ORDER BY course_code ASC, session ASC")) {
            // Loop through the result set and add the courses to the model
            while (resultSet.next()) {
                String courseCode = resultSet.getString("course_code");
                String session = resultSet.getString("session");
                String courseTitle = resultSet.getString("course_title");
                String teacher = resultSet.getString("teacher");
                String weekday = resultSet.getString("weekday");
                String startTime = resultSet.getString("start_time");
                String endTime = resultSet.getString("end_time");
                int capacity = resultSet.getInt("capacity");
                int applicants = resultSet.getInt("applicants");

                model.addRow(new Object[]{courseCode, session, courseTitle, teacher, weekday, startTime, endTime, capacity, applicants});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    public String processAddCourse(String userId, String courseCode, String session) {
        try {
            // Check if the student is already registered in the course
            String checkEnrollmentSql = "SELECT COUNT(*) FROM course_registrations WHERE user_id = ? AND course_code = ?";
            try (PreparedStatement statement = connection.prepareStatement(checkEnrollmentSql)) {
                statement.setString(1, userId);
                statement.setString(2, courseCode);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt(1) > 0) {
                        // Student is already enrolled in the course
                        return "The course has been registered already";
                    }
                }
            }

            // Check if the session is full
            String checkCapacitySql = "SELECT capacity, applicants FROM courses WHERE course_code = ? AND session = ?";
            try (PreparedStatement statement = connection.prepareStatement(checkCapacitySql)) {
                statement.setString(1, courseCode);
                statement.setString(2, session);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt("applicants") >= resultSet.getInt("capacity")) {
                        // Session is full
                        return "The course is FULL";
                    }
                }
            }

            // Check if the student has exceeded their three-course quota
            String checkQuotaSql = "SELECT COUNT(*) FROM course_registrations WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(checkQuotaSql)) {
                statement.setString(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt(1) >= 3) {
                        // Student has already registered for three courses
                        return "THREE courses have been registered";
                    }
                }
            }

            // Check for time conflicts with other courses
            String checkConflictSql = "SELECT courses.course_code FROM course_registrations "
                    + "JOIN courses ON course_registrations.course_code = courses.course_code AND course_registrations.session = courses.session "
                    + "WHERE course_registrations.user_id = ? AND courses.weekday = ? AND (("
                    + "courses.start_time < ? AND courses.end_time > ?) OR (courses.start_time < ? AND courses.end_time > ?) OR (courses.start_time >= ? AND courses.start_time < ?) OR (courses.end_time > ? AND courses.end_time <= ?))";

            try (PreparedStatement statement = connection.prepareStatement(checkConflictSql)) {
                statement.setString(1, userId);

                // Get the weekday, start time and end time of the course being added
                String courseDetailsSql = "SELECT weekday, start_time, end_time FROM courses WHERE course_code = ? AND session = ?";
                try (PreparedStatement courseStatement = connection.prepareStatement(courseDetailsSql)) {
                    courseStatement.setString(1, courseCode);
                    courseStatement.setString(2, session);
                    try (ResultSet courseResultSet = courseStatement.executeQuery()) {
                        if (courseResultSet.next()) {
                            statement.setString(2, courseResultSet.getString("weekday"));
                            statement.setString(3, courseResultSet.getString("start_time"));
                            statement.setString(4, courseResultSet.getString("start_time"));
                            statement.setString(5, courseResultSet.getString("end_time"));
                            statement.setString(6, courseResultSet.getString("end_time"));
                            statement.setString(7, courseResultSet.getString("start_time"));
                            statement.setString(8, courseResultSet.getString("end_time"));
                            statement.setString(9, courseResultSet.getString("start_time"));
                            statement.setString(10, courseResultSet.getString("end_time"));
                            try (ResultSet conflictResultSet = statement.executeQuery()) {
                                if (conflictResultSet.next()) {
                                    // There is a time conflict with another course
                                    return "Time conflict with " + conflictResultSet.getString("course_code");
                                }
                            }
                        }
                    }
                }
            }

            // All eligibility criteria are met, add the course registration
            String addRegistrationSql = "INSERT INTO course_registrations (user_id, course_code, session) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(addRegistrationSql)) {
                statement.setString(1, userId);
                statement.setString(2, courseCode);
                statement.setString(3, session);
                statement.executeUpdate();
            }

            //Add 1 to Applicants
            String incrementApplicantsSql = "UPDATE courses SET applicants = applicants + 1 WHERE course_code = ? AND session = ?";
            try (PreparedStatement incrementStatement = connection.prepareStatement(incrementApplicantsSql)) {
                incrementStatement.setString(1, courseCode);
                incrementStatement.setString(2, session);
                incrementStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Registration added successfully
        return "Course is added successfully";
    }

    public String processDropCourse(String userId, String courseCode, String session) {
        try {
            // Check if the student is registered in the course
            String checkEnrollmentSql = "SELECT COUNT(*) FROM course_registrations WHERE user_id = ? AND course_code = ? AND session = ?";
            try (PreparedStatement statement = connection.prepareStatement(checkEnrollmentSql)) {
                statement.setString(1, userId);
                statement.setString(2, courseCode);
                statement.setString(3, session);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt(1) == 0) {
                        // Student is not registered in the course
                        return "The course is not be registered";
                    }
                }
            }

            // Remove the course registration
            String removeRegistrationSql = "DELETE FROM course_registrations WHERE user_id = ? AND course_code = ? AND session = ?";
            try (PreparedStatement statement = connection.prepareStatement(removeRegistrationSql)) {
                statement.setString(1, userId);
                statement.setString(2, courseCode);
                statement.setString(3, session);
                statement.executeUpdate();
            }

            // Delete from pending 
            String removePendingDataSql = "DELETE FROM pending_add_drop WHERE user_id = ? AND drop_course_code = ? AND drop_session = ?";
            try (PreparedStatement statement = connection.prepareStatement(removePendingDataSql)) {
                statement.setString(1, userId);
                statement.setString(2, courseCode);
                statement.setString(3, session);

                statement.executeUpdate();
            }

            // Decrement the applicants count for the course
            String decrementApplicantsSql = "UPDATE courses SET applicants = applicants - 1 WHERE course_code = ? AND session = ?";
            try (PreparedStatement decrementStatement = connection.prepareStatement(decrementApplicantsSql)) {
                decrementStatement.setString(1, courseCode);
                decrementStatement.setString(2, session);
                decrementStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Course dropped successfully
        return "Course is dropped successfully";
    }

    public String processAddDropCourse(String userId, String addCourseCode, String addSession, String dropCourseCode, String dropSession) {
        String result = null;
        try {
            // Start a transaction
            connection.setAutoCommit(false);

            // Attempt to drop the course
            String dropResult = processDropCourse(userId, dropCourseCode, dropSession);
            if (!dropResult.equals("Course is dropped successfully")) {
                throw new SQLException(dropResult);
            }

            // Attempt to add the course
            String addResult = processAddCourse(userId, addCourseCode, addSession);
            if (!addResult.equals("Course is added successfully")) {
                throw new SQLException(addResult);
            }

            // Commit the transaction
            connection.commit();

            // Set the result to "Add/Drop successfully"
            result = "Courses are add/drop successfully";

        } catch (SQLException e) {
            // Roll back the changes made to the database
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            result = e.getMessage();
        } finally {
            // Set auto-commit back to true
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String addToPendingList(String userId, String addCourseCode, String addSession, String dropCourseCode, String dropSession) {
        try {
            String sql = "INSERT INTO pending_add_drop (user_id, add_course_code, add_session, drop_course_code, drop_session) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, addCourseCode);
            preparedStatement.setString(3, addSession);
            preparedStatement.setString(4, dropCourseCode);
            preparedStatement.setString(5, dropSession);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                teacherController.updatePendingDisplayPanel();
                return "Add add/drop request to pending list successfully";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed. Please try again.";
    }

    public NonEditableTableModel processPendingCourses() {
        NonEditableTableModel model = new NonEditableTableModel(
                new Object[]{"ID", "User ID", "Add Code", "Add Session", "Drop Code", "Drop Session"},
                0
        );

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pending_add_drop")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userId = resultSet.getString("user_id");
                String addCourseCode = resultSet.getString("add_course_code");
                String addSession = resultSet.getString("add_session");
                String dropCourseCode = resultSet.getString("drop_course_code");
                String dropSession = resultSet.getString("drop_session");
                model.addRow(new Object[]{id, userId, addCourseCode, addSession, dropCourseCode, dropSession});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    public NonEditableTableModel processOverview() {
        NonEditableTableModel model = new NonEditableTableModel(
                new Object[]{"User ID", "Course Code", "Session", "Course Title", "Teacher", "Weekday", "Time", "Capacity", "Applicants"},
                0
        );

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT cr.user_id, cr.course_code, cr.session, c.course_title, c.teacher, c.weekday, c.start_time, c.end_time, c.capacity, c.applicants "
                        + "FROM course_registrations AS cr "
                        + "JOIN courses AS c ON cr.course_code = c.course_code AND cr.session = c.session "
                        + "ORDER BY cr.user_id, cr.course_code, cr.session")) {
            while (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String courseCode = resultSet.getString("course_code");
                String session = resultSet.getString("session");
                String courseTitle = resultSet.getString("course_title");
                String teacher = resultSet.getString("teacher");
                String weekday = resultSet.getString("weekday");
                String startTime = resultSet.getString("start_time");
                String endTime = resultSet.getString("end_time");
                int capacity = resultSet.getInt("capacity");
                int applicants = resultSet.getInt("applicants");

                model.addRow(new Object[]{userId, courseCode, session, courseTitle, teacher, weekday, startTime + " - " + endTime, capacity, applicants});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    public String processPending() {

        List<String[]> dataList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM pending_add_drop";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String[] data = new String[6];
                data[0] = result.getString("id");
                data[1] = result.getString("user_id");
                data[2] = result.getString("add_course_code");
                data[3] = result.getString("add_session");
                data[4] = result.getString("drop_course_code");
                data[5] = result.getString("drop_session");
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print the data stored in the list
        for (String[] data : dataList) {
            String userId = data[1];
            String addCourseCode = data[2];
            String addSession = data[3];
            String dropCourseCode = data[4];
            String dropSession = data[5];
            if (processAddDropCourse(userId, addCourseCode, addSession, dropCourseCode, dropSession).equals("Courses are add/drop successfully")) {
                try {
                    String sql = "DELETE FROM pending_add_drop WHERE user_id = ? AND add_course_code = ? AND add_session = ? AND drop_course_code = ? AND drop_session = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, userId);
                    statement.setString(2, addCourseCode);
                    statement.setString(3, addSession);
                    statement.setString(4, dropCourseCode);
                    statement.setString(5, dropSession);
                    int rowsAffected = statement.executeUpdate();
                    return String.valueOf(rowsAffected + 1) + "pending request(s) is/are processed";
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "check pending request(s) finish";
    }
}
