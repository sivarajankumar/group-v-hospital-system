/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.OperationSaff;

import com.cput.hospital.model.Doctor;

/**
 *
 * @author Leo
 */
public interface DoctorService {

    public Doctor findSpeciality(String speciality, Long id);

    public String CheckAvailability(String status, Long id);
}
