/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.Services.OperationStaffModuleTests;

import com.cput.hospital.app.Modules.OperationSaff.NurseService;
import com.cput.hospital.model.Nurse;
import java.util.List;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Leo
 */
public class NurseServiceTest {

    private static ApplicationContext ctx;
    private NurseService nurseService;

    public NurseServiceTest() {
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
    public void testNurse() {

        nurseService = (NurseService) ctx.getBean("nurseService");

        List<Nurse> nurse = nurseService.nurseRank("Sister");
        for (Nurse nurses : nurse) {

            System.out.println("Nurse is:" + nurses.getJobDesc());
        }

        List<Nurse> nurse2 = nurseService.findNurseOnStatus("On duty");

        for (Nurse nurses : nurse2) {

            System.out.println("Status:" + nurses.getNurseStatus());
        }

    }
}
