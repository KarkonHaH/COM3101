package DTO;

public class User {
    private String userId;
    private String userPassword;
    private String userGroup;
    private String gender;
    private String userName;
    
    public User(){
        
    }

    public User(String userId, String userPassword, String userGroup, String gender, String userName) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
        this.gender = gender;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}