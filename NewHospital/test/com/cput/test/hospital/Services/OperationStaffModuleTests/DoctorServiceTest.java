/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.OperationStaffModuleTests;

import com.cput.hospital.app.Modules.OperationSaff.DoctorService;
import com.cput.hospital.model.Doctor;
import java.util.List;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Leo
 */
public class DoctorServiceTest {

    private static ApplicationContext ctx;
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

        doctorService = (DoctorService) ctx.getBean("doctorService");

        List<Doctor> doctor = doctorService.findSpeciality("Physiology");

        for (Doctor doc : doctor) {

            System.out.println("Specialty:" + doc.getSpeciality());
        }

        List<Doctor> doctor2 = doctorService.CheckAvailability("Available");
        for (Doctor doc : doctor2) {

            System.out.println("Doctor status:" + doc.getAvailability());
        }

    }
}
