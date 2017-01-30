package com.example.taseneem21.bloodbank_v2;

/**
 * Created by taseneem 21 on 11/27/2016.
 */
public class Hospital {
    private String hospitalname;
    private String hospitalDescription;

    public Hospital(String hospitalname, String hospitalDescription) {
        this.hospitalname = hospitalname;
        this.hospitalDescription = hospitalDescription;
    }

    public Hospital() {
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getHospitalDescription() {
        return hospitalDescription;
    }

    public void setHospitalDescription(String hospitalDescription) {
        this.hospitalDescription = hospitalDescription;
    }

}
