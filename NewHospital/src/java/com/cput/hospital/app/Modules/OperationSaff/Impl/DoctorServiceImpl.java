/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.OperationSaff.Impl;

import com.cput.hospital.app.Modules.OperationSaff.DoctorService;
import com.cput.hospital.model.Doctor;
import com.cput.hospital.model.OperationStaff;
import com.cput.hospital.model.Staff;
import com.cput.hospital.model.Surgeon;
import com.cput.hospital.services.StaffCrudService;
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
    StaffCrudService staffCrudService;

    @Override
    public String CheckAvailability(String status, Long id) {

        Staff staff = staffCrudService.findById(id);
        List<OperationStaff> opStaff = staff.getOpStaff();

        List<Doctor> doctor = new ArrayList<Doctor>();

        for (Doctor doc : doctor) {

            if (status.equals(doc)) {
                return "The doctor is vailable for appointments";
            } else {
                return "The doctor is not available for appointments";
            }
        }
        return status;
    }

    @Override
    public Doctor findSpeciality(String speciality, Long id) {

        Staff staff = staffCrudService.findById(id);
        List<OperationStaff> opStaff = staff.getOpStaff();
        Doctor doctor = new Doctor();
        List<Surgeon> surgeon = doctor.getSurgeon();
        for (Surgeon surg : surgeon) {

            if (speciality.equals(surg.getSpeciality())) {

                System.out.println("The doctor specialises with" + surg.getSpeciality());
            }
        }

        return doctor;
    }
}
