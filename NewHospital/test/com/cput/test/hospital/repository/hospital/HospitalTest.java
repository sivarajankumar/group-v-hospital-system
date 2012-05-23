/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.hospital;

import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.Hospital;
import com.cput.hospital.services.HospitalCrudService;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author user
 */
public class HospitalTest {
    private static ApplicationContext ctx;
    private HospitalCrudService hospitalCrudService;
    public HospitalTest() {
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
    public void mytestMethod(){
         hospitalCrudService = (HospitalCrudService)ctx.getBean("hospitalCrudService");
         Map<String, String> values = new HashMap<String, String>();
         values.put("name", "Makhiwane");
         values.put("code", "ow11de");
         
         values.put("dept1", "CHILD");
         values.put("dept11","1234");
                                    
         values.put("dept2", "YOUTH");
         values.put("dept22","1234");
         
         values.put("dept3", "ADULT");
         values.put("dept33","1234");
         
         values.put("code1","1234");
         values.put("status1","Empty");
         values.put("gender1","female");
         
         values.put("code2","4567");
         values.put("status2","Empty");
         values.put("gender2","Males");
         
         
                                  
         Hospital hospital = Appfactory.creatHospital(values);
         hospitalCrudService.persist(hospital);  
         //reading 
         Hospital host = hospitalCrudService.findById(hospital.getId());
         Assert.assertNotNull(host);
         //UDATING
         host.setName("MAKHIWANE");
         hospitalCrudService.merge(host);
         //DELETING THE HOSPITAL
        // hospitalCrudService.remove(host);
         
    
    }
}
