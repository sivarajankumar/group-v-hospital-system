/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.DoctorServiceTest;

import com.cput.hospital.app.Modules.OperationSaff.DoctorService;
import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.OperationStaff;
import com.cput.hospital.services.OperationStaffCrudService;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Leo
 */
public class DoctorServiceTest {

    private static ApplicationContext ctx;
    private static Long staffId;
    private DoctorService doctorService;
    private OperationStaffCrudService operationStaffCrudService;

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

        operationStaffCrudService = (OperationStaffCrudService) ctx.getBean("operationStaffCrudService");
        //doctorCrudService = (DoctorCrudService) ctx.getBean("doctorCrudService");

        Map<String, String> values = new HashMap<String, String>();
        values.put("Speciality", "Physiology");
        values.put("Availability", "Available");
        values.put("Speciality", "Dentist");
        values.put("Availability", "Not Available");
        values.put("Speciality", "Phsychiatrist");
        values.put("Availability", "Not Available");
        values.put("Speciality", "Podiatrist");
        values.put("Availability", "Available");

        OperationStaff opStaff = Appfactory.createOperstionStaff(values);
        operationStaffCrudService.persist(opStaff);
    }
}
