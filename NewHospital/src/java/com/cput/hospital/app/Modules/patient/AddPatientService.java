/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.patient;

import com.cput.hospital.model.*;
import java.util.Date;

/**
 *
 * @author yandiswa
 */
public interface AddPatientService {
    public Patient addPatien(String prescription,String allergies,String specialReqs,String idNumber,Date date);
    public Person findByName(String name);
    
  
}
