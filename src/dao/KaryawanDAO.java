/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import koneksi.koneksi;
import java.sql.SQLException;
import model.modelKaryawan;
/**
 *
 * @author User
 */
public class KaryawanDAO {
    Connection kon;
    PreparedStatement ps;
    ResultSet rs;
    modelKaryawan karyawan;
    
    public KaryawanDAO() {
        this.kon = koneksi.getConnection();
    }
    
    public void login(modelKaryawan karyawan) {
        String sql = "SELECT * FROM karyawan WHERE nama_karyawan = ? AND password = ?";

        try {
            ps = kon.prepareStatement(sql);
            ps.setString(1, karyawan.getNama_karyawan());
            ps.setString(2, karyawan.getPassword()); 
            rs = ps.executeQuery();

            if (rs.next()) {
                karyawan.setId_karyawan(rs.getString("id_karyawan"));
                karyawan.setJabatan(rs.getString("jabatan"));
            } else {
                karyawan.setId_karyawan(null);
                karyawan.setJabatan(null);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
    
}
