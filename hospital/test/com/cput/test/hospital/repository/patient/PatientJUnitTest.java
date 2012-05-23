/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.patient;

import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.app.module.patient.AddPatientService;
import com.cput.hospital.model.Patient;
import com.cput.hospital.model.Person;
/*<<<<<<< .mine
import com.cput.hospital.model.Person;

import com.cput.hospital.services.HospitalCrudService;
=======
>>>>>>> .r9*/
import com.cput.hospital.services.PatientCrudService;
import com.cput.hospital.services.PersonCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author yandiswa
 */
public class PatientJUnitTest {
    private static ApplicationContext ctx;
    private PatientCrudService patientCrudService;
    private PersonCrudService personCrudService;
    private static Long patientID;
    public PatientJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
          ctx = new ClassPathXmlApplicationContext("classpath:com/cput/hospital/app/conf/applicationContext-*.xml");
 
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void patient() {
        
        
          personCrudService =(PersonCrudService) ctx.getBean("personCrudService"); 
         
     Map<String,String> values = new HashMap<String,String>();
     values.put("title", "Mr");
     values.put("firstname", "Qiqa");
     values.put("lastname", "Kotyi");
     values.put("gender", "male");
     values.put("race","white");
     values.put("date of birth","1985-02-3");
     values.put("cell number", "083569584");
     values.put("phone number", "021 458 8954");
     values.put("postal address", "P.O box 99");
     values.put("home address", "4854 Peter Street");
     
     Person person = Appfactory.createPerson(values);
     personCrudService.persist(person);
          patientCrudService = (PatientCrudService)ctx.getBean("patientCrudService");
         Map<String, String> patienvalues = new HashMap<String, String>();
    
     patienvalues.put("idNumber", "123456");
    patienvalues.put("date", "date");
    patienvalues.put("prestription", "medicin");
    patienvalues.put("allergies", "jection");
    patienvalues.put("spacial_req", "test");
    
     patienvalues.put("idNumber", "654123");
     patienvalues.put("date", "date");
    patienvalues.put("prestription", "arv");
    patienvalues.put("allergies", "pills");
    patienvalues.put("spacial_req", "sikness");
    
   patienvalues.put("date", " date");
    patienvalues.put("time", "time");
    
    patienvalues.put("date", "date");
    patienvalues.put("diagnoses", "hiv");
    patienvalues.put("privAppointment", "dyt");
    
    patienvalues.put("date", "date");
    patienvalues.put("diagnoses", "tb");
    patienvalues.put("privAppointment", "mj");
   
    
       Patient patient = Appfactory.creatPatient(patienvalues,person);
      /* AddPatientService object;
       
       object = (AddPatientService)ctx.getBean("addPatientService");
       Person myperson = object.findByName("Qiqa");
       */
     
       
                  
       
         patientCrudService.persist(patient);
         patientID = patient.getId();
         Assert.assertNotNull(patient.getId());
    Patient patient1 = patientCrudService.findById(patientID);
 
     Assert.assertEquals("654123", patient1.getIdNumber());
     //update
       Patient patient2 = patientCrudService.findById(patientID);
     patient2.setIdNumber("2010145");
      patientCrudService.merge(patient2);
         
        Patient patient3 = patientCrudService.findById(patientID);
          Assert.assertEquals("2010145", patient3.getIdNumber());
          //delete
        /* Person person4 = personCrudService.findById(personId);
      personCrudService.remove(person4);
        Person person5 = personCrudService.findById(personId);
         Assert.assertNull(person5);*/
    

         
         /* patientCrudService.removeById(new Long(49));
         Patient patient8 = patientCrudService.findById(new Long(49));
         Assert.assertNull(patient8);
         
          patientCrudService.removeById(new Long(50));
         Patient patient18 = patientCrudService.findById(new Long(50));
         Assert.assertNull(patient18);*/
         
    }
}
