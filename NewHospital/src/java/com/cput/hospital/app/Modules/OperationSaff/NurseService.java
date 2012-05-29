/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.OperationSaff;

import com.cput.hospital.model.Nurse;
import java.util.List;

/**
 *
 * @author Leo
 */
public interface NurseService {
    
    public List<Nurse> nurseRank(String rank);
     public List<Nurse> findNurseOnStatus(String nurseStatus);
    
}
