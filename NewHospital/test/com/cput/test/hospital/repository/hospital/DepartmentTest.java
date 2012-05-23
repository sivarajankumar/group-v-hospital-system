/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.hospital;

import com.cput.hospital.app.Modules.hospitalModules.Service.DepartmentService;
import com.cput.hospital.model.Department;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class DepartmentTest {
    private static ApplicationContext ctx;
    DepartmentService departmentService;
    public DepartmentTest() {
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
     public void myTest(){
       departmentService = (DepartmentService)ctx.getBean("departmentServiceImp");
       List<Department> departments = departmentService.findAllDepartment();
       
       for(Department dept:departments)
       {
           System.out.println("Department name: "+dept.getDeptName());
       }
         Department depts =departmentService.findByName("YOUTH");
         System.out.println("name :"+depts.getDeptCode()+"code :"+depts.getDeptName());
    }
}
