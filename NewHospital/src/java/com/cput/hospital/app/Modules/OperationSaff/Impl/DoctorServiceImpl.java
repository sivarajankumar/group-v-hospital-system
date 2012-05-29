/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.OperationSaff.Impl;

import com.cput.hospital.app.Modules.OperationSaff.DoctorService;
import com.cput.hospital.model.Doctor;
import com.cput.hospital.model.OperationStaff;
import com.cput.hospital.services.OperationStaffCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leo
 */
@Service("doctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    OperationStaffCrudService operationStaffCrudService;

    @Override
    public List<Doctor> CheckAvailability(String status) {

        List<Doctor> doctor = new ArrayList<Doctor>();
        List<OperationStaff> opStaff = new ArrayList<OperationStaff>();
        opStaff= operationStaffCrudService.findAll();

        for (OperationStaff operationS : opStaff) {

            List<Doctor> docs = operationS.getDoctor();

            for (Doctor doc : docs) {

                if (status.equalsIgnoreCase("Available")) {
                    doctor.add(doc);
                }
            }
        }
        return doctor;
    }

    @Override
    public List<Doctor> findSpeciality(String speciality) {

        List<Doctor> doctor = new ArrayList<Doctor>();

        List< OperationStaff> opStaff = new ArrayList<OperationStaff>();
        
        opStaff= operationStaffCrudService.findAll();
        for (OperationStaff operationS : opStaff) {

            List<Doctor> docs = operationS.getDoctor();
            for (Doctor doc : docs) {

                if (speciality.equals(doc.getSpeciality())) {

                    doctor = (List<Doctor>) doc;
                }
            }
        }
        return doctor;
    }
}
