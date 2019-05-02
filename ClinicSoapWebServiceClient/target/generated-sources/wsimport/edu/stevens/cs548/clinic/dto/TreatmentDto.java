
package edu.stevens.cs548.clinic.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="diagnosis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="drugTreatment" type="{http://cs548.stevens.edu/clinic/dto}drugTreatment" minOccurs="0"/>
 *         &lt;element name="radiology" type="{http://cs548.stevens.edu/clinic/dto}radiologyTreatment" minOccurs="0"/>
 *         &lt;element name="surgery" type="{http://cs548.stevens.edu/clinic/dto}surgeryTreatment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "diagnosis",
    "patient",
    "provider",
    "drugTreatment",
    "radiology",
    "surgery"
})
@XmlRootElement(name = "treatment-dto")
public class TreatmentDto {

    protected long id;
    @XmlElement(required = true)
    protected String diagnosis;
    protected long patient;
    protected long provider;
    protected DrugTreatment drugTreatment;
    protected RadiologyTreatment radiology;
    protected SurgeryTreatment surgery;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the diagnosis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets the value of the diagnosis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagnosis(String value) {
        this.diagnosis = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     */
    public long getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     */
    public void setPatient(long value) {
        this.patient = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     */
    public long getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     */
    public void setProvider(long value) {
        this.provider = value;
    }

    /**
     * Gets the value of the drugTreatment property.
     * 
     * @return
     *     possible object is
     *     {@link DrugTreatment }
     *     
     */
    public DrugTreatment getDrugTreatment() {
        return drugTreatment;
    }

    /**
     * Sets the value of the drugTreatment property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrugTreatment }
     *     
     */
    public void setDrugTreatment(DrugTreatment value) {
        this.drugTreatment = value;
    }

    /**
     * Gets the value of the radiology property.
     * 
     * @return
     *     possible object is
     *     {@link RadiologyTreatment }
     *     
     */
    public RadiologyTreatment getRadiology() {
        return radiology;
    }

    /**
     * Sets the value of the radiology property.
     * 
     * @param value
     *     allowed object is
     *     {@link RadiologyTreatment }
     *     
     */
    public void setRadiology(RadiologyTreatment value) {
        this.radiology = value;
    }

    /**
     * Gets the value of the surgery property.
     * 
     * @return
     *     possible object is
     *     {@link SurgeryTreatment }
     *     
     */
    public SurgeryTreatment getSurgery() {
        return surgery;
    }

    /**
     * Sets the value of the surgery property.
     * 
     * @param value
     *     allowed object is
     *     {@link SurgeryTreatment }
     *     
     */
    public void setSurgery(SurgeryTreatment value) {
        this.surgery = value;
    }

}
