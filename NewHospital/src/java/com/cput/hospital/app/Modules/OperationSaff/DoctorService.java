/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.OperationSaff;

import com.cput.hospital.model.Doctor;
import java.util.List;

/**
 *
 * @author Leo
 */
public interface DoctorService {

    public List<Doctor> findSpeciality(String speciality);

    public  List<Doctor> CheckAvailability(String status);
}
