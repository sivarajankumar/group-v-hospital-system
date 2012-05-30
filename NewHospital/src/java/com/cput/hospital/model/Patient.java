
 /*
 * @author Leo
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author yandiswa
 */
@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 @Temporal(javax.persistence.TemporalType.DATE)
    private Date accepted;
   
    @OneToMany
    @JoinColumn(name="persorn_id")
    private List<Person> person = new ArrayList<Person>();
    
   @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name="appointment_id")
    private List<Appointment> appointment = new ArrayList<Appointment>();
    
      @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name="history_id")
    private List<History> history = new ArrayList<History>();

      @ManyToOne
      @JoinColumn(name ="ward_id")
      private Ward ward;
      
    @ManyToOne
    private OperationStaff operationStaff;
    
    private String prescription;
    private String allergies;
    private String specialReqs;
    private String idNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public Long getId() {
        return id;
    }

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

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public OperationStaff getOperationStaff() {
        return operationStaff;
    }

    public void setOperationStaff(OperationStaff operationStaff) {
        this.operationStaff = operationStaff;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getSpecialReqs() {
        return specialReqs;
    }

    public void setSpecialReqs(String specialReqs) {
        this.specialReqs = specialReqs;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
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
        return "com.cput.hospital.model.Patient[ id=" + id + " ]";
    }
    
}
