/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author Leo
 */
@Embeddable
public class Demographic implements Serializable{
    
    private Date dateOfBirth;
    private String race;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
    
}
