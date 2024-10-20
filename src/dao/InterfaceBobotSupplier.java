/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author tndull
 */
import java.util.List;
import model.ModelBobotSupplier;
import model.ModelBobotSubKriteria;

public interface InterfaceBobotSupplier {
    public Boolean insert(ModelBobotSupplier m);
    public Boolean update(ModelBobotSupplier m);
    public Boolean delete(ModelBobotSupplier m);
    public List<ModelBobotSupplier> getAllBobotKaryawan(String id_karyawan);
    public Boolean bobotIsExists(String id_karyawan, int id_kriteria);
}
