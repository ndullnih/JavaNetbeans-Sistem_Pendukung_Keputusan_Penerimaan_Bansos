/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ndull
 */
import java.util.Date;
import dao.DAOSupplier;
import model.ModelSupplier;
import model.ModelTabelSupplier;
import view.ViewSupplier;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import dao.InterfaceSupplier;

public class ControllerSupplier {
    ViewSupplier frm;
    InterfaceSupplier in;
    List<ModelSupplier> list;
    
    public ControllerSupplier(ViewSupplier frm){
        this.frm = frm;
        reset();
        in = new DAOSupplier();
        list = in.getAllKaryawan();
    }
    
    public void reset(){
        frm.getTxtIdKaryawan().setText("");
        frm.getTxtNama().setText("");
        frm.getTxtAlamat().setText("");
        frm.getTxtNoTelp().setText("");
        frm.getTxtIdKaryawan().setEnabled(true);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list = in.getAllKaryawan();
        ModelTabelSupplier mtk = new ModelTabelSupplier(list);
        frm.getTblKaryawan().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(int row){
        frm.getTxtIdKaryawan().setText(list.get(row).getIdKaryawan());
        frm.getTxtNama().setText(list.get(row).getNama());
        frm.getTxtAlamat().setText(list.get(row).getAlamat());
        frm.getTxtNoTelp().setText(list.get(row).getNoTelp());
        frm.getTxtIdKaryawan().setEnabled(false);
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelSupplier mk = new ModelSupplier();
        
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty() && !frm.getTxtNama().getText().trim().isEmpty()){
            mk.setIdKaryawan(frm.getTxtIdKaryawan().getText().trim());
            mk.setNama(frm.getTxtNama().getText().trim());
            mk.setAlamat(frm.getTxtAlamat().getText().trim());
            mk.setNoTelp(frm.getTxtNoTelp().getText().trim());
            if (in.insert(mk)){
                JOptionPane.showMessageDialog(frm, "Data berhasil ditambahkan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Id dan Nama harus diisi","Info",2);
        }
    }
    
    public void update(){
        ModelSupplier mk = new ModelSupplier();
        
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty() && !frm.getTxtNama().getText().trim().isEmpty()){
            mk.setIdKaryawan(frm.getTxtIdKaryawan().getText().trim());
            mk.setNama(frm.getTxtNama().getText().trim());
            mk.setAlamat(frm.getTxtAlamat().getText().trim());
            mk.setNoTelp(frm.getTxtNoTelp().getText().trim());
            if (in.update(mk)){
                JOptionPane.showMessageDialog(frm, "Perubahan data berhasil disimpan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Perubahan data gagal disimpan","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Id dan Nama harus diisi","Info",2);
        }
    }
    
    public void delete(){
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty()){
            if (in.delete(frm.getTxtIdKaryawan().getText().trim())){
                JOptionPane.showMessageDialog(frm, "Data berhasil dihapus.","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data gagal dihapus","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Id harus diisi","Info",2);
        }
    }
    
    public void cari(){
        if (!frm.getTxtCari().getText().trim().isEmpty()){
            list = in.getCariKaryawan(frm.getTxtCari().getText().trim());
            ModelTabelSupplier mtk = new ModelTabelSupplier(list);
            frm.getTblKaryawan().setModel(mtk);
        }else{
            list = in.getAllKaryawan();
            ModelTabelSupplier mtk = new ModelTabelSupplier(list);
            frm.getTblKaryawan().setModel(mtk);
        }
    }
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblKaryawan();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(100);
    }
}
