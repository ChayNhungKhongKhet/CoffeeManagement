/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.coffee_mangement.view;

/**
 *
 * @author asus
 */
public class Add_Menu extends javax.swing.JFrame {

    /**
     * Creates new form Add_Menu
     */
    public Add_Menu() {
        initComponents();
        setLocationRelativeTo(null);        
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        PanelEditMenu338 = new javax.swing.JPanel();
        txtPrice338 = new javax.swing.JTextField();
        btnConfirm338 = new javax.swing.JButton();
        txtUnit338 = new javax.swing.JTextField();
        lblName338 = new javax.swing.JLabel();
        lbDishGroup338 = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        lbUnit338 = new javax.swing.JLabel();
        btnCancel338 = new javax.swing.JButton();
        cbbDishGroup338 = new javax.swing.JComboBox<>();
        txtNameDish338 = new javax.swing.JTextField();
        lbPrice338 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm món");
        setBackground(new java.awt.Color(69, 32, 16));

        jPanel1.setBackground(new java.awt.Color(69, 32, 16));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        PanelEditMenu338.setBackground(new java.awt.Color(69, 32, 16));

        txtPrice338.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrice338.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrice338.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrice338KeyReleased(evt);
            }
        });

        btnConfirm338.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirm338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConfirm338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_mangement/image/apply-icon.png"))); // NOI18N
        btnConfirm338.setText("XÁC NHẬN");
        btnConfirm338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm338ActionPerformed(evt);
            }
        });

        txtUnit338.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUnit338.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblName338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName338.setForeground(new java.awt.Color(255, 255, 0));
        lblName338.setText("Tên món:");

        lbDishGroup338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDishGroup338.setForeground(new java.awt.Color(255, 255, 0));
        lbDishGroup338.setText("Nhóm món:");

        lblten.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblten.setForeground(new java.awt.Color(255, 255, 255));
        lblten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_mangement/image/hp-notepad-pencil-icon.png"))); // NOI18N
        lblten.setText("THÊM MÓN");

        lbUnit338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbUnit338.setForeground(new java.awt.Color(255, 255, 0));
        lbUnit338.setText("ĐVT:");

        btnCancel338.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_mangement/image/Error-Symbol-icon.png"))); // NOI18N
        btnCancel338.setText("HỦY");
        btnCancel338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel338ActionPerformed(evt);
            }
        });

        cbbDishGroup338.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbDishGroup338.setForeground(new java.awt.Color(51, 0, 51));
        cbbDishGroup338.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDishGroup338.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDishGroup338ItemStateChanged(evt);
            }
        });

        txtNameDish338.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNameDish338.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbPrice338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPrice338.setForeground(new java.awt.Color(255, 255, 0));
        lbPrice338.setText("Đơn giá:");

        javax.swing.GroupLayout PanelEditMenu338Layout = new javax.swing.GroupLayout(PanelEditMenu338);
        PanelEditMenu338.setLayout(PanelEditMenu338Layout);
        PanelEditMenu338Layout.setHorizontalGroup(
            PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditMenu338Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditMenu338Layout.createSequentialGroup()
                        .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName338, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbPrice338, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbUnit338, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDishGroup338, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbDishGroup338, 0, 147, Short.MAX_VALUE)
                            .addComponent(txtNameDish338)
                            .addComponent(txtPrice338)
                            .addComponent(txtUnit338))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelEditMenu338Layout.createSequentialGroup()
                        .addComponent(btnConfirm338)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnCancel338, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(PanelEditMenu338Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblten)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelEditMenu338Layout.setVerticalGroup(
            PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditMenu338Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblten)
                .addGap(18, 18, 18)
                .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName338)
                    .addComponent(txtNameDish338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDishGroup338)
                    .addComponent(cbbDishGroup338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrice338)
                    .addComponent(txtPrice338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUnit338)
                    .addComponent(txtUnit338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelEditMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm338, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel338, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 21, 0, 10);
        jPanel1.add(PanelEditMenu338, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrice338KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrice338KeyReleased
        try{
            Integer.parseInt(txtPrice338.getText());
        }catch(Exception ex){
            txtPrice338.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrice338KeyReleased

    private void btnConfirm338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirm338ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirm338ActionPerformed

    private void btnCancel338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel338ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancel338ActionPerformed

    private void cbbDishGroup338ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDishGroup338ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDishGroup338ItemStateChanged

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
            java.util.logging.Logger.getLogger(Add_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEditMenu338;
    private javax.swing.JButton btnCancel338;
    private javax.swing.JButton btnConfirm338;
    private javax.swing.JComboBox<Object> cbbDishGroup338;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDishGroup338;
    private javax.swing.JLabel lbPrice338;
    private javax.swing.JLabel lbUnit338;
    private javax.swing.JLabel lblName338;
    private javax.swing.JLabel lblten;
    private javax.swing.JTextField txtNameDish338;
    private javax.swing.JTextField txtPrice338;
    private javax.swing.JTextField txtUnit338;
    // End of variables declaration//GEN-END:variables
}
