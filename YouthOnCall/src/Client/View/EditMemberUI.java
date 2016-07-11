/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.View;

import Client.Control.MembersControl;
import Client.Model.Jobs;
import Client.Model.Members;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olanandkate
 */
public class EditMemberUI extends javax.swing.JFrame {

    // Instantiate variables
    MembersControl membersController = new MembersControl();
    
    /**
     * Creates new form EditJobUI
     */
    public EditMemberUI(int memberID) {
        initComponents();
        MemberIDField.setVisible(false);
        try {
            Members member = membersController.retrieveMember(memberID);
            this.MemberIDField.setText(Integer.toString(memberID));
            this.NameField.setText(member.getName());
            this.EmailField.setText(member.getEmail());
            this.AddressField.setText(member.getAddress());
            this.CityField.setText(member.getCity());
            this.StateField.setText(member.getSt());
            this.ZipField.setText(Integer.toString(member.getZip()));
            this.PhoneField.setText(member.getPhone());
            if (member.isYouth()) {
                    this.YouthField.setSelectedIndex(0);
            } else {
                    this.YouthField.setSelectedIndex(1);
            }
        } catch (IOException ex) {
            Logger.getLogger(EditJobUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        MemberIDField = new javax.swing.JTextField();
        NameLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        AddressLabel = new javax.swing.JLabel();
        AddressField = new javax.swing.JTextField();
        CityLabel = new javax.swing.JLabel();
        CityField = new javax.swing.JTextField();
        StateLabel = new javax.swing.JLabel();
        StateField = new javax.swing.JTextField();
        ZipLabel = new javax.swing.JLabel();
        ZipField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PhoneField = new javax.swing.JTextField();
        YouthField = new javax.swing.JComboBox<>();
        YouthLabel = new javax.swing.JLabel();
        NewPasswordLabel = new javax.swing.JLabel();
        NewPasswordField = new javax.swing.JPasswordField();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        ConfirmPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        NameLabel.setText("Name:");

        EmailLabel.setText("Email:");

        AddressLabel.setText("Address:");

        CityLabel.setText("City:");

        StateLabel.setText("State:");

        ZipLabel.setText("Zip:");

        jLabel4.setText("Phone:");

        YouthField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        YouthLabel.setText("Youth");

        NewPasswordLabel.setText("New Password:");

        ConfirmPasswordLabel.setText("Confirm Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MemberIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConfirmPasswordLabel)
                    .addComponent(NewPasswordLabel)
                    .addComponent(jLabel4)
                    .addComponent(ZipLabel)
                    .addComponent(StateLabel)
                    .addComponent(CityLabel)
                    .addComponent(AddressLabel)
                    .addComponent(EmailLabel)
                    .addComponent(SaveButton)
                    .addComponent(NameLabel)
                    .addComponent(YouthLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CancelButton)
                    .addComponent(NameField)
                    .addComponent(EmailField)
                    .addComponent(AddressField)
                    .addComponent(CityField)
                    .addComponent(StateField)
                    .addComponent(ZipField)
                    .addComponent(PhoneField)
                    .addComponent(YouthField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewPasswordField)
                    .addComponent(ConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MemberIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailLabel)
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddressLabel)
                            .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CityLabel)
                            .addComponent(CityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StateLabel)
                            .addComponent(StateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ZipLabel)
                            .addComponent(ZipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YouthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YouthLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NewPasswordLabel)
                            .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConfirmPasswordLabel)
                            .addComponent(ConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMemberUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new EditMemberUI().setVisible(true);
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField CityField;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField MemberIDField;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPasswordField NewPasswordField;
    private javax.swing.JLabel NewPasswordLabel;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField StateField;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JComboBox<String> YouthField;
    private javax.swing.JLabel YouthLabel;
    private javax.swing.JTextField ZipField;
    private javax.swing.JLabel ZipLabel;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
