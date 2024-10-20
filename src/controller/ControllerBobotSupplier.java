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
import model.ModelSupplier;
import view.ViewBobotSupplier;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import dao.DAOBobotSupplier;
import dao.DAOKriteria;
import dao.DAOSubKriteria;
import dao.InterfaceKriteria;
import dao.InterfaceSubKriteria;
import model.ModelBobotSupplier;
import model.ModelKriteria;
import model.ModelSubKriteria;
import model.ModelTabelBobotSupplier;
import dao.InterfaceBobotSupplier;

public class ControllerBobotSupplier {
    ViewBobotSupplier frm;
    InterfaceKriteria in_k;
    InterfaceSubKriteria in_s;
    InterfaceBobotSupplier in_bobot;
    List<ModelBobotSupplier> list_bobot;
    List<ModelKriteria> list_k;
    List<ModelSubKriteria> list_s;
    ModelSupplier karyawan;
    
    public ControllerBobotSupplier(ViewBobotSupplier frm, ModelSupplier karyawan){
        this.frm = frm;
        this.karyawan = karyawan;
        in_bobot = new DAOBobotSupplier();
        in_k = new DAOKriteria();
        in_s = new DAOSubKriteria();
        list_bobot = in_bobot.getAllBobotKaryawan(karyawan.getIdKaryawan());
        list_k = in_k.getAllKriteria();
        setFieldKaryawan();
        setItemsKriteria();
        reset();
    }
    
    private void setItemsKriteria(){
        frm.getCboKriteria().setModel(new DefaultComboBoxModel(list_k.toArray()));
        setItemsSubKriteria();
    }
    
    public void setItemsSubKriteria(){
        ModelKriteria k = (ModelKriteria) frm.getCboKriteria().getSelectedItem();
        list_s = in_s.getSubKriteriaByKriteria(k);
        frm.getCboSubKriteria().setModel(new DefaultComboBoxModel(list_s.toArray()));
    }
    
    public void reset(){
        frm.getCboKriteria().setSelectedIndex(0);
        frm.getCboSubKriteria().setSelectedIndex(0);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list_bobot = in_bobot.getAllBobotKaryawan(karyawan.getIdKaryawan());
        ModelTabelBobotSupplier mtk = new ModelTabelBobotSupplier(list_bobot);
        frm.getTblKaryawan().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(int row){
        setSelectedKriteria(list_bobot.get(row).getKriteria().getNamaKriteria());
        setSelectedSubKriteria(list_bobot.get(row).getSubKriteria().getNamaSubKriteria());
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelBobotSupplier mb = new ModelBobotSupplier();
        
        mb.setKaryawan(karyawan);
        mb.setSubKriteria((ModelSubKriteria) frm.getCboSubKriteria().getSelectedItem());
        mb.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        
        if (in_bobot.bobotIsExists(mb.getKaryawan().getIdKaryawan(), mb.getKriteria().getIdKriteria())){
            in_bobot.delete(mb);
        }
        
        if(in_bobot.insert(mb)){
            JOptionPane.showMessageDialog(frm, "Data nilai berhasil ditambahkan","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data nilai gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
        }
    }
    
    public void update(){
        ModelBobotSupplier mb = new ModelBobotSupplier();
        
        mb.setKaryawan(karyawan);
        mb.setSubKriteria((ModelSubKriteria) frm.getCboSubKriteria().getSelectedItem());
        mb.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        
        //JOptionPane.showMessageDialog(frm, in_bobot.bobotIsExists(mb.getKaryawan().getIdKaryawan(), mb.getKriteria().getIdKriteria()));
        
        if (in_bobot.bobotIsExists(mb.getKaryawan().getIdKaryawan(), mb.getKriteria().getIdKriteria())){
            in_bobot.delete(mb);
        }
        
        if(in_bobot.insert(mb)){
            JOptionPane.showMessageDialog(frm, "Data nilai berhasil diubah","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data nilai gagal diubah. Periksa kembali data yang diinput.","Info",0);
        }
    }
    
    public void delete(){
        ModelBobotSupplier mb = new ModelBobotSupplier();
        
        mb.setKaryawan(karyawan);
        mb.setSubKriteria((ModelSubKriteria) frm.getCboSubKriteria().getSelectedItem());
        mb.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        
        if (in_bobot.bobotIsExists(mb.getKaryawan().getIdKaryawan(), mb.getKriteria().getIdKriteria())){
            if (in_bobot.delete(mb)){
                JOptionPane.showMessageDialog(frm, "Data nilai berhasil dihapus","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data nilai gagal dihapus. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nilai dengan kriteria yang dipilih tidak ditemukan","Info",2);
        }
    }
    
    private void setFieldKaryawan(){
        frm.getTxtIdKaryawan().setText(karyawan.getIdKaryawan());
        frm.getTxtNama().setText(karyawan.getNama());
    }
    
    private void setSelectedKriteria(String value){
        String item;
        for(int i=0; i<frm.getCboKriteria().getItemCount();i++){
            item = frm.getCboKriteria().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboKriteria().setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void setSelectedSubKriteria(String value){
        String item;
        for(int i=0; i<frm.getCboSubKriteria().getItemCount();i++){
            item = frm.getCboSubKriteria().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboSubKriteria().setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblKaryawan();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(2).setPreferredWidth(260);
    }
}
