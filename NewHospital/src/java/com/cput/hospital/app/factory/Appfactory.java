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
        department.setDeptName(values.get("dept1"));
        department.setDeptCode(values.get("dept11"));

        Department department2 = new Department();
        department2.setDeptName(values.get("dept2"));
        department2.setDeptCode(values.get("dept22"));
        
        Department department3 = new Department();
        department3.setDeptName(values.get("dept3"));
        department3.setDeptCode(values.get("dept33"));
        
         Ward females = new Ward();
         females.setWardcode(values.get("code1"));
         females.setWardStatus(values.get("status1"));
         females.setGender(values.get("gender1"));
         
         Ward males = new Ward();
         males.setWardcode(values.get("code2"));
         males.setWardStatus(values.get("status2"));
         males.setGender(values.get("gender2"));
         
         
         Ward males1 = new Ward();
         males1.setWardcode(values.get("code2"));
         males1.setWardStatus(values.get("status2"));
         males1.setGender(values.get("gender2"));
         
         
         Ward females1 = new Ward();
         females1.setWardcode(values.get("code1"));
         females1.setWardStatus(values.get("status1"));
         females1.setGender(values.get("gender1"));
         
         
         Ward males3 = new Ward();
         males3.setWardcode(values.get("code2"));
         males3.setWardStatus(values.get("status2"));
         males3.setGender(values.get("gender2"));
         
         
         Ward females3 = new Ward();
         females3.setWardcode(values.get("code1"));
         females3.setWardStatus(values.get("status1"));
         females3.setGender(values.get("gender1"));
        
        department.getWard().add(males);
        department.getWard().add(females);
        
        department2.getWard().add(males1);
        department2.getWard().add(females1);
        
       department3.getWard().add(males3);
       department3.getWard().add(females3);
       
        hospital.getDepartment().add(department);
        hospital.getDepartment().add(department2);
        hospital.getDepartment().add(department3);
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

        Surgeon surgeon = new Surgeon();
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
    public static TechnicalStaff createTechnicalStaff(Map<String, String> values) {
        TechnicalStaff technicalStaff = new TechnicalStaff();
        technicalStaff.setJobDescription(values.get("Job description"));
        return technicalStaff;
    }

    
}
