/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.hospitalModules.imp;

import com.cput.hospital.app.Modules.hospitalModules.Service.WardService;
import com.cput.hospital.model.Department;
import com.cput.hospital.model.Hospital;
import com.cput.hospital.model.Ward;
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
@Service("wardServiceImpl")
@Transactional
public class WardServiceImpl implements WardService {
    @Autowired
    HospitalCrudService hospitalCrudService;

    public List<Ward> findAllWards() {
        List<Ward> ward = new ArrayList<Ward>();
        List<Hospital> hospital = new ArrayList<Hospital>();
        hospital = hospitalCrudService.findAll();
        for (Hospital hosp : hospital) {
            List<Department> depart = hosp.getDepartment();
            for (Department mydept : depart) {
                List<Ward> wards = mydept.getWard();
                ward = wards;
            }
        }
        return ward;
    }

    @Override
    public List<Ward> findByAndGendStatus(String status) {

        List<Ward> myWord = new ArrayList<Ward>();
        List<Hospital> myHospital = new ArrayList<Hospital>();
        for (Hospital hosp : myHospital) {
            List<Department> depart = hosp.getDepartment();
            for (Department mydept : depart) {
                List<Ward> wards = mydept.getWard();
                for (Ward wardz : wards) {
                    if (status.equalsIgnoreCase("empty")) {
                        myWord.add(wardz);
                    }
                }
            }
        }
        return myWord;
    }
}
