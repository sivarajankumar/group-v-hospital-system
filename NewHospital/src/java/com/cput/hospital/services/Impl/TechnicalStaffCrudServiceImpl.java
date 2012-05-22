/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.services.Impl;

import com.cput.hospital.model.TechnicalStaff;
import com.cput.hospital.repository.GenericDAO;
import com.cput.hospital.services.TechnicalStaffCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author enkosi
 */
@Service("technicalStaffCrudService")
@Transactional
public class TechnicalStaffCrudServiceImpl implements TechnicalStaffCrudService{

    @Autowired
    private GenericDAO<TechnicalStaff> dao;
    
    public final void setDao(final GenericDAO<TechnicalStaff>daoToSet){
        this.dao = daoToSet;
        this.dao.setClazz(TechnicalStaff.class);
    }
    
    @Override
    public TechnicalStaff findById(Long id) {
                setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<TechnicalStaff> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(TechnicalStaff entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(TechnicalStaff entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(TechnicalStaff entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<TechnicalStaff> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
       setDao(dao);
       return dao.count();
    }

    @Override
    public TechnicalStaff getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<TechnicalStaff> getEntitiesByProperName(String name, String value) {
            setDao(dao);
            return dao.getEntitiesByProperName(name, value);
    }
    
}
