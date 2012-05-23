/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.app.Modules.hospitalModules.Service;

import com.cput.hospital.model.Ward;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public interface WardService {
    public List<Ward> findAllWards();
    public List<Ward> findByAndGendStatus(String status);
   
}
