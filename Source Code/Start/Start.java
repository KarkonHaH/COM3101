package Start;

import Controller.*;
import Model.*;
import View.*;

public class Start {
    public static void main(String[] args) {
        // Check if database file exists
        DatabaseCreator DBcreator = new DatabaseCreator();

        //Init GUI object
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController();
        LoginModel loginModel = new LoginModel();
        TeacherView studentView = new TeacherView();
        TeacherController studentController = new TeacherController();
        TeacherModel studentModel = new TeacherModel();

        //LoginView setter
        loginView.setLoginController(loginController);
        //LoginController setter
        loginController.setLoginView(loginView);
        loginController.setLoginModel(loginModel);
        loginController.setStudentController(studentController);
        //LoginModel setter
        loginModel.setLoginController(loginController);
        
        //StudentView setter
        studentView.setTeacherController(studentController);
        //StudentController setter
        studentController.setLoginController(loginController);
        studentController.setTeacherView(studentView);
        studentController.setTeacherModel(studentModel);
        //StudentModel setter
        studentModel.setTeacherController(studentController);
        
        // Display the login form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loginView.setVisible(true); // Use the staffView instance that you created
            }
        });
    }
}
