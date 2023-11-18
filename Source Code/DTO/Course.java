package DTO;

public class Course {
    private String courseCode;
    private String session;
    private String courseTitle;
    private String teacher;
    private String weekday;
    private String startTime;
    private String endTime;
    private int capacity;
    private int applicants;
    
    public Course(){
        
    }
    
    public Course(String courseCode, String session, String courseTitle, String teacher, String weekday, String startTime, String endTime, int capacity, int applicants) {
        this.courseCode = courseCode;
        this.session = session;
        this.courseTitle = courseTitle;
        this.teacher = teacher;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.applicants = applicants;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public String getSession() {
        return session;
    }
    
    public void setSession(String session) {
        this.session = session;
    }
    
    public String getCourseTitle() {
        return courseTitle;
    }
    
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    
    public String getTeacher() {
        return teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public String getWeekday() {
        return weekday;
    }
    
    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getApplicants() {
        return applicants;
    }
    
    public void setApplicants(int applicants) {
        this.applicants = applicants;
    }
}