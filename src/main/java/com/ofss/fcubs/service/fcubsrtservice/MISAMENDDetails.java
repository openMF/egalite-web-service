
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MISAMENDDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MISAMENDDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CONTREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SPD" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MISAMENDDetails", propOrder = {
    "contref",
    "rtype",
    "rcode",
    "spd"
})
public class MISAMENDDetails {

    @XmlElement(name = "CONTREF")
    protected String contref;
    @XmlElement(name = "RTYPE", required = true)
    protected String rtype;
    @XmlElement(name = "RCODE", required = true)
    protected String rcode;
    @XmlElement(name = "SPD", required = true)
    protected BigDecimal spd;

    /**
     * Gets the value of the contref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTREF() {
        return contref;
    }

    /**
     * Sets the value of the contref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTREF(String value) {
        this.contref = value;
    }

    /**
     * Gets the value of the rtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRTYPE() {
        return rtype;
    }

    /**
     * Sets the value of the rtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRTYPE(String value) {
        this.rtype = value;
    }

    /**
     * Gets the value of the rcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRCODE() {
        return rcode;
    }

    /**
     * Sets the value of the rcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRCODE(String value) {
        this.rcode = value;
    }

    /**
     * Gets the value of the spd property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSPD() {
        return spd;
    }

    /**
     * Sets the value of the spd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSPD(BigDecimal value) {
        this.spd = value;
    }

}
