/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Leo
 */
@Entity
public class Ward implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String wardcode;
    private String  wardStatus;
    private String gender;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private List<Patient> patients = new ArrayList<Patient>();
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWardStatus() {
        return wardStatus;
    }

    public void setWardStatus(String wardStatus) {
        this.wardStatus = wardStatus;
    }

    public String getWardcode() {
        return wardcode;
    }

    public void setWardcode(String wardcode) {
        this.wardcode = wardcode;
    }
   
   

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.za.hospital.model.Ward[ id=" + id + " ]";
    }
    
}
