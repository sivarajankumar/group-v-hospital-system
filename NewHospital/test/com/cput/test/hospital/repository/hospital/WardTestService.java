/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.hospital;

import com.cput.hospital.app.Modules.hospitalModules.Service.WardService;
import com.cput.hospital.model.Ward;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class WardTestService {
    private static ApplicationContext ctx;
    WardService wardService;
    public WardTestService() {
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
     public void mytest(){
          wardService = (WardService)ctx.getBean("wardServiceImpl");
       List<Ward> wards = wardService.findAllWards();
       
       for(Ward myWard:wards)
       {
           System.out.println("Department name: "+myWard.getGender());
       }
       List<Ward> myward = wardService.findByAndGendStatus("empty");
       for(Ward myWard:wards)
        {
         System.out.println("Department name: "+myWard.getWardStatus());
        }
    }
         
         
 }

