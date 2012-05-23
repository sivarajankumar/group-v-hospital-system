/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.hospitalModules.Service;

import com.cput.hospital.model.Department;
import java.util.List;

/**
 *
 * @author user
 */
public interface DepartmentService{
    public List<Department> findAllDepartment();
    public Department findByName(String deptName);
    }
