/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.KoneksiMySQL;
import model.ModelSupplier;
/**
 *
 * @author ndull
 */

public class DAOSupplier implements InterfaceSupplier{
    Connection conn;
    final String INSERT = "INSERT INTO tbl_anggota(kta, nama,alamat, no_telp) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE tbl_anggota SET nama=?, alamat=?, no_telp=? WHERE kta=?";
    final String DELETE = "DELETE from tbl_anggota WHERE kta=?";
    final String SELECT = "SELECT * FROM tbl_anggota";
    final String SEARCH = "SELECT * FROM tbl_anggota WHERE nama like ? OR kta=?";
    
    public DAOSupplier(){
        try {
            conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean insert(ModelSupplier m){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(INSERT);
            statement.setString(1, m.getIdKaryawan());
            statement.setString(2, m.getNama());
            statement.setString(3, m.getAlamat());
            statement.setString(4, m.getNoTelp());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public Boolean update(ModelSupplier m){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, m.getNama());
            statement.setString(2, m.getAlamat());
            statement.setString(3, m.getNoTelp());
            statement.setString(4, m.getIdKaryawan());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public Boolean delete(String id){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(DELETE);
            statement.setString(1, id);
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public List<ModelSupplier> getAllKaryawan(){
        List<ModelSupplier> list = null;
        try {
            list = new ArrayList<ModelSupplier>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT);
            while (rs.next()){
                ModelSupplier mk = new ModelSupplier();
                mk.setIdKaryawan(rs.getString("kta"));
                mk.setNama(rs.getString("nama"));
                mk.setAlamat(rs.getString("alamat"));
                mk.setNoTelp(rs.getString("no_telp"));
                list.add(mk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public List<ModelSupplier> getCariKaryawan(String cari){
        List<ModelSupplier> list = null;
        try {
            list = new ArrayList<ModelSupplier>();
            PreparedStatement st = conn.prepareStatement(SEARCH);
            st.setString(1, "%" + cari + "%");
            st.setString(2, cari);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                ModelSupplier mk = new ModelSupplier();
                mk.setIdKaryawan(rs.getString("kta"));
                mk.setNama(rs.getString("nama"));
                mk.setAlamat(rs.getString("alamat"));
                mk.setNoTelp(rs.getString("no_telp"));
                list.add(mk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}