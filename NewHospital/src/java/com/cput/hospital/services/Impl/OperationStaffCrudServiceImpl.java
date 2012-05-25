/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.services.Impl;

import com.cput.hospital.model.OperationStaff;
import com.cput.hospital.model.Staff;
import com.cput.hospital.repository.GenericDAO;
import com.cput.hospital.services.OperationStaffCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leo
 */
@Service("operationStaffCrudService")
@Transactional
public class OperationStaffCrudServiceImpl implements OperationStaffCrudService{

      @Autowired
      private GenericDAO<OperationStaff> dao;
    
     public final void setDao(final GenericDAO< OperationStaff> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(OperationStaff.class);
    }
    public OperationStaffCrudServiceImpl(){}
    
    @Override
    public OperationStaff findById(Long id) {
       setDao(dao);
       return dao.findById(id);
    }

    @Override
    public List<OperationStaff> findAll() {
       setDao(dao);
       return dao.findAll();
    }

    @Override
    public void persist(OperationStaff entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(OperationStaff entity) {
       setDao(dao);
       dao.merge(entity);
    }

    @Override
    public void remove(OperationStaff entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
       setDao(dao);
       dao.removeById(entityId);
    }

    @Override
    public List<OperationStaff> findInRange(int firstResult, int maxResults) {
       setDao(dao);
       
       return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public OperationStaff getByPropertyName(String name, String value) {
       setDao(dao);
       return dao.getByPropertyName(name, value);
    }

    @Override
    public List<OperationStaff> getEntitiesByProperName(String name, String value) {
       setDao(dao);
       return dao.getEntitiesByProperName(name, value);
    }
    
}
