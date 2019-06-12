package com.ghana.examresult.Model.Diploma;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Datum implements Serializable {

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
    @SerializedName("maritime_transport")
    @Expose
    private Integer maritimeTransport;
    @SerializedName("multimodal_transport")
    @Expose
    private Integer multimodalTransport;
    @SerializedName("sea_containers")
    @Expose
    private Integer seaContainers;
    @SerializedName("air_transport")
    @Expose
    private Integer airTransport;
    @SerializedName("road_transport")
    @Expose
    private Integer roadTransport;
    @SerializedName("rail_transport")
    @Expose
    private Integer railTransport;
    @SerializedName("inland_waterway_transport")
    @Expose
    private Integer inlandWaterwayTransport;
    @SerializedName("customs_procedures")
    @Expose
    private Integer customsProcedures;
    @SerializedName("logistics_and_warehousing")
    @Expose
    private Integer logisticsAndWarehousing;
    @SerializedName("transport_insurance")
    @Expose
    private Integer transportInsurance;
    @SerializedName("ict_in_forwarding")
    @Expose
    private Integer ictInForwarding;
    @SerializedName("dangerous_goods")
    @Expose
    private Integer dangerousGoods;
    @SerializedName("safety_and_security")
    @Expose
    private Integer safetyAndSecurity;
    @SerializedName("isActive")
    @Expose
    private String isActive;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("secret_code")
    @Expose
    private String secretCode;


    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
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

    public Integer getMaritimeTransport() {
        return maritimeTransport;
    }

    public void setMaritimeTransport(Integer maritimeTransport) {
        this.maritimeTransport = maritimeTransport;
    }

    public Integer getMultimodalTransport() {
        return multimodalTransport;
    }

    public void setMultimodalTransport(Integer multimodalTransport) {
        this.multimodalTransport = multimodalTransport;
    }

    public Integer getSeaContainers() {
        return seaContainers;
    }

    public void setSeaContainers(Integer seaContainers) {
        this.seaContainers = seaContainers;
    }

    public Integer getAirTransport() {
        return airTransport;
    }

    public void setAirTransport(Integer airTransport) {
        this.airTransport = airTransport;
    }

    public Integer getRoadTransport() {
        return roadTransport;
    }

    public void setRoadTransport(Integer roadTransport) {
        this.roadTransport = roadTransport;
    }

    public Integer getRailTransport() {
        return railTransport;
    }

    public void setRailTransport(Integer railTransport) {
        this.railTransport = railTransport;
    }

    public Integer getInlandWaterwayTransport() {
        return inlandWaterwayTransport;
    }

    public void setInlandWaterwayTransport(Integer inlandWaterwayTransport) {
        this.inlandWaterwayTransport = inlandWaterwayTransport;
    }

    public Integer getCustomsProcedures() {
        return customsProcedures;
    }

    public void setCustomsProcedures(Integer customsProcedures) {
        this.customsProcedures = customsProcedures;
    }

    public Integer getLogisticsAndWarehousing() {
        return logisticsAndWarehousing;
    }

    public void setLogisticsAndWarehousing(Integer logisticsAndWarehousing) {
        this.logisticsAndWarehousing = logisticsAndWarehousing;
    }

    public Integer getTransportInsurance() {
        return transportInsurance;
    }

    public void setTransportInsurance(Integer transportInsurance) {
        this.transportInsurance = transportInsurance;
    }

    public Integer getIctInForwarding() {
        return ictInForwarding;
    }

    public void setIctInForwarding(Integer ictInForwarding) {
        this.ictInForwarding = ictInForwarding;
    }

    public Integer getDangerousGoods() {
        return dangerousGoods;
    }

    public void setDangerousGoods(Integer dangerousGoods) {
        this.dangerousGoods = dangerousGoods;
    }

    public Integer getSafetyAndSecurity() {
        return safetyAndSecurity;
    }

    public void setSafetyAndSecurity(Integer safetyAndSecurity) {
        this.safetyAndSecurity = safetyAndSecurity;
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
                ", maritimeTransport=" + maritimeTransport +
                ", multimodalTransport=" + multimodalTransport +
                ", seaContainers=" + seaContainers +
                ", airTransport=" + airTransport +
                ", roadTransport=" + roadTransport +
                ", railTransport=" + railTransport +
                ", inlandWaterwayTransport=" + inlandWaterwayTransport +
                ", customsProcedures=" + customsProcedures +
                ", logisticsAndWarehousing=" + logisticsAndWarehousing +
                ", transportInsurance=" + transportInsurance +
                ", ictInForwarding=" + ictInForwarding +
                ", dangerousGoods=" + dangerousGoods +
                ", safetyAndSecurity=" + safetyAndSecurity +
                ", isActive='" + isActive + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", secretCode='" + secretCode + '\'' +
                '}';
    }
}