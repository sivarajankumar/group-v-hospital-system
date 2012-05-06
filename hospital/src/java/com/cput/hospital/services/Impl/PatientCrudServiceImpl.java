/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.services.Impl;

import com.cput.hospital.model.Patient;
import com.cput.hospital.repository.GenericDAO;
import com.cput.hospital.services.PatientCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("patientCrudService")
@Transactional
public class PatientCrudServiceImpl implements PatientCrudService {
@Autowired
     private GenericDAO<Patient> dao;
     
      public final void setDao(final GenericDAO< Patient> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Patient.class);
      }
        public PatientCrudServiceImpl(){
            
        }
    @Override
    public Patient findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Patient entity) {
         setDao(dao);
       dao.persist(entity);
    }

    @Override
    public void merge(Patient entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Patient entity) {
         setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
       dao.removeById(entityId);
    }

    @Override
    public List<Patient> findInRange(int firstResult, int maxResults) {
        setDao(dao);
       return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
       return dao.count();
    }

    @Override
    public Patient getByPropertyName(String name, String value) {
       setDao(dao);
       return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Patient> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
