/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.test.hospital.repository.people;

import com.cput.hospital.app.factory.Appfactory;
import com.cput.hospital.model.Person;
import com.cput.hospital.services.PersonCrudService;
import java.util.Map;
import java.util.HashMap;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Leo
 */
public class PersonJUnitTest {
    
    private static ApplicationContext ctx;
    private PersonCrudService personCrudService;
    private static Long personId;
    public PersonJUnitTest() {
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
     public void addPerson() {
     
     personCrudService =(PersonCrudService) ctx.getBean("personCrudService"); 
         
     Map<String,String> values = new HashMap<String,String>();
     values.put("title", "Mr");
     values.put("firstname", "Qiqa");
     values.put("lastname", "Kotyi");
     values.put("gender", "male");
     values.put("race","white");
     values.put("date of birth","1985-02-3");
     values.put("cell number", "083569584");
     values.put("phone number", "021 458 8954");
     values.put("postal address", "P.O box 99");
     values.put("home address", "4854 Peter Street");
     
     Person person = Appfactory.createPerson(values);
     personCrudService.persist(person);
     personId =person.getId();
     Assert.assertNotNull(person.getId());
     }
}
