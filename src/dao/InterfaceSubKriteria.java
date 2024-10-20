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
import model.ModelSubKriteria;

public interface InterfaceSubKriteria {
    public Boolean insert(ModelSubKriteria m);
    public Boolean update(ModelSubKriteria m);
    public Boolean delete(int id_kriteria);
    public List<ModelSubKriteria> getAllSubKriteria(int id_kriteria);
    public List<ModelSubKriteria> getSubKriteriaByKriteria(ModelKriteria m);
}
