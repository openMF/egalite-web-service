
package com.ofss.fcubs.service.fcubsclservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Disbursement-Create-IO-Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Disbursement-Create-IO-Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACTNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COMPNM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ESN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VALDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EXECUTIONDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="REMARKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUTHSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dsbr-Detail" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="STTLMODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="STTLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SETTLEBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLPROD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EXTACNM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLRBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLRBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PRDCAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLGPRODDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ENDPNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RTNGNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SCTRCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="INSTRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REVERSED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLLCYEQ" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="EXCHRT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="UPLDSRC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NEGOREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NEGORATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Charges" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="STTLMODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SETTLEBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLPROD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EXTACNM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EXTACNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLRBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLRBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PRDCAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLGPRODDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ENDPNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RTNGNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SCTRCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CARDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="INSTRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STTLLCYEQ" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="EXCHRT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Checklist" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DESC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CHECKED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Remarks" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="REMARK1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Userdef" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FIELDCHAR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDCHAR20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER5" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER6" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER7" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER8" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER9" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER10" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER11" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER12" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER13" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER14" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER15" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER16" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER17" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER18" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER19" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDNUMBER20" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE1" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE2" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE3" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE5" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE6" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE7" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE8" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE9" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FIELDDATE10" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Advices" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SUPPRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PRIORITY" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FORMAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Suppress" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dsbr-Settlement" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INTRIMINST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRIMINST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRMDRY1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PYMTDTLS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ULTBENF1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINST1CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TRNSTYP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="COVRREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CHRGDET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="OURCORRESP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RECVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ACCINST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Disbursement-Create-IO-Type", propOrder = {
    "actno",
    "br",
    "compnm",
    "refno",
    "esn",
    "valdt",
    "executiondate",
    "remarks",
    "txnstat",
    "authstat",
    "accnum",
    "dsbrDetail",
    "dsbrCharges",
    "dsbrChecklist",
    "dsbrRemarks",
    "dsbrUserdef",
    "dsbrAdvices",
    "dsbrSuppress",
    "dsbrSettlement"
})
public class DisbursementCreateIOType {

    @XmlElement(name = "ACTNO", required = true)
    protected String actno;
    @XmlElement(name = "BR", required = true)
    protected String br;
    @XmlElement(name = "COMPNM")
    protected String compnm;
    @XmlElement(name = "REFNO")
    protected String refno;
    @XmlElement(name = "ESN", required = true)
    protected BigDecimal esn;
    @XmlElement(name = "VALDT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar valdt;
    @XmlElement(name = "EXECUTIONDATE")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar executiondate;
    @XmlElement(name = "REMARKS")
    protected String remarks;
    @XmlElement(name = "TXNSTAT")
    protected String txnstat;
    @XmlElement(name = "AUTHSTAT")
    protected String authstat;
    @XmlElement(name = "ACCNUM")
    protected String accnum;
    @XmlElement(name = "Dsbr-Detail")
    protected List<DisbursementCreateIOType.DsbrDetail> dsbrDetail;
    @XmlElement(name = "Dsbr-Charges")
    protected List<DisbursementCreateIOType.DsbrCharges> dsbrCharges;
    @XmlElement(name = "Dsbr-Checklist")
    protected List<DisbursementCreateIOType.DsbrChecklist> dsbrChecklist;
    @XmlElement(name = "Dsbr-Remarks")
    protected DisbursementCreateIOType.DsbrRemarks dsbrRemarks;
    @XmlElement(name = "Dsbr-Userdef")
    protected DisbursementCreateIOType.DsbrUserdef dsbrUserdef;
    @XmlElement(name = "Dsbr-Advices")
    protected List<DisbursementCreateIOType.DsbrAdvices> dsbrAdvices;
    @XmlElement(name = "Dsbr-Suppress")
    protected List<DisbursementCreateIOType.DsbrSuppress> dsbrSuppress;
    @XmlElement(name = "Dsbr-Settlement")
    protected DisbursementCreateIOType.DsbrSettlement dsbrSettlement;

    /**
     * Gets the value of the actno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTNO() {
        return actno;
    }

    /**
     * Sets the value of the actno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTNO(String value) {
        this.actno = value;
    }

    /**
     * Gets the value of the br property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBR() {
        return br;
    }

    /**
     * Sets the value of the br property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBR(String value) {
        this.br = value;
    }

    /**
     * Gets the value of the compnm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPNM() {
        return compnm;
    }

    /**
     * Sets the value of the compnm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPNM(String value) {
        this.compnm = value;
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
     * Gets the value of the esn property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getESN() {
        return esn;
    }

    /**
     * Sets the value of the esn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setESN(BigDecimal value) {
        this.esn = value;
    }

    /**
     * Gets the value of the valdt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVALDT() {
        return valdt;
    }

    /**
     * Sets the value of the valdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVALDT(XMLGregorianCalendar value) {
        this.valdt = value;
    }

    /**
     * Gets the value of the executiondate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEXECUTIONDATE() {
        return executiondate;
    }

    /**
     * Sets the value of the executiondate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEXECUTIONDATE(XMLGregorianCalendar value) {
        this.executiondate = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMARKS() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMARKS(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the txnstat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNSTAT() {
        return txnstat;
    }

    /**
     * Sets the value of the txnstat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNSTAT(String value) {
        this.txnstat = value;
    }

    /**
     * Gets the value of the authstat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHSTAT() {
        return authstat;
    }

    /**
     * Sets the value of the authstat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHSTAT(String value) {
        this.authstat = value;
    }

    /**
     * Gets the value of the accnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCNUM() {
        return accnum;
    }

    /**
     * Sets the value of the accnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCNUM(String value) {
        this.accnum = value;
    }

    /**
     * Gets the value of the dsbrDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dsbrDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDsbrDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisbursementCreateIOType.DsbrDetail }
     * 
     * 
     */
    public List<DisbursementCreateIOType.DsbrDetail> getDsbrDetail() {
        if (dsbrDetail == null) {
            dsbrDetail = new ArrayList<DisbursementCreateIOType.DsbrDetail>();
        }
        return this.dsbrDetail;
    }

    /**
     * Gets the value of the dsbrCharges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dsbrCharges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDsbrCharges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisbursementCreateIOType.DsbrCharges }
     * 
     * 
     */
    public List<DisbursementCreateIOType.DsbrCharges> getDsbrCharges() {
        if (dsbrCharges == null) {
            dsbrCharges = new ArrayList<DisbursementCreateIOType.DsbrCharges>();
        }
        return this.dsbrCharges;
    }

    /**
     * Gets the value of the dsbrChecklist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dsbrChecklist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDsbrChecklist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisbursementCreateIOType.DsbrChecklist }
     * 
     * 
     */
    public List<DisbursementCreateIOType.DsbrChecklist> getDsbrChecklist() {
        if (dsbrChecklist == null) {
            dsbrChecklist = new ArrayList<DisbursementCreateIOType.DsbrChecklist>();
        }
        return this.dsbrChecklist;
    }

    /**
     * Gets the value of the dsbrRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementCreateIOType.DsbrRemarks }
     *     
     */
    public DisbursementCreateIOType.DsbrRemarks getDsbrRemarks() {
        return dsbrRemarks;
    }

    /**
     * Sets the value of the dsbrRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementCreateIOType.DsbrRemarks }
     *     
     */
    public void setDsbrRemarks(DisbursementCreateIOType.DsbrRemarks value) {
        this.dsbrRemarks = value;
    }

    /**
     * Gets the value of the dsbrUserdef property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementCreateIOType.DsbrUserdef }
     *     
     */
    public DisbursementCreateIOType.DsbrUserdef getDsbrUserdef() {
        return dsbrUserdef;
    }

    /**
     * Sets the value of the dsbrUserdef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementCreateIOType.DsbrUserdef }
     *     
     */
    public void setDsbrUserdef(DisbursementCreateIOType.DsbrUserdef value) {
        this.dsbrUserdef = value;
    }

    /**
     * Gets the value of the dsbrAdvices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dsbrAdvices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDsbrAdvices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisbursementCreateIOType.DsbrAdvices }
     * 
     * 
     */
    public List<DisbursementCreateIOType.DsbrAdvices> getDsbrAdvices() {
        if (dsbrAdvices == null) {
            dsbrAdvices = new ArrayList<DisbursementCreateIOType.DsbrAdvices>();
        }
        return this.dsbrAdvices;
    }

    /**
     * Gets the value of the dsbrSuppress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dsbrSuppress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDsbrSuppress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisbursementCreateIOType.DsbrSuppress }
     * 
     * 
     */
    public List<DisbursementCreateIOType.DsbrSuppress> getDsbrSuppress() {
        if (dsbrSuppress == null) {
            dsbrSuppress = new ArrayList<DisbursementCreateIOType.DsbrSuppress>();
        }
        return this.dsbrSuppress;
    }

    /**
     * Gets the value of the dsbrSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementCreateIOType.DsbrSettlement }
     *     
     */
    public DisbursementCreateIOType.DsbrSettlement getDsbrSettlement() {
        return dsbrSettlement;
    }

    /**
     * Sets the value of the dsbrSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementCreateIOType.DsbrSettlement }
     *     
     */
    public void setDsbrSettlement(DisbursementCreateIOType.DsbrSettlement value) {
        this.dsbrSettlement = value;
    }


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
     *         &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SUPPRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PRIORITY" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FORMAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msgtype",
        "suppress",
        "priority",
        "format"
    })
    public static class DsbrAdvices {

        @XmlElement(name = "MSGTYPE", required = true)
        protected String msgtype;
        @XmlElement(name = "SUPPRESS")
        protected String suppress;
        @XmlElement(name = "PRIORITY")
        protected BigDecimal priority;
        @XmlElement(name = "FORMAT")
        protected String format;

        /**
         * Gets the value of the msgtype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMSGTYPE() {
            return msgtype;
        }

        /**
         * Sets the value of the msgtype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMSGTYPE(String value) {
            this.msgtype = value;
        }

        /**
         * Gets the value of the suppress property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSUPPRESS() {
            return suppress;
        }

        /**
         * Sets the value of the suppress property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSUPPRESS(String value) {
            this.suppress = value;
        }

        /**
         * Gets the value of the priority property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPRIORITY() {
            return priority;
        }

        /**
         * Sets the value of the priority property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPRIORITY(BigDecimal value) {
            this.priority = value;
        }

        /**
         * Gets the value of the format property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFORMAT() {
            return format;
        }

        /**
         * Sets the value of the format property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFORMAT(String value) {
            this.format = value;
        }

    }


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
     *         &lt;element name="STTLMODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SETTLEBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLPROD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EXTACNM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EXTACNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLRBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLRBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PRDCAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLGPRODDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ENDPNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RTNGNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SCTRCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CARDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="INSTRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLLCYEQ" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="EXCHRT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "sttlmode",
        "sttlccy",
        "settlebranch",
        "sttlacc",
        "sttlprod",
        "extacnm",
        "extacno",
        "clrbnk",
        "clrbrn",
        "prdcat",
        "clgproddr",
        "endpnt",
        "rtngno",
        "sctrcd",
        "cardno",
        "sttlamt",
        "instrno",
        "sttllcyeq",
        "exchrt",
        "compname"
    })
    public static class DsbrCharges {

        @XmlElement(name = "STTLMODE")
        protected String sttlmode;
        @XmlElement(name = "STTLCCY")
        protected String sttlccy;
        @XmlElement(name = "SETTLEBRANCH")
        protected String settlebranch;
        @XmlElement(name = "STTLACC")
        protected String sttlacc;
        @XmlElement(name = "STTLPROD")
        protected String sttlprod;
        @XmlElement(name = "EXTACNM")
        protected String extacnm;
        @XmlElement(name = "EXTACNO")
        protected String extacno;
        @XmlElement(name = "CLRBNK")
        protected String clrbnk;
        @XmlElement(name = "CLRBRN")
        protected String clrbrn;
        @XmlElement(name = "PRDCAT")
        protected String prdcat;
        @XmlElement(name = "CLGPRODDR")
        protected String clgproddr;
        @XmlElement(name = "ENDPNT")
        protected String endpnt;
        @XmlElement(name = "RTNGNO")
        protected String rtngno;
        @XmlElement(name = "SCTRCD")
        protected String sctrcd;
        @XmlElement(name = "CARDNO")
        protected String cardno;
        @XmlElement(name = "STTLAMT")
        protected BigDecimal sttlamt;
        @XmlElement(name = "INSTRNO")
        protected String instrno;
        @XmlElement(name = "STTLLCYEQ")
        protected BigDecimal sttllcyeq;
        @XmlElement(name = "EXCHRT")
        protected BigDecimal exchrt;
        @XmlElement(name = "COMPNAME")
        protected String compname;

        /**
         * Gets the value of the sttlmode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLMODE() {
            return sttlmode;
        }

        /**
         * Sets the value of the sttlmode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLMODE(String value) {
            this.sttlmode = value;
        }

        /**
         * Gets the value of the sttlccy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLCCY() {
            return sttlccy;
        }

        /**
         * Sets the value of the sttlccy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLCCY(String value) {
            this.sttlccy = value;
        }

        /**
         * Gets the value of the settlebranch property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSETTLEBRANCH() {
            return settlebranch;
        }

        /**
         * Sets the value of the settlebranch property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSETTLEBRANCH(String value) {
            this.settlebranch = value;
        }

        /**
         * Gets the value of the sttlacc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLACC() {
            return sttlacc;
        }

        /**
         * Sets the value of the sttlacc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLACC(String value) {
            this.sttlacc = value;
        }

        /**
         * Gets the value of the sttlprod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLPROD() {
            return sttlprod;
        }

        /**
         * Sets the value of the sttlprod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLPROD(String value) {
            this.sttlprod = value;
        }

        /**
         * Gets the value of the extacnm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEXTACNM() {
            return extacnm;
        }

        /**
         * Sets the value of the extacnm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEXTACNM(String value) {
            this.extacnm = value;
        }

        /**
         * Gets the value of the extacno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEXTACNO() {
            return extacno;
        }

        /**
         * Sets the value of the extacno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEXTACNO(String value) {
            this.extacno = value;
        }

        /**
         * Gets the value of the clrbnk property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLRBNK() {
            return clrbnk;
        }

        /**
         * Sets the value of the clrbnk property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLRBNK(String value) {
            this.clrbnk = value;
        }

        /**
         * Gets the value of the clrbrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLRBRN() {
            return clrbrn;
        }

        /**
         * Sets the value of the clrbrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLRBRN(String value) {
            this.clrbrn = value;
        }

        /**
         * Gets the value of the prdcat property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPRDCAT() {
            return prdcat;
        }

        /**
         * Sets the value of the prdcat property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPRDCAT(String value) {
            this.prdcat = value;
        }

        /**
         * Gets the value of the clgproddr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLGPRODDR() {
            return clgproddr;
        }

        /**
         * Sets the value of the clgproddr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLGPRODDR(String value) {
            this.clgproddr = value;
        }

        /**
         * Gets the value of the endpnt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getENDPNT() {
            return endpnt;
        }

        /**
         * Sets the value of the endpnt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setENDPNT(String value) {
            this.endpnt = value;
        }

        /**
         * Gets the value of the rtngno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRTNGNO() {
            return rtngno;
        }

        /**
         * Sets the value of the rtngno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRTNGNO(String value) {
            this.rtngno = value;
        }

        /**
         * Gets the value of the sctrcd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSCTRCD() {
            return sctrcd;
        }

        /**
         * Sets the value of the sctrcd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSCTRCD(String value) {
            this.sctrcd = value;
        }

        /**
         * Gets the value of the cardno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCARDNO() {
            return cardno;
        }

        /**
         * Sets the value of the cardno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCARDNO(String value) {
            this.cardno = value;
        }

        /**
         * Gets the value of the sttlamt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSTTLAMT() {
            return sttlamt;
        }

        /**
         * Sets the value of the sttlamt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSTTLAMT(BigDecimal value) {
            this.sttlamt = value;
        }

        /**
         * Gets the value of the instrno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINSTRNO() {
            return instrno;
        }

        /**
         * Sets the value of the instrno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINSTRNO(String value) {
            this.instrno = value;
        }

        /**
         * Gets the value of the sttllcyeq property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSTTLLCYEQ() {
            return sttllcyeq;
        }

        /**
         * Sets the value of the sttllcyeq property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSTTLLCYEQ(BigDecimal value) {
            this.sttllcyeq = value;
        }

        /**
         * Gets the value of the exchrt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getEXCHRT() {
            return exchrt;
        }

        /**
         * Sets the value of the exchrt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setEXCHRT(BigDecimal value) {
            this.exchrt = value;
        }

        /**
         * Gets the value of the compname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPNAME() {
            return compname;
        }

        /**
         * Sets the value of the compname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPNAME(String value) {
            this.compname = value;
        }

    }


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
     *         &lt;element name="DESC" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CHECKED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "desc",
        "checked"
    })
    public static class DsbrChecklist {

        @XmlElement(name = "DESC", required = true)
        protected String desc;
        @XmlElement(name = "CHECKED")
        protected String checked;

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESC() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESC(String value) {
            this.desc = value;
        }

        /**
         * Gets the value of the checked property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHECKED() {
            return checked;
        }

        /**
         * Sets the value of the checked property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHECKED(String value) {
            this.checked = value;
        }

    }


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
     *         &lt;element name="STTLMODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="STTLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SETTLEBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLPROD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EXTACNM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLRBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLRBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PRDCAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLGPRODDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ENDPNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RTNGNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SCTRCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="INSTRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REVERSED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STTLLCYEQ" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="EXCHRT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="UPLDSRC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NEGOREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NEGORATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "sttlmode",
        "sttlccy",
        "settlebranch",
        "sttlacc",
        "sttlprod",
        "extacnm",
        "clrbnk",
        "clrbrn",
        "prdcat",
        "clgproddr",
        "endpnt",
        "rtngno",
        "sctrcd",
        "sttlamt",
        "instrno",
        "reversed",
        "sttllcyeq",
        "exchrt",
        "upldsrc",
        "negorefno",
        "negorate"
    })
    public static class DsbrDetail {

        @XmlElement(name = "STTLMODE", required = true)
        protected String sttlmode;
        @XmlElement(name = "STTLCCY")
        protected String sttlccy;
        @XmlElement(name = "SETTLEBRANCH")
        protected String settlebranch;
        @XmlElement(name = "STTLACC")
        protected String sttlacc;
        @XmlElement(name = "STTLPROD")
        protected String sttlprod;
        @XmlElement(name = "EXTACNM")
        protected String extacnm;
        @XmlElement(name = "CLRBNK")
        protected String clrbnk;
        @XmlElement(name = "CLRBRN")
        protected String clrbrn;
        @XmlElement(name = "PRDCAT")
        protected String prdcat;
        @XmlElement(name = "CLGPRODDR")
        protected String clgproddr;
        @XmlElement(name = "ENDPNT")
        protected String endpnt;
        @XmlElement(name = "RTNGNO")
        protected String rtngno;
        @XmlElement(name = "SCTRCD")
        protected String sctrcd;
        @XmlElement(name = "STTLAMT")
        protected BigDecimal sttlamt;
        @XmlElement(name = "INSTRNO")
        protected String instrno;
        @XmlElement(name = "REVERSED")
        protected String reversed;
        @XmlElement(name = "STTLLCYEQ")
        protected BigDecimal sttllcyeq;
        @XmlElement(name = "EXCHRT")
        protected BigDecimal exchrt;
        @XmlElement(name = "UPLDSRC")
        protected String upldsrc;
        @XmlElement(name = "NEGOREFNO")
        protected String negorefno;
        @XmlElement(name = "NEGORATE")
        protected BigDecimal negorate;

        /**
         * Gets the value of the sttlmode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLMODE() {
            return sttlmode;
        }

        /**
         * Sets the value of the sttlmode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLMODE(String value) {
            this.sttlmode = value;
        }

        /**
         * Gets the value of the sttlccy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLCCY() {
            return sttlccy;
        }

        /**
         * Sets the value of the sttlccy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLCCY(String value) {
            this.sttlccy = value;
        }

        /**
         * Gets the value of the settlebranch property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSETTLEBRANCH() {
            return settlebranch;
        }

        /**
         * Sets the value of the settlebranch property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSETTLEBRANCH(String value) {
            this.settlebranch = value;
        }

        /**
         * Gets the value of the sttlacc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLACC() {
            return sttlacc;
        }

        /**
         * Sets the value of the sttlacc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLACC(String value) {
            this.sttlacc = value;
        }

        /**
         * Gets the value of the sttlprod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTTLPROD() {
            return sttlprod;
        }

        /**
         * Sets the value of the sttlprod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTTLPROD(String value) {
            this.sttlprod = value;
        }

        /**
         * Gets the value of the extacnm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEXTACNM() {
            return extacnm;
        }

        /**
         * Sets the value of the extacnm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEXTACNM(String value) {
            this.extacnm = value;
        }

        /**
         * Gets the value of the clrbnk property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLRBNK() {
            return clrbnk;
        }

        /**
         * Sets the value of the clrbnk property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLRBNK(String value) {
            this.clrbnk = value;
        }

        /**
         * Gets the value of the clrbrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLRBRN() {
            return clrbrn;
        }

        /**
         * Sets the value of the clrbrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLRBRN(String value) {
            this.clrbrn = value;
        }

        /**
         * Gets the value of the prdcat property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPRDCAT() {
            return prdcat;
        }

        /**
         * Sets the value of the prdcat property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPRDCAT(String value) {
            this.prdcat = value;
        }

        /**
         * Gets the value of the clgproddr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCLGPRODDR() {
            return clgproddr;
        }

        /**
         * Sets the value of the clgproddr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCLGPRODDR(String value) {
            this.clgproddr = value;
        }

        /**
         * Gets the value of the endpnt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getENDPNT() {
            return endpnt;
        }

        /**
         * Sets the value of the endpnt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setENDPNT(String value) {
            this.endpnt = value;
        }

        /**
         * Gets the value of the rtngno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRTNGNO() {
            return rtngno;
        }

        /**
         * Sets the value of the rtngno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRTNGNO(String value) {
            this.rtngno = value;
        }

        /**
         * Gets the value of the sctrcd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSCTRCD() {
            return sctrcd;
        }

        /**
         * Sets the value of the sctrcd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSCTRCD(String value) {
            this.sctrcd = value;
        }

        /**
         * Gets the value of the sttlamt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSTTLAMT() {
            return sttlamt;
        }

        /**
         * Sets the value of the sttlamt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSTTLAMT(BigDecimal value) {
            this.sttlamt = value;
        }

        /**
         * Gets the value of the instrno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINSTRNO() {
            return instrno;
        }

        /**
         * Sets the value of the instrno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINSTRNO(String value) {
            this.instrno = value;
        }

        /**
         * Gets the value of the reversed property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREVERSED() {
            return reversed;
        }

        /**
         * Sets the value of the reversed property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREVERSED(String value) {
            this.reversed = value;
        }

        /**
         * Gets the value of the sttllcyeq property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSTTLLCYEQ() {
            return sttllcyeq;
        }

        /**
         * Sets the value of the sttllcyeq property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSTTLLCYEQ(BigDecimal value) {
            this.sttllcyeq = value;
        }

        /**
         * Gets the value of the exchrt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getEXCHRT() {
            return exchrt;
        }

        /**
         * Sets the value of the exchrt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setEXCHRT(BigDecimal value) {
            this.exchrt = value;
        }

        /**
         * Gets the value of the upldsrc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUPLDSRC() {
            return upldsrc;
        }

        /**
         * Sets the value of the upldsrc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUPLDSRC(String value) {
            this.upldsrc = value;
        }

        /**
         * Gets the value of the negorefno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNEGOREFNO() {
            return negorefno;
        }

        /**
         * Sets the value of the negorefno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNEGOREFNO(String value) {
            this.negorefno = value;
        }

        /**
         * Gets the value of the negorate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getNEGORATE() {
            return negorate;
        }

        /**
         * Sets the value of the negorate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setNEGORATE(BigDecimal value) {
            this.negorate = value;
        }

    }


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
     *         &lt;element name="REMARK1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "remark1"
    })
    public static class DsbrRemarks {

        @XmlElement(name = "REMARK1")
        protected String remark1;

        /**
         * Gets the value of the remark1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK1() {
            return remark1;
        }

        /**
         * Sets the value of the remark1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK1(String value) {
            this.remark1 = value;
        }

    }


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
     *         &lt;element name="INTRIMINST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRIMINST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRMDRY1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PYMTDTLS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ULTBENF1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINST1CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TRNSTYP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="COVRREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CHRGDET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="OURCORRESP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RECVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RCVRCORRESP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ACCINST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RCVRCORRESP5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "intriminst1",
        "intriminst2",
        "intrmdry1",
        "sndrrcvrinfo1",
        "sndrrcvrinfo2",
        "pymtdtls1",
        "ordrinstutn1",
        "ordrcust1",
        "bnfinstutn1",
        "ordrcust5",
        "ordrinstutn5",
        "ultbenf1",
        "bnfinst1CVR",
        "trnstyp",
        "covrreq",
        "chrgdet",
        "ourcorresp",
        "recvr",
        "rcvrcorresp1",
        "accinst1",
        "rcvrcorresp5"
    })
    public static class DsbrSettlement {

        @XmlElement(name = "INTRIMINST1")
        protected String intriminst1;
        @XmlElement(name = "INTRIMINST2")
        protected String intriminst2;
        @XmlElement(name = "INTRMDRY1")
        protected String intrmdry1;
        @XmlElement(name = "SNDRRCVRINFO1")
        protected String sndrrcvrinfo1;
        @XmlElement(name = "SNDRRCVRINFO2")
        protected String sndrrcvrinfo2;
        @XmlElement(name = "PYMTDTLS1")
        protected String pymtdtls1;
        @XmlElement(name = "ORDRINSTUTN1")
        protected String ordrinstutn1;
        @XmlElement(name = "ORDRCUST1")
        protected String ordrcust1;
        @XmlElement(name = "BNFINSTUTN1")
        protected String bnfinstutn1;
        @XmlElement(name = "ORDRCUST5")
        protected String ordrcust5;
        @XmlElement(name = "ORDRINSTUTN5")
        protected String ordrinstutn5;
        @XmlElement(name = "ULTBENF1")
        protected String ultbenf1;
        @XmlElement(name = "BNFINST1CVR")
        protected String bnfinst1CVR;
        @XmlElement(name = "TRNSTYP")
        protected String trnstyp;
        @XmlElement(name = "COVRREQ")
        protected String covrreq;
        @XmlElement(name = "CHRGDET")
        protected String chrgdet;
        @XmlElement(name = "OURCORRESP")
        protected String ourcorresp;
        @XmlElement(name = "RECVR")
        protected String recvr;
        @XmlElement(name = "RCVRCORRESP1")
        protected String rcvrcorresp1;
        @XmlElement(name = "ACCINST1")
        protected String accinst1;
        @XmlElement(name = "RCVRCORRESP5")
        protected String rcvrcorresp5;

        /**
         * Gets the value of the intriminst1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRIMINST1() {
            return intriminst1;
        }

        /**
         * Sets the value of the intriminst1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRIMINST1(String value) {
            this.intriminst1 = value;
        }

        /**
         * Gets the value of the intriminst2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRIMINST2() {
            return intriminst2;
        }

        /**
         * Sets the value of the intriminst2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRIMINST2(String value) {
            this.intriminst2 = value;
        }

        /**
         * Gets the value of the intrmdry1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRMDRY1() {
            return intrmdry1;
        }

        /**
         * Sets the value of the intrmdry1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRMDRY1(String value) {
            this.intrmdry1 = value;
        }

        /**
         * Gets the value of the sndrrcvrinfo1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSNDRRCVRINFO1() {
            return sndrrcvrinfo1;
        }

        /**
         * Sets the value of the sndrrcvrinfo1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSNDRRCVRINFO1(String value) {
            this.sndrrcvrinfo1 = value;
        }

        /**
         * Gets the value of the sndrrcvrinfo2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSNDRRCVRINFO2() {
            return sndrrcvrinfo2;
        }

        /**
         * Sets the value of the sndrrcvrinfo2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSNDRRCVRINFO2(String value) {
            this.sndrrcvrinfo2 = value;
        }

        /**
         * Gets the value of the pymtdtls1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPYMTDTLS1() {
            return pymtdtls1;
        }

        /**
         * Sets the value of the pymtdtls1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPYMTDTLS1(String value) {
            this.pymtdtls1 = value;
        }

        /**
         * Gets the value of the ordrinstutn1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRINSTUTN1() {
            return ordrinstutn1;
        }

        /**
         * Sets the value of the ordrinstutn1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRINSTUTN1(String value) {
            this.ordrinstutn1 = value;
        }

        /**
         * Gets the value of the ordrcust1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRCUST1() {
            return ordrcust1;
        }

        /**
         * Sets the value of the ordrcust1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRCUST1(String value) {
            this.ordrcust1 = value;
        }

        /**
         * Gets the value of the bnfinstutn1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINSTUTN1() {
            return bnfinstutn1;
        }

        /**
         * Sets the value of the bnfinstutn1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINSTUTN1(String value) {
            this.bnfinstutn1 = value;
        }

        /**
         * Gets the value of the ordrcust5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRCUST5() {
            return ordrcust5;
        }

        /**
         * Sets the value of the ordrcust5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRCUST5(String value) {
            this.ordrcust5 = value;
        }

        /**
         * Gets the value of the ordrinstutn5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRINSTUTN5() {
            return ordrinstutn5;
        }

        /**
         * Sets the value of the ordrinstutn5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRINSTUTN5(String value) {
            this.ordrinstutn5 = value;
        }

        /**
         * Gets the value of the ultbenf1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getULTBENF1() {
            return ultbenf1;
        }

        /**
         * Sets the value of the ultbenf1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setULTBENF1(String value) {
            this.ultbenf1 = value;
        }

        /**
         * Gets the value of the bnfinst1CVR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINST1CVR() {
            return bnfinst1CVR;
        }

        /**
         * Sets the value of the bnfinst1CVR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINST1CVR(String value) {
            this.bnfinst1CVR = value;
        }

        /**
         * Gets the value of the trnstyp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTRNSTYP() {
            return trnstyp;
        }

        /**
         * Sets the value of the trnstyp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTRNSTYP(String value) {
            this.trnstyp = value;
        }

        /**
         * Gets the value of the covrreq property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOVRREQ() {
            return covrreq;
        }

        /**
         * Sets the value of the covrreq property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOVRREQ(String value) {
            this.covrreq = value;
        }

        /**
         * Gets the value of the chrgdet property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHRGDET() {
            return chrgdet;
        }

        /**
         * Sets the value of the chrgdet property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHRGDET(String value) {
            this.chrgdet = value;
        }

        /**
         * Gets the value of the ourcorresp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOURCORRESP() {
            return ourcorresp;
        }

        /**
         * Sets the value of the ourcorresp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOURCORRESP(String value) {
            this.ourcorresp = value;
        }

        /**
         * Gets the value of the recvr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECVR() {
            return recvr;
        }

        /**
         * Sets the value of the recvr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECVR(String value) {
            this.recvr = value;
        }

        /**
         * Gets the value of the rcvrcorresp1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRCVRCORRESP1() {
            return rcvrcorresp1;
        }

        /**
         * Sets the value of the rcvrcorresp1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRCVRCORRESP1(String value) {
            this.rcvrcorresp1 = value;
        }

        /**
         * Gets the value of the accinst1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACCINST1() {
            return accinst1;
        }

        /**
         * Sets the value of the accinst1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCINST1(String value) {
            this.accinst1 = value;
        }

        /**
         * Gets the value of the rcvrcorresp5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRCVRCORRESP5() {
            return rcvrcorresp5;
        }

        /**
         * Sets the value of the rcvrcorresp5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRCVRCORRESP5(String value) {
            this.rcvrcorresp5 = value;
        }

    }


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
     *         &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "msgtype"
    })
    public static class DsbrSuppress {

        @XmlElement(name = "MSGTYPE", required = true)
        protected String msgtype;

        /**
         * Gets the value of the msgtype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMSGTYPE() {
            return msgtype;
        }

        /**
         * Sets the value of the msgtype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMSGTYPE(String value) {
            this.msgtype = value;
        }

    }


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
     *         &lt;element name="FIELDCHAR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDCHAR20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER5" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER6" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER7" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER8" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER9" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER10" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER11" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER12" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER13" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER14" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER15" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER16" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER17" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER18" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER19" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDNUMBER20" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FIELDDATE1" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE2" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE3" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE5" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE6" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE7" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE8" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE9" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FIELDDATE10" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
        "fieldchar1",
        "fieldchar2",
        "fieldchar3",
        "fieldchar4",
        "fieldchar5",
        "fieldchar6",
        "fieldchar7",
        "fieldchar8",
        "fieldchar9",
        "fieldchar10",
        "fieldchar11",
        "fieldchar12",
        "fieldchar13",
        "fieldchar14",
        "fieldchar15",
        "fieldchar16",
        "fieldchar17",
        "fieldchar18",
        "fieldchar19",
        "fieldchar20",
        "fieldnumber1",
        "fieldnumber2",
        "fieldnumber3",
        "fieldnumber4",
        "fieldnumber5",
        "fieldnumber6",
        "fieldnumber7",
        "fieldnumber8",
        "fieldnumber9",
        "fieldnumber10",
        "fieldnumber11",
        "fieldnumber12",
        "fieldnumber13",
        "fieldnumber14",
        "fieldnumber15",
        "fieldnumber16",
        "fieldnumber17",
        "fieldnumber18",
        "fieldnumber19",
        "fieldnumber20",
        "fielddate1",
        "fielddate2",
        "fielddate3",
        "fielddate5",
        "fielddate6",
        "fielddate7",
        "fielddate8",
        "fielddate9",
        "fielddate10"
    })
    public static class DsbrUserdef {

        @XmlElement(name = "FIELDCHAR1")
        protected String fieldchar1;
        @XmlElement(name = "FIELDCHAR2")
        protected String fieldchar2;
        @XmlElement(name = "FIELDCHAR3")
        protected String fieldchar3;
        @XmlElement(name = "FIELDCHAR4")
        protected String fieldchar4;
        @XmlElement(name = "FIELDCHAR5")
        protected String fieldchar5;
        @XmlElement(name = "FIELDCHAR6")
        protected String fieldchar6;
        @XmlElement(name = "FIELDCHAR7")
        protected String fieldchar7;
        @XmlElement(name = "FIELDCHAR8")
        protected String fieldchar8;
        @XmlElement(name = "FIELDCHAR9")
        protected String fieldchar9;
        @XmlElement(name = "FIELDCHAR10")
        protected String fieldchar10;
        @XmlElement(name = "FIELDCHAR11")
        protected String fieldchar11;
        @XmlElement(name = "FIELDCHAR12")
        protected String fieldchar12;
        @XmlElement(name = "FIELDCHAR13")
        protected String fieldchar13;
        @XmlElement(name = "FIELDCHAR14")
        protected String fieldchar14;
        @XmlElement(name = "FIELDCHAR15")
        protected String fieldchar15;
        @XmlElement(name = "FIELDCHAR16")
        protected String fieldchar16;
        @XmlElement(name = "FIELDCHAR17")
        protected String fieldchar17;
        @XmlElement(name = "FIELDCHAR18")
        protected String fieldchar18;
        @XmlElement(name = "FIELDCHAR19")
        protected String fieldchar19;
        @XmlElement(name = "FIELDCHAR20")
        protected String fieldchar20;
        @XmlElement(name = "FIELDNUMBER1")
        protected BigDecimal fieldnumber1;
        @XmlElement(name = "FIELDNUMBER2")
        protected BigDecimal fieldnumber2;
        @XmlElement(name = "FIELDNUMBER3")
        protected BigDecimal fieldnumber3;
        @XmlElement(name = "FIELDNUMBER4")
        protected BigDecimal fieldnumber4;
        @XmlElement(name = "FIELDNUMBER5")
        protected BigDecimal fieldnumber5;
        @XmlElement(name = "FIELDNUMBER6")
        protected BigDecimal fieldnumber6;
        @XmlElement(name = "FIELDNUMBER7")
        protected BigDecimal fieldnumber7;
        @XmlElement(name = "FIELDNUMBER8")
        protected BigDecimal fieldnumber8;
        @XmlElement(name = "FIELDNUMBER9")
        protected BigDecimal fieldnumber9;
        @XmlElement(name = "FIELDNUMBER10")
        protected BigDecimal fieldnumber10;
        @XmlElement(name = "FIELDNUMBER11")
        protected BigDecimal fieldnumber11;
        @XmlElement(name = "FIELDNUMBER12")
        protected BigDecimal fieldnumber12;
        @XmlElement(name = "FIELDNUMBER13")
        protected BigDecimal fieldnumber13;
        @XmlElement(name = "FIELDNUMBER14")
        protected BigDecimal fieldnumber14;
        @XmlElement(name = "FIELDNUMBER15")
        protected BigDecimal fieldnumber15;
        @XmlElement(name = "FIELDNUMBER16")
        protected BigDecimal fieldnumber16;
        @XmlElement(name = "FIELDNUMBER17")
        protected BigDecimal fieldnumber17;
        @XmlElement(name = "FIELDNUMBER18")
        protected BigDecimal fieldnumber18;
        @XmlElement(name = "FIELDNUMBER19")
        protected BigDecimal fieldnumber19;
        @XmlElement(name = "FIELDNUMBER20")
        protected BigDecimal fieldnumber20;
        @XmlElement(name = "FIELDDATE1")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate1;
        @XmlElement(name = "FIELDDATE2")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate2;
        @XmlElement(name = "FIELDDATE3")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate3;
        @XmlElement(name = "FIELDDATE5")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate5;
        @XmlElement(name = "FIELDDATE6")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate6;
        @XmlElement(name = "FIELDDATE7")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate7;
        @XmlElement(name = "FIELDDATE8")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate8;
        @XmlElement(name = "FIELDDATE9")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate9;
        @XmlElement(name = "FIELDDATE10")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fielddate10;

        /**
         * Gets the value of the fieldchar1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR1() {
            return fieldchar1;
        }

        /**
         * Sets the value of the fieldchar1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR1(String value) {
            this.fieldchar1 = value;
        }

        /**
         * Gets the value of the fieldchar2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR2() {
            return fieldchar2;
        }

        /**
         * Sets the value of the fieldchar2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR2(String value) {
            this.fieldchar2 = value;
        }

        /**
         * Gets the value of the fieldchar3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR3() {
            return fieldchar3;
        }

        /**
         * Sets the value of the fieldchar3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR3(String value) {
            this.fieldchar3 = value;
        }

        /**
         * Gets the value of the fieldchar4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR4() {
            return fieldchar4;
        }

        /**
         * Sets the value of the fieldchar4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR4(String value) {
            this.fieldchar4 = value;
        }

        /**
         * Gets the value of the fieldchar5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR5() {
            return fieldchar5;
        }

        /**
         * Sets the value of the fieldchar5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR5(String value) {
            this.fieldchar5 = value;
        }

        /**
         * Gets the value of the fieldchar6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR6() {
            return fieldchar6;
        }

        /**
         * Sets the value of the fieldchar6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR6(String value) {
            this.fieldchar6 = value;
        }

        /**
         * Gets the value of the fieldchar7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR7() {
            return fieldchar7;
        }

        /**
         * Sets the value of the fieldchar7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR7(String value) {
            this.fieldchar7 = value;
        }

        /**
         * Gets the value of the fieldchar8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR8() {
            return fieldchar8;
        }

        /**
         * Sets the value of the fieldchar8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR8(String value) {
            this.fieldchar8 = value;
        }

        /**
         * Gets the value of the fieldchar9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR9() {
            return fieldchar9;
        }

        /**
         * Sets the value of the fieldchar9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR9(String value) {
            this.fieldchar9 = value;
        }

        /**
         * Gets the value of the fieldchar10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR10() {
            return fieldchar10;
        }

        /**
         * Sets the value of the fieldchar10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR10(String value) {
            this.fieldchar10 = value;
        }

        /**
         * Gets the value of the fieldchar11 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR11() {
            return fieldchar11;
        }

        /**
         * Sets the value of the fieldchar11 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR11(String value) {
            this.fieldchar11 = value;
        }

        /**
         * Gets the value of the fieldchar12 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR12() {
            return fieldchar12;
        }

        /**
         * Sets the value of the fieldchar12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR12(String value) {
            this.fieldchar12 = value;
        }

        /**
         * Gets the value of the fieldchar13 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR13() {
            return fieldchar13;
        }

        /**
         * Sets the value of the fieldchar13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR13(String value) {
            this.fieldchar13 = value;
        }

        /**
         * Gets the value of the fieldchar14 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR14() {
            return fieldchar14;
        }

        /**
         * Sets the value of the fieldchar14 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR14(String value) {
            this.fieldchar14 = value;
        }

        /**
         * Gets the value of the fieldchar15 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR15() {
            return fieldchar15;
        }

        /**
         * Sets the value of the fieldchar15 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR15(String value) {
            this.fieldchar15 = value;
        }

        /**
         * Gets the value of the fieldchar16 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR16() {
            return fieldchar16;
        }

        /**
         * Sets the value of the fieldchar16 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR16(String value) {
            this.fieldchar16 = value;
        }

        /**
         * Gets the value of the fieldchar17 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR17() {
            return fieldchar17;
        }

        /**
         * Sets the value of the fieldchar17 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR17(String value) {
            this.fieldchar17 = value;
        }

        /**
         * Gets the value of the fieldchar18 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR18() {
            return fieldchar18;
        }

        /**
         * Sets the value of the fieldchar18 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR18(String value) {
            this.fieldchar18 = value;
        }

        /**
         * Gets the value of the fieldchar19 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR19() {
            return fieldchar19;
        }

        /**
         * Sets the value of the fieldchar19 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR19(String value) {
            this.fieldchar19 = value;
        }

        /**
         * Gets the value of the fieldchar20 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIELDCHAR20() {
            return fieldchar20;
        }

        /**
         * Sets the value of the fieldchar20 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIELDCHAR20(String value) {
            this.fieldchar20 = value;
        }

        /**
         * Gets the value of the fieldnumber1 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER1() {
            return fieldnumber1;
        }

        /**
         * Sets the value of the fieldnumber1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER1(BigDecimal value) {
            this.fieldnumber1 = value;
        }

        /**
         * Gets the value of the fieldnumber2 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER2() {
            return fieldnumber2;
        }

        /**
         * Sets the value of the fieldnumber2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER2(BigDecimal value) {
            this.fieldnumber2 = value;
        }

        /**
         * Gets the value of the fieldnumber3 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER3() {
            return fieldnumber3;
        }

        /**
         * Sets the value of the fieldnumber3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER3(BigDecimal value) {
            this.fieldnumber3 = value;
        }

        /**
         * Gets the value of the fieldnumber4 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER4() {
            return fieldnumber4;
        }

        /**
         * Sets the value of the fieldnumber4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER4(BigDecimal value) {
            this.fieldnumber4 = value;
        }

        /**
         * Gets the value of the fieldnumber5 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER5() {
            return fieldnumber5;
        }

        /**
         * Sets the value of the fieldnumber5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER5(BigDecimal value) {
            this.fieldnumber5 = value;
        }

        /**
         * Gets the value of the fieldnumber6 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER6() {
            return fieldnumber6;
        }

        /**
         * Sets the value of the fieldnumber6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER6(BigDecimal value) {
            this.fieldnumber6 = value;
        }

        /**
         * Gets the value of the fieldnumber7 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER7() {
            return fieldnumber7;
        }

        /**
         * Sets the value of the fieldnumber7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER7(BigDecimal value) {
            this.fieldnumber7 = value;
        }

        /**
         * Gets the value of the fieldnumber8 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER8() {
            return fieldnumber8;
        }

        /**
         * Sets the value of the fieldnumber8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER8(BigDecimal value) {
            this.fieldnumber8 = value;
        }

        /**
         * Gets the value of the fieldnumber9 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER9() {
            return fieldnumber9;
        }

        /**
         * Sets the value of the fieldnumber9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER9(BigDecimal value) {
            this.fieldnumber9 = value;
        }

        /**
         * Gets the value of the fieldnumber10 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER10() {
            return fieldnumber10;
        }

        /**
         * Sets the value of the fieldnumber10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER10(BigDecimal value) {
            this.fieldnumber10 = value;
        }

        /**
         * Gets the value of the fieldnumber11 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER11() {
            return fieldnumber11;
        }

        /**
         * Sets the value of the fieldnumber11 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER11(BigDecimal value) {
            this.fieldnumber11 = value;
        }

        /**
         * Gets the value of the fieldnumber12 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER12() {
            return fieldnumber12;
        }

        /**
         * Sets the value of the fieldnumber12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER12(BigDecimal value) {
            this.fieldnumber12 = value;
        }

        /**
         * Gets the value of the fieldnumber13 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER13() {
            return fieldnumber13;
        }

        /**
         * Sets the value of the fieldnumber13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER13(BigDecimal value) {
            this.fieldnumber13 = value;
        }

        /**
         * Gets the value of the fieldnumber14 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER14() {
            return fieldnumber14;
        }

        /**
         * Sets the value of the fieldnumber14 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER14(BigDecimal value) {
            this.fieldnumber14 = value;
        }

        /**
         * Gets the value of the fieldnumber15 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER15() {
            return fieldnumber15;
        }

        /**
         * Sets the value of the fieldnumber15 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER15(BigDecimal value) {
            this.fieldnumber15 = value;
        }

        /**
         * Gets the value of the fieldnumber16 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER16() {
            return fieldnumber16;
        }

        /**
         * Sets the value of the fieldnumber16 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER16(BigDecimal value) {
            this.fieldnumber16 = value;
        }

        /**
         * Gets the value of the fieldnumber17 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER17() {
            return fieldnumber17;
        }

        /**
         * Sets the value of the fieldnumber17 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER17(BigDecimal value) {
            this.fieldnumber17 = value;
        }

        /**
         * Gets the value of the fieldnumber18 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER18() {
            return fieldnumber18;
        }

        /**
         * Sets the value of the fieldnumber18 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER18(BigDecimal value) {
            this.fieldnumber18 = value;
        }

        /**
         * Gets the value of the fieldnumber19 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER19() {
            return fieldnumber19;
        }

        /**
         * Sets the value of the fieldnumber19 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER19(BigDecimal value) {
            this.fieldnumber19 = value;
        }

        /**
         * Gets the value of the fieldnumber20 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFIELDNUMBER20() {
            return fieldnumber20;
        }

        /**
         * Sets the value of the fieldnumber20 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFIELDNUMBER20(BigDecimal value) {
            this.fieldnumber20 = value;
        }

        /**
         * Gets the value of the fielddate1 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE1() {
            return fielddate1;
        }

        /**
         * Sets the value of the fielddate1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE1(XMLGregorianCalendar value) {
            this.fielddate1 = value;
        }

        /**
         * Gets the value of the fielddate2 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE2() {
            return fielddate2;
        }

        /**
         * Sets the value of the fielddate2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE2(XMLGregorianCalendar value) {
            this.fielddate2 = value;
        }

        /**
         * Gets the value of the fielddate3 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE3() {
            return fielddate3;
        }

        /**
         * Sets the value of the fielddate3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE3(XMLGregorianCalendar value) {
            this.fielddate3 = value;
        }

        /**
         * Gets the value of the fielddate5 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE5() {
            return fielddate5;
        }

        /**
         * Sets the value of the fielddate5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE5(XMLGregorianCalendar value) {
            this.fielddate5 = value;
        }

        /**
         * Gets the value of the fielddate6 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE6() {
            return fielddate6;
        }

        /**
         * Sets the value of the fielddate6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE6(XMLGregorianCalendar value) {
            this.fielddate6 = value;
        }

        /**
         * Gets the value of the fielddate7 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE7() {
            return fielddate7;
        }

        /**
         * Sets the value of the fielddate7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE7(XMLGregorianCalendar value) {
            this.fielddate7 = value;
        }

        /**
         * Gets the value of the fielddate8 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE8() {
            return fielddate8;
        }

        /**
         * Sets the value of the fielddate8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE8(XMLGregorianCalendar value) {
            this.fielddate8 = value;
        }

        /**
         * Gets the value of the fielddate9 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE9() {
            return fielddate9;
        }

        /**
         * Sets the value of the fielddate9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE9(XMLGregorianCalendar value) {
            this.fielddate9 = value;
        }

        /**
         * Gets the value of the fielddate10 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFIELDDATE10() {
            return fielddate10;
        }

        /**
         * Sets the value of the fielddate10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFIELDDATE10(XMLGregorianCalendar value) {
            this.fielddate10 = value;
        }

    }

}
