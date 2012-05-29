/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.OperationStaff;

import com.cput.hospital.app.Modules.OperationSaff.DoctorService;
import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.OperationStaff;
import com.cput.hospital.services.OperationStaffCrudService;
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
public class OperationStaffTest {

    private static ApplicationContext ctx;
    private static Long staffId;
    private OperationStaffCrudService operationStaffCrudService;

    public OperationStaffTest() {
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
    public void testOperstionStaff() {

        operationStaffCrudService = (OperationStaffCrudService) ctx.getBean("operationStaffCrudService");

        Map<String, String> values = new HashMap<String, String>();
        values.put("Speciality", "Physiology");
        values.put("Availability", "Available");
        values.put("Speciality", "Dentist");
        values.put("Availability", "Available");
        values.put("Job description", "Sister");
        values.put("Nurse status", "On duty");


        OperationStaff opStaff = Appfactory.createOperstionStaff(values);
        operationStaffCrudService.persist(opStaff);
        opStaff.setStaffNumber("B14785");
        Assert.assertNotNull(opStaff);
        staffId = opStaff.getId();

        //Read

        opStaff = operationStaffCrudService.findById(staffId);
        Assert.assertNotNull(opStaff);

        //Update 
        OperationStaff opStaff2 = operationStaffCrudService.findById(staffId);
        opStaff2.setStaffNumber("A123456");
        opStaff2.setDoctor(opStaff2.getDoctor());
        opStaff2.setNurse(opStaff2.getNurse());
        operationStaffCrudService.merge(opStaff);

        //Delete
        OperationStaff opStaff3 = operationStaffCrudService.findById(staffId);
        operationStaffCrudService.remove(opStaff3);

        //Read again
        OperationStaff opStaff4 = operationStaffCrudService.findById(staffId);
        Assert.assertNull(opStaff4);

    }
}
