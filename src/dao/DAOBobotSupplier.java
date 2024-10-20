/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.KoneksiMySQL;
import java.sql.PreparedStatement;
import java.util.List;
import model.ModelBobotSupplier;
import model.ModelKriteria;
import model.ModelSubKriteria;

/**
 *
 * @author ndull
 */
public class DAOBobotSupplier implements InterfaceBobotSupplier{
    Connection conn;
    final String insert = "INSERT INTO tbl_bobot  (kta,id_kriteria,id_subkriteria) VALUES(?,?,?)";
    final String update = "UPDATE tbl_bobot SET id_kriteria=?, id_subkriteria=? WHERE kta=?";
    final String delete = "DELETE FROM tbl_bobot WHERE kta=? AND id_kriteria=?";
    final String select = "SELECT a.id_kriteria, a.nama_kriteria, b.id_subkriteria, b.nama_subkriteria FROM tbl_kriteria a, tbl_subkriteria b, tbl_bobot c WHERE c.id_kriteria=a.id_kriteria AND c.id_subkriteria=b.id_subkriteria AND c.kta=? ORDER BY b.id_kriteria";
    final String cek_isexists = "SELECT * FROM tbl_bobot WHERE kta=? AND id_kriteria=?";
    
    public DAOBobotSupplier(){
        try {
            conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Boolean insert(ModelBobotSupplier m) {
        try {
            PreparedStatement statement = conn.prepareStatement(insert);
            statement.setString(1, m.getKaryawan().getIdKaryawan());
            statement.setInt(2, m.getKriteria().getIdKriteria());
            statement.setInt(3, m.getSubKriteria().getIdSubKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean update(ModelBobotSupplier m) {
        try {
            PreparedStatement statement = conn.prepareStatement(update);
            statement.setInt(1, m.getKriteria().getIdKriteria());
            statement.setInt(2, m.getSubKriteria().getIdSubKriteria());
            statement.setString(3, m.getKaryawan().getIdKaryawan());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean delete(ModelBobotSupplier m) {
        try {
            PreparedStatement statement = conn.prepareStatement(delete);
            statement.setString(1, m.getKaryawan().getIdKaryawan());
            statement.setInt(2, m.getKriteria().getIdKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ModelBobotSupplier> getAllBobotKaryawan(String id_karyawan) {
        List<ModelBobotSupplier> list = null;
        try {
            list = new ArrayList<ModelBobotSupplier>();
            PreparedStatement statement = conn.prepareStatement(select);
            statement.setString(1, id_karyawan);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ModelKriteria kriteria = new ModelKriteria();
                ModelSubKriteria subkriteria = new ModelSubKriteria();
                ModelBobotSupplier karyawan = new ModelBobotSupplier();
                kriteria.setIdKriteria(rs.getInt("id_kriteria"));
                kriteria.setNamaKriteria(rs.getString("nama_kriteria"));
                subkriteria.setIdSubKriteria(rs.getInt("id_subkriteria"));
                subkriteria.setNamaSubKriteria(rs.getString("nama_subkriteria"));
                subkriteria.setKriteria(kriteria);
                karyawan.setKriteria(kriteria);
                karyawan.setSubKriteria(subkriteria);
                list.add(karyawan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Boolean bobotIsExists(String id_karyawan, int id_kriteria) {
        try {
            PreparedStatement statement = conn.prepareStatement(cek_isexists);
            statement.setString(1, id_karyawan);
            statement.setInt(2, id_kriteria);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}