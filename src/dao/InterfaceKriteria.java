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
import model.ModelKriteria;

public interface InterfaceKriteria {
    public Boolean insert(ModelKriteria m);
    public Boolean update(ModelKriteria m);
    public Boolean delete(int id_kriteria);
    public List<ModelKriteria> getAllKriteria();
    public ModelKriteria getKriteriaBaseOnID(int id_kriteria);
}
