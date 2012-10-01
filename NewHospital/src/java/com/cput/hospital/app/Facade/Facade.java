/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Facade;

import com.cput.hospital.app.conf.GetContext;
import com.cput.hospital.services.PatientCrudService;
import java.io.Serializable;
import org.springframework.context.ApplicationContext;


/**
 *
 * @author Leo
 */
public class Facade implements Serializable{
    
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private PatientCrudService patientCrudService;
    
    public PatientCrudService getPatientService() {
        patientCrudService = (PatientCrudService) ctx.getBean("patientCrudService");
        return patientCrudService;
    }
}
