/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ModelNilaiSupplier;
import model.ModelNilaiKriteria;
import model.ModelNilaiSubKriteria;
import model.ModelValues;

/**
 *
 * @author ndull
 */
public interface InterfaceNilaiBobot {
    public Boolean insertNilaiKriteria(ModelNilaiKriteria kriteria);
    public Boolean insertNilaiSubKriteria(ModelNilaiSubKriteria subkriteria);
    public Boolean insertNilaiKaryawan(ModelNilaiSupplier karyawan);
    public Boolean insertValues(ModelValues values);
    public List<ModelNilaiSupplier> getNilaiKaryawan();
    public void clearTable();
}
