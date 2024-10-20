/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ndull
 */
public class ModelTabelTampilNilaiKriteria extends AbstractTableModel{
    final String[] nama_kolom = {"No", "Id Kriteria", "Nama Kriteria", "Nilai"};
    List<ModelTampilNilaiKriteria> list;
    DecimalFormat df = new DecimalFormat("#.##");
    
    public ModelTabelTampilNilaiKriteria(List<ModelTampilNilaiKriteria> list){
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
                return list.get(row).getIdKriteria();
            case 2:
                return list.get(row).getNamaKriteria();
            case 3:
                return df.format(list.get(row).getNilaiKriteria());
            default:
                return null;
        }
    }
}
