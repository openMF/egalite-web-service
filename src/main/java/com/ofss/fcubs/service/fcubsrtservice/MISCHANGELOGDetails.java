
package com.ofss.fcubs.service.fcubsrtservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MISCHANGELOGDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MISCHANGELOGDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIS" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="TXNDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OLDMIS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NEWMIS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MISCHANGELOGDetails", propOrder = {
    "brn",
    "refno",
    "mis",
    "txndt",
    "oldmis",
    "newmis"
})
public class MISCHANGELOGDetails {

    @XmlElement(name = "BRN")
    protected String brn;
    @XmlElement(name = "REFNO")
    protected String refno;
    @XmlElement(name = "MIS")
    @XmlSchemaType(name = "anySimpleType")
    protected Object mis;
    @XmlElement(name = "TXNDT")
    protected String txndt;
    @XmlElement(name = "OLDMIS", required = true)
    protected String oldmis;
    @XmlElement(name = "NEWMIS", required = true)
    protected String newmis;

    /**
     * Gets the value of the brn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRN() {
        return brn;
    }

    /**
     * Sets the value of the brn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRN(String value) {
        this.brn = value;
    }

    /**
     * Gets the value of the refno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFNO() {
        return refno;
    }

    /**
     * Sets the value of the refno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFNO(String value) {
        this.refno = value;
    }

    /**
     * Gets the value of the mis property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getMIS() {
        return mis;
    }

    /**
     * Sets the value of the mis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setMIS(Object value) {
        this.mis = value;
    }

    /**
     * Gets the value of the txndt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNDT() {
        return txndt;
    }

    /**
     * Sets the value of the txndt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNDT(String value) {
        this.txndt = value;
    }

    /**
     * Gets the value of the oldmis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOLDMIS() {
        return oldmis;
    }

    /**
     * Sets the value of the oldmis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOLDMIS(String value) {
        this.oldmis = value;
    }

    /**
     * Gets the value of the newmis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEWMIS() {
        return newmis;
    }

    /**
     * Sets the value of the newmis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEWMIS(String value) {
        this.newmis = value;
    }

}
