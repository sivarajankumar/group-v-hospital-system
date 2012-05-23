/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.patientStaff.impl;


import com.cput.hospital.app.Modules.patientStaff.service.AddPatientService;
import com.cput.hospital.model.*;
import com.cput.hospital.services.PatientCrudService;
import com.cput.hospital.services.PersonCrudService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yandiswa
 */
@Service("addPatientService")
@Transactional
public class AddPatientImpl implements AddPatientService {

    @Autowired
    private PersonCrudService personCrudService;
   private PatientCrudService patientCrudService;
    @Override
    public Patient addPatien(String prescription, String allergies, String specialReqs, String idNumber, Date date) {
        Patient patient = new Patient();
        patient.setIdNumber(idNumber);
        patient.setAllergies(allergies);
        patient.setAccepted(new Date());
        patient.setPrescription(prescription);
        patient.setSpecialReqs(specialReqs);

        return patient;
    }

    /*
     * @Override public Person addPerson(String title, Name name, Contact
     * contact, Address addres, Demographic demographic) { Person person = new
     * Person(); person.setTitle(title); person.setAddress(addres);
     * person.setContact(contact); person.setDemographic(demographic);
     * person.setName(name);
     *
     * return person;
    }
     */
    @Override
    public Person findByName(String name) {
        Person person = new Person();
        List<Person> persons = personCrudService.findAll();
        for (Person p : persons) {
            if (p.getName().getFirstName().equalsIgnoreCase(name)) {
                person = p;
            }
        }

        return person;
    }
}
