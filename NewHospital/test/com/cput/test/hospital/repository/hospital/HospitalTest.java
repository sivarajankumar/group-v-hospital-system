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
    public void mytestMethod() {

        hospitalCrudService = (HospitalCrudService) ctx.getBean("hospitalCrudService");
        Map<String, String> values = new HashMap<String, String>();
        values.put("name", "Makhiwane");
        values.put("code", "ow11de");
        values.put("deptName", "Child");
        values.put("deptCode", "1234");

        Hospital hospital = Appfactory.creatHospital(values);
        hospitalCrudService.persist(hospital);
        Assert.assertNotNull(hospital);



    }
}
