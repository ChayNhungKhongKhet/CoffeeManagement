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
        java.awt.GridBagConstraints gridBagConstraints;

        functionPanel = new javax.swing.JPanel();
        btnSell307 = new javax.swing.JButton();
        btnManage307 = new javax.swing.JButton();
        btnStatistical307 = new javax.swing.JButton();
        btnWarehouse307 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        accountButton307 = new javax.swing.JButton();
        logOutButton307 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(255, 153, 0));

        functionPanel.setBackground(new java.awt.Color(69, 32, 16));
        functionPanel.setForeground(new java.awt.Color(255, 255, 255));
        functionPanel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        functionPanel.setLayout(new java.awt.GridLayout(1, 10, 0, 10));

        btnSell307.setBackground(new java.awt.Color(69, 32, 16));
        btnSell307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSell307.setForeground(new java.awt.Color(255, 153, 0));
        btnSell307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/sell_logo.png"))); // NOI18N
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
        btnManage307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/management_logo.png"))); // NOI18N
        btnManage307.setText("Quản lý");
        functionPanel.add(btnManage307);

        btnStatistical307.setBackground(new java.awt.Color(69, 32, 16));
        btnStatistical307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatistical307.setForeground(new java.awt.Color(255, 153, 0));
        btnStatistical307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/statistical_logo.png"))); // NOI18N
        btnStatistical307.setText("Thống kê");
        functionPanel.add(btnStatistical307);

        btnWarehouse307.setBackground(new java.awt.Color(69, 32, 16));
        btnWarehouse307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnWarehouse307.setForeground(new java.awt.Color(255, 153, 0));
        btnWarehouse307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/warehouse_logo.png"))); // NOI18N
        btnWarehouse307.setText("Kho NVL");
        btnWarehouse307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarehouse307ActionPerformed(evt);
            }
        });
        functionPanel.add(btnWarehouse307);

        getContentPane().add(functionPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(69, 32, 16));
        jPanel2.setAutoscrolls(true);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jSeparator1.setBackground(new java.awt.Color(69, 32, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 692;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jSeparator1, gridBagConstraints);

        accountButton307.setBackground(new java.awt.Color(69, 32, 16));
        accountButton307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accountButton307.setForeground(new java.awt.Color(255, 153, 0));
        accountButton307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/change_pass_logo.png"))); // NOI18N
        accountButton307.setText("Tài khoản");
        accountButton307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButton307ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 0);
        jPanel2.add(accountButton307, gridBagConstraints);

        logOutButton307.setBackground(new java.awt.Color(69, 32, 16));
        logOutButton307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logOutButton307.setForeground(new java.awt.Color(255, 153, 0));
        logOutButton307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/log_out_logo.png"))); // NOI18N
        logOutButton307.setText("Đăng xuất");
        logOutButton307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButton307ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 18, 0, 0);
        jPanel2.add(logOutButton307, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(69, 32, 16));

        jLabel1.setBackground(new java.awt.Color(69, 32, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/banner_.png"))); // NOI18N
        jLabel1.setLabelFor(jPanel3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 20, 0);
        jPanel2.add(jPanel3, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(42, 18, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logOutButton307;
    // End of variables declaration//GEN-END:variables
}
