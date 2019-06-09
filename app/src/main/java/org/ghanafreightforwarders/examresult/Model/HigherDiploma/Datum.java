package org.ghanafreightforwarders.examresult.Model.HigherDiploma;

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
    @SerializedName("procurement_management")
    @Expose
    private Integer procurementManagement;
    @SerializedName("strategic_management")
    @Expose
    private Integer strategicManagement;
    @SerializedName("production_and_operational")
    @Expose
    private Integer productionAndOperational;
    @SerializedName("international_transport_management")
    @Expose
    private Integer internationalTransportManagement;
    @SerializedName("supply_chain_management")
    @Expose
    private Integer supplyChainManagement;
    @SerializedName("financial_management")
    @Expose
    private Integer financialManagement;
    @SerializedName("global_marketing")
    @Expose
    private Integer globalMarketing;
    @SerializedName("business_law")
    @Expose
    private Integer businessLaw;
    @SerializedName("human_resources_management")
    @Expose
    private Integer humanResourcesManagement;
    @SerializedName("research_methodology")
    @Expose
    private Integer researchMethodology;
    @SerializedName("entrepreneur_creativity")
    @Expose
    private Integer entrepreneurCreativity;
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

    public Integer getProcurementManagement() {
        return procurementManagement;
    }

    public void setProcurementManagement(Integer procurementManagement) {
        this.procurementManagement = procurementManagement;
    }

    public Integer getStrategicManagement() {
        return strategicManagement;
    }

    public void setStrategicManagement(Integer strategicManagement) {
        this.strategicManagement = strategicManagement;
    }

    public Integer getProductionAndOperational() {
        return productionAndOperational;
    }

    public void setProductionAndOperational(Integer productionAndOperational) {
        this.productionAndOperational = productionAndOperational;
    }

    public Integer getInternationalTransportManagement() {
        return internationalTransportManagement;
    }

    public void setInternationalTransportManagement(Integer internationalTransportManagement) {
        this.internationalTransportManagement = internationalTransportManagement;
    }

    public Integer getSupplyChainManagement() {
        return supplyChainManagement;
    }

    public void setSupplyChainManagement(Integer supplyChainManagement) {
        this.supplyChainManagement = supplyChainManagement;
    }

    public Integer getFinancialManagement() {
        return financialManagement;
    }

    public void setFinancialManagement(Integer financialManagement) {
        this.financialManagement = financialManagement;
    }

    public Integer getGlobalMarketing() {
        return globalMarketing;
    }

    public void setGlobalMarketing(Integer globalMarketing) {
        this.globalMarketing = globalMarketing;
    }

    public Integer getBusinessLaw() {
        return businessLaw;
    }

    public void setBusinessLaw(Integer businessLaw) {
        this.businessLaw = businessLaw;
    }

    public Integer getHumanResourcesManagement() {
        return humanResourcesManagement;
    }

    public void setHumanResourcesManagement(Integer humanResourcesManagement) {
        this.humanResourcesManagement = humanResourcesManagement;
    }

    public Integer getResearchMethodology() {
        return researchMethodology;
    }

    public void setResearchMethodology(Integer researchMethodology) {
        this.researchMethodology = researchMethodology;
    }

    public Integer getEntrepreneurCreativity() {
        return entrepreneurCreativity;
    }

    public void setEntrepreneurCreativity(Integer entrepreneurCreativity) {
        this.entrepreneurCreativity = entrepreneurCreativity;
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
                ", procurementManagement=" + procurementManagement +
                ", strategicManagement=" + strategicManagement +
                ", productionAndOperational=" + productionAndOperational +
                ", internationalTransportManagement=" + internationalTransportManagement +
                ", supplyChainManagement=" + supplyChainManagement +
                ", financialManagement=" + financialManagement +
                ", globalMarketing=" + globalMarketing +
                ", businessLaw=" + businessLaw +
                ", humanResourcesManagement=" + humanResourcesManagement +
                ", researchMethodology=" + researchMethodology +
                ", entrepreneurCreativity=" + entrepreneurCreativity +
                ", isActive='" + isActive + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", secretCode='" + secretCode + '\'' +
                '}';
    }
}
