/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.coffee_management.view;

import com.java.coffee_management.dao.CategoryDao;
import com.java.coffee_management.dao.ProductDao;
import com.java.coffee_management.dao.TableDao;
import com.java.coffee_management.model.Product;
import com.java.coffee_management.model.RawOrder;
import com.java.coffee_management.model.Size;
import com.java.coffee_management.model.Table;
import com.java.coffee_management.view.sale.OrderDetail;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SaleMain extends javax.swing.JFrame {

    private final TableDao tbDao = new TableDao();
    private final CategoryDao cateDao = new CategoryDao();
    DefaultTableModel dfTableModelProduct;
    public static DefaultTableModel dfTableModelOrder;
    ProductDao proDao = new ProductDao();
    public static List<RawOrder> rawOrderList = new ArrayList<>();

    public SaleMain() {
        initComponents();
        fillTable("Tất cả");
        for (String i : tbDao.getAllArea()) {
            areaComboBox.addItem(i);
        }
        for (String i : cateDao.getAll()) {
            categoryComboBox.addItem(i);
        }
        dfTableModelProduct = new DefaultTableModel(new Object[]{"Id", "Name", "Price", "Category"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        productTable.setModel(dfTableModelProduct);
        fillTableProduct(proDao.getAllProduct());
        dfTableModelOrder = new DefaultTableModel(new Object[]{"Product", "Size", "Price", "Quantity"}, 0);
        orderTable.setModel(dfTableModelOrder);
        orderTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    public void fillTableProduct(List<Product> products) {
        products.forEach(product -> {
            dfTableModelProduct.addRow(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getCategory().getName()});
        });
    }

    public static void fillTableOrder(Product product, int quantity, String size) {
        RawOrder rawOrder = new RawOrder(product, size, quantity);
        boolean isEquals = false;
        if (rawOrderList != null) {
            for (int i = 0; i < rawOrderList.size(); i++) {
                if ((rawOrder.getProduct().getName().equals(rawOrderList.get(i).getProduct().getName()) && (rawOrder.getSize().equalsIgnoreCase(rawOrderList.get(i).getSize())))) {
                    isEquals = true;
                    break;
                }
            }
        }
        if (!isEquals) {
            dfTableModelOrder.addRow(new Object[]{product.getName(), size, product.getPrice(), quantity});
            rawOrderList.add(rawOrder);
        }
        
    }

    public void fillTable(String area) {
        tablePanel.removeAll();
        tablePanel.updateUI();
        List<Table> tables = new ArrayList<>();
        if (area.equalsIgnoreCase("Tất cả")) {
            tables = tbDao.getAll();
        } else {
            tables = tbDao.getAllByArea(area);
        }
        JButton[] listBtn = new JButton[tables.size()];
        for (int i = 0; i < listBtn.length; i++) {
            listBtn[i] = new JButton();
            listBtn[i].setText(String.valueOf(tables.get(i).getId()));
            listBtn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png")));
            if (tables.get(i).getState().equalsIgnoreCase("Đang phục vụ")) {
                listBtn[i].setBackground(Color.decode("#FF6666"));
                listBtn[i].setBorderPainted(false);
            }
            listBtn[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    banLabel.setText(btn.getText());
                }
            });
            tablePanel.add(listBtn[i]);
        }
        tablePanel.updateUI();
    }
    public void fillTongTien(){
        Double sum = 0.0;
        for(RawOrder r : rawOrderList) {
            System.out.println(r);
            Size size = proDao.getSizeByName(r.getSize());
            sum+= (r.getQuantity()*(r.getProduct().getPrice()+size.getMorePrice()));
        }
        tongTienTextField.setText(String.valueOf(sum));
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

        SalePanel307 = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        contenPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        areaComboBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        productPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        categoryComboBox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        orderPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        banLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tongTienTextField = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        huyButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        thanhToanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        SalePanel307.setBackground(new java.awt.Color(255, 255, 255));
        SalePanel307.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SalePanel307.setLayout(new javax.swing.BoxLayout(SalePanel307, javax.swing.BoxLayout.LINE_AXIS));

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftPanel.setPreferredSize(new java.awt.Dimension(350, 750));

        contenPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Welcome To YMACH Coffee");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setLabelFor(jLabel3);
        jLabel3.setText("Trống");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setBackground(new java.awt.Color(255, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setLabelFor(jPanel5);
        jLabel4.setText("Đang Phục Vụ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        areaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaComboBoxActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Tầng");

        javax.swing.GroupLayout contenPanelLayout = new javax.swing.GroupLayout(contenPanel);
        contenPanel.setLayout(contenPanelLayout);
        contenPanelLayout.setHorizontalGroup(
            contenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenPanelLayout.createSequentialGroup()
                .addGroup(contenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(contenPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        contenPanelLayout.setVerticalGroup(
            contenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel18))
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablePanel.setLayout(new java.awt.GridLayout(5, 4, 20, 20));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(contenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SalePanel307.add(leftPanel);

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightPanel.setLayout(new java.awt.GridBagLayout());

        productPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        productTable.setToolTipText("");
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(productTable);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Loại");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tìm kiếm");

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))))
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 12, 0, 2);
        rightPanel.add(productPanel, gridBagConstraints);

        orderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Order"));
        orderPanel.setPreferredSize(new java.awt.Dimension(850, 500));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        orderTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                orderTableFocusLost(evt);
            }
        });
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                orderTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                orderTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                orderTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Bàn");

        banLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        banLabel.setForeground(new java.awt.Color(0, 204, 204));
        banLabel.setText("jLabel5");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tổng tiền");

        tongTienTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tongTienTextFieldCaretUpdate(evt);
            }
        });
        tongTienTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tongTienTextFieldActionPerformed(evt);
            }
        });
        tongTienTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tongTienTextFieldKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Chiết khấu");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Thành tiền");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Tiền khách đưa");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Còn lại");

        huyButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        huyButton.setText("Huỷ HĐ");
        huyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huyButtonMouseClicked(evt);
            }
        });

        orderButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orderButton.setText("Order");

        thanhToanButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        thanhToanButton.setText("Thanh Toán");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(banLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(38, 38, 38))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(46, 46, 46)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tongTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(38, 38, 38)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(59, 59, 59)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(thanhToanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(huyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(banLabel))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tongTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(huyButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thanhToanButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = -12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 2, 2);
        rightPanel.add(orderPanel, gridBagConstraints);

        SalePanel307.add(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1201, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SalePanel307, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SalePanel307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void areaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaComboBoxActionPerformed
        String itemSelected = areaComboBox.getItemAt(areaComboBox.getSelectedIndex());
        if (itemSelected.equals("Tầng 1"))
            fillTable("Tầng 1");
        else if (itemSelected.equals("Tầng 2"))
            fillTable("Tầng 2");
        else if (itemSelected.equals("Tầng 3"))
            fillTable("Tầng 3");
        else
            fillTable("Tất cả");
    }//GEN-LAST:event_areaComboBoxActionPerformed

    private void huyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_huyButtonMouseClicked

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = 0;
        int id = (int) source.getModel().getValueAt(row, column);
        OrderDetail orderD = new OrderDetail(proDao.getById(id));
        orderD.setVisible(true);
    }//GEN-LAST:event_productTableMouseClicked

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked

    }//GEN-LAST:event_orderTableMouseClicked

    private void orderTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseEntered

    }//GEN-LAST:event_orderTableMouseEntered

    private void orderTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderTableFocusGained

    }//GEN-LAST:event_orderTableFocusGained

    private void orderTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseReleased

    }//GEN-LAST:event_orderTableMouseReleased

    private void orderTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderTableMousePressed

    private void orderTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderTableFocusLost
        int var = JOptionPane.showConfirmDialog(this, "Bạn muốn xoá món này ?");
        
        if(var == JOptionPane.YES_OPTION && rawOrderList != null){
            String productName = orderTable.getValueAt(orderTable.getSelectedRow(),0) + "";
            Product pr = proDao.getByName(productName);
            Iterator<RawOrder> itr = rawOrderList.iterator();
            while (itr.hasNext()) {
                RawOrder next = itr.next();
                if(next.getProduct().getId() == pr.getId())
                    rawOrderList.remove(next);
            }
            dfTableModelOrder.removeRow(orderTable.getSelectedRow());
        }
    }//GEN-LAST:event_orderTableFocusLost

    private void tongTienTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tongTienTextFieldActionPerformed
        
    }//GEN-LAST:event_tongTienTextFieldActionPerformed

    private void tongTienTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tongTienTextFieldCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_tongTienTextFieldCaretUpdate

    private void tongTienTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tongTienTextFieldKeyReleased
        
        
    }//GEN-LAST:event_tongTienTextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SaleMain().setVisible(true);
                }
            });

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaleMain.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(SaleMain.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(SaleMain.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SaleMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SalePanel307;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JLabel banLabel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JPanel contenPanel;
    private javax.swing.JButton huyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton orderButton;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JTable orderTable;
    private javax.swing.JPanel productPanel;
    private javax.swing.JTable productTable;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton thanhToanButton;
    private javax.swing.JTextField tongTienTextField;
    // End of variables declaration//GEN-END:variables
}
