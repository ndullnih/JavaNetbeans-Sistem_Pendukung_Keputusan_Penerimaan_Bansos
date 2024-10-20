/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ndull
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelSelectTabelSupplier extends AbstractTableModel{
    private final String[] COLUMN_NAME = {"ID Pasien","Nama","Alamat","No Telp"};
    private final Integer COLUMN_COUNT = 4;
    List<ModelSupplier> list;
    
    public ModelSelectTabelSupplier(List<ModelSupplier> list){
        this.list = list;
    }
    
    @Override
    public int getColumnCount(){
        return COLUMN_COUNT;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public String getColumnName(int column){
        return COLUMN_NAME[column];
    }
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return list.get(row).getIdKaryawan();
            case 1:
                return list.get(row).getNama();
            case 2:
                return list.get(row).getAlamat();
            case 3:
                return list.get(row).getNoTelp();
            default:
                return null;
        }
    }
}
