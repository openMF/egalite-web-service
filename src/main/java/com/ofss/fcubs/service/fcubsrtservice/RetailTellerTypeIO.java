
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
 * <p>Java class for Retail-Teller-Type-IO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Retail-Teller-Type-IO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BRN" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="TXNDATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="VALDATE" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="REMACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ROUTINGNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENDPOINT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERIALNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ROUTECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DRINSTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRINSTCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REPREASON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NARRATIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "Retail-Teller-Type-IO", propOrder = {
    "xref",
    "prd",
    "brn",
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
    "txndate",
    "valdate",
    "remaccount",
    "rembank",
    "rembranch",
    "routingno",
    "endpoint",
    "serialno",
    "routecode",
    "drinstcd",
    "crinstcd",
    "repreason",
    "narrative",
    "tokenno",
    "chargeDetails",
    "chequeDetails",
    "misDetails",
    "udfDetails",
    "messageDetails"
})
public class RetailTellerTypeIO {

    @XmlElement(name = "XREF")
    protected String xref;
    @XmlElement(name = "PRD", required = true)
    protected String prd;
    @XmlElement(name = "BRN", required = true)
    protected String brn;
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
    @XmlElement(name = "TXNDATE")
    @XmlSchemaType(name = "anySimpleType")
    protected Object txndate;
    @XmlElement(name = "VALDATE")
    @XmlSchemaType(name = "anySimpleType")
    protected Object valdate;
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
    @XmlElement(name = "REPREASON")
    protected String repreason;
    @XmlElement(name = "NARRATIVE")
    protected String narrative;
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
