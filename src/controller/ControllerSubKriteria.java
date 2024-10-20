/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import dao.DAOSubKriteria;
import dao.DAOKriteria;
import dao.InterfaceKriteria;
import dao.InterfaceSubKriteria;
import model.ModelKriteria;
import model.ModelSubKriteria;
import model.ModelTabelSubKriteria;
import view.ViewSubKriteria;
/**
 *
 * @author ndull
 */
public class ControllerSubKriteria {
    ViewSubKriteria frm;
    InterfaceSubKriteria in;
    InterfaceKriteria in_kriteria;
    List<ModelSubKriteria> list;
    List<ModelKriteria> list_kriteria;
    
    ModelKriteria kriteria;
    
    public ControllerSubKriteria(ViewSubKriteria frm){
        this.frm = frm;
        in_kriteria = new DAOKriteria();
        list_kriteria = in_kriteria.getAllKriteria();
        setKriteria(list_kriteria);
        in = new DAOSubKriteria();
        kriteria = new ModelKriteria();
        kriteria = (ModelKriteria) frm.getCboKriteria().getSelectedItem();
        list = in.getAllSubKriteria(kriteria.getIdKriteria());
        this.reset();
    }
    
    private void setKriteria(List<ModelKriteria> list_kriteria){
        frm.getCboKriteria().setModel(new DefaultComboBoxModel(list_kriteria.toArray()));
        frm.getCboKriteria().setSelectedIndex(0);
    }
    
    public final void reset(){
        frm.getTxtIdSubKriteria().setText("");
        frm.getTxtNamaSubKriteria().setText("");
        frm.getCboKriteria().setSelectedIndex(0);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        kriteria = (ModelKriteria) frm.getCboKriteria().getSelectedItem();
        
        list = in.getAllSubKriteria(kriteria.getIdKriteria());
        ModelTabelSubKriteria mtk = new ModelTabelSubKriteria(list);
        frm.getTblSubKriteria().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(int row){
        frm.getTxtIdSubKriteria().setText(list.get(row).getIdSubKriteria().toString());
        frm.getTxtNamaSubKriteria().setText(list.get(row).getNamaSubKriteria());
        setSelectedKriteria(list.get(row).getKriteria().getNamaKriteria());
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelSubKriteria mk = new ModelSubKriteria();
        
        if(!frm.getTxtNamaSubKriteria().getText().trim().isEmpty()){
            mk.setNamaSubKriteria(frm.getTxtNamaSubKriteria().getText().trim());
            mk.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
            if(in.insert(mk)){
                JOptionPane.showMessageDialog(frm, "Data subkriteria berhasil ditambahkan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data subkriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama subKriteria harus diisi","Info",2);
        }
    }
    
    public void update(){
        ModelSubKriteria mk = new ModelSubKriteria();
        
        if(!frm.getTxtNamaSubKriteria().getText().trim().isEmpty()){
            mk.setIdSubKriteria(Integer.parseInt(frm.getTxtIdSubKriteria().getText().trim()));
            mk.setNamaSubKriteria(frm.getTxtNamaSubKriteria().getText().trim());
            mk.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
            if(in.update(mk)){
                JOptionPane.showMessageDialog(frm, "Perubahan data subkriteria berhasil disimpan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Perubahan data subkriteria gagal disimpan","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama subkriteria harus diisi","Info",2);
        }
    }
    
    public void delete(){
        if (in.delete(Integer.parseInt(frm.getTxtIdSubKriteria().getText().trim()))){
            JOptionPane.showMessageDialog(frm, "Data subkriteria berhasil dihapus.","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data subkriteria gagal dihapus","Info",0);
        }
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
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblSubKriteria();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(190);
        columnModel.getColumn(3).setPreferredWidth(180);
    }

}
