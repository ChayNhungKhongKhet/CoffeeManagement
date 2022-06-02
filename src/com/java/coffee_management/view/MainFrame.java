/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.coffee_management.view;


import com.java.coffee_management.dao.SQLHandler;
import com.sun.jdi.connect.spi.Connection;

import com.java.coffee_management.Dao.Dao;
import com.java.coffee_management.Service.Service;
import com.java.coffee_management.entity.Employee_entity;
import com.java.coffee_management.entity.Menu_entity;
import com.java.coffee_management.entity.Table;
import com.java.coffee_management.entity.category;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Admin
 */
public class MainFrame extends javax.swing.JFrame {
    
    CardLayout card;
    List<JPanel> listPanelViewWarehouse = new ArrayList<>();
    List<JButton> listButtonViewWarehouse = new ArrayList<>();
    List<JPanel> listPanelManage = new ArrayList<>();
    List<JLabel> listLabelManage = new ArrayList<>();
    List<JPanel> listPanelStatistical = new ArrayList<>();
    List<JButton> listButtonStatistical = new ArrayList<>();

    public final SQLHandler sqlHandler = new SQLHandler();
    public DefaultTableModel dftableTKHoaDonModel = new DefaultTableModel();
    public DefaultTableModel dftableTKKhoModel = new DefaultTableModel();
    String datefrom, dateto;
    double tongtienhd, tongtiennhap, tongluongnv;

    Dao dao = new Dao();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    DefaultTableModel defaultTableModelTB = new DefaultTableModel();
    DefaultTableModel defaultTableModelMN = new DefaultTableModel();
    Service service = new Service();


    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        card = (CardLayout) mainPanel307.getLayout();
        card.show(mainPanel307, "bannerPanel");
        panelListManager();
        labelListManager();
        panelListStatiscal();
        buttonListStatistical();
        panelListViewWarehouse();
        buttonListViewWarehouse();

        setTableTKHoaDon338();
        setTableTKKho338();
        tongtienthuve338();
        tongtiennhapkho338();
        bieudo338();

        
        //Vũ Lê Na
        textFieldTotalEmployee234.setText(String.valueOf(service.demNV()));
        textFieldTotalTable234.setText(String.valueOf(service.demBan()));
        textFieldTotalDrink234.setText(String.valueOf(service.demMenu()));
        comboBoxTypeDrink234.removeAllItems();
        List<category> cts = new ArrayList<>();
        cts = service.getAllCategory_234();
        for (category c:cts){
            comboBoxTypeDrink234.addItem(c.getName());
        }
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
        //END

    }
    
    public void panelListStatiscal() {
        listPanelStatistical.add(PanelBill338);
        listPanelStatistical.add(PanelSalary338);
        listPanelStatistical.add(PanelWareHouse338);
        listPanelStatistical.add(PanelSales338);
    }
    
    public void panelIsSelectedStatistical(int index) {
        for (int i = 0; i < listPanelStatistical.size(); i++) {
            if (index == i) {
                listPanelStatistical.get(i).setVisible(true);
            } else {
                listPanelStatistical.get(i).setVisible(false);
            }
        }
        
    }

    
    public void buttonListManager() {


    public void buttonListStatistical() {
        listButtonStatistical.add(btnStatisBill338);
        listButtonStatistical.add(btnStatisSalary338);
        listButtonStatistical.add(btnStatisWareH338);
        listButtonStatistical.add(btnStatisLN338);
    }
    
    public void buttonListIsSelected(int index) {
        for (int i = 0; i < listButtonStatistical.size(); i++) {
            if (index == i) {
                listButtonStatistical.get(i).setBackground(Color.cyan);
            } else {
                listButtonStatistical.get(i).setBackground(Color.white);
            }
        }
    }
    
    public void panelListManager() {
        listPanelManage.add(JpnEmployee_Manager);
        listPanelManage.add(Jpntable_Manager);
        listPanelManage.add(JpnMenu_Manager);
    }
    
    public void lableIsSelectedManage(int index) {
        for (int i = 0; i < listPanelManage.size(); i++) {
            if (index == i) {
                listPanelManage.get(i).setVisible(true);
            } else {
                listPanelManage.get(i).setVisible(false);
            }
        }
        
    }
    
    public void labelListManager() {
        listLabelManage.add(JlbEmloyee_manager);
        listLabelManage.add(JlbTable_manager);
        listLabelManage.add(JlbMenu_manager);
    }
    
    public void lableListIsSelected(int index) {
        for (int i = 0; i < listLabelManage.size(); i++) {
            if (index == i) {
                listLabelManage.get(i).setBackground(Color.cyan);
            } else {
                listLabelManage.get(i).setBackground(Color.white);
            }
        }
    }
    
    public void panelListViewWarehouse() {
        listPanelViewWarehouse.add(jpnPurchase);
        listPanelViewWarehouse.add(jpnWarehouse);
        listPanelViewWarehouse.add(jpnInventory);
        listPanelViewWarehouse.add(jpnIngredientsList);
        listPanelViewWarehouse.add(jpnSupplierInformation);
    }
    
    public void panelIsSelectedWarehouse(int index) {
        for (int i = 0; i < listPanelViewWarehouse.size(); i++) {
            if (index == i) {
                listPanelViewWarehouse.get(i).setVisible(true);
            } else {
                listPanelViewWarehouse.get(i).setVisible(false);
            }
        }
        
    }
    
    public void buttonListViewWarehouse() {
        listButtonViewWarehouse.add(btnNhapMua111);
        listButtonViewWarehouse.add(btnNhapKho111);
        listButtonViewWarehouse.add(btnKiiemKe111);
        listButtonViewWarehouse.add(btnDanhMuc111);
        listButtonViewWarehouse.add(btnThongTinNCC111);
        
    }
    
    public void buttonListIsSelectedWarehouse(int index) {
        for (int i = 0; i < listButtonViewWarehouse.size(); i++) {
            if (index == i) {
                listButtonViewWarehouse.get(i).setBackground(Color.cyan);
            } else {
                listButtonViewWarehouse.get(i).setBackground(Color.white);
            }
        }
    }

/////////////////////////////////////////////////////THONG KE////////////////////////////////////////////////////////////////////
    // SHOW DATA
    /// BILL
    public void setTableTKHoaDon338() {
        String columns[] = {
            "Mã hóa đơn", "Thời gian", "Bàn", "Thành tiền"
        };
        dftableTKHoaDonModel.setColumnIdentifiers(columns);
        tblReceipt338.setModel(dftableTKHoaDonModel);
        showDataTKHoaDon338();
    }
    
    public void showDataTKHoaDon338() {
        try {
            ResultSet rs = sqlHandler.getAllDataTKHoaDon338();
            while (rs.next()) {
                Object[] rows = {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
                };
                dftableTKHoaDonModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // KHO
    public void setTableTKKho338() {
        String columns[] = {
            "Mã hóa đơn", "Mã nhà cung cấp", "Tên nhà cung cấp", "Thời gian", "Mã nguyên liệu", "Số lượng", "Giá", "Thành tiền"
        };
        dftableTKKhoModel.setColumnIdentifiers(columns);
        tbSale338.setModel(dftableTKKhoModel);
        showDataTKKho338();
    }
    
    public void showDataTKKho338() {
        try {
            ResultSet rs = sqlHandler.getAllDataTKKho338();
            while (rs.next()) {
                Object[] rows = {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                };
                dftableTKKhoModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void clearTableTKKho338(DefaultTableModel dftableModel) {
        int n = dftableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            dftableModel.removeRow(i);
        }
    }

    public void showDataTKKhoDesc338() {
        try {
            ResultSet rs = sqlHandler.getAllDataTKKhoDesc338();
            while (rs.next()) {
                Object[] rows = {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                };
                dftableTKKhoModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showDataTKKhoAsc338() {
        try {
            ResultSet rs = sqlHandler.getAllDataTKKhoAsc338();
            while (rs.next()) {
                Object[] rows = {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                };
                dftableTKKhoModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    DecimalFormat df = new DecimalFormat("#");
/////////////////////////////////////////////////////THONG KE////////////////////////////////////////////////////////////////////
    // Tổng tiền

    public void tongtienthuve338() {
        double tongtien = 0;
        int row = tblReceipt338.getRowCount();
        for (int i = 0; i < row; i++) {
            tongtien += Double.valueOf(tblReceipt338.getModel().getValueAt(i, 3).toString()) * 1000;
        }
        lbCollectedMoney338.setText("" +  df.format(tongtien) + "  VNĐ");
        tongtienhd = Double.valueOf(df.format(tongtien));
        
    }
    
     public void tongtiennhapkho338() {
        double tongtien = 0;
        int row = tbSale338.getRowCount();
        for (int i = 0; i < row; i++) {
            tongtien += Double.valueOf(tbSale338.getModel().getValueAt(i, 7).toString()) * 1000;
        }
        lbSalesMoney_338.setText("" +  df.format(tongtien) + "  VNĐ");
        tongtiennhap = Double.valueOf(df.format(tongtien));
    }
     
     public void bieudo338() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(tongtienhd, "Tiền", "Tổng tiền hóa đơn");
        dataset.addValue(tongtiennhap, "Tiền", "Tổng tiền nhập");
        dataset.addValue(60000, "Tiền", "Tổng tiền lương nhân viên");
        JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ THỐNG KÊ", "Loại", "Tiền",dataset);
        CategoryPlot lineCategoryPlot = barChart.getCategoryPlot();
        lineCategoryPlot.setRangeGridlinePaint(Color.BLACK);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(panelChart338.getWidth(), 300));
        panelChart338.removeAll();
        panelChart338.setLayout(new CardLayout());
        panelChart338.add(chartPanel);
        panelChart338.validate();
        panelChart338.repaint();
     }
     
 //////////////////////////////////////////////////////////THONG KE/////////////////////////////////////////////////
     
     public void countTKHDB338() {
         int count = 0;
         
         ResultSet rs = sqlHandler.getCountTKHDB338();
         try {
             while(rs.next()) {
                 count = rs.getInt(1);
             }
         } catch (Exception e) {
         }
         lbTKHDB338.setText("" + count);
     }
      public void countTKHDN338() {
         int count = 0;
         
         ResultSet rs = sqlHandler.getCountTKHDN338();
         try {
             while(rs.next()) {
                 count = rs.getInt(1);
             }
         } catch (Exception e) {
         }
         lbTKHBN338.setText("" + count);
     }
       public void countTKNV338() {
         int count = 0;
         
         ResultSet rs = sqlHandler.getCountTKNV338();
         try {
             while(rs.next()) {
                 count = rs.getInt(1);
             }
         } catch (Exception e) {
         }
         lbTKNV338.setText("" + count);
     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        functionPanel307 = new javax.swing.JPanel();
        btnSell307 = new javax.swing.JButton();
        btnManage307 = new javax.swing.JButton();
        btnStatistical307 = new javax.swing.JButton();
        btnWarehouse307 = new javax.swing.JButton();
        logOutButton307 = new javax.swing.JButton();
        mainPanel307 = new javax.swing.JPanel();
        bannerPanel307 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        panelAll338 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelMenu338 = new javax.swing.JPanel();
        btnStatisSalary338 = new javax.swing.JButton();
        btnStatisBill338 = new javax.swing.JButton();
        btnStatisWareH338 = new javax.swing.JButton();
        btnStatisLN338 = new javax.swing.JButton();
        PanelDetails338 = new javax.swing.JPanel();
        PanelBill338 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PanelRevenueManagerment338 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnRevenue338 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        btnXuatExcel338 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblReceipt338 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbCollectedMoney338 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PanelSalary338 = new javax.swing.JPanel();
        PanelAllSalary307 = new javax.swing.JPanel();
        PanelNorthSalary307 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbbSalarySort307 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        dateChooser4 = new com.toedter.calendar.JDateChooser();
        btnSalary307 = new javax.swing.JButton();
        btnXuatExcelSalary307 = new javax.swing.JButton();
        PanelCenterSalary307 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSalary307 = new javax.swing.JTable();
        PanelSouthSalary307 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbSalaryTotal307 = new javax.swing.JLabel();
        PanelWareHouse338 = new javax.swing.JPanel();
        PanelAllWare338 = new javax.swing.JPanel();
        PanelNorthSales338 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbMoneyGroup338 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnWareH338 = new javax.swing.JButton();
        btnExcelWare338 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        PanelCenterSales338 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSale338 = new javax.swing.JTable();
        PanelSouthSales338 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbSalesMoney_338 = new javax.swing.JLabel();
        PanelSales338 = new javax.swing.JPanel();
        PanelAllSale338 = new javax.swing.JPanel();
        PanelNorth340 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        PanelTKHD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbTKHDB338 = new javax.swing.JLabel();
        PanelTNV = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbTKHBN338 = new javax.swing.JLabel();
        PanelTKHD2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lbTKNV338 = new javax.swing.JLabel();
        PanelCenter338 = new javax.swing.JPanel();
        PanelSouth338 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();

        panelChart338 = new javax.swing.JPanel();
        managePanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        JlbEmloyee_manager = new javax.swing.JLabel();
        JlbTable_manager = new javax.swing.JLabel();
        JlbMenu_manager = new javax.swing.JLabel();
        JlbAccount_manager = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Jpntable_Manager = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        JpnMenu_Manager = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        JpnAccount_Manager = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        JpnEmployee_Manager = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAddEmployee = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        sellPanel = new javax.swing.JPanel();
        panelReservations320 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        btnTable1320 = new javax.swing.JButton();
        btnTable2318 = new javax.swing.JButton();
        btnTable3318 = new javax.swing.JButton();
        btnTable4318 = new javax.swing.JButton();
        btnTable5318 = new javax.swing.JButton();
        btnTable6318 = new javax.swing.JButton();
        btnTable7318 = new javax.swing.JButton();
        btnTable8318 = new javax.swing.JButton();
        btnTable9318 = new javax.swing.JButton();
        btnTable10318 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lbSalesMoney338 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jpnMenu = new javax.swing.JPanel();
        btnNhapMua111 = new javax.swing.JButton();
        btnNhapKho111 = new javax.swing.JButton();
        btnKiiemKe111 = new javax.swing.JButton();
        btnDanhMuc111 = new javax.swing.JButton();
        btnThongTinNCC111 = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        jpnPurchase = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel159 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpnWarehouse = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel165 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel166 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jLabel171 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jpnInventory = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel180 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel182 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel183 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel184 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel185 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSeparator5 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jpnIngredientsList = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jTextField33 = new javax.swing.JTextField();
        jLabel198 = new javax.swing.JLabel();
        jpnSupplierInformation = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel199 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField32 = new javax.swing.JTextField();
        jLabel210 = new javax.swing.JLabel();
        sellPanel = new javax.swing.JPanel();
        panelReservations321 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnTable1318 = new javax.swing.JButton();
        btnTable2318 = new javax.swing.JButton();
        btnTable3318 = new javax.swing.JButton();
        btnTable4318 = new javax.swing.JButton();
        btnTable5318 = new javax.swing.JButton();
        btnTable6318 = new javax.swing.JButton();
        btnTable7318 = new javax.swing.JButton();
        btnTable8318 = new javax.swing.JButton();
        btnTable9318 = new javax.swing.JButton();
        btnTable10318 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        managePanel234 = new javax.swing.JPanel();
        MenuManager_234 = new javax.swing.JPanel();
        JlbEmloyee_manager = new javax.swing.JLabel();
        JlbTable_manager = new javax.swing.JLabel();
        JlbMenu_manager = new javax.swing.JLabel();
        MainManager_234 = new javax.swing.JPanel();
        JpnEmployee_Manager = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        textFieldNameEmployee234 = new javax.swing.JTextField();
        textFieldPosition234 = new javax.swing.JTextField();
        btnSearchNameEmployee234 = new javax.swing.JLabel();
        btnSearchPosition234 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableEmployeeManager234 = new javax.swing.JTable();
        btnAddEmployee234 = new javax.swing.JLabel();
        btnEditEmployee234 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        textFieldTotalEmployee234 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        btnRefresh3_234 = new javax.swing.JButton();
        Jpntable_Manager = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTableManeger234 = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        textFieldTotalTable234 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        btnEditTable234 = new javax.swing.JLabel();
        btnAddTable234 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnDeleteTable234 = new javax.swing.JLabel();
        comboBoxFloor234 = new javax.swing.JComboBox<>();
        btnRefresh1_234 = new javax.swing.JButton();
        JpnMenu_Manager = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableDrinkManager234 = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        textFieldTotalDrink234 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        btnEditDrink234 = new javax.swing.JLabel();
        btnAddDrink234 = new javax.swing.JLabel();
        btnSearchDrink234 = new javax.swing.JLabel();
        textFieldNameDrink234 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        btnDeleteDrink234 = new javax.swing.JLabel();
        comboBoxTypeDrink234 = new javax.swing.JComboBox<>();
        btnRefresh2_234 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(255, 153, 0));

        functionPanel307.setBackground(new java.awt.Color(69, 32, 16));
        functionPanel307.setForeground(new java.awt.Color(255, 255, 255));
        functionPanel307.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        functionPanel307.setLayout(new java.awt.GridLayout(1, 10, 0, 10));

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
        functionPanel307.add(btnSell307);

        btnManage307.setBackground(new java.awt.Color(69, 32, 16));
        btnManage307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnManage307.setForeground(new java.awt.Color(255, 153, 0));
        btnManage307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/manage.png"))); // NOI18N
        btnManage307.setText("Quản lý");
        btnManage307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManage307ActionPerformed(evt);
            }
        });
        functionPanel307.add(btnManage307);

        btnStatistical307.setBackground(new java.awt.Color(69, 32, 16));
        btnStatistical307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatistical307.setForeground(new java.awt.Color(255, 153, 0));
        btnStatistical307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/statistical.png"))); // NOI18N
        btnStatistical307.setText("Thống kê");
        btnStatistical307.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatistical307MouseClicked(evt);
            }
        });
        btnStatistical307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistical307ActionPerformed(evt);
            }
        });
        functionPanel307.add(btnStatistical307);

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
        functionPanel307.add(btnWarehouse307);

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
        functionPanel307.add(logOutButton307);

        getContentPane().add(functionPanel307, java.awt.BorderLayout.NORTH);

        mainPanel307.setBackground(new java.awt.Color(69, 32, 16));
        mainPanel307.setLayout(new java.awt.CardLayout());

        bannerPanel307.setBackground(new java.awt.Color(69, 32, 16));
        bannerPanel307.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bannerPanel307.setForeground(new java.awt.Color(255, 153, 0));
        bannerPanel307.setLayout(new java.awt.GridBagLayout());

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/banner.png"))); // NOI18N
        jLabel34.setMaximumSize(new java.awt.Dimension(1000, 800));
        jLabel34.setMinimumSize(new java.awt.Dimension(1000, 800));
        jLabel34.setPreferredSize(new java.awt.Dimension(1000, 800));
        bannerPanel307.add(jLabel34, new java.awt.GridBagConstraints());

        mainPanel307.add(bannerPanel307, "bannerPanel");

        panelAll338.setBackground(new java.awt.Color(69, 32, 16));
        panelAll338.setPreferredSize(new java.awt.Dimension(1038, 486));

        jPanel2.setBackground(new java.awt.Color(69, 32, 16));

        PanelMenu338.setBackground(new java.awt.Color(69, 32, 16));
        PanelMenu338.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnStatisSalary338.setBackground(new java.awt.Color(255, 255, 255));
        btnStatisSalary338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatisSalary338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/coins_32_338.png"))); // NOI18N
        btnStatisSalary338.setText("THỐNG KÊ LƯƠNG NHÂN VIÊN");
        btnStatisSalary338.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatisSalary338.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnStatisSalary338.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStatisSalary338.setIconTextGap(10);
        btnStatisSalary338.setPreferredSize(new java.awt.Dimension(0, 35));
        btnStatisSalary338.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisSalary338MouseClicked(evt);
            }
        });

        btnStatisBill338.setBackground(new java.awt.Color(255, 255, 255));
        btnStatisBill338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatisBill338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_billing_machine_32.png"))); // NOI18N
        btnStatisBill338.setText("THỐNG KÊ THEO HD & MÓN");
        btnStatisBill338.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatisBill338.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnStatisBill338.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStatisBill338.setIconTextGap(10);
        btnStatisBill338.setPreferredSize(new java.awt.Dimension(0, 35));
        btnStatisBill338.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisBill338MouseClicked(evt);
            }
        });

        btnStatisWareH338.setBackground(new java.awt.Color(255, 255, 255));
        btnStatisWareH338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatisWareH338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/warehouse_32_338.png"))); // NOI18N
        btnStatisWareH338.setText("THỐNG KÊ NHẬP KHO");
        btnStatisWareH338.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatisWareH338.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnStatisWareH338.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStatisWareH338.setIconTextGap(10);
        btnStatisWareH338.setPreferredSize(new java.awt.Dimension(0, 35));
        btnStatisWareH338.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisWareH338MouseClicked(evt);
            }
        });

        btnStatisLN338.setBackground(new java.awt.Color(255, 255, 255));
        btnStatisLN338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStatisLN338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/expensive_price_32.png"))); // NOI18N
        btnStatisLN338.setText("THỐNG KÊ");
        btnStatisLN338.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatisLN338.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnStatisLN338.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStatisLN338.setIconTextGap(10);
        btnStatisLN338.setPreferredSize(new java.awt.Dimension(0, 35));
        btnStatisLN338.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisLN338MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu338Layout = new javax.swing.GroupLayout(PanelMenu338);
        PanelMenu338.setLayout(PanelMenu338Layout);
        PanelMenu338Layout.setHorizontalGroup(
            PanelMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu338Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStatisBill338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStatisSalary338, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(btnStatisWareH338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStatisLN338, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelMenu338Layout.setVerticalGroup(
            PanelMenu338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu338Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnStatisBill338, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnStatisSalary338, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnStatisWareH338, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnStatisLN338, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelMenu338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelMenu338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelDetails338.setBackground(new java.awt.Color(69, 32, 16));

        PanelBill338.setBackground(new java.awt.Color(69, 32, 16));

        jScrollPane4.setMaximumSize(new java.awt.Dimension(2000, 600));

        PanelRevenueManagerment338.setBackground(new java.awt.Color(69, 32, 16));
        PanelRevenueManagerment338.setPreferredSize(new java.awt.Dimension(1150, 549));

        jPanel3.setBackground(new java.awt.Color(69, 32, 16));

        jPanel5.setBackground(new java.awt.Color(69, 32, 16));

        jPanel1.setBackground(new java.awt.Color(69, 32, 16));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/invoice-icon_338.png"))); // NOI18N
        jLabel12.setText("Thống kê theo hóa đơn");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel12.setOpaque(true);

        btnRevenue338.setBackground(new java.awt.Color(255, 204, 0));
        btnRevenue338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRevenue338.setText("THỐNG KÊ");
        btnRevenue338.setBorder(null);
        btnRevenue338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenue338ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Đến ngày");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("Từ ngày");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnRevenue338, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(388, 388, 388))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRevenue338, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        btnXuatExcel338.setBackground(new java.awt.Color(0, 204, 204));
        btnXuatExcel338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXuatExcel338.setText("XUẤT EXCEL");
        btnXuatExcel338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcel338ActionPerformed(evt);
            }
        });

        tblReceipt338.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(tblReceipt338);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Money-icon_338.png"))); // NOI18N
        jLabel3.setText("Tiền thu về:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        jLabel3.setOpaque(true);

        lbCollectedMoney338.setBackground(new java.awt.Color(255, 255, 255));
        lbCollectedMoney338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCollectedMoney338.setForeground(new java.awt.Color(204, 0, 0));
        lbCollectedMoney338.setText(".....");
        lbCollectedMoney338.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(69, 32, 16));
        jLabel15.setForeground(new java.awt.Color(74, 211, 149));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo_130_338.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(69, 32, 16));
        jLabel7.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("YMach Coffee");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lbCollectedMoney338, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatExcel338, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXuatExcel338, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbCollectedMoney338, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel7)))
                .addContainerGap(70, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        jLabel6.setBackground(new java.awt.Color(69, 32, 16));
        jLabel6.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(475, 475, 475)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 86, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(444, 444, 444)
                    .addComponent(jLabel6)
                    .addContainerGap(1013, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jLabel10)
                .addGap(127, 127, 127))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(226, 226, 226)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addGap(227, 227, 227)))
        );

        javax.swing.GroupLayout PanelRevenueManagerment338Layout = new javax.swing.GroupLayout(PanelRevenueManagerment338);
        PanelRevenueManagerment338.setLayout(PanelRevenueManagerment338Layout);
        PanelRevenueManagerment338Layout.setHorizontalGroup(
            PanelRevenueManagerment338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRevenueManagerment338Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelRevenueManagerment338Layout.setVerticalGroup(
            PanelRevenueManagerment338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(PanelRevenueManagerment338);

        javax.swing.GroupLayout PanelBill338Layout = new javax.swing.GroupLayout(PanelBill338);
        PanelBill338.setLayout(PanelBill338Layout);
        PanelBill338Layout.setHorizontalGroup(
            PanelBill338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2345, Short.MAX_VALUE)
        );
        PanelBill338Layout.setVerticalGroup(
            PanelBill338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
        );

        PanelSalary338.setBackground(new java.awt.Color(69, 32, 16));

        PanelAllSalary307.setBackground(new java.awt.Color(69, 32, 16));
        PanelAllSalary307.setOpaque(false);

        PanelNorthSalary307.setBackground(new java.awt.Color(69, 32, 16));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/sales_performance_338.png"))); // NOI18N
        jLabel16.setText("LƯƠNG NHÂN VIÊN");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/sort_by_338_32.png"))); // NOI18N
        jLabel17.setText("Sắp xếp:");

        cbbSalarySort307.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbSalarySort307.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần", "Giảm dần", " " }));
        cbbSalarySort307.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSalarySort307ItemStateChanged(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_cheap_338_64.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("Từ ngày");

        dateChooser3.setBackground(new java.awt.Color(69, 32, 16));
        dateChooser3.setDateFormatString("dd-MM-yyyy\n");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("Đến ngày");

        dateChooser4.setBackground(new java.awt.Color(69, 32, 16));
        dateChooser4.setDateFormatString("dd-MM-yyyy\n");

        btnSalary307.setBackground(new java.awt.Color(255, 204, 0));
        btnSalary307.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalary307.setText("THỐNG KÊ");
        btnSalary307.setBorder(null);
        btnSalary307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalary307ActionPerformed(evt);
            }
        });

        btnXuatExcelSalary307.setBackground(new java.awt.Color(0, 255, 255));
        btnXuatExcelSalary307.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXuatExcelSalary307.setText("XUẤT EXCEL");
        btnXuatExcelSalary307.setBorder(null);
        btnXuatExcelSalary307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelSalary307ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelNorthSalary307Layout = new javax.swing.GroupLayout(PanelNorthSalary307);
        PanelNorthSalary307.setLayout(PanelNorthSalary307Layout);
        PanelNorthSalary307Layout.setHorizontalGroup(
            PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorthSalary307Layout.createSequentialGroup()
                .addGroup(PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNorthSalary307Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbSalarySort307, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXuatExcelSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNorthSalary307Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap())
        );
        PanelNorthSalary307Layout.setVerticalGroup(
            PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorthSalary307Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelNorthSalary307Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSalarySort307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuatExcelSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNorthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCenterSalary307.setBackground(new java.awt.Color(69, 32, 16));

        tbSalary307.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbSalary307.setForeground(new java.awt.Color(51, 0, 51));
        tbSalary307.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSalary307.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSalary307MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSalary307);

        javax.swing.GroupLayout PanelCenterSalary307Layout = new javax.swing.GroupLayout(PanelCenterSalary307);
        PanelCenterSalary307.setLayout(PanelCenterSalary307Layout);
        PanelCenterSalary307Layout.setHorizontalGroup(
            PanelCenterSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelCenterSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCenterSalary307Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelCenterSalary307Layout.setVerticalGroup(
            PanelCenterSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
            .addGroup(PanelCenterSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCenterSalary307Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)))
        );

        PanelSouthSalary307.setBackground(new java.awt.Color(69, 32, 16));

        jLabel21.setBackground(new java.awt.Color(69, 32, 16));
        jLabel21.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("YMach Coffee");

        jLabel22.setBackground(new java.awt.Color(69, 32, 16));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo_130_338.png"))); // NOI18N
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(69, 32, 16));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/cup_2_110.png"))); // NOI18N

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Money-icon_338.png"))); // NOI18N
        jLabel24.setText("Tổng lương nhân viên:");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        jLabel24.setOpaque(true);

        lbSalaryTotal307.setBackground(new java.awt.Color(255, 255, 255));
        lbSalaryTotal307.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSalaryTotal307.setForeground(new java.awt.Color(204, 0, 0));
        lbSalaryTotal307.setText(".....");
        lbSalaryTotal307.setOpaque(true);

        javax.swing.GroupLayout PanelSouthSalary307Layout = new javax.swing.GroupLayout(PanelSouthSalary307);
        PanelSouthSalary307.setLayout(PanelSouthSalary307Layout);
        PanelSouthSalary307Layout.setHorizontalGroup(
            PanelSouthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSouthSalary307Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 1590, Short.MAX_VALUE)
                .addGroup(PanelSouthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSouthSalary307Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSalaryTotal307, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSouthSalary307Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelSouthSalary307Layout.setVerticalGroup(
            PanelSouthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSouthSalary307Layout.createSequentialGroup()
                .addGroup(PanelSouthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelSouthSalary307Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelSouthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(lbSalaryTotal307, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(PanelSouthSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSouthSalary307Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelSouthSalary307Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelAllSalary307Layout = new javax.swing.GroupLayout(PanelAllSalary307);
        PanelAllSalary307.setLayout(PanelAllSalary307Layout);
        PanelAllSalary307Layout.setHorizontalGroup(
            PanelAllSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNorthSalary307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelCenterSalary307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSouthSalary307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAllSalary307Layout.setVerticalGroup(
            PanelAllSalary307Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAllSalary307Layout.createSequentialGroup()
                .addComponent(PanelNorthSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelCenterSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelSouthSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PanelSalary338Layout = new javax.swing.GroupLayout(PanelSalary338);
        PanelSalary338.setLayout(PanelSalary338Layout);
        PanelSalary338Layout.setHorizontalGroup(
            PanelSalary338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAllSalary307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSalary338Layout.setVerticalGroup(
            PanelSalary338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAllSalary307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelWareHouse338.setBackground(new java.awt.Color(69, 32, 16));

        PanelAllWare338.setBackground(new java.awt.Color(69, 32, 16));
        PanelAllWare338.setOpaque(false);

        PanelNorthSales338.setBackground(new java.awt.Color(69, 32, 16));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/house338_48.png"))); // NOI18N
        jLabel8.setText("NHẬP KHO");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/sort_by_338_32.png"))); // NOI18N
        jLabel9.setText("Sắp xếp:");

        cbbMoneyGroup338.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbMoneyGroup338.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần", "Giảm dần", " " }));
        cbbMoneyGroup338.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMoneyGroup338ItemStateChanged(evt);
            }
        });
        cbbMoneyGroup338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMoneyGroup338ActionPerformed(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Money_Bag_Pounds_48.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 0));
        jLabel26.setText("Từ ngày");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 0));
        jLabel27.setText("Đến ngày");

        btnWareH338.setBackground(new java.awt.Color(255, 204, 0));
        btnWareH338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnWareH338.setText("THỐNG KÊ");
        btnWareH338.setBorder(null);
        btnWareH338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWareH338ActionPerformed(evt);
            }
        });

        btnExcelWare338.setBackground(new java.awt.Color(0, 255, 255));
        btnExcelWare338.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcelWare338.setText("XUẤT EXCEL");
        btnExcelWare338.setBorder(null);
        btnExcelWare338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelWare338ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelNorthSales338Layout = new javax.swing.GroupLayout(PanelNorthSales338);
        PanelNorthSales338.setLayout(PanelNorthSales338Layout);
        PanelNorthSales338Layout.setHorizontalGroup(
            PanelNorthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorthSales338Layout.createSequentialGroup()
                .addGroup(PanelNorthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNorthSales338Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNorthSales338Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbMoneyGroup338, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnWareH338, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnExcelWare338, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1347, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
        );
        PanelNorthSales338Layout.setVerticalGroup(
            PanelNorthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorthSales338Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNorthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelNorthSales338Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNorthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbMoneyGroup338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNorthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnWareH338, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcelWare338, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCenterSales338.setBackground(new java.awt.Color(69, 32, 16));

        tbSale338.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbSale338.setForeground(new java.awt.Color(51, 0, 51));
        tbSale338.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbSale338);

        javax.swing.GroupLayout PanelCenterSales338Layout = new javax.swing.GroupLayout(PanelCenterSales338);
        PanelCenterSales338.setLayout(PanelCenterSales338Layout);
        PanelCenterSales338Layout.setHorizontalGroup(
            PanelCenterSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelCenterSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCenterSales338Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelCenterSales338Layout.setVerticalGroup(
            PanelCenterSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
            .addGroup(PanelCenterSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCenterSales338Layout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelSouthSales338.setBackground(new java.awt.Color(69, 32, 16));

        jLabel28.setBackground(new java.awt.Color(69, 32, 16));
        jLabel28.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("YMach Coffee");

        jLabel29.setBackground(new java.awt.Color(69, 32, 16));
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo_130_338.png"))); // NOI18N
        jLabel29.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(69, 32, 16));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/cup_2_110.png"))); // NOI18N

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Money-icon_338.png"))); // NOI18N
        jLabel31.setText("Tổng tiền nhập:");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        jLabel31.setOpaque(true);

        lbSalesMoney_338.setBackground(new java.awt.Color(255, 255, 255));
        lbSalesMoney_338.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSalesMoney_338.setForeground(new java.awt.Color(204, 0, 0));
        lbSalesMoney_338.setText(".....");
        lbSalesMoney_338.setOpaque(true);

        javax.swing.GroupLayout PanelSouthSales338Layout = new javax.swing.GroupLayout(PanelSouthSales338);
        PanelSouthSales338.setLayout(PanelSouthSales338Layout);
        PanelSouthSales338Layout.setHorizontalGroup(
            PanelSouthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSouthSales338Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelSouthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSouthSales338Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSouthSales338Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSalesMoney_338, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelSouthSales338Layout.setVerticalGroup(
            PanelSouthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSouthSales338Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelSouthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lbSalesMoney_338, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelSouthSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSouthSales338Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelSouthSales338Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSouthSales338Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(177, 177, 177))
        );

        javax.swing.GroupLayout PanelAllWare338Layout = new javax.swing.GroupLayout(PanelAllWare338);
        PanelAllWare338.setLayout(PanelAllWare338Layout);
        PanelAllWare338Layout.setHorizontalGroup(
            PanelAllWare338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNorthSales338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSouthSales338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelCenterSales338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAllWare338Layout.setVerticalGroup(
            PanelAllWare338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAllWare338Layout.createSequentialGroup()
                .addComponent(PanelNorthSales338, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelCenterSales338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelSouthSales338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PanelWareHouse338Layout = new javax.swing.GroupLayout(PanelWareHouse338);
        PanelWareHouse338.setLayout(PanelWareHouse338Layout);
        PanelWareHouse338Layout.setHorizontalGroup(
            PanelWareHouse338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAllWare338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelWareHouse338Layout.setVerticalGroup(
            PanelWareHouse338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAllWare338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelSales338.setBackground(new java.awt.Color(69, 32, 16));

        PanelAllSale338.setBackground(new java.awt.Color(69, 32, 16));
        PanelAllSale338.setOpaque(false);

        PanelNorth340.setBackground(new java.awt.Color(69, 32, 16));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/sales_performance_338.png"))); // NOI18N
        jLabel32.setText("THỐNG KÊ");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel32.setOpaque(true);

        PanelTKHD.setBackground(new java.awt.Color(255, 255, 255));
        PanelTKHD.setPreferredSize(new java.awt.Dimension(375, 220));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hóa đơn bán");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Ecommerce_338.png"))); // NOI18N

        lbTKHDB338.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbTKHDB338.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTKHDB338.setText("3");

        javax.swing.GroupLayout PanelTKHDLayout = new javax.swing.GroupLayout(PanelTKHD);
        PanelTKHD.setLayout(PanelTKHDLayout);
        PanelTKHDLayout.setHorizontalGroup(
            PanelTKHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelTKHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(lbTKHDB338, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        PanelTKHDLayout.setVerticalGroup(
            PanelTKHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTKHDLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(PanelTKHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(lbTKHDB338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        PanelTNV.setBackground(new java.awt.Color(153, 255, 153));
        PanelTNV.setPreferredSize(new java.awt.Dimension(375, 220));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hóa đơn nhập hàng");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Ecommerce_338.png"))); // NOI18N

        lbTKHBN338.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbTKHBN338.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTKHBN338.setText("3");

        javax.swing.GroupLayout PanelTNVLayout = new javax.swing.GroupLayout(PanelTNV);
        PanelTNV.setLayout(PanelTNVLayout);
        PanelTNVLayout.setHorizontalGroup(
            PanelTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelTNVLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(lbTKHBN338, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        PanelTNVLayout.setVerticalGroup(
            PanelTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTNVLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(PanelTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(lbTKHBN338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        PanelTKHD2.setBackground(new java.awt.Color(102, 255, 255));
        PanelTKHD2.setPreferredSize(new java.awt.Dimension(375, 190));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nhân viên");

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/User_338.png"))); // NOI18N

        lbTKNV338.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbTKNV338.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTKNV338.setText("3");

        javax.swing.GroupLayout PanelTKHD2Layout = new javax.swing.GroupLayout(PanelTKHD2);
        PanelTKHD2.setLayout(PanelTKHD2Layout);
        PanelTKHD2Layout.setHorizontalGroup(
            PanelTKHD2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelTKHD2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(lbTKNV338, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        PanelTKHD2Layout.setVerticalGroup(
            PanelTKHD2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTKHD2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(86, 86, 86)
                .addGroup(PanelTKHD2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTKNV338, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelNorth340Layout = new javax.swing.GroupLayout(PanelNorth340);
        PanelNorth340.setLayout(PanelNorth340Layout);
        PanelNorth340Layout.setHorizontalGroup(
            PanelNorth340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorth340Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNorth340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNorth340Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelNorth340Layout.createSequentialGroup()
                        .addComponent(PanelTKHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelTKHD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelNorth340Layout.setVerticalGroup(
            PanelNorth340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorth340Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelNorth340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTKHD2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(PanelNorth340Layout.createSequentialGroup()
                        .addGroup(PanelNorth340Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelTKHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PanelCenter338.setBackground(new java.awt.Color(69, 32, 16));

        javax.swing.GroupLayout PanelCenter338Layout = new javax.swing.GroupLayout(PanelCenter338);
        PanelCenter338.setLayout(PanelCenter338Layout);
        PanelCenter338Layout.setHorizontalGroup(
            PanelCenter338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1175, Short.MAX_VALUE)
        );
        PanelCenter338Layout.setVerticalGroup(
            PanelCenter338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        PanelSouth338.setBackground(new java.awt.Color(69, 32, 16));

        jLabel46.setBackground(new java.awt.Color(69, 32, 16));
        jLabel46.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("YMach Coffee");

        jLabel47.setBackground(new java.awt.Color(69, 32, 16));
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo_130_338.png"))); // NOI18N
        jLabel47.setOpaque(true);

        javax.swing.GroupLayout PanelSouth338Layout = new javax.swing.GroupLayout(PanelSouth338);
        PanelSouth338.setLayout(PanelSouth338Layout);
        PanelSouth338Layout.setHorizontalGroup(
            PanelSouth338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSouth338Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelSouth338Layout.setVerticalGroup(
            PanelSouth338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSouth338Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelSouth338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSouth338Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(154, 154, 154))
        );

        panelChart338.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelChart338Layout = new javax.swing.GroupLayout(panelChart338);
        panelChart338.setLayout(panelChart338Layout);
        panelChart338Layout.setHorizontalGroup(
            panelChart338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        panelChart338Layout.setVerticalGroup(
            panelChart338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelAllSale338Layout = new javax.swing.GroupLayout(PanelAllSale338);
        PanelAllSale338.setLayout(PanelAllSale338Layout);
        PanelAllSale338Layout.setHorizontalGroup(
            PanelAllSale338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAllSale338Layout.createSequentialGroup()
                .addGroup(PanelAllSale338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAllSale338Layout.createSequentialGroup()
                        .addComponent(PanelNorth340, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAllSale338Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelChart338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)))
                .addComponent(PanelCenter338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelSouth338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAllSale338Layout.setVerticalGroup(
            PanelAllSale338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAllSale338Layout.createSequentialGroup()
                .addComponent(PanelNorth340, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelAllSale338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAllSale338Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(PanelCenter338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(PanelAllSale338Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(panelChart338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(PanelSouth338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelSales338Layout = new javax.swing.GroupLayout(PanelSales338);
        PanelSales338.setLayout(PanelSales338Layout);
        PanelSales338Layout.setHorizontalGroup(
            PanelSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAllSale338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSales338Layout.setVerticalGroup(
            PanelSales338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSales338Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAllSale338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelDetails338Layout = new javax.swing.GroupLayout(PanelDetails338);
        PanelDetails338.setLayout(PanelDetails338Layout);
        PanelDetails338Layout.setHorizontalGroup(
            PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelWareHouse338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelSales338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelSalary338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelBill338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDetails338Layout.setVerticalGroup(
            PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelWareHouse338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelSales338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelSalary338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelDetails338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelBill338, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAll338Layout = new javax.swing.GroupLayout(panelAll338);
        panelAll338.setLayout(panelAll338Layout);
        panelAll338Layout.setHorizontalGroup(
            panelAll338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAll338Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(PanelDetails338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAll338Layout.setVerticalGroup(
            panelAll338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDetails338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel307.add(panelAll338, "panelAll338");

        jpnMenu.setBackground(new java.awt.Color(69, 32, 16));

        btnNhapMua111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhapMua111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_buy_48px.png"))); // NOI18N
        btnNhapMua111.setText("NHẬP MUA");
        btnNhapMua111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMua111ActionPerformed(evt);
            }
        });

        btnNhapKho111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhapKho111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_warehouse_48px.png"))); // NOI18N
        btnNhapKho111.setText("NHẬP KHO");
        btnNhapKho111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapKho111ActionPerformed(evt);
            }
        });

        btnKiiemKe111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKiiemKe111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_inventory_flow_48px.png"))); // NOI18N
        btnKiiemKe111.setText("KIỂM KÊ");
        btnKiiemKe111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiiemKe111ActionPerformed(evt);
            }
        });

        btnDanhMuc111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDanhMuc111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_category_48px.png"))); // NOI18N
        btnDanhMuc111.setText("DANH MỤC NL");
        btnDanhMuc111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMuc111ActionPerformed(evt);
            }
        });

        btnThongTinNCC111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongTinNCC111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_more_info_48px.png"))); // NOI18N
        btnThongTinNCC111.setText("THÔNG TIN NCC");
        btnThongTinNCC111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinNCC111ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThongTinNCC111, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDanhMuc111, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiiemKe111, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapMua111, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapKho111, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnNhapMua111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnNhapKho111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnKiiemKe111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDanhMuc111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThongTinNCC111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(514, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jpnMenu);

        jpnView.setLayout(new java.awt.CardLayout());

        jPanel19.setBackground(new java.awt.Color(69, 32, 16));

        jLabel148.setBackground(new java.awt.Color(255, 255, 255));
        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 0, 0));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_buy_48px.png"))); // NOI18N
        jLabel148.setText("Phiếu nhập mua");
        jLabel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel148.setOpaque(true);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel149.setText("Tên nhân viên:");

        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel150.setText("Mã NV:");

        jTextField45.setText("jTextField1");

        jTextField46.setText("jTextField2");

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel151.setText("Mã phiếu nhập:");

        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel152.setText("Ngày nhập:");

        jTextField47.setText("jTextField3");

        jLabel153.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel153.setText("Tên NCC:");

        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel154.setText("Mã NCC:");

        jTextField48.setText("jTextField4");

        jTextField49.setText("jTextField5");

        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel155.setText("Tên NVL:");

        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel156.setText("Mã NVL:");

        jTextField50.setText("jTextField6");

        jTextField51.setText("jTextField7");

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel157.setText("Loại NVL:");

        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel158.setText("Số lượng:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel159.setText("Đơn vị tính:");

        jTextField52.setText("jTextField8");

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel160.setText("Đơn giá:");

        jTextField53.setText("jTextField9");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel149)
                    .addComponent(jLabel151))
                .addGap(25, 25, 25)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField45, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jTextField47))
                .addGap(61, 61, 61)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel152)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 999, Short.MAX_VALUE)
                        .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addComponent(jSeparator10)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel153)
                    .addComponent(jLabel155)
                    .addComponent(jLabel157)
                    .addComponent(jLabel159))
                .addGap(48, 48, 48)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField48, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jTextField50)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel154)
                    .addComponent(jLabel156)
                    .addComponent(jLabel158)
                    .addComponent(jLabel160))
                .addGap(30, 30, 30)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField49, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jTextField51)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField53))
                .addGap(26, 26, 26))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jLabel150)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel151)
                        .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel152))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(jLabel154)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel155)
                    .addComponent(jLabel156)
                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157)
                    .addComponent(jLabel158)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160)
                    .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(jTable10);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_add_48px_1.png"))); // NOI18N
        jButton1.setText("Thêm");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_computer_support_48px.png"))); // NOI18N
        jButton2.setText("Sửa");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1703, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane20)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)))
                .addGap(63, 63, 63)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnPurchaseLayout = new javax.swing.GroupLayout(jpnPurchase);
        jpnPurchase.setLayout(jpnPurchaseLayout);
        jpnPurchaseLayout.setHorizontalGroup(
            jpnPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnPurchaseLayout.setVerticalGroup(
            jpnPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnPurchase, "card2");

        jPanel21.setBackground(new java.awt.Color(69, 32, 16));

        jLabel161.setBackground(new java.awt.Color(255, 255, 255));
        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 0, 0));
        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_warehouse_48px.png"))); // NOI18N
        jLabel161.setText("PHIẾU NHẬP KHO");
        jLabel161.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel161.setOpaque(true);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel162.setText("Tên NV:");

        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel163.setText("Mã NV:");

        jTextField54.setText("jTextField10");

        jTextField11.setText("jTextField11");

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel164.setText("Ngày nhập:");

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel165.setText("Mã phiếu nhập:");

        jTextField12.setText("jTextField12");

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel166.setText("Tên NL:");

        jTextField13.setText("jTextField13");

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel167.setText("Mã NL:");

        jTextField14.setText("jTextField14");

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel168.setText("Phân loại:");

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel169.setText("Đơn vị tính:");

        jTextField15.setText("jTextField15");

        jTextField16.setText("jTextField16");

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel170.setText("Số lượng nhập:");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel162)
                            .addComponent(jLabel164))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField54)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel163)
                                .addGap(37, 37, 37)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel165)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField12))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel170)
                                .addGap(24, 24, 24)
                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel168, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel169)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel167)
                                        .addGap(36, 36, 36)))))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel165)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel162)
                            .addComponent(jLabel163)
                            .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel164)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel167)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel168)
                    .addComponent(jLabel169)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel170)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_add_48px_1.png"))); // NOI18N
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_computer_support_48px.png"))); // NOI18N
        jButton4.setText("Sửa");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane21.setViewportView(jTable11);

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 0, 0));
        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_search_16px.png"))); // NOI18N
        jLabel171.setText("Tên NVL");

        jTextField34.setText("jTextField34");

        jLabel172.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setText("YMACH COFFEE");

        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/drink.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane21)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel161))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel171)
                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(84, 84, 84)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel172))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(224, 224, 224))
        );

        javax.swing.GroupLayout jpnWarehouseLayout = new javax.swing.GroupLayout(jpnWarehouse);
        jpnWarehouse.setLayout(jpnWarehouseLayout);
        jpnWarehouseLayout.setHorizontalGroup(
            jpnWarehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnWarehouseLayout.setVerticalGroup(
            jpnWarehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnWarehouse, "card3");

        jPanel23.setBackground(new java.awt.Color(69, 32, 16));

        jLabel174.setBackground(new java.awt.Color(255, 255, 255));
        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 0, 0));
        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_inventory_flow_48px.png"))); // NOI18N
        jLabel174.setText("KIỂM KÊ");
        jLabel174.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel174.setOpaque(true);

        jLabel175.setForeground(new java.awt.Color(255, 255, 0));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel176.setText("Kiểm kê từ ngày:");

        jLabel177.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel177.setText("Mã kiểm kê:");

        jLabel178.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel178.setText("Tên NVL:");

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel179.setText("Đến ngày:");

        jTextField17.setText("jTextField17");

        jTextField18.setText("jTextField18");

        jLabel180.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel180.setText("Mã NVL:");

        jTextField19.setText("jTextField19");

        jLabel181.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel181.setText("Số lượng kiểm kê:");

        jLabel182.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel182.setText("Số lượng ban đầu:");

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel183.setText("Số lượng chênh lệch");

        jLabel184.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel184.setText("Nguyên nhân:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane22.setViewportView(jTextArea1);

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel185.setText("Xử lý:");

        jScrollPane23.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 257, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel176)
                            .addComponent(jLabel177)
                            .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jTextField17)
                            .addComponent(jTextField19)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel182)
                            .addComponent(jLabel184))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel179, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel178, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField18)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel181)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel183)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(356, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel176)
                        .addComponent(jLabel179))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177)
                    .addComponent(jLabel178)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel181)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel182)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel183)
                        .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel184)
                    .addComponent(jScrollPane22)
                    .addComponent(jLabel185)
                    .addComponent(jScrollPane23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_add_48px_1.png"))); // NOI18N
        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_computer_support_48px.png"))); // NOI18N
        jButton6.setText("Sửa");

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane24.setViewportView(jTable12);

        jLabel186.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/cup_338.png"))); // NOI18N

        jLabel187.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setText("YMACH COFFEE");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(27, 27, 27))
            .addComponent(jSeparator5)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24)
                .addContainerGap())
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(548, 548, 548)
                .addComponent(jLabel186)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel175)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(213, 213, 213)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel187)))
                .addGap(190, 190, 190))
        );

        javax.swing.GroupLayout jpnInventoryLayout = new javax.swing.GroupLayout(jpnInventory);
        jpnInventory.setLayout(jpnInventoryLayout);
        jpnInventoryLayout.setHorizontalGroup(
            jpnInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInventoryLayout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnInventoryLayout.setVerticalGroup(
            jpnInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnInventory, "card4");

        jpnIngredientsList.setBackground(new java.awt.Color(69, 32, 16));

        jPanel4.setBackground(new java.awt.Color(69, 32, 16));

        jLabel188.setBackground(new java.awt.Color(255, 255, 255));
        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 0, 0));
        jLabel188.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_category_48px.png"))); // NOI18N
        jLabel188.setText("THÔNG TIN NGUYÊN LIỆU");
        jLabel188.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel188.setOpaque(true);

        jLabel189.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel189.setText("Tên NVL:");

        jTextField20.setText("jTextField20");

        jLabel190.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel190.setText("Mã NVL:");

        jTextField21.setText("jTextField21");

        jLabel191.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel191.setText("Giá:");

        jLabel192.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel192.setText("Tổng số hiện còn:");

        jTextField22.setText("jTextField22");

        jLabel193.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel193.setText("NCC:");

        jLabel194.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel194.setText("Hạn dùng:");

        jTextField23.setText("jTextField23");

        jLabel195.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel195.setText("VNĐ");

        jLabel196.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel196.setText("Số lượng nhập:");

        jLabel197.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel197.setText("Số lượng đã tiêu thụ:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel189)
                            .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField20, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextField23)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel196)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel190)
                                    .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel192)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel197)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel189)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel190)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel191)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel195)
                        .addComponent(jLabel194))
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel193)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel192)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel196)
                    .addComponent(jLabel197)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_add_48px_1.png"))); // NOI18N
        jButton7.setText("Thêm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_computer_support_48px.png"))); // NOI18N
        jButton8.setText("Sửa");

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane25.setViewportView(jTable13);

        jTextField33.setText("jTextField33");

        jLabel198.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 0, 0));
        jLabel198.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_search_16px.png"))); // NOI18N
        jLabel198.setText("Tên NVL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel188))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane25)))
                .addGap(29, 29, 29))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel198)
                .addGap(165, 165, 165))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel198))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70)))
                .addGap(17, 17, 17)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(205, 205, 205))
        );

        javax.swing.GroupLayout jpnIngredientsListLayout = new javax.swing.GroupLayout(jpnIngredientsList);
        jpnIngredientsList.setLayout(jpnIngredientsListLayout);
        jpnIngredientsListLayout.setHorizontalGroup(
            jpnIngredientsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnIngredientsListLayout.setVerticalGroup(
            jpnIngredientsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnIngredientsList, "card5");

        jPanel24.setBackground(new java.awt.Color(69, 32, 16));

        jLabel199.setBackground(new java.awt.Color(255, 255, 255));
        jLabel199.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 0, 0));
        jLabel199.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_more_info_48px.png"))); // NOI18N
        jLabel199.setText("THÔNG TIN NHÀ CUNG CẤP");
        jLabel199.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel199.setOpaque(true);

        jLabel200.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel200.setText("Tên NCC:");

        jLabel201.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel201.setText("Mã NCC:");

        jTextField24.setText("jTextField24");

        jTextField25.setText("jTextField25");

        jLabel202.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel202.setText("Di động:");

        jLabel203.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel203.setText("Email:");

        jTextField26.setText("jTextField26");

        jTextField27.setText("jTextField27");

        jLabel204.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel204.setText("Công ty:");

        jLabel205.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel205.setText("Địa chỉ:");

        jTextField28.setText("jTextField28");

        jTextField29.setText("jTextField29");

        jLabel206.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel206.setText("Điện thoại:");

        jLabel207.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel207.setText("Fax:");

        jTextField30.setText("jTextField30");

        jTextField31.setText("jTextField31");

        jLabel208.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel208.setText("Thông tin xuất hoá đơn:");

        jLabel209.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel209.setText("Ghi chú:");

        jScrollPane26.setViewportView(jTextPane2);

        jScrollPane27.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel200, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField24, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jTextField26))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel203, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel201, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField25, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jTextField27)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel204)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel206)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField30)))
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel209)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel205)
                                        .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel200)
                    .addComponent(jLabel201)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel202)
                    .addComponent(jLabel203)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel204)
                    .addComponent(jLabel205)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel206)
                    .addComponent(jLabel207)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel209)
                    .addComponent(jLabel208))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jScrollPane27))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_add_48px_1.png"))); // NOI18N
        jButton9.setText("Thêm");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_computer_support_48px.png"))); // NOI18N
        jButton10.setText("Sửa");

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_Delete_48px.png"))); // NOI18N
        jButton15.setText("Xoá");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane28.setViewportView(jTable5);

        jTextField32.setText("jTextField32");

        jLabel210.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(255, 0, 0));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons8_search_16px.png"))); // NOI18N
        jLabel210.setText("Tên NCC");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
            .addComponent(jSeparator8)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel199)
                .addGap(148, 148, 148)
                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel210)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane28)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel210))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(253, 253, 253))
        );

        javax.swing.GroupLayout jpnSupplierInformationLayout = new javax.swing.GroupLayout(jpnSupplierInformation);
        jpnSupplierInformation.setLayout(jpnSupplierInformationLayout);
        jpnSupplierInformationLayout.setHorizontalGroup(
            jpnSupplierInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnSupplierInformationLayout.setVerticalGroup(
            jpnSupplierInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnSupplierInformation, "card6");

        jSplitPane1.setRightComponent(jpnView);

        mainPanel307.add(jSplitPane1, "warehousePanel");

        panelReservations321.setBackground(new java.awt.Color(69, 32, 16));
        panelReservations321.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Tầng:");

        jComboBox5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", " " }));

        jButton13.setBackground(new java.awt.Color(0, 204, 204));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(51, 255, 0));

        jLabel41.setForeground(new java.awt.Color(255, 255, 0));
        jLabel41.setText("Free");

        jLabel42.setForeground(new java.awt.Color(255, 255, 0));
        jLabel42.setText("Reserved");

        jButton17.setBackground(new java.awt.Color(204, 0, 204));

        jLabel50.setForeground(new java.awt.Color(255, 255, 0));
        jLabel50.setText("Serving");

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Logo318.png"))); // NOI18N

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(204, 0, 0));
        jLabel52.setText("YMACH COFFEE");

        jPanel15.setBackground(new java.awt.Color(69, 32, 16));
        jPanel15.setLayout(new java.awt.GridLayout(5, 2, 20, 20));

        btnTable1318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable1318.setText("1");
        btnTable1318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable1318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable1318);

        btnTable2318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable2318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable2318.setText("2");
        btnTable2318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable2318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable2318);

        btnTable3318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable3318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable3318.setText("3");
        btnTable3318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable3318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable3318);

        btnTable4318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable4318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable4318.setText("4");
        btnTable4318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable4318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable4318);

        btnTable5318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable5318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable5318.setText("5");
        btnTable5318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable5318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable5318);

        btnTable6318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable6318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable6318.setText("6");
        btnTable6318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable6318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable6318);

        btnTable7318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable7318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable7318.setText("7");
        btnTable7318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable7318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable7318);

        btnTable8318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable8318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable8318.setText("8");
        btnTable8318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable8318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable8318);

        btnTable9318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable9318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable9318.setText("9");
        btnTable9318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable9318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable9318);

        btnTable10318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable10318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable10318.setText("10");
        btnTable10318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable10318ActionPerformed(evt);
            }
        });
        jPanel15.add(btnTable10318);

        javax.swing.GroupLayout panelReservations321Layout = new javax.swing.GroupLayout(panelReservations321);
        panelReservations321.setLayout(panelReservations321Layout);
        panelReservations321Layout.setHorizontalGroup(
            panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservations321Layout.createSequentialGroup()
                .addGroup(panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservations321Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel40)
                        .addGap(5, 5, 5)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addGroup(panelReservations320Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel85)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelReservations320Layout.setVerticalGroup(
            panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservations320Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addGap(18, 18, 18)
                .addGroup(panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addGroup(panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservations320Layout.createSequentialGroup()

                    .addGroup(panelReservations321Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel41)
                        .addGap(5, 5, 5)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel42))
                    .addGroup(panelReservations321Layout.createSequentialGroup()
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50))
                    .addGroup(panelReservations321Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel51)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel52))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelReservations321Layout.setVerticalGroup(
            panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservations321Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservations321Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addGroup(panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(panelReservations321Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(panelReservations321Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel52)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(69, 32, 16));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel53.setBackground(new java.awt.Color(69, 32, 16));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Menu318.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 1869, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sellPanelLayout = new javax.swing.GroupLayout(sellPanel);
        sellPanel.setLayout(sellPanelLayout);
        sellPanelLayout.setHorizontalGroup(
            sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellPanelLayout.createSequentialGroup()
                .addComponent(panelReservations321, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        sellPanelLayout.setVerticalGroup(
            sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservations321, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel307.add(sellPanel, "sellPanel");

        managePanel234.setBackground(new java.awt.Color(255, 255, 255));

        MenuManager_234.setBackground(new java.awt.Color(69, 32, 16));

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

        javax.swing.GroupLayout MenuManager_234Layout = new javax.swing.GroupLayout(MenuManager_234);
        MenuManager_234.setLayout(MenuManager_234Layout);
        MenuManager_234Layout.setHorizontalGroup(
            MenuManager_234Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuManager_234Layout.createSequentialGroup()
                .addContainerGap()

                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel114)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                .addGroup(MenuManager_234Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JlbTable_manager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbMenu_manager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbEmloyee_manager, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addContainerGap())

        );
        MenuManager_234Layout.setVerticalGroup(
            MenuManager_234Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuManager_234Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(JlbEmloyee_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(JlbTable_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(JlbMenu_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainManager_234.setLayout(new java.awt.CardLayout());

        JpnEmployee_Manager.setBackground(new java.awt.Color(69, 32, 16));
        JpnEmployee_Manager.setForeground(new java.awt.Color(255, 255, 0));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 0));
        jLabel62.setText("Tên Nhân Viên :");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 0));
        jLabel63.setText("Chức Vụ:");

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
        jScrollPane9.setViewportView(tableEmployeeManager234);

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

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 0));
        jLabel64.setText("Tổng số nhân viên :");

        textFieldTotalEmployee234.setText("...");
        textFieldTotalEmployee234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalEmployee234ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 0));
        jLabel65.setText("YMACH COFFEE");


        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField36))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel118)
                            .addComponent(jLabel117))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel121)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel119))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel122)
                            .addComponent(jLabel120)
                            .addComponent(jLabel124))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField34)
                    .addComponent(jTextField35)
                    .addComponent(jScrollPane14)
                    .addComponent(jTextField37))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        btnRefresh3_234.setBackground(new java.awt.Color(0, 255, 255));
        btnRefresh3_234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefresh3_234.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh3_234.setText("Refresh");
        btnRefresh3_234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh3_234ActionPerformed(evt);
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
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel66)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddEmployee234, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(btnEditEmployee234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRefresh3_234, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel63)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldPosition234, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchPosition234, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))

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
                                .addComponent(jLabel62)
                                .addComponent(jLabel63)
                                .addComponent(textFieldNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldPosition234, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(124, 124, 124)
                        .addComponent(btnAddEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(btnEditEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addComponent(btnSearchNameEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh3_234)
                .addGap(37, 37, 37)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(textFieldTotalEmployee234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel65))
                    .addComponent(jLabel66))
                .addGap(19, 19, 19))
        );

        MainManager_234.add(JpnEmployee_Manager, "card3");

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
        jScrollPane6.setViewportView(tableTableManeger234);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel55.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 0));
        jLabel55.setText("YMACH COFFEE");

        textFieldTotalTable234.setText("...");
        textFieldTotalTable234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalTable234ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 0));
        jLabel56.setText("Tổng số bàn :");

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

        comboBoxFloor234.setBackground(new java.awt.Color(0, 255, 255));
        comboBoxFloor234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxFloor234.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LẦU 1 ", "LẦU 2", "LẦU 3", " " }));
        comboBoxFloor234.setToolTipText("");
        comboBoxFloor234.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxFloor234ItemStateChanged(evt);
            }
        });

        btnRefresh1_234.setBackground(new java.awt.Color(0, 255, 255));
        btnRefresh1_234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefresh1_234.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh1_234.setText("Refresh");
        btnRefresh1_234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1_234ActionPerformed(evt);
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
                        .addComponent(comboBoxFloor234, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalTable234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel54)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpntable_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddTable234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditTable234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteTable234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpntable_ManagerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh1_234, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
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
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh1_234)
                .addGap(37, 37, 37)
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(textFieldTotalTable234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel55))
                    .addComponent(jLabel54))
                .addGap(26, 26, 26))
        );

        MainManager_234.add(Jpntable_Manager, "card4");

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
        jScrollPane8.setViewportView(tableDrinkManager234);

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel58.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 0));
        jLabel58.setText("YMACH COFFEE");

        textFieldTotalDrink234.setText("...");
        textFieldTotalDrink234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalDrink234ActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 0));
        jLabel59.setText("Tổng số món :");

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

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 0));
        jLabel60.setText("Tên đồ uống :");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 0));
        jLabel61.setText("Loại đồ uống :");

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

        comboBoxTypeDrink234.setBackground(new java.awt.Color(0, 255, 255));
        comboBoxTypeDrink234.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxTypeDrink234.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cà Phê", "Trà ", "Trà Sứa", "Sinh tố, Nước ép", " " }));
        comboBoxTypeDrink234.setToolTipText("");
        comboBoxTypeDrink234.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTypeDrink234ItemStateChanged(evt);
            }
        });

        btnRefresh2_234.setBackground(new java.awt.Color(0, 255, 255));
        btnRefresh2_234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefresh2_234.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh2_234.setText("Refresh");
        btnRefresh2_234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh2_234ActionPerformed(evt);
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
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTypeDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNameDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(0, 1280, Short.MAX_VALUE)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel57)
                        .addGap(70, 70, 70))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnMenu_ManagerLayout.createSequentialGroup()
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh2_234, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnMenu_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1738, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDrink234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditDrink234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDrink234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jpnSupplierInformationLayout.setVerticalGroup(
            jpnSupplierInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSupplierInformationLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addGap(0, 0, 0))

        JpnMenu_ManagerLayout.setVerticalGroup(
            JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60)
                        .addComponent(jLabel61)
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
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(btnRefresh2_234)
                .addGap(37, 37, 37)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(textFieldTotalDrink234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58))
                    .addComponent(jLabel57))
                .addGap(26, 26, 26))

        );

        MainManager_234.add(JpnMenu_Manager, "card5");

        javax.swing.GroupLayout managePanel234Layout = new javax.swing.GroupLayout(managePanel234);
        managePanel234.setLayout(managePanel234Layout);
        managePanel234Layout.setHorizontalGroup(
            managePanel234Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanel234Layout.createSequentialGroup()
                .addComponent(MenuManager_234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainManager_234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        managePanel234Layout.setVerticalGroup(
            managePanel234Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainManager_234, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel307.add(managePanel234, "managePanel234");

        getContentPane().add(mainPanel307, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSell307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSell307ActionPerformed
        card.show(mainPanel307, "sellPanel");
    }//GEN-LAST:event_btnSell307ActionPerformed

    private void btnWarehouse307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarehouse307ActionPerformed
        card.show(mainPanel307, "warehousePanel");
        buttonListIsSelectedWarehouse(0);
        panelIsSelectedWarehouse(0);
    }//GEN-LAST:event_btnWarehouse307ActionPerformed

    private void logOutButton307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButton307ActionPerformed
        this.setVisible(false);
        new SignInFrame().setVisible(true);
    }//GEN-LAST:event_logOutButton307ActionPerformed

    private void btnManage307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManage307ActionPerformed
        card.show(mainPanel307, "managePanel234");
        lableIsSelectedManage(0);
        lableListIsSelected(0);
    }//GEN-LAST:event_btnManage307ActionPerformed

    private void btnStatistical307MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatistical307MouseClicked

    }//GEN-LAST:event_btnStatistical307MouseClicked

    private void btnStatistical307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatistical307ActionPerformed
        card.show(mainPanel307, "panelAll338");
        panelIsSelectedStatistical(0);
        buttonListIsSelected(0);
    }//GEN-LAST:event_btnStatistical307ActionPerformed

    private void btnStatisSalary338MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisSalary338MouseClicked
        // TODO add your handling code here:
        panelIsSelectedStatistical(1);
        buttonListIsSelected(1);
    }//GEN-LAST:event_btnStatisSalary338MouseClicked

    private void btnStatisBill338MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisBill338MouseClicked
        // TODO add your handling code here:
        panelIsSelectedStatistical(0);
        buttonListIsSelected(0);
    }//GEN-LAST:event_btnStatisBill338MouseClicked

    private void btnStatisWareH338MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisWareH338MouseClicked
        // TODO add your handling code here:
        panelIsSelectedStatistical(2);
        buttonListIsSelected(2);
    }//GEN-LAST:event_btnStatisWareH338MouseClicked

    private void btnStatisLN338MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisLN338MouseClicked
        // TODO add your handling code here
        panelIsSelectedStatistical(3);
        buttonListIsSelected(3);
        countTKHDB338();
        countTKHDN338();
        countTKNV338();
    }//GEN-LAST:event_btnStatisLN338MouseClicked

    private void btnRevenue338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenue338ActionPerformed
        
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        // TODO add your handling code here:
        datefrom = sf.format(jDateChooser3.getDate());
        dateto = sf.format(jDateChooser4.getDate());
        
        clearTableTKKho338(dftableTKHoaDonModel);
        setTableTKHoaDonDate338();
    }//GEN-LAST:event_btnRevenue338ActionPerformed

    public void setTableTKHoaDonDate338() {
        String columns[] = {
            "Mã hóa đơn", "Thời gian", "Bàn", "Thành tiền"
        };
        dftableTKHoaDonModel.setColumnIdentifiers(columns);
        tblReceipt338.setModel(dftableTKHoaDonModel);
        showDataTKHoaDon338();
    }
    
    public void showDataTKHoaDonDate338() {
        try {
            ResultSet rs = sqlHandler.getAllDataTKHoaDonDate338(datefrom, dateto);
            while (rs.next()) {
                Object[] rows = {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
                };
                dftableTKHoaDonModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    private void cbbSalarySort307ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSalarySort307ItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSalarySort307ItemStateChanged

    private void btnSalary307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalary307ActionPerformed
        
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalary307ActionPerformed

    private void btnXuatExcelSalary307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelSalary307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelSalary307ActionPerformed

    private void tbSalary307MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalary307MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSalary307MouseClicked

    private void cbbMoneyGroup338ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMoneyGroup338ItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMoneyGroup338ItemStateChanged

    private void btnWareH338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWareH338ActionPerformed
        
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        // TODO add your handling code here:
        datefrom = sf.format(jDateChooser2.getDate());
        dateto = sf.format(jDateChooser1.getDate());
        clearTableTKKho338(dftableTKKhoModel);
        setTableTKKhoDate338();
    }//GEN-LAST:event_btnWareH338ActionPerformed

    public void showDataDateTKKho338() {
        try {
            ResultSet rs = sqlHandler.getDataDate338(datefrom, dateto);
            while (rs.next()) {
                Object[] rows = {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                };
                dftableTKKhoModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setTableTKKhoDate338() {
        String columns[] = {
            "Mã hóa đơn", "Mã nhà cung cấp", "Tên nhà cung cấp", "Thời gian", "Mã nguyên liệu", "Số lượng", "Giá", "Thành tiền"
        };
        dftableTKKhoModel.setColumnIdentifiers(columns);
        tbSale338.setModel(dftableTKKhoModel);
        showDataDateTKKho338();
    }
    
    
    private void btnExcelWare338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelWare338ActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("ThongKeKho");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);// để lại 2 dòng trống
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH KHO");
            
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MA HD");
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("MA NCC ");
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("TEN NCC");
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("THOI GIAN");
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("MA NGUYEN LIEU");
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("SO LUONG");
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("GIA");
            
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("THANH TIEN");
            int i = 0;
            ResultSet rs = sqlHandler.getAllDataTKKho338();
            while (rs.next()) {
                row = sheet.createRow(4 + i);
                
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                
                cell = row.createCell(1, CellType.STRING);                
                cell.setCellValue(rs.getInt(1));
                
                cell = row.createCell(2, CellType.STRING);                
                cell.setCellValue(rs.getInt(2));
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(rs.getString(3));
                
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(rs.getString(4));
                
                cell = row.createCell(5, CellType.STRING);                
                cell.setCellValue(rs.getInt(5));
                
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(rs.getString(6));
                
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(rs.getString(7));
                
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(rs.getString(8));                
                
                i++;
            }
            
            File f = new File("D://ThongKeKho.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(this, "in thanh cong D:\\ThongKeKho");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }        
    }//GEN-LAST:event_btnExcelWare338ActionPerformed


    private void JlbEmloyee_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbEmloyee_managerMouseClicked

    private void tbSales339MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSales339MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSales339MouseClicked

    private void cbbDishGroup340ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDishGroup340ItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDishGroup340ItemStateChanged

    private void btnSales338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSales338ActionPerformed

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSales338ActionPerformed

    private void btnXuatExcelSale338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelSale338ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelSale338ActionPerformed

    private void tbSales338MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSales338MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSales338MouseClicked

    private void btnNhapMua111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMua111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelectedWarehouse(0);
        panelIsSelectedWarehouse(0);
    }//GEN-LAST:event_btnNhapMua111ActionPerformed

    private void btnNhapKho111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapKho111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelectedWarehouse(1);
        panelIsSelectedWarehouse(1);
    }//GEN-LAST:event_btnNhapKho111ActionPerformed

    private void btnKiiemKe111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiiemKe111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelectedWarehouse(2);
        panelIsSelectedWarehouse(2);
    }//GEN-LAST:event_btnKiiemKe111ActionPerformed

    private void btnDanhMuc111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMuc111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelectedWarehouse(3);
        panelIsSelectedWarehouse(3);
    }//GEN-LAST:event_btnDanhMuc111ActionPerformed

    private void btnThongTinNCC111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinNCC111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelectedWarehouse(4);
        panelIsSelectedWarehouse(4);
    }//GEN-LAST:event_btnThongTinNCC111ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnTable1318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable1318ActionPerformed
        // TODO add your handling code here:

        {
            new Order().setVisible(true);
        }
    }//GEN-LAST:event_btnTable1318ActionPerformed

    private void btnTable2318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable2318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable2318ActionPerformed

    private void btnTable3318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable3318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable3318ActionPerformed

    private void btnTable4318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable4318ActionPerformed
        // TODO add your handling code here:

        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable4318ActionPerformed

    private void btnTable5318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable5318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable5318ActionPerformed

    private void btnTable6318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable6318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable6318ActionPerformed

    private void btnTable7318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable7318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable7318ActionPerformed

    private void btnTable8318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable8318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable8318ActionPerformed

    private void btnTable9318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable9318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable9318ActionPerformed

    private void btnTable10318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable10318ActionPerformed
        // TODO add your handling code here:
        new Order().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable10318ActionPerformed

    private void JlbEmloyee_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbEmloyee_managerMouseClicked
        // TODO add your handling code here:
        lableIsSelectedManage(0);
        lableListIsSelected(0);
        System.out.print("a");

    }//GEN-LAST:event_JlbEmloyee_managerMouseClicked

    private void JlbTable_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbTable_managerMouseClicked
        lableIsSelectedManage(1);
        lableListIsSelected(1);
    }//GEN-LAST:event_JlbTable_managerMouseClicked

    private void JlbMenu_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbMenu_managerMouseClicked
        lableIsSelectedManage(2);
        lableListIsSelected(2);
    }//GEN-LAST:event_JlbMenu_managerMouseClicked

    private void textFieldTotalTable234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalTable234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalTable234ActionPerformed

    private void btnEditTable234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditTable234MouseClicked
        EditTable at = new EditTable();
        at.setVisible(true);
    }//GEN-LAST:event_btnEditTable234MouseClicked

    private void btnAddTable234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTable234MouseClicked
        AddTable at = new AddTable();
        at.setVisible(true);
    }//GEN-LAST:event_btnAddTable234MouseClicked

    private void btnDeleteTable234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteTable234MouseClicked
        int row = tableTableManeger234.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn muốn xóa trươc", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.valueOf(String.valueOf(tableTableManeger234.getValueAt(row, 0)));
            service.deleteTable(id);
            defaultTableModelTB.setRowCount(0);
            List<Table> tbs = service.getAllTable_234();

            for (Table e : tbs) {
                defaultTableModelTB.addRow(new Object[]{e.getId(), e.getTang(), e.getBan(),});
            }
        }
    }//GEN-LAST:event_btnDeleteTable234MouseClicked

    private void comboBoxFloor234ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxFloor234ItemStateChanged
        // TODO add your handling code here:
        defaultTableModelTB.setRowCount(0);
        List<Table> tbs = service.getAllTable_234(comboBoxFloor234.getSelectedIndex() + 1);

        for (Table e : tbs) {
            defaultTableModelTB.addRow(new Object[]{e.getId(), e.getTang(), e.getBan(),});
        }
    }//GEN-LAST:event_comboBoxFloor234ItemStateChanged

    private void btnRefresh1_234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1_234ActionPerformed
        // TODO add your handling code here:
        defaultTableModelTB.setRowCount(0);
        List<Table> tbs = service.getAllTable_234();

        for (Table e : tbs) {
            defaultTableModelTB.addRow(new Object[]{e.getId(), e.getTang(), e.getBan(),});
        }
    }//GEN-LAST:event_btnRefresh1_234ActionPerformed

    private void textFieldTotalDrink234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalDrink234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalDrink234ActionPerformed

    private void btnEditDrink234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditDrink234MouseClicked
        EditMenu at = new EditMenu();
        at.setVisible(true);
    }//GEN-LAST:event_btnEditDrink234MouseClicked

    private void btnAddDrink234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDrink234MouseClicked
        AddMenu at = new AddMenu();
        at.setVisible(true);
    }//GEN-LAST:event_btnAddDrink234MouseClicked

    private void textFieldNameDrink234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNameDrink234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNameDrink234ActionPerformed

    private void textFieldNameDrink234KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNameDrink234KeyReleased
        // TODO add your handling code here:
        defaultTableModelMN.setRowCount(0);
        List<Menu_entity> mns = service.getAllMenu_234(String.valueOf(textFieldNameDrink234.getText()).trim());

        for (Menu_entity e : mns) {

            defaultTableModelMN.addRow(new Object[]{e.getIdP(), e.getNameC(), e.getNameP(), e.getPrice()});
        }
    }//GEN-LAST:event_textFieldNameDrink234KeyReleased

    private void btnDeleteDrink234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDrink234MouseClicked
        // TODO add your handling code here:
        int row = tableDrinkManager234.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn muốn xóa trươc", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.valueOf(String.valueOf(tableDrinkManager234.getValueAt(row, 0)));
            service.deleteMenu(id);
            defaultTableModelMN.setRowCount(0);
            List<Menu_entity> mns = service.getAllMenu_234();

            for (Menu_entity e : mns) {

                defaultTableModelMN.addRow(new Object[]{e.getIdP(), e.getNameC(), e.getNameP(), e.getPrice()});
            }
        }
    }//GEN-LAST:event_btnDeleteDrink234MouseClicked

    private void comboBoxTypeDrink234ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTypeDrink234ItemStateChanged
        // TODO add your handling code here:
        defaultTableModelMN.setRowCount(0);
        List<Menu_entity> mns = service.getAllMenu1_234(String.valueOf(comboBoxTypeDrink234.getSelectedItem()).trim());

        for (Menu_entity e : mns) {

            defaultTableModelMN.addRow(new Object[]{e.getIdP(), e.getNameC(), e.getNameP(), e.getPrice()});
        }
    }//GEN-LAST:event_comboBoxTypeDrink234ItemStateChanged

    private void btnRefresh2_234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh2_234ActionPerformed
        // TODO add your handling code here:
        defaultTableModelMN.setRowCount(0);
        List<Menu_entity> mns = service.getAllMenu_234();

        for (Menu_entity e : mns) {

            defaultTableModelMN.addRow(new Object[]{e.getIdP(), e.getNameC(), e.getNameP(), e.getPrice()});
        }
    }//GEN-LAST:event_btnRefresh2_234ActionPerformed

    private void textFieldNameEmployee234KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNameEmployee234KeyReleased
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        List<Employee_entity> emp = service.searchEmployee_234(textFieldNameEmployee234.getText());

        for (Employee_entity e : emp) {
            System.out.println(e.getPassword());
            defaultTableModel.addRow(new Object[]{e.getId(), e.getTennv(), e.getNgayVaoLam(), e.getSoDienThoai(), e.getChucVu(), e.getUserName(), e.getPassword()});
        }
    }//GEN-LAST:event_textFieldNameEmployee234KeyReleased

    private void textFieldPosition234KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldPosition234KeyReleased
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        List<Employee_entity> emp = service.searchCVEmployee_234(textFieldPosition234.getText());

        for (Employee_entity e : emp) {
            System.out.println(e.getPassword());
            defaultTableModel.addRow(new Object[]{e.getId(), e.getTennv(), e.getNgayVaoLam(), e.getSoDienThoai(), e.getChucVu(), e.getUserName(), e.getPassword()});
        }
    }//GEN-LAST:event_textFieldPosition234KeyReleased

    private void btnAddEmployee234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddEmployee234MouseClicked
        AddEmployee ae = new AddEmployee();
        ae.setVisible(true);

    }//GEN-LAST:event_btnAddEmployee234MouseClicked

    private void btnEditEmployee234MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditEmployee234MouseClicked
        EditEmployee ee = new EditEmployee();
        ee.setVisible(true);
    }//GEN-LAST:event_btnEditEmployee234MouseClicked

    private void textFieldTotalEmployee234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalEmployee234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalEmployee234ActionPerformed

    private void btnRefresh3_234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh3_234ActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        List<Employee_entity> emp = service.getAllEmployee_234();

        for (Employee_entity e : emp) {
            System.out.println(e.getPassword());
            defaultTableModel.addRow(new Object[]{e.getId(), e.getTennv(), e.getNgayVaoLam(), e.getSoDienThoai(), e.getChucVu(), e.getUserName(), e.getPassword()});
        }
    }//GEN-LAST:event_btnRefresh3_234ActionPerformed

    private void btnXuatExcel338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcel338ActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("ThongKeHD");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);// để lại 2 dòng trống
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH HOA DON");
            
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MA HD");
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("THOI GIAN");
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("BAN");
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("THANH TIEN");
            int i = 0;
            ResultSet rs = sqlHandler.getAllDataTKHoaDon338();
            while (rs.next()) {
                row = sheet.createRow(4 + i);
                
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                
                cell = row.createCell(1, CellType.STRING);
                
                cell.setCellValue(rs.getInt(1));
                
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(rs.getString(2));
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(rs.getString(3));
                
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(rs.getString(4));
                i++;
            }
            
            File f = new File("D://ThongKeHD.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(this, "in thanh cong D:\\ThongKeHD");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }        
    }//GEN-LAST:event_btnXuatExcel338ActionPerformed

    private void cbbMoneyGroup338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMoneyGroup338ActionPerformed
        // TODO add your handling code here:
        if (cbbMoneyGroup338.getSelectedItem().equals("Giảm dần")){
            clearTableTKKho338(dftableTKKhoModel);
            showDataTKKhoDesc338();
        }
        if (cbbMoneyGroup338.getSelectedItem().equals("Tăng dần")){
            clearTableTKKho338(dftableTKKhoModel);
            showDataTKKhoAsc338();
        }
    }//GEN-LAST:event_cbbMoneyGroup338ActionPerformed

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
    private javax.swing.JLabel JlbEmloyee_manager;
    private javax.swing.JLabel JlbMenu_manager;
    private javax.swing.JLabel JlbTable_manager;
    private javax.swing.JPanel JpnEmployee_Manager;
    private javax.swing.JPanel JpnMenu_Manager;
    private javax.swing.JPanel Jpntable_Manager;
    private javax.swing.JPanel MainManager_234;
    private javax.swing.JPanel MenuManager_234;
    private javax.swing.JPanel PanelAllSalary307;
    private javax.swing.JPanel PanelAllSale338;
    private javax.swing.JPanel PanelAllWare338;
    private javax.swing.JPanel PanelBill338;
    private javax.swing.JPanel PanelCenter338;
    private javax.swing.JPanel PanelCenterSalary307;
    private javax.swing.JPanel PanelCenterSales338;
    private javax.swing.JPanel PanelDetails338;
    private javax.swing.JPanel PanelMenu338;
    private javax.swing.JPanel PanelNorth340;
    private javax.swing.JPanel PanelNorthSalary307;
    private javax.swing.JPanel PanelNorthSales338;
    private javax.swing.JPanel PanelRevenueManagerment338;
    private javax.swing.JPanel PanelSalary338;
    private javax.swing.JPanel PanelSales338;
    private javax.swing.JPanel PanelSouth338;
    private javax.swing.JPanel PanelSouthSalary307;
    private javax.swing.JPanel PanelSouthSales338;
    private javax.swing.JPanel PanelTKHD;
    private javax.swing.JPanel PanelTKHD2;
    private javax.swing.JPanel PanelTNV;
    private javax.swing.JPanel PanelWareHouse338;
    private javax.swing.JPanel bannerPanel307;
    private javax.swing.JLabel btnAddDrink234;
    private javax.swing.JLabel btnAddEmployee234;
    private javax.swing.JLabel btnAddTable234;
    private javax.swing.JButton btnDanhMuc111;
    private javax.swing.JLabel btnDeleteDrink234;
    private javax.swing.JLabel btnDeleteTable234;
    private javax.swing.JLabel btnEditDrink234;
    private javax.swing.JLabel btnEditEmployee234;
    private javax.swing.JLabel btnEditTable234;
    private javax.swing.JButton btnExcelWare338;
    private javax.swing.JButton btnKiiemKe111;
    private javax.swing.JButton btnManage307;
    private javax.swing.JButton btnNhapKho111;
    private javax.swing.JButton btnNhapMua111;
    private javax.swing.JButton btnRefresh1_234;
    private javax.swing.JButton btnRefresh2_234;
    private javax.swing.JButton btnRefresh3_234;
    private javax.swing.JButton btnRevenue338;
    private javax.swing.JButton btnSalary307;


    private javax.swing.JButton btnSales338;
    private javax.swing.JLabel btnSearchDrink234;
    private javax.swing.JLabel btnSearchNameEmployee234;
    private javax.swing.JLabel btnSearchPosition234;
    private javax.swing.JButton btnSeeDetail338;
    private javax.swing.JButton btnSell307;
    private javax.swing.JButton btnStatisBill338;
    private javax.swing.JButton btnStatisLN338;
    private javax.swing.JButton btnStatisSalary338;
    private javax.swing.JButton btnStatisWareH338;
    private javax.swing.JButton btnStatistical307;
    private javax.swing.JButton btnTable10318;
    private javax.swing.JButton btnTable1318;
    private javax.swing.JButton btnTable2318;
    private javax.swing.JButton btnTable3318;
    private javax.swing.JButton btnTable4318;
    private javax.swing.JButton btnTable5318;
    private javax.swing.JButton btnTable6318;
    private javax.swing.JButton btnTable7318;
    private javax.swing.JButton btnTable8318;
    private javax.swing.JButton btnTable9318;
    private javax.swing.JButton btnThongTinNCC111;
    private javax.swing.JButton btnWareH338;
    private javax.swing.JButton btnWarehouse307;
    private javax.swing.JButton btnXuatExcel338;
    private javax.swing.JButton btnXuatExcelSalary307;
    private javax.swing.JComboBox<String> cbbMoneyGroup338;
    private javax.swing.JComboBox<String> cbbSalarySort307;

    private javax.swing.JComboBox<String> comboBoxFloor234;
    private javax.swing.JComboBox<String> comboBoxTypeDrink234;
    private com.toedter.calendar.JDateChooser dateChooser1;
    private com.toedter.calendar.JDateChooser dateChooser10;
    private com.toedter.calendar.JDateChooser dateChooser2;
    private com.toedter.calendar.JDateChooser dateChooser3;
    private com.toedter.calendar.JDateChooser dateChooser4;
    private javax.swing.JPanel functionPanel307;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;

    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;

    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;

    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;

    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;

    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;

    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;

    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JPanel jpnIngredientsList;
    private javax.swing.JPanel jpnInventory;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnPurchase;
    private javax.swing.JPanel jpnSupplierInformation;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel jpnWarehouse;
    private javax.swing.JLabel lbCollectedMoney338;
    private javax.swing.JLabel lbSalaryTotal307;
    private javax.swing.JLabel lbSalesMoney_338;
    private javax.swing.JLabel lbTKHBN338;
    private javax.swing.JLabel lbTKHDB338;
    private javax.swing.JLabel lbTKNV338;
    private javax.swing.JButton logOutButton307;
    private javax.swing.JPanel mainPanel307;
    private javax.swing.JPanel managePanel234;
    private javax.swing.JPanel panelAll338;

    private javax.swing.JPanel panelChart338;
    private javax.swing.JPanel panelReservations320;

    private javax.swing.JPanel panelReservations321;

    private javax.swing.JPanel sellPanel;
    private javax.swing.JTable tableDrinkManager234;
    private javax.swing.JTable tableEmployeeManager234;
    private javax.swing.JTable tableTableManeger234;
    private javax.swing.JTable tbSalary307;
    private javax.swing.JTable tbSale338;
    private javax.swing.JTable tblReceipt338;
    private javax.swing.JTextField textFieldNameDrink234;
    private javax.swing.JTextField textFieldNameEmployee234;
    private javax.swing.JTextField textFieldPosition234;
    private javax.swing.JTextField textFieldTotalDrink234;
    private javax.swing.JTextField textFieldTotalEmployee234;
    private javax.swing.JTextField textFieldTotalTable234;
    // End of variables declaration//GEN-END:variables

}
