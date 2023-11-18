package Controller;

import Controller.LoginController;
import View.TeacherView;
import Model.TeacherModel;
import DTO.User;
import DTO.Course;
import javax.swing.table.DefaultTableModel;

public class TeacherController {
    
    private LoginController loginController;
    private TeacherView teacherView;
    private TeacherModel teacherModel;
    
    private User user = null;
    private Course addCourse = null;
    private Course dropCourse = null;
    private String add_SearchKeyword = "";
    private String drop_SearchKeyword = "";
    private String adddrop_SearchKeyword = "";
    private DefaultTableModel overviewModel = null;
    private DefaultTableModel unregisteredCoursesModel = null;
    private DefaultTableModel registeredCoursesModel = null;
    private DefaultTableModel pendingCoursesModel = null;
    
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    public void setTeacherView(TeacherView teacherView) {
        this.teacherView = teacherView;
    }
    
    public void setTeacherModel(TeacherModel teacherModel) {
        this.teacherModel = teacherModel;
    }
    
    public void startView(){
        updateOverviewDisplayPanel();
        updatePendingDisplayPanel();
        teacherView.setLocationRelativeTo(null);
        teacherView.setVisible(true);     
    }
    
    public void userInfoRequest(String UserId){
        user = null;
        teacherModel.createConnection();
        user = teacherModel.processUserInfo(UserId);
        if (user == null)
            teacherView.showMessage("Invalid ID, please try again.");
        else{
            String userGroup = user.getUserGroup();
            if (userGroup.equals("Student")){
                teacherView.updateUserInfo(user.getUserId(), user.getGender(), user.getUserName());
                teacherView.resetDisplaySearcher();
                updateAddDisplayPanel("","");
                updateDropDisplayPanel("","");
                updateAddDropDisplayPanel("","");              
            }
            else if (userGroup.equals("Teacher")){
                teacherView.showMessage("This is not a student ID, please try again.");
                
            }
        }
        teacherModel.closeConnection();
    }
    
    public void updateOverviewDisplayPanel(){
        overviewModel = new DefaultTableModel();
        teacherModel.createConnection();
        overviewModel = teacherModel.processOverview();
        teacherModel.closeConnection();
        teacherView.updateOverviewTable(overviewModel);
     
    }
    
    public void updateAddControlPanel(String row){
        row = row.substring(1, row.length() - 1);
        String[] rowData = row.split(", ");
        addCourse = new Course(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5], rowData[6], Integer.valueOf(rowData[7]), Integer.valueOf(rowData[8]));
        teacherView.updateAddLabel(rowData);
    }
    
    public void updateAddDisplayPanel(String comboBoxText, String textFieldText){
        if (comboBoxText.equals("ALL"))
            add_SearchKeyword = textFieldText;
        else
            add_SearchKeyword = comboBoxText + textFieldText;
        registeredCoursesModel = new DefaultTableModel();
        unregisteredCoursesModel = new DefaultTableModel();  
        teacherModel.createConnection();
        registeredCoursesModel = teacherModel.processRegisteredCourses( user.getUserId());
        unregisteredCoursesModel = teacherModel.processUnregisteredCourses(add_SearchKeyword, user.getUserId());
        teacherModel.closeConnection();
        teacherView.updateAddTable(registeredCoursesModel, unregisteredCoursesModel);
    }
    
    public void addCourseRequest(){
        if(addCourse != null){
            String result = "";
            teacherModel.createConnection();
            result = teacherModel.processAddCourse(user.getUserId(), addCourse.getCourseCode(), addCourse.getSession());
            teacherModel.closeConnection();
            updateOverviewDisplayPanel();
            updateAddDisplayPanel("ALL", add_SearchKeyword);
            updateDropDisplayPanel("ALL", drop_SearchKeyword);
            updateAddDropDisplayPanel("ALL", adddrop_SearchKeyword);
            teacherView.showMessage(result);     
            reset();
        }
        else
            teacherView.showMessage("No selected course");
    }
    
    public void updateDropControlPanel(String row){
        row = row.substring(1, row.length() - 1);
        String[] rowData = row.split(", ");
        dropCourse = new Course(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5], rowData[6], Integer.valueOf(rowData[7]), Integer.valueOf(rowData[8]));
        teacherView.updateDropLabel(rowData);
        
    }
    
    public void updateDropDisplayPanel(String comboBoxText, String textFieldText){
        if (comboBoxText.equals("ALL"))
            drop_SearchKeyword = textFieldText;
        else
            drop_SearchKeyword = comboBoxText + textFieldText;
        registeredCoursesModel = new DefaultTableModel();
        unregisteredCoursesModel = new DefaultTableModel();  
        teacherModel.createConnection();
        registeredCoursesModel = teacherModel.processRegisteredCourses( user.getUserId());
        unregisteredCoursesModel = teacherModel.processUnregisteredCourses(drop_SearchKeyword, user.getUserId());
        teacherModel.closeConnection();
        teacherView.updateDropTable(registeredCoursesModel, unregisteredCoursesModel);
        reset();
    }
    
    public void dropCourseRequest(){
        if(dropCourse != null){
            String result = "";
            teacherModel.createConnection();
            result = teacherModel.processDropCourse(user.getUserId(), dropCourse.getCourseCode(), dropCourse.getSession());
            teacherModel.closeConnection();
            updateOverviewDisplayPanel();
            updateAddDisplayPanel("ALL", add_SearchKeyword);
            updateDropDisplayPanel("ALL", drop_SearchKeyword);
            updateAddDropDisplayPanel("ALL", adddrop_SearchKeyword);
            teacherView.showMessage(result);
            reset();
        }
        else
            teacherView.showMessage("No selected course");
    }
    
    public void updateAddDropAddControlPanel(String row){
        row = row.substring(1, row.length() - 1);
        String[] rowData = row.split(", ");
        addCourse = new Course(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5], rowData[6], Integer.valueOf(rowData[7]), Integer.valueOf(rowData[8]));
        teacherView.updateAddDropAddLabel(rowData);
    }
    
    public void updateAddDropDropControlPanel(String row){
        row = row.substring(1, row.length() - 1);
        String[] rowData = row.split(", ");
        dropCourse = new Course(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5], rowData[6], Integer.valueOf(rowData[7]), Integer.valueOf(rowData[8]));
        teacherView.updateAddDropDropLabel(rowData);
    }
    
    public void updateAddDropDisplayPanel(String comboBoxText, String textFieldText){
        if (comboBoxText.equals("ALL"))
            adddrop_SearchKeyword = textFieldText;
        else
            adddrop_SearchKeyword = comboBoxText + textFieldText;
        registeredCoursesModel = new DefaultTableModel();
        unregisteredCoursesModel = new DefaultTableModel();  
        teacherModel.createConnection();
        registeredCoursesModel = teacherModel.processRegisteredCourses( user.getUserId());
        unregisteredCoursesModel = teacherModel.processUnregisteredCourses(adddrop_SearchKeyword, user.getUserId());
        teacherModel.closeConnection();
        teacherView.updateAddDropTable(registeredCoursesModel, unregisteredCoursesModel);
        reset();
    }
    
    public void addDropCourseRequest(){
        if(addCourse != null && dropCourse != null){
            String result = "";
            teacherModel.createConnection();
            result = teacherModel.processAddDropCourse(user.getUserId(), addCourse.getCourseCode(), addCourse.getSession(), dropCourse.getCourseCode(), dropCourse.getSession());
            teacherModel.closeConnection();           
            teacherView.showMessage(result);
            if(!result.contains("successfully")){
                if(teacherView.pendingConfirmationMessage()){
                    teacherModel.createConnection();
                    result = teacherModel.addToPendingList(user.getUserId(), addCourse.getCourseCode(), addCourse.getSession(), dropCourse.getCourseCode(), dropCourse.getSession());
                    teacherModel.closeConnection();
                    teacherView.showMessage(result);
                }
            }
            updateOverviewDisplayPanel();
            updateAddDisplayPanel("ALL", add_SearchKeyword);
            updateDropDisplayPanel("ALL", drop_SearchKeyword);
            updateAddDropDisplayPanel("ALL", adddrop_SearchKeyword);
            reset();
        }
        else
            teacherView.showMessage("No selected course");
    } 
    
    public void updatePendingDisplayPanel(){
        pendingCoursesModel = new DefaultTableModel();
        teacherModel.createConnection();
        pendingCoursesModel = teacherModel.processPendingCourses();
        teacherModel.closeConnection();
        teacherView.updatePendingTable(pendingCoursesModel);
     
    }
    
    public void pendingRequest(){
        teacherModel.createConnection();
        teacherView.showMessage(teacherModel.processPending());
        teacherModel.closeConnection();
        updatePendingDisplayPanel();
        updateOverviewDisplayPanel();
        
    }
    
    public void logoutRequest(){
        teacherView.setVisible(false);
        teacherView.resetUserInfo();
        teacherView.resetControlPanel();
        teacherView.resetDisplaySearcher();
        teacherView.resetTable();
        loginController.startView();
    }
    
    public void reset(){
        addCourse = null;
        dropCourse = null;
        teacherView.resetControlPanel();
    }
}