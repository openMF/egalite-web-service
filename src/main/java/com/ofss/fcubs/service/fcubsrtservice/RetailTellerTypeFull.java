
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Retail-Teller-Type-Full complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Retail-Teller-Type-Full">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FCCREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ESN" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="EVNTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BRN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MODULE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TXNTRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITCARDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CC_HOLDER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFFSETBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFFSETACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFFSETCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFFSETAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="OFFSETTRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="XRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LCYAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TXNDATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="CHEQUE_ISS_DATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="REJECT_CODE" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="VALDATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="RELCUST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ROUTINGNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENDPOINT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERIALNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ROUTECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DRINSTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRINSTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TCYCHGAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYCHGAMT1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYCHGAMT2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYCHGAMT3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYCHGAMT4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCYTOTCHGAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="REPREASON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NARRATIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRACKREVERSE" type="{http://fcubs.ofss.com/service/FCUBSRTService}YesNoType" minOccurs="0"/>
 *         &lt;element name="LCYXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MAKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAKERSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKERSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODNO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RECSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUTHSTAT" type="{http://fcubs.ofss.com/service/FCUBSRTService}AuthStatType" minOccurs="0"/>
 *         &lt;element name="SCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCYCHGAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGACYXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGLCYXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LCYCHGAMT1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGACYXRATE1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGLCYXRATE1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LCYCHGAMT2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGACYXRATE2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGLCYXRATE2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LCYCHGAMT3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGACYXRATE3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGLCYXRATE3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LCYCHGAMT4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGACYXRATE4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHGLCYXRATE4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DRACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FTPRBLM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIMERECV" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="THEIRCHGS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRCHGS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRCHGS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRCHGS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRCHGS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRACC1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRACC2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRACC3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THEIRACC4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BATCHNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CALCHG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNDRCR" type="{http://fcubs.ofss.com/service/FCUBSRTService}DrCrType" minOccurs="0"/>
 *         &lt;element name="BOOKDATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="CLGBNK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFFSETLCYAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TRANCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FT" type="{http://fcubs.ofss.com/service/FCUBSRTService}YesNoType" minOccurs="0"/>
 *         &lt;element name="UTLBNF1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UTLBNF2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UTLBNF3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UTLBNF4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ULTBNF5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AWI1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AWI2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AWI3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AWI4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AWI5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCYTOTCHGAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DENMCCY1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DENMAMT1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DENMCCY2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DENMAMT2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ACCTITLE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCTITLE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CHRACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCYCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TOKEN_NO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Charge-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}ChgdetsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Cheque-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}MckDetsType" minOccurs="0"/>
 *         &lt;element name="Mis-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}MISDETAILSType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Udf-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}UDFDETAILSType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Message-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}MsgDetsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Retail-Teller-Type-Full", propOrder = {
    "xref",
    "fccref",
    "prd",
    "esn",
    "evntcd",
    "brn",
    "module",
    "txnbrn",
    "txnacc",
    "txnccy",
    "txnamt",
    "txntrn",
    "creditcardno",
    "ccholdername",
    "offsetbrn",
    "offsetacc",
    "offsetccy",
    "offsetamt",
    "offsettrn",
    "xrate",
    "lcyamt",
    "txndate",
    "chequeissdate",
    "rejectcode",
    "valdate",
    "relcust",
    "remaccount",
    "rembank",
    "rembranch",
    "routingno",
    "endpoint",
    "serialno",
    "routecode",
    "drinstcd",
    "crinstcd",
    "tcychgamt",
    "tcychgamt1",
    "tcychgamt2",
    "tcychgamt3",
    "tcychgamt4",
    "tcytotchgamt",
    "repreason",
    "narrative",
    "trackreverse",
    "lcyxrate",
    "makerid",
    "makerstamp",
    "checkerid",
    "checkerstamp",
    "modno",
    "recstat",
    "authstat",
    "scode",
    "lcychgamt",
    "chgacyxrate",
    "chglcyxrate",
    "lcychgamt1",
    "chgacyxrate1",
    "chglcyxrate1",
    "lcychgamt2",
    "chgacyxrate2",
    "chglcyxrate2",
    "lcychgamt3",
    "chgacyxrate3",
    "chglcyxrate3",
    "lcychgamt4",
    "chgacyxrate4",
    "chglcyxrate4",
    "dracc",
    "ftprblm",
    "timerecv",
    "theirchgs",
    "theirchgs1",
    "theirchgs2",
    "theirchgs3",
    "theirchgs4",
    "theiracc",
    "theiracc1",
    "theiracc2",
    "theiracc3",
    "theiracc4",
    "batchno",
    "calchg",
    "txndrcr",
    "bookdate",
    "clgbnk",
    "offsetlcyamt",
    "trancount",
    "ft",
    "utlbnf1",
    "utlbnf2",
    "utlbnf3",
    "utlbnf4",
    "ultbnf5",
    "awi1",
    "awi2",
    "awi3",
    "awi4",
    "awi5",
    "country",
    "lcytotchgamt",
    "denmccy1",
    "denmamt1",
    "denmccy2",
    "denmamt2",
    "acctitle1",
    "acctitle2",
    "actamt",
    "chracc",
    "totil",
    "ccycode",
    "amount",
    "tokenno",
    "chargeDetails",
    "chequeDetails",
    "misDetails",
    "udfDetails",
    "messageDetails"
})
public class RetailTellerTypeFull {

    @XmlElement(name = "XREF")
    protected String xref;
    @XmlElement(name = "FCCREF")
    protected String fccref;
    @XmlElement(name = "PRD", required = true)
    protected String prd;
    @XmlElement(name = "ESN")
    protected BigDecimal esn;
    @XmlElement(name = "EVNTCD")
    protected String evntcd;
    @XmlElement(name = "BRN", required = true)
    protected String brn;
    @XmlElement(name = "MODULE")
    protected String module;
    @XmlElement(name = "TXNBRN")
    protected String txnbrn;
    @XmlElement(name = "TXNACC")
    protected String txnacc;
    @XmlElement(name = "TXNCCY")
    protected String txnccy;
    @XmlElement(name = "TXNAMT")
    protected BigDecimal txnamt;
    @XmlElement(name = "TXNTRN")
    protected String txntrn;
    @XmlElement(name = "CREDITCARDNO")
    protected String creditcardno;
    @XmlElement(name = "CC_HOLDER_NAME")
    protected String ccholdername;
    @XmlElement(name = "OFFSETBRN")
    protected String offsetbrn;
    @XmlElement(name = "OFFSETACC")
    protected String offsetacc;
    @XmlElement(name = "OFFSETCCY")
    protected String offsetccy;
    @XmlElement(name = "OFFSETAMT")
    protected BigDecimal offsetamt;
    @XmlElement(name = "OFFSETTRN")
    protected String offsettrn;
    @XmlElement(name = "XRATE")
    protected BigDecimal xrate;
    @XmlElement(name = "LCYAMT")
    protected BigDecimal lcyamt;
    @XmlElement(name = "TXNDATE")
    @XmlSchemaType(name = "anySimpleType")
    protected Object txndate;
    @XmlElement(name = "CHEQUE_ISS_DATE")
    @XmlSchemaType(name = "anySimpleType")
    protected Object chequeissdate;
    @XmlElement(name = "REJECT_CODE")
    protected Object rejectcode;
    @XmlElement(name = "VALDATE")
    @XmlSchemaType(name = "anySimpleType")
    protected Object valdate;
    @XmlElement(name = "RELCUST")
    protected String relcust;
    @XmlElement(name = "REMACCOUNT")
    protected String remaccount;
    @XmlElement(name = "REMBANK")
    protected String rembank;
    @XmlElement(name = "REMBRANCH")
    protected String rembranch;
    @XmlElement(name = "ROUTINGNO")
    protected String routingno;
    @XmlElement(name = "ENDPOINT")
    protected String endpoint;
    @XmlElement(name = "SERIALNO")
    protected String serialno;
    @XmlElement(name = "ROUTECODE")
    protected String routecode;
    @XmlElement(name = "DRINSTCD")
    protected String drinstcd;
    @XmlElement(name = "CRINSTCD")
    protected String crinstcd;
    @XmlElement(name = "TCYCHGAMT")
    protected BigDecimal tcychgamt;
    @XmlElement(name = "TCYCHGAMT1")
    protected BigDecimal tcychgamt1;
    @XmlElement(name = "TCYCHGAMT2")
    protected BigDecimal tcychgamt2;
    @XmlElement(name = "TCYCHGAMT3")
    protected BigDecimal tcychgamt3;
    @XmlElement(name = "TCYCHGAMT4")
    protected BigDecimal tcychgamt4;
    @XmlElement(name = "TCYTOTCHGAMT")
    protected BigDecimal tcytotchgamt;
    @XmlElement(name = "REPREASON")
    protected String repreason;
    @XmlElement(name = "NARRATIVE")
    protected String narrative;
    @XmlElement(name = "TRACKREVERSE")
    protected YesNoType trackreverse;
    @XmlElement(name = "LCYXRATE")
    protected BigDecimal lcyxrate;
    @XmlElement(name = "MAKERID")
    protected String makerid;
    @XmlElement(name = "MAKERSTAMP")
    protected String makerstamp;
    @XmlElement(name = "CHECKERID")
    protected String checkerid;
    @XmlElement(name = "CHECKERSTAMP")
    protected String checkerstamp;
    @XmlElement(name = "MODNO")
    protected BigDecimal modno;
    @XmlElement(name = "RECSTAT")
    protected String recstat;
    @XmlElement(name = "AUTHSTAT")
    protected AuthStatType authstat;
    @XmlElement(name = "SCODE")
    protected String scode;
    @XmlElement(name = "LCYCHGAMT")
    protected BigDecimal lcychgamt;
    @XmlElement(name = "CHGACYXRATE")
    protected BigDecimal chgacyxrate;
    @XmlElement(name = "CHGLCYXRATE")
    protected BigDecimal chglcyxrate;
    @XmlElement(name = "LCYCHGAMT1")
    protected BigDecimal lcychgamt1;
    @XmlElement(name = "CHGACYXRATE1")
    protected BigDecimal chgacyxrate1;
    @XmlElement(name = "CHGLCYXRATE1")
    protected BigDecimal chglcyxrate1;
    @XmlElement(name = "LCYCHGAMT2")
    protected BigDecimal lcychgamt2;
    @XmlElement(name = "CHGACYXRATE2")
    protected BigDecimal chgacyxrate2;
    @XmlElement(name = "CHGLCYXRATE2")
    protected BigDecimal chglcyxrate2;
    @XmlElement(name = "LCYCHGAMT3")
    protected BigDecimal lcychgamt3;
    @XmlElement(name = "CHGACYXRATE3")
    protected BigDecimal chgacyxrate3;
    @XmlElement(name = "CHGLCYXRATE3")
    protected BigDecimal chglcyxrate3;
    @XmlElement(name = "LCYCHGAMT4")
    protected BigDecimal lcychgamt4;
    @XmlElement(name = "CHGACYXRATE4")
    protected BigDecimal chgacyxrate4;
    @XmlElement(name = "CHGLCYXRATE4")
    protected BigDecimal chglcyxrate4;
    @XmlElement(name = "DRACC")
    protected String dracc;
    @XmlElement(name = "FTPRBLM")
    protected String ftprblm;
    @XmlElement(name = "TIMERECV")
    @XmlSchemaType(name = "anySimpleType")
    protected Object timerecv;
    @XmlElement(name = "THEIRCHGS")
    protected String theirchgs;
    @XmlElement(name = "THEIRCHGS1")
    protected String theirchgs1;
    @XmlElement(name = "THEIRCHGS2")
    protected String theirchgs2;
    @XmlElement(name = "THEIRCHGS3")
    protected String theirchgs3;
    @XmlElement(name = "THEIRCHGS4")
    protected String theirchgs4;
    @XmlElement(name = "THEIRACC")
    protected String theiracc;
    @XmlElement(name = "THEIRACC1")
    protected String theiracc1;
    @XmlElement(name = "THEIRACC2")
    protected String theiracc2;
    @XmlElement(name = "THEIRACC3")
    protected String theiracc3;
    @XmlElement(name = "THEIRACC4")
    protected String theiracc4;
    @XmlElement(name = "BATCHNO")
    protected String batchno;
    @XmlElement(name = "CALCHG")
    protected String calchg;
    @XmlElement(name = "TXNDRCR")
    protected DrCrType txndrcr;
    @XmlElement(name = "BOOKDATE")
    @XmlSchemaType(name = "anySimpleType")
    protected Object bookdate;
    @XmlElement(name = "CLGBNK")
    protected String clgbnk;
    @XmlElement(name = "OFFSETLCYAMT")
    protected BigDecimal offsetlcyamt;
    @XmlElement(name = "TRANCOUNT")
    protected String trancount;
    @XmlElement(name = "FT")
    protected YesNoType ft;
    @XmlElement(name = "UTLBNF1")
    protected String utlbnf1;
    @XmlElement(name = "UTLBNF2")
    protected String utlbnf2;
    @XmlElement(name = "UTLBNF3")
    protected String utlbnf3;
    @XmlElement(name = "UTLBNF4")
    protected String utlbnf4;
    @XmlElement(name = "ULTBNF5")
    protected String ultbnf5;
    @XmlElement(name = "AWI1")
    protected String awi1;
    @XmlElement(name = "AWI2")
    protected String awi2;
    @XmlElement(name = "AWI3")
    protected String awi3;
    @XmlElement(name = "AWI4")
    protected String awi4;
    @XmlElement(name = "AWI5")
    protected String awi5;
    @XmlElement(name = "COUNTRY")
    protected String country;
    @XmlElement(name = "LCYTOTCHGAMT")
    protected BigDecimal lcytotchgamt;
    @XmlElement(name = "DENMCCY1")
    protected String denmccy1;
    @XmlElement(name = "DENMAMT1")
    protected BigDecimal denmamt1;
    @XmlElement(name = "DENMCCY2")
    protected String denmccy2;
    @XmlElement(name = "DENMAMT2")
    protected BigDecimal denmamt2;
    @XmlElement(name = "ACCTITLE1")
    protected String acctitle1;
    @XmlElement(name = "ACCTITLE2")
    protected String acctitle2;
    @XmlElement(name = "ACTAMT")
    protected BigDecimal actamt;
    @XmlElement(name = "CHRACC")
    protected String chracc;
    @XmlElement(name = "TOTIL")
    protected String totil;
    @XmlElement(name = "CCYCODE")
    protected String ccycode;
    @XmlElement(name = "AMOUNT")
    protected BigDecimal amount;
    @XmlElement(name = "TOKEN_NO")
    protected BigDecimal tokenno;
    @XmlElement(name = "Charge-Details")
    protected List<ChgdetsType> chargeDetails;
    @XmlElement(name = "Cheque-Details")
    protected MckDetsType chequeDetails;
    @XmlElement(name = "Mis-Details")
    protected List<MISDETAILSType> misDetails;
    @XmlElement(name = "Udf-Details")
    protected List<UDFDETAILSType> udfDetails;
    @XmlElement(name = "Message-Details")
    protected MsgDetsType messageDetails;

    /**
     * Gets the value of the xref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXREF() {
        return xref;
    }

    /**
     * Sets the value of the xref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXREF(String value) {
        this.xref = value;
    }

    /**
     * Gets the value of the fccref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCCREF() {
        return fccref;
    }

    /**
     * Sets the value of the fccref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCCREF(String value) {
        this.fccref = value;
    }

    /**
     * Gets the value of the prd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRD() {
        return prd;
    }

    /**
     * Sets the value of the prd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRD(String value) {
        this.prd = value;
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
     * Gets the value of the evntcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVNTCD() {
        return evntcd;
    }

    /**
     * Sets the value of the evntcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVNTCD(String value) {
        this.evntcd = value;
    }

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
     * Gets the value of the module property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODULE() {
        return module;
    }

    /**
     * Sets the value of the module property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODULE(String value) {
        this.module = value;
    }

    /**
     * Gets the value of the txnbrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNBRN() {
        return txnbrn;
    }

    /**
     * Sets the value of the txnbrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNBRN(String value) {
        this.txnbrn = value;
    }

    /**
     * Gets the value of the txnacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNACC() {
        return txnacc;
    }

    /**
     * Sets the value of the txnacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNACC(String value) {
        this.txnacc = value;
    }

    /**
     * Gets the value of the txnccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNCCY() {
        return txnccy;
    }

    /**
     * Sets the value of the txnccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNCCY(String value) {
        this.txnccy = value;
    }

    /**
     * Gets the value of the txnamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTXNAMT() {
        return txnamt;
    }

    /**
     * Sets the value of the txnamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTXNAMT(BigDecimal value) {
        this.txnamt = value;
    }

    /**
     * Gets the value of the txntrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNTRN() {
        return txntrn;
    }

    /**
     * Sets the value of the txntrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNTRN(String value) {
        this.txntrn = value;
    }

    /**
     * Gets the value of the creditcardno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDITCARDNO() {
        return creditcardno;
    }

    /**
     * Sets the value of the creditcardno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDITCARDNO(String value) {
        this.creditcardno = value;
    }

    /**
     * Gets the value of the ccholdername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCHOLDERNAME() {
        return ccholdername;
    }

    /**
     * Sets the value of the ccholdername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCHOLDERNAME(String value) {
        this.ccholdername = value;
    }

    /**
     * Gets the value of the offsetbrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFSETBRN() {
        return offsetbrn;
    }

    /**
     * Sets the value of the offsetbrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFSETBRN(String value) {
        this.offsetbrn = value;
    }

    /**
     * Gets the value of the offsetacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFSETACC() {
        return offsetacc;
    }

    /**
     * Sets the value of the offsetacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFSETACC(String value) {
        this.offsetacc = value;
    }

    /**
     * Gets the value of the offsetccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFSETCCY() {
        return offsetccy;
    }

    /**
     * Sets the value of the offsetccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFSETCCY(String value) {
        this.offsetccy = value;
    }

    /**
     * Gets the value of the offsetamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOFFSETAMT() {
        return offsetamt;
    }

    /**
     * Sets the value of the offsetamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOFFSETAMT(BigDecimal value) {
        this.offsetamt = value;
    }

    /**
     * Gets the value of the offsettrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFSETTRN() {
        return offsettrn;
    }

    /**
     * Sets the value of the offsettrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFSETTRN(String value) {
        this.offsettrn = value;
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
     * Gets the value of the lcyamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYAMT() {
        return lcyamt;
    }

    /**
     * Sets the value of the lcyamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYAMT(BigDecimal value) {
        this.lcyamt = value;
    }

    /**
     * Gets the value of the txndate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTXNDATE() {
        return txndate;
    }

    /**
     * Sets the value of the txndate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTXNDATE(Object value) {
        this.txndate = value;
    }

    /**
     * Gets the value of the chequeissdate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCHEQUEISSDATE() {
        return chequeissdate;
    }

    /**
     * Sets the value of the chequeissdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCHEQUEISSDATE(Object value) {
        this.chequeissdate = value;
    }

    /**
     * Gets the value of the rejectcode property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getREJECTCODE() {
        return rejectcode;
    }

    /**
     * Sets the value of the rejectcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setREJECTCODE(Object value) {
        this.rejectcode = value;
    }

    /**
     * Gets the value of the valdate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getVALDATE() {
        return valdate;
    }

    /**
     * Sets the value of the valdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setVALDATE(Object value) {
        this.valdate = value;
    }

    /**
     * Gets the value of the relcust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELCUST() {
        return relcust;
    }

    /**
     * Sets the value of the relcust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELCUST(String value) {
        this.relcust = value;
    }

    /**
     * Gets the value of the remaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMACCOUNT() {
        return remaccount;
    }

    /**
     * Sets the value of the remaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMACCOUNT(String value) {
        this.remaccount = value;
    }

    /**
     * Gets the value of the rembank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMBANK() {
        return rembank;
    }

    /**
     * Sets the value of the rembank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMBANK(String value) {
        this.rembank = value;
    }

    /**
     * Gets the value of the rembranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMBRANCH() {
        return rembranch;
    }

    /**
     * Sets the value of the rembranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMBRANCH(String value) {
        this.rembranch = value;
    }

    /**
     * Gets the value of the routingno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROUTINGNO() {
        return routingno;
    }

    /**
     * Sets the value of the routingno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROUTINGNO(String value) {
        this.routingno = value;
    }

    /**
     * Gets the value of the endpoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDPOINT() {
        return endpoint;
    }

    /**
     * Sets the value of the endpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDPOINT(String value) {
        this.endpoint = value;
    }

    /**
     * Gets the value of the serialno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNO() {
        return serialno;
    }

    /**
     * Sets the value of the serialno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNO(String value) {
        this.serialno = value;
    }

    /**
     * Gets the value of the routecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROUTECODE() {
        return routecode;
    }

    /**
     * Sets the value of the routecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROUTECODE(String value) {
        this.routecode = value;
    }

    /**
     * Gets the value of the drinstcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRINSTCD() {
        return drinstcd;
    }

    /**
     * Sets the value of the drinstcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRINSTCD(String value) {
        this.drinstcd = value;
    }

    /**
     * Gets the value of the crinstcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRINSTCD() {
        return crinstcd;
    }

    /**
     * Sets the value of the crinstcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRINSTCD(String value) {
        this.crinstcd = value;
    }

    /**
     * Gets the value of the tcychgamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYCHGAMT() {
        return tcychgamt;
    }

    /**
     * Sets the value of the tcychgamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYCHGAMT(BigDecimal value) {
        this.tcychgamt = value;
    }

    /**
     * Gets the value of the tcychgamt1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYCHGAMT1() {
        return tcychgamt1;
    }

    /**
     * Sets the value of the tcychgamt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYCHGAMT1(BigDecimal value) {
        this.tcychgamt1 = value;
    }

    /**
     * Gets the value of the tcychgamt2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYCHGAMT2() {
        return tcychgamt2;
    }

    /**
     * Sets the value of the tcychgamt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYCHGAMT2(BigDecimal value) {
        this.tcychgamt2 = value;
    }

    /**
     * Gets the value of the tcychgamt3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYCHGAMT3() {
        return tcychgamt3;
    }

    /**
     * Sets the value of the tcychgamt3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYCHGAMT3(BigDecimal value) {
        this.tcychgamt3 = value;
    }

    /**
     * Gets the value of the tcychgamt4 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYCHGAMT4() {
        return tcychgamt4;
    }

    /**
     * Sets the value of the tcychgamt4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYCHGAMT4(BigDecimal value) {
        this.tcychgamt4 = value;
    }

    /**
     * Gets the value of the tcytotchgamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCYTOTCHGAMT() {
        return tcytotchgamt;
    }

    /**
     * Sets the value of the tcytotchgamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCYTOTCHGAMT(BigDecimal value) {
        this.tcytotchgamt = value;
    }

    /**
     * Gets the value of the repreason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPREASON() {
        return repreason;
    }

    /**
     * Sets the value of the repreason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPREASON(String value) {
        this.repreason = value;
    }

    /**
     * Gets the value of the narrative property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNARRATIVE() {
        return narrative;
    }

    /**
     * Sets the value of the narrative property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNARRATIVE(String value) {
        this.narrative = value;
    }

    /**
     * Gets the value of the trackreverse property.
     * 
     * @return
     *     possible object is
     *     {@link YesNoType }
     *     
     */
    public YesNoType getTRACKREVERSE() {
        return trackreverse;
    }

    /**
     * Sets the value of the trackreverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoType }
     *     
     */
    public void setTRACKREVERSE(YesNoType value) {
        this.trackreverse = value;
    }

    /**
     * Gets the value of the lcyxrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYXRATE() {
        return lcyxrate;
    }

    /**
     * Sets the value of the lcyxrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYXRATE(BigDecimal value) {
        this.lcyxrate = value;
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
     * Gets the value of the makerstamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAKERSTAMP() {
        return makerstamp;
    }

    /**
     * Sets the value of the makerstamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAKERSTAMP(String value) {
        this.makerstamp = value;
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
     * Gets the value of the modno property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMODNO() {
        return modno;
    }

    /**
     * Sets the value of the modno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMODNO(BigDecimal value) {
        this.modno = value;
    }

    /**
     * Gets the value of the recstat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECSTAT() {
        return recstat;
    }

    /**
     * Sets the value of the recstat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECSTAT(String value) {
        this.recstat = value;
    }

    /**
     * Gets the value of the authstat property.
     * 
     * @return
     *     possible object is
     *     {@link AuthStatType }
     *     
     */
    public AuthStatType getAUTHSTAT() {
        return authstat;
    }

    /**
     * Sets the value of the authstat property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthStatType }
     *     
     */
    public void setAUTHSTAT(AuthStatType value) {
        this.authstat = value;
    }

    /**
     * Gets the value of the scode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCODE() {
        return scode;
    }

    /**
     * Sets the value of the scode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCODE(String value) {
        this.scode = value;
    }

    /**
     * Gets the value of the lcychgamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYCHGAMT() {
        return lcychgamt;
    }

    /**
     * Sets the value of the lcychgamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYCHGAMT(BigDecimal value) {
        this.lcychgamt = value;
    }

    /**
     * Gets the value of the chgacyxrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGACYXRATE() {
        return chgacyxrate;
    }

    /**
     * Sets the value of the chgacyxrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGACYXRATE(BigDecimal value) {
        this.chgacyxrate = value;
    }

    /**
     * Gets the value of the chglcyxrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGLCYXRATE() {
        return chglcyxrate;
    }

    /**
     * Sets the value of the chglcyxrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGLCYXRATE(BigDecimal value) {
        this.chglcyxrate = value;
    }

    /**
     * Gets the value of the lcychgamt1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYCHGAMT1() {
        return lcychgamt1;
    }

    /**
     * Sets the value of the lcychgamt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYCHGAMT1(BigDecimal value) {
        this.lcychgamt1 = value;
    }

    /**
     * Gets the value of the chgacyxrate1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGACYXRATE1() {
        return chgacyxrate1;
    }

    /**
     * Sets the value of the chgacyxrate1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGACYXRATE1(BigDecimal value) {
        this.chgacyxrate1 = value;
    }

    /**
     * Gets the value of the chglcyxrate1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGLCYXRATE1() {
        return chglcyxrate1;
    }

    /**
     * Sets the value of the chglcyxrate1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGLCYXRATE1(BigDecimal value) {
        this.chglcyxrate1 = value;
    }

    /**
     * Gets the value of the lcychgamt2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYCHGAMT2() {
        return lcychgamt2;
    }

    /**
     * Sets the value of the lcychgamt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYCHGAMT2(BigDecimal value) {
        this.lcychgamt2 = value;
    }

    /**
     * Gets the value of the chgacyxrate2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGACYXRATE2() {
        return chgacyxrate2;
    }

    /**
     * Sets the value of the chgacyxrate2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGACYXRATE2(BigDecimal value) {
        this.chgacyxrate2 = value;
    }

    /**
     * Gets the value of the chglcyxrate2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGLCYXRATE2() {
        return chglcyxrate2;
    }

    /**
     * Sets the value of the chglcyxrate2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGLCYXRATE2(BigDecimal value) {
        this.chglcyxrate2 = value;
    }

    /**
     * Gets the value of the lcychgamt3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYCHGAMT3() {
        return lcychgamt3;
    }

    /**
     * Sets the value of the lcychgamt3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYCHGAMT3(BigDecimal value) {
        this.lcychgamt3 = value;
    }

    /**
     * Gets the value of the chgacyxrate3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGACYXRATE3() {
        return chgacyxrate3;
    }

    /**
     * Sets the value of the chgacyxrate3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGACYXRATE3(BigDecimal value) {
        this.chgacyxrate3 = value;
    }

    /**
     * Gets the value of the chglcyxrate3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGLCYXRATE3() {
        return chglcyxrate3;
    }

    /**
     * Sets the value of the chglcyxrate3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGLCYXRATE3(BigDecimal value) {
        this.chglcyxrate3 = value;
    }

    /**
     * Gets the value of the lcychgamt4 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYCHGAMT4() {
        return lcychgamt4;
    }

    /**
     * Sets the value of the lcychgamt4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYCHGAMT4(BigDecimal value) {
        this.lcychgamt4 = value;
    }

    /**
     * Gets the value of the chgacyxrate4 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGACYXRATE4() {
        return chgacyxrate4;
    }

    /**
     * Sets the value of the chgacyxrate4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGACYXRATE4(BigDecimal value) {
        this.chgacyxrate4 = value;
    }

    /**
     * Gets the value of the chglcyxrate4 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCHGLCYXRATE4() {
        return chglcyxrate4;
    }

    /**
     * Sets the value of the chglcyxrate4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCHGLCYXRATE4(BigDecimal value) {
        this.chglcyxrate4 = value;
    }

    /**
     * Gets the value of the dracc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRACC() {
        return dracc;
    }

    /**
     * Sets the value of the dracc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRACC(String value) {
        this.dracc = value;
    }

    /**
     * Gets the value of the ftprblm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTPRBLM() {
        return ftprblm;
    }

    /**
     * Sets the value of the ftprblm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTPRBLM(String value) {
        this.ftprblm = value;
    }

    /**
     * Gets the value of the timerecv property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTIMERECV() {
        return timerecv;
    }

    /**
     * Sets the value of the timerecv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTIMERECV(Object value) {
        this.timerecv = value;
    }

    /**
     * Gets the value of the theirchgs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRCHGS() {
        return theirchgs;
    }

    /**
     * Sets the value of the theirchgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRCHGS(String value) {
        this.theirchgs = value;
    }

    /**
     * Gets the value of the theirchgs1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRCHGS1() {
        return theirchgs1;
    }

    /**
     * Sets the value of the theirchgs1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRCHGS1(String value) {
        this.theirchgs1 = value;
    }

    /**
     * Gets the value of the theirchgs2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRCHGS2() {
        return theirchgs2;
    }

    /**
     * Sets the value of the theirchgs2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRCHGS2(String value) {
        this.theirchgs2 = value;
    }

    /**
     * Gets the value of the theirchgs3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRCHGS3() {
        return theirchgs3;
    }

    /**
     * Sets the value of the theirchgs3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRCHGS3(String value) {
        this.theirchgs3 = value;
    }

    /**
     * Gets the value of the theirchgs4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRCHGS4() {
        return theirchgs4;
    }

    /**
     * Sets the value of the theirchgs4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRCHGS4(String value) {
        this.theirchgs4 = value;
    }

    /**
     * Gets the value of the theiracc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRACC() {
        return theiracc;
    }

    /**
     * Sets the value of the theiracc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRACC(String value) {
        this.theiracc = value;
    }

    /**
     * Gets the value of the theiracc1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRACC1() {
        return theiracc1;
    }

    /**
     * Sets the value of the theiracc1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRACC1(String value) {
        this.theiracc1 = value;
    }

    /**
     * Gets the value of the theiracc2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRACC2() {
        return theiracc2;
    }

    /**
     * Sets the value of the theiracc2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRACC2(String value) {
        this.theiracc2 = value;
    }

    /**
     * Gets the value of the theiracc3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRACC3() {
        return theiracc3;
    }

    /**
     * Sets the value of the theiracc3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRACC3(String value) {
        this.theiracc3 = value;
    }

    /**
     * Gets the value of the theiracc4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHEIRACC4() {
        return theiracc4;
    }

    /**
     * Sets the value of the theiracc4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHEIRACC4(String value) {
        this.theiracc4 = value;
    }

    /**
     * Gets the value of the batchno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBATCHNO() {
        return batchno;
    }

    /**
     * Sets the value of the batchno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBATCHNO(String value) {
        this.batchno = value;
    }

    /**
     * Gets the value of the calchg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCALCHG() {
        return calchg;
    }

    /**
     * Sets the value of the calchg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCALCHG(String value) {
        this.calchg = value;
    }

    /**
     * Gets the value of the txndrcr property.
     * 
     * @return
     *     possible object is
     *     {@link DrCrType }
     *     
     */
    public DrCrType getTXNDRCR() {
        return txndrcr;
    }

    /**
     * Sets the value of the txndrcr property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrCrType }
     *     
     */
    public void setTXNDRCR(DrCrType value) {
        this.txndrcr = value;
    }

    /**
     * Gets the value of the bookdate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBOOKDATE() {
        return bookdate;
    }

    /**
     * Sets the value of the bookdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBOOKDATE(Object value) {
        this.bookdate = value;
    }

    /**
     * Gets the value of the clgbnk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLGBNK() {
        return clgbnk;
    }

    /**
     * Sets the value of the clgbnk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLGBNK(String value) {
        this.clgbnk = value;
    }

    /**
     * Gets the value of the offsetlcyamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOFFSETLCYAMT() {
        return offsetlcyamt;
    }

    /**
     * Sets the value of the offsetlcyamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOFFSETLCYAMT(BigDecimal value) {
        this.offsetlcyamt = value;
    }

    /**
     * Gets the value of the trancount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANCOUNT() {
        return trancount;
    }

    /**
     * Sets the value of the trancount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANCOUNT(String value) {
        this.trancount = value;
    }

    /**
     * Gets the value of the ft property.
     * 
     * @return
     *     possible object is
     *     {@link YesNoType }
     *     
     */
    public YesNoType getFT() {
        return ft;
    }

    /**
     * Sets the value of the ft property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoType }
     *     
     */
    public void setFT(YesNoType value) {
        this.ft = value;
    }

    /**
     * Gets the value of the utlbnf1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTLBNF1() {
        return utlbnf1;
    }

    /**
     * Sets the value of the utlbnf1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTLBNF1(String value) {
        this.utlbnf1 = value;
    }

    /**
     * Gets the value of the utlbnf2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTLBNF2() {
        return utlbnf2;
    }

    /**
     * Sets the value of the utlbnf2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTLBNF2(String value) {
        this.utlbnf2 = value;
    }

    /**
     * Gets the value of the utlbnf3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTLBNF3() {
        return utlbnf3;
    }

    /**
     * Sets the value of the utlbnf3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTLBNF3(String value) {
        this.utlbnf3 = value;
    }

    /**
     * Gets the value of the utlbnf4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTLBNF4() {
        return utlbnf4;
    }

    /**
     * Sets the value of the utlbnf4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTLBNF4(String value) {
        this.utlbnf4 = value;
    }

    /**
     * Gets the value of the ultbnf5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getULTBNF5() {
        return ultbnf5;
    }

    /**
     * Sets the value of the ultbnf5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setULTBNF5(String value) {
        this.ultbnf5 = value;
    }

    /**
     * Gets the value of the awi1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAWI1() {
        return awi1;
    }

    /**
     * Sets the value of the awi1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAWI1(String value) {
        this.awi1 = value;
    }

    /**
     * Gets the value of the awi2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAWI2() {
        return awi2;
    }

    /**
     * Sets the value of the awi2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAWI2(String value) {
        this.awi2 = value;
    }

    /**
     * Gets the value of the awi3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAWI3() {
        return awi3;
    }

    /**
     * Sets the value of the awi3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAWI3(String value) {
        this.awi3 = value;
    }

    /**
     * Gets the value of the awi4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAWI4() {
        return awi4;
    }

    /**
     * Sets the value of the awi4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAWI4(String value) {
        this.awi4 = value;
    }

    /**
     * Gets the value of the awi5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAWI5() {
        return awi5;
    }

    /**
     * Sets the value of the awi5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAWI5(String value) {
        this.awi5 = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOUNTRY() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOUNTRY(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the lcytotchgamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCYTOTCHGAMT() {
        return lcytotchgamt;
    }

    /**
     * Sets the value of the lcytotchgamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCYTOTCHGAMT(BigDecimal value) {
        this.lcytotchgamt = value;
    }

    /**
     * Gets the value of the denmccy1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDENMCCY1() {
        return denmccy1;
    }

    /**
     * Sets the value of the denmccy1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDENMCCY1(String value) {
        this.denmccy1 = value;
    }

    /**
     * Gets the value of the denmamt1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDENMAMT1() {
        return denmamt1;
    }

    /**
     * Sets the value of the denmamt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDENMAMT1(BigDecimal value) {
        this.denmamt1 = value;
    }

    /**
     * Gets the value of the denmccy2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDENMCCY2() {
        return denmccy2;
    }

    /**
     * Sets the value of the denmccy2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDENMCCY2(String value) {
        this.denmccy2 = value;
    }

    /**
     * Gets the value of the denmamt2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDENMAMT2() {
        return denmamt2;
    }

    /**
     * Sets the value of the denmamt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDENMAMT2(BigDecimal value) {
        this.denmamt2 = value;
    }

    /**
     * Gets the value of the acctitle1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTITLE1() {
        return acctitle1;
    }

    /**
     * Sets the value of the acctitle1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTITLE1(String value) {
        this.acctitle1 = value;
    }

    /**
     * Gets the value of the acctitle2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTITLE2() {
        return acctitle2;
    }

    /**
     * Sets the value of the acctitle2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTITLE2(String value) {
        this.acctitle2 = value;
    }

    /**
     * Gets the value of the actamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getACTAMT() {
        return actamt;
    }

    /**
     * Sets the value of the actamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setACTAMT(BigDecimal value) {
        this.actamt = value;
    }

    /**
     * Gets the value of the chracc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHRACC() {
        return chracc;
    }

    /**
     * Sets the value of the chracc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHRACC(String value) {
        this.chracc = value;
    }

    /**
     * Gets the value of the totil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTIL() {
        return totil;
    }

    /**
     * Sets the value of the totil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTIL(String value) {
        this.totil = value;
    }

    /**
     * Gets the value of the ccycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCYCODE() {
        return ccycode;
    }

    /**
     * Sets the value of the ccycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCYCODE(String value) {
        this.ccycode = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMOUNT() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMOUNT(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the tokenno property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOKENNO() {
        return tokenno;
    }

    /**
     * Sets the value of the tokenno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOKENNO(BigDecimal value) {
        this.tokenno = value;
    }

    /**
     * Gets the value of the chargeDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chargeDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChgdetsType }
     * 
     * 
     */
    public List<ChgdetsType> getChargeDetails() {
        if (chargeDetails == null) {
            chargeDetails = new ArrayList<ChgdetsType>();
        }
        return this.chargeDetails;
    }

    /**
     * Gets the value of the chequeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link MckDetsType }
     *     
     */
    public MckDetsType getChequeDetails() {
        return chequeDetails;
    }

    /**
     * Sets the value of the chequeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link MckDetsType }
     *     
     */
    public void setChequeDetails(MckDetsType value) {
        this.chequeDetails = value;
    }

    /**
     * Gets the value of the misDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the misDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMisDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MISDETAILSType }
     * 
     * 
     */
    public List<MISDETAILSType> getMisDetails() {
        if (misDetails == null) {
            misDetails = new ArrayList<MISDETAILSType>();
        }
        return this.misDetails;
    }

    /**
     * Gets the value of the udfDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the udfDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUdfDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UDFDETAILSType }
     * 
     * 
     */
    public List<UDFDETAILSType> getUdfDetails() {
        if (udfDetails == null) {
            udfDetails = new ArrayList<UDFDETAILSType>();
        }
        return this.udfDetails;
    }

    /**
     * Gets the value of the messageDetails property.
     * 
     * @return
     *     possible object is
     *     {@link MsgDetsType }
     *     
     */
    public MsgDetsType getMessageDetails() {
        return messageDetails;
    }

    /**
     * Sets the value of the messageDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgDetsType }
     *     
     */
    public void setMessageDetails(MsgDetsType value) {
        this.messageDetails = value;
    }

}
