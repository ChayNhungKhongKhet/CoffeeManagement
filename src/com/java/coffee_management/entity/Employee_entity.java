/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.entity;

/**
 *
 * @author ASUS
 */
public class Employee_entity {
    private String tennv;
    private String ngayVaoLam;
    private String SoDienThoai;
    private String ChucVu;

    public Employee_entity() {
    }

    public Employee_entity(String tennv, String ngayVaoLam, String SoDienThoai, String ChucVu) {
        this.tennv = tennv;
        this.ngayVaoLam = ngayVaoLam;
        this.SoDienThoai = SoDienThoai;
        this.ChucVu = ChucVu;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
    
}
