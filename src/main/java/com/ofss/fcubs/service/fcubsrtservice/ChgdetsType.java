
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChgdetsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChgdetsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CHGCOMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WAIVER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGAMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CHGCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MISHEAD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETTINGIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGGL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCYCHG" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="XRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYCHG" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChgdetsType", propOrder = {
    "chgcomp",
    "waiver",
    "chgamt",
    "chgccy",
    "mishead",
    "txncode",
    "nettingind",
    "chggl",
    "type",
    "lcychg",
    "xrate",
    "tcychg",
    "tcyxrate"
})
public class ChgdetsType {

    @XmlElement(name = "CHGCOMP")
    protected String chgcomp;
    @XmlElement(name = "WAIVER")
    protected String waiver;
    @XmlElement(name = "CHGAMT", required = true)
    protected BigDecimal chgamt;
    @XmlElement(name = "CHGCCY")
    protected String chgccy;
    @XmlElement(name = "MISHEAD")
    protected String mishead;
    @XmlElement(name = "TXNCODE")
    protected String txncode;
    @XmlElement(name = "NETTINGIND")
    protected String nettingind;
    @XmlElement(name = "CHGGL")
    protected String chggl;
    @XmlElement(name = "TYPE")
    protected String type;
    @XmlElement(name = "LCYCHG")
    protected BigDecimal lcychg;
    @XmlElement(name = "XRATE")
    protected BigDecimal xrate;
    @XmlElement(name = "TCYCHG")
    protected BigDecimal tcychg;
    @XmlElement(name = "TCYXRATE")
    protected BigDecimal tcyxrate;

    /**
     * Gets the value of the chgcomp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGCOMP() {
        return chgcomp;
    }

    /**
     * Sets the value of the chgcomp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGCOMP(String value) {
        this.chgcomp = value;
    }

    /**
     * Gets the value of the waiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWAIVER() {
        return waiver;
    }

    /**
     * Sets the value of the waiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWAIVER(String value) {
        this.waiver = value;
    }

    /**
     * Gets the value of the chgamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGAMT() {
        return chgamt;
    }

    /**
     * Sets the value of the chgamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGAMT(BigDecimal value) {
        this.chgamt = value;
    }

    /**
     * Gets the value of the chgccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGCCY() {
        return chgccy;
    }

    /**
     * Sets the value of the chgccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGCCY(String value) {
        this.chgccy = value;
    }

    /**
     * Gets the value of the mishead property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMISHEAD() {
        return mishead;
    }

    /**
     * Sets the value of the mishead property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMISHEAD(String value) {
        this.mishead = value;
    }

    /**
     * Gets the value of the txncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNCODE() {
        return txncode;
    }

    /**
     * Sets the value of the txncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNCODE(String value) {
        this.txncode = value;
    }

    /**
     * Gets the value of the nettingind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNETTINGIND() {
        return nettingind;
    }

    /**
     * Sets the value of the nettingind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNETTINGIND(String value) {
        this.nettingind = value;
    }

    /**
     * Gets the value of the chggl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGGL() {
        return chggl;
    }

    /**
     * Sets the value of the chggl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGGL(String value) {
        this.chggl = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the lcychg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYCHG() {
        return lcychg;
    }

    /**
     * Sets the value of the lcychg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYCHG(BigDecimal value) {
        this.lcychg = value;
    }

    /**
     * Gets the value of the xrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getXRATE() {
        return xrate;
    }

    /**
     * Sets the value of the xrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setXRATE(BigDecimal value) {
        this.xrate = value;
    }

    /**
     * Gets the value of the tcychg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYCHG() {
        return tcychg;
    }

    /**
     * Sets the value of the tcychg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYCHG(BigDecimal value) {
        this.tcychg = value;
    }

    /**
     * Gets the value of the tcyxrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYXRATE() {
        return tcyxrate;
    }

    /**
     * Sets the value of the tcyxrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYXRATE(BigDecimal value) {
        this.tcyxrate = value;
    }

}
