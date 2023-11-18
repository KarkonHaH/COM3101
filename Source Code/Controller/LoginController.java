package Controller;

import DTO.User;
import View.LoginView;
import Controller.TeacherController;
import Model.LoginModel;

public class LoginController {
    private LoginView loginView;
    private LoginModel loginModel;
    
    private TeacherController studentController;
 
    
    private User user;
 
    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }
    
    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
    
    public void setStudentController(TeacherController studentController) {
        this.studentController = studentController;
    }
    
    public void startView(){
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }
    
    public void loginRequest(String id, String password) {
        user = null;
        loginModel.createConnection();
        user = loginModel.processLogin(id, password);
        if (user == null)
            loginView.showMessage("Invalid ID or Password, please try again.");
        else{
            String userGroup = user.getUserGroup();
            if (userGroup.equals("Teacher")){
                loginView.setVisible(false);
                loginView.reset();
                studentController.startView();
            }
            else if (userGroup.equals("Student")){
                loginView.showMessage("This is a student account, please try again.");
                loginView.reset();
            }
        }
        loginModel.closeConnection();
    }
}