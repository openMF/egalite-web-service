
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
 * <p>Java class for Disbursement-Full-Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Disbursement-Full-Type">
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
 *         &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="REMARKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAKERDTSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECHKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKERSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUTHSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BRNCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMTFINANCED" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AMOUNTDISBURSED" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
 *                   &lt;element name="EXTACNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                   &lt;element name="ORGEXCHRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
 *                   &lt;element name="REMARK2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="REMARK10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                   &lt;element name="INTRIMINST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRIMINST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRIMINST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRMDRY1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRMDRY2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRMDRY3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRMDRY4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INTRMDRY5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SNDRRCVRINFO6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PYMTDTLS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PYMTDTLS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PYMTDTLS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PYMTDTLS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINSTUTN2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINSTUTN3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINSTUTN4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINSTUTN5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRCUST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORDRINSTUTN5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ULTBENF1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ULTBENF2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ULTBENF3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ULTBENF4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ULTBENF5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINST1CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINST2CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINST3CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINST4CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BNFINST5CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TRNSTYP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="COVRREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CHRGDET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="OURCORRESP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RECVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ACCINST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ACCINST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ACCINST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ACCINST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ACCINST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RCVRCORRESP5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Udf-Others" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DESCCHAR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR25" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR26" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR27" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR31" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR32" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR33" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR34" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR35" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR36" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR37" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR38" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR39" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR40" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR41" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR42" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR43" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR44" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR45" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR46" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR47" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR48" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR49" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHAR50" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "Disbursement-Full-Type", propOrder = {
    "actno",
    "br",
    "compnm",
    "refno",
    "esn",
    "valdt",
    "executiondate",
    "ccy",
    "totamt",
    "remarks",
    "makerid",
    "makerdtstamp",
    "chechkerid",
    "txnstat",
    "checkerstamp",
    "authstat",
    "accnum",
    "brncd",
    "amtfinanced",
    "amountdisbursed",
    "dsbrDetail",
    "dsbrCharges",
    "dsbrChecklist",
    "dsbrRemarks",
    "dsbrUserdef",
    "dsbrAdvices",
    "dsbrSuppress",
    "dsbrSettlement",
    "udfOthers"
})
public class DisbursementFullType {

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
    @XmlElement(name = "CCY")
    protected String ccy;
    @XmlElement(name = "TOTAMT")
    protected BigDecimal totamt;
    @XmlElement(name = "REMARKS")
    protected String remarks;
    @XmlElement(name = "MAKERID")
    protected String makerid;
    @XmlElement(name = "MAKERDTSTAMP")
    protected String makerdtstamp;
    @XmlElement(name = "CHECHKERID")
    protected String chechkerid;
    @XmlElement(name = "TXNSTAT")
    protected String txnstat;
    @XmlElement(name = "CHECKERSTAMP")
    protected String checkerstamp;
    @XmlElement(name = "AUTHSTAT")
    protected String authstat;
    @XmlElement(name = "ACCNUM")
    protected String accnum;
    @XmlElement(name = "BRNCD")
    protected String brncd;
    @XmlElement(name = "AMTFINANCED")
    protected BigDecimal amtfinanced;
    @XmlElement(name = "AMOUNTDISBURSED")
    protected BigDecimal amountdisbursed;
    @XmlElement(name = "Dsbr-Detail")
    protected List<DisbursementFullType.DsbrDetail> dsbrDetail;
    @XmlElement(name = "Dsbr-Charges")
    protected List<DisbursementFullType.DsbrCharges> dsbrCharges;
    @XmlElement(name = "Dsbr-Checklist")
    protected List<DisbursementFullType.DsbrChecklist> dsbrChecklist;
    @XmlElement(name = "Dsbr-Remarks")
    protected DisbursementFullType.DsbrRemarks dsbrRemarks;
    @XmlElement(name = "Dsbr-Userdef")
    protected DisbursementFullType.DsbrUserdef dsbrUserdef;
    @XmlElement(name = "Dsbr-Advices")
    protected List<DisbursementFullType.DsbrAdvices> dsbrAdvices;
    @XmlElement(name = "Dsbr-Suppress")
    protected List<DisbursementFullType.DsbrSuppress> dsbrSuppress;
    @XmlElement(name = "Dsbr-Settlement")
    protected DisbursementFullType.DsbrSettlement dsbrSettlement;
    @XmlElement(name = "Udf-Others")
    protected DisbursementFullType.UdfOthers udfOthers;

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
     * Gets the value of the totamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOTAMT() {
        return totamt;
    }

    /**
     * Sets the value of the totamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOTAMT(BigDecimal value) {
        this.totamt = value;
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
     * Gets the value of the makerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAKERID() {
        return makerid;
    }

    /**
     * Sets the value of the makerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAKERID(String value) {
        this.makerid = value;
    }

    /**
     * Gets the value of the makerdtstamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAKERDTSTAMP() {
        return makerdtstamp;
    }

    /**
     * Sets the value of the makerdtstamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAKERDTSTAMP(String value) {
        this.makerdtstamp = value;
    }

    /**
     * Gets the value of the chechkerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECHKERID() {
        return chechkerid;
    }

    /**
     * Sets the value of the chechkerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECHKERID(String value) {
        this.chechkerid = value;
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
     * Gets the value of the checkerstamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECKERSTAMP() {
        return checkerstamp;
    }

    /**
     * Sets the value of the checkerstamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECKERSTAMP(String value) {
        this.checkerstamp = value;
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
     * Gets the value of the brncd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRNCD() {
        return brncd;
    }

    /**
     * Sets the value of the brncd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRNCD(String value) {
        this.brncd = value;
    }

    /**
     * Gets the value of the amtfinanced property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMTFINANCED() {
        return amtfinanced;
    }

    /**
     * Sets the value of the amtfinanced property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMTFINANCED(BigDecimal value) {
        this.amtfinanced = value;
    }

    /**
     * Gets the value of the amountdisbursed property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMOUNTDISBURSED() {
        return amountdisbursed;
    }

    /**
     * Sets the value of the amountdisbursed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMOUNTDISBURSED(BigDecimal value) {
        this.amountdisbursed = value;
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
     * {@link DisbursementFullType.DsbrDetail }
     * 
     * 
     */
    public List<DisbursementFullType.DsbrDetail> getDsbrDetail() {
        if (dsbrDetail == null) {
            dsbrDetail = new ArrayList<DisbursementFullType.DsbrDetail>();
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
     * {@link DisbursementFullType.DsbrCharges }
     * 
     * 
     */
    public List<DisbursementFullType.DsbrCharges> getDsbrCharges() {
        if (dsbrCharges == null) {
            dsbrCharges = new ArrayList<DisbursementFullType.DsbrCharges>();
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
     * {@link DisbursementFullType.DsbrChecklist }
     * 
     * 
     */
    public List<DisbursementFullType.DsbrChecklist> getDsbrChecklist() {
        if (dsbrChecklist == null) {
            dsbrChecklist = new ArrayList<DisbursementFullType.DsbrChecklist>();
        }
        return this.dsbrChecklist;
    }

    /**
     * Gets the value of the dsbrRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementFullType.DsbrRemarks }
     *     
     */
    public DisbursementFullType.DsbrRemarks getDsbrRemarks() {
        return dsbrRemarks;
    }

    /**
     * Sets the value of the dsbrRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementFullType.DsbrRemarks }
     *     
     */
    public void setDsbrRemarks(DisbursementFullType.DsbrRemarks value) {
        this.dsbrRemarks = value;
    }

    /**
     * Gets the value of the dsbrUserdef property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementFullType.DsbrUserdef }
     *     
     */
    public DisbursementFullType.DsbrUserdef getDsbrUserdef() {
        return dsbrUserdef;
    }

    /**
     * Sets the value of the dsbrUserdef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementFullType.DsbrUserdef }
     *     
     */
    public void setDsbrUserdef(DisbursementFullType.DsbrUserdef value) {
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
     * {@link DisbursementFullType.DsbrAdvices }
     * 
     * 
     */
    public List<DisbursementFullType.DsbrAdvices> getDsbrAdvices() {
        if (dsbrAdvices == null) {
            dsbrAdvices = new ArrayList<DisbursementFullType.DsbrAdvices>();
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
     * {@link DisbursementFullType.DsbrSuppress }
     * 
     * 
     */
    public List<DisbursementFullType.DsbrSuppress> getDsbrSuppress() {
        if (dsbrSuppress == null) {
            dsbrSuppress = new ArrayList<DisbursementFullType.DsbrSuppress>();
        }
        return this.dsbrSuppress;
    }

    /**
     * Gets the value of the dsbrSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementFullType.DsbrSettlement }
     *     
     */
    public DisbursementFullType.DsbrSettlement getDsbrSettlement() {
        return dsbrSettlement;
    }

    /**
     * Sets the value of the dsbrSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementFullType.DsbrSettlement }
     *     
     */
    public void setDsbrSettlement(DisbursementFullType.DsbrSettlement value) {
        this.dsbrSettlement = value;
    }

    /**
     * Gets the value of the udfOthers property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementFullType.UdfOthers }
     *     
     */
    public DisbursementFullType.UdfOthers getUdfOthers() {
        return udfOthers;
    }

    /**
     * Sets the value of the udfOthers property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementFullType.UdfOthers }
     *     
     */
    public void setUdfOthers(DisbursementFullType.UdfOthers value) {
        this.udfOthers = value;
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
     *         &lt;element name="EXTACNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
     *         &lt;element name="ORGEXCHRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "extacno",
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
        "orgexchrate",
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
        @XmlElement(name = "ORGEXCHRATE")
        protected BigDecimal orgexchrate;
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
         * Gets the value of the orgexchrate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getORGEXCHRATE() {
            return orgexchrate;
        }

        /**
         * Sets the value of the orgexchrate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setORGEXCHRATE(BigDecimal value) {
            this.orgexchrate = value;
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
     *         &lt;element name="REMARK2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="REMARK10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "remark1",
        "remark2",
        "remark3",
        "remark4",
        "remark5",
        "remark6",
        "remark7",
        "remark8",
        "remark9",
        "remark10"
    })
    public static class DsbrRemarks {

        @XmlElement(name = "REMARK1")
        protected String remark1;
        @XmlElement(name = "REMARK2")
        protected String remark2;
        @XmlElement(name = "REMARK3")
        protected String remark3;
        @XmlElement(name = "REMARK4")
        protected String remark4;
        @XmlElement(name = "REMARK5")
        protected String remark5;
        @XmlElement(name = "REMARK6")
        protected String remark6;
        @XmlElement(name = "REMARK7")
        protected String remark7;
        @XmlElement(name = "REMARK8")
        protected String remark8;
        @XmlElement(name = "REMARK9")
        protected String remark9;
        @XmlElement(name = "REMARK10")
        protected String remark10;

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

        /**
         * Gets the value of the remark2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK2() {
            return remark2;
        }

        /**
         * Sets the value of the remark2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK2(String value) {
            this.remark2 = value;
        }

        /**
         * Gets the value of the remark3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK3() {
            return remark3;
        }

        /**
         * Sets the value of the remark3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK3(String value) {
            this.remark3 = value;
        }

        /**
         * Gets the value of the remark4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK4() {
            return remark4;
        }

        /**
         * Sets the value of the remark4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK4(String value) {
            this.remark4 = value;
        }

        /**
         * Gets the value of the remark5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK5() {
            return remark5;
        }

        /**
         * Sets the value of the remark5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK5(String value) {
            this.remark5 = value;
        }

        /**
         * Gets the value of the remark6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK6() {
            return remark6;
        }

        /**
         * Sets the value of the remark6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK6(String value) {
            this.remark6 = value;
        }

        /**
         * Gets the value of the remark7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK7() {
            return remark7;
        }

        /**
         * Sets the value of the remark7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK7(String value) {
            this.remark7 = value;
        }

        /**
         * Gets the value of the remark8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK8() {
            return remark8;
        }

        /**
         * Sets the value of the remark8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK8(String value) {
            this.remark8 = value;
        }

        /**
         * Gets the value of the remark9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK9() {
            return remark9;
        }

        /**
         * Sets the value of the remark9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK9(String value) {
            this.remark9 = value;
        }

        /**
         * Gets the value of the remark10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARK10() {
            return remark10;
        }

        /**
         * Sets the value of the remark10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARK10(String value) {
            this.remark10 = value;
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
     *         &lt;element name="INTRIMINST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRIMINST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRIMINST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRMDRY1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRMDRY2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRMDRY3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRMDRY4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INTRMDRY5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SNDRRCVRINFO6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PYMTDTLS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PYMTDTLS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PYMTDTLS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PYMTDTLS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINSTUTN1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINSTUTN2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINSTUTN3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINSTUTN4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINSTUTN5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRCUST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORDRINSTUTN5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ULTBENF1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ULTBENF2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ULTBENF3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ULTBENF4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ULTBENF5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINST1CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINST2CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINST3CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINST4CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BNFINST5CVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TRNSTYP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="COVRREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CHRGDET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="OURCORRESP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RECVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RCVRCORRESP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RCVRCORRESP2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RCVRCORRESP3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RCVRCORRESP4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ACCINST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ACCINST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ACCINST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ACCINST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ACCINST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "intriminst3",
        "intriminst4",
        "intriminst5",
        "intrmdry1",
        "intrmdry2",
        "intrmdry3",
        "intrmdry4",
        "intrmdry5",
        "sndrrcvrinfo1",
        "sndrrcvrinfo2",
        "sndrrcvrinfo3",
        "sndrrcvrinfo4",
        "sndrrcvrinfo5",
        "sndrrcvrinfo6",
        "pymtdtls1",
        "pymtdtls2",
        "pymtdtls3",
        "pymtdtls4",
        "ordrinstutn1",
        "ordrinstutn2",
        "ordrinstutn3",
        "ordrinstutn4",
        "ordrcust1",
        "ordrcust2",
        "ordrcust3",
        "ordrcust4",
        "bnfinstutn1",
        "bnfinstutn2",
        "bnfinstutn3",
        "bnfinstutn4",
        "bnfinstutn5",
        "ordrcust5",
        "ordrinstutn5",
        "ultbenf1",
        "ultbenf2",
        "ultbenf3",
        "ultbenf4",
        "ultbenf5",
        "bnfinst1CVR",
        "bnfinst2CVR",
        "bnfinst3CVR",
        "bnfinst4CVR",
        "bnfinst5CVR",
        "trnstyp",
        "covrreq",
        "chrgdet",
        "ourcorresp",
        "recvr",
        "rcvrcorresp1",
        "rcvrcorresp2",
        "rcvrcorresp3",
        "rcvrcorresp4",
        "accinst1",
        "accinst2",
        "accinst3",
        "accinst4",
        "accinst5",
        "rcvrcorresp5"
    })
    public static class DsbrSettlement {

        @XmlElement(name = "INTRIMINST1")
        protected String intriminst1;
        @XmlElement(name = "INTRIMINST2")
        protected String intriminst2;
        @XmlElement(name = "INTRIMINST3")
        protected String intriminst3;
        @XmlElement(name = "INTRIMINST4")
        protected String intriminst4;
        @XmlElement(name = "INTRIMINST5")
        protected String intriminst5;
        @XmlElement(name = "INTRMDRY1")
        protected String intrmdry1;
        @XmlElement(name = "INTRMDRY2")
        protected String intrmdry2;
        @XmlElement(name = "INTRMDRY3")
        protected String intrmdry3;
        @XmlElement(name = "INTRMDRY4")
        protected String intrmdry4;
        @XmlElement(name = "INTRMDRY5")
        protected String intrmdry5;
        @XmlElement(name = "SNDRRCVRINFO1")
        protected String sndrrcvrinfo1;
        @XmlElement(name = "SNDRRCVRINFO2")
        protected String sndrrcvrinfo2;
        @XmlElement(name = "SNDRRCVRINFO3")
        protected String sndrrcvrinfo3;
        @XmlElement(name = "SNDRRCVRINFO4")
        protected String sndrrcvrinfo4;
        @XmlElement(name = "SNDRRCVRINFO5")
        protected String sndrrcvrinfo5;
        @XmlElement(name = "SNDRRCVRINFO6")
        protected String sndrrcvrinfo6;
        @XmlElement(name = "PYMTDTLS1")
        protected String pymtdtls1;
        @XmlElement(name = "PYMTDTLS2")
        protected String pymtdtls2;
        @XmlElement(name = "PYMTDTLS3")
        protected String pymtdtls3;
        @XmlElement(name = "PYMTDTLS4")
        protected String pymtdtls4;
        @XmlElement(name = "ORDRINSTUTN1")
        protected String ordrinstutn1;
        @XmlElement(name = "ORDRINSTUTN2")
        protected String ordrinstutn2;
        @XmlElement(name = "ORDRINSTUTN3")
        protected String ordrinstutn3;
        @XmlElement(name = "ORDRINSTUTN4")
        protected String ordrinstutn4;
        @XmlElement(name = "ORDRCUST1")
        protected String ordrcust1;
        @XmlElement(name = "ORDRCUST2")
        protected String ordrcust2;
        @XmlElement(name = "ORDRCUST3")
        protected String ordrcust3;
        @XmlElement(name = "ORDRCUST4")
        protected String ordrcust4;
        @XmlElement(name = "BNFINSTUTN1")
        protected String bnfinstutn1;
        @XmlElement(name = "BNFINSTUTN2")
        protected String bnfinstutn2;
        @XmlElement(name = "BNFINSTUTN3")
        protected String bnfinstutn3;
        @XmlElement(name = "BNFINSTUTN4")
        protected String bnfinstutn4;
        @XmlElement(name = "BNFINSTUTN5")
        protected String bnfinstutn5;
        @XmlElement(name = "ORDRCUST5")
        protected String ordrcust5;
        @XmlElement(name = "ORDRINSTUTN5")
        protected String ordrinstutn5;
        @XmlElement(name = "ULTBENF1")
        protected String ultbenf1;
        @XmlElement(name = "ULTBENF2")
        protected String ultbenf2;
        @XmlElement(name = "ULTBENF3")
        protected String ultbenf3;
        @XmlElement(name = "ULTBENF4")
        protected String ultbenf4;
        @XmlElement(name = "ULTBENF5")
        protected String ultbenf5;
        @XmlElement(name = "BNFINST1CVR")
        protected String bnfinst1CVR;
        @XmlElement(name = "BNFINST2CVR")
        protected String bnfinst2CVR;
        @XmlElement(name = "BNFINST3CVR")
        protected String bnfinst3CVR;
        @XmlElement(name = "BNFINST4CVR")
        protected String bnfinst4CVR;
        @XmlElement(name = "BNFINST5CVR")
        protected String bnfinst5CVR;
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
        @XmlElement(name = "RCVRCORRESP2")
        protected String rcvrcorresp2;
        @XmlElement(name = "RCVRCORRESP3")
        protected String rcvrcorresp3;
        @XmlElement(name = "RCVRCORRESP4")
        protected String rcvrcorresp4;
        @XmlElement(name = "ACCINST1")
        protected String accinst1;
        @XmlElement(name = "ACCINST2")
        protected String accinst2;
        @XmlElement(name = "ACCINST3")
        protected String accinst3;
        @XmlElement(name = "ACCINST4")
        protected String accinst4;
        @XmlElement(name = "ACCINST5")
        protected String accinst5;
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
         * Gets the value of the intriminst3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRIMINST3() {
            return intriminst3;
        }

        /**
         * Sets the value of the intriminst3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRIMINST3(String value) {
            this.intriminst3 = value;
        }

        /**
         * Gets the value of the intriminst4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRIMINST4() {
            return intriminst4;
        }

        /**
         * Sets the value of the intriminst4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRIMINST4(String value) {
            this.intriminst4 = value;
        }

        /**
         * Gets the value of the intriminst5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRIMINST5() {
            return intriminst5;
        }

        /**
         * Sets the value of the intriminst5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRIMINST5(String value) {
            this.intriminst5 = value;
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
         * Gets the value of the intrmdry2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRMDRY2() {
            return intrmdry2;
        }

        /**
         * Sets the value of the intrmdry2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRMDRY2(String value) {
            this.intrmdry2 = value;
        }

        /**
         * Gets the value of the intrmdry3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRMDRY3() {
            return intrmdry3;
        }

        /**
         * Sets the value of the intrmdry3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRMDRY3(String value) {
            this.intrmdry3 = value;
        }

        /**
         * Gets the value of the intrmdry4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRMDRY4() {
            return intrmdry4;
        }

        /**
         * Sets the value of the intrmdry4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRMDRY4(String value) {
            this.intrmdry4 = value;
        }

        /**
         * Gets the value of the intrmdry5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINTRMDRY5() {
            return intrmdry5;
        }

        /**
         * Sets the value of the intrmdry5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINTRMDRY5(String value) {
            this.intrmdry5 = value;
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
         * Gets the value of the sndrrcvrinfo3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSNDRRCVRINFO3() {
            return sndrrcvrinfo3;
        }

        /**
         * Sets the value of the sndrrcvrinfo3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSNDRRCVRINFO3(String value) {
            this.sndrrcvrinfo3 = value;
        }

        /**
         * Gets the value of the sndrrcvrinfo4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSNDRRCVRINFO4() {
            return sndrrcvrinfo4;
        }

        /**
         * Sets the value of the sndrrcvrinfo4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSNDRRCVRINFO4(String value) {
            this.sndrrcvrinfo4 = value;
        }

        /**
         * Gets the value of the sndrrcvrinfo5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSNDRRCVRINFO5() {
            return sndrrcvrinfo5;
        }

        /**
         * Sets the value of the sndrrcvrinfo5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSNDRRCVRINFO5(String value) {
            this.sndrrcvrinfo5 = value;
        }

        /**
         * Gets the value of the sndrrcvrinfo6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSNDRRCVRINFO6() {
            return sndrrcvrinfo6;
        }

        /**
         * Sets the value of the sndrrcvrinfo6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSNDRRCVRINFO6(String value) {
            this.sndrrcvrinfo6 = value;
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
         * Gets the value of the pymtdtls2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPYMTDTLS2() {
            return pymtdtls2;
        }

        /**
         * Sets the value of the pymtdtls2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPYMTDTLS2(String value) {
            this.pymtdtls2 = value;
        }

        /**
         * Gets the value of the pymtdtls3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPYMTDTLS3() {
            return pymtdtls3;
        }

        /**
         * Sets the value of the pymtdtls3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPYMTDTLS3(String value) {
            this.pymtdtls3 = value;
        }

        /**
         * Gets the value of the pymtdtls4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPYMTDTLS4() {
            return pymtdtls4;
        }

        /**
         * Sets the value of the pymtdtls4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPYMTDTLS4(String value) {
            this.pymtdtls4 = value;
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
         * Gets the value of the ordrinstutn2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRINSTUTN2() {
            return ordrinstutn2;
        }

        /**
         * Sets the value of the ordrinstutn2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRINSTUTN2(String value) {
            this.ordrinstutn2 = value;
        }

        /**
         * Gets the value of the ordrinstutn3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRINSTUTN3() {
            return ordrinstutn3;
        }

        /**
         * Sets the value of the ordrinstutn3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRINSTUTN3(String value) {
            this.ordrinstutn3 = value;
        }

        /**
         * Gets the value of the ordrinstutn4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRINSTUTN4() {
            return ordrinstutn4;
        }

        /**
         * Sets the value of the ordrinstutn4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRINSTUTN4(String value) {
            this.ordrinstutn4 = value;
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
         * Gets the value of the ordrcust2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRCUST2() {
            return ordrcust2;
        }

        /**
         * Sets the value of the ordrcust2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRCUST2(String value) {
            this.ordrcust2 = value;
        }

        /**
         * Gets the value of the ordrcust3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRCUST3() {
            return ordrcust3;
        }

        /**
         * Sets the value of the ordrcust3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRCUST3(String value) {
            this.ordrcust3 = value;
        }

        /**
         * Gets the value of the ordrcust4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDRCUST4() {
            return ordrcust4;
        }

        /**
         * Sets the value of the ordrcust4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDRCUST4(String value) {
            this.ordrcust4 = value;
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
         * Gets the value of the bnfinstutn2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINSTUTN2() {
            return bnfinstutn2;
        }

        /**
         * Sets the value of the bnfinstutn2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINSTUTN2(String value) {
            this.bnfinstutn2 = value;
        }

        /**
         * Gets the value of the bnfinstutn3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINSTUTN3() {
            return bnfinstutn3;
        }

        /**
         * Sets the value of the bnfinstutn3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINSTUTN3(String value) {
            this.bnfinstutn3 = value;
        }

        /**
         * Gets the value of the bnfinstutn4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINSTUTN4() {
            return bnfinstutn4;
        }

        /**
         * Sets the value of the bnfinstutn4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINSTUTN4(String value) {
            this.bnfinstutn4 = value;
        }

        /**
         * Gets the value of the bnfinstutn5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINSTUTN5() {
            return bnfinstutn5;
        }

        /**
         * Sets the value of the bnfinstutn5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINSTUTN5(String value) {
            this.bnfinstutn5 = value;
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
         * Gets the value of the ultbenf2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getULTBENF2() {
            return ultbenf2;
        }

        /**
         * Sets the value of the ultbenf2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setULTBENF2(String value) {
            this.ultbenf2 = value;
        }

        /**
         * Gets the value of the ultbenf3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getULTBENF3() {
            return ultbenf3;
        }

        /**
         * Sets the value of the ultbenf3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setULTBENF3(String value) {
            this.ultbenf3 = value;
        }

        /**
         * Gets the value of the ultbenf4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getULTBENF4() {
            return ultbenf4;
        }

        /**
         * Sets the value of the ultbenf4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setULTBENF4(String value) {
            this.ultbenf4 = value;
        }

        /**
         * Gets the value of the ultbenf5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getULTBENF5() {
            return ultbenf5;
        }

        /**
         * Sets the value of the ultbenf5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setULTBENF5(String value) {
            this.ultbenf5 = value;
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
         * Gets the value of the bnfinst2CVR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINST2CVR() {
            return bnfinst2CVR;
        }

        /**
         * Sets the value of the bnfinst2CVR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINST2CVR(String value) {
            this.bnfinst2CVR = value;
        }

        /**
         * Gets the value of the bnfinst3CVR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINST3CVR() {
            return bnfinst3CVR;
        }

        /**
         * Sets the value of the bnfinst3CVR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINST3CVR(String value) {
            this.bnfinst3CVR = value;
        }

        /**
         * Gets the value of the bnfinst4CVR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINST4CVR() {
            return bnfinst4CVR;
        }

        /**
         * Sets the value of the bnfinst4CVR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINST4CVR(String value) {
            this.bnfinst4CVR = value;
        }

        /**
         * Gets the value of the bnfinst5CVR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBNFINST5CVR() {
            return bnfinst5CVR;
        }

        /**
         * Sets the value of the bnfinst5CVR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBNFINST5CVR(String value) {
            this.bnfinst5CVR = value;
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
         * Gets the value of the rcvrcorresp2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRCVRCORRESP2() {
            return rcvrcorresp2;
        }

        /**
         * Sets the value of the rcvrcorresp2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRCVRCORRESP2(String value) {
            this.rcvrcorresp2 = value;
        }

        /**
         * Gets the value of the rcvrcorresp3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRCVRCORRESP3() {
            return rcvrcorresp3;
        }

        /**
         * Sets the value of the rcvrcorresp3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRCVRCORRESP3(String value) {
            this.rcvrcorresp3 = value;
        }

        /**
         * Gets the value of the rcvrcorresp4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRCVRCORRESP4() {
            return rcvrcorresp4;
        }

        /**
         * Sets the value of the rcvrcorresp4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRCVRCORRESP4(String value) {
            this.rcvrcorresp4 = value;
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
         * Gets the value of the accinst2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACCINST2() {
            return accinst2;
        }

        /**
         * Sets the value of the accinst2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCINST2(String value) {
            this.accinst2 = value;
        }

        /**
         * Gets the value of the accinst3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACCINST3() {
            return accinst3;
        }

        /**
         * Sets the value of the accinst3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCINST3(String value) {
            this.accinst3 = value;
        }

        /**
         * Gets the value of the accinst4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACCINST4() {
            return accinst4;
        }

        /**
         * Sets the value of the accinst4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCINST4(String value) {
            this.accinst4 = value;
        }

        /**
         * Gets the value of the accinst5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACCINST5() {
            return accinst5;
        }

        /**
         * Sets the value of the accinst5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCINST5(String value) {
            this.accinst5 = value;
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
     *         &lt;element name="DESCCHAR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR25" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR26" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR27" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR31" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR32" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR33" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR34" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR35" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR36" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR37" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR38" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR39" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR40" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR41" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR42" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR43" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR44" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR45" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR46" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR47" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR48" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR49" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHAR50" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "descchar1",
        "descchar2",
        "descchar3",
        "descchar4",
        "descchar5",
        "descchar6",
        "descchar7",
        "descchar8",
        "descchar9",
        "descchar10",
        "descchar11",
        "descchar12",
        "descchar13",
        "descchar14",
        "descchar15",
        "descchar16",
        "descchar17",
        "descchar18",
        "descchar19",
        "descchar20",
        "descchar21",
        "descchar22",
        "descchar23",
        "descchar24",
        "descchar25",
        "descchar26",
        "descchar27",
        "descchar28",
        "descchar29",
        "descchar30",
        "descchar31",
        "descchar32",
        "descchar33",
        "descchar34",
        "descchar35",
        "descchar36",
        "descchar37",
        "descchar38",
        "descchar39",
        "descchar40",
        "descchar41",
        "descchar42",
        "descchar43",
        "descchar44",
        "descchar45",
        "descchar46",
        "descchar47",
        "descchar48",
        "descchar49",
        "descchar50"
    })
    public static class UdfOthers {

        @XmlElement(name = "DESCCHAR1")
        protected String descchar1;
        @XmlElement(name = "DESCCHAR2")
        protected String descchar2;
        @XmlElement(name = "DESCCHAR3")
        protected String descchar3;
        @XmlElement(name = "DESCCHAR4")
        protected String descchar4;
        @XmlElement(name = "DESCCHAR5")
        protected String descchar5;
        @XmlElement(name = "DESCCHAR6")
        protected String descchar6;
        @XmlElement(name = "DESCCHAR7")
        protected String descchar7;
        @XmlElement(name = "DESCCHAR8")
        protected String descchar8;
        @XmlElement(name = "DESCCHAR9")
        protected String descchar9;
        @XmlElement(name = "DESCCHAR10")
        protected String descchar10;
        @XmlElement(name = "DESCCHAR11")
        protected String descchar11;
        @XmlElement(name = "DESCCHAR12")
        protected String descchar12;
        @XmlElement(name = "DESCCHAR13")
        protected String descchar13;
        @XmlElement(name = "DESCCHAR14")
        protected String descchar14;
        @XmlElement(name = "DESCCHAR15")
        protected String descchar15;
        @XmlElement(name = "DESCCHAR16")
        protected String descchar16;
        @XmlElement(name = "DESCCHAR17")
        protected String descchar17;
        @XmlElement(name = "DESCCHAR18")
        protected String descchar18;
        @XmlElement(name = "DESCCHAR19")
        protected String descchar19;
        @XmlElement(name = "DESCCHAR20")
        protected String descchar20;
        @XmlElement(name = "DESCCHAR21")
        protected String descchar21;
        @XmlElement(name = "DESCCHAR22")
        protected String descchar22;
        @XmlElement(name = "DESCCHAR23")
        protected String descchar23;
        @XmlElement(name = "DESCCHAR24")
        protected String descchar24;
        @XmlElement(name = "DESCCHAR25")
        protected String descchar25;
        @XmlElement(name = "DESCCHAR26")
        protected String descchar26;
        @XmlElement(name = "DESCCHAR27")
        protected String descchar27;
        @XmlElement(name = "DESCCHAR28")
        protected String descchar28;
        @XmlElement(name = "DESCCHAR29")
        protected String descchar29;
        @XmlElement(name = "DESCCHAR30")
        protected String descchar30;
        @XmlElement(name = "DESCCHAR31")
        protected String descchar31;
        @XmlElement(name = "DESCCHAR32")
        protected String descchar32;
        @XmlElement(name = "DESCCHAR33")
        protected String descchar33;
        @XmlElement(name = "DESCCHAR34")
        protected String descchar34;
        @XmlElement(name = "DESCCHAR35")
        protected String descchar35;
        @XmlElement(name = "DESCCHAR36")
        protected String descchar36;
        @XmlElement(name = "DESCCHAR37")
        protected String descchar37;
        @XmlElement(name = "DESCCHAR38")
        protected String descchar38;
        @XmlElement(name = "DESCCHAR39")
        protected String descchar39;
        @XmlElement(name = "DESCCHAR40")
        protected String descchar40;
        @XmlElement(name = "DESCCHAR41")
        protected String descchar41;
        @XmlElement(name = "DESCCHAR42")
        protected String descchar42;
        @XmlElement(name = "DESCCHAR43")
        protected String descchar43;
        @XmlElement(name = "DESCCHAR44")
        protected String descchar44;
        @XmlElement(name = "DESCCHAR45")
        protected String descchar45;
        @XmlElement(name = "DESCCHAR46")
        protected String descchar46;
        @XmlElement(name = "DESCCHAR47")
        protected String descchar47;
        @XmlElement(name = "DESCCHAR48")
        protected String descchar48;
        @XmlElement(name = "DESCCHAR49")
        protected String descchar49;
        @XmlElement(name = "DESCCHAR50")
        protected String descchar50;

        /**
         * Gets the value of the descchar1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR1() {
            return descchar1;
        }

        /**
         * Sets the value of the descchar1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR1(String value) {
            this.descchar1 = value;
        }

        /**
         * Gets the value of the descchar2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR2() {
            return descchar2;
        }

        /**
         * Sets the value of the descchar2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR2(String value) {
            this.descchar2 = value;
        }

        /**
         * Gets the value of the descchar3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR3() {
            return descchar3;
        }

        /**
         * Sets the value of the descchar3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR3(String value) {
            this.descchar3 = value;
        }

        /**
         * Gets the value of the descchar4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR4() {
            return descchar4;
        }

        /**
         * Sets the value of the descchar4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR4(String value) {
            this.descchar4 = value;
        }

        /**
         * Gets the value of the descchar5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR5() {
            return descchar5;
        }

        /**
         * Sets the value of the descchar5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR5(String value) {
            this.descchar5 = value;
        }

        /**
         * Gets the value of the descchar6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR6() {
            return descchar6;
        }

        /**
         * Sets the value of the descchar6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR6(String value) {
            this.descchar6 = value;
        }

        /**
         * Gets the value of the descchar7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR7() {
            return descchar7;
        }

        /**
         * Sets the value of the descchar7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR7(String value) {
            this.descchar7 = value;
        }

        /**
         * Gets the value of the descchar8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR8() {
            return descchar8;
        }

        /**
         * Sets the value of the descchar8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR8(String value) {
            this.descchar8 = value;
        }

        /**
         * Gets the value of the descchar9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR9() {
            return descchar9;
        }

        /**
         * Sets the value of the descchar9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR9(String value) {
            this.descchar9 = value;
        }

        /**
         * Gets the value of the descchar10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR10() {
            return descchar10;
        }

        /**
         * Sets the value of the descchar10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR10(String value) {
            this.descchar10 = value;
        }

        /**
         * Gets the value of the descchar11 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR11() {
            return descchar11;
        }

        /**
         * Sets the value of the descchar11 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR11(String value) {
            this.descchar11 = value;
        }

        /**
         * Gets the value of the descchar12 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR12() {
            return descchar12;
        }

        /**
         * Sets the value of the descchar12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR12(String value) {
            this.descchar12 = value;
        }

        /**
         * Gets the value of the descchar13 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR13() {
            return descchar13;
        }

        /**
         * Sets the value of the descchar13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR13(String value) {
            this.descchar13 = value;
        }

        /**
         * Gets the value of the descchar14 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR14() {
            return descchar14;
        }

        /**
         * Sets the value of the descchar14 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR14(String value) {
            this.descchar14 = value;
        }

        /**
         * Gets the value of the descchar15 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR15() {
            return descchar15;
        }

        /**
         * Sets the value of the descchar15 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR15(String value) {
            this.descchar15 = value;
        }

        /**
         * Gets the value of the descchar16 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR16() {
            return descchar16;
        }

        /**
         * Sets the value of the descchar16 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR16(String value) {
            this.descchar16 = value;
        }

        /**
         * Gets the value of the descchar17 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR17() {
            return descchar17;
        }

        /**
         * Sets the value of the descchar17 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR17(String value) {
            this.descchar17 = value;
        }

        /**
         * Gets the value of the descchar18 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR18() {
            return descchar18;
        }

        /**
         * Sets the value of the descchar18 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR18(String value) {
            this.descchar18 = value;
        }

        /**
         * Gets the value of the descchar19 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR19() {
            return descchar19;
        }

        /**
         * Sets the value of the descchar19 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR19(String value) {
            this.descchar19 = value;
        }

        /**
         * Gets the value of the descchar20 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR20() {
            return descchar20;
        }

        /**
         * Sets the value of the descchar20 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR20(String value) {
            this.descchar20 = value;
        }

        /**
         * Gets the value of the descchar21 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR21() {
            return descchar21;
        }

        /**
         * Sets the value of the descchar21 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR21(String value) {
            this.descchar21 = value;
        }

        /**
         * Gets the value of the descchar22 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR22() {
            return descchar22;
        }

        /**
         * Sets the value of the descchar22 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR22(String value) {
            this.descchar22 = value;
        }

        /**
         * Gets the value of the descchar23 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR23() {
            return descchar23;
        }

        /**
         * Sets the value of the descchar23 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR23(String value) {
            this.descchar23 = value;
        }

        /**
         * Gets the value of the descchar24 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR24() {
            return descchar24;
        }

        /**
         * Sets the value of the descchar24 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR24(String value) {
            this.descchar24 = value;
        }

        /**
         * Gets the value of the descchar25 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR25() {
            return descchar25;
        }

        /**
         * Sets the value of the descchar25 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR25(String value) {
            this.descchar25 = value;
        }

        /**
         * Gets the value of the descchar26 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR26() {
            return descchar26;
        }

        /**
         * Sets the value of the descchar26 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR26(String value) {
            this.descchar26 = value;
        }

        /**
         * Gets the value of the descchar27 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR27() {
            return descchar27;
        }

        /**
         * Sets the value of the descchar27 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR27(String value) {
            this.descchar27 = value;
        }

        /**
         * Gets the value of the descchar28 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR28() {
            return descchar28;
        }

        /**
         * Sets the value of the descchar28 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR28(String value) {
            this.descchar28 = value;
        }

        /**
         * Gets the value of the descchar29 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR29() {
            return descchar29;
        }

        /**
         * Sets the value of the descchar29 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR29(String value) {
            this.descchar29 = value;
        }

        /**
         * Gets the value of the descchar30 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR30() {
            return descchar30;
        }

        /**
         * Sets the value of the descchar30 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR30(String value) {
            this.descchar30 = value;
        }

        /**
         * Gets the value of the descchar31 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR31() {
            return descchar31;
        }

        /**
         * Sets the value of the descchar31 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR31(String value) {
            this.descchar31 = value;
        }

        /**
         * Gets the value of the descchar32 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR32() {
            return descchar32;
        }

        /**
         * Sets the value of the descchar32 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR32(String value) {
            this.descchar32 = value;
        }

        /**
         * Gets the value of the descchar33 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR33() {
            return descchar33;
        }

        /**
         * Sets the value of the descchar33 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR33(String value) {
            this.descchar33 = value;
        }

        /**
         * Gets the value of the descchar34 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR34() {
            return descchar34;
        }

        /**
         * Sets the value of the descchar34 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR34(String value) {
            this.descchar34 = value;
        }

        /**
         * Gets the value of the descchar35 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR35() {
            return descchar35;
        }

        /**
         * Sets the value of the descchar35 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR35(String value) {
            this.descchar35 = value;
        }

        /**
         * Gets the value of the descchar36 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR36() {
            return descchar36;
        }

        /**
         * Sets the value of the descchar36 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR36(String value) {
            this.descchar36 = value;
        }

        /**
         * Gets the value of the descchar37 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR37() {
            return descchar37;
        }

        /**
         * Sets the value of the descchar37 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR37(String value) {
            this.descchar37 = value;
        }

        /**
         * Gets the value of the descchar38 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR38() {
            return descchar38;
        }

        /**
         * Sets the value of the descchar38 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR38(String value) {
            this.descchar38 = value;
        }

        /**
         * Gets the value of the descchar39 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR39() {
            return descchar39;
        }

        /**
         * Sets the value of the descchar39 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR39(String value) {
            this.descchar39 = value;
        }

        /**
         * Gets the value of the descchar40 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR40() {
            return descchar40;
        }

        /**
         * Sets the value of the descchar40 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR40(String value) {
            this.descchar40 = value;
        }

        /**
         * Gets the value of the descchar41 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR41() {
            return descchar41;
        }

        /**
         * Sets the value of the descchar41 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR41(String value) {
            this.descchar41 = value;
        }

        /**
         * Gets the value of the descchar42 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR42() {
            return descchar42;
        }

        /**
         * Sets the value of the descchar42 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR42(String value) {
            this.descchar42 = value;
        }

        /**
         * Gets the value of the descchar43 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR43() {
            return descchar43;
        }

        /**
         * Sets the value of the descchar43 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR43(String value) {
            this.descchar43 = value;
        }

        /**
         * Gets the value of the descchar44 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR44() {
            return descchar44;
        }

        /**
         * Sets the value of the descchar44 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR44(String value) {
            this.descchar44 = value;
        }

        /**
         * Gets the value of the descchar45 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR45() {
            return descchar45;
        }

        /**
         * Sets the value of the descchar45 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR45(String value) {
            this.descchar45 = value;
        }

        /**
         * Gets the value of the descchar46 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR46() {
            return descchar46;
        }

        /**
         * Sets the value of the descchar46 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR46(String value) {
            this.descchar46 = value;
        }

        /**
         * Gets the value of the descchar47 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR47() {
            return descchar47;
        }

        /**
         * Sets the value of the descchar47 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR47(String value) {
            this.descchar47 = value;
        }

        /**
         * Gets the value of the descchar48 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR48() {
            return descchar48;
        }

        /**
         * Sets the value of the descchar48 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR48(String value) {
            this.descchar48 = value;
        }

        /**
         * Gets the value of the descchar49 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR49() {
            return descchar49;
        }

        /**
         * Sets the value of the descchar49 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR49(String value) {
            this.descchar49 = value;
        }

        /**
         * Gets the value of the descchar50 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHAR50() {
            return descchar50;
        }

        /**
         * Sets the value of the descchar50 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHAR50(String value) {
            this.descchar50 = value;
        }

    }

}
