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
 * @author Leo
 */
@Entity
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date joinedDate;
    
    private String staffNum;
    private String education;
    private String certification;
    private String langauges;
    @OneToMany(orphanRemoval= true,cascade=CascadeType.ALL)
    @JoinColumn(name="staff_number")
    private List<AdministrativeStaff> admin = new ArrayList<AdministrativeStaff>();
    @OneToMany
    @JoinColumn(name="staff_number")
    private List<TechnicalStaff> techStaff = new ArrayList<TechnicalStaff>();
    
    public List<AdministrativeStaff> getAdmin() {
        return admin;
    }
    @OneToMany(orphanRemoval= true,cascade=CascadeType.ALL)
    @JoinColumn(name="staff_number")
    private List<OperationStaff> opStaff;

    public List<OperationStaff> getOpStaff() {
        return opStaff;
    }

    public void setOpStaff(List<OperationStaff> opStaff) {
        this.opStaff = opStaff;
    }
    
    public void setAdmin(List<AdministrativeStaff> admin) {
        this.admin = admin;
    }

    public List<TechnicalStaff> getTechStaff() {
        return techStaff;
    }

    public void setTechStaff(List<TechnicalStaff> techStaff) {
        this.techStaff = techStaff;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getLangauges() {
        return langauges;
    }

    public void setLangauges(String langauges) {
        this.langauges = langauges;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
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
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.za.hospital.model.Staff[ id=" + id + " ]";
    }
    
}
