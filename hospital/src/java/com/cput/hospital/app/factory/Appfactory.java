/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.factory;

import com.cput.hospital.model.*;
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
}
