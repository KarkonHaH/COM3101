package Start;

import java.io.File;
import java.sql.*;

public class DatabaseCreator {
    private static final String DB_NAME = "database.db";

    public DatabaseCreator() {
        Connection connection = null;
        try {
            // Check if database file exists
            boolean databaseExists = false;
            if (new File(DB_NAME).isFile()) {
                databaseExists = true;
            }

            // Open database connection
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);

            // If database doesn't exist, create tables
            if (!databaseExists) {
                Statement statement = connection.createStatement();
                
                statement.executeUpdate("CREATE TABLE users ("
                        + "user_id TEXT PRIMARY KEY,"
                        + "user_password TEXT,"
                        + "user_group TEXT,"
                        + "gender TEXT,"
                        + "user_name TEXT)");
                
                statement.executeUpdate("CREATE TABLE courses ("
                        + "course_code TEXT,"
                        + "session TEXT,"
                        + "course_title TEXT,"
                        + "teacher TEXT,"
                        + "weekday TEXT,"
                        + "start_time TEXT,"
                        + "end_time TEXT,"
                        + "capacity INTEGER,"
                        + "applicants INTEGER,"
                        + "PRIMARY KEY (course_code, session));");
                
                statement.executeUpdate("CREATE TABLE course_registrations ("
                        + "user_id TEXT,"
                        + "course_code TEXT,"
                        + "session TEXT,"
                        + "PRIMARY KEY (user_id, course_code, session),"
                        + "FOREIGN KEY (user_id) REFERENCES users(user_id),"
                        + "FOREIGN KEY (course_code, session) REFERENCES courses(course_code, session))");
                
                statement.executeUpdate("CREATE TABLE pending_add_drop ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "user_id TEXT,"
                        + "add_course_code TEXT,"
                        + "add_session TEXT,"
                        + "drop_course_code TEXT,"
                        + "drop_session TEXT,"
                        + "FOREIGN KEY (user_id) REFERENCES users(user_id),"
                        + "FOREIGN KEY (add_course_code, add_session) REFERENCES courses(course_code, session),"
                        + "FOREIGN KEY (drop_course_code, drop_session) REFERENCES courses(course_code, session))");
                
                statement.executeUpdate("INSERT INTO users VALUES ('S01', '123456', 'Student', 'F', 'Student1')");
                statement.executeUpdate("INSERT INTO users VALUES ('S02', '123456', 'Student', 'M', 'Student2')");
                statement.executeUpdate("INSERT INTO users VALUES ('S03', '123456', 'Student', 'M', 'Student3')");
                statement.executeUpdate("INSERT INTO users VALUES ('T01', 'password1', 'Teacher', 'M', 'user1')");
                statement.executeUpdate("INSERT INTO users VALUES ('T02', 'password2', 'Teacher', 'F', 'user2')");
                
                statement.executeUpdate("INSERT INTO courses VALUES ('C01', 'L01', 'Course1', 'Dr One', 'Mon', '09:00', '12:00', 2, 0)");
                statement.executeUpdate("INSERT INTO courses VALUES ('C01', 'L02', 'Course1', 'Dr One', 'Mon', '18:30', '21:30', 2, 0)");
                statement.executeUpdate("INSERT INTO courses VALUES ('C02', 'L01', 'Course2', 'Dr Two', 'Tue', '09:00', '12:00', 2, 0)");
                statement.executeUpdate("INSERT INTO courses VALUES ('C03', 'L01', 'Course3', 'Dr Three', 'Mon', '09:00', '12:00', 2, 0)");
                statement.executeUpdate("INSERT INTO courses VALUES ('C04', 'L01', 'Course4', 'Dr Four', 'Thur', '09:00', '12:00', 2, 0)");
                statement.executeUpdate("INSERT INTO courses VALUES ('C05', 'L01', 'Course5', 'Dr Five', 'Fri', '09:00', '12:00', 2, 0)");
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}