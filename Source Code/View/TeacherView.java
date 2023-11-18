package View;

import Controller.TeacherController;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TeacherView extends javax.swing.JFrame {

    private TeacherController teacherController;

    public void setTeacherController(TeacherController teacherController) {
        this.teacherController = teacherController;
    }

    /**
     * Creates new form StudentView
     */
    public TeacherView() {
        setTitle("Course Registration System");
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void updateUserInfo(String userId, String gender, String name){
        lb_sidText.setText(userId);
        lb_genderText.setText(gender);
        lb_nameText.setText(name);
    }
    
    public void resetUserInfo(){
        lb_sidText.setText("[SID]");
        lb_genderText.setText("[Gender]");
        lb_nameText.setText("[Name]");
    }
    
    public void resetDisplaySearcher(){
        tf_addSearch.setText("");
        tf_dropSearch.setText("");
        tf_addDropSearch.setText("");
        cb_addSearch.setSelectedIndex(0);
        cb_dropSearch.setSelectedIndex(0);
        cb_addDropSearch.setSelectedIndex(0);
    }
    
    public void resetTable(){
        DefaultTableModel model = null;
        model = (DefaultTableModel) jTable_addUnregisteredCourses.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel) jTable_addRegisteredCourses.getModel();
        model.setRowCount(0);
        
        model = (DefaultTableModel) jTable_dropUnregisteredCourses.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel) jTable_dropRegisteredCourses.getModel();
        model.setRowCount(0);
        
        model = (DefaultTableModel) jTable_addDropUnregisteredCourses.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel) jTable_addDropRegisteredCourses.getModel();
        model.setRowCount(0);
    }

    public void resetControlPanel() {
        //Add
        lb_addCourseCodeText.setText("N/A");
        lb_addSessionText.setText("N/A");
        lb_addCourseTitleText.setText("N/A");
        lb_addTeacherText.setText("N/A");
        lb_addWeekdayText.setText("N/A");
        lb_addTimeText.setText("N/A");
        lb_addCapacityText.setText("N/A");
        lb_addApplicantsText.setText("N/A");
        //Drop
        lb_dropCourseCodeText.setText("N/A");
        lb_dropSessionText.setText("N/A");
        lb_dropCourseTitleText.setText("N/A");
        lb_dropTeacherText.setText("N/A");
        lb_dropWeekdayText.setText("N/A");
        lb_dropTimeText.setText("N/A");
        lb_dropCapacityText.setText("N/A");
        lb_dropApplicantsText.setText("N/A");
        //AddDrop -Add
        lb_addDropAddCourseCodeText.setText("N/A");
        lb_addDropAddSessionText.setText("N/A");
        lb_addDeopAddCourseTitleText.setText("N/A");
        lb_addDropAddTeacherText.setText("N/A");
        lb_addDropAddWeekdayText.setText("N/A");
        lb_addDropAddTimeText.setText("N/A");
        lb_addDropAddCapacityText.setText("N/A");
        lb_addDropAddApplicantsText.setText("N/A");
        //AddDrop -Drop
        lb_addDropDropCourseCodeText.setText("N/A");
        lb_addDropDropSessionText.setText("N/A");
        lb_addDropDropCourseTitleText.setText("N/A");
        lb_addDropDropTeacherText.setText("N/A");
        lb_addDropDropWeekdayText.setText("N/A");
        lb_addDropDropTimeText.setText("N/A");
        lb_addDropDropCapacityText.setText("N/A");
        lb_addDropDropApplicantsText.setText("N/A");

    }
    
    public void updateOverviewTable(DefaultTableModel overviewModel) {
        jTable_overview.setModel(overviewModel);      
        jTable_overview.getColumnModel().getColumn(0).setPreferredWidth(30); // UserID
        jTable_overview.getColumnModel().getColumn(1).setPreferredWidth(40); // Course Code
        jTable_overview.getColumnModel().getColumn(2).setPreferredWidth(30); // Session
        jTable_overview.getColumnModel().getColumn(3).setPreferredWidth(300); // Course Title
        jTable_overview.getColumnModel().getColumn(4).setPreferredWidth(100); // Teacher
        jTable_overview.getColumnModel().getColumn(5).setPreferredWidth(30); // Weekday  
        jTable_overview.getColumnModel().getColumn(6).setPreferredWidth(50); // Time
        jTable_overview.getColumnModel().getColumn(7).setPreferredWidth(20); // Capacity
        jTable_overview.getColumnModel().getColumn(8).setPreferredWidth(20); // Applicants
    }

    public void updateAddLabel(String[] rowData) {
        lb_addCourseCodeText.setText(rowData[0]);
        lb_addSessionText.setText(rowData[1]);
        lb_addCourseTitleText.setText(rowData[2]);
        lb_addTeacherText.setText(rowData[3]);
        lb_addWeekdayText.setText(rowData[4]);
        lb_addTimeText.setText(rowData[5] + " - " + rowData[6]);
        lb_addCapacityText.setText(rowData[7]);
        lb_addApplicantsText.setText(rowData[8]);
    }

    public void updateAddTable(DefaultTableModel registeredCoursesModel, DefaultTableModel unregisteredCoursesModel) {

        jTable_addRegisteredCourses.setModel(registeredCoursesModel);
        jTable_addRegisteredCourses.getColumnModel().getColumn(0).setPreferredWidth(40); // Course Code
        jTable_addRegisteredCourses.getColumnModel().getColumn(1).setPreferredWidth(30); // Session
        jTable_addRegisteredCourses.getColumnModel().getColumn(2).setPreferredWidth(300); // Course Title
        jTable_addRegisteredCourses.getColumnModel().getColumn(3).setPreferredWidth(100); // Teacher
        jTable_addRegisteredCourses.getColumnModel().getColumn(4).setPreferredWidth(30); // Weekday
        jTable_addRegisteredCourses.getColumnModel().getColumn(5).setPreferredWidth(30); // Start Time
        jTable_addRegisteredCourses.getColumnModel().getColumn(6).setPreferredWidth(30); // End Time
        jTable_addRegisteredCourses.getColumnModel().getColumn(7).setPreferredWidth(30); // Capacity
        jTable_addRegisteredCourses.getColumnModel().getColumn(8).setPreferredWidth(30); // Applicants

        jTable_addUnregisteredCourses.setModel(unregisteredCoursesModel);
        jTable_addUnregisteredCourses.getColumnModel().getColumn(0).setPreferredWidth(40); // Course Code
        jTable_addUnregisteredCourses.getColumnModel().getColumn(1).setPreferredWidth(30); // Session
        jTable_addUnregisteredCourses.getColumnModel().getColumn(2).setPreferredWidth(300); // Course Title
        jTable_addUnregisteredCourses.getColumnModel().getColumn(3).setPreferredWidth(100); // Teacher
        jTable_addUnregisteredCourses.getColumnModel().getColumn(4).setPreferredWidth(30); // Weekday
        jTable_addUnregisteredCourses.getColumnModel().getColumn(5).setPreferredWidth(30); // Start Time
        jTable_addUnregisteredCourses.getColumnModel().getColumn(6).setPreferredWidth(30); // End Time
        jTable_addUnregisteredCourses.getColumnModel().getColumn(7).setPreferredWidth(30); // Capacity
        jTable_addUnregisteredCourses.getColumnModel().getColumn(8).setPreferredWidth(30); // Applicants
    }

    public void updateDropLabel(String[] rowData) {
        lb_dropCourseCodeText.setText(rowData[0]);
        lb_dropSessionText.setText(rowData[1]);
        lb_dropCourseTitleText.setText(rowData[1]);
        lb_dropTeacherText.setText(rowData[3]);
        lb_dropWeekdayText.setText(rowData[4]);
        lb_dropTimeText.setText(rowData[5] + " - " + rowData[6]);
        lb_dropCapacityText.setText(rowData[7]);
        lb_dropApplicantsText.setText(rowData[8]);
    }

    public void updateDropTable(DefaultTableModel registeredCoursesModel, DefaultTableModel unregisteredCoursesModel) {

        jTable_dropRegisteredCourses.setModel(registeredCoursesModel);
        jTable_dropRegisteredCourses.getColumnModel().getColumn(0).setPreferredWidth(40); // Course Code
        jTable_dropRegisteredCourses.getColumnModel().getColumn(1).setPreferredWidth(30); // Session
        jTable_dropRegisteredCourses.getColumnModel().getColumn(2).setPreferredWidth(300); // Course Title
        jTable_dropRegisteredCourses.getColumnModel().getColumn(3).setPreferredWidth(100); // Teacher
        jTable_dropRegisteredCourses.getColumnModel().getColumn(4).setPreferredWidth(30); // Weekday
        jTable_dropRegisteredCourses.getColumnModel().getColumn(5).setPreferredWidth(30); // Start Time
        jTable_dropRegisteredCourses.getColumnModel().getColumn(6).setPreferredWidth(30); // End Time
        jTable_dropRegisteredCourses.getColumnModel().getColumn(7).setPreferredWidth(30); // Capacity
        jTable_dropRegisteredCourses.getColumnModel().getColumn(8).setPreferredWidth(30); // Applicants

        jTable_dropUnregisteredCourses.setModel(unregisteredCoursesModel);
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(0).setPreferredWidth(40); // Course Code
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(1).setPreferredWidth(30); // Session
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(2).setPreferredWidth(300); // Course Title
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(3).setPreferredWidth(100); // Teacher
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(4).setPreferredWidth(30); // Weekday
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(5).setPreferredWidth(30); // Start Time
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(6).setPreferredWidth(30); // End Time
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(7).setPreferredWidth(30); // Capacity
        jTable_dropUnregisteredCourses.getColumnModel().getColumn(8).setPreferredWidth(30); // Applicants
    }

    public void updateAddDropAddLabel(String[] rowData) {
        lb_addDropAddCourseCodeText.setText(rowData[0]);
        lb_addDropAddSessionText.setText(rowData[1]);
        lb_addDeopAddCourseTitleText.setText(rowData[2]);
        lb_addDropAddTeacherText.setText(rowData[3]);
        lb_addDropAddWeekdayText.setText(rowData[4]);
        lb_addDropAddTimeText.setText(rowData[5] + " - " + rowData[6]);
        lb_addDropAddCapacityText.setText(rowData[7]);
        lb_addDropAddApplicantsText.setText(rowData[8]);
    }

    public void updateAddDropDropLabel(String[] rowData) {
        lb_addDropDropCourseCodeText.setText(rowData[0]);
        lb_addDropDropSessionText.setText(rowData[1]);
        lb_addDropDropCourseTitleText.setText(rowData[2]);
        lb_addDropDropTeacherText.setText(rowData[3]);
        lb_addDropDropWeekdayText.setText(rowData[4]);
        lb_addDropDropTimeText.setText(rowData[5] + " - " + rowData[6]);
        lb_addDropDropCapacityText.setText(rowData[7]);
        lb_addDropDropApplicantsText.setText(rowData[8]);
    }

    public void updateAddDropTable(DefaultTableModel registeredCoursesModel, DefaultTableModel unregisteredCoursesModel) {

        jTable_addDropRegisteredCourses.setModel(registeredCoursesModel);
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(0).setPreferredWidth(40); // Course Code
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(1).setPreferredWidth(30); // Session
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(2).setPreferredWidth(300); // Course Title
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(3).setPreferredWidth(100); // Teacher
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(4).setPreferredWidth(30); // Weekday
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(5).setPreferredWidth(30); // Start Time
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(6).setPreferredWidth(30); // End Time
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(7).setPreferredWidth(30); // Capacity
        jTable_addDropRegisteredCourses.getColumnModel().getColumn(8).setPreferredWidth(30); // Applicants

        jTable_addDropUnregisteredCourses.setModel(unregisteredCoursesModel);
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(0).setPreferredWidth(40); // Course Code
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(1).setPreferredWidth(30); // Session
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(2).setPreferredWidth(300); // Course Title
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(3).setPreferredWidth(100); // Teacher
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(4).setPreferredWidth(30); // Weekday
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(5).setPreferredWidth(30); // Start Time
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(6).setPreferredWidth(30); // End Time
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(7).setPreferredWidth(30); // Capacity
        jTable_addDropUnregisteredCourses.getColumnModel().getColumn(8).setPreferredWidth(30); // Applicants
    }
    
    public void updatePendingTable(DefaultTableModel pendingCoursesModel) {
        jTable_pendingCourses.setModel(pendingCoursesModel);      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_backgound = new javax.swing.JPanel();
        jPanel_bar = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        lb_sidTitle = new javax.swing.JLabel();
        lb_sidText = new javax.swing.JLabel();
        lb_genderTitle = new javax.swing.JLabel();
        lb_genderText = new javax.swing.JLabel();
        lb_nameTitle = new javax.swing.JLabel();
        lb_nameText = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        lb_sidInputTitle = new javax.swing.JLabel();
        tf_sidInput = new javax.swing.JTextField();
        btn_enter = new javax.swing.JButton();
        jTabbedPane_teacher = new javax.swing.JTabbedPane();
        jPanel_overview = new javax.swing.JPanel();
        jPanel_overviewDisplay = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_overview = new javax.swing.JTable();
        lb_overview = new javax.swing.JLabel();
        jPanel_add = new javax.swing.JPanel();
        jPanel_addControl = new javax.swing.JPanel();
        lb_addCourseCodeTitle = new javax.swing.JLabel();
        lb_addSection = new javax.swing.JLabel();
        lb_addCourseCodeText = new javax.swing.JLabel();
        lb_addCourseTitleText = new javax.swing.JLabel();
        lb_addCourseTitleTitle = new javax.swing.JLabel();
        lb_addTeacherTitle = new javax.swing.JLabel();
        lb_addTeacherText = new javax.swing.JLabel();
        lb_addWeekdayTitle = new javax.swing.JLabel();
        lb_addWeekdayText = new javax.swing.JLabel();
        lb_addTimeText = new javax.swing.JLabel();
        lb_addTimeTitle = new javax.swing.JLabel();
        lb_addCapacityTitle = new javax.swing.JLabel();
        lb_addCapacityText = new javax.swing.JLabel();
        lb_addApplicantsText = new javax.swing.JLabel();
        lb_addApplicantsTitle = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        lb_addSessionTitle = new javax.swing.JLabel();
        lb_addSessionText = new javax.swing.JLabel();
        jPanel_addDisplay = new javax.swing.JPanel();
        lb_addUnregisteredCourses = new javax.swing.JLabel();
        lb_addSearcher = new javax.swing.JLabel();
        cb_addSearch = new javax.swing.JComboBox<>();
        tf_addSearch = new javax.swing.JTextField();
        btn_addSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_addUnregisteredCourses = new javax.swing.JTable();
        lb_addRegisteredCourses = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_addRegisteredCourses = new javax.swing.JTable();
        jPanel_drop = new javax.swing.JPanel();
        jPanel_dropControl = new javax.swing.JPanel();
        lb_dropSection = new javax.swing.JLabel();
        lb_dropCourseCodeTitle = new javax.swing.JLabel();
        lb_dropCourseCodeText = new javax.swing.JLabel();
        lb_dropCourseTitleTitle = new javax.swing.JLabel();
        lb_dropCourseTitleText = new javax.swing.JLabel();
        lb_dropTeacherTitle = new javax.swing.JLabel();
        lb_dropTeacherText = new javax.swing.JLabel();
        lb_dropWeekdayTitle = new javax.swing.JLabel();
        lb_dropWeekdayText = new javax.swing.JLabel();
        lb_dropCapacityTitle = new javax.swing.JLabel();
        lb_dropCapacityText = new javax.swing.JLabel();
        lb_dropTimeTitle = new javax.swing.JLabel();
        lb_dropTimeText = new javax.swing.JLabel();
        lb_dropApplicantsTitle = new javax.swing.JLabel();
        lb_dropApplicantsText = new javax.swing.JLabel();
        btn_drop = new javax.swing.JButton();
        lb_dropSessionTitle = new javax.swing.JLabel();
        lb_dropSessionText = new javax.swing.JLabel();
        jPanel_dropDisplay = new javax.swing.JPanel();
        lb_dropRegisteredCourses = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_dropRegisteredCourses = new javax.swing.JTable();
        lb_dropUnregisteredCourses = new javax.swing.JLabel();
        lb_dropSearcher = new javax.swing.JLabel();
        cb_dropSearch = new javax.swing.JComboBox<>();
        tf_dropSearch = new javax.swing.JTextField();
        btn_dropSearch = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_dropUnregisteredCourses = new javax.swing.JTable();
        jPanel_addDrop = new javax.swing.JPanel();
        jPanel_addDropControl = new javax.swing.JPanel();
        lb_addDropAddSection = new javax.swing.JLabel();
        lb_addDropAddCourseCodeTitle = new javax.swing.JLabel();
        lb_addDropAddSessionTitle = new javax.swing.JLabel();
        lb_addDropAddSessionText = new javax.swing.JLabel();
        lb_addDropAddCourseCodeText = new javax.swing.JLabel();
        lb_addDropAddCourseTitleTitle = new javax.swing.JLabel();
        lb_addDeopAddCourseTitleText = new javax.swing.JLabel();
        lb_addDropAddTeacherTitle = new javax.swing.JLabel();
        lb_addDropAddTeacherText = new javax.swing.JLabel();
        lb_addDropAddWeekdayTitle = new javax.swing.JLabel();
        lb_addDropAddWeekdayText = new javax.swing.JLabel();
        lb_addDropAddCapacityTitle = new javax.swing.JLabel();
        lb_addDropAddCapacityText = new javax.swing.JLabel();
        lb_addDropAddTimeTitle = new javax.swing.JLabel();
        lb_addDropAddTimeText = new javax.swing.JLabel();
        lb_addDropAddApplicantsTitle = new javax.swing.JLabel();
        lb_addDropAddApplicantsText = new javax.swing.JLabel();
        lb_addDropDropSection = new javax.swing.JLabel();
        lb_addDropDropCourseCodeTitle = new javax.swing.JLabel();
        lb_addDropDropSessionTitle = new javax.swing.JLabel();
        lb_addDropDropSessionText = new javax.swing.JLabel();
        lb_addDropDropCourseCodeText = new javax.swing.JLabel();
        lb_addDropDropCourseTitleTitle = new javax.swing.JLabel();
        lb_addDropDropCourseTitleText = new javax.swing.JLabel();
        lb_addDropDropTeacherTitle = new javax.swing.JLabel();
        lb_addDropDropTeacherText = new javax.swing.JLabel();
        lb_addDropDropWeekdayTitle = new javax.swing.JLabel();
        lb_addDropDropWeekdayText = new javax.swing.JLabel();
        lb_addDropDropCapacityTitle = new javax.swing.JLabel();
        lb_addDropDropCapacityText = new javax.swing.JLabel();
        lb_addDropDropApplicantsText = new javax.swing.JLabel();
        lb_addDropDropApplicantsTitle = new javax.swing.JLabel();
        lb_addDropDropTimeText = new javax.swing.JLabel();
        lb_addDropDropTimeTitle = new javax.swing.JLabel();
        btn_addDrop = new javax.swing.JButton();
        jPanel_addDropDisplay = new javax.swing.JPanel();
        lb_addDropRegisteredCourses = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_addDropRegisteredCourses = new javax.swing.JTable();
        lb_addDropUnregisteredCourses = new javax.swing.JLabel();
        lb_addDropSearcher = new javax.swing.JLabel();
        cb_addDropSearch = new javax.swing.JComboBox<>();
        tf_addDropSearch = new javax.swing.JTextField();
        btn_addDropSearch = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_addDropUnregisteredCourses = new javax.swing.JTable();
        jPanel_pending = new javax.swing.JPanel();
        jPanel_pendingControl = new javax.swing.JPanel();
        lb_pendingSection = new javax.swing.JLabel();
        btn_pending = new javax.swing.JButton();
        jPanel_pendingDisplay = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_pendingCourses = new javax.swing.JTable();
        lb_PendingCourses = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));

        jPanel_backgound.setBackground(new java.awt.Color(0, 102, 0));

        jPanel_bar.setBackground(new java.awt.Color(255, 255, 255));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png"))); // NOI18N

        lb_sidTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_sidTitle.setForeground(new java.awt.Color(0, 102, 0));
        lb_sidTitle.setText("SID: ");

        lb_sidText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_sidText.setForeground(new java.awt.Color(0, 102, 0));
        lb_sidText.setText("[SID]");

        lb_genderTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_genderTitle.setForeground(new java.awt.Color(0, 102, 0));
        lb_genderTitle.setText("Gender: ");

        lb_genderText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_genderText.setForeground(new java.awt.Color(0, 102, 0));
        lb_genderText.setText("[Gender]");

        lb_nameTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_nameTitle.setForeground(new java.awt.Color(0, 102, 0));
        lb_nameTitle.setText("Name: ");

        lb_nameText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_nameText.setForeground(new java.awt.Color(0, 102, 0));
        lb_nameText.setText("[Name]");

        btn_logout.setBackground(new java.awt.Color(0, 102, 0));
        btn_logout.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        lb_sidInputTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_sidInputTitle.setForeground(new java.awt.Color(0, 102, 0));
        lb_sidInputTitle.setText("Enter SID:");

        tf_sidInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_sidInput.setMinimumSize(new java.awt.Dimension(73, 23));
        tf_sidInput.setPreferredSize(new java.awt.Dimension(73, 23));

        btn_enter.setBackground(new java.awt.Color(0, 102, 0));
        btn_enter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_enter.setForeground(new java.awt.Color(255, 255, 255));
        btn_enter.setText("Enter");
        btn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_barLayout = new javax.swing.GroupLayout(jPanel_bar);
        jPanel_bar.setLayout(jPanel_barLayout);
        jPanel_barLayout.setHorizontalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_barLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(logo)
                .addGap(100, 100, 100)
                .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_barLayout.createSequentialGroup()
                        .addComponent(lb_sidTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_sidText)
                        .addGap(50, 50, 50)
                        .addComponent(lb_genderTitle)
                        .addGap(0, 0, 0)
                        .addComponent(lb_genderText)
                        .addGap(50, 50, 50)
                        .addComponent(lb_nameTitle)
                        .addGap(0, 0, 0)
                        .addComponent(lb_nameText))
                    .addGroup(jPanel_barLayout.createSequentialGroup()
                        .addComponent(lb_sidInputTitle)
                        .addGap(5, 5, 5)
                        .addComponent(tf_sidInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_enter)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel_barLayout.setVerticalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_sidInputTitle)
                    .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_sidInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_enter)))
                .addGap(10, 10, 10)
                .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_sidTitle)
                    .addComponent(lb_sidText)
                    .addComponent(lb_genderTitle)
                    .addComponent(lb_genderText)
                    .addComponent(lb_nameTitle)
                    .addComponent(lb_nameText))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane_teacher.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane_teacher.setFocusable(false);
        jTabbedPane_teacher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabbedPane_teacher.setMinimumSize(new java.awt.Dimension(100, 191));

        jPanel_overviewDisplay.setBackground(new java.awt.Color(255, 255, 204));

        jTable_overview.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_overview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Code", "Session", "Title", "Teacher", "Weekday", "Time", "Capacity", "Applicants"
            }
        ));
        jTable_overview.setEnabled(false);
        jTable_overview.setRowHeight(24);
        jTable_overview.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_overview.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_overview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_overviewMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable_overview);

        lb_overview.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_overview.setText("Registration Overview");

        javax.swing.GroupLayout jPanel_overviewDisplayLayout = new javax.swing.GroupLayout(jPanel_overviewDisplay);
        jPanel_overviewDisplay.setLayout(jPanel_overviewDisplayLayout);
        jPanel_overviewDisplayLayout.setHorizontalGroup(
            jPanel_overviewDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_overviewDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_overviewDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_overview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_overviewDisplayLayout.setVerticalGroup(
            jPanel_overviewDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_overviewDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_overview)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_overviewLayout = new javax.swing.GroupLayout(jPanel_overview);
        jPanel_overview.setLayout(jPanel_overviewLayout);
        jPanel_overviewLayout.setHorizontalGroup(
            jPanel_overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_overviewDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_overviewLayout.setVerticalGroup(
            jPanel_overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_overviewDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane_teacher.addTab("Overview", jPanel_overview);

        jPanel_addControl.setBackground(new java.awt.Color(255, 255, 255));

        lb_addCourseCodeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addCourseCodeTitle.setText("Course Code");

        lb_addSection.setBackground(new java.awt.Color(0, 102, 0));
        lb_addSection.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addSection.setForeground(new java.awt.Color(255, 255, 255));
        lb_addSection.setText(" Add Course Section");
        lb_addSection.setOpaque(true);

        lb_addCourseCodeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addCourseCodeText.setText("N/A");

        lb_addCourseTitleText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addCourseTitleText.setText("N/A");

        lb_addCourseTitleTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addCourseTitleTitle.setText("Course Title");

        lb_addTeacherTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addTeacherTitle.setText("Teacher");

        lb_addTeacherText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addTeacherText.setText("N/A");

        lb_addWeekdayTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addWeekdayTitle.setText("Weekday");

        lb_addWeekdayText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addWeekdayText.setText("N/A");

        lb_addTimeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addTimeText.setText("N/A");

        lb_addTimeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addTimeTitle.setText("Time");

        lb_addCapacityTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addCapacityTitle.setText("Capacity");

        lb_addCapacityText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addCapacityText.setText("N/A");

        lb_addApplicantsText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addApplicantsText.setText("N/A");

        lb_addApplicantsTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addApplicantsTitle.setText("Applicants");

        btn_add.setBackground(new java.awt.Color(0, 102, 0));
        btn_add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        lb_addSessionTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addSessionTitle.setText("Session");

        lb_addSessionText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addSessionText.setText("N/A");

        javax.swing.GroupLayout jPanel_addControlLayout = new javax.swing.GroupLayout(jPanel_addControl);
        jPanel_addControl.setLayout(jPanel_addControlLayout);
        jPanel_addControlLayout.setHorizontalGroup(
            jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_addControlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_addSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_addControlLayout.createSequentialGroup()
                        .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_addCourseTitleText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_addCourseTitleTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_addTeacherTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_addTeacherText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_addControlLayout.createSequentialGroup()
                                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lb_addCapacityText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addWeekdayTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(lb_addWeekdayText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addCapacityTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_addTimeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addApplicantsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(lb_addApplicantsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_addControlLayout.createSequentialGroup()
                        .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_addCourseCodeText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_addCourseCodeTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_addSessionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_addSessionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        jPanel_addControlLayout.setVerticalGroup(
            jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addControlLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_addSection)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addCourseCodeTitle)
                    .addComponent(lb_addSessionTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addCourseCodeText)
                    .addComponent(lb_addSessionText))
                .addGap(5, 5, 5)
                .addComponent(lb_addCourseTitleTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_addCourseTitleText)
                .addGap(5, 5, 5)
                .addComponent(lb_addTeacherTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_addTeacherText)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addWeekdayTitle)
                    .addComponent(lb_addTimeTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addWeekdayText)
                    .addComponent(lb_addTimeText))
                .addGap(5, 5, 5)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addCapacityTitle)
                    .addComponent(lb_addApplicantsTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addCapacityText)
                    .addComponent(lb_addApplicantsText))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_addDisplay.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_addDisplay.setToolTipText("");

        lb_addUnregisteredCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addUnregisteredCourses.setText("Unregistered Courses");

        lb_addSearcher.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lb_addSearcher.setText("Course Code Searcher:");

        cb_addSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cb_addSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ACY", "AIN", "AMS", "ASI", "BJC", "BUS", "CHI", "CMT", "COM", "ECO", "FIN", "FLA", "GEN" }));

        tf_addSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_addSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        tf_addSearch.setPreferredSize(new java.awt.Dimension(73, 23));

        btn_addSearch.setBackground(new java.awt.Color(0, 102, 0));
        btn_addSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_addSearch.setForeground(new java.awt.Color(255, 255, 255));
        btn_addSearch.setText("Search");
        btn_addSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addSearchActionPerformed(evt);
            }
        });

        jTable_addUnregisteredCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_addUnregisteredCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_addUnregisteredCourses.setRowHeight(24);
        jTable_addUnregisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addUnregisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addUnregisteredCourses.setShowGrid(true);
        jTable_addUnregisteredCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_addUnregisteredCoursesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_addUnregisteredCourses);

        lb_addRegisteredCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addRegisteredCourses.setText("Registered Courses");

        jTable_addRegisteredCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_addRegisteredCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_addRegisteredCourses.setEnabled(false);
        jTable_addRegisteredCourses.setRowHeight(24);
        jTable_addRegisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addRegisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable_addRegisteredCourses);

        javax.swing.GroupLayout jPanel_addDisplayLayout = new javax.swing.GroupLayout(jPanel_addDisplay);
        jPanel_addDisplay.setLayout(jPanel_addDisplayLayout);
        jPanel_addDisplayLayout.setHorizontalGroup(
            jPanel_addDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDisplayLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel_addDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_addDisplayLayout.createSequentialGroup()
                        .addComponent(cb_addSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tf_addSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_addSearch)
                        .addContainerGap())
                    .addGroup(jPanel_addDisplayLayout.createSequentialGroup()
                        .addGroup(jPanel_addDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_addRegisteredCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                            .addComponent(lb_addUnregisteredCourses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_addSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(6, 6, 6))))
        );
        jPanel_addDisplayLayout.setVerticalGroup(
            jPanel_addDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDisplayLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_addUnregisteredCourses)
                .addGap(10, 10, 10)
                .addComponent(lb_addSearcher)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_addSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_addSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addSearch))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lb_addRegisteredCourses)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel_addLayout = new javax.swing.GroupLayout(jPanel_add);
        jPanel_add.setLayout(jPanel_addLayout);
        jPanel_addLayout.setHorizontalGroup(
            jPanel_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addLayout.createSequentialGroup()
                .addComponent(jPanel_addControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_addDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel_addLayout.setVerticalGroup(
            jPanel_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_addControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_addDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane_teacher.addTab("Add", jPanel_add);

        jPanel_dropControl.setBackground(new java.awt.Color(255, 255, 255));

        lb_dropSection.setBackground(new java.awt.Color(0, 102, 0));
        lb_dropSection.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropSection.setForeground(new java.awt.Color(255, 255, 255));
        lb_dropSection.setText(" Drop Course Section");
        lb_dropSection.setOpaque(true);

        lb_dropCourseCodeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropCourseCodeTitle.setText("Course Code");

        lb_dropCourseCodeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropCourseCodeText.setText("N/A");

        lb_dropCourseTitleTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropCourseTitleTitle.setText("Course Title");

        lb_dropCourseTitleText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropCourseTitleText.setText("N/A");

        lb_dropTeacherTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropTeacherTitle.setText("Teacher");

        lb_dropTeacherText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropTeacherText.setText("N/A");

        lb_dropWeekdayTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropWeekdayTitle.setText("Weekday");

        lb_dropWeekdayText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropWeekdayText.setText("N/A");

        lb_dropCapacityTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropCapacityTitle.setText("Capacity");

        lb_dropCapacityText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropCapacityText.setText("N/A");

        lb_dropTimeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropTimeTitle.setText("Time");

        lb_dropTimeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropTimeText.setText("N/A");

        lb_dropApplicantsTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropApplicantsTitle.setText("Applicants");

        lb_dropApplicantsText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropApplicantsText.setText("N/A");

        btn_drop.setBackground(new java.awt.Color(0, 102, 0));
        btn_drop.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_drop.setForeground(new java.awt.Color(255, 255, 255));
        btn_drop.setText("Drop");
        btn_drop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dropActionPerformed(evt);
            }
        });

        lb_dropSessionTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropSessionTitle.setText("Session");

        lb_dropSessionText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_dropSessionText.setText("N/A");

        javax.swing.GroupLayout jPanel_dropControlLayout = new javax.swing.GroupLayout(jPanel_dropControl);
        jPanel_dropControl.setLayout(jPanel_dropControlLayout);
        jPanel_dropControlLayout.setHorizontalGroup(
            jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_drop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_dropControlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_dropCourseTitleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_dropCourseTitleTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_dropTeacherTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_dropTeacherText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_dropControlLayout.createSequentialGroup()
                        .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_dropCapacityText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_dropWeekdayTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lb_dropWeekdayText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_dropCapacityTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_dropTimeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_dropTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_dropApplicantsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lb_dropApplicantsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lb_dropCourseCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_dropControlLayout.createSequentialGroup()
                        .addComponent(lb_dropCourseCodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_dropSessionText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_dropSessionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lb_dropSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel_dropControlLayout.setVerticalGroup(
            jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dropControlLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_dropSection)
                .addGap(5, 5, 5)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dropCourseCodeTitle)
                    .addComponent(lb_dropSessionTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dropCourseCodeText)
                    .addComponent(lb_dropSessionText))
                .addGap(5, 5, 5)
                .addComponent(lb_dropCourseTitleTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_dropCourseTitleText)
                .addGap(5, 5, 5)
                .addComponent(lb_dropTeacherTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_dropTeacherText)
                .addGap(5, 5, 5)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dropWeekdayTitle)
                    .addComponent(lb_dropTimeTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dropWeekdayText)
                    .addComponent(lb_dropTimeText))
                .addGap(5, 5, 5)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dropCapacityTitle)
                    .addComponent(lb_dropApplicantsTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_dropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dropCapacityText)
                    .addComponent(lb_dropApplicantsText))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_drop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_dropDisplay.setBackground(new java.awt.Color(255, 255, 204));

        lb_dropRegisteredCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropRegisteredCourses.setText("Registered Courses");

        jTable_dropRegisteredCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_dropRegisteredCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dropRegisteredCourses.setRowHeight(24);
        jTable_dropRegisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_dropRegisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_dropRegisteredCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_dropRegisteredCoursesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_dropRegisteredCourses);

        lb_dropUnregisteredCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_dropUnregisteredCourses.setText("Unregistered Courses");

        lb_dropSearcher.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lb_dropSearcher.setText("Course Code Searcher:");

        cb_dropSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cb_dropSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ACY", "AIN", "AMS", "ASI", "BJC", "BUS", "CHI", "CMT", "COM", "ECO", "FIN", "FLA", "GEN" }));

        tf_dropSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_dropSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        tf_dropSearch.setPreferredSize(new java.awt.Dimension(73, 23));

        btn_dropSearch.setBackground(new java.awt.Color(0, 102, 0));
        btn_dropSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_dropSearch.setForeground(new java.awt.Color(255, 255, 255));
        btn_dropSearch.setText("Search");
        btn_dropSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dropSearchActionPerformed(evt);
            }
        });

        jTable_dropUnregisteredCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_dropUnregisteredCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dropUnregisteredCourses.setEnabled(false);
        jTable_dropUnregisteredCourses.setRowHeight(24);
        jTable_dropUnregisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_dropUnregisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jTable_dropUnregisteredCourses);

        javax.swing.GroupLayout jPanel_dropDisplayLayout = new javax.swing.GroupLayout(jPanel_dropDisplay);
        jPanel_dropDisplay.setLayout(jPanel_dropDisplayLayout);
        jPanel_dropDisplayLayout.setHorizontalGroup(
            jPanel_dropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dropDisplayLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel_dropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_dropDisplayLayout.createSequentialGroup()
                        .addComponent(cb_dropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tf_dropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_dropSearch)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_dropDisplayLayout.createSequentialGroup()
                        .addGroup(jPanel_dropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_dropRegisteredCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                            .addComponent(lb_dropSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(lb_dropUnregisteredCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))))
        );
        jPanel_dropDisplayLayout.setVerticalGroup(
            jPanel_dropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dropDisplayLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_dropUnregisteredCourses)
                .addGap(10, 10, 10)
                .addComponent(lb_dropSearcher)
                .addGap(5, 5, 5)
                .addGroup(jPanel_dropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_dropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dropSearch))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lb_dropRegisteredCourses)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_dropLayout = new javax.swing.GroupLayout(jPanel_drop);
        jPanel_drop.setLayout(jPanel_dropLayout);
        jPanel_dropLayout.setHorizontalGroup(
            jPanel_dropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dropLayout.createSequentialGroup()
                .addComponent(jPanel_dropControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_dropDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel_dropLayout.setVerticalGroup(
            jPanel_dropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_dropControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_dropDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane_teacher.addTab("Drop", jPanel_drop);

        jPanel_addDropControl.setBackground(new java.awt.Color(255, 255, 255));

        lb_addDropAddSection.setBackground(new java.awt.Color(0, 102, 0));
        lb_addDropAddSection.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddSection.setForeground(new java.awt.Color(255, 255, 255));
        lb_addDropAddSection.setText(" Add Course Section");
        lb_addDropAddSection.setOpaque(true);

        lb_addDropAddCourseCodeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddCourseCodeTitle.setText("Course Code");

        lb_addDropAddSessionTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddSessionTitle.setText("Session");

        lb_addDropAddSessionText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddSessionText.setText("N/A");

        lb_addDropAddCourseCodeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddCourseCodeText.setText("N/A");

        lb_addDropAddCourseTitleTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddCourseTitleTitle.setText("Course Title");

        lb_addDeopAddCourseTitleText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDeopAddCourseTitleText.setText("N/A");

        lb_addDropAddTeacherTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddTeacherTitle.setText("Teacher");

        lb_addDropAddTeacherText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddTeacherText.setText("N/A");

        lb_addDropAddWeekdayTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddWeekdayTitle.setText("Weekday");

        lb_addDropAddWeekdayText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddWeekdayText.setText("N/A");

        lb_addDropAddCapacityTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddCapacityTitle.setText("Capacity");

        lb_addDropAddCapacityText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddCapacityText.setText("N/A");

        lb_addDropAddTimeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddTimeTitle.setText("Time");

        lb_addDropAddTimeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddTimeText.setText("N/A");

        lb_addDropAddApplicantsTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropAddApplicantsTitle.setText("Applicants");

        lb_addDropAddApplicantsText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropAddApplicantsText.setText("N/A");

        lb_addDropDropSection.setBackground(new java.awt.Color(0, 102, 0));
        lb_addDropDropSection.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropSection.setForeground(new java.awt.Color(255, 255, 255));
        lb_addDropDropSection.setText(" Drop Course Section");
        lb_addDropDropSection.setOpaque(true);

        lb_addDropDropCourseCodeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropCourseCodeTitle.setText("Course Code");

        lb_addDropDropSessionTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropSessionTitle.setText("Session");

        lb_addDropDropSessionText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropSessionText.setText("N/A");

        lb_addDropDropCourseCodeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropCourseCodeText.setText("N/A");

        lb_addDropDropCourseTitleTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropCourseTitleTitle.setText("Course Title");

        lb_addDropDropCourseTitleText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropCourseTitleText.setText("N/A");

        lb_addDropDropTeacherTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropTeacherTitle.setText("Teacher");

        lb_addDropDropTeacherText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropTeacherText.setText("N/A");

        lb_addDropDropWeekdayTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropWeekdayTitle.setText("Weekday");

        lb_addDropDropWeekdayText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropWeekdayText.setText("N/A");

        lb_addDropDropCapacityTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropCapacityTitle.setText("Capacity");

        lb_addDropDropCapacityText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropCapacityText.setText("N/A");

        lb_addDropDropApplicantsText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropApplicantsText.setText("N/A");

        lb_addDropDropApplicantsTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropApplicantsTitle.setText("Applicants");

        lb_addDropDropTimeText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lb_addDropDropTimeText.setText("N/A");

        lb_addDropDropTimeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropDropTimeTitle.setText("Time");

        btn_addDrop.setBackground(new java.awt.Color(0, 102, 0));
        btn_addDrop.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_addDrop.setForeground(new java.awt.Color(255, 255, 255));
        btn_addDrop.setText("Add/Drop");
        btn_addDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addDropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_addDropControlLayout = new javax.swing.GroupLayout(jPanel_addDropControl);
        jPanel_addDropControl.setLayout(jPanel_addDropControlLayout);
        jPanel_addDropControlLayout.setHorizontalGroup(
            jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDropControlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_addDropControlLayout.createSequentialGroup()
                            .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lb_addDropAddCourseCodeText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropAddCourseCodeTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_addDropAddSessionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_addDropAddSessionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel_addDropControlLayout.createSequentialGroup()
                            .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lb_addDeopAddCourseTitleText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addDropAddCourseTitleTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addDropAddTeacherTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_addDropAddTeacherText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel_addDropControlLayout.createSequentialGroup()
                                        .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lb_addDropAddCapacityText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_addDropAddWeekdayTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_addDropAddWeekdayText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_addDropAddCapacityTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lb_addDropAddTimeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_addDropAddTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_addDropAddApplicantsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_addDropAddApplicantsText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(lb_addDropAddSection, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_addDropDropCourseTitleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_addDropDropCourseTitleTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_addDropDropTeacherTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_addDropDropTeacherText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_addDropControlLayout.createSequentialGroup()
                            .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lb_addDropDropCapacityText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropDropWeekdayTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropDropWeekdayText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropDropCapacityTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lb_addDropDropTimeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropDropTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropDropApplicantsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_addDropDropApplicantsText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lb_addDropDropCourseCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel_addDropControlLayout.createSequentialGroup()
                            .addComponent(lb_addDropDropCourseCodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_addDropDropSessionText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_addDropDropSessionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lb_addDropDropSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addComponent(btn_addDrop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_addDropControlLayout.setVerticalGroup(
            jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDropControlLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_addDropAddSection)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropAddCourseCodeTitle)
                    .addComponent(lb_addDropAddSessionTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropAddCourseCodeText)
                    .addComponent(lb_addDropAddSessionText))
                .addGap(5, 5, 5)
                .addComponent(lb_addDropAddCourseTitleTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_addDeopAddCourseTitleText)
                .addGap(5, 5, 5)
                .addComponent(lb_addDropAddTeacherTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_addDropAddTeacherText)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropAddWeekdayTitle)
                    .addComponent(lb_addDropAddTimeTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropAddWeekdayText)
                    .addComponent(lb_addDropAddTimeText))
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropAddCapacityTitle)
                    .addComponent(lb_addDropAddApplicantsTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropAddCapacityText)
                    .addComponent(lb_addDropAddApplicantsText))
                .addGap(10, 10, 10)
                .addComponent(lb_addDropDropSection)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropDropCourseCodeTitle)
                    .addComponent(lb_addDropDropSessionTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropDropCourseCodeText)
                    .addComponent(lb_addDropDropSessionText))
                .addGap(5, 5, 5)
                .addComponent(lb_addDropDropCourseTitleTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_addDropDropCourseTitleText)
                .addGap(5, 5, 5)
                .addComponent(lb_addDropDropTeacherTitle)
                .addGap(0, 0, 0)
                .addComponent(lb_addDropDropTeacherText)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropDropWeekdayTitle)
                    .addComponent(lb_addDropDropTimeTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropDropWeekdayText)
                    .addComponent(lb_addDropDropTimeText))
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropDropCapacityTitle)
                    .addComponent(lb_addDropDropApplicantsTitle))
                .addGap(0, 0, 0)
                .addGroup(jPanel_addDropControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_addDropDropCapacityText)
                    .addComponent(lb_addDropDropApplicantsText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_addDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_addDropDisplay.setBackground(new java.awt.Color(255, 255, 204));

        lb_addDropRegisteredCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropRegisteredCourses.setText("Registered Courses");

        jTable_addDropRegisteredCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_addDropRegisteredCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_addDropRegisteredCourses.setRowHeight(24);
        jTable_addDropRegisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addDropRegisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addDropRegisteredCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_addDropRegisteredCoursesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_addDropRegisteredCourses);

        lb_addDropUnregisteredCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_addDropUnregisteredCourses.setText("Unregistered Courses");

        lb_addDropSearcher.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lb_addDropSearcher.setText("Course Code Searcher:");

        cb_addDropSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cb_addDropSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ACY", "AIN", "AMS", "ASI", "BJC", "BUS", "CHI", "CMT", "COM", "ECO", "FIN", "FLA", "GEN" }));

        tf_addDropSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_addDropSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        tf_addDropSearch.setPreferredSize(new java.awt.Dimension(73, 23));

        btn_addDropSearch.setBackground(new java.awt.Color(0, 102, 0));
        btn_addDropSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_addDropSearch.setForeground(new java.awt.Color(255, 255, 255));
        btn_addDropSearch.setText("Search");
        btn_addDropSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addDropSearchActionPerformed(evt);
            }
        });

        jTable_addDropUnregisteredCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_addDropUnregisteredCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Session", "Title", "Teacher", "Weekday", "Start Time", "End Time", "Capacity", "Applicants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_addDropUnregisteredCourses.setRowHeight(24);
        jTable_addDropUnregisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addDropUnregisteredCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_addDropUnregisteredCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_addDropUnregisteredCoursesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable_addDropUnregisteredCourses);

        javax.swing.GroupLayout jPanel_addDropDisplayLayout = new javax.swing.GroupLayout(jPanel_addDropDisplay);
        jPanel_addDropDisplay.setLayout(jPanel_addDropDisplayLayout);
        jPanel_addDropDisplayLayout.setHorizontalGroup(
            jPanel_addDropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDropDisplayLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel_addDropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_addDropDisplayLayout.createSequentialGroup()
                        .addComponent(cb_addDropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tf_addDropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_addDropSearch)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_addDropDisplayLayout.createSequentialGroup()
                        .addGroup(jPanel_addDropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_addDropRegisteredCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                            .addComponent(lb_addDropUnregisteredCourses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_addDropSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6))
                        .addGap(6, 6, 6))))
        );
        jPanel_addDropDisplayLayout.setVerticalGroup(
            jPanel_addDropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDropDisplayLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_addDropUnregisteredCourses)
                .addGap(10, 10, 10)
                .addComponent(lb_addDropSearcher)
                .addGap(5, 5, 5)
                .addGroup(jPanel_addDropDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_addDropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_addDropSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addDropSearch))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lb_addDropRegisteredCourses)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_addDropLayout = new javax.swing.GroupLayout(jPanel_addDrop);
        jPanel_addDrop.setLayout(jPanel_addDropLayout);
        jPanel_addDropLayout.setHorizontalGroup(
            jPanel_addDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_addDropLayout.createSequentialGroup()
                .addComponent(jPanel_addDropControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_addDropDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel_addDropLayout.setVerticalGroup(
            jPanel_addDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_addDropControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_addDropDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane_teacher.addTab("Add/Drop", jPanel_addDrop);

        jPanel_pendingControl.setBackground(new java.awt.Color(255, 255, 255));

        lb_pendingSection.setBackground(new java.awt.Color(0, 102, 0));
        lb_pendingSection.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_pendingSection.setForeground(new java.awt.Color(255, 255, 255));
        lb_pendingSection.setText("Pending Course Section");
        lb_pendingSection.setOpaque(true);

        btn_pending.setBackground(new java.awt.Color(0, 102, 0));
        btn_pending.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_pending.setForeground(new java.awt.Color(255, 255, 255));
        btn_pending.setText("Pending");
        btn_pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pendingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_pendingControlLayout = new javax.swing.GroupLayout(jPanel_pendingControl);
        jPanel_pendingControl.setLayout(jPanel_pendingControlLayout);
        jPanel_pendingControlLayout.setHorizontalGroup(
            jPanel_pendingControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_pending, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_pendingControlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_pendingSection, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel_pendingControlLayout.setVerticalGroup(
            jPanel_pendingControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pendingControlLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lb_pendingSection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                .addComponent(btn_pending, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_pendingDisplay.setBackground(new java.awt.Color(255, 255, 204));

        jTable_pendingCourses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable_pendingCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "User ID", "addCode", "addSession", "dropCode", "dropSession"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_pendingCourses.setEnabled(false);
        jTable_pendingCourses.setRowHeight(24);
        jTable_pendingCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_pendingCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_pendingCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_pendingCoursesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable_pendingCourses);

        lb_PendingCourses.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lb_PendingCourses.setText("Pending Courses");

        javax.swing.GroupLayout jPanel_pendingDisplayLayout = new javax.swing.GroupLayout(jPanel_pendingDisplay);
        jPanel_pendingDisplay.setLayout(jPanel_pendingDisplayLayout);
        jPanel_pendingDisplayLayout.setHorizontalGroup(
            jPanel_pendingDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pendingDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_pendingDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_PendingCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_pendingDisplayLayout.setVerticalGroup(
            jPanel_pendingDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pendingDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_PendingCourses)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_pendingLayout = new javax.swing.GroupLayout(jPanel_pending);
        jPanel_pending.setLayout(jPanel_pendingLayout);
        jPanel_pendingLayout.setHorizontalGroup(
            jPanel_pendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pendingLayout.createSequentialGroup()
                .addComponent(jPanel_pendingControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_pendingDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel_pendingLayout.setVerticalGroup(
            jPanel_pendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_pendingControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_pendingDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane_teacher.addTab("Pending", jPanel_pending);

        javax.swing.GroupLayout jPanel_backgoundLayout = new javax.swing.GroupLayout(jPanel_backgound);
        jPanel_backgound.setLayout(jPanel_backgoundLayout);
        jPanel_backgoundLayout.setHorizontalGroup(
            jPanel_backgoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_backgoundLayout.setVerticalGroup(
            jPanel_backgoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_backgoundLayout.createSequentialGroup()
                .addComponent(jPanel_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_backgound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_backgound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        teacherController.addCourseRequest();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_dropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dropActionPerformed
        // TODO add your handling code here:
        teacherController.dropCourseRequest();
    }//GEN-LAST:event_btn_dropActionPerformed

    private void btn_dropSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dropSearchActionPerformed
        // TODO add your handling code here:
        String comboBoxText = String.valueOf(cb_dropSearch.getSelectedItem());
        String textFieldText = tf_dropSearch.getText();
        if(lb_sidText.getText().equals("[SID]")){
            showMessage("Please input SID first");
        }else{
            teacherController.updateDropDisplayPanel(comboBoxText, textFieldText);
        }       
    }//GEN-LAST:event_btn_dropSearchActionPerformed

    private void jTable_dropRegisteredCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_dropRegisteredCoursesMouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable_dropRegisteredCourses.getSelectedRow();
        TableModel model = jTable_dropRegisteredCourses.getModel();

        // Get the values of the clicked row
        Object[] rowValues = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowValues[i] = model.getValueAt(rowIndex, i);
        }

        teacherController.updateDropControlPanel(Arrays.toString(rowValues));
    }//GEN-LAST:event_jTable_dropRegisteredCoursesMouseClicked

    private void btn_addDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addDropActionPerformed
        // TODO add your handling code here:
        teacherController.addDropCourseRequest();
    }//GEN-LAST:event_btn_addDropActionPerformed

    private void btn_addDropSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addDropSearchActionPerformed
        // TODO add your handling code here:
        String comboBoxText = String.valueOf(cb_addDropSearch.getSelectedItem());
        String textFieldText = tf_addDropSearch.getText();
        if(lb_sidText.getText().equals("[SID]")){
            showMessage("Please input SID first");
        }else{
            teacherController.updateAddDropDisplayPanel(comboBoxText, textFieldText);
        }
    }//GEN-LAST:event_btn_addDropSearchActionPerformed

    private void jTable_addDropUnregisteredCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_addDropUnregisteredCoursesMouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable_addDropUnregisteredCourses.getSelectedRow();
        TableModel model = jTable_addDropUnregisteredCourses.getModel();

        // Get the values of the clicked row
        Object[] rowValues = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowValues[i] = model.getValueAt(rowIndex, i);
        }

        teacherController.updateAddDropAddControlPanel(Arrays.toString(rowValues));
    }//GEN-LAST:event_jTable_addDropUnregisteredCoursesMouseClicked

    private void jTable_addDropRegisteredCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_addDropRegisteredCoursesMouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable_addDropRegisteredCourses.getSelectedRow();
        TableModel model = jTable_addDropRegisteredCourses.getModel();

        // Get the values of the clicked row
        Object[] rowValues = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowValues[i] = model.getValueAt(rowIndex, i);
        }
        teacherController.updateAddDropDropControlPanel(Arrays.toString(rowValues));
    }//GEN-LAST:event_jTable_addDropRegisteredCoursesMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        teacherController.logoutRequest();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enterActionPerformed
        // TODO add your handling code here:
        String userInput = tf_sidInput.getText();
        teacherController.userInfoRequest(userInput);
    }//GEN-LAST:event_btn_enterActionPerformed

    private void btn_pendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pendingActionPerformed
        // TODO add your handling code here:
        teacherController.pendingRequest();
    }//GEN-LAST:event_btn_pendingActionPerformed

    private void jTable_pendingCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_pendingCoursesMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable_pendingCoursesMouseClicked

    private void btn_addSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addSearchActionPerformed
        // TODO add your handling code here:
        String comboBoxText = String.valueOf(cb_addSearch.getSelectedItem());
        String textFieldText = tf_addSearch.getText();
        if(lb_sidText.getText().equals("[SID]")){
            showMessage("Please input SID first");
        }else{
            teacherController.updateAddDisplayPanel(comboBoxText, textFieldText);
        }      
    }//GEN-LAST:event_btn_addSearchActionPerformed

    private void jTable_addUnregisteredCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_addUnregisteredCoursesMouseClicked
        int rowIndex = jTable_addUnregisteredCourses.getSelectedRow();
        TableModel model = jTable_addUnregisteredCourses.getModel();

        // Get the values of the clicked row
        Object[] rowValues = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowValues[i] = model.getValueAt(rowIndex, i);
        }
        teacherController.updateAddControlPanel(Arrays.toString(rowValues));
    }//GEN-LAST:event_jTable_addUnregisteredCoursesMouseClicked

    private void jTable_overviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_overviewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_overviewMouseClicked

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public boolean pendingConfirmationMessage() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Add the add/drop request to pending list?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            return true;
        } else if (dialogResult == JOptionPane.NO_OPTION) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_addDrop;
    private javax.swing.JButton btn_addDropSearch;
    private javax.swing.JButton btn_addSearch;
    private javax.swing.JButton btn_drop;
    private javax.swing.JButton btn_dropSearch;
    private javax.swing.JButton btn_enter;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_pending;
    private javax.swing.JComboBox<String> cb_addDropSearch;
    private javax.swing.JComboBox<String> cb_addSearch;
    private javax.swing.JComboBox<String> cb_dropSearch;
    private javax.swing.JPanel jPanel_add;
    private javax.swing.JPanel jPanel_addControl;
    private javax.swing.JPanel jPanel_addDisplay;
    private javax.swing.JPanel jPanel_addDrop;
    private javax.swing.JPanel jPanel_addDropControl;
    private javax.swing.JPanel jPanel_addDropDisplay;
    private javax.swing.JPanel jPanel_backgound;
    private javax.swing.JPanel jPanel_bar;
    private javax.swing.JPanel jPanel_drop;
    private javax.swing.JPanel jPanel_dropControl;
    private javax.swing.JPanel jPanel_dropDisplay;
    private javax.swing.JPanel jPanel_overview;
    private javax.swing.JPanel jPanel_overviewDisplay;
    private javax.swing.JPanel jPanel_pending;
    private javax.swing.JPanel jPanel_pendingControl;
    private javax.swing.JPanel jPanel_pendingDisplay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane_teacher;
    private javax.swing.JTable jTable_addDropRegisteredCourses;
    private javax.swing.JTable jTable_addDropUnregisteredCourses;
    private javax.swing.JTable jTable_addRegisteredCourses;
    private javax.swing.JTable jTable_addUnregisteredCourses;
    private javax.swing.JTable jTable_dropRegisteredCourses;
    private javax.swing.JTable jTable_dropUnregisteredCourses;
    private javax.swing.JTable jTable_overview;
    private javax.swing.JTable jTable_pendingCourses;
    private javax.swing.JLabel lb_PendingCourses;
    private javax.swing.JLabel lb_addApplicantsText;
    private javax.swing.JLabel lb_addApplicantsTitle;
    private javax.swing.JLabel lb_addCapacityText;
    private javax.swing.JLabel lb_addCapacityTitle;
    private javax.swing.JLabel lb_addCourseCodeText;
    private javax.swing.JLabel lb_addCourseCodeTitle;
    private javax.swing.JLabel lb_addCourseTitleText;
    private javax.swing.JLabel lb_addCourseTitleTitle;
    private javax.swing.JLabel lb_addDeopAddCourseTitleText;
    private javax.swing.JLabel lb_addDropAddApplicantsText;
    private javax.swing.JLabel lb_addDropAddApplicantsTitle;
    private javax.swing.JLabel lb_addDropAddCapacityText;
    private javax.swing.JLabel lb_addDropAddCapacityTitle;
    private javax.swing.JLabel lb_addDropAddCourseCodeText;
    private javax.swing.JLabel lb_addDropAddCourseCodeTitle;
    private javax.swing.JLabel lb_addDropAddCourseTitleTitle;
    private javax.swing.JLabel lb_addDropAddSection;
    private javax.swing.JLabel lb_addDropAddSessionText;
    private javax.swing.JLabel lb_addDropAddSessionTitle;
    private javax.swing.JLabel lb_addDropAddTeacherText;
    private javax.swing.JLabel lb_addDropAddTeacherTitle;
    private javax.swing.JLabel lb_addDropAddTimeText;
    private javax.swing.JLabel lb_addDropAddTimeTitle;
    private javax.swing.JLabel lb_addDropAddWeekdayText;
    private javax.swing.JLabel lb_addDropAddWeekdayTitle;
    private javax.swing.JLabel lb_addDropDropApplicantsText;
    private javax.swing.JLabel lb_addDropDropApplicantsTitle;
    private javax.swing.JLabel lb_addDropDropCapacityText;
    private javax.swing.JLabel lb_addDropDropCapacityTitle;
    private javax.swing.JLabel lb_addDropDropCourseCodeText;
    private javax.swing.JLabel lb_addDropDropCourseCodeTitle;
    private javax.swing.JLabel lb_addDropDropCourseTitleText;
    private javax.swing.JLabel lb_addDropDropCourseTitleTitle;
    private javax.swing.JLabel lb_addDropDropSection;
    private javax.swing.JLabel lb_addDropDropSessionText;
    private javax.swing.JLabel lb_addDropDropSessionTitle;
    private javax.swing.JLabel lb_addDropDropTeacherText;
    private javax.swing.JLabel lb_addDropDropTeacherTitle;
    private javax.swing.JLabel lb_addDropDropTimeText;
    private javax.swing.JLabel lb_addDropDropTimeTitle;
    private javax.swing.JLabel lb_addDropDropWeekdayText;
    private javax.swing.JLabel lb_addDropDropWeekdayTitle;
    private javax.swing.JLabel lb_addDropRegisteredCourses;
    private javax.swing.JLabel lb_addDropSearcher;
    private javax.swing.JLabel lb_addDropUnregisteredCourses;
    private javax.swing.JLabel lb_addRegisteredCourses;
    private javax.swing.JLabel lb_addSearcher;
    private javax.swing.JLabel lb_addSection;
    private javax.swing.JLabel lb_addSessionText;
    private javax.swing.JLabel lb_addSessionTitle;
    private javax.swing.JLabel lb_addTeacherText;
    private javax.swing.JLabel lb_addTeacherTitle;
    private javax.swing.JLabel lb_addTimeText;
    private javax.swing.JLabel lb_addTimeTitle;
    private javax.swing.JLabel lb_addUnregisteredCourses;
    private javax.swing.JLabel lb_addWeekdayText;
    private javax.swing.JLabel lb_addWeekdayTitle;
    private javax.swing.JLabel lb_dropApplicantsText;
    private javax.swing.JLabel lb_dropApplicantsTitle;
    private javax.swing.JLabel lb_dropCapacityText;
    private javax.swing.JLabel lb_dropCapacityTitle;
    private javax.swing.JLabel lb_dropCourseCodeText;
    private javax.swing.JLabel lb_dropCourseCodeTitle;
    private javax.swing.JLabel lb_dropCourseTitleText;
    private javax.swing.JLabel lb_dropCourseTitleTitle;
    private javax.swing.JLabel lb_dropRegisteredCourses;
    private javax.swing.JLabel lb_dropSearcher;
    private javax.swing.JLabel lb_dropSection;
    private javax.swing.JLabel lb_dropSessionText;
    private javax.swing.JLabel lb_dropSessionTitle;
    private javax.swing.JLabel lb_dropTeacherText;
    private javax.swing.JLabel lb_dropTeacherTitle;
    private javax.swing.JLabel lb_dropTimeText;
    private javax.swing.JLabel lb_dropTimeTitle;
    private javax.swing.JLabel lb_dropUnregisteredCourses;
    private javax.swing.JLabel lb_dropWeekdayText;
    private javax.swing.JLabel lb_dropWeekdayTitle;
    private javax.swing.JLabel lb_genderText;
    private javax.swing.JLabel lb_genderTitle;
    private javax.swing.JLabel lb_nameText;
    private javax.swing.JLabel lb_nameTitle;
    private javax.swing.JLabel lb_overview;
    private javax.swing.JLabel lb_pendingSection;
    private javax.swing.JLabel lb_sidInputTitle;
    private javax.swing.JLabel lb_sidText;
    private javax.swing.JLabel lb_sidTitle;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField tf_addDropSearch;
    private javax.swing.JTextField tf_addSearch;
    private javax.swing.JTextField tf_dropSearch;
    private javax.swing.JTextField tf_sidInput;
    // End of variables declaration//GEN-END:variables
}
