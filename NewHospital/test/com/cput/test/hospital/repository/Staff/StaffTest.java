/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.Staff;

import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.Staff;
import com.cput.hospital.services.StaffCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Leo
 */
public class StaffTest {

    private StaffCrudService staffCrudService;
    private static ApplicationContext ctx;
    private static Long id;

    public StaffTest() {
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
    public void testStaff() {
        //create 
        staffCrudService = (StaffCrudService) ctx.getBean("staffCrudService");

        Map<String, String> values = new HashMap<String, String>();
        values.put("Staff number", "209030372");
        values.put("Joined date", "21-05-1999");
        values.put("Education", "MTech");

        values.put("Certifcation", "MTech certificate");
        values.put("Language", "Tshitsonga");

        Staff staff = Appfactory.createStaff(values);
        staffCrudService.persist(staff);
        id = staff.getId();
        Assert.assertNotNull(staff);

        // Read
        staff = staffCrudService.findById(id);
        Assert.assertNotNull(staff);

        // Update 
        Staff staff2 = staffCrudService.findById(id);
        staff2.setStaffNum("123456");
        staff2.setJoinedDate(new Date());
        staff2.setEducation("Diploma");
        staff2.setCertification("ND: HR Mangement");
        staff2.setLangauges("Sepedi");
        staffCrudService.merge(staff2);

        // Delete 

        Staff staff3 = staffCrudService.findById(id);
        staffCrudService.remove(staff3);

        //Read again
        Staff staff4 = staffCrudService.findById(id);
        Assert.assertNull(staff4);
    }
}
