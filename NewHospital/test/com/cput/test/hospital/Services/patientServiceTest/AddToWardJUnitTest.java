/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.patientServiceTest;

import com.cput.hospital.app.Modules.patientStaff.service.AddToWardService;
import com.cput.hospital.model.Ward;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author yandiswa
 */
public class AddToWardJUnitTest {
    private AddToWardService addToWardService;
    private static ApplicationContext ctx;
    public AddToWardJUnitTest() {
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
     @Test//(expected=UnsupportedOperationException.class)
     public void addToWard() {
     
     addToWardService = (AddToWardService)ctx.getBean("addToWardService");
     
     List<Ward> ward = addToWardService.addPatient("arv");
        Assert.assertNotNull(ward);
     
     }
}
