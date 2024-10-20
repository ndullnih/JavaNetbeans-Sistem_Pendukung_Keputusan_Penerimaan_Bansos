/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ndull
 */
public class ModelTabelBobotSupplier extends AbstractTableModel{
    final String[] nama_kolom = {"No","Kriteria", "Nilai"};
    List<ModelBobotSupplier> list;
    
    public ModelTabelBobotSupplier(List<ModelBobotSupplier> list){
        this.list = list;
    }
    
    @Override
    public int getColumnCount(){
        return 3;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public String getColumnName(int column){
        return nama_kolom[column];
    }
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return row+1;
            case 1:
                return list.get(row).getKriteria().getNamaKriteria();
            case 2:
                return list.get(row).getSubKriteria().getNamaSubKriteria();
            default:
                return null;
        }
    }
}
