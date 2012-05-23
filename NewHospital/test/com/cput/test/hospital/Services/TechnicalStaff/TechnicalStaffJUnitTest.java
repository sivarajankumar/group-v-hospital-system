/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.TechnicalStaff;

import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.TechnicalStaff;
import com.cput.hospital.app.Modules.TechnicalStaff.TechnicalStaffCrudService;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author enkosi
 */
public class TechnicalStaffJUnitTest {

    public TechnicalStaffCrudService technicalStaffCrudService;
    public static ApplicationContext ctx;
    public static Long id;

    public TechnicalStaffJUnitTest() {
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
    public void testTechnicalStaff() {

        //create staff
        technicalStaffCrudService = (TechnicalStaffCrudService) ctx.getBean("technicalStaffCrudService");
        Map<String, String> values = new HashMap<String, String>();

        values.put("Job description","Web_Master");

        TechnicalStaff technicalStaff = Appfactory.createTechnicalStaff(values);
        technicalStaffCrudService.persist(technicalStaff);
        id = technicalStaff.getId();
        Assert.assertNotNull(technicalStaff);

        //read
        technicalStaff = technicalStaffCrudService.findById(id);
        Assert.assertNotNull(technicalStaff);

        // Update 
        TechnicalStaff ts2 = technicalStaffCrudService.findById(id);
        ts2.setJobDescription("Network Technician");
        technicalStaffCrudService.merge(ts2);

        // Delete 
        TechnicalStaff ts3 = technicalStaffCrudService.findById(id);
        technicalStaffCrudService.remove(ts3);

        //Read again
        TechnicalStaff ts4 = technicalStaffCrudService.findById(id);
        Assert.assertNull(ts4);
    }
}
