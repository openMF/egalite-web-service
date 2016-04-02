
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MISBALTRANLOGDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MISBALTRANLOGDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIS" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="TXNDT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OLDMIS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NEWMIS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PERIOD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FINYR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GLCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MISBALTRANLOGDetails", propOrder = {
    "brn",
    "refno",
    "mis",
    "txndt",
    "oldmis",
    "newmis",
    "period",
    "finyr",
    "glcode",
    "ccy",
    "amt",
    "exrate"
})
public class MISBALTRANLOGDetails {

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
    @XmlElement(name = "PERIOD", required = true)
    protected String period;
    @XmlElement(name = "FINYR", required = true)
    protected String finyr;
    @XmlElement(name = "GLCODE", required = true)
    protected String glcode;
    @XmlElement(name = "CCY", required = true)
    protected String ccy;
    @XmlElement(name = "AMT", required = true)
    protected BigDecimal amt;
    @XmlElement(name = "EXRATE", required = true)
    protected BigDecimal exrate;

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

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERIOD() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERIOD(String value) {
        this.period = value;
    }

    /**
     * Gets the value of the finyr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFINYR() {
        return finyr;
    }

    /**
     * Sets the value of the finyr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFINYR(String value) {
        this.finyr = value;
    }

    /**
     * Gets the value of the glcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLCODE() {
        return glcode;
    }

    /**
     * Sets the value of the glcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLCODE(String value) {
        this.glcode = value;
    }

    /**
     * Gets the value of the ccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCY() {
        return ccy;
    }

    /**
     * Sets the value of the ccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCY(String value) {
        this.ccy = value;
    }

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMT() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMT(BigDecimal value) {
        this.amt = value;
    }

    /**
     * Gets the value of the exrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEXRATE() {
        return exrate;
    }

    /**
     * Sets the value of the exrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEXRATE(BigDecimal value) {
        this.exrate = value;
    }

}
