
package com.ofss.fcubs.service.fcubsrtservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Dedrtprm-Modify-IO-Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Dedrtprm-Modify-IO-Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PRDCD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PRDDESC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PRDSLG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRDRMRKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRDSTRTDT" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="PRDENDDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PRDGRP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NRMLRTVARI" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MAXRTVARI" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RTCODEPRFERD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RATETYPPRFERED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODNO" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ProductUDF" type="{http://fcubs.ofss.com/service/FCUBSRTService}ProductUDF-Modify-IO-Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProductMISDetails" type="{http://fcubs.ofss.com/service/FCUBSRTService}ProdMisDetails-Modify-IO-Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dedrtprm-Modify-IO-Type", propOrder = {
    "prdcd",
    "prddesc",
    "prdslg",
    "prdrmrks",
    "prdstrtdt",
    "prdenddt",
    "prdgrp",
    "nrmlrtvari",
    "maxrtvari",
    "rtcodeprferd",
    "ratetypprfered",
    "modno",
    "productUDF",
    "productMISDetails"
})
public class DedrtprmModifyIOType {

    @XmlElement(name = "PRDCD", required = true)
    protected String prdcd;
    @XmlElement(name = "PRDDESC", required = true)
    protected String prddesc;
    @XmlElement(name = "PRDSLG")
    protected String prdslg;
    @XmlElement(name = "PRDRMRKS")
    protected String prdrmrks;
    @XmlElement(name = "PRDSTRTDT", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar prdstrtdt;
    @XmlElement(name = "PRDENDDT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar prdenddt;
    @XmlElement(name = "PRDGRP", required = true)
    protected String prdgrp;
    @XmlElement(name = "NRMLRTVARI", required = true)
    protected BigDecimal nrmlrtvari;
    @XmlElement(name = "MAXRTVARI", required = true)
    protected BigDecimal maxrtvari;
    @XmlElement(name = "RTCODEPRFERD", required = true)
    protected String rtcodeprferd;
    @XmlElement(name = "RATETYPPRFERED")
    protected String ratetypprfered;
    @XmlElement(name = "MODNO")
    protected BigInteger modno;
    @XmlElement(name = "ProductUDF")
    protected List<ProductUDFModifyIOType> productUDF;
    @XmlElement(name = "ProductMISDetails")
    protected ProdMisDetailsModifyIOType productMISDetails;

    /**
     * Gets the value of the prdcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDCD() {
        return prdcd;
    }

    /**
     * Sets the value of the prdcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDCD(String value) {
        this.prdcd = value;
    }

    /**
     * Gets the value of the prddesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDDESC() {
        return prddesc;
    }

    /**
     * Sets the value of the prddesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDDESC(String value) {
        this.prddesc = value;
    }

    /**
     * Gets the value of the prdslg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDSLG() {
        return prdslg;
    }

    /**
     * Sets the value of the prdslg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDSLG(String value) {
        this.prdslg = value;
    }

    /**
     * Gets the value of the prdrmrks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDRMRKS() {
        return prdrmrks;
    }

    /**
     * Sets the value of the prdrmrks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDRMRKS(String value) {
        this.prdrmrks = value;
    }

    /**
     * Gets the value of the prdstrtdt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPRDSTRTDT() {
        return prdstrtdt;
    }

    /**
     * Sets the value of the prdstrtdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPRDSTRTDT(XMLGregorianCalendar value) {
        this.prdstrtdt = value;
    }

    /**
     * Gets the value of the prdenddt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPRDENDDT() {
        return prdenddt;
    }

    /**
     * Sets the value of the prdenddt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPRDENDDT(XMLGregorianCalendar value) {
        this.prdenddt = value;
    }

    /**
     * Gets the value of the prdgrp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDGRP() {
        return prdgrp;
    }

    /**
     * Sets the value of the prdgrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDGRP(String value) {
        this.prdgrp = value;
    }

    /**
     * Gets the value of the nrmlrtvari property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNRMLRTVARI() {
        return nrmlrtvari;
    }

    /**
     * Sets the value of the nrmlrtvari property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNRMLRTVARI(BigDecimal value) {
        this.nrmlrtvari = value;
    }

    /**
     * Gets the value of the maxrtvari property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMAXRTVARI() {
        return maxrtvari;
    }

    /**
     * Sets the value of the maxrtvari property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMAXRTVARI(BigDecimal value) {
        this.maxrtvari = value;
    }

    /**
     * Gets the value of the rtcodeprferd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRTCODEPRFERD() {
        return rtcodeprferd;
    }

    /**
     * Sets the value of the rtcodeprferd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRTCODEPRFERD(String value) {
        this.rtcodeprferd = value;
    }

    /**
     * Gets the value of the ratetypprfered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRATETYPPRFERED() {
        return ratetypprfered;
    }

    /**
     * Sets the value of the ratetypprfered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRATETYPPRFERED(String value) {
        this.ratetypprfered = value;
    }

    /**
     * Gets the value of the modno property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMODNO() {
        return modno;
    }

    /**
     * Sets the value of the modno property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMODNO(BigInteger value) {
        this.modno = value;
    }

    /**
     * Gets the value of the productUDF property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productUDF property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductUDF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductUDFModifyIOType }
     * 
     * 
     */
    public List<ProductUDFModifyIOType> getProductUDF() {
        if (productUDF == null) {
            productUDF = new ArrayList<ProductUDFModifyIOType>();
        }
        return this.productUDF;
    }

    /**
     * Gets the value of the productMISDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ProdMisDetailsModifyIOType }
     *     
     */
    public ProdMisDetailsModifyIOType getProductMISDetails() {
        return productMISDetails;
    }

    /**
     * Sets the value of the productMISDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdMisDetailsModifyIOType }
     *     
     */
    public void setProductMISDetails(ProdMisDetailsModifyIOType value) {
        this.productMISDetails = value;
    }

}
