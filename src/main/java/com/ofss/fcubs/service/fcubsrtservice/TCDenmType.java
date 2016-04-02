
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TCDenmType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCDenmType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TCDESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TCCOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SYSCOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SNO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="STARTNO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ENDNO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TCIDDENM" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="INOUTIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TCCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISSCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCDenmType", propOrder = {
    "tcdesc",
    "tccount",
    "syscount",
    "sno",
    "startno",
    "endno",
    "tcamt",
    "tciddenm",
    "inoutind",
    "tcccy",
    "isscode"
})
public class TCDenmType {

    @XmlElement(name = "TCDESC")
    protected String tcdesc;
    @XmlElement(name = "TCCOUNT")
    protected BigDecimal tccount;
    @XmlElement(name = "SYSCOUNT")
    protected BigDecimal syscount;
    @XmlElement(name = "SNO")
    protected BigDecimal sno;
    @XmlElement(name = "STARTNO")
    protected BigDecimal startno;
    @XmlElement(name = "ENDNO")
    protected BigDecimal endno;
    @XmlElement(name = "TCAMT")
    protected BigDecimal tcamt;
    @XmlElement(name = "TCIDDENM")
    protected BigDecimal tciddenm;
    @XmlElement(name = "INOUTIND")
    protected String inoutind;
    @XmlElement(name = "TCCCY")
    protected String tcccy;
    @XmlElement(name = "ISSCODE")
    protected String isscode;

    /**
     * Gets the value of the tcdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTCDESC() {
        return tcdesc;
    }

    /**
     * Sets the value of the tcdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTCDESC(String value) {
        this.tcdesc = value;
    }

    /**
     * Gets the value of the tccount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCCOUNT() {
        return tccount;
    }

    /**
     * Sets the value of the tccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCCOUNT(BigDecimal value) {
        this.tccount = value;
    }

    /**
     * Gets the value of the syscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSYSCOUNT() {
        return syscount;
    }

    /**
     * Sets the value of the syscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSYSCOUNT(BigDecimal value) {
        this.syscount = value;
    }

    /**
     * Gets the value of the sno property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSNO() {
        return sno;
    }

    /**
     * Sets the value of the sno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSNO(BigDecimal value) {
        this.sno = value;
    }

    /**
     * Gets the value of the startno property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSTARTNO() {
        return startno;
    }

    /**
     * Sets the value of the startno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSTARTNO(BigDecimal value) {
        this.startno = value;
    }

    /**
     * Gets the value of the endno property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getENDNO() {
        return endno;
    }

    /**
     * Sets the value of the endno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setENDNO(BigDecimal value) {
        this.endno = value;
    }

    /**
     * Gets the value of the tcamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCAMT() {
        return tcamt;
    }

    /**
     * Sets the value of the tcamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCAMT(BigDecimal value) {
        this.tcamt = value;
    }

    /**
     * Gets the value of the tciddenm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTCIDDENM() {
        return tciddenm;
    }

    /**
     * Sets the value of the tciddenm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTCIDDENM(BigDecimal value) {
        this.tciddenm = value;
    }

    /**
     * Gets the value of the inoutind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINOUTIND() {
        return inoutind;
    }

    /**
     * Sets the value of the inoutind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINOUTIND(String value) {
        this.inoutind = value;
    }

    /**
     * Gets the value of the tcccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTCCCY() {
        return tcccy;
    }

    /**
     * Sets the value of the tcccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTCCCY(String value) {
        this.tcccy = value;
    }

    /**
     * Gets the value of the isscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSCODE() {
        return isscode;
    }

    /**
     * Sets the value of the isscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSCODE(String value) {
        this.isscode = value;
    }

}
