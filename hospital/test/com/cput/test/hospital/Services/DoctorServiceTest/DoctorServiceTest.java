/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.DoctorServiceTest;

import com.cput.hospital.app.Modules.OperationSaff.DoctorService;
import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.Doctor;
import com.cput.hospital.model.OperationStaff;
import com.cput.hospital.model.Staff;
import com.cput.hospital.services.StaffCrudService;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Leo
 */
public class DoctorServiceTest {
    
    private static ApplicationContext ctx;
    private static Long staffId;
    private StaffCrudService staffCrudService;
    private DoctorService doctorService;
    
    public DoctorServiceTest() {
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
     public void testDoctor() {
     
         staffCrudService  = (StaffCrudService) ctx.getBean("staffCrudService");
         doctorService = (DoctorService) ctx.getBean("doctorService"); 
         
         Map<String,String> values  = new HashMap<String,String>();
         values.put("Speciality", "Dentist");
         values.put("Speciality", "Physiologist");
         values.put("Speciality", "Phsychiachrist");
         
         Staff staff = Appfactory.createStaff(values);
         staffCrudService.persist(staff);
         Assert.assertNotNull(staff);
         staffId = staff.getId();
         
         Doctor dentist = doctorService.findSpeciality("Dentist", staffId);
         Doctor physiologist = doctorService.findSpeciality("Physiologist", staffId);
         Doctor phsychiachrist = doctorService.findSpeciality("Phsychiachrist", staffId);
         
         OperationStaff opStaff = new OperationStaff();
     }
}
