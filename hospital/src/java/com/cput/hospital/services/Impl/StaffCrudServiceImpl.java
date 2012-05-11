/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.services.Impl;

import com.cput.hospital.model.Staff;
import com.cput.hospital.repository.GenericDAO;
import com.cput.hospital.services.StaffCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leo
 */
@Service("staffCrudService")
@Transactional
public class StaffCrudServiceImpl implements StaffCrudService{

    @Autowired
    private GenericDAO<Staff> dao;
    
     public final void setDao(final GenericDAO< Staff> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Staff.class);
    }
     public StaffCrudServiceImpl()
    {
    
    }
    @Override
    public Staff findById(Long id) {
       setDao(dao);
       return dao.findById(id);
    }
   
    @Override
    public List<Staff> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Staff entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Staff entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Staff entity) {
        setDao(dao);
        dao.remove(entity);
    }
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Staff> findInRange(int firstResult, int maxResults) {
       setDao(dao);
       return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Staff getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Staff> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
