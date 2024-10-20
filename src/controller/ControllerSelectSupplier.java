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
import dao.DAOSupplier;
import model.ModelSupplier;
import model.ModelTabelSupplier;
import view.ViewSelectSupplier;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import view.ViewBobotSupplier;
import dao.InterfaceSupplier;

public class ControllerSelectSupplier {
    ViewSelectSupplier frm;
    InterfaceSupplier in;
    List<ModelSupplier> list;
    ModelSupplier karyawan;
    
    public ControllerSelectSupplier(ViewSelectSupplier frm){
        this.frm = frm;
        in = new DAOSupplier();
        list = in.getAllKaryawan();
        karyawan = new ModelSupplier();
    }
    
    public void isiTable(){
        list = in.getAllKaryawan();
        ModelTabelSupplier mtk = new ModelTabelSupplier(list);
        frm.getTblKaryawan().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(int row){
        karyawan = list.get(row);
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
    
    public void showBobotKaryawan(){
        this.frm.dispose();
        new ViewBobotSupplier(karyawan).setVisible(true);
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
