/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.coffee_management.view;
import com.java.coffe_management.Service.Service;
import com.java.coffee_management.Dao.Dao;
import com.java.coffee_management.entity.Employee_entity;
import com.java.coffee_management.entity.Table;
import com.java.coffee_management.entity.Menu_entity;
import com.java.coffee_management.entity.category;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Coffee_management_general extends javax.swing.JFrame {
    List<JPanel> listPanelManage =new ArrayList<>();
    List<JLabel> listLabelManage =new ArrayList<>();
    Dao dao = new Dao();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    DefaultTableModel defaultTableModelTB = new DefaultTableModel();
    DefaultTableModel defaultTableModelMN = new DefaultTableModel();
    Service service = new Service();
    public Coffee_management_general() {
        initComponents();
        textFieldTotalEmployee234.setText(String.valueOf(service.demNV()));
        textFieldTotalTable234.setText(String.valueOf(service.demBan()));
        textFieldTotalDrink234.setText(String.valueOf(service.demMenu()));
        comboBoxTypeDrink234.removeAllItems();
        List<category> cts = new ArrayList<>();
        cts = service.getAllCategory_234();
        for (category c:cts){
            comboBoxTypeDrink234.addItem(c.getName());
        }
        setLocationRelativeTo(null);
        panelListManager();
        labelListManager();
        lableIsSelectedManage(0);
        lableListIsSelected(0);
                defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // khong cho phep nguoi dung Edit du lieu trong bang
            }
        };
        
        tableEmployeeManager234.setModel(defaultTableModel);
        defaultTableModel.addColumn("id");
        defaultTableModel.addColumn("Họ và tên");
        defaultTableModel.addColumn("Ngày vào làm");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Chức vụ");
        defaultTableModel.addColumn("Tai khoản");
        defaultTableModel.addColumn("Mật khẩu");
//        
        List<Employee_entity> emp = service.getAllEmployee_234();
        
        for(Employee_entity e : emp){
            defaultTableModel.addRow(new Object[]{e.getId(),e.getTennv(),e.getNgayVaoLam(),e.getSoDienThoai(),e.getChucVu(),e.getUserName(),e.getPassword()});
        }
        defaultTableModelTB = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // khong cho phep nguoi dung Edit du lieu trong bang
            }
        };
        tableTableManeger234.setModel(defaultTableModelTB);
        defaultTableModelTB.addColumn("id");
        defaultTableModelTB.addColumn("Tầng");
        defaultTableModelTB.addColumn("Trạng thái");
        List<Table> tbs = service.getAllTable_234();
        
        for(Table e : tbs){
            defaultTableModelTB.addRow(new Object[]{e.getId(),e.getTang(),e.getBan(),});
        }
        defaultTableModelMN = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // khong cho phep nguoi dung Edit du lieu trong bang
            }
        };
        tableDrinkManager234.setModel(defaultTableModelMN);
        defaultTableModelMN.addColumn("id");
        defaultTableModelMN.addColumn("Loại");
        defaultTableModelMN.addColumn("Tên");
        defaultTableModelMN.addColumn("Giá");
        
        List<Menu_entity> mns = service.getAllMenu_234();
        
        for(Menu_entity e : mns){
            
            defaultTableModelMN.addRow(new Object[]{e.getIdP(),e.getNameC(),e.getNameP(),e.getPrice()});
        }
    }
    public void panelListManager(){
        listPanelManage.add(JpnEmployee_Manager);
        listPanelManage.add(Jpntable_Manager);
        listPanelManage.add(JpnMenu_Manager);
        listPanelManage.add(JpnAccount_Manager);
    }
    public void lableIsSelectedManage( int index){
        for (int i=0 ;i < listPanelManage.size(); i++){
            if(index == i)
                listPanelManage.get(i).setVisible(true);
            else
                listPanelManage.get(i).setVisible(false);
        }
          
    }
    public void labelListManager(){
        listLabelManage.add(JlbEmloyee_manager);
        listLabelManage.add(JlbTable_manager);
        listLabelManage.add(JlbMenu_manager);
        listLabelManage.add(JlbAccount_manager);
    }
    public void lableListIsSelected( int index){
        for (int i=0 ;i < listLabelManage.size(); i++){
            if(index == i)
                listLabelManage.get(i).setBackground(Color.cyan);
            else
                listLabelManage.get(i).setBackground(Color.white);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JlbEmloyee_manager = new javax.swing.JLabel();
        JlbTable_manager = new javax.swing.JLabel();
        JlbMenu_manager = new javax.swing.JLabel();
        JlbAccount_manager = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Jpntable_Manager = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTableManeger234 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        textFieldTotalTable234 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnEditTable234 = new javax.swing.JLabel();
        btnAddTable234 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnDeleteTable234 = new javax.swing.JLabel();
        comboBoxFloor234 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        JpnMenu_Manager = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDrinkManager234 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textFieldTotalDrink234 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnEditDrink234 = new javax.swing.JLabel();
        btnAddDrink234 = new javax.swing.JLabel();
        btnSearchDrink234 = new javax.swing.JLabel();
        textFieldNameDrink234 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnDeleteDrink234 = new javax.swing.JLabel();
        comboBoxTypeDrink234 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        JpnAccount_Manager = new javax.swing.JPanel();
        btnSearchUser234 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textFieldTotalAccount234 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnEditUser234 = new javax.swing.JLabel();
        btnDeleteUser234 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAcountManager234 = new javax.swing.JTable();
        btnSearchNameEmployee_234 = new javax.swing.JLabel();
        textFieldNameUser234 = new javax.swing.JTextField();
        textFieldNameEmloyee_234 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAddUser234 = new javax.swing.JLabel();
        JpnEmployee_Manager = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldNameEmployee234 = new javax.swing.JTextField();
        textFieldPosition234 = new javax.swing.JTextField();
        btnSearchNameEmployee234 = new javax.swing.JLabel();
        btnSearchPosition234 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployeeManager234 = new javax.swing.JTable();
        btnAddEmployee234 = new javax.swing.JLabel();
        btnEditEmployee234 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textFieldTotalEmployee234 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1260, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(69, 32, 16));

        JlbEmloyee_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbEmloyee_manager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JlbEmloyee_manager.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbEmloyee_manager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/More-People-icon.png"))); // NOI18N
        JlbEmloyee_manager.setText("     QUẢN LÝ NHÂN VIÊN ");
        JlbEmloyee_manager.setToolTipText("");
        JlbEmloyee_manager.setOpaque(true);
        JlbEmloyee_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbEmloyee_managerMouseClicked(evt);
            }
        });

        JlbTable_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbTable_manager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JlbTable_manager.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbTable_manager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        JlbTable_manager.setText("     QUẢN LÝ BÀN ");
        JlbTable_manager.setToolTipText("");
        JlbTable_manager.setOpaque(true);
        JlbTable_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbTable_managerMouseClicked(evt);
            }
        });

        JlbMenu_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbMenu_manager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JlbMenu_manager.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbMenu_manager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/menu_managerment_338.png"))); // NOI18N
        JlbMenu_manager.setText("     QUẢN LÝ MENU");
        JlbMenu_manager.setToolTipText("");
        JlbMenu_manager.setOpaque(true);
        JlbMenu_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbMenu_managerMouseClicked(evt);
            }
        });

        JlbAccount_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbAccount_manager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JlbAccount_manager.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbAccount_manager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/account_338.png"))); // NOI18N
        JlbAccount_manager.setText("     QUẢN LÝ TÀI KHOẢN");
        JlbAccount_manager.setToolTipText("");
        JlbAccount_manager.setOpaque(true);
        JlbAccount_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbAccount_managerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JlbAccount_manager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbTable_manager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbMenu_manager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbEmloyee_manager, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(JlbEmloyee_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(JlbTable_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(JlbMenu_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(JlbAccount_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        Jpntable_Manager.setBackground(new java.awt.Color(69, 32, 16));

        tableTableManeger234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        tableTableManeger234.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableTableManeger234);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 0));
        jLabel30.setText("YMACH COFFEE");

        textFieldTotalTable234.setText("...");
        textFieldTotalTable234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalTable234ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 0));
        jLabel31.setText("Tổng số bàn :");

        btnEditTable234.setBackground(new java.awt.Color(255, 255, 255));
        btnEditTable234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditTable234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditTable234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/document_edit.png"))); // NOI18N
        btnEditTable234.setText("SỬA ");
        btnEditTable234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 153, 153)));
        btnEditTable234.setOpaque(true);
        btnEditTable234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditTable234MouseClicked(evt);
            }
        });

        btnAddTable234.setBackground(new java.awt.Color(255, 255, 255));
        btnAddTable234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddTable234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddTable234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_add.png"))); // NOI18N
        btnAddTable234.setText("THÊM ");
        btnAddTable234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 153, 153)));
        btnAddTable234.setOpaque(true);
        btnAddTable234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTable234MouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 0));
        jLabel36.setText("Lầu :");

        btnDeleteTable234.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteTable234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteTable234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteTable234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_delete.png"))); // NOI18N
        btnDeleteTable234.setText("XOÁ");
        btnDeleteTable234.setToolTipText("");
        btnDeleteTable234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 153, 153)));
        btnDeleteTable234.setOpaque(true);
        btnDeleteTable234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteTable234MouseClicked(evt);
            }
        });

        comboBoxFloor234.setBackground(new java.awt.Color(204, 255, 204));
        comboBoxFloor234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxFloor234.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LẦU 1 ", "LẦU 2", "LẦU 3", " " }));
        comboBoxFloor234.setToolTipText("");
        comboBoxFloor234.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxFloor234ItemStateChanged(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Jpntable_ManagerLayout = new javax.swing.GroupLayout(Jpntable_Manager);
        Jpntable_Manager.setLayout(Jpntable_ManagerLayout);
        Jpntable_ManagerLayout.setHorizontalGroup(
            Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxFloor234, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalTable234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel26)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddTable234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditTable234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteTable234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        Jpntable_ManagerLayout.setVerticalGroup(
            Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(comboBoxFloor234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(btnAddTable234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEditTable234, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnDeleteTable234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(37, 37, 37)
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(textFieldTotalTable234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30))
                    .addComponent(jLabel26))
                .addGap(26, 26, 26))
        );

        jPanel3.add(Jpntable_Manager, "card4");

        JpnMenu_Manager.setBackground(new java.awt.Color(69, 32, 16));

        tableDrinkManager234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        tableDrinkManager234.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableDrinkManager234);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("YMACH COFFEE");

        textFieldTotalDrink234.setText("...");
        textFieldTotalDrink234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalDrink234ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 0));
        jLabel22.setText("Tổng số món :");

        btnEditDrink234.setBackground(new java.awt.Color(255, 255, 255));
        btnEditDrink234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditDrink234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditDrink234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/document_edit.png"))); // NOI18N
        btnEditDrink234.setText("SỬA ");
        btnEditDrink234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnEditDrink234.setOpaque(true);
        btnEditDrink234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditDrink234MouseClicked(evt);
            }
        });

        btnAddDrink234.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDrink234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddDrink234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddDrink234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_add.png"))); // NOI18N
        btnAddDrink234.setText("THÊM ");
        btnAddDrink234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnAddDrink234.setOpaque(true);
        btnAddDrink234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddDrink234MouseClicked(evt);
            }
        });

        btnSearchDrink234.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchDrink234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchDrink234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        btnSearchDrink234.setOpaque(true);

        textFieldNameDrink234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNameDrink234ActionPerformed(evt);
            }
        });
        textFieldNameDrink234.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldNameDrink234KeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 0));
        jLabel27.setText("Tên đồ uống :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 0));
        jLabel28.setText("Loại đồ uống :");

        btnDeleteDrink234.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteDrink234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteDrink234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteDrink234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_delete.png"))); // NOI18N
        btnDeleteDrink234.setText("XOÁ");
        btnDeleteDrink234.setToolTipText("");
        btnDeleteDrink234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnDeleteDrink234.setOpaque(true);
        btnDeleteDrink234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteDrink234MouseClicked(evt);
            }
        });

        comboBoxTypeDrink234.setBackground(new java.awt.Color(204, 255, 204));
        comboBoxTypeDrink234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxTypeDrink234.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cà Phê", "Trà ", "Trà Sứa", "Sinh tố, Nước ép", " " }));
        comboBoxTypeDrink234.setToolTipText("");
        comboBoxTypeDrink234.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTypeDrink234ItemStateChanged(evt);
            }
        });

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnMenu_ManagerLayout = new javax.swing.GroupLayout(JpnMenu_Manager);
        JpnMenu_Manager.setLayout(JpnMenu_ManagerLayout);
        JpnMenu_ManagerLayout.setHorizontalGroup(
            JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTypeDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNameDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel20)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddDrink234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditDrink234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteDrink234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        JpnMenu_ManagerLayout.setVerticalGroup(
            JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)
                        .addComponent(comboBoxTypeDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearchDrink234, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(textFieldNameDrink234))
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnAddDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnDeleteDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(37, 37, 37)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(textFieldTotalDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21))
                    .addComponent(jLabel20))
                .addGap(26, 26, 26))
        );

        jPanel3.add(JpnMenu_Manager, "card5");

        JpnAccount_Manager.setBackground(new java.awt.Color(59, 32, 16));

        btnSearchUser234.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchUser234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchUser234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        btnSearchUser234.setOpaque(true);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("YMACH COFFEE");

        textFieldTotalAccount234.setText("...");
        textFieldTotalAccount234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalAccount234ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("Tổng số tài khoản :");

        btnEditUser234.setBackground(new java.awt.Color(255, 255, 255));
        btnEditUser234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditUser234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditUser234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/document_edit.png"))); // NOI18N
        btnEditUser234.setText("SỬA ");
        btnEditUser234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnEditUser234.setOpaque(true);
        btnEditUser234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditUser234MouseClicked(evt);
            }
        });

        btnDeleteUser234.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteUser234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteUser234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteUser234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_delete.png"))); // NOI18N
        btnDeleteUser234.setText("Xoá");
        btnDeleteUser234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnDeleteUser234.setOpaque(true);

        tableAcountManager234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        tableAcountManager234.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableAcountManager234);

        btnSearchNameEmployee_234.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchNameEmployee_234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchNameEmployee_234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        btnSearchNameEmployee_234.setOpaque(true);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Tên User:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Tên Nhân Viên :");

        btnAddUser234.setBackground(new java.awt.Color(255, 255, 255));
        btnAddUser234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddUser234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddUser234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_add_338.png"))); // NOI18N
        btnAddUser234.setText("THÊM ");
        btnAddUser234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnAddUser234.setOpaque(true);
        btnAddUser234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddUser234MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpnAccount_ManagerLayout = new javax.swing.GroupLayout(JpnAccount_Manager);
        JpnAccount_Manager.setLayout(JpnAccount_ManagerLayout);
        JpnAccount_ManagerLayout.setHorizontalGroup(
            JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalAccount234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnAccount_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel11)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNameEmloyee_234, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchNameEmployee_234, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnAccount_ManagerLayout.createSequentialGroup()
                                .addComponent(textFieldNameUser234, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchUser234, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnAccount_ManagerLayout.createSequentialGroup()
                                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditUser234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddUser234, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(btnDeleteUser234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))))))
        );
        JpnAccount_ManagerLayout.setVerticalGroup(
            JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearchNameEmployee_234, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSearchUser234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(textFieldNameEmloyee_234, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNameUser234, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnAddUser234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnEditUser234, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDeleteUser234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(71, 71, 71)
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textFieldTotalAccount234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addComponent(jLabel11))
                .addGap(26, 26, 26))
        );

        jPanel3.add(JpnAccount_Manager, "card5");

        JpnEmployee_Manager.setBackground(new java.awt.Color(69, 32, 16));
        JpnEmployee_Manager.setForeground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tên Nhân Viên :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Chức Vụ:");

        textFieldNameEmployee234.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldNameEmployee234KeyReleased(evt);
            }
        });

        textFieldPosition234.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldPosition234KeyReleased(evt);
            }
        });

        btnSearchNameEmployee234.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchNameEmployee234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchNameEmployee234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        btnSearchNameEmployee234.setOpaque(true);

        btnSearchPosition234.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchPosition234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearchPosition234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        btnSearchPosition234.setOpaque(true);

        tableEmployeeManager234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        tableEmployeeManager234.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableEmployeeManager234);

        btnAddEmployee234.setBackground(new java.awt.Color(255, 255, 255));
        btnAddEmployee234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddEmployee234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddEmployee234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/file_add.png"))); // NOI18N
        btnAddEmployee234.setText("THÊM ");
        btnAddEmployee234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnAddEmployee234.setOpaque(true);
        btnAddEmployee234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddEmployee234MouseClicked(evt);
            }
        });

        btnEditEmployee234.setBackground(new java.awt.Color(255, 255, 255));
        btnEditEmployee234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditEmployee234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditEmployee234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/document_edit.png"))); // NOI18N
        btnEditEmployee234.setText("SỬA ");
        btnEditEmployee234.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 1, 1, new java.awt.Color(0, 204, 204)));
        btnEditEmployee234.setOpaque(true);
        btnEditEmployee234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditEmployee234MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Tổng số nhân viên :");

        textFieldTotalEmployee234.setText("...");
        textFieldTotalEmployee234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalEmployee234ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("YMACH COFFEE");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnEmployee_ManagerLayout = new javax.swing.GroupLayout(JpnEmployee_Manager);
        JpnEmployee_Manager.setLayout(JpnEmployee_ManagerLayout);
        JpnEmployee_ManagerLayout.setHorizontalGroup(
            JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldPosition234, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchPosition234, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel9)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddEmployee234, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(btnEditEmployee234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))))
        );
        JpnEmployee_ManagerLayout.setVerticalGroup(
            JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchPosition234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(textFieldNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldPosition234, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addComponent(btnAddEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnEditEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addComponent(btnSearchNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textFieldTotalEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(jLabel9))
                .addGap(19, 19, 19))
        );

        jPanel3.add(JpnEmployee_Manager, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlbEmloyee_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbEmloyee_managerMouseClicked
        // TODO add your handling code here:
        lableIsSelectedManage(0);
        lableListIsSelected(0);
        
    }//GEN-LAST:event_JlbEmloyee_managerMouseClicked

    private void JlbTable_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbTable_managerMouseClicked
        lableIsSelectedManage(1);
        lableListIsSelected(1);
    }//GEN-LAST:event_JlbTable_managerMouseClicked

    private void JlbMenu_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbMenu_managerMouseClicked
        lableIsSelectedManage(2);
        lableListIsSelected(2);
    }//GEN-LAST:event_JlbMenu_managerMouseClicked

    private void JlbAccount_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAccount_managerMouseClicked
        lableIsSelectedManage(3);
        lableListIsSelected(3);
    }//GEN-LAST:event_JlbAccount_managerMouseClicked

    private void textFieldTotalEmployee234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalEmployee234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalEmployee234ActionPerformed

    private void textFieldTotalAccount234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalAccount234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalAccount234ActionPerformed

    private void textFieldTotalDrink234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalDrink234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalDrink234ActionPerformed

    private void textFieldTotalTable234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalTable234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalTable234ActionPerformed

    private void btnAddEmployee234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddEmployee234MouseClicked
        AddEmployee ae = new AddEmployee();
        ae.setVisible(true);
        
    }//GEN-LAST:event_btnAddEmployee234MouseClicked

    private void btnEditEmployee234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditEmployee234MouseClicked
        EditEmployee ee = new EditEmployee();
        ee.setVisible(true);
    }//GEN-LAST:event_btnEditEmployee234MouseClicked

    private void btnAddTable234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTable234MouseClicked
        AddTable at = new AddTable();
        at.setVisible(true);
    }//GEN-LAST:event_btnAddTable234MouseClicked

    private void btnEditTable234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditTable234MouseClicked
        EditTable at = new EditTable();
        at.setVisible(true);
    }//GEN-LAST:event_btnEditTable234MouseClicked

    private void btnDeleteTable234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteTable234MouseClicked
        int row = tableTableManeger234.getSelectedRow();
        if (row ==-1){
            JOptionPane.showMessageDialog(Coffee_management_general.this,"Vui lòng chọn bàn muốn xóa trươc","Lỗi",JOptionPane.ERROR_MESSAGE);
        }else{
            int id = Integer.valueOf(String.valueOf(tableTableManeger234.getValueAt(row,0)));
            service.deleteTable(id);
            defaultTableModelTB.setRowCount(0);
            List<Table> tbs = service.getAllTable_234();

            for(Table e : tbs){
                defaultTableModelTB.addRow(new Object[]{e.getId(),e.getTang(),e.getBan(),});
            }
        }
    }//GEN-LAST:event_btnDeleteTable234MouseClicked

    private void btnAddDrink234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDrink234MouseClicked
        AddMenu at = new AddMenu();
        at.setVisible(true);
    }//GEN-LAST:event_btnAddDrink234MouseClicked

    private void btnEditDrink234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditDrink234MouseClicked
        EditMenu at = new EditMenu();
        at.setVisible(true);
    }//GEN-LAST:event_btnEditDrink234MouseClicked

    private void btnAddUser234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUser234MouseClicked
        AddAccount at = new AddAccount();
        at.setVisible(true);
    }//GEN-LAST:event_btnAddUser234MouseClicked

    private void btnEditUser234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditUser234MouseClicked
        EditAccount at = new EditAccount();
        at.setVisible(true);
    }//GEN-LAST:event_btnEditUser234MouseClicked

    private void textFieldNameDrink234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNameDrink234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNameDrink234ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        List<Employee_entity> emp = service.getAllEmployee_234();
        
        for(Employee_entity e : emp){
            System.out.println(e.getPassword());
            defaultTableModel.addRow(new Object[]{e.getId(),e.getTennv(),e.getNgayVaoLam(),e.getSoDienThoai(),e.getChucVu(),e.getUserName(),e.getPassword()});
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textFieldNameEmployee234KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNameEmployee234KeyReleased
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        List<Employee_entity> emp = service.searchEmployee_234(textFieldNameEmployee234.getText());
        
        for(Employee_entity e : emp){
            System.out.println(e.getPassword());
            defaultTableModel.addRow(new Object[]{e.getId(),e.getTennv(),e.getNgayVaoLam(),e.getSoDienThoai(),e.getChucVu(),e.getUserName(),e.getPassword()});
        }
    }//GEN-LAST:event_textFieldNameEmployee234KeyReleased

    private void textFieldPosition234KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldPosition234KeyReleased
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        List<Employee_entity> emp = service.searchCVEmployee_234(textFieldPosition234.getText());
        
        for(Employee_entity e : emp){
            System.out.println(e.getPassword());
            defaultTableModel.addRow(new Object[]{e.getId(),e.getTennv(),e.getNgayVaoLam(),e.getSoDienThoai(),e.getChucVu(),e.getUserName(),e.getPassword()});
        }
    }//GEN-LAST:event_textFieldPosition234KeyReleased

    private void comboBoxFloor234ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxFloor234ItemStateChanged
        // TODO add your handling code here:
        defaultTableModelTB.setRowCount(0);
        List<Table> tbs = service.getAllTable_234(comboBoxFloor234.getSelectedIndex()+1);
        
        for(Table e : tbs){
            defaultTableModelTB.addRow(new Object[]{e.getId(),e.getTang(),e.getBan(),});
        }
    }//GEN-LAST:event_comboBoxFloor234ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        defaultTableModelTB.setRowCount(0);
        List<Table> tbs = service.getAllTable_234();
        
        for(Table e : tbs){
            defaultTableModelTB.addRow(new Object[]{e.getId(),e.getTang(),e.getBan(),});
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboBoxTypeDrink234ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTypeDrink234ItemStateChanged
        // TODO add your handling code here:
        defaultTableModelMN.setRowCount(0);
            List<Menu_entity> mns = service.getAllMenu1_234(String.valueOf(comboBoxTypeDrink234.getSelectedItem()).trim());
        
        for(Menu_entity e : mns){
            
            defaultTableModelMN.addRow(new Object[]{e.getIdP(),e.getNameC(),e.getNameP(),e.getPrice()});
        }
    }//GEN-LAST:event_comboBoxTypeDrink234ItemStateChanged

    private void textFieldNameDrink234KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNameDrink234KeyReleased
        // TODO add your handling code here:
         defaultTableModelMN.setRowCount(0);
            List<Menu_entity> mns = service.getAllMenu_234(String.valueOf(textFieldNameDrink234.getText()).trim());
        
        for(Menu_entity e : mns){
            
            defaultTableModelMN.addRow(new Object[]{e.getIdP(),e.getNameC(),e.getNameP(),e.getPrice()});
        }
    }//GEN-LAST:event_textFieldNameDrink234KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        defaultTableModelMN.setRowCount(0);
            List<Menu_entity> mns = service.getAllMenu_234();
        
        for(Menu_entity e : mns){
            
            defaultTableModelMN.addRow(new Object[]{e.getIdP(),e.getNameC(),e.getNameP(),e.getPrice()});
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDeleteDrink234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDrink234MouseClicked
        // TODO add your handling code here:
        int row = tableDrinkManager234.getSelectedRow();
        if (row ==-1){
            JOptionPane.showMessageDialog(Coffee_management_general.this,"Vui lòng chọn bàn muốn xóa trươc","Lỗi",JOptionPane.ERROR_MESSAGE);
        }else{
            int id = Integer.valueOf(String.valueOf(tableDrinkManager234.getValueAt(row,0)));
            service.deleteMenu(id);
            defaultTableModelMN.setRowCount(0);
            List<Menu_entity> mns = service.getAllMenu_234();
        
        for(Menu_entity e : mns){
            
            defaultTableModelMN.addRow(new Object[]{e.getIdP(),e.getNameC(),e.getNameP(),e.getPrice()});
        }
        }
    }//GEN-LAST:event_btnDeleteDrink234MouseClicked

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
            java.util.logging.Logger.getLogger(Coffee_management_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Coffee_management_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Coffee_management_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Coffee_management_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Coffee_management_general().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlbAccount_manager;
    private javax.swing.JLabel JlbEmloyee_manager;
    private javax.swing.JLabel JlbMenu_manager;
    private javax.swing.JLabel JlbTable_manager;
    private javax.swing.JPanel JpnAccount_Manager;
    private javax.swing.JPanel JpnEmployee_Manager;
    private javax.swing.JPanel JpnMenu_Manager;
    private javax.swing.JPanel Jpntable_Manager;
    private javax.swing.JLabel btnAddDrink234;
    private javax.swing.JLabel btnAddEmployee234;
    private javax.swing.JLabel btnAddTable234;
    private javax.swing.JLabel btnAddUser234;
    private javax.swing.JLabel btnDeleteDrink234;
    private javax.swing.JLabel btnDeleteTable234;
    private javax.swing.JLabel btnDeleteUser234;
    private javax.swing.JLabel btnEditDrink234;
    private javax.swing.JLabel btnEditEmployee234;
    private javax.swing.JLabel btnEditTable234;
    private javax.swing.JLabel btnEditUser234;
    private javax.swing.JLabel btnSearchDrink234;
    private javax.swing.JLabel btnSearchNameEmployee234;
    private javax.swing.JLabel btnSearchNameEmployee_234;
    private javax.swing.JLabel btnSearchPosition234;
    private javax.swing.JLabel btnSearchUser234;
    private javax.swing.JComboBox<String> comboBoxFloor234;
    private javax.swing.JComboBox<String> comboBoxTypeDrink234;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableAcountManager234;
    private javax.swing.JTable tableDrinkManager234;
    private javax.swing.JTable tableEmployeeManager234;
    private javax.swing.JTable tableTableManeger234;
    private javax.swing.JTextField textFieldNameDrink234;
    private javax.swing.JTextField textFieldNameEmloyee_234;
    private javax.swing.JTextField textFieldNameEmployee234;
    private javax.swing.JTextField textFieldNameUser234;
    private javax.swing.JTextField textFieldPosition234;
    private javax.swing.JTextField textFieldTotalAccount234;
    private javax.swing.JTextField textFieldTotalDrink234;
    private javax.swing.JTextField textFieldTotalEmployee234;
    private javax.swing.JTextField textFieldTotalTable234;
    // End of variables declaration//GEN-END:variables
}
