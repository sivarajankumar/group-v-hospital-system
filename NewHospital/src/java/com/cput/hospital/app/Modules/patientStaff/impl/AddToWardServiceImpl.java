/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.patientStaff.impl;

import com.cput.hospital.app.Modules.patientStaff.service.AddToWardService;
import com.cput.hospital.model.Patient;
import com.cput.hospital.model.Ward;
import com.cput.hospital.services.PatientCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("addToWardService")
@Transactional
public class AddToWardServiceImpl implements  AddToWardService{

    @Autowired
    
   private PatientCrudService patientCrudService;
    @Override
    public List<Ward> addPatient(String name) {
        List<Ward> wards = new ArrayList();
        for(Ward wd:wards)
        {
            if(wd.getWardStatus().equalsIgnoreCase("Empty"))
            {
                List<Patient>patients =wd.getPatients();
                for(Patient pat:patients)
                {
                    if(pat.getPrescription().equalsIgnoreCase(name))
                    {
                        wards.add(wd);
                    }
                }
            }
            else{
            throw new UnsupportedOperationException("Ward is full");
        }
        }    
        return wards;
    }
}