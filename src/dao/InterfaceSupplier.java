/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ndull
 */
import java.util.List;
import model.ModelSupplier;

public interface InterfaceSupplier {
    public Boolean insert(ModelSupplier m);
    
    public Boolean update(ModelSupplier m);
    
    public Boolean delete(String id);
    
    public List<ModelSupplier> getAllKaryawan();
    
    public List<ModelSupplier> getCariKaryawan(String cari);
}
