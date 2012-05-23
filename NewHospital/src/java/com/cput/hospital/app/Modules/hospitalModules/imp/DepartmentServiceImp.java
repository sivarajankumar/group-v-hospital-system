/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.hospitalModules.imp;

import com.cput.hospital.app.Modules.hospitalModules.Service.DepartmentService;
import com.cput.hospital.model.Department;
import com.cput.hospital.model.Hospital;
import com.cput.hospital.services.HospitalCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Service("departmentServiceImp")
@Transactional
public class DepartmentServiceImp implements DepartmentService {
@Autowired
    HospitalCrudService hospitalCrudService;
    @Override
     public List<Department> findAllDepartment()
  {
       List<Department> department = new ArrayList<Department>();
       List<Hospital> hospital = new ArrayList<Hospital>();
       hospital = hospitalCrudService.findAll();
       for(Hospital hosp:hospital)
          {
              List<Department> depart = hosp.getDepartment();
                 for(Department mydept:depart)
                    {
                      department.add(mydept);
                    }
          }           
     return department;
    }

    @Override
     public Department findByName(String deptName) {
       Department department = new Department();
       List<Hospital> hospital = new ArrayList<Hospital>();
       hospital = hospitalCrudService.findAll();
       for(Hospital hosp:hospital)
          {
              List<Department> depart = hosp.getDepartment();
                 for(Department mydept:depart)
                    {
                       if(mydept.getDeptName().equalsIgnoreCase(deptName))
                       {
                         department = mydept;  
                       }
                    }
          } 
     return   department;
    }
    
}
