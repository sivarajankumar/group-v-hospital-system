/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.services.Impl;

import com.cput.hospital.model.Hospital;
import com.cput.hospital.repository.GenericDAO;
import com.cput.hospital.services.HospitalCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service("hospitalCrudService")
@Transactional
public class HospitalCrudServiceImp implements HospitalCrudService{
 @Autowired
    private GenericDAO<Hospital> dao;
    public final void setDao(final GenericDAO<Hospital> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Hospital.class);
    }
    @Override
    public Hospital findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Hospital> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Hospital entity) {
       setDao(dao);
       dao.persist(entity);
    }

    @Override
    public void merge(Hospital entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Hospital entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Hospital> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Hospital getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Hospital> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
