/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.coffee_management.view;

import com.java.coffee_management.Service.Service;
import com.java.coffee_management.model.Menu_entity;
import com.java.coffee_management.model.category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class EditMenu extends javax.swing.JFrame {

    /**
     * Creates new form EditMenu
     */
    Service service = new Service();
    public EditMenu() {
        initComponents();
        setLocationRelativeTo(null);
        jcomboboxtypemenu234.removeAllItems();
        jComboBoxIDMenu234.removeAllItems();
        List<category> cts = new ArrayList<>();
        cts = service.getAllCategory_234();
        for (category c:cts){
            jcomboboxtypemenu234.addItem(c.getName());
        }
        List<Menu_entity> mns = service.getAllMenu_234();
        
        for(Menu_entity e : mns){
            jComboBoxIDMenu234.addItem(String.valueOf(e.getIdP()));
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

        jPanelEditMenu234 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnXEditmenu234 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcomboboxtypemenu234 = new javax.swing.JComboBox<>();
        btnEditmenu1_234 = new javax.swing.JLabel();
        btnCancel1_234 = new javax.swing.JLabel();
        jtfnamemenu234 = new javax.swing.JTextField();
        jtfPricemenu234 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxIDMenu234 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelEditMenu234.setBackground(new java.awt.Color(69, 32, 16));
        jPanelEditMenu234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));
        jPanelEditMenu234.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        btnXEditmenu234.setBackground(new java.awt.Color(255, 0, 0));
        btnXEditmenu234.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXEditmenu234.setForeground(new java.awt.Color(255, 255, 255));
        btnXEditmenu234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnXEditmenu234.setText("X");
        btnXEditmenu234.setOpaque(true);
        btnXEditmenu234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXEditmenu234MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXEditmenu234, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXEditmenu234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelEditMenu234.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 346, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("SỬA MÓN  ");
        jPanelEditMenu234.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 33, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID món");
        jPanelEditMenu234.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jcomboboxtypemenu234.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÀ PHÊ", "TRÀ ", "TRÀ SỮA ", "SINH TỐ, NƯỚC ÉP", " ", " " }));
        jPanelEditMenu234.add(jcomboboxtypemenu234, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 140, -1));

        btnEditmenu1_234.setBackground(new java.awt.Color(0, 204, 255));
        btnEditmenu1_234.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditmenu1_234.setForeground(new java.awt.Color(255, 255, 255));
        btnEditmenu1_234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditmenu1_234.setText("SỬA");
        btnEditmenu1_234.setOpaque(true);
        btnEditmenu1_234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditmenu1_234MouseClicked(evt);
            }
        });
        jPanelEditMenu234.add(btnEditmenu1_234, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 100, 23));

        btnCancel1_234.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel1_234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel1_234.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel1_234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel1_234.setText("HUỶ BỎ ");
        btnCancel1_234.setOpaque(true);
        jPanelEditMenu234.add(btnCancel1_234, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 100, 23));

        jtfnamemenu234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfnamemenu234ActionPerformed(evt);
            }
        });
        jPanelEditMenu234.add(jtfnamemenu234, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 166, -1));
        jPanelEditMenu234.add(jtfPricemenu234, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 166, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText(" Loại món:");
        jPanelEditMenu234.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 67, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Giá món:");
        jPanelEditMenu234.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 67, -1));

        jComboBoxIDMenu234.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxIDMenu234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDMenu234ActionPerformed(evt);
            }
        });
        jPanelEditMenu234.add(jComboBoxIDMenu234, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tên món:");
        jPanelEditMenu234.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tên món:");
        jPanelEditMenu234.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEditMenu234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEditMenu234, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXEditmenu234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXEditmenu234MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnXEditmenu234MouseClicked

    private void jComboBoxIDMenu234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDMenu234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIDMenu234ActionPerformed

    private void btnEditmenu1_234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditmenu1_234MouseClicked
        // TODO add your handling code here:
        service.updateMenu(Integer.valueOf(String.valueOf(jComboBoxIDMenu234.getSelectedItem())),String.valueOf(jcomboboxtypemenu234.getSelectedItem()), jtfnamemenu234.getText(), Float.valueOf(jtfPricemenu234.getText()));
        this.dispose();
    }//GEN-LAST:event_btnEditmenu1_234MouseClicked

    private void jtfnamemenu234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnamemenu234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfnamemenu234ActionPerformed

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
            java.util.logging.Logger.getLogger(EditMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancel1_234;
    private javax.swing.JLabel btnEditmenu1_234;
    private javax.swing.JLabel btnXEditmenu234;
    private javax.swing.JComboBox<String> jComboBoxIDMenu234;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelEditMenu234;
    private javax.swing.JComboBox<String> jcomboboxtypemenu234;
    private javax.swing.JTextField jtfPricemenu234;
    private javax.swing.JTextField jtfnamemenu234;
    // End of variables declaration//GEN-END:variables
}
