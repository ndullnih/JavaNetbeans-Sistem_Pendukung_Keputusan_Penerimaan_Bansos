/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ModelKriteria;
import model.ModelTampilHasil;
import model.ModelTampilNilaiKriteria;
import model.ModelTampilNilaiSubKriteria;
import model.ModelValues;

/**
 *
 * @author ndull
 */
public interface InterfaceTampilNilaiKriteria {
    public List<ModelTampilNilaiKriteria> getAllNilaiBobotKriteria();
    public List<ModelValues> getValuesKriteria();
    public List<ModelTampilNilaiSubKriteria> getNilaiBobotSubKriteria(ModelKriteria m);
    public List<ModelValues> getValuesSubKriteria(ModelKriteria k);
    public List<ModelTampilHasil> getHasil();
}
