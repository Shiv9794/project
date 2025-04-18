/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.feesmanagementsysteminjava;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Shivam Singh
 */
public class EditCourse extends javax.swing.JFrame {

    /**
     * Creates new form EditCourse
     */
    DefaultTableModel model;
    public EditCourse() {
        initComponents();
        setRecordsToTable();
    }

    
    public void setRecordsToTable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        String sql="select* from course";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            String courseId=rs.getString("id");
            String courseName=rs.getString("cname");
            String courseFees=rs.getString("cost");
            
            
            Object[] obj={courseId,courseName,courseFees};
            model =(DefaultTableModel)tbl_edit_course.getModel();
            model.addRow(obj);
            
            
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
}
    
    public void addCourse(int id,String cname,double cost){
        try{
            Connection con=DBConnection.getConnection();
        String sql="insert into course values(?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1, id);
        st.setString(2, cname);
        st.setDouble(3, cost);
        int rowCount=st.executeUpdate();
        if(rowCount==1){
            JOptionPane.showMessageDialog(this,"course added succesfully");
            clearTable();
            setRecordsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this,"course inserted failed");
        }
        }
        catch(Exception e){
            
        }
    }
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel)tbl_edit_course.getModel();
        model.setRowCount(0);
    }
    
    public void update(int id,String cname,double cost){
        try{
            Connection con=DBConnection.getConnection();
        String sql="update course set cname=?,cost=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        
        st.setString(1, cname);
        st.setDouble(2, cost);
        st.setInt(3, id);
        int rowCount=st.executeUpdate();
        if(rowCount==1){
            JOptionPane.showMessageDialog(this,"course updation succesfully");
            clearTable();
            setRecordsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this,"course updation failed");
        }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"course updation failed and exception occurs");
        }
    }
    
    public void delete(int id){
        try{
            Connection con=DBConnection.getConnection();
        
        PreparedStatement st=con.prepareStatement("delete from course where id=?");
        
        
        st.setInt(1, id);
        int rowCount=st.executeUpdate();
        if(rowCount==1){
            JOptionPane.showMessageDialog(this,"course deleted succesfully");
            clearTable();
            setRecordsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this,"course deletion failed");
        }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"course deletion failed and exception occurs");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_edit_course = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_course_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_course_fees = new javax.swing.JTextField();
        txt_course_id = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_edit_course.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Fees"
            }
        ));
        tbl_edit_course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_edit_courseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbl_edit_courseMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_edit_course);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 112, 670, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Edit Course");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 190, 30));

        txt_course_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Course Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Course Fees");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Course ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        txt_course_fees.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_course_fees, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 200, -1));

        txt_course_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_course_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 200, -1));

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton10.setText("UPDATE");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, 30));

        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton11.setText("DELETE");
        jButton11.setPreferredSize(new java.awt.Dimension(97, 32));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        jButton12.setBackground(new java.awt.Color(0, 0, 102));
        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("ADD");
        jButton12.setPreferredSize(new java.awt.Dimension(97, 32));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 100, -1));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 810));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\search 10.png")); // NOI18N
        jButton1.setText("Search Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 230, 35));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\home black 5.png")); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 230, 35));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\edit list 5.png")); // NOI18N
        jButton3.setText("Edit Course");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 212, 230, 35));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\leftaaa 5 black.png")); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 472, 230, 35));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\view 5.png")); // NOI18N
        jButton5.setText("Course List");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 295, 230, 35));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\book.png")); // NOI18N
        jButton6.setText("View all Record");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 230, 36));

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\out left 5.png")); // NOI18N
        jButton13.setText("Logout");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 230, 35));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\print simple.png")); // NOI18N
        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 230, 35));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 260, 810));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 810));

        setSize(new java.awt.Dimension(1404, 817));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
int id=Integer.parseInt(txt_course_id.getText());
String cname=txt_course_name.getText(); 
double cost=Double.parseDouble(txt_course_fees.getText());
update(id,cname,cost);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
int id=Integer.parseInt(txt_course_id.getText());

delete(id);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
int id=Integer.parseInt(txt_course_id.getText());
String cname=txt_course_name.getText(); 
double cost=Double.parseDouble(txt_course_fees.getText());
addCourse(id,cname,cost);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void tbl_edit_courseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_edit_courseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_edit_courseMouseExited

    private void tbl_edit_courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_edit_courseMouseClicked
     int rowNo=tbl_edit_course.getSelectedRow();   
     TableModel model=tbl_edit_course.getModel();
     
     txt_course_id.setText(model.getValueAt(rowNo,0).toString());
     txt_course_name.setText((String)model.getValueAt(rowNo,1));
     txt_course_fees.setText((String)model.getValueAt(rowNo,2));
    }//GEN-LAST:event_tbl_edit_courseMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SearchRecords search=new SearchRecords();
        search.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EditCourse edit=new EditCourse();
        edit.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CourseList cl=new CourseList();
        cl.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ViewAllRecords var=new ViewAllRecords();
        var.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        LogInPage lip=new LogInPage();
        lip.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);
                
                tbl_edit_course.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }      // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_edit_course;
    private javax.swing.JTextField txt_course_fees;
    private javax.swing.JTextField txt_course_id;
    private javax.swing.JTextField txt_course_name;
    // End of variables declaration//GEN-END:variables
}
