/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.coffee_management.view;

import java.awt.Color;

/**
 *
 * @author Admin
 */
public class MainFrame extends javax.swing.JFrame {


    public MainFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        functionPanel = new javax.swing.JPanel();
        btnSell307 = new javax.swing.JButton();
        btnManage307 = new javax.swing.JButton();
        btnStatistical307 = new javax.swing.JButton();
        btnWarehouse307 = new javax.swing.JButton();
        accountButton307 = new javax.swing.JButton();
        logOutButton307 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 0));

        functionPanel.setBackground(new java.awt.Color(69, 32, 16));
        functionPanel.setForeground(new java.awt.Color(255, 255, 255));
        functionPanel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        functionPanel.setLayout(new java.awt.GridLayout(1, 10, 0, 10));

        btnSell307.setBackground(new java.awt.Color(69, 32, 16));
        btnSell307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSell307.setForeground(new java.awt.Color(255, 153, 0));
        btnSell307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/sell.png"))); // NOI18N
        btnSell307.setText("Bán hàng");
        btnSell307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSell307ActionPerformed(evt);
            }
        });
        functionPanel.add(btnSell307);

        btnManage307.setBackground(new java.awt.Color(69, 32, 16));
        btnManage307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnManage307.setForeground(new java.awt.Color(255, 153, 0));
        btnManage307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/manage.png"))); // NOI18N
        btnManage307.setText("Quản lý");
        functionPanel.add(btnManage307);

        btnStatistical307.setBackground(new java.awt.Color(69, 32, 16));
        btnStatistical307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatistical307.setForeground(new java.awt.Color(255, 153, 0));
        btnStatistical307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/statistical.png"))); // NOI18N
        btnStatistical307.setText("Thống kê");
        functionPanel.add(btnStatistical307);

        btnWarehouse307.setBackground(new java.awt.Color(69, 32, 16));
        btnWarehouse307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnWarehouse307.setForeground(new java.awt.Color(255, 153, 0));
        btnWarehouse307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/warehouse.png"))); // NOI18N
        btnWarehouse307.setText("Kho NVL");
        btnWarehouse307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarehouse307ActionPerformed(evt);
            }
        });
        functionPanel.add(btnWarehouse307);

        accountButton307.setBackground(new java.awt.Color(69, 32, 16));
        accountButton307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accountButton307.setForeground(new java.awt.Color(255, 153, 0));
        accountButton307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/account.png"))); // NOI18N
        accountButton307.setText("Tài khoản");
        accountButton307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButton307ActionPerformed(evt);
            }
        });
        functionPanel.add(accountButton307);

        logOutButton307.setBackground(new java.awt.Color(69, 32, 16));
        logOutButton307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logOutButton307.setForeground(new java.awt.Color(255, 153, 0));
        logOutButton307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logout.png"))); // NOI18N
        logOutButton307.setText("Đăng xuất");
        logOutButton307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButton307ActionPerformed(evt);
            }
        });
        functionPanel.add(logOutButton307);

        getContentPane().add(functionPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setBackground(new java.awt.Color(69, 32, 16));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setForeground(new java.awt.Color(255, 153, 0));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/banner.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 800));
        jLabel1.setMinimumSize(new java.awt.Dimension(1000, 800));
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        mainPanel.add(jLabel1, new java.awt.GridBagConstraints());

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSell307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSell307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSell307ActionPerformed

    private void btnWarehouse307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarehouse307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWarehouse307ActionPerformed

    private void logOutButton307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButton307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutButton307ActionPerformed

    private void accountButton307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButton307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountButton307ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton307;
    private javax.swing.JButton btnManage307;
    private javax.swing.JButton btnSell307;
    private javax.swing.JButton btnStatistical307;
    private javax.swing.JButton btnWarehouse307;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOutButton307;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
