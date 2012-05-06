/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Leo
 */
@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date accepted;
    private Long patientID;
    @OneToOne
    private History sickness;
    private String prescription;
    private String allergies;
    private String specialReqs;

    public Date getAccepted() {
        return accepted;
    }

    public void setAccepted(Date accepted) {
        this.accepted = accepted;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public History getSickness() {
        return sickness;
    }

    public void setSickness(History sickness) {
        this.sickness = sickness;
    }

    public String getSpecialReqs() {
        return specialReqs;
    }

    public void setSpecialReqs(String specialReqs) {
        this.specialReqs = specialReqs;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.za.hospital.model.Patient[ id=" + id + " ]";
    }
    
}
