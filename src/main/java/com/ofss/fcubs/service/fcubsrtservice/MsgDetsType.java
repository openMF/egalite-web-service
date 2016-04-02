
package com.ofss.fcubs.service.fcubsrtservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MsgDetsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MsgDetsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OPERCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INSTRCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VDATECR" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="ORDCUST1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDCUST2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDCUST3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDCUST4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDCUST5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECEIVER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYDET1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYDET2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYDET3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYDET4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRI1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRI2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRI3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRI4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRI5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRI6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGDET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REGREP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REGREP2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REGREP3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECONT1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECONT2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECONT3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECONT4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECONT5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VDATEDR" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgDetsType", propOrder = {
    "type",
    "opercd",
    "instrcd",
    "txncd",
    "vdatecr",
    "ordcust1",
    "ordcust2",
    "ordcust3",
    "ordcust4",
    "ordcust5",
    "receiver",
    "paydet1",
    "paydet2",
    "paydet3",
    "paydet4",
    "sri1",
    "sri2",
    "sri3",
    "sri4",
    "sri5",
    "sri6",
    "chgdet",
    "regrep1",
    "regrep2",
    "regrep3",
    "econt1",
    "econt2",
    "econt3",
    "econt4",
    "econt5",
    "vdatedr"
})
public class MsgDetsType {

    @XmlElement(name = "TYPE")
    protected String type;
    @XmlElement(name = "OPERCD")
    protected String opercd;
    @XmlElement(name = "INSTRCD")
    protected String instrcd;
    @XmlElement(name = "TXNCD")
    protected String txncd;
    @XmlElement(name = "VDATECR", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object vdatecr;
    @XmlElement(name = "ORDCUST1")
    protected String ordcust1;
    @XmlElement(name = "ORDCUST2")
    protected String ordcust2;
    @XmlElement(name = "ORDCUST3")
    protected String ordcust3;
    @XmlElement(name = "ORDCUST4")
    protected String ordcust4;
    @XmlElement(name = "ORDCUST5")
    protected String ordcust5;
    @XmlElement(name = "RECEIVER")
    protected String receiver;
    @XmlElement(name = "PAYDET1")
    protected String paydet1;
    @XmlElement(name = "PAYDET2")
    protected String paydet2;
    @XmlElement(name = "PAYDET3")
    protected String paydet3;
    @XmlElement(name = "PAYDET4")
    protected String paydet4;
    @XmlElement(name = "SRI1")
    protected String sri1;
    @XmlElement(name = "SRI2")
    protected String sri2;
    @XmlElement(name = "SRI3")
    protected String sri3;
    @XmlElement(name = "SRI4")
    protected String sri4;
    @XmlElement(name = "SRI5")
    protected String sri5;
    @XmlElement(name = "SRI6")
    protected String sri6;
    @XmlElement(name = "CHGDET")
    protected String chgdet;
    @XmlElement(name = "REGREP1")
    protected String regrep1;
    @XmlElement(name = "REGREP2")
    protected String regrep2;
    @XmlElement(name = "REGREP3")
    protected String regrep3;
    @XmlElement(name = "ECONT1")
    protected String econt1;
    @XmlElement(name = "ECONT2")
    protected String econt2;
    @XmlElement(name = "ECONT3")
    protected String econt3;
    @XmlElement(name = "ECONT4")
    protected String econt4;
    @XmlElement(name = "ECONT5")
    protected String econt5;
    @XmlElement(name = "VDATEDR", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object vdatedr;

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
     * Gets the value of the opercd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERCD() {
        return opercd;
    }

    /**
     * Sets the value of the opercd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERCD(String value) {
        this.opercd = value;
    }

    /**
     * Gets the value of the instrcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTRCD() {
        return instrcd;
    }

    /**
     * Sets the value of the instrcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTRCD(String value) {
        this.instrcd = value;
    }

    /**
     * Gets the value of the txncd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNCD() {
        return txncd;
    }

    /**
     * Sets the value of the txncd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNCD(String value) {
        this.txncd = value;
    }

    /**
     * Gets the value of the vdatecr property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getVDATECR() {
        return vdatecr;
    }

    /**
     * Sets the value of the vdatecr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setVDATECR(Object value) {
        this.vdatecr = value;
    }

    /**
     * Gets the value of the ordcust1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUST1() {
        return ordcust1;
    }

    /**
     * Sets the value of the ordcust1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUST1(String value) {
        this.ordcust1 = value;
    }

    /**
     * Gets the value of the ordcust2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUST2() {
        return ordcust2;
    }

    /**
     * Sets the value of the ordcust2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUST2(String value) {
        this.ordcust2 = value;
    }

    /**
     * Gets the value of the ordcust3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUST3() {
        return ordcust3;
    }

    /**
     * Sets the value of the ordcust3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUST3(String value) {
        this.ordcust3 = value;
    }

    /**
     * Gets the value of the ordcust4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUST4() {
        return ordcust4;
    }

    /**
     * Sets the value of the ordcust4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUST4(String value) {
        this.ordcust4 = value;
    }

    /**
     * Gets the value of the ordcust5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUST5() {
        return ordcust5;
    }

    /**
     * Sets the value of the ordcust5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUST5(String value) {
        this.ordcust5 = value;
    }

    /**
     * Gets the value of the receiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECEIVER() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECEIVER(String value) {
        this.receiver = value;
    }

    /**
     * Gets the value of the paydet1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYDET1() {
        return paydet1;
    }

    /**
     * Sets the value of the paydet1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYDET1(String value) {
        this.paydet1 = value;
    }

    /**
     * Gets the value of the paydet2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYDET2() {
        return paydet2;
    }

    /**
     * Sets the value of the paydet2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYDET2(String value) {
        this.paydet2 = value;
    }

    /**
     * Gets the value of the paydet3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYDET3() {
        return paydet3;
    }

    /**
     * Sets the value of the paydet3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYDET3(String value) {
        this.paydet3 = value;
    }

    /**
     * Gets the value of the paydet4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYDET4() {
        return paydet4;
    }

    /**
     * Sets the value of the paydet4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYDET4(String value) {
        this.paydet4 = value;
    }

    /**
     * Gets the value of the sri1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRI1() {
        return sri1;
    }

    /**
     * Sets the value of the sri1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRI1(String value) {
        this.sri1 = value;
    }

    /**
     * Gets the value of the sri2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRI2() {
        return sri2;
    }

    /**
     * Sets the value of the sri2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRI2(String value) {
        this.sri2 = value;
    }

    /**
     * Gets the value of the sri3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRI3() {
        return sri3;
    }

    /**
     * Sets the value of the sri3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRI3(String value) {
        this.sri3 = value;
    }

    /**
     * Gets the value of the sri4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRI4() {
        return sri4;
    }

    /**
     * Sets the value of the sri4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRI4(String value) {
        this.sri4 = value;
    }

    /**
     * Gets the value of the sri5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRI5() {
        return sri5;
    }

    /**
     * Sets the value of the sri5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRI5(String value) {
        this.sri5 = value;
    }

    /**
     * Gets the value of the sri6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRI6() {
        return sri6;
    }

    /**
     * Sets the value of the sri6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRI6(String value) {
        this.sri6 = value;
    }

    /**
     * Gets the value of the chgdet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGDET() {
        return chgdet;
    }

    /**
     * Sets the value of the chgdet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGDET(String value) {
        this.chgdet = value;
    }

    /**
     * Gets the value of the regrep1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGREP1() {
        return regrep1;
    }

    /**
     * Sets the value of the regrep1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGREP1(String value) {
        this.regrep1 = value;
    }

    /**
     * Gets the value of the regrep2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGREP2() {
        return regrep2;
    }

    /**
     * Sets the value of the regrep2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGREP2(String value) {
        this.regrep2 = value;
    }

    /**
     * Gets the value of the regrep3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGREP3() {
        return regrep3;
    }

    /**
     * Sets the value of the regrep3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGREP3(String value) {
        this.regrep3 = value;
    }

    /**
     * Gets the value of the econt1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECONT1() {
        return econt1;
    }

    /**
     * Sets the value of the econt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECONT1(String value) {
        this.econt1 = value;
    }

    /**
     * Gets the value of the econt2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECONT2() {
        return econt2;
    }

    /**
     * Sets the value of the econt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECONT2(String value) {
        this.econt2 = value;
    }

    /**
     * Gets the value of the econt3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECONT3() {
        return econt3;
    }

    /**
     * Sets the value of the econt3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECONT3(String value) {
        this.econt3 = value;
    }

    /**
     * Gets the value of the econt4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECONT4() {
        return econt4;
    }

    /**
     * Sets the value of the econt4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECONT4(String value) {
        this.econt4 = value;
    }

    /**
     * Gets the value of the econt5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECONT5() {
        return econt5;
    }

    /**
     * Sets the value of the econt5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECONT5(String value) {
        this.econt5 = value;
    }

    /**
     * Gets the value of the vdatedr property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getVDATEDR() {
        return vdatedr;
    }

    /**
     * Sets the value of the vdatedr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setVDATEDR(Object value) {
        this.vdatedr = value;
    }

}
