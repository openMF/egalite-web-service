
package com.ofss.fcubs.service.fcubsrtservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MckDetsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MckDetsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYBRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHQNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPDT" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="BENFNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENFADDR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENFADDR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENFADDR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENFADDR4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLSTYPE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLS2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLSTYPE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLS3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLSTYPE3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLS4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLSTYPE4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLS5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLSTYPE5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLS6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHERDETLSTYPE6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MckDetsType", propOrder = {
    "srno",
    "paybrn",
    "chqno",
    "stat",
    "expdt",
    "benfname",
    "benfaddr1",
    "benfaddr2",
    "benfaddr3",
    "benfaddr4",
    "crno",
    "isb",
    "otherdetls1",
    "otherdetlstype1",
    "otherdetls2",
    "otherdetlstype2",
    "otherdetls3",
    "otherdetlstype3",
    "otherdetls4",
    "otherdetlstype4",
    "otherdetls5",
    "otherdetlstype5",
    "otherdetls6",
    "otherdetlstype6"
})
public class MckDetsType {

    @XmlElement(name = "SRNO")
    protected String srno;
    @XmlElement(name = "PAYBRN")
    protected String paybrn;
    @XmlElement(name = "CHQNO")
    protected String chqno;
    @XmlElement(name = "STAT")
    protected String stat;
    @XmlElement(name = "EXPDT", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object expdt;
    @XmlElement(name = "BENFNAME")
    protected String benfname;
    @XmlElement(name = "BENFADDR1")
    protected String benfaddr1;
    @XmlElement(name = "BENFADDR2")
    protected String benfaddr2;
    @XmlElement(name = "BENFADDR3")
    protected String benfaddr3;
    @XmlElement(name = "BENFADDR4")
    protected String benfaddr4;
    @XmlElement(name = "CRNO")
    protected String crno;
    @XmlElement(name = "ISB")
    protected String isb;
    @XmlElement(name = "OTHERDETLS1")
    protected String otherdetls1;
    @XmlElement(name = "OTHERDETLSTYPE1")
    protected String otherdetlstype1;
    @XmlElement(name = "OTHERDETLS2")
    protected String otherdetls2;
    @XmlElement(name = "OTHERDETLSTYPE2")
    protected String otherdetlstype2;
    @XmlElement(name = "OTHERDETLS3")
    protected String otherdetls3;
    @XmlElement(name = "OTHERDETLSTYPE3")
    protected String otherdetlstype3;
    @XmlElement(name = "OTHERDETLS4")
    protected String otherdetls4;
    @XmlElement(name = "OTHERDETLSTYPE4")
    protected String otherdetlstype4;
    @XmlElement(name = "OTHERDETLS5")
    protected String otherdetls5;
    @XmlElement(name = "OTHERDETLSTYPE5")
    protected String otherdetlstype5;
    @XmlElement(name = "OTHERDETLS6")
    protected String otherdetls6;
    @XmlElement(name = "OTHERDETLSTYPE6")
    protected String otherdetlstype6;

    /**
     * Gets the value of the srno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRNO() {
        return srno;
    }

    /**
     * Sets the value of the srno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRNO(String value) {
        this.srno = value;
    }

    /**
     * Gets the value of the paybrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYBRN() {
        return paybrn;
    }

    /**
     * Sets the value of the paybrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYBRN(String value) {
        this.paybrn = value;
    }

    /**
     * Gets the value of the chqno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHQNO() {
        return chqno;
    }

    /**
     * Sets the value of the chqno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHQNO(String value) {
        this.chqno = value;
    }

    /**
     * Gets the value of the stat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTAT() {
        return stat;
    }

    /**
     * Sets the value of the stat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTAT(String value) {
        this.stat = value;
    }

    /**
     * Gets the value of the expdt property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEXPDT() {
        return expdt;
    }

    /**
     * Sets the value of the expdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEXPDT(Object value) {
        this.expdt = value;
    }

    /**
     * Gets the value of the benfname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENFNAME() {
        return benfname;
    }

    /**
     * Sets the value of the benfname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENFNAME(String value) {
        this.benfname = value;
    }

    /**
     * Gets the value of the benfaddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENFADDR1() {
        return benfaddr1;
    }

    /**
     * Sets the value of the benfaddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENFADDR1(String value) {
        this.benfaddr1 = value;
    }

    /**
     * Gets the value of the benfaddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENFADDR2() {
        return benfaddr2;
    }

    /**
     * Sets the value of the benfaddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENFADDR2(String value) {
        this.benfaddr2 = value;
    }

    /**
     * Gets the value of the benfaddr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENFADDR3() {
        return benfaddr3;
    }

    /**
     * Sets the value of the benfaddr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENFADDR3(String value) {
        this.benfaddr3 = value;
    }

    /**
     * Gets the value of the benfaddr4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENFADDR4() {
        return benfaddr4;
    }

    /**
     * Sets the value of the benfaddr4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENFADDR4(String value) {
        this.benfaddr4 = value;
    }

    /**
     * Gets the value of the crno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRNO() {
        return crno;
    }

    /**
     * Sets the value of the crno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRNO(String value) {
        this.crno = value;
    }

    /**
     * Gets the value of the isb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISB() {
        return isb;
    }

    /**
     * Sets the value of the isb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISB(String value) {
        this.isb = value;
    }

    /**
     * Gets the value of the otherdetls1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLS1() {
        return otherdetls1;
    }

    /**
     * Sets the value of the otherdetls1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLS1(String value) {
        this.otherdetls1 = value;
    }

    /**
     * Gets the value of the otherdetlstype1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLSTYPE1() {
        return otherdetlstype1;
    }

    /**
     * Sets the value of the otherdetlstype1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLSTYPE1(String value) {
        this.otherdetlstype1 = value;
    }

    /**
     * Gets the value of the otherdetls2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLS2() {
        return otherdetls2;
    }

    /**
     * Sets the value of the otherdetls2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLS2(String value) {
        this.otherdetls2 = value;
    }

    /**
     * Gets the value of the otherdetlstype2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLSTYPE2() {
        return otherdetlstype2;
    }

    /**
     * Sets the value of the otherdetlstype2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLSTYPE2(String value) {
        this.otherdetlstype2 = value;
    }

    /**
     * Gets the value of the otherdetls3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLS3() {
        return otherdetls3;
    }

    /**
     * Sets the value of the otherdetls3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLS3(String value) {
        this.otherdetls3 = value;
    }

    /**
     * Gets the value of the otherdetlstype3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLSTYPE3() {
        return otherdetlstype3;
    }

    /**
     * Sets the value of the otherdetlstype3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLSTYPE3(String value) {
        this.otherdetlstype3 = value;
    }

    /**
     * Gets the value of the otherdetls4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLS4() {
        return otherdetls4;
    }

    /**
     * Sets the value of the otherdetls4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLS4(String value) {
        this.otherdetls4 = value;
    }

    /**
     * Gets the value of the otherdetlstype4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLSTYPE4() {
        return otherdetlstype4;
    }

    /**
     * Sets the value of the otherdetlstype4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLSTYPE4(String value) {
        this.otherdetlstype4 = value;
    }

    /**
     * Gets the value of the otherdetls5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLS5() {
        return otherdetls5;
    }

    /**
     * Sets the value of the otherdetls5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLS5(String value) {
        this.otherdetls5 = value;
    }

    /**
     * Gets the value of the otherdetlstype5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLSTYPE5() {
        return otherdetlstype5;
    }

    /**
     * Sets the value of the otherdetlstype5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLSTYPE5(String value) {
        this.otherdetlstype5 = value;
    }

    /**
     * Gets the value of the otherdetls6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLS6() {
        return otherdetls6;
    }

    /**
     * Sets the value of the otherdetls6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLS6(String value) {
        this.otherdetls6 = value;
    }

    /**
     * Gets the value of the otherdetlstype6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERDETLSTYPE6() {
        return otherdetlstype6;
    }

    /**
     * Sets the value of the otherdetlstype6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERDETLSTYPE6(String value) {
        this.otherdetlstype6 = value;
    }

}
