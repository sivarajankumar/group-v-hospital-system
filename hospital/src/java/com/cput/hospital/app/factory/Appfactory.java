/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.factory;

import com.cput.hospital.model.*;
import java.sql.Time;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Leo
 */
public class Appfactory {

    public static Person createPerson(Map<String, String> values) {
        Person person = new Person();
        person.setTitle(values.get("title"));

        Name name = new Name();
        name.setFirstName(values.get("firstname"));
        name.setLasName(values.get("lastname"));

        Demographic demo = new Demographic();
        demo.setDateOfBirth(new Date());
        demo.setRace(values.get("race"));
        demo.setGender(values.get("gender"));

        Contact cont = new Contact();
        cont.setCellNumber(values.get("cell number"));
        cont.setPhoneNumber(values.get("phone number"));

        Address address = new Address();
        address.setPostalAddress(values.get("postal address"));
        address.setHomeAddress(values.get("home address"));

        person.setAddress(address);
        person.setContact(cont);
        person.setDemographic(demo);
        person.setName(name);
        return person;

      
    }

    public static Hospital creatHospital(Map<String, String> values) {
        Hospital hospital = new Hospital();
        hospital.setName(values.get("name"));
        hospital.setCode(values.get("code"));
        Department department = new Department();
        department.setDeptCode(values.get("deptCode"));
        department.setDeptName(values.get("deptName"));
        hospital.getDepartment().add(department);
        return hospital;
    }

    public static Staff createStaff(Map<String, String> values) {

        Staff staff = new Staff();
        staff.setStaffNum(values.get("Staff number"));
        staff.setJoinedDate(new Date());
        staff.setEducation(values.get("Education"));
        staff.setCertification(values.get("Certification"));
        staff.setLangauges(values.get("Language"));

        AdministrativeStaff admin = new AdministrativeStaff();
        admin.setJobDescription(values.get("Job description"));

        TechnicalStaff techStaff = new TechnicalStaff();
        techStaff.setJobDescription(values.get("Job description"));
        techStaff.setJobDescription("Job description");
        
        Surgeon surgeon  = new Surgeon();
        surgeon.setSpeciality(values.get("Speciality"));
        surgeon.setSpeciality(values.get("Speciality"));
        surgeon.setSpeciality(values.get("Speciality"));
        
        return staff;
    }
    public static Patient creatPatient(Map<String, String> values,Person person ) {
        Patient patient = new Patient();
        patient.setAccepted((new Date()));
        patient.setAllergies(values.get("allergies"));
        patient.setPrescription(values.get("prestription"));
        patient.setSpecialReqs(values.get("spacial_req"));
        patient.setIdNumber(values.get("idNumber"));
       // Person person = new Person();
        //history
        History history = new History();
        history.setDiagnosis(values.get("diagnoses"));
        history.setHdate(new Date());
        history.setPrevAppo(values.get("privAppointment"));
       Appointment appointment = new Appointment();
       appointment.setDate(new Date());
       appointment.setTime(new Time(12,45,10));
       patient.getAppointment().add(appointment);
       patient.getHistory().add(history);
        patient.getPerson().add(person);
        
        return patient;
    }
    }
    

