package com.indie.dental.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patient_address")
public class PatientAddress implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long patientId;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patientAddress")
//    private PatientDetail patientDetail;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name = "zipcode")
    private String zipcode;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

//    public PatientDetail getPatientDetail() {
//        return patientDetail;
//    }
//
//    public void setPatientDetail(PatientDetail patientDetail) {
//        this.patientDetail = patientDetail;
//    }
}
