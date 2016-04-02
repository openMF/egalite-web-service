
package com.ofss.fcubs.service.fcubsrtservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProdMisDetails-Full-Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProdMisDetails-Full-Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MISGRP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POOLCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CSTCD1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CSTCD2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CSTCD4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CSTCD5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Default-Mis-Codes" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MISCLS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MISCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ProdMisDetails-Full-Type", propOrder = {
    "misgrp",
    "poolcd",
    "cstcd1",
    "cstcd2",
    "cstcd4",
    "cstcd5",
    "defaultMisCodes"
})
public class ProdMisDetailsFullType {

    @XmlElement(name = "MISGRP")
    protected String misgrp;
    @XmlElement(name = "POOLCD")
    protected String poolcd;
    @XmlElement(name = "CSTCD1")
    protected String cstcd1;
    @XmlElement(name = "CSTCD2")
    protected String cstcd2;
    @XmlElement(name = "CSTCD4")
    protected String cstcd4;
    @XmlElement(name = "CSTCD5")
    protected String cstcd5;
    @XmlElement(name = "Default-Mis-Codes")
    protected List<ProdMisDetailsFullType.DefaultMisCodes> defaultMisCodes;

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
     * Gets the value of the cstcd1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSTCD1() {
        return cstcd1;
    }

    /**
     * Sets the value of the cstcd1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSTCD1(String value) {
        this.cstcd1 = value;
    }

    /**
     * Gets the value of the cstcd2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSTCD2() {
        return cstcd2;
    }

    /**
     * Sets the value of the cstcd2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSTCD2(String value) {
        this.cstcd2 = value;
    }

    /**
     * Gets the value of the cstcd4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSTCD4() {
        return cstcd4;
    }

    /**
     * Sets the value of the cstcd4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSTCD4(String value) {
        this.cstcd4 = value;
    }

    /**
     * Gets the value of the cstcd5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSTCD5() {
        return cstcd5;
    }

    /**
     * Sets the value of the cstcd5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSTCD5(String value) {
        this.cstcd5 = value;
    }

    /**
     * Gets the value of the defaultMisCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the defaultMisCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefaultMisCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProdMisDetailsFullType.DefaultMisCodes }
     * 
     * 
     */
    public List<ProdMisDetailsFullType.DefaultMisCodes> getDefaultMisCodes() {
        if (defaultMisCodes == null) {
            defaultMisCodes = new ArrayList<ProdMisDetailsFullType.DefaultMisCodes>();
        }
        return this.defaultMisCodes;
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
     *         &lt;element name="MISCLS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="MISCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "miscls",
        "miscd"
    })
    public static class DefaultMisCodes {

        @XmlElement(name = "MISCLS")
        protected String miscls;
        @XmlElement(name = "MISCD")
        protected String miscd;

        /**
         * Gets the value of the miscls property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMISCLS() {
            return miscls;
        }

        /**
         * Sets the value of the miscls property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMISCLS(String value) {
            this.miscls = value;
        }

        /**
         * Gets the value of the miscd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMISCD() {
            return miscd;
        }

        /**
         * Sets the value of the miscd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMISCD(String value) {
            this.miscd = value;
        }

    }

}
