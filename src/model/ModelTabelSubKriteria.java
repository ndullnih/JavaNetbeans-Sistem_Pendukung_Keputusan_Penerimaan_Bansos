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
public class ModelTabelSubKriteria extends AbstractTableModel{
    final String[] nama_kolom = {"No","ID Sub Kriteria","Nama Sub Kriteria","Nama Kriteria"};
    List<ModelSubKriteria> list;
    
    public ModelTabelSubKriteria(List<ModelSubKriteria> list){
        this.list = list;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
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
                return list.get(row).getIdSubKriteria();
            case 2:
                return list.get(row).getNamaSubKriteria();
            case 3:
                return list.get(row).getKriteria().getNamaKriteria();
            default:
                return null;
        }
    }
}
