package com.example.studentresult.Model.Certificate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("student_name")
    @Expose
    private String studentName;
    @SerializedName("student_number")
    @Expose
    private String studentNumber;
    @SerializedName("intro_to_ff")
    @Expose
    private Integer introToFf;
    @SerializedName("intro_to_logistics")
    @Expose
    private Integer introToLogistics;
    @SerializedName("intro_to_transportation")
    @Expose
    private Integer introToTransportation;
    @SerializedName("intro_to_customs_procedures")
    @Expose
    private Integer introToCustomsProcedures;
    @SerializedName("business_communication")
    @Expose
    private Integer businessCommunication;
    @SerializedName("statistics_and_bm")
    @Expose
    private Integer statisticsAndBm;
    @SerializedName("isActive")
    @Expose
    private String isActive;
    @SerializedName("created_date")
    @Expose
    private String createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getIntroToFf() {
        return introToFf;
    }

    public void setIntroToFf(Integer introToFf) {
        this.introToFf = introToFf;
    }

    public Integer getIntroToLogistics() {
        return introToLogistics;
    }

    public void setIntroToLogistics(Integer introToLogistics) {
        this.introToLogistics = introToLogistics;
    }

    public Integer getIntroToTransportation() {
        return introToTransportation;
    }

    public void setIntroToTransportation(Integer introToTransportation) {
        this.introToTransportation = introToTransportation;
    }

    public Integer getIntroToCustomsProcedures() {
        return introToCustomsProcedures;
    }

    public void setIntroToCustomsProcedures(Integer introToCustomsProcedures) {
        this.introToCustomsProcedures = introToCustomsProcedures;
    }

    public Integer getBusinessCommunication() {
        return businessCommunication;
    }

    public void setBusinessCommunication(Integer businessCommunication) {
        this.businessCommunication = businessCommunication;
    }

    public Integer getStatisticsAndBm() {
        return statisticsAndBm;
    }

    public void setStatisticsAndBm(Integer statisticsAndBm) {
        this.statisticsAndBm = statisticsAndBm;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", introToFf=" + introToFf +
                ", introToLogistics=" + introToLogistics +
                ", introToTransportation=" + introToTransportation +
                ", introToCustomsProcedures=" + introToCustomsProcedures +
                ", businessCommunication=" + businessCommunication +
                ", statisticsAndBm=" + statisticsAndBm +
                ", isActive='" + isActive + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}