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

public class ModelTabelSupplier extends AbstractTableModel{
    private final String[] COLUMN_NAME = {"No.","NIS","Nama","Alamat","No Telp"};
    private final Integer COLUMN_COUNT = 5;
    List<ModelSupplier> list;
    
    public ModelTabelSupplier(List<ModelSupplier> list){
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
                return row+1;
            case 1:
                return list.get(row).getIdKaryawan();
            case 2:
                return list.get(row).getNama();
            case 3:
                return list.get(row).getAlamat();
            case 4:
                return list.get(row).getNoTelp();
            default:
                return null;
        }
    }
}
