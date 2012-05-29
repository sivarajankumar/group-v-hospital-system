/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.OperationSaff.Impl;

import com.cput.hospital.app.Modules.OperationSaff.NurseService;
import com.cput.hospital.model.Nurse;
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
@Service("nurseService")
@Transactional
public class NurseServiceImpl implements NurseService {

    @Autowired
    private OperationStaffCrudService operationStaffCrudService;

    @Override
    public List<Nurse> nurseRank(String rank) {

        List<Nurse> nurse = new ArrayList<Nurse>();
        List< OperationStaff> opStaff = new ArrayList<OperationStaff>();
        opStaff = operationStaffCrudService.findAll();

        for (OperationStaff operationS : opStaff) {

            List<Nurse> nur = operationS.getNurse();
            for (Nurse nurses : nur) {

                if (rank.equalsIgnoreCase(nurses.getJobDesc())) {

                    nurse = (List<Nurse>) nurses;
                }

            }
        }
        return nurse;


    }

    @Override
    public List<Nurse> findNurseOnStatus(String nurseStatus) {

        List<Nurse> nurse = new ArrayList<Nurse>();
        List<OperationStaff> operationStaff = new ArrayList<OperationStaff>();

        for (OperationStaff opStaff : operationStaff) {

            List<Nurse> nurses = opStaff.getNurse();
            for (Nurse nur : nurses) {

                if (nurseStatus.equals(nur.getNurseStatus())) {

                    nurse = (List<Nurse>) nur;
                }
            }
        }
        return nurse;
    }
}
