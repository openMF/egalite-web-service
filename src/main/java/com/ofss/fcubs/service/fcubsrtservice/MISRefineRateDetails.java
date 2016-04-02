
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MISRefineRateDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MISRefineRateDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UNITREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BKDATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="EFFDT" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="REFRT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MISRefineRateDetails", propOrder = {
    "unitref",
    "bkdate",
    "effdt",
    "refrt"
})
public class MISRefineRateDetails {

    @XmlElement(name = "UNITREF")
    protected String unitref;
    @XmlElement(name = "BKDATE", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object bkdate;
    @XmlElement(name = "EFFDT")
    @XmlSchemaType(name = "anySimpleType")
    protected Object effdt;
    @XmlElement(name = "REFRT", required = true)
    protected BigDecimal refrt;

    /**
     * Gets the value of the unitref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITREF() {
        return unitref;
    }

    /**
     * Sets the value of the unitref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITREF(String value) {
        this.unitref = value;
    }

    /**
     * Gets the value of the bkdate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBKDATE() {
        return bkdate;
    }

    /**
     * Sets the value of the bkdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBKDATE(Object value) {
        this.bkdate = value;
    }

    /**
     * Gets the value of the effdt property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEFFDT() {
        return effdt;
    }

    /**
     * Sets the value of the effdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEFFDT(Object value) {
        this.effdt = value;
    }

    /**
     * Gets the value of the refrt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getREFRT() {
        return refrt;
    }

    /**
     * Sets the value of the refrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setREFRT(BigDecimal value) {
        this.refrt = value;
    }

}
