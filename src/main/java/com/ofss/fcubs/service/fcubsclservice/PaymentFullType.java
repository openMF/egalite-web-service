
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
 * <p>Java class for Payment-Full-Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payment-Full-Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACCNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BRNCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ESN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VALDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EXECDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LMTDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CUSTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RSLVVAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="INSTPMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COLAGNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMTEXCESS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECOMPBAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECOMPFRM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAKERDTSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKERDTSTMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUTHSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLOSE_RVLNG_LOAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REVMAKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REVMAKERDTSTAMP" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="REVCHECKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REVCHECKERDTSTAMP" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TOTAL_PRIN_OUT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Settelments" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RVRSD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLMOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="LONCCYEQV" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="EXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="STLBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLPRD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INSTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ENDPNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CRDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EXTRACCNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EXTRACCNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLRBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CLRBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SECTORCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ROUTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ORGNLRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="NEGOTIATEDRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="NEGOTIATIONREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Compstld" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="COMOCCYEQV" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Compsummary" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CPMPCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AMTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="ADJAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="AMTOVRDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="AMTNTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="AMTWVD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="AMTCAP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="AMTPAID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Penalrates" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EFFDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="UDENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UDEVAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Chklist" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CHKED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Rmk" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RMK1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RMK10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Udffld" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DESCCHARFLD1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD27" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD31" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD32" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD33" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD34" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD35" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD36" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD38" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD39" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD40" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD41" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD42" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD43" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD45" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD46" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD47" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD48" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DESCCHARFLD49" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Udfval" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FLDCHAR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDCHAR20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FLDNUM1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM5" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM6" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM7" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM8" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM9" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM10" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM11" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM12" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM13" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM14" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM15" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM16" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM19" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDNUM20" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="FLDDT1" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT2" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT3" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT4" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT5" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT6" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT7" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT8" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FLDDT9" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Reverse" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RVRSD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLMOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="STLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Summary" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ACCNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BRNCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ESN" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="VALDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="EXECDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="AUTHSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RECMPBAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RECOMPFRM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="INSTPMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Total" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TOTAL_AMOUNT_DUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAL_ADJUSTED_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAMTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAL_AMTNOTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAL_AMTWVD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAL_AMTCAP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAL_AMTPAID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="TOTAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
@XmlType(name = "Payment-Full-Type", propOrder = {
    "accno",
    "brncode",
    "esn",
    "valdt",
    "execdt",
    "lmtdt",
    "custid",
    "rslvval",
    "instpmt",
    "colagnt",
    "amtexcess",
    "ccy",
    "recompbas",
    "recompfrm",
    "makerid",
    "makerdtstamp",
    "checkerid",
    "checkerdtstmp",
    "txnstat",
    "authstat",
    "closervlngloan",
    "revmakerid",
    "revmakerdtstamp",
    "revcheckerid",
    "revcheckerdtstamp",
    "totalprinout",
    "settelments",
    "compsummary",
    "penalrates",
    "chklist",
    "rmk",
    "udffld",
    "udfval",
    "reverse",
    "summary",
    "total"
})
public class PaymentFullType {

    @XmlElement(name = "ACCNO", required = true)
    protected String accno;
    @XmlElement(name = "BRNCODE", required = true)
    protected String brncode;
    @XmlElement(name = "ESN", required = true)
    protected BigDecimal esn;
    @XmlElement(name = "VALDT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar valdt;
    @XmlElement(name = "EXECDT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar execdt;
    @XmlElement(name = "LMTDT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lmtdt;
    @XmlElement(name = "CUSTID")
    protected String custid;
    @XmlElement(name = "RSLVVAL")
    protected BigDecimal rslvval;
    @XmlElement(name = "INSTPMT")
    protected String instpmt;
    @XmlElement(name = "COLAGNT")
    protected String colagnt;
    @XmlElement(name = "AMTEXCESS")
    protected BigDecimal amtexcess;
    @XmlElement(name = "CCY")
    protected String ccy;
    @XmlElement(name = "RECOMPBAS")
    protected String recompbas;
    @XmlElement(name = "RECOMPFRM")
    protected String recompfrm;
    @XmlElement(name = "MAKERID")
    protected String makerid;
    @XmlElement(name = "MAKERDTSTAMP")
    protected String makerdtstamp;
    @XmlElement(name = "CHECKERID")
    protected String checkerid;
    @XmlElement(name = "CHECKERDTSTMP")
    protected String checkerdtstmp;
    @XmlElement(name = "TXNSTAT")
    protected String txnstat;
    @XmlElement(name = "AUTHSTAT")
    protected String authstat;
    @XmlElement(name = "CLOSE_RVLNG_LOAN")
    protected String closervlngloan;
    @XmlElement(name = "REVMAKERID")
    protected String revmakerid;
    @XmlElement(name = "REVMAKERDTSTAMP")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar revmakerdtstamp;
    @XmlElement(name = "REVCHECKERID")
    protected String revcheckerid;
    @XmlElement(name = "REVCHECKERDTSTAMP")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar revcheckerdtstamp;
    @XmlElement(name = "TOTAL_PRIN_OUT")
    protected BigDecimal totalprinout;
    @XmlElement(name = "Settelments")
    protected List<PaymentFullType.Settelments> settelments;
    @XmlElement(name = "Compsummary")
    protected List<PaymentFullType.Compsummary> compsummary;
    @XmlElement(name = "Penalrates")
    protected List<PaymentFullType.Penalrates> penalrates;
    @XmlElement(name = "Chklist")
    protected List<PaymentFullType.Chklist> chklist;
    @XmlElement(name = "Rmk")
    protected List<PaymentFullType.Rmk> rmk;
    @XmlElement(name = "Udffld")
    protected PaymentFullType.Udffld udffld;
    @XmlElement(name = "Udfval")
    protected PaymentFullType.Udfval udfval;
    @XmlElement(name = "Reverse")
    protected List<PaymentFullType.Reverse> reverse;
    @XmlElement(name = "Summary")
    protected PaymentFullType.Summary summary;
    @XmlElement(name = "Total")
    protected List<PaymentFullType.Total> total;

    /**
     * Gets the value of the accno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCNO() {
        return accno;
    }

    /**
     * Sets the value of the accno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCNO(String value) {
        this.accno = value;
    }

    /**
     * Gets the value of the brncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRNCODE() {
        return brncode;
    }

    /**
     * Sets the value of the brncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRNCODE(String value) {
        this.brncode = value;
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
     * Gets the value of the execdt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEXECDT() {
        return execdt;
    }

    /**
     * Sets the value of the execdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEXECDT(XMLGregorianCalendar value) {
        this.execdt = value;
    }

    /**
     * Gets the value of the lmtdt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLMTDT() {
        return lmtdt;
    }

    /**
     * Sets the value of the lmtdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLMTDT(XMLGregorianCalendar value) {
        this.lmtdt = value;
    }

    /**
     * Gets the value of the custid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTID() {
        return custid;
    }

    /**
     * Sets the value of the custid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTID(String value) {
        this.custid = value;
    }

    /**
     * Gets the value of the rslvval property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRSLVVAL() {
        return rslvval;
    }

    /**
     * Sets the value of the rslvval property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRSLVVAL(BigDecimal value) {
        this.rslvval = value;
    }

    /**
     * Gets the value of the instpmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTPMT() {
        return instpmt;
    }

    /**
     * Sets the value of the instpmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTPMT(String value) {
        this.instpmt = value;
    }

    /**
     * Gets the value of the colagnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLAGNT() {
        return colagnt;
    }

    /**
     * Sets the value of the colagnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLAGNT(String value) {
        this.colagnt = value;
    }

    /**
     * Gets the value of the amtexcess property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMTEXCESS() {
        return amtexcess;
    }

    /**
     * Sets the value of the amtexcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMTEXCESS(BigDecimal value) {
        this.amtexcess = value;
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
     * Gets the value of the recompbas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECOMPBAS() {
        return recompbas;
    }

    /**
     * Sets the value of the recompbas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECOMPBAS(String value) {
        this.recompbas = value;
    }

    /**
     * Gets the value of the recompfrm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECOMPFRM() {
        return recompfrm;
    }

    /**
     * Sets the value of the recompfrm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECOMPFRM(String value) {
        this.recompfrm = value;
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
     * Gets the value of the checkerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECKERID() {
        return checkerid;
    }

    /**
     * Sets the value of the checkerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECKERID(String value) {
        this.checkerid = value;
    }

    /**
     * Gets the value of the checkerdtstmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECKERDTSTMP() {
        return checkerdtstmp;
    }

    /**
     * Sets the value of the checkerdtstmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECKERDTSTMP(String value) {
        this.checkerdtstmp = value;
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
     * Gets the value of the closervlngloan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLOSERVLNGLOAN() {
        return closervlngloan;
    }

    /**
     * Sets the value of the closervlngloan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLOSERVLNGLOAN(String value) {
        this.closervlngloan = value;
    }

    /**
     * Gets the value of the revmakerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREVMAKERID() {
        return revmakerid;
    }

    /**
     * Sets the value of the revmakerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREVMAKERID(String value) {
        this.revmakerid = value;
    }

    /**
     * Gets the value of the revmakerdtstamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getREVMAKERDTSTAMP() {
        return revmakerdtstamp;
    }

    /**
     * Sets the value of the revmakerdtstamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setREVMAKERDTSTAMP(XMLGregorianCalendar value) {
        this.revmakerdtstamp = value;
    }

    /**
     * Gets the value of the revcheckerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREVCHECKERID() {
        return revcheckerid;
    }

    /**
     * Sets the value of the revcheckerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREVCHECKERID(String value) {
        this.revcheckerid = value;
    }

    /**
     * Gets the value of the revcheckerdtstamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getREVCHECKERDTSTAMP() {
        return revcheckerdtstamp;
    }

    /**
     * Sets the value of the revcheckerdtstamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setREVCHECKERDTSTAMP(XMLGregorianCalendar value) {
        this.revcheckerdtstamp = value;
    }

    /**
     * Gets the value of the totalprinout property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOTALPRINOUT() {
        return totalprinout;
    }

    /**
     * Sets the value of the totalprinout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOTALPRINOUT(BigDecimal value) {
        this.totalprinout = value;
    }

    /**
     * Gets the value of the settelments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settelments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettelments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Settelments }
     * 
     * 
     */
    public List<PaymentFullType.Settelments> getSettelments() {
        if (settelments == null) {
            settelments = new ArrayList<PaymentFullType.Settelments>();
        }
        return this.settelments;
    }

    /**
     * Gets the value of the compsummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compsummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompsummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Compsummary }
     * 
     * 
     */
    public List<PaymentFullType.Compsummary> getCompsummary() {
        if (compsummary == null) {
            compsummary = new ArrayList<PaymentFullType.Compsummary>();
        }
        return this.compsummary;
    }

    /**
     * Gets the value of the penalrates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the penalrates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPenalrates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Penalrates }
     * 
     * 
     */
    public List<PaymentFullType.Penalrates> getPenalrates() {
        if (penalrates == null) {
            penalrates = new ArrayList<PaymentFullType.Penalrates>();
        }
        return this.penalrates;
    }

    /**
     * Gets the value of the chklist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chklist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChklist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Chklist }
     * 
     * 
     */
    public List<PaymentFullType.Chklist> getChklist() {
        if (chklist == null) {
            chklist = new ArrayList<PaymentFullType.Chklist>();
        }
        return this.chklist;
    }

    /**
     * Gets the value of the rmk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRmk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Rmk }
     * 
     * 
     */
    public List<PaymentFullType.Rmk> getRmk() {
        if (rmk == null) {
            rmk = new ArrayList<PaymentFullType.Rmk>();
        }
        return this.rmk;
    }

    /**
     * Gets the value of the udffld property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentFullType.Udffld }
     *     
     */
    public PaymentFullType.Udffld getUdffld() {
        return udffld;
    }

    /**
     * Sets the value of the udffld property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentFullType.Udffld }
     *     
     */
    public void setUdffld(PaymentFullType.Udffld value) {
        this.udffld = value;
    }

    /**
     * Gets the value of the udfval property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentFullType.Udfval }
     *     
     */
    public PaymentFullType.Udfval getUdfval() {
        return udfval;
    }

    /**
     * Sets the value of the udfval property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentFullType.Udfval }
     *     
     */
    public void setUdfval(PaymentFullType.Udfval value) {
        this.udfval = value;
    }

    /**
     * Gets the value of the reverse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reverse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReverse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Reverse }
     * 
     * 
     */
    public List<PaymentFullType.Reverse> getReverse() {
        if (reverse == null) {
            reverse = new ArrayList<PaymentFullType.Reverse>();
        }
        return this.reverse;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentFullType.Summary }
     *     
     */
    public PaymentFullType.Summary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentFullType.Summary }
     *     
     */
    public void setSummary(PaymentFullType.Summary value) {
        this.summary = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the total property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentFullType.Total }
     * 
     * 
     */
    public List<PaymentFullType.Total> getTotal() {
        if (total == null) {
            total = new ArrayList<PaymentFullType.Total>();
        }
        return this.total;
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
     *         &lt;element name="DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CHKED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "chked"
    })
    public static class Chklist {

        @XmlElement(name = "DESC")
        protected String desc;
        @XmlElement(name = "CHKED")
        protected String chked;

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
         * Gets the value of the chked property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHKED() {
            return chked;
        }

        /**
         * Sets the value of the chked property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHKED(String value) {
            this.chked = value;
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
     *         &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CPMPCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AMTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="ADJAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="AMTOVRDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="AMTNTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="AMTWVD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="AMTCAP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="AMTPAID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "compname",
        "cpmpccy",
        "amtdue",
        "adjamt",
        "amtovrdue",
        "amtntdue",
        "amtwvd",
        "amtcap",
        "amtpaid"
    })
    public static class Compsummary {

        @XmlElement(name = "COMPNAME")
        protected String compname;
        @XmlElement(name = "CPMPCCY")
        protected String cpmpccy;
        @XmlElement(name = "AMTDUE")
        protected BigDecimal amtdue;
        @XmlElement(name = "ADJAMT")
        protected BigDecimal adjamt;
        @XmlElement(name = "AMTOVRDUE")
        protected BigDecimal amtovrdue;
        @XmlElement(name = "AMTNTDUE")
        protected BigDecimal amtntdue;
        @XmlElement(name = "AMTWVD")
        protected BigDecimal amtwvd;
        @XmlElement(name = "AMTCAP")
        protected BigDecimal amtcap;
        @XmlElement(name = "AMTPAID")
        protected BigDecimal amtpaid;

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

        /**
         * Gets the value of the cpmpccy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCPMPCCY() {
            return cpmpccy;
        }

        /**
         * Sets the value of the cpmpccy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCPMPCCY(String value) {
            this.cpmpccy = value;
        }

        /**
         * Gets the value of the amtdue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAMTDUE() {
            return amtdue;
        }

        /**
         * Sets the value of the amtdue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAMTDUE(BigDecimal value) {
            this.amtdue = value;
        }

        /**
         * Gets the value of the adjamt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getADJAMT() {
            return adjamt;
        }

        /**
         * Sets the value of the adjamt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setADJAMT(BigDecimal value) {
            this.adjamt = value;
        }

        /**
         * Gets the value of the amtovrdue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAMTOVRDUE() {
            return amtovrdue;
        }

        /**
         * Sets the value of the amtovrdue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAMTOVRDUE(BigDecimal value) {
            this.amtovrdue = value;
        }

        /**
         * Gets the value of the amtntdue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAMTNTDUE() {
            return amtntdue;
        }

        /**
         * Sets the value of the amtntdue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAMTNTDUE(BigDecimal value) {
            this.amtntdue = value;
        }

        /**
         * Gets the value of the amtwvd property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAMTWVD() {
            return amtwvd;
        }

        /**
         * Sets the value of the amtwvd property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAMTWVD(BigDecimal value) {
            this.amtwvd = value;
        }

        /**
         * Gets the value of the amtcap property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAMTCAP() {
            return amtcap;
        }

        /**
         * Sets the value of the amtcap property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAMTCAP(BigDecimal value) {
            this.amtcap = value;
        }

        /**
         * Gets the value of the amtpaid property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAMTPAID() {
            return amtpaid;
        }

        /**
         * Sets the value of the amtpaid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAMTPAID(BigDecimal value) {
            this.amtpaid = value;
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
     *         &lt;element name="EFFDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="UDENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UDEVAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "effdt",
        "udename",
        "udeval"
    })
    public static class Penalrates {

        @XmlElement(name = "EFFDT")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effdt;
        @XmlElement(name = "UDENAME")
        protected String udename;
        @XmlElement(name = "UDEVAL")
        protected BigDecimal udeval;

        /**
         * Gets the value of the effdt property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEFFDT() {
            return effdt;
        }

        /**
         * Sets the value of the effdt property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEFFDT(XMLGregorianCalendar value) {
            this.effdt = value;
        }

        /**
         * Gets the value of the udename property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUDENAME() {
            return udename;
        }

        /**
         * Sets the value of the udename property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUDENAME(String value) {
            this.udename = value;
        }

        /**
         * Gets the value of the udeval property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUDEVAL() {
            return udeval;
        }

        /**
         * Sets the value of the udeval property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUDEVAL(BigDecimal value) {
            this.udeval = value;
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
     *         &lt;element name="RVRSD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLMOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "rvrsd",
        "stlmod",
        "stlccy",
        "stlamt"
    })
    public static class Reverse {

        @XmlElement(name = "RVRSD")
        protected String rvrsd;
        @XmlElement(name = "STLMOD")
        protected String stlmod;
        @XmlElement(name = "STLCCY")
        protected String stlccy;
        @XmlElement(name = "STLAMT")
        protected BigDecimal stlamt;

        /**
         * Gets the value of the rvrsd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRVRSD() {
            return rvrsd;
        }

        /**
         * Sets the value of the rvrsd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRVRSD(String value) {
            this.rvrsd = value;
        }

        /**
         * Gets the value of the stlmod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLMOD() {
            return stlmod;
        }

        /**
         * Sets the value of the stlmod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLMOD(String value) {
            this.stlmod = value;
        }

        /**
         * Gets the value of the stlccy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLCCY() {
            return stlccy;
        }

        /**
         * Sets the value of the stlccy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLCCY(String value) {
            this.stlccy = value;
        }

        /**
         * Gets the value of the stlamt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSTLAMT() {
            return stlamt;
        }

        /**
         * Sets the value of the stlamt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSTLAMT(BigDecimal value) {
            this.stlamt = value;
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
     *         &lt;element name="RMK1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RMK10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "rmk1",
        "rmk2",
        "rmk3",
        "rmk4",
        "rmk5",
        "rmk6",
        "rmk7",
        "rmk8",
        "rmk9",
        "rmk10"
    })
    public static class Rmk {

        @XmlElement(name = "RMK1")
        protected String rmk1;
        @XmlElement(name = "RMK2")
        protected String rmk2;
        @XmlElement(name = "RMK3")
        protected String rmk3;
        @XmlElement(name = "RMK4")
        protected String rmk4;
        @XmlElement(name = "RMK5")
        protected String rmk5;
        @XmlElement(name = "RMK6")
        protected String rmk6;
        @XmlElement(name = "RMK7")
        protected String rmk7;
        @XmlElement(name = "RMK8")
        protected String rmk8;
        @XmlElement(name = "RMK9")
        protected String rmk9;
        @XmlElement(name = "RMK10")
        protected String rmk10;

        /**
         * Gets the value of the rmk1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK1() {
            return rmk1;
        }

        /**
         * Sets the value of the rmk1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK1(String value) {
            this.rmk1 = value;
        }

        /**
         * Gets the value of the rmk2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK2() {
            return rmk2;
        }

        /**
         * Sets the value of the rmk2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK2(String value) {
            this.rmk2 = value;
        }

        /**
         * Gets the value of the rmk3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK3() {
            return rmk3;
        }

        /**
         * Sets the value of the rmk3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK3(String value) {
            this.rmk3 = value;
        }

        /**
         * Gets the value of the rmk4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK4() {
            return rmk4;
        }

        /**
         * Sets the value of the rmk4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK4(String value) {
            this.rmk4 = value;
        }

        /**
         * Gets the value of the rmk5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK5() {
            return rmk5;
        }

        /**
         * Sets the value of the rmk5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK5(String value) {
            this.rmk5 = value;
        }

        /**
         * Gets the value of the rmk6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK6() {
            return rmk6;
        }

        /**
         * Sets the value of the rmk6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK6(String value) {
            this.rmk6 = value;
        }

        /**
         * Gets the value of the rmk7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK7() {
            return rmk7;
        }

        /**
         * Sets the value of the rmk7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK7(String value) {
            this.rmk7 = value;
        }

        /**
         * Gets the value of the rmk8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK8() {
            return rmk8;
        }

        /**
         * Sets the value of the rmk8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK8(String value) {
            this.rmk8 = value;
        }

        /**
         * Gets the value of the rmk9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK9() {
            return rmk9;
        }

        /**
         * Sets the value of the rmk9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK9(String value) {
            this.rmk9 = value;
        }

        /**
         * Gets the value of the rmk10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRMK10() {
            return rmk10;
        }

        /**
         * Sets the value of the rmk10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRMK10(String value) {
            this.rmk10 = value;
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
     *         &lt;element name="RVRSD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLMOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="LONCCYEQV" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="EXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="STLBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLPRD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INSTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ENDPNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CRDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EXTRACCNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EXTRACCNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLRBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CLRBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SECTORCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ROUTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="STLREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ORGNLRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="NEGOTIATEDRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="NEGOTIATIONREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Compstld" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="COMOCCYEQV" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "rvrsd",
        "stlmod",
        "stlccy",
        "stlamt",
        "lonccyeqv",
        "exrate",
        "stlbrn",
        "stlacc",
        "stlprd",
        "instno",
        "endpnt",
        "crdno",
        "extraccno",
        "extraccname",
        "clrbnk",
        "clrbrn",
        "sectorcd",
        "routno",
        "stlrefno",
        "orgnlrate",
        "negotiatedrate",
        "negotiationrefno",
        "compstld"
    })
    public static class Settelments {

        @XmlElement(name = "RVRSD")
        protected String rvrsd;
        @XmlElement(name = "STLMOD")
        protected String stlmod;
        @XmlElement(name = "STLCCY")
        protected String stlccy;
        @XmlElement(name = "STLAMT")
        protected BigDecimal stlamt;
        @XmlElement(name = "LONCCYEQV")
        protected BigDecimal lonccyeqv;
        @XmlElement(name = "EXRATE")
        protected BigDecimal exrate;
        @XmlElement(name = "STLBRN")
        protected String stlbrn;
        @XmlElement(name = "STLACC")
        protected String stlacc;
        @XmlElement(name = "STLPRD")
        protected String stlprd;
        @XmlElement(name = "INSTNO")
        protected String instno;
        @XmlElement(name = "ENDPNT")
        protected String endpnt;
        @XmlElement(name = "CRDNO")
        protected String crdno;
        @XmlElement(name = "EXTRACCNO")
        protected String extraccno;
        @XmlElement(name = "EXTRACCNAME")
        protected String extraccname;
        @XmlElement(name = "CLRBNK")
        protected String clrbnk;
        @XmlElement(name = "CLRBRN")
        protected String clrbrn;
        @XmlElement(name = "SECTORCD")
        protected String sectorcd;
        @XmlElement(name = "ROUTNO")
        protected String routno;
        @XmlElement(name = "STLREFNO")
        protected String stlrefno;
        @XmlElement(name = "ORGNLRATE")
        protected BigDecimal orgnlrate;
        @XmlElement(name = "NEGOTIATEDRATE")
        protected BigDecimal negotiatedrate;
        @XmlElement(name = "NEGOTIATIONREFNO")
        protected String negotiationrefno;
        @XmlElement(name = "Compstld")
        protected List<PaymentFullType.Settelments.Compstld> compstld;

        /**
         * Gets the value of the rvrsd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRVRSD() {
            return rvrsd;
        }

        /**
         * Sets the value of the rvrsd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRVRSD(String value) {
            this.rvrsd = value;
        }

        /**
         * Gets the value of the stlmod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLMOD() {
            return stlmod;
        }

        /**
         * Sets the value of the stlmod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLMOD(String value) {
            this.stlmod = value;
        }

        /**
         * Gets the value of the stlccy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLCCY() {
            return stlccy;
        }

        /**
         * Sets the value of the stlccy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLCCY(String value) {
            this.stlccy = value;
        }

        /**
         * Gets the value of the stlamt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSTLAMT() {
            return stlamt;
        }

        /**
         * Sets the value of the stlamt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSTLAMT(BigDecimal value) {
            this.stlamt = value;
        }

        /**
         * Gets the value of the lonccyeqv property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLONCCYEQV() {
            return lonccyeqv;
        }

        /**
         * Sets the value of the lonccyeqv property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLONCCYEQV(BigDecimal value) {
            this.lonccyeqv = value;
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

        /**
         * Gets the value of the stlbrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLBRN() {
            return stlbrn;
        }

        /**
         * Sets the value of the stlbrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLBRN(String value) {
            this.stlbrn = value;
        }

        /**
         * Gets the value of the stlacc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLACC() {
            return stlacc;
        }

        /**
         * Sets the value of the stlacc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLACC(String value) {
            this.stlacc = value;
        }

        /**
         * Gets the value of the stlprd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLPRD() {
            return stlprd;
        }

        /**
         * Sets the value of the stlprd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLPRD(String value) {
            this.stlprd = value;
        }

        /**
         * Gets the value of the instno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINSTNO() {
            return instno;
        }

        /**
         * Sets the value of the instno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINSTNO(String value) {
            this.instno = value;
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
         * Gets the value of the crdno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCRDNO() {
            return crdno;
        }

        /**
         * Sets the value of the crdno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCRDNO(String value) {
            this.crdno = value;
        }

        /**
         * Gets the value of the extraccno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEXTRACCNO() {
            return extraccno;
        }

        /**
         * Sets the value of the extraccno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEXTRACCNO(String value) {
            this.extraccno = value;
        }

        /**
         * Gets the value of the extraccname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEXTRACCNAME() {
            return extraccname;
        }

        /**
         * Sets the value of the extraccname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEXTRACCNAME(String value) {
            this.extraccname = value;
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
         * Gets the value of the sectorcd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSECTORCD() {
            return sectorcd;
        }

        /**
         * Sets the value of the sectorcd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSECTORCD(String value) {
            this.sectorcd = value;
        }

        /**
         * Gets the value of the routno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getROUTNO() {
            return routno;
        }

        /**
         * Sets the value of the routno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setROUTNO(String value) {
            this.routno = value;
        }

        /**
         * Gets the value of the stlrefno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTLREFNO() {
            return stlrefno;
        }

        /**
         * Sets the value of the stlrefno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTLREFNO(String value) {
            this.stlrefno = value;
        }

        /**
         * Gets the value of the orgnlrate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getORGNLRATE() {
            return orgnlrate;
        }

        /**
         * Sets the value of the orgnlrate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setORGNLRATE(BigDecimal value) {
            this.orgnlrate = value;
        }

        /**
         * Gets the value of the negotiatedrate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getNEGOTIATEDRATE() {
            return negotiatedrate;
        }

        /**
         * Sets the value of the negotiatedrate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setNEGOTIATEDRATE(BigDecimal value) {
            this.negotiatedrate = value;
        }

        /**
         * Gets the value of the negotiationrefno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNEGOTIATIONREFNO() {
            return negotiationrefno;
        }

        /**
         * Sets the value of the negotiationrefno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNEGOTIATIONREFNO(String value) {
            this.negotiationrefno = value;
        }

        /**
         * Gets the value of the compstld property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the compstld property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCompstld().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PaymentFullType.Settelments.Compstld }
         * 
         * 
         */
        public List<PaymentFullType.Settelments.Compstld> getCompstld() {
            if (compstld == null) {
                compstld = new ArrayList<PaymentFullType.Settelments.Compstld>();
            }
            return this.compstld;
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
         *         &lt;element name="COMPNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="COMOCCYEQV" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
            "compname",
            "comoccyeqv"
        })
        public static class Compstld {

            @XmlElement(name = "COMPNAME")
            protected String compname;
            @XmlElement(name = "COMOCCYEQV")
            protected BigDecimal comoccyeqv;

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

            /**
             * Gets the value of the comoccyeqv property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getCOMOCCYEQV() {
                return comoccyeqv;
            }

            /**
             * Sets the value of the comoccyeqv property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setCOMOCCYEQV(BigDecimal value) {
                this.comoccyeqv = value;
            }

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
     *         &lt;element name="ACCNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BRNCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ESN" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="VALDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="EXECDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="AUTHSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RECMPBAS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RECOMPFRM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="INSTPMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="MOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "accno",
        "brncode",
        "esn",
        "valdt",
        "execdt",
        "authstat",
        "recmpbas",
        "recompfrm",
        "instpmt",
        "mod"
    })
    public static class Summary {

        @XmlElement(name = "ACCNO")
        protected String accno;
        @XmlElement(name = "BRNCODE")
        protected String brncode;
        @XmlElement(name = "ESN")
        protected BigDecimal esn;
        @XmlElement(name = "VALDT")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar valdt;
        @XmlElement(name = "EXECDT")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar execdt;
        @XmlElement(name = "AUTHSTAT")
        protected String authstat;
        @XmlElement(name = "RECMPBAS")
        protected String recmpbas;
        @XmlElement(name = "RECOMPFRM")
        protected String recompfrm;
        @XmlElement(name = "INSTPMT")
        protected String instpmt;
        @XmlElement(name = "MOD")
        protected String mod;

        /**
         * Gets the value of the accno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACCNO() {
            return accno;
        }

        /**
         * Sets the value of the accno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCNO(String value) {
            this.accno = value;
        }

        /**
         * Gets the value of the brncode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBRNCODE() {
            return brncode;
        }

        /**
         * Sets the value of the brncode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBRNCODE(String value) {
            this.brncode = value;
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
         * Gets the value of the execdt property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEXECDT() {
            return execdt;
        }

        /**
         * Sets the value of the execdt property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEXECDT(XMLGregorianCalendar value) {
            this.execdt = value;
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
         * Gets the value of the recmpbas property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECMPBAS() {
            return recmpbas;
        }

        /**
         * Sets the value of the recmpbas property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECMPBAS(String value) {
            this.recmpbas = value;
        }

        /**
         * Gets the value of the recompfrm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECOMPFRM() {
            return recompfrm;
        }

        /**
         * Sets the value of the recompfrm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECOMPFRM(String value) {
            this.recompfrm = value;
        }

        /**
         * Gets the value of the instpmt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINSTPMT() {
            return instpmt;
        }

        /**
         * Sets the value of the instpmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINSTPMT(String value) {
            this.instpmt = value;
        }

        /**
         * Gets the value of the mod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMOD() {
            return mod;
        }

        /**
         * Sets the value of the mod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMOD(String value) {
            this.mod = value;
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
     *         &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TOTAL_AMOUNT_DUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAL_ADJUSTED_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAMTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAL_AMTNOTDUE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAL_AMTWVD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAL_AMTCAP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAL_AMTPAID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="TOTAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "ccy",
        "totalamountdue",
        "totaladjustedamount",
        "totamtdue",
        "totalamtnotdue",
        "totalamtwvd",
        "totalamtcap",
        "totalamtpaid",
        "total"
    })
    public static class Total {

        @XmlElement(name = "CCY")
        protected String ccy;
        @XmlElement(name = "TOTAL_AMOUNT_DUE")
        protected BigDecimal totalamountdue;
        @XmlElement(name = "TOTAL_ADJUSTED_AMOUNT")
        protected BigDecimal totaladjustedamount;
        @XmlElement(name = "TOTAMTDUE")
        protected BigDecimal totamtdue;
        @XmlElement(name = "TOTAL_AMTNOTDUE")
        protected BigDecimal totalamtnotdue;
        @XmlElement(name = "TOTAL_AMTWVD")
        protected BigDecimal totalamtwvd;
        @XmlElement(name = "TOTAL_AMTCAP")
        protected BigDecimal totalamtcap;
        @XmlElement(name = "TOTAL_AMTPAID")
        protected BigDecimal totalamtpaid;
        @XmlElement(name = "TOTAL")
        protected BigDecimal total;

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
         * Gets the value of the totalamountdue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTALAMOUNTDUE() {
            return totalamountdue;
        }

        /**
         * Sets the value of the totalamountdue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTALAMOUNTDUE(BigDecimal value) {
            this.totalamountdue = value;
        }

        /**
         * Gets the value of the totaladjustedamount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTALADJUSTEDAMOUNT() {
            return totaladjustedamount;
        }

        /**
         * Sets the value of the totaladjustedamount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTALADJUSTEDAMOUNT(BigDecimal value) {
            this.totaladjustedamount = value;
        }

        /**
         * Gets the value of the totamtdue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTAMTDUE() {
            return totamtdue;
        }

        /**
         * Sets the value of the totamtdue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTAMTDUE(BigDecimal value) {
            this.totamtdue = value;
        }

        /**
         * Gets the value of the totalamtnotdue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTALAMTNOTDUE() {
            return totalamtnotdue;
        }

        /**
         * Sets the value of the totalamtnotdue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTALAMTNOTDUE(BigDecimal value) {
            this.totalamtnotdue = value;
        }

        /**
         * Gets the value of the totalamtwvd property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTALAMTWVD() {
            return totalamtwvd;
        }

        /**
         * Sets the value of the totalamtwvd property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTALAMTWVD(BigDecimal value) {
            this.totalamtwvd = value;
        }

        /**
         * Gets the value of the totalamtcap property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTALAMTCAP() {
            return totalamtcap;
        }

        /**
         * Sets the value of the totalamtcap property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTALAMTCAP(BigDecimal value) {
            this.totalamtcap = value;
        }

        /**
         * Gets the value of the totalamtpaid property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTALAMTPAID() {
            return totalamtpaid;
        }

        /**
         * Sets the value of the totalamtpaid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTALAMTPAID(BigDecimal value) {
            this.totalamtpaid = value;
        }

        /**
         * Gets the value of the total property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTOTAL() {
            return total;
        }

        /**
         * Sets the value of the total property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTOTAL(BigDecimal value) {
            this.total = value;
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
     *         &lt;element name="DESCCHARFLD1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD27" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD31" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD32" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD33" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD34" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD35" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD36" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD38" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD39" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD40" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD41" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD42" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD43" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD45" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD46" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD47" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD48" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DESCCHARFLD49" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "desccharfld1",
        "desccharfld2",
        "desccharfld3",
        "desccharfld4",
        "desccharfld5",
        "desccharfld6",
        "desccharfld7",
        "desccharfld8",
        "desccharfld9",
        "desccharfld10",
        "desccharfld11",
        "desccharfld12",
        "desccharfld13",
        "desccharfld14",
        "desccharfld15",
        "desccharfld16",
        "desccharfld17",
        "desccharfld18",
        "desccharfld19",
        "desccharfld20",
        "desccharfld21",
        "desccharfld22",
        "desccharfld23",
        "desccharfld24",
        "desccharfld27",
        "desccharfld28",
        "desccharfld29",
        "desccharfld30",
        "desccharfld31",
        "desccharfld32",
        "desccharfld33",
        "desccharfld34",
        "desccharfld35",
        "desccharfld36",
        "desccharfld38",
        "desccharfld39",
        "desccharfld40",
        "desccharfld41",
        "desccharfld42",
        "desccharfld43",
        "desccharfld45",
        "desccharfld46",
        "desccharfld47",
        "desccharfld48",
        "desccharfld49"
    })
    public static class Udffld {

        @XmlElement(name = "DESCCHARFLD1")
        protected String desccharfld1;
        @XmlElement(name = "DESCCHARFLD2")
        protected String desccharfld2;
        @XmlElement(name = "DESCCHARFLD3")
        protected String desccharfld3;
        @XmlElement(name = "DESCCHARFLD4")
        protected String desccharfld4;
        @XmlElement(name = "DESCCHARFLD5")
        protected String desccharfld5;
        @XmlElement(name = "DESCCHARFLD6")
        protected String desccharfld6;
        @XmlElement(name = "DESCCHARFLD7")
        protected String desccharfld7;
        @XmlElement(name = "DESCCHARFLD8")
        protected String desccharfld8;
        @XmlElement(name = "DESCCHARFLD9")
        protected String desccharfld9;
        @XmlElement(name = "DESCCHARFLD10")
        protected String desccharfld10;
        @XmlElement(name = "DESCCHARFLD11")
        protected String desccharfld11;
        @XmlElement(name = "DESCCHARFLD12")
        protected String desccharfld12;
        @XmlElement(name = "DESCCHARFLD13")
        protected String desccharfld13;
        @XmlElement(name = "DESCCHARFLD14")
        protected String desccharfld14;
        @XmlElement(name = "DESCCHARFLD15")
        protected String desccharfld15;
        @XmlElement(name = "DESCCHARFLD16")
        protected String desccharfld16;
        @XmlElement(name = "DESCCHARFLD17")
        protected String desccharfld17;
        @XmlElement(name = "DESCCHARFLD18")
        protected String desccharfld18;
        @XmlElement(name = "DESCCHARFLD19")
        protected String desccharfld19;
        @XmlElement(name = "DESCCHARFLD20")
        protected String desccharfld20;
        @XmlElement(name = "DESCCHARFLD21")
        protected String desccharfld21;
        @XmlElement(name = "DESCCHARFLD22")
        protected String desccharfld22;
        @XmlElement(name = "DESCCHARFLD23")
        protected String desccharfld23;
        @XmlElement(name = "DESCCHARFLD24")
        protected String desccharfld24;
        @XmlElement(name = "DESCCHARFLD27")
        protected String desccharfld27;
        @XmlElement(name = "DESCCHARFLD28")
        protected String desccharfld28;
        @XmlElement(name = "DESCCHARFLD29")
        protected String desccharfld29;
        @XmlElement(name = "DESCCHARFLD30")
        protected String desccharfld30;
        @XmlElement(name = "DESCCHARFLD31")
        protected String desccharfld31;
        @XmlElement(name = "DESCCHARFLD32")
        protected String desccharfld32;
        @XmlElement(name = "DESCCHARFLD33")
        protected String desccharfld33;
        @XmlElement(name = "DESCCHARFLD34")
        protected String desccharfld34;
        @XmlElement(name = "DESCCHARFLD35")
        protected String desccharfld35;
        @XmlElement(name = "DESCCHARFLD36")
        protected String desccharfld36;
        @XmlElement(name = "DESCCHARFLD38")
        protected String desccharfld38;
        @XmlElement(name = "DESCCHARFLD39")
        protected String desccharfld39;
        @XmlElement(name = "DESCCHARFLD40")
        protected String desccharfld40;
        @XmlElement(name = "DESCCHARFLD41")
        protected String desccharfld41;
        @XmlElement(name = "DESCCHARFLD42")
        protected String desccharfld42;
        @XmlElement(name = "DESCCHARFLD43")
        protected String desccharfld43;
        @XmlElement(name = "DESCCHARFLD45")
        protected String desccharfld45;
        @XmlElement(name = "DESCCHARFLD46")
        protected String desccharfld46;
        @XmlElement(name = "DESCCHARFLD47")
        protected String desccharfld47;
        @XmlElement(name = "DESCCHARFLD48")
        protected String desccharfld48;
        @XmlElement(name = "DESCCHARFLD49")
        protected String desccharfld49;

        /**
         * Gets the value of the desccharfld1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD1() {
            return desccharfld1;
        }

        /**
         * Sets the value of the desccharfld1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD1(String value) {
            this.desccharfld1 = value;
        }

        /**
         * Gets the value of the desccharfld2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD2() {
            return desccharfld2;
        }

        /**
         * Sets the value of the desccharfld2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD2(String value) {
            this.desccharfld2 = value;
        }

        /**
         * Gets the value of the desccharfld3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD3() {
            return desccharfld3;
        }

        /**
         * Sets the value of the desccharfld3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD3(String value) {
            this.desccharfld3 = value;
        }

        /**
         * Gets the value of the desccharfld4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD4() {
            return desccharfld4;
        }

        /**
         * Sets the value of the desccharfld4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD4(String value) {
            this.desccharfld4 = value;
        }

        /**
         * Gets the value of the desccharfld5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD5() {
            return desccharfld5;
        }

        /**
         * Sets the value of the desccharfld5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD5(String value) {
            this.desccharfld5 = value;
        }

        /**
         * Gets the value of the desccharfld6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD6() {
            return desccharfld6;
        }

        /**
         * Sets the value of the desccharfld6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD6(String value) {
            this.desccharfld6 = value;
        }

        /**
         * Gets the value of the desccharfld7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD7() {
            return desccharfld7;
        }

        /**
         * Sets the value of the desccharfld7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD7(String value) {
            this.desccharfld7 = value;
        }

        /**
         * Gets the value of the desccharfld8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD8() {
            return desccharfld8;
        }

        /**
         * Sets the value of the desccharfld8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD8(String value) {
            this.desccharfld8 = value;
        }

        /**
         * Gets the value of the desccharfld9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD9() {
            return desccharfld9;
        }

        /**
         * Sets the value of the desccharfld9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD9(String value) {
            this.desccharfld9 = value;
        }

        /**
         * Gets the value of the desccharfld10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD10() {
            return desccharfld10;
        }

        /**
         * Sets the value of the desccharfld10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD10(String value) {
            this.desccharfld10 = value;
        }

        /**
         * Gets the value of the desccharfld11 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD11() {
            return desccharfld11;
        }

        /**
         * Sets the value of the desccharfld11 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD11(String value) {
            this.desccharfld11 = value;
        }

        /**
         * Gets the value of the desccharfld12 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD12() {
            return desccharfld12;
        }

        /**
         * Sets the value of the desccharfld12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD12(String value) {
            this.desccharfld12 = value;
        }

        /**
         * Gets the value of the desccharfld13 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD13() {
            return desccharfld13;
        }

        /**
         * Sets the value of the desccharfld13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD13(String value) {
            this.desccharfld13 = value;
        }

        /**
         * Gets the value of the desccharfld14 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD14() {
            return desccharfld14;
        }

        /**
         * Sets the value of the desccharfld14 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD14(String value) {
            this.desccharfld14 = value;
        }

        /**
         * Gets the value of the desccharfld15 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD15() {
            return desccharfld15;
        }

        /**
         * Sets the value of the desccharfld15 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD15(String value) {
            this.desccharfld15 = value;
        }

        /**
         * Gets the value of the desccharfld16 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD16() {
            return desccharfld16;
        }

        /**
         * Sets the value of the desccharfld16 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD16(String value) {
            this.desccharfld16 = value;
        }

        /**
         * Gets the value of the desccharfld17 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD17() {
            return desccharfld17;
        }

        /**
         * Sets the value of the desccharfld17 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD17(String value) {
            this.desccharfld17 = value;
        }

        /**
         * Gets the value of the desccharfld18 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD18() {
            return desccharfld18;
        }

        /**
         * Sets the value of the desccharfld18 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD18(String value) {
            this.desccharfld18 = value;
        }

        /**
         * Gets the value of the desccharfld19 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD19() {
            return desccharfld19;
        }

        /**
         * Sets the value of the desccharfld19 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD19(String value) {
            this.desccharfld19 = value;
        }

        /**
         * Gets the value of the desccharfld20 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD20() {
            return desccharfld20;
        }

        /**
         * Sets the value of the desccharfld20 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD20(String value) {
            this.desccharfld20 = value;
        }

        /**
         * Gets the value of the desccharfld21 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD21() {
            return desccharfld21;
        }

        /**
         * Sets the value of the desccharfld21 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD21(String value) {
            this.desccharfld21 = value;
        }

        /**
         * Gets the value of the desccharfld22 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD22() {
            return desccharfld22;
        }

        /**
         * Sets the value of the desccharfld22 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD22(String value) {
            this.desccharfld22 = value;
        }

        /**
         * Gets the value of the desccharfld23 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD23() {
            return desccharfld23;
        }

        /**
         * Sets the value of the desccharfld23 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD23(String value) {
            this.desccharfld23 = value;
        }

        /**
         * Gets the value of the desccharfld24 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD24() {
            return desccharfld24;
        }

        /**
         * Sets the value of the desccharfld24 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD24(String value) {
            this.desccharfld24 = value;
        }

        /**
         * Gets the value of the desccharfld27 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD27() {
            return desccharfld27;
        }

        /**
         * Sets the value of the desccharfld27 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD27(String value) {
            this.desccharfld27 = value;
        }

        /**
         * Gets the value of the desccharfld28 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD28() {
            return desccharfld28;
        }

        /**
         * Sets the value of the desccharfld28 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD28(String value) {
            this.desccharfld28 = value;
        }

        /**
         * Gets the value of the desccharfld29 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD29() {
            return desccharfld29;
        }

        /**
         * Sets the value of the desccharfld29 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD29(String value) {
            this.desccharfld29 = value;
        }

        /**
         * Gets the value of the desccharfld30 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD30() {
            return desccharfld30;
        }

        /**
         * Sets the value of the desccharfld30 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD30(String value) {
            this.desccharfld30 = value;
        }

        /**
         * Gets the value of the desccharfld31 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD31() {
            return desccharfld31;
        }

        /**
         * Sets the value of the desccharfld31 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD31(String value) {
            this.desccharfld31 = value;
        }

        /**
         * Gets the value of the desccharfld32 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD32() {
            return desccharfld32;
        }

        /**
         * Sets the value of the desccharfld32 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD32(String value) {
            this.desccharfld32 = value;
        }

        /**
         * Gets the value of the desccharfld33 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD33() {
            return desccharfld33;
        }

        /**
         * Sets the value of the desccharfld33 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD33(String value) {
            this.desccharfld33 = value;
        }

        /**
         * Gets the value of the desccharfld34 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD34() {
            return desccharfld34;
        }

        /**
         * Sets the value of the desccharfld34 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD34(String value) {
            this.desccharfld34 = value;
        }

        /**
         * Gets the value of the desccharfld35 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD35() {
            return desccharfld35;
        }

        /**
         * Sets the value of the desccharfld35 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD35(String value) {
            this.desccharfld35 = value;
        }

        /**
         * Gets the value of the desccharfld36 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD36() {
            return desccharfld36;
        }

        /**
         * Sets the value of the desccharfld36 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD36(String value) {
            this.desccharfld36 = value;
        }

        /**
         * Gets the value of the desccharfld38 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD38() {
            return desccharfld38;
        }

        /**
         * Sets the value of the desccharfld38 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD38(String value) {
            this.desccharfld38 = value;
        }

        /**
         * Gets the value of the desccharfld39 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD39() {
            return desccharfld39;
        }

        /**
         * Sets the value of the desccharfld39 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD39(String value) {
            this.desccharfld39 = value;
        }

        /**
         * Gets the value of the desccharfld40 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD40() {
            return desccharfld40;
        }

        /**
         * Sets the value of the desccharfld40 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD40(String value) {
            this.desccharfld40 = value;
        }

        /**
         * Gets the value of the desccharfld41 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD41() {
            return desccharfld41;
        }

        /**
         * Sets the value of the desccharfld41 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD41(String value) {
            this.desccharfld41 = value;
        }

        /**
         * Gets the value of the desccharfld42 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD42() {
            return desccharfld42;
        }

        /**
         * Sets the value of the desccharfld42 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD42(String value) {
            this.desccharfld42 = value;
        }

        /**
         * Gets the value of the desccharfld43 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD43() {
            return desccharfld43;
        }

        /**
         * Sets the value of the desccharfld43 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD43(String value) {
            this.desccharfld43 = value;
        }

        /**
         * Gets the value of the desccharfld45 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD45() {
            return desccharfld45;
        }

        /**
         * Sets the value of the desccharfld45 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD45(String value) {
            this.desccharfld45 = value;
        }

        /**
         * Gets the value of the desccharfld46 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD46() {
            return desccharfld46;
        }

        /**
         * Sets the value of the desccharfld46 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD46(String value) {
            this.desccharfld46 = value;
        }

        /**
         * Gets the value of the desccharfld47 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD47() {
            return desccharfld47;
        }

        /**
         * Sets the value of the desccharfld47 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD47(String value) {
            this.desccharfld47 = value;
        }

        /**
         * Gets the value of the desccharfld48 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD48() {
            return desccharfld48;
        }

        /**
         * Sets the value of the desccharfld48 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD48(String value) {
            this.desccharfld48 = value;
        }

        /**
         * Gets the value of the desccharfld49 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCCHARFLD49() {
            return desccharfld49;
        }

        /**
         * Sets the value of the desccharfld49 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCCHARFLD49(String value) {
            this.desccharfld49 = value;
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
     *         &lt;element name="FLDCHAR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDCHAR20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="FLDNUM1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM5" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM6" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM7" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM8" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM9" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM10" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM11" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM12" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM13" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM14" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM15" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM16" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM19" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDNUM20" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="FLDDT1" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT2" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT3" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT4" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT5" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT6" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT7" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT8" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FLDDT9" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
        "fldchar1",
        "fldchar2",
        "fldchar3",
        "fldchar4",
        "fldchar5",
        "fldchar7",
        "fldchar8",
        "fldchar9",
        "fldchar10",
        "fldchar11",
        "fldchar12",
        "fldchar13",
        "fldchar14",
        "fldchar16",
        "fldchar17",
        "fldchar18",
        "fldchar19",
        "fldchar20",
        "fldnum1",
        "fldnum2",
        "fldnum3",
        "fldnum4",
        "fldnum5",
        "fldnum6",
        "fldnum7",
        "fldnum8",
        "fldnum9",
        "fldnum10",
        "fldnum11",
        "fldnum12",
        "fldnum13",
        "fldnum14",
        "fldnum15",
        "fldnum16",
        "fldnum19",
        "fldnum20",
        "flddt1",
        "flddt2",
        "flddt3",
        "flddt4",
        "flddt5",
        "flddt6",
        "flddt7",
        "flddt8",
        "flddt9"
    })
    public static class Udfval {

        @XmlElement(name = "FLDCHAR1")
        protected String fldchar1;
        @XmlElement(name = "FLDCHAR2")
        protected String fldchar2;
        @XmlElement(name = "FLDCHAR3")
        protected String fldchar3;
        @XmlElement(name = "FLDCHAR4")
        protected String fldchar4;
        @XmlElement(name = "FLDCHAR5")
        protected String fldchar5;
        @XmlElement(name = "FLDCHAR7")
        protected String fldchar7;
        @XmlElement(name = "FLDCHAR8")
        protected String fldchar8;
        @XmlElement(name = "FLDCHAR9")
        protected String fldchar9;
        @XmlElement(name = "FLDCHAR10")
        protected String fldchar10;
        @XmlElement(name = "FLDCHAR11")
        protected String fldchar11;
        @XmlElement(name = "FLDCHAR12")
        protected String fldchar12;
        @XmlElement(name = "FLDCHAR13")
        protected String fldchar13;
        @XmlElement(name = "FLDCHAR14")
        protected String fldchar14;
        @XmlElement(name = "FLDCHAR16")
        protected String fldchar16;
        @XmlElement(name = "FLDCHAR17")
        protected String fldchar17;
        @XmlElement(name = "FLDCHAR18")
        protected String fldchar18;
        @XmlElement(name = "FLDCHAR19")
        protected String fldchar19;
        @XmlElement(name = "FLDCHAR20")
        protected String fldchar20;
        @XmlElement(name = "FLDNUM1")
        protected BigDecimal fldnum1;
        @XmlElement(name = "FLDNUM2")
        protected BigDecimal fldnum2;
        @XmlElement(name = "FLDNUM3")
        protected BigDecimal fldnum3;
        @XmlElement(name = "FLDNUM4")
        protected BigDecimal fldnum4;
        @XmlElement(name = "FLDNUM5")
        protected BigDecimal fldnum5;
        @XmlElement(name = "FLDNUM6")
        protected BigDecimal fldnum6;
        @XmlElement(name = "FLDNUM7")
        protected BigDecimal fldnum7;
        @XmlElement(name = "FLDNUM8")
        protected BigDecimal fldnum8;
        @XmlElement(name = "FLDNUM9")
        protected BigDecimal fldnum9;
        @XmlElement(name = "FLDNUM10")
        protected BigDecimal fldnum10;
        @XmlElement(name = "FLDNUM11")
        protected BigDecimal fldnum11;
        @XmlElement(name = "FLDNUM12")
        protected BigDecimal fldnum12;
        @XmlElement(name = "FLDNUM13")
        protected BigDecimal fldnum13;
        @XmlElement(name = "FLDNUM14")
        protected BigDecimal fldnum14;
        @XmlElement(name = "FLDNUM15")
        protected BigDecimal fldnum15;
        @XmlElement(name = "FLDNUM16")
        protected BigDecimal fldnum16;
        @XmlElement(name = "FLDNUM19")
        protected BigDecimal fldnum19;
        @XmlElement(name = "FLDNUM20")
        protected BigDecimal fldnum20;
        @XmlElement(name = "FLDDT1")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt1;
        @XmlElement(name = "FLDDT2")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt2;
        @XmlElement(name = "FLDDT3")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt3;
        @XmlElement(name = "FLDDT4")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt4;
        @XmlElement(name = "FLDDT5")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt5;
        @XmlElement(name = "FLDDT6")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt6;
        @XmlElement(name = "FLDDT7")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt7;
        @XmlElement(name = "FLDDT8")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt8;
        @XmlElement(name = "FLDDT9")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar flddt9;

        /**
         * Gets the value of the fldchar1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR1() {
            return fldchar1;
        }

        /**
         * Sets the value of the fldchar1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR1(String value) {
            this.fldchar1 = value;
        }

        /**
         * Gets the value of the fldchar2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR2() {
            return fldchar2;
        }

        /**
         * Sets the value of the fldchar2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR2(String value) {
            this.fldchar2 = value;
        }

        /**
         * Gets the value of the fldchar3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR3() {
            return fldchar3;
        }

        /**
         * Sets the value of the fldchar3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR3(String value) {
            this.fldchar3 = value;
        }

        /**
         * Gets the value of the fldchar4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR4() {
            return fldchar4;
        }

        /**
         * Sets the value of the fldchar4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR4(String value) {
            this.fldchar4 = value;
        }

        /**
         * Gets the value of the fldchar5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR5() {
            return fldchar5;
        }

        /**
         * Sets the value of the fldchar5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR5(String value) {
            this.fldchar5 = value;
        }

        /**
         * Gets the value of the fldchar7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR7() {
            return fldchar7;
        }

        /**
         * Sets the value of the fldchar7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR7(String value) {
            this.fldchar7 = value;
        }

        /**
         * Gets the value of the fldchar8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR8() {
            return fldchar8;
        }

        /**
         * Sets the value of the fldchar8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR8(String value) {
            this.fldchar8 = value;
        }

        /**
         * Gets the value of the fldchar9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR9() {
            return fldchar9;
        }

        /**
         * Sets the value of the fldchar9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR9(String value) {
            this.fldchar9 = value;
        }

        /**
         * Gets the value of the fldchar10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR10() {
            return fldchar10;
        }

        /**
         * Sets the value of the fldchar10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR10(String value) {
            this.fldchar10 = value;
        }

        /**
         * Gets the value of the fldchar11 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR11() {
            return fldchar11;
        }

        /**
         * Sets the value of the fldchar11 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR11(String value) {
            this.fldchar11 = value;
        }

        /**
         * Gets the value of the fldchar12 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR12() {
            return fldchar12;
        }

        /**
         * Sets the value of the fldchar12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR12(String value) {
            this.fldchar12 = value;
        }

        /**
         * Gets the value of the fldchar13 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR13() {
            return fldchar13;
        }

        /**
         * Sets the value of the fldchar13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR13(String value) {
            this.fldchar13 = value;
        }

        /**
         * Gets the value of the fldchar14 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR14() {
            return fldchar14;
        }

        /**
         * Sets the value of the fldchar14 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR14(String value) {
            this.fldchar14 = value;
        }

        /**
         * Gets the value of the fldchar16 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR16() {
            return fldchar16;
        }

        /**
         * Sets the value of the fldchar16 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR16(String value) {
            this.fldchar16 = value;
        }

        /**
         * Gets the value of the fldchar17 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR17() {
            return fldchar17;
        }

        /**
         * Sets the value of the fldchar17 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR17(String value) {
            this.fldchar17 = value;
        }

        /**
         * Gets the value of the fldchar18 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR18() {
            return fldchar18;
        }

        /**
         * Sets the value of the fldchar18 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR18(String value) {
            this.fldchar18 = value;
        }

        /**
         * Gets the value of the fldchar19 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR19() {
            return fldchar19;
        }

        /**
         * Sets the value of the fldchar19 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR19(String value) {
            this.fldchar19 = value;
        }

        /**
         * Gets the value of the fldchar20 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFLDCHAR20() {
            return fldchar20;
        }

        /**
         * Sets the value of the fldchar20 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFLDCHAR20(String value) {
            this.fldchar20 = value;
        }

        /**
         * Gets the value of the fldnum1 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM1() {
            return fldnum1;
        }

        /**
         * Sets the value of the fldnum1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM1(BigDecimal value) {
            this.fldnum1 = value;
        }

        /**
         * Gets the value of the fldnum2 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM2() {
            return fldnum2;
        }

        /**
         * Sets the value of the fldnum2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM2(BigDecimal value) {
            this.fldnum2 = value;
        }

        /**
         * Gets the value of the fldnum3 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM3() {
            return fldnum3;
        }

        /**
         * Sets the value of the fldnum3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM3(BigDecimal value) {
            this.fldnum3 = value;
        }

        /**
         * Gets the value of the fldnum4 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM4() {
            return fldnum4;
        }

        /**
         * Sets the value of the fldnum4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM4(BigDecimal value) {
            this.fldnum4 = value;
        }

        /**
         * Gets the value of the fldnum5 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM5() {
            return fldnum5;
        }

        /**
         * Sets the value of the fldnum5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM5(BigDecimal value) {
            this.fldnum5 = value;
        }

        /**
         * Gets the value of the fldnum6 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM6() {
            return fldnum6;
        }

        /**
         * Sets the value of the fldnum6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM6(BigDecimal value) {
            this.fldnum6 = value;
        }

        /**
         * Gets the value of the fldnum7 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM7() {
            return fldnum7;
        }

        /**
         * Sets the value of the fldnum7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM7(BigDecimal value) {
            this.fldnum7 = value;
        }

        /**
         * Gets the value of the fldnum8 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM8() {
            return fldnum8;
        }

        /**
         * Sets the value of the fldnum8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM8(BigDecimal value) {
            this.fldnum8 = value;
        }

        /**
         * Gets the value of the fldnum9 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM9() {
            return fldnum9;
        }

        /**
         * Sets the value of the fldnum9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM9(BigDecimal value) {
            this.fldnum9 = value;
        }

        /**
         * Gets the value of the fldnum10 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM10() {
            return fldnum10;
        }

        /**
         * Sets the value of the fldnum10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM10(BigDecimal value) {
            this.fldnum10 = value;
        }

        /**
         * Gets the value of the fldnum11 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM11() {
            return fldnum11;
        }

        /**
         * Sets the value of the fldnum11 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM11(BigDecimal value) {
            this.fldnum11 = value;
        }

        /**
         * Gets the value of the fldnum12 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM12() {
            return fldnum12;
        }

        /**
         * Sets the value of the fldnum12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM12(BigDecimal value) {
            this.fldnum12 = value;
        }

        /**
         * Gets the value of the fldnum13 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM13() {
            return fldnum13;
        }

        /**
         * Sets the value of the fldnum13 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM13(BigDecimal value) {
            this.fldnum13 = value;
        }

        /**
         * Gets the value of the fldnum14 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM14() {
            return fldnum14;
        }

        /**
         * Sets the value of the fldnum14 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM14(BigDecimal value) {
            this.fldnum14 = value;
        }

        /**
         * Gets the value of the fldnum15 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM15() {
            return fldnum15;
        }

        /**
         * Sets the value of the fldnum15 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM15(BigDecimal value) {
            this.fldnum15 = value;
        }

        /**
         * Gets the value of the fldnum16 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM16() {
            return fldnum16;
        }

        /**
         * Sets the value of the fldnum16 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM16(BigDecimal value) {
            this.fldnum16 = value;
        }

        /**
         * Gets the value of the fldnum19 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM19() {
            return fldnum19;
        }

        /**
         * Sets the value of the fldnum19 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM19(BigDecimal value) {
            this.fldnum19 = value;
        }

        /**
         * Gets the value of the fldnum20 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFLDNUM20() {
            return fldnum20;
        }

        /**
         * Sets the value of the fldnum20 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFLDNUM20(BigDecimal value) {
            this.fldnum20 = value;
        }

        /**
         * Gets the value of the flddt1 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT1() {
            return flddt1;
        }

        /**
         * Sets the value of the flddt1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT1(XMLGregorianCalendar value) {
            this.flddt1 = value;
        }

        /**
         * Gets the value of the flddt2 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT2() {
            return flddt2;
        }

        /**
         * Sets the value of the flddt2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT2(XMLGregorianCalendar value) {
            this.flddt2 = value;
        }

        /**
         * Gets the value of the flddt3 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT3() {
            return flddt3;
        }

        /**
         * Sets the value of the flddt3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT3(XMLGregorianCalendar value) {
            this.flddt3 = value;
        }

        /**
         * Gets the value of the flddt4 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT4() {
            return flddt4;
        }

        /**
         * Sets the value of the flddt4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT4(XMLGregorianCalendar value) {
            this.flddt4 = value;
        }

        /**
         * Gets the value of the flddt5 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT5() {
            return flddt5;
        }

        /**
         * Sets the value of the flddt5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT5(XMLGregorianCalendar value) {
            this.flddt5 = value;
        }

        /**
         * Gets the value of the flddt6 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT6() {
            return flddt6;
        }

        /**
         * Sets the value of the flddt6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT6(XMLGregorianCalendar value) {
            this.flddt6 = value;
        }

        /**
         * Gets the value of the flddt7 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT7() {
            return flddt7;
        }

        /**
         * Sets the value of the flddt7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT7(XMLGregorianCalendar value) {
            this.flddt7 = value;
        }

        /**
         * Gets the value of the flddt8 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT8() {
            return flddt8;
        }

        /**
         * Sets the value of the flddt8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT8(XMLGregorianCalendar value) {
            this.flddt8 = value;
        }

        /**
         * Gets the value of the flddt9 property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFLDDT9() {
            return flddt9;
        }

        /**
         * Sets the value of the flddt9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFLDDT9(XMLGregorianCalendar value) {
            this.flddt9 = value;
        }

    }

}
