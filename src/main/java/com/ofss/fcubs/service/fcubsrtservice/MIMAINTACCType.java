
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MIMAINTACCType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MIMAINTACCType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MISGRP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RTFLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINKGRP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POOLCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFRTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFRTSPRD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="REFRTTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CALCMETH" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="TXNMIS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COSTCOD1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COSTCOD2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COSTCOD3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COSTCOD4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COSTCOD5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MIMAINTACCType", propOrder = {
    "misgrp",
    "rtflag",
    "linkgrp",
    "poolcd",
    "refrtcd",
    "refrtsprd",
    "refrttype",
    "calcmeth",
    "txnmis1",
    "txnmis2",
    "txnmis3",
    "txnmis4",
    "txnmis5",
    "txnmis6",
    "txnmis7",
    "txnmis8",
    "txnmis9",
    "txnmis10",
    "compmis1",
    "compmis2",
    "compmis3",
    "compmis4",
    "compmis5",
    "compmis6",
    "compmis7",
    "compmis8",
    "compmis9",
    "compmis10",
    "costcod1",
    "costcod2",
    "costcod3",
    "costcod4",
    "costcod5"
})
public class MIMAINTACCType {

    @XmlElement(name = "MISGRP")
    protected String misgrp;
    @XmlElement(name = "RTFLAG")
    protected String rtflag;
    @XmlElement(name = "LINKGRP")
    protected String linkgrp;
    @XmlElement(name = "POOLCD")
    protected String poolcd;
    @XmlElement(name = "REFRTCD")
    protected String refrtcd;
    @XmlElement(name = "REFRTSPRD")
    protected BigDecimal refrtsprd;
    @XmlElement(name = "REFRTTYPE")
    protected String refrttype;
    @XmlElement(name = "CALCMETH")
    protected BigInteger calcmeth;
    @XmlElement(name = "TXNMIS1")
    protected String txnmis1;
    @XmlElement(name = "TXNMIS2")
    protected String txnmis2;
    @XmlElement(name = "TXNMIS3")
    protected String txnmis3;
    @XmlElement(name = "TXNMIS4")
    protected String txnmis4;
    @XmlElement(name = "TXNMIS5")
    protected String txnmis5;
    @XmlElement(name = "TXNMIS6")
    protected String txnmis6;
    @XmlElement(name = "TXNMIS7")
    protected String txnmis7;
    @XmlElement(name = "TXNMIS8")
    protected String txnmis8;
    @XmlElement(name = "TXNMIS9")
    protected String txnmis9;
    @XmlElement(name = "TXNMIS10")
    protected String txnmis10;
    @XmlElement(name = "COMPMIS1")
    protected String compmis1;
    @XmlElement(name = "COMPMIS2")
    protected String compmis2;
    @XmlElement(name = "COMPMIS3")
    protected String compmis3;
    @XmlElement(name = "COMPMIS4")
    protected String compmis4;
    @XmlElement(name = "COMPMIS5")
    protected String compmis5;
    @XmlElement(name = "COMPMIS6")
    protected String compmis6;
    @XmlElement(name = "COMPMIS7")
    protected String compmis7;
    @XmlElement(name = "COMPMIS8")
    protected String compmis8;
    @XmlElement(name = "COMPMIS9")
    protected String compmis9;
    @XmlElement(name = "COMPMIS10")
    protected String compmis10;
    @XmlElement(name = "COSTCOD1")
    protected String costcod1;
    @XmlElement(name = "COSTCOD2")
    protected String costcod2;
    @XmlElement(name = "COSTCOD3")
    protected String costcod3;
    @XmlElement(name = "COSTCOD4")
    protected String costcod4;
    @XmlElement(name = "COSTCOD5")
    protected String costcod5;

    /**
     * Gets the value of the misgrp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMISGRP() {
        return misgrp;
    }

    /**
     * Sets the value of the misgrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMISGRP(String value) {
        this.misgrp = value;
    }

    /**
     * Gets the value of the rtflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRTFLAG() {
        return rtflag;
    }

    /**
     * Sets the value of the rtflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRTFLAG(String value) {
        this.rtflag = value;
    }

    /**
     * Gets the value of the linkgrp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKGRP() {
        return linkgrp;
    }

    /**
     * Sets the value of the linkgrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKGRP(String value) {
        this.linkgrp = value;
    }

    /**
     * Gets the value of the poolcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOOLCD() {
        return poolcd;
    }

    /**
     * Sets the value of the poolcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOOLCD(String value) {
        this.poolcd = value;
    }

    /**
     * Gets the value of the refrtcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFRTCD() {
        return refrtcd;
    }

    /**
     * Sets the value of the refrtcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFRTCD(String value) {
        this.refrtcd = value;
    }

    /**
     * Gets the value of the refrtsprd property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getREFRTSPRD() {
        return refrtsprd;
    }

    /**
     * Sets the value of the refrtsprd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setREFRTSPRD(BigDecimal value) {
        this.refrtsprd = value;
    }

    /**
     * Gets the value of the refrttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFRTTYPE() {
        return refrttype;
    }

    /**
     * Sets the value of the refrttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFRTTYPE(String value) {
        this.refrttype = value;
    }

    /**
     * Gets the value of the calcmeth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCALCMETH() {
        return calcmeth;
    }

    /**
     * Sets the value of the calcmeth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCALCMETH(BigInteger value) {
        this.calcmeth = value;
    }

    /**
     * Gets the value of the txnmis1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS1() {
        return txnmis1;
    }

    /**
     * Sets the value of the txnmis1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS1(String value) {
        this.txnmis1 = value;
    }

    /**
     * Gets the value of the txnmis2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS2() {
        return txnmis2;
    }

    /**
     * Sets the value of the txnmis2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS2(String value) {
        this.txnmis2 = value;
    }

    /**
     * Gets the value of the txnmis3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS3() {
        return txnmis3;
    }

    /**
     * Sets the value of the txnmis3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS3(String value) {
        this.txnmis3 = value;
    }

    /**
     * Gets the value of the txnmis4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS4() {
        return txnmis4;
    }

    /**
     * Sets the value of the txnmis4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS4(String value) {
        this.txnmis4 = value;
    }

    /**
     * Gets the value of the txnmis5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS5() {
        return txnmis5;
    }

    /**
     * Sets the value of the txnmis5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS5(String value) {
        this.txnmis5 = value;
    }

    /**
     * Gets the value of the txnmis6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS6() {
        return txnmis6;
    }

    /**
     * Sets the value of the txnmis6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS6(String value) {
        this.txnmis6 = value;
    }

    /**
     * Gets the value of the txnmis7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS7() {
        return txnmis7;
    }

    /**
     * Sets the value of the txnmis7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS7(String value) {
        this.txnmis7 = value;
    }

    /**
     * Gets the value of the txnmis8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS8() {
        return txnmis8;
    }

    /**
     * Sets the value of the txnmis8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS8(String value) {
        this.txnmis8 = value;
    }

    /**
     * Gets the value of the txnmis9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS9() {
        return txnmis9;
    }

    /**
     * Sets the value of the txnmis9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS9(String value) {
        this.txnmis9 = value;
    }

    /**
     * Gets the value of the txnmis10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS10() {
        return txnmis10;
    }

    /**
     * Sets the value of the txnmis10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS10(String value) {
        this.txnmis10 = value;
    }

    /**
     * Gets the value of the compmis1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS1() {
        return compmis1;
    }

    /**
     * Sets the value of the compmis1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS1(String value) {
        this.compmis1 = value;
    }

    /**
     * Gets the value of the compmis2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS2() {
        return compmis2;
    }

    /**
     * Sets the value of the compmis2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS2(String value) {
        this.compmis2 = value;
    }

    /**
     * Gets the value of the compmis3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS3() {
        return compmis3;
    }

    /**
     * Sets the value of the compmis3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS3(String value) {
        this.compmis3 = value;
    }

    /**
     * Gets the value of the compmis4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS4() {
        return compmis4;
    }

    /**
     * Sets the value of the compmis4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS4(String value) {
        this.compmis4 = value;
    }

    /**
     * Gets the value of the compmis5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS5() {
        return compmis5;
    }

    /**
     * Sets the value of the compmis5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS5(String value) {
        this.compmis5 = value;
    }

    /**
     * Gets the value of the compmis6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS6() {
        return compmis6;
    }

    /**
     * Sets the value of the compmis6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS6(String value) {
        this.compmis6 = value;
    }

    /**
     * Gets the value of the compmis7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS7() {
        return compmis7;
    }

    /**
     * Sets the value of the compmis7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS7(String value) {
        this.compmis7 = value;
    }

    /**
     * Gets the value of the compmis8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS8() {
        return compmis8;
    }

    /**
     * Sets the value of the compmis8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS8(String value) {
        this.compmis8 = value;
    }

    /**
     * Gets the value of the compmis9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS9() {
        return compmis9;
    }

    /**
     * Sets the value of the compmis9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS9(String value) {
        this.compmis9 = value;
    }

    /**
     * Gets the value of the compmis10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS10() {
        return compmis10;
    }

    /**
     * Sets the value of the compmis10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS10(String value) {
        this.compmis10 = value;
    }

    /**
     * Gets the value of the costcod1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSTCOD1() {
        return costcod1;
    }

    /**
     * Sets the value of the costcod1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSTCOD1(String value) {
        this.costcod1 = value;
    }

    /**
     * Gets the value of the costcod2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSTCOD2() {
        return costcod2;
    }

    /**
     * Sets the value of the costcod2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSTCOD2(String value) {
        this.costcod2 = value;
    }

    /**
     * Gets the value of the costcod3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSTCOD3() {
        return costcod3;
    }

    /**
     * Sets the value of the costcod3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSTCOD3(String value) {
        this.costcod3 = value;
    }

    /**
     * Gets the value of the costcod4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSTCOD4() {
        return costcod4;
    }

    /**
     * Sets the value of the costcod4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSTCOD4(String value) {
        this.costcod4 = value;
    }

    /**
     * Gets the value of the costcod5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOSTCOD5() {
        return costcod5;
    }

    /**
     * Sets the value of the costcod5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOSTCOD5(String value) {
        this.costcod5 = value;
    }

}
