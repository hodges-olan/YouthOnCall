/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.View;

import Client.Control.MembersControl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author co075oh
 */
public class MembersUI extends javax.swing.JFrame {

    // Define Controllers
    private final MembersControl membersController = new MembersControl();
    
    /**
     * Creates new form MemberUI
     */
    public MembersUI() {
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

        MembersScrollPane = new javax.swing.JScrollPane();
        MembersTable = new javax.swing.JTable();
        MembersRefreshButton = new javax.swing.JButton();
        AddMember = new javax.swing.JButton();
        EditMember = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        MembersMenu = new javax.swing.JMenu();
        Close = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        try {
            MembersTable.setModel(new javax.swing.table.DefaultTableModel(
                membersController.retrieveAllMembers(),
                membersController.retrieveColumns()
            ));
        } catch (IOException ex) {
            Logger.getLogger(MembersUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        MembersScrollPane.setViewportView(MembersTable);

        MembersRefreshButton.setText("Refresh");
        MembersRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MembersRefreshButtonActionPerformed(evt);
            }
        });

        AddMember.setText("Add Member");
        AddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberActionPerformed(evt);
            }
        });

        EditMember.setText("Edit Member");
        EditMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMemberActionPerformed(evt);
            }
        });

        MembersMenu.setText("Members");

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        MembersMenu.add(Close);

        MenuBar.add(MembersMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MembersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AddMember)
                        .addGap(18, 18, 18)
                        .addComponent(EditMember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MembersRefreshButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MembersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MembersRefreshButton)
                    .addComponent(AddMember)
                    .addComponent(EditMember))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void AddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberActionPerformed
        new AddMemberUI().setVisible(true);
    }//GEN-LAST:event_AddMemberActionPerformed

    private void EditMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMemberActionPerformed
        new EditMemberUI().setVisible(true);
    }//GEN-LAST:event_EditMemberActionPerformed

    private void MembersRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MembersRefreshButtonActionPerformed
        try {
            MembersTable.setModel(new javax.swing.table.DefaultTableModel(
                    membersController.retrieveAllMembers(),
                    membersController.retrieveColumns()
            ));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MembersRefreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MembersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MembersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MembersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MembersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MembersUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMember;
    private javax.swing.JMenuItem Close;
    private javax.swing.JButton EditMember;
    private javax.swing.JMenu MembersMenu;
    private javax.swing.JButton MembersRefreshButton;
    private javax.swing.JScrollPane MembersScrollPane;
    private javax.swing.JTable MembersTable;
    private javax.swing.JMenuBar MenuBar;
    // End of variables declaration//GEN-END:variables
}
