package com.mycompany.feesmanagementsysteminjava;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Shivam Singh
 */
public class LogInPage extends javax.swing.JFrame {

    /**
     * Creates new form LogInPage
     */
    public LogInPage() {
        initComponents();
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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbutton = new javax.swing.JButton();
        lbutton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        perrormsg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        uerrormsg = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(102, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\muskan jaiswal\\Documents\\NetBeansProjects\\com.mycompany_FeesManagementSystemInJava_jar_1.0-SNAPSHOT\\src\\main\\java\\image\\admin.png")); // NOI18N
        jLabel4.setText(" Log In");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 120));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbutton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbutton.setText("Clear");
        cbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(cbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 123, -1));

        lbutton.setBackground(new java.awt.Color(0, 0, 102));
        lbutton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbutton.setForeground(new java.awt.Color(255, 255, 255));
        lbutton.setText("Log In");
        lbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbuttonMouseExited(evt);
            }
        });
        lbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(lbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 123, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setText("Sign Up");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 123, -1));

        perrormsg.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(perrormsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 442, 14));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Password");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 123, 39));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 123, 39));

        uerrormsg.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(uerrormsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 418, 16));

        txtuname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 250, 39));

        txtpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 250, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 690, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbuttonActionPerformed
String uname,password;
uname=txtuname.getText();
password=txtpassword.getText();

if(uname.equals("")){
    uerrormsg.setText("please Enter the username");
}
if(password.equals("")){
    perrormsg.setText("please Enter the password");
}
else{

verification(uname,password);
}
    }//GEN-LAST:event_lbuttonActionPerformed

    private void cbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbuttonActionPerformed
clear();    }//GEN-LAST:event_cbuttonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     SignUpPage s1=new SignUpPage();
     s1.setVisible(true);
     this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbuttonMouseEntered
Color c1=new Color(204,225,255); 
lbutton.setBackground(c1);   
Color c2=new Color(0,0,0); 
lbutton.setForeground(c2); // TODO add your handling code here:
    }//GEN-LAST:event_lbuttonMouseEntered

    private void lbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbuttonMouseExited
Color c1=new Color(0,0,102); 
lbutton.setBackground(c1);  
Color c2=new Color(255,255,255); 
lbutton.setForeground(c2); // TODO add your handling code here:
    }//GEN-LAST:event_lbuttonMouseExited

    
    void clear(){
        
        
        txtpassword.setText("");
        txtuname.setText("");
        
        
        perrormsg.setText("");
        uerrormsg.setText("");
       
    }
    
    void verification(String name,String password){
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/feesmanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con=DriverManager.getConnection(url,"root","2309");
        
        String sql="select*from signuppage where uname=? and password=?";
       
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,name);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            HomePage hp=new HomePage();
            hp.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Incorrect username or password");
        }
        }
        catch(Exception e){
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbutton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lbutton;
    private javax.swing.JLabel perrormsg;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuname;
    private javax.swing.JLabel uerrormsg;
    // End of variables declaration//GEN-END:variables
}
