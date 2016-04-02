
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MISDETAILSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MISDETAILSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MISGRP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REL_REF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REL_ACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MISHD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POOLCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFRT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="REFRTTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFXRT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CALCMETH" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="MISGRPTXN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFRTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFRTSPRD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FUNDMIS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MISGRPCOMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="LINKGRP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RTFLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROCFLG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="FUNDMIS1LBL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS2LBL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS3LBL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS4LBL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS5LBL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS6LBL6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS7LBL7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS8LBL8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS9LBL9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FUNDMIS10LBL10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS1LBL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS2LBL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS3LBL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS4LBL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS5LBL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS6LBL6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS7LBL7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS8LBL8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS9LBL9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPMIS10LBL10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS1LBL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS2LBL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS3LBL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS4LBL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS5LBL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS6LBL6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS7LBL7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS8LBL8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS9LBL9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNMIS10LBL10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MISDETAILSType", propOrder = {
    "branch",
    "custno",
    "misgrp",
    "relref",
    "relacc",
    "mishd",
    "poolcd",
    "refrt",
    "refrttype",
    "refxrt",
    "calcmeth",
    "misgrptxn",
    "refrtcd",
    "refrtsprd",
    "fundmis1",
    "fundmis2",
    "fundmis3",
    "fundmis4",
    "fundmis5",
    "fundmis6",
    "fundmis7",
    "fundmis8",
    "fundmis9",
    "fundmis10",
    "misgrpcomp",
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
    "costcod5",
    "linkgrp",
    "ccy",
    "rtflag",
    "procflg",
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
    "fundmis1LBL1",
    "fundmis2LBL2",
    "fundmis3LBL3",
    "fundmis4LBL4",
    "fundmis5LBL5",
    "fundmis6LBL6",
    "fundmis7LBL7",
    "fundmis8LBL8",
    "fundmis9LBL9",
    "fundmis10LBL10",
    "compmis1LBL1",
    "compmis2LBL2",
    "compmis3LBL3",
    "compmis4LBL4",
    "compmis5LBL5",
    "compmis6LBL6",
    "compmis7LBL7",
    "compmis8LBL8",
    "compmis9LBL9",
    "compmis10LBL10",
    "txnmis1LBL1",
    "txnmis2LBL2",
    "txnmis3LBL3",
    "txnmis4LBL4",
    "txnmis5LBL5",
    "txnmis6LBL6",
    "txnmis7LBL7",
    "txnmis8LBL8",
    "txnmis9LBL9",
    "txnmis10LBL10"
})
public class MISDETAILSType {

    @XmlElement(name = "BRANCH")
    protected String branch;
    @XmlElement(name = "CUSTNO")
    protected String custno;
    @XmlElement(name = "MISGRP")
    protected String misgrp;
    @XmlElement(name = "REL_REF")
    protected String relref;
    @XmlElement(name = "REL_ACC")
    protected String relacc;
    @XmlElement(name = "MISHD")
    protected String mishd;
    @XmlElement(name = "POOLCD")
    protected String poolcd;
    @XmlElement(name = "REFRT")
    protected BigDecimal refrt;
    @XmlElement(name = "REFRTTYPE")
    protected String refrttype;
    @XmlElement(name = "REFXRT")
    protected String refxrt;
    @XmlElement(name = "CALCMETH")
    protected BigInteger calcmeth;
    @XmlElement(name = "MISGRPTXN")
    protected String misgrptxn;
    @XmlElement(name = "REFRTCD")
    protected String refrtcd;
    @XmlElement(name = "REFRTSPRD")
    protected BigDecimal refrtsprd;
    @XmlElement(name = "FUNDMIS1")
    protected String fundmis1;
    @XmlElement(name = "FUNDMIS2")
    protected String fundmis2;
    @XmlElement(name = "FUNDMIS3")
    protected String fundmis3;
    @XmlElement(name = "FUNDMIS4")
    protected String fundmis4;
    @XmlElement(name = "FUNDMIS5")
    protected String fundmis5;
    @XmlElement(name = "FUNDMIS6")
    protected String fundmis6;
    @XmlElement(name = "FUNDMIS7")
    protected String fundmis7;
    @XmlElement(name = "FUNDMIS8")
    protected String fundmis8;
    @XmlElement(name = "FUNDMIS9")
    protected String fundmis9;
    @XmlElement(name = "FUNDMIS10")
    protected String fundmis10;
    @XmlElement(name = "MISGRPCOMP")
    protected String misgrpcomp;
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
    @XmlElement(name = "LINKGRP")
    protected String linkgrp;
    @XmlElement(name = "CCY")
    protected String ccy;
    @XmlElement(name = "RTFLAG")
    protected String rtflag;
    @XmlElement(name = "PROCFLG")
    protected String procflg;
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
    @XmlElement(name = "FUNDMIS1LBL1")
    protected String fundmis1LBL1;
    @XmlElement(name = "FUNDMIS2LBL2")
    protected String fundmis2LBL2;
    @XmlElement(name = "FUNDMIS3LBL3")
    protected String fundmis3LBL3;
    @XmlElement(name = "FUNDMIS4LBL4")
    protected String fundmis4LBL4;
    @XmlElement(name = "FUNDMIS5LBL5")
    protected String fundmis5LBL5;
    @XmlElement(name = "FUNDMIS6LBL6")
    protected String fundmis6LBL6;
    @XmlElement(name = "FUNDMIS7LBL7")
    protected String fundmis7LBL7;
    @XmlElement(name = "FUNDMIS8LBL8")
    protected String fundmis8LBL8;
    @XmlElement(name = "FUNDMIS9LBL9")
    protected String fundmis9LBL9;
    @XmlElement(name = "FUNDMIS10LBL10")
    protected String fundmis10LBL10;
    @XmlElement(name = "COMPMIS1LBL1")
    protected String compmis1LBL1;
    @XmlElement(name = "COMPMIS2LBL2")
    protected String compmis2LBL2;
    @XmlElement(name = "COMPMIS3LBL3")
    protected String compmis3LBL3;
    @XmlElement(name = "COMPMIS4LBL4")
    protected String compmis4LBL4;
    @XmlElement(name = "COMPMIS5LBL5")
    protected String compmis5LBL5;
    @XmlElement(name = "COMPMIS6LBL6")
    protected String compmis6LBL6;
    @XmlElement(name = "COMPMIS7LBL7")
    protected String compmis7LBL7;
    @XmlElement(name = "COMPMIS8LBL8")
    protected String compmis8LBL8;
    @XmlElement(name = "COMPMIS9LBL9")
    protected String compmis9LBL9;
    @XmlElement(name = "COMPMIS10LBL10")
    protected String compmis10LBL10;
    @XmlElement(name = "TXNMIS1LBL1")
    protected String txnmis1LBL1;
    @XmlElement(name = "TXNMIS2LBL2")
    protected String txnmis2LBL2;
    @XmlElement(name = "TXNMIS3LBL3")
    protected String txnmis3LBL3;
    @XmlElement(name = "TXNMIS4LBL4")
    protected String txnmis4LBL4;
    @XmlElement(name = "TXNMIS5LBL5")
    protected String txnmis5LBL5;
    @XmlElement(name = "TXNMIS6LBL6")
    protected String txnmis6LBL6;
    @XmlElement(name = "TXNMIS7LBL7")
    protected String txnmis7LBL7;
    @XmlElement(name = "TXNMIS8LBL8")
    protected String txnmis8LBL8;
    @XmlElement(name = "TXNMIS9LBL9")
    protected String txnmis9LBL9;
    @XmlElement(name = "TXNMIS10LBL10")
    protected String txnmis10LBL10;

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRANCH() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRANCH(String value) {
        this.branch = value;
    }

    /**
     * Gets the value of the custno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTNO() {
        return custno;
    }

    /**
     * Sets the value of the custno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTNO(String value) {
        this.custno = value;
    }

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
     * Gets the value of the relref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELREF() {
        return relref;
    }

    /**
     * Sets the value of the relref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELREF(String value) {
        this.relref = value;
    }

    /**
     * Gets the value of the relacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELACC() {
        return relacc;
    }

    /**
     * Sets the value of the relacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELACC(String value) {
        this.relacc = value;
    }

    /**
     * Gets the value of the mishd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMISHD() {
        return mishd;
    }

    /**
     * Sets the value of the mishd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMISHD(String value) {
        this.mishd = value;
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
     * Gets the value of the refxrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFXRT() {
        return refxrt;
    }

    /**
     * Sets the value of the refxrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFXRT(String value) {
        this.refxrt = value;
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
     * Gets the value of the misgrptxn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMISGRPTXN() {
        return misgrptxn;
    }

    /**
     * Sets the value of the misgrptxn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMISGRPTXN(String value) {
        this.misgrptxn = value;
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
     * Gets the value of the fundmis1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS1() {
        return fundmis1;
    }

    /**
     * Sets the value of the fundmis1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS1(String value) {
        this.fundmis1 = value;
    }

    /**
     * Gets the value of the fundmis2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS2() {
        return fundmis2;
    }

    /**
     * Sets the value of the fundmis2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS2(String value) {
        this.fundmis2 = value;
    }

    /**
     * Gets the value of the fundmis3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS3() {
        return fundmis3;
    }

    /**
     * Sets the value of the fundmis3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS3(String value) {
        this.fundmis3 = value;
    }

    /**
     * Gets the value of the fundmis4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS4() {
        return fundmis4;
    }

    /**
     * Sets the value of the fundmis4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS4(String value) {
        this.fundmis4 = value;
    }

    /**
     * Gets the value of the fundmis5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS5() {
        return fundmis5;
    }

    /**
     * Sets the value of the fundmis5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS5(String value) {
        this.fundmis5 = value;
    }

    /**
     * Gets the value of the fundmis6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS6() {
        return fundmis6;
    }

    /**
     * Sets the value of the fundmis6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS6(String value) {
        this.fundmis6 = value;
    }

    /**
     * Gets the value of the fundmis7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS7() {
        return fundmis7;
    }

    /**
     * Sets the value of the fundmis7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS7(String value) {
        this.fundmis7 = value;
    }

    /**
     * Gets the value of the fundmis8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS8() {
        return fundmis8;
    }

    /**
     * Sets the value of the fundmis8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS8(String value) {
        this.fundmis8 = value;
    }

    /**
     * Gets the value of the fundmis9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS9() {
        return fundmis9;
    }

    /**
     * Sets the value of the fundmis9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS9(String value) {
        this.fundmis9 = value;
    }

    /**
     * Gets the value of the fundmis10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS10() {
        return fundmis10;
    }

    /**
     * Sets the value of the fundmis10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS10(String value) {
        this.fundmis10 = value;
    }

    /**
     * Gets the value of the misgrpcomp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMISGRPCOMP() {
        return misgrpcomp;
    }

    /**
     * Sets the value of the misgrpcomp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMISGRPCOMP(String value) {
        this.misgrpcomp = value;
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
     * Gets the value of the procflg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCFLG() {
        return procflg;
    }

    /**
     * Sets the value of the procflg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCFLG(String value) {
        this.procflg = value;
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
     * Gets the value of the fundmis1LBL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS1LBL1() {
        return fundmis1LBL1;
    }

    /**
     * Sets the value of the fundmis1LBL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS1LBL1(String value) {
        this.fundmis1LBL1 = value;
    }

    /**
     * Gets the value of the fundmis2LBL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS2LBL2() {
        return fundmis2LBL2;
    }

    /**
     * Sets the value of the fundmis2LBL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS2LBL2(String value) {
        this.fundmis2LBL2 = value;
    }

    /**
     * Gets the value of the fundmis3LBL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS3LBL3() {
        return fundmis3LBL3;
    }

    /**
     * Sets the value of the fundmis3LBL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS3LBL3(String value) {
        this.fundmis3LBL3 = value;
    }

    /**
     * Gets the value of the fundmis4LBL4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS4LBL4() {
        return fundmis4LBL4;
    }

    /**
     * Sets the value of the fundmis4LBL4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS4LBL4(String value) {
        this.fundmis4LBL4 = value;
    }

    /**
     * Gets the value of the fundmis5LBL5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS5LBL5() {
        return fundmis5LBL5;
    }

    /**
     * Sets the value of the fundmis5LBL5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS5LBL5(String value) {
        this.fundmis5LBL5 = value;
    }

    /**
     * Gets the value of the fundmis6LBL6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS6LBL6() {
        return fundmis6LBL6;
    }

    /**
     * Sets the value of the fundmis6LBL6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS6LBL6(String value) {
        this.fundmis6LBL6 = value;
    }

    /**
     * Gets the value of the fundmis7LBL7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS7LBL7() {
        return fundmis7LBL7;
    }

    /**
     * Sets the value of the fundmis7LBL7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS7LBL7(String value) {
        this.fundmis7LBL7 = value;
    }

    /**
     * Gets the value of the fundmis8LBL8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS8LBL8() {
        return fundmis8LBL8;
    }

    /**
     * Sets the value of the fundmis8LBL8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS8LBL8(String value) {
        this.fundmis8LBL8 = value;
    }

    /**
     * Gets the value of the fundmis9LBL9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS9LBL9() {
        return fundmis9LBL9;
    }

    /**
     * Sets the value of the fundmis9LBL9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS9LBL9(String value) {
        this.fundmis9LBL9 = value;
    }

    /**
     * Gets the value of the fundmis10LBL10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNDMIS10LBL10() {
        return fundmis10LBL10;
    }

    /**
     * Sets the value of the fundmis10LBL10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNDMIS10LBL10(String value) {
        this.fundmis10LBL10 = value;
    }

    /**
     * Gets the value of the compmis1LBL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS1LBL1() {
        return compmis1LBL1;
    }

    /**
     * Sets the value of the compmis1LBL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS1LBL1(String value) {
        this.compmis1LBL1 = value;
    }

    /**
     * Gets the value of the compmis2LBL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS2LBL2() {
        return compmis2LBL2;
    }

    /**
     * Sets the value of the compmis2LBL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS2LBL2(String value) {
        this.compmis2LBL2 = value;
    }

    /**
     * Gets the value of the compmis3LBL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS3LBL3() {
        return compmis3LBL3;
    }

    /**
     * Sets the value of the compmis3LBL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS3LBL3(String value) {
        this.compmis3LBL3 = value;
    }

    /**
     * Gets the value of the compmis4LBL4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS4LBL4() {
        return compmis4LBL4;
    }

    /**
     * Sets the value of the compmis4LBL4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS4LBL4(String value) {
        this.compmis4LBL4 = value;
    }

    /**
     * Gets the value of the compmis5LBL5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS5LBL5() {
        return compmis5LBL5;
    }

    /**
     * Sets the value of the compmis5LBL5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS5LBL5(String value) {
        this.compmis5LBL5 = value;
    }

    /**
     * Gets the value of the compmis6LBL6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS6LBL6() {
        return compmis6LBL6;
    }

    /**
     * Sets the value of the compmis6LBL6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS6LBL6(String value) {
        this.compmis6LBL6 = value;
    }

    /**
     * Gets the value of the compmis7LBL7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS7LBL7() {
        return compmis7LBL7;
    }

    /**
     * Sets the value of the compmis7LBL7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS7LBL7(String value) {
        this.compmis7LBL7 = value;
    }

    /**
     * Gets the value of the compmis8LBL8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS8LBL8() {
        return compmis8LBL8;
    }

    /**
     * Sets the value of the compmis8LBL8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS8LBL8(String value) {
        this.compmis8LBL8 = value;
    }

    /**
     * Gets the value of the compmis9LBL9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS9LBL9() {
        return compmis9LBL9;
    }

    /**
     * Sets the value of the compmis9LBL9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS9LBL9(String value) {
        this.compmis9LBL9 = value;
    }

    /**
     * Gets the value of the compmis10LBL10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPMIS10LBL10() {
        return compmis10LBL10;
    }

    /**
     * Sets the value of the compmis10LBL10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPMIS10LBL10(String value) {
        this.compmis10LBL10 = value;
    }

    /**
     * Gets the value of the txnmis1LBL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS1LBL1() {
        return txnmis1LBL1;
    }

    /**
     * Sets the value of the txnmis1LBL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS1LBL1(String value) {
        this.txnmis1LBL1 = value;
    }

    /**
     * Gets the value of the txnmis2LBL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS2LBL2() {
        return txnmis2LBL2;
    }

    /**
     * Sets the value of the txnmis2LBL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS2LBL2(String value) {
        this.txnmis2LBL2 = value;
    }

    /**
     * Gets the value of the txnmis3LBL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS3LBL3() {
        return txnmis3LBL3;
    }

    /**
     * Sets the value of the txnmis3LBL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS3LBL3(String value) {
        this.txnmis3LBL3 = value;
    }

    /**
     * Gets the value of the txnmis4LBL4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS4LBL4() {
        return txnmis4LBL4;
    }

    /**
     * Sets the value of the txnmis4LBL4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS4LBL4(String value) {
        this.txnmis4LBL4 = value;
    }

    /**
     * Gets the value of the txnmis5LBL5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS5LBL5() {
        return txnmis5LBL5;
    }

    /**
     * Sets the value of the txnmis5LBL5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS5LBL5(String value) {
        this.txnmis5LBL5 = value;
    }

    /**
     * Gets the value of the txnmis6LBL6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS6LBL6() {
        return txnmis6LBL6;
    }

    /**
     * Sets the value of the txnmis6LBL6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS6LBL6(String value) {
        this.txnmis6LBL6 = value;
    }

    /**
     * Gets the value of the txnmis7LBL7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS7LBL7() {
        return txnmis7LBL7;
    }

    /**
     * Sets the value of the txnmis7LBL7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS7LBL7(String value) {
        this.txnmis7LBL7 = value;
    }

    /**
     * Gets the value of the txnmis8LBL8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS8LBL8() {
        return txnmis8LBL8;
    }

    /**
     * Sets the value of the txnmis8LBL8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS8LBL8(String value) {
        this.txnmis8LBL8 = value;
    }

    /**
     * Gets the value of the txnmis9LBL9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS9LBL9() {
        return txnmis9LBL9;
    }

    /**
     * Sets the value of the txnmis9LBL9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS9LBL9(String value) {
        this.txnmis9LBL9 = value;
    }

    /**
     * Gets the value of the txnmis10LBL10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNMIS10LBL10() {
        return txnmis10LBL10;
    }

    /**
     * Sets the value of the txnmis10LBL10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNMIS10LBL10(String value) {
        this.txnmis10LBL10 = value;
    }

}
