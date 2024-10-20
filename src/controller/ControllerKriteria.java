/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import dao.DAOKriteria;
import dao.InterfaceKriteria;
import model.ModelKriteria;
import model.ModelTabelKriteria;
import view.ViewKriteria;
/**
 *
 * @author ndull
 */
public class ControllerKriteria {
    ViewKriteria frm;
    InterfaceKriteria in;
    List<ModelKriteria> list;
    
    public ControllerKriteria(ViewKriteria frm){
        this.frm = frm;
        reset();
        in = new DAOKriteria();
        list = in.getAllKriteria();
    }
    
    public void reset(){
        frm.getTxtIdKriteria().setText("");
        frm.getTxtNamaKriteria().setText("");
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list = in.getAllKriteria();
        ModelTabelKriteria mtk = new ModelTabelKriteria(list);
        frm.getTblKriteria().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(int row){
        frm.getTxtIdKriteria().setText(list.get(row).getIdKriteria().toString());
        frm.getTxtNamaKriteria().setText(list.get(row).getNamaKriteria());
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelKriteria mk = new ModelKriteria();
        
        if(!frm.getTxtNamaKriteria().getText().trim().isEmpty()){
            mk.setNamaKriteria(frm.getTxtNamaKriteria().getText().trim());
            if(in.insert(mk)){
                JOptionPane.showMessageDialog(frm, "Data kriteria berhasil ditambahkan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data kriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama Kriteria harus diisi","Info",2);
        }
    }
    
    public void update(){
        ModelKriteria mk = new ModelKriteria();
        
        if(!frm.getTxtNamaKriteria().getText().trim().isEmpty()){
            mk.setIdKriteria(Integer.parseInt(frm.getTxtIdKriteria().getText().trim()));
            mk.setNamaKriteria(frm.getTxtNamaKriteria().getText().trim());
            if(in.update(mk)){
                JOptionPane.showMessageDialog(frm, "Perubahan data kriteria berhasil disimpan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Perubahan data kriteria gagal disimpan","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama Kriteria harus diisi","Info",2);
        }
    }
    
    public void delete(){
        if (in.delete(Integer.parseInt(frm.getTxtIdKriteria().getText().trim()))){
            JOptionPane.showMessageDialog(frm, "Data kriteria berhasil dihapus.","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data kriteria gagal dihapus","Info",0);
        }
    }
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblKriteria();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(360);
    }
}
