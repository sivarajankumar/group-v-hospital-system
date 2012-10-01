/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.presentation;

import com.cput.hospital.app.Facade.Facade;
import org.springframework.stereotype.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Leo
 */
@Controller
public class HomeController {
    private final Facade data = new Facade();
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
 
    @RequestMapping({"/"})
    public String home() {

       
       return "index";
    }
}