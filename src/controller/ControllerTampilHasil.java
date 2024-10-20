/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import dao.DAOTampilNilaiKriteria;
import dao.InterfaceTampilNilaiKriteria;
import model.ModelTabelTampilHasil;
import model.ModelTampilHasil;
import view.ViewHasil;
/**
 *
 * @author ndull
 */
public class ControllerTampilHasil {
    ViewHasil frm;
    InterfaceTampilNilaiKriteria in;
    List<ModelTampilHasil> list_nilai;
    DecimalFormat df;
    
    public ControllerTampilHasil(ViewHasil frm){
        this.frm = frm;
        in = new DAOTampilNilaiKriteria();
        list_nilai = in.getHasil();
        df = new DecimalFormat("#.##");
    }
    
    public void isiTable(){
        list_nilai = in.getHasil();
        ModelTabelTampilHasil mtk = new ModelTabelTampilHasil(list_nilai);
        frm.getTblHasil().setModel(mtk);
        setTableColumnSize();
    }
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblHasil();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(50);
    }
}
