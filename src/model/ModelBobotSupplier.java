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
public class ModelBobotSupplier {
    private ModelSupplier karyawan;
    private ModelKriteria kriteria;
    private ModelSubKriteria subkriteria;
    
    public void setKaryawan(ModelSupplier karyawan){
        this.karyawan = karyawan;
    }
    
    public ModelSupplier getKaryawan(){
        return karyawan;
    }
    
    public void setKriteria(ModelKriteria kriteria){
        this.kriteria = kriteria;
    }
    
    public ModelKriteria getKriteria(){
        return kriteria;
    }
    
    public void setSubKriteria(ModelSubKriteria subkriteria){
        this.subkriteria = subkriteria;
    }
    
    public ModelSubKriteria getSubKriteria(){
        return subkriteria;
    }
    
}
