/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.patientServiceTest;

import com.cput.hospital.app.Modules.patientStaff.service.AddPatientService;
import com.cput.hospital.app.factory.Appfactory;

import com.cput.hospital.model.Patient;
import com.cput.hospital.model.Person;
import com.cput.hospital.services.PatientCrudService;
import com.cput.hospital.services.PersonCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author yandiswa
 */
public class AddPatientJUnitTest {
    private static ApplicationContext ctx;
    private AddPatientService addPatientService;
   private  PersonCrudService personCrudService;
   private PatientCrudService patientCrudService;
   private static Long patientID;
    public AddPatientJUnitTest() {
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
     public void addPatient() {
        
        personCrudService =(PersonCrudService) ctx.getBean("personCrudService"); 
         
     Map<String,String> values = new HashMap<String,String>();
     values.put("title", "Ms");
     values.put("firstname", "Yandiswa");
     values.put("lastname", "Makanda");
     values.put("gender", "female");
     values.put("race","black");
     values.put("date of birth","1985-02-3");
     values.put("cell number", "083569584");
     values.put("phone number", "021 458 8954");
     values.put("postal address", "P.O box 99");
     values.put("home address", "4854 Peter Street");
     
     Person person = Appfactory.createPerson(values);
     personCrudService.persist(person);
     
     patientCrudService =(PatientCrudService) ctx.getBean("patientCrudService"); 
     
        addPatientService = (AddPatientService)ctx.getBean("addPatientService");
         Person myperson = addPatientService.findByName("Qiqa");
      
  Patient p =      addPatientService.addPatien("medicen","tb","sickness", "123456", new Date());
     
       p.getPerson().add(myperson);
       patientCrudService.persist(p);
       
       
        patientID = p.getId();
         Assert.assertNotNull(p.getId());
    Patient patient1 = patientCrudService.findById(patientID);
 
     Assert.assertEquals("123456", patient1.getIdNumber());
     //update
       Patient patient2 = patientCrudService.findById(patientID);
     patient2.setIdNumber("2010145");
      patientCrudService.merge(patient2);
         
        Patient patient3 = patientCrudService.findById(patientID);
          Assert.assertEquals("2010145", patient3.getIdNumber());
        Patient patient4 = patientCrudService.findById(patientID);
      patientCrudService.remove(patient4);
        Patient patient5 = patientCrudService.findById(patientID);
         Assert.assertNull(patient5);
       
    }
    
}
