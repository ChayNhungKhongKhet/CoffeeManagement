/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.coffee_management.view;

import com.java.coffee_management.dao.SQLHandler;
import com.sun.jdi.connect.spi.Connection;
import java.awt.CardLayout;
import java.awt.Color;
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
    
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        card = (CardLayout) mainPanel307.getLayout();
        card.show(mainPanel307, "bannerPanel");
        panelListManager();
        labelListManager();
        panelListStatiscal();
        buttonListManager();
        panelListViewWarehouse();
        buttonListViewWarehouse();
        setTableTKHoaDon338();
        setTableTKKho338();
        tongtienthuve338();
        tongtiennhapkho338();
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
        listPanelManage.add(JpnAccount_Manager);
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
        listLabelManage.add(JlbAccount_manager);
    }
    
    public void lableListIsSelected(int index) {
        for (int i = 0; i < listLabelManage.size(); i++) {
            if (index == i) {
                listLabelManage.get(i).setBackground(Color.gray);
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
    }
    
     public void tongtiennhapkho338() {
        double tongtien = 0;
        int row = tbSale338.getRowCount();
        for (int i = 0; i < row; i++) {
            tongtien += Double.valueOf(tbSale338.getModel().getValueAt(i, 7).toString()) * 1000;
        }
        lbSalesMoney_338.setText("" +  df.format(tongtien) + "  VNĐ");
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        jPanel22 = new javax.swing.JPanel();
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
        jSplitPane1 = new javax.swing.JSplitPane();
        jpnMenu = new javax.swing.JPanel();
        btnNhapMua111 = new javax.swing.JButton();
        btnNhapKho111 = new javax.swing.JButton();
        btnKiiemKe111 = new javax.swing.JButton();
        btnDanhMuc111 = new javax.swing.JButton();
        btnThongTinNCC111 = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        jpnPurchase = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel92 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel97 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel98 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jpnWarehouse = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField28 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jpnInventory = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel123 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jpnIngredientsList = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jpnSupplierInformation = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel143 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel144 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jTextField51 = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

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

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
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
                    .addGroup(PanelAllSale338Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(PanelCenter338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelSouth338, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAllSale338Layout.setVerticalGroup(
            PanelAllSale338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAllSale338Layout.createSequentialGroup()
                .addComponent(PanelNorth340, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(PanelAllSale338Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCenter338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addComponent(PanelAllSale338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        managePanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        JlbEmloyee_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbEmloyee_manager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlbEmloyee_manager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbEmloyee_manager.setText("QUẢN LÝ NHÂN VIÊN ");
        JlbEmloyee_manager.setToolTipText("");
        JlbEmloyee_manager.setOpaque(true);
        JlbEmloyee_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbEmloyee_managerMouseClicked(evt);
            }
        });

        JlbTable_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbTable_manager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlbTable_manager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbTable_manager.setText("QUẢN LÝ BÀN ");
        JlbTable_manager.setToolTipText("");
        JlbTable_manager.setOpaque(true);
        JlbTable_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbTable_managerMouseClicked(evt);
            }
        });

        JlbMenu_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbMenu_manager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlbMenu_manager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbMenu_manager.setText("QUẢN LÝ MENU");
        JlbMenu_manager.setToolTipText("");
        JlbMenu_manager.setOpaque(true);
        JlbMenu_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbMenu_managerMouseClicked(evt);
            }
        });

        JlbAccount_manager.setBackground(new java.awt.Color(255, 255, 255));
        JlbAccount_manager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlbAccount_manager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbAccount_manager.setText("QUẢN LÝ TÀI KHOẢN");
        JlbAccount_manager.setToolTipText("");
        JlbAccount_manager.setOpaque(true);
        JlbAccount_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbAccount_managerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JlbAccount_manager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbEmloyee_manager, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(JlbTable_manager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlbMenu_manager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
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

        jPanel7.setLayout(new java.awt.CardLayout());

        Jpntable_Manager.setBackground(new java.awt.Color(69, 32, 16));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable4);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 0));
        jLabel36.setText("YMACH COFFEE");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 0));
        jLabel37.setText("Tổng số bàn :");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/edit (1).png"))); // NOI18N
        jLabel38.setText("SỬA ");
        jLabel38.setOpaque(true);
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icon-add.png"))); // NOI18N
        jLabel39.setText("THÊM ");
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        jLabel40.setOpaque(true);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 0));
        jLabel41.setText("Tên bàn :");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 0));
        jLabel42.setText("Lầu :");

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons-delete.png"))); // NOI18N
        jLabel50.setText("XOÁ");
        jLabel50.setToolTipText("");
        jLabel50.setOpaque(true);
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(204, 255, 204));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LẦU 1 ", "LẦU 2", "LẦU 3", " " }));
        jComboBox2.setToolTipText("");

        javax.swing.GroupLayout Jpntable_ManagerLayout = new javax.swing.GroupLayout(Jpntable_Manager);
        Jpntable_Manager.setLayout(Jpntable_ManagerLayout);
        Jpntable_ManagerLayout.setHorizontalGroup(
            Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpntable_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel35)
                        .addGap(70, 70, 70))
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        Jpntable_ManagerLayout.setVerticalGroup(
            Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel41)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)))
                .addGap(71, 71, 71)
                .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpntable_ManagerLayout.createSequentialGroup()
                        .addGroup(Jpntable_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36))
                    .addComponent(jLabel35))
                .addGap(26, 26, 26))
        );

        jPanel7.add(Jpntable_Manager, "card4");

        JpnMenu_Manager.setBackground(new java.awt.Color(69, 32, 16));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable3);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel52.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 0));
        jLabel52.setText("YMACH COFFEE");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 0));
        jLabel53.setText("Tổng số món :");

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/edit (1).png"))); // NOI18N
        jLabel54.setText("SỬA ");
        jLabel54.setOpaque(true);
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icon-add.png"))); // NOI18N
        jLabel55.setText("THÊM ");
        jLabel55.setOpaque(true);
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        jLabel56.setOpaque(true);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 0));
        jLabel57.setText("Tên đồ uống :");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 0));
        jLabel58.setText("Loại đồ uống :");

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons-delete.png"))); // NOI18N
        jLabel59.setText("XOÁ");
        jLabel59.setToolTipText("");
        jLabel59.setOpaque(true);

        jComboBox1.setBackground(new java.awt.Color(204, 255, 204));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cà Phê", "Trà ", "Trà Sứa", "Sinh tố, Nước ép", " " }));
        jComboBox1.setToolTipText("");

        javax.swing.GroupLayout JpnMenu_ManagerLayout = new javax.swing.GroupLayout(JpnMenu_Manager);
        JpnMenu_Manager.setLayout(JpnMenu_ManagerLayout);
        JpnMenu_ManagerLayout.setHorizontalGroup(
            JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnMenu_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel51)
                        .addGap(70, 70, 70))
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        JpnMenu_ManagerLayout.setVerticalGroup(
            JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel57)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel58)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)))
                .addGap(71, 71, 71)
                .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnMenu_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnMenu_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52))
                    .addComponent(jLabel51))
                .addGap(26, 26, 26))
        );

        jPanel7.add(JpnMenu_Manager, "card5");

        JpnAccount_Manager.setBackground(new java.awt.Color(59, 32, 16));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        jLabel60.setOpaque(true);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        jLabel62.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 0));
        jLabel62.setText("YMACH COFFEE");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 0));
        jLabel63.setText("Tổng số tài khoản :");

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/edit (1).png"))); // NOI18N
        jLabel64.setText("SỬA ");
        jLabel64.setOpaque(true);
        jLabel64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel64MouseClicked(evt);
            }
        });

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icons-delete.png"))); // NOI18N
        jLabel65.setText("Xoá");
        jLabel65.setOpaque(true);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTable2);

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        jLabel66.setOpaque(true);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 0));
        jLabel67.setText("Tên User:");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 0));
        jLabel68.setText("Tên Nhân Viên :");

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icon-add.png"))); // NOI18N
        jLabel69.setText("THÊM ");
        jLabel69.setOpaque(true);
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
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
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnAccount_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel61)
                        .addGap(70, 70, 70))
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        JpnAccount_ManagerLayout.setVerticalGroup(
            JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(jLabel67)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(71, 71, 71)
                .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnAccount_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnAccount_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel62))
                    .addComponent(jLabel61))
                .addGap(26, 26, 26))
        );

        jPanel7.add(JpnAccount_Manager, "card5");

        JpnEmployee_Manager.setBackground(new java.awt.Color(69, 32, 16));
        JpnEmployee_Manager.setForeground(new java.awt.Color(255, 255, 0));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 0));
        jLabel70.setText("Tên Nhân Viên :");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 0));
        jLabel71.setText("Chức Vụ:");

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        jLabel72.setOpaque(true);

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/search.png"))); // NOI18N
        jLabel73.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTable1);

        btnAddEmployee.setBackground(new java.awt.Color(255, 255, 255));
        btnAddEmployee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/icon-add.png"))); // NOI18N
        btnAddEmployee.setText("THÊM ");
        btnAddEmployee.setOpaque(true);
        btnAddEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddEmployeeMouseClicked(evt);
            }
        });

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/edit (1).png"))); // NOI18N
        jLabel74.setText("SỬA ");
        jLabel74.setOpaque(true);
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 0));
        jLabel75.setText("Tổng số nhân viên :");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("VNI-Park", 1, 48)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 0));
        jLabel76.setText("YMACH COFFEE");

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/logo3.png"))); // NOI18N

        javax.swing.GroupLayout JpnEmployee_ManagerLayout = new javax.swing.GroupLayout(JpnEmployee_Manager);
        JpnEmployee_Manager.setLayout(JpnEmployee_ManagerLayout);
        JpnEmployee_ManagerLayout.setHorizontalGroup(
            JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnEmployee_ManagerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel77)
                        .addGap(70, 70, 70))))
        );
        JpnEmployee_ManagerLayout.setVerticalGroup(
            JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)))
                .addGap(71, 71, 71)
                .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnEmployee_ManagerLayout.createSequentialGroup()
                        .addGroup(JpnEmployee_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel76))
                    .addComponent(jLabel77))
                .addGap(19, 19, 19))
        );

        jPanel7.add(JpnEmployee_Manager, "card3");

        javax.swing.GroupLayout managePanelLayout = new javax.swing.GroupLayout(managePanel);
        managePanel.setLayout(managePanelLayout);
        managePanelLayout.setHorizontalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        managePanelLayout.setVerticalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel307.add(managePanel, "managePanel");

        sellPanel.setLayout(new java.awt.GridBagLayout());

        panelReservations320.setBackground(new java.awt.Color(69, 32, 16));
        panelReservations320.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Tầng:");

        jComboBox5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", " " }));

        jPanel12.setBackground(new java.awt.Color(69, 32, 16));
        jPanel12.setLayout(new java.awt.GridLayout(5, 2, 20, 20));

        btnTable1320.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable1320.setText("1");
        btnTable1320.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable1320ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable1320);

        btnTable2318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable2318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable2318.setText("2");
        btnTable2318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable2318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable2318);

        btnTable3318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable3318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable3318.setText("3");
        btnTable3318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable3318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable3318);

        btnTable4318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable4318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable4318.setText("4");
        btnTable4318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable4318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable4318);

        btnTable5318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable5318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable5318.setText("5");
        btnTable5318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable5318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable5318);

        btnTable6318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable6318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable6318.setText("6");
        btnTable6318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable6318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable6318);

        btnTable7318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable7318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable7318.setText("7");
        btnTable7318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable7318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable7318);

        btnTable8318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable8318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable8318.setText("8");
        btnTable8318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable8318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable8318);

        btnTable9318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable9318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable9318.setText("9");
        btnTable9318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable9318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable9318);

        btnTable10318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTable10318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Table318.png"))); // NOI18N
        btnTable10318.setText("10");
        btnTable10318.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTable10318ActionPerformed(evt);
            }
        });
        jPanel12.add(btnTable10318);

        jButton11.setBackground(new java.awt.Color(0, 204, 204));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(51, 255, 0));

        jLabel81.setForeground(new java.awt.Color(255, 255, 0));
        jLabel81.setText("Free");

        jLabel82.setForeground(new java.awt.Color(255, 255, 0));
        jLabel82.setText("Reserved");

        jButton13.setBackground(new java.awt.Color(204, 0, 204));

        jLabel83.setForeground(new java.awt.Color(255, 255, 0));
        jLabel83.setText("Serving");

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Logo318.png"))); // NOI18N

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(204, 0, 0));
        jLabel85.setText("YMACH COFFEE");

        javax.swing.GroupLayout panelReservations320Layout = new javax.swing.GroupLayout(panelReservations320);
        panelReservations320.setLayout(panelReservations320Layout);
        panelReservations320Layout.setHorizontalGroup(
            panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelReservations320Layout.createSequentialGroup()
                .addGroup(panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservations320Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel82))
                    .addGroup(panelReservations320Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel83)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelReservations320Layout.createSequentialGroup()
                .addGroup(panelReservations320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservations320Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservations320Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel85)
                        .addGap(76, 76, 76))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 322;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        sellPanel.add(panelReservations320, gridBagConstraints);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/java/coffee_management/image/Sell318.jpg"))); // NOI18N
        jPanel13.add(jLabel86, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 299;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 566);
        sellPanel.add(jPanel13, gridBagConstraints);

        mainPanel307.add(sellPanel, "sellPanel");

        jSplitPane1.setBackground(new java.awt.Color(69, 32, 16));

        jpnMenu.setBackground(new java.awt.Color(69, 32, 16));
        jpnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNhapMua111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhapMua111.setText("NHẬP MUA");
        btnNhapMua111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMua111ActionPerformed(evt);
            }
        });

        btnNhapKho111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhapKho111.setText("NHẬP KHO");
        btnNhapKho111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapKho111ActionPerformed(evt);
            }
        });

        btnKiiemKe111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKiiemKe111.setText("KIỂM KÊ");
        btnKiiemKe111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiiemKe111ActionPerformed(evt);
            }
        });

        btnDanhMuc111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDanhMuc111.setText("DANH MỤC NL");
        btnDanhMuc111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMuc111ActionPerformed(evt);
            }
        });

        btnThongTinNCC111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThongTinNCC111, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDanhMuc111, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiiemKe111, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapKho111, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapMua111, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnNhapMua111, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnNhapKho111, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnKiiemKe111, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnDanhMuc111, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnThongTinNCC111, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jpnMenu);

        jpnView.setLayout(new java.awt.CardLayout());

        jpnPurchase.setBackground(new java.awt.Color(255, 255, 204));

        jPanel11.setBackground(new java.awt.Color(69, 32, 16));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 0, 0));
        jLabel87.setText("PHIẾU NHẬP MUA");
        jLabel87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jLabel87.setOpaque(true);

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
        jScrollPane11.setViewportView(jTable5);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Tạo mới");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Sửa");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel88.setText("Tên nhân viên:");

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel89.setText("Mã nhân viên:");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel90.setText("Mã phiếu nhập:");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel91.setText("Ngày nhập");

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel92.setText("Tên NCC:");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel93.setText("Mã NCC:");

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel94.setText("Tên NVL:");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel95.setText("Mã NVL:");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel96.setText("Loại NVL:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel97.setText("Số lượng:");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel98.setText("Đơn vị tính:");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel99.setText("Đơn giá:");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel100.setText("Thành tiền:");

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel101.setText("VNĐ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel88)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel92)
                                            .addComponent(jLabel94)
                                            .addComponent(jLabel96))
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField14)
                                                .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.LEADING, 0, 113, Short.MAX_VALUE)
                                                .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel98))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel95)
                                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField18))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(jLabel90)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTextField20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jButton3)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnPurchaseLayout = new javax.swing.GroupLayout(jpnPurchase);
        jpnPurchase.setLayout(jpnPurchaseLayout);
        jpnPurchaseLayout.setHorizontalGroup(
            jpnPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPurchaseLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnPurchaseLayout.setVerticalGroup(
            jpnPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPurchaseLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jpnView.add(jpnPurchase, "card2");

        jPanel15.setBackground(new java.awt.Color(69, 32, 16));

        jLabel102.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 204, 51));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("PHIẾU NHẬP KHO");

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel103.setText("Tên NV:");

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel104.setText("Mã NV:");

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel105.setText("Ngày/tháng/năm:");

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("Mã phiếu nhập:");

        jTextField21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel104)
                        .addGap(65, 65, 65)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jLabel104)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(jLabel106)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel107.setText("Tên NL:");

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel108.setText("Mã NL:");

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel109.setText("Phân loại:");

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel110.setText("Số lượng nhập:");

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("Đơn vị tính:");

        jTextField24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel107)
                            .addComponent(jLabel109))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField24, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jTextField25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel108)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel110)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(116, 116, 116))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel108)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel109)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel110)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(jTable6);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Thêm");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Sửa");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane12)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(72, 72, 72)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton6)
                            .addGap(178, 178, 178)))
                    .addComponent(jLabel102))
                .addContainerGap(1125, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel102)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton4)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jpnWarehouseLayout = new javax.swing.GroupLayout(jpnWarehouse);
        jpnWarehouse.setLayout(jpnWarehouseLayout);
        jpnWarehouseLayout.setHorizontalGroup(
            jpnWarehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnWarehouseLayout.setVerticalGroup(
            jpnWarehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnWarehouseLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jpnView.add(jpnWarehouse, "card3");

        jPanel17.setBackground(new java.awt.Color(69, 32, 16));

        jLabel112.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 204, 51));
        jLabel112.setText("PHIẾU KIỂM KÊ");

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel113.setText("Mục đích");

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel114.setText("Loại hàng kiểm kê");

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel115.setText("Ngày kiểm kê");

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel116.setText("Mã phiếu kiểm kê:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
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
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nguyên vật liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117.setText("Mã NVL:");

        jTextField32.setText("jTextField4");

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel118.setText("Tên NVL:");

        jTextField33.setText("jTextField5");

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel119.setText("Số lượng kiểm kê:");

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel120.setText("Số lượng chênh lệch");

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel121.setText("Nguyên nhân:");

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel122.setText("Xử lý:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane13.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane14.setViewportView(jTextArea2);

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel123.setText("Số lượng theo sổ:");

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel124.setText("Đơn vị tính:");

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
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119)
                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel118)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel121)
                                .addComponent(jLabel122))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel124)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(jTable7);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Thêm");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Sửa");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel112))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                            .addComponent(jSeparator4)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnInventoryLayout = new javax.swing.GroupLayout(jpnInventory);
        jpnInventory.setLayout(jpnInventoryLayout);
        jpnInventoryLayout.setHorizontalGroup(
            jpnInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInventoryLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnInventoryLayout.setVerticalGroup(
            jpnInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnInventoryLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jpnView.add(jpnInventory, "card4");

        jPanel9.setBackground(new java.awt.Color(69, 32, 16));

        jPanel10.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel125.setText("Tên NL:");

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel126.setText("Mã NL:");

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel127.setText("Hạn dùng:");

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel128.setText("Giá:");

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel129.setText("Nhà cung cấp:");

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel130.setText("Tổng số:");

        jTextField38.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField39.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel131.setText("(VNĐ)");

        jTextField42.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField43.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel125)
                    .addComponent(jLabel126)
                    .addComponent(jLabel127))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel128)
                    .addComponent(jLabel129)
                    .addComponent(jLabel130))
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField41, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jTextField42)
                    .addComponent(jTextField43))
                .addGap(18, 18, 18)
                .addComponent(jLabel131)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(jLabel128)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jLabel129)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(jLabel130)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel132.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 204, 51));
        jLabel132.setText("THÔNG TIN NGUYÊN LIỆU");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(jTable8);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Thêm");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("Sửa");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel132)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel132)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)))
                .addContainerGap(363, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnIngredientsListLayout = new javax.swing.GroupLayout(jpnIngredientsList);
        jpnIngredientsList.setLayout(jpnIngredientsListLayout);
        jpnIngredientsListLayout.setHorizontalGroup(
            jpnIngredientsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnIngredientsListLayout.setVerticalGroup(
            jpnIngredientsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.add(jpnIngredientsList, "card5");

        jPanel19.setBackground(new java.awt.Color(69, 32, 16));

        jLabel133.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 0));
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("QUẢN LÝ THÔNG TIN NHÀ CUNG CẤP");

        jPanel20.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel134.setText("Người liên hệ:");

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel135.setText("Di động:");

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel136.setText("Email:");

        jTextField44.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField45.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField46.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel134)
                    .addComponent(jLabel135))
                .addGap(32, 32, 32)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jLabel136))
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(jLabel136)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel137.setText("Công ty:");

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel138.setText("Địa chỉ:");

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel139.setText("Thành phố:");

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel140.setText("Điện thoại:");

        jLabel141.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel141.setText("Fax:");

        jTextField47.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField48.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField49.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTextField50.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel142.setText("Thông tin xuất hoá đơn:");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane17.setViewportView(jTextArea3);

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel143.setText("Ghi chú:");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane18.setViewportView(jTextArea4);

        jLabel144.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel144.setText("Nhóm KH/NCC:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel137)
                            .addComponent(jLabel138)
                            .addComponent(jLabel139)
                            .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField47)
                                        .addComponent(jComboBox3, 0, 153, Short.MAX_VALUE)
                                        .addComponent(jTextField48)
                                        .addComponent(jTextField49))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel140)
                    .addComponent(jLabel144))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane18)
                    .addComponent(jScrollPane17))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel137)
                            .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel142))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel139))))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel140)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel143)
                                .addGap(81, 81, 81))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel141)
                                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel144)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))))
        );

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 0, 0));
        jButton14.setText("Tìm kiếm");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane19.setViewportView(jTable9);

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("Thêm ");

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setText("Sửa");
        jButton16.setActionCommand("");

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton17.setText("Xoá");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel133)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jButton14))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                    .addComponent(jSeparator5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel133)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton15)
                        .addGap(57, 57, 57)
                        .addComponent(jButton16)
                        .addGap(49, 49, 49)
                        .addComponent(jButton17)))
                .addGap(24, 24, 24)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );

        javax.swing.GroupLayout jpnSupplierInformationLayout = new javax.swing.GroupLayout(jpnSupplierInformation);
        jpnSupplierInformation.setLayout(jpnSupplierInformationLayout);
        jpnSupplierInformationLayout.setHorizontalGroup(
            jpnSupplierInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnSupplierInformationLayout.setVerticalGroup(
            jpnSupplierInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSupplierInformationLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jpnView.add(jpnSupplierInformation, "card6");

        jSplitPane1.setRightComponent(jpnView);

        mainPanel307.add(jSplitPane1, "warehousePanel");

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
        card.show(mainPanel307, "managePanel");
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

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        EditTable at = new EditTable();
        at.setVisible(true);
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        AddTable at = new AddTable();
        at.setVisible(true);
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked

    }//GEN-LAST:event_jLabel50MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        EditMenu at = new EditMenu();
        at.setVisible(true);
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        AddMenu at = new AddMenu();
        at.setVisible(true);
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        EditAccount at = new EditAccount();
        at.setVisible(true);
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        AddAccount at = new AddAccount();
        at.setVisible(true);
    }//GEN-LAST:event_jLabel69MouseClicked

    private void btnAddEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddEmployeeMouseClicked
        AddEmployee ae = new AddEmployee();
        ae.setVisible(true);
    }//GEN-LAST:event_btnAddEmployeeMouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        EditEmployee ee = new EditEmployee();
        ee.setVisible(true);
    }//GEN-LAST:event_jLabel74MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnTable1320ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable1320ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnTable1320ActionPerformed

    private void btnTable2318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable2318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable2318ActionPerformed

    private void btnTable3318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable3318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable3318ActionPerformed

    private void btnTable4318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable4318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable4318ActionPerformed

    private void btnTable5318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable5318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable5318ActionPerformed

    private void btnTable6318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable6318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable6318ActionPerformed

    private void btnTable7318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable7318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable7318ActionPerformed

    private void btnTable8318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable8318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable8318ActionPerformed

    private void btnTable9318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable9318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTable9318ActionPerformed

    private void btnTable10318ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTable10318ActionPerformed
        // TODO add your handling code here:
        new Order_().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnTable10318ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnNhapMua111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMua111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelected(0);
        panelIsSelectedWarehouse(0);
    }//GEN-LAST:event_btnNhapMua111ActionPerformed

    private void btnNhapKho111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapKho111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelected(1);
        panelIsSelectedWarehouse(1);
    }//GEN-LAST:event_btnNhapKho111ActionPerformed

    private void btnKiiemKe111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiiemKe111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelected(2);
        panelIsSelectedWarehouse(2);
    }//GEN-LAST:event_btnKiiemKe111ActionPerformed

    private void btnDanhMuc111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMuc111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelected(3);
        panelIsSelectedWarehouse(3);
    }//GEN-LAST:event_btnDanhMuc111ActionPerformed

    private void btnThongTinNCC111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinNCC111ActionPerformed
        // TODO add your handling code here:
        buttonListIsSelected(4);
        panelIsSelectedWarehouse(4);
    }//GEN-LAST:event_btnThongTinNCC111ActionPerformed

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
    private javax.swing.JLabel JlbAccount_manager;
    private javax.swing.JLabel JlbEmloyee_manager;
    private javax.swing.JLabel JlbMenu_manager;
    private javax.swing.JLabel JlbTable_manager;
    private javax.swing.JPanel JpnAccount_Manager;
    private javax.swing.JPanel JpnEmployee_Manager;
    private javax.swing.JPanel JpnMenu_Manager;
    private javax.swing.JPanel Jpntable_Manager;
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
    private javax.swing.JLabel btnAddEmployee;
    private javax.swing.JButton btnDanhMuc111;
    private javax.swing.JButton btnExcelWare338;
    private javax.swing.JButton btnKiiemKe111;
    private javax.swing.JButton btnManage307;
    private javax.swing.JButton btnNhapKho111;
    private javax.swing.JButton btnNhapMua111;
    private javax.swing.JButton btnRevenue338;
    private javax.swing.JButton btnSalary307;
    private javax.swing.JButton btnSell307;
    private javax.swing.JButton btnStatisBill338;
    private javax.swing.JButton btnStatisLN338;
    private javax.swing.JButton btnStatisSalary338;
    private javax.swing.JButton btnStatisWareH338;
    private javax.swing.JButton btnStatistical307;
    private javax.swing.JButton btnTable10318;
    private javax.swing.JButton btnTable1320;
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
    private com.toedter.calendar.JDateChooser dateChooser3;
    private com.toedter.calendar.JDateChooser dateChooser4;
    private javax.swing.JPanel functionPanel307;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
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
    private javax.swing.JPanel managePanel;
    private javax.swing.JPanel panelAll338;
    private javax.swing.JPanel panelReservations320;
    private javax.swing.JPanel sellPanel;
    private javax.swing.JTable tbSalary307;
    private javax.swing.JTable tbSale338;
    private javax.swing.JTable tblReceipt338;
    // End of variables declaration//GEN-END:variables

}
