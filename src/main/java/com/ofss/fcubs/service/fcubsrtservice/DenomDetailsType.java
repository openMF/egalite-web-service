
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DenomDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DenomDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CDCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDDENOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UNITS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="INOUTIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DENMVAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DenomDetailsType", propOrder = {
    "cdccy",
    "cddenom",
    "value",
    "units",
    "inoutind",
    "denmval"
})
public class DenomDetailsType {

    @XmlElement(name = "CDCCY")
    protected String cdccy;
    @XmlElement(name = "CDDENOM")
    protected String cddenom;
    @XmlElement(name = "VALUE")
    protected BigDecimal value;
    @XmlElement(name = "UNITS")
    protected BigDecimal units;
    @XmlElement(name = "INOUTIND")
    protected String inoutind;
    @XmlElement(name = "DENMVAL")
    protected BigDecimal denmval;

    /**
     * Gets the value of the cdccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDCCY() {
        return cdccy;
    }

    /**
     * Sets the value of the cdccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDCCY(String value) {
        this.cdccy = value;
    }

    /**
     * Gets the value of the cddenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDDENOM() {
        return cddenom;
    }

    /**
     * Sets the value of the cddenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDDENOM(String value) {
        this.cddenom = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVALUE() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVALUE(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUNITS() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUNITS(BigDecimal value) {
        this.units = value;
    }

    /**
     * Gets the value of the inoutind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINOUTIND() {
        return inoutind;
    }

    /**
     * Sets the value of the inoutind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINOUTIND(String value) {
        this.inoutind = value;
    }

    /**
     * Gets the value of the denmval property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDENMVAL() {
        return denmval;
    }

    /**
     * Sets the value of the denmval property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDENMVAL(BigDecimal value) {
        this.denmval = value;
    }

}
