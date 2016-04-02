
package com.ofss.fcubs.service.fcubsrtservice;

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
 * <p>Java class for Dedrtprm-IO-Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Dedrtprm-IO-Type">
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
 *         &lt;element name="WAREHOUSE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PART_OF_PRODUCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODULE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POOL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LEGS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BRANCHES_LIST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENCIES_LIST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CATEGORIES_LIST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRMLRTVARI" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MAXRTVARI" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PRDTYP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RTCODEPRFERD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RATETYPPRFERED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RTH_CLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASSET_CAT_LIST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCATION_LIST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GEN_MT103P" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INCLUDE_TDS_CALC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INSTR_PROD_ALLOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROTFOLIO_PROD_ALLOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAKER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MMAKERSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKERSTAMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODNO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AUTHSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXNSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ONCEAUTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RT-Product-Preference">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PRDCD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="RDPAYMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CASHGLPOST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TRACKRECV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TXNLIMIT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProductUDF" type="{http://fcubs.ofss.com/service/FCUBSRTService}ProductUDF-Create-IO-Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProductMISDetails" type="{http://fcubs.ofss.com/service/FCUBSRTService}ProdMisDetails-Create-IO-Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dedrtprm-IO-Type", propOrder = {
    "prdcd",
    "prddesc",
    "prdslg",
    "prdrmrks",
    "prdstrtdt",
    "prdenddt",
    "prdgrp",
    "warehousecode",
    "partofproduct",
    "module",
    "poolcode",
    "legs",
    "brancheslist",
    "currencieslist",
    "categorieslist",
    "nrmlrtvari",
    "maxrtvari",
    "prdtyp",
    "rtcodeprferd",
    "ratetypprfered",
    "rthclass",
    "assetcatlist",
    "locationlist",
    "genmt103P",
    "includetdscalc",
    "instrprodallow",
    "protfolioprodallow",
    "maker",
    "mmakerstamp",
    "checker",
    "checkerstamp",
    "modno",
    "authstat",
    "txnstat",
    "onceauth",
    "rtProductPreference",
    "productUDF",
    "productMISDetails"
})
public class DedrtprmIOType {

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
    @XmlElement(name = "WAREHOUSE_CODE")
    protected String warehousecode;
    @XmlElement(name = "PART_OF_PRODUCT")
    protected String partofproduct;
    @XmlElement(name = "MODULE")
    protected String module;
    @XmlElement(name = "POOL_CODE")
    protected String poolcode;
    @XmlElement(name = "LEGS")
    protected BigDecimal legs;
    @XmlElement(name = "BRANCHES_LIST")
    protected String brancheslist;
    @XmlElement(name = "CURRENCIES_LIST")
    protected String currencieslist;
    @XmlElement(name = "CATEGORIES_LIST")
    protected String categorieslist;
    @XmlElement(name = "NRMLRTVARI", required = true)
    protected BigDecimal nrmlrtvari;
    @XmlElement(name = "MAXRTVARI", required = true)
    protected BigDecimal maxrtvari;
    @XmlElement(name = "PRDTYP", required = true)
    protected String prdtyp;
    @XmlElement(name = "RTCODEPRFERD", required = true)
    protected String rtcodeprferd;
    @XmlElement(name = "RATETYPPRFERED")
    protected String ratetypprfered;
    @XmlElement(name = "RTH_CLASS")
    protected String rthclass;
    @XmlElement(name = "ASSET_CAT_LIST")
    protected String assetcatlist;
    @XmlElement(name = "LOCATION_LIST")
    protected String locationlist;
    @XmlElement(name = "GEN_MT103P")
    protected String genmt103P;
    @XmlElement(name = "INCLUDE_TDS_CALC")
    protected String includetdscalc;
    @XmlElement(name = "INSTR_PROD_ALLOW")
    protected String instrprodallow;
    @XmlElement(name = "PROTFOLIO_PROD_ALLOW")
    protected String protfolioprodallow;
    @XmlElement(name = "MAKER")
    protected String maker;
    @XmlElement(name = "MMAKERSTAMP")
    protected String mmakerstamp;
    @XmlElement(name = "CHECKER")
    protected String checker;
    @XmlElement(name = "CHECKERSTAMP")
    protected String checkerstamp;
    @XmlElement(name = "MODNO")
    protected BigDecimal modno;
    @XmlElement(name = "AUTHSTAT")
    protected String authstat;
    @XmlElement(name = "TXNSTAT")
    protected String txnstat;
    @XmlElement(name = "ONCEAUTH")
    protected String onceauth;
    @XmlElement(name = "RT-Product-Preference", required = true)
    protected DedrtprmIOType.RTProductPreference rtProductPreference;
    @XmlElement(name = "ProductUDF")
    protected List<ProductUDFCreateIOType> productUDF;
    @XmlElement(name = "ProductMISDetails")
    protected ProdMisDetailsCreateIOType productMISDetails;

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
     * Gets the value of the warehousecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWAREHOUSECODE() {
        return warehousecode;
    }

    /**
     * Sets the value of the warehousecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWAREHOUSECODE(String value) {
        this.warehousecode = value;
    }

    /**
     * Gets the value of the partofproduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTOFPRODUCT() {
        return partofproduct;
    }

    /**
     * Sets the value of the partofproduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTOFPRODUCT(String value) {
        this.partofproduct = value;
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
     * Gets the value of the poolcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOOLCODE() {
        return poolcode;
    }

    /**
     * Sets the value of the poolcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOOLCODE(String value) {
        this.poolcode = value;
    }

    /**
     * Gets the value of the legs property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLEGS() {
        return legs;
    }

    /**
     * Sets the value of the legs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLEGS(BigDecimal value) {
        this.legs = value;
    }

    /**
     * Gets the value of the brancheslist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRANCHESLIST() {
        return brancheslist;
    }

    /**
     * Sets the value of the brancheslist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRANCHESLIST(String value) {
        this.brancheslist = value;
    }

    /**
     * Gets the value of the currencieslist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENCIESLIST() {
        return currencieslist;
    }

    /**
     * Sets the value of the currencieslist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENCIESLIST(String value) {
        this.currencieslist = value;
    }

    /**
     * Gets the value of the categorieslist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCATEGORIESLIST() {
        return categorieslist;
    }

    /**
     * Sets the value of the categorieslist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCATEGORIESLIST(String value) {
        this.categorieslist = value;
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
     * Gets the value of the prdtyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDTYP() {
        return prdtyp;
    }

    /**
     * Sets the value of the prdtyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDTYP(String value) {
        this.prdtyp = value;
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
     * Gets the value of the rthclass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRTHCLASS() {
        return rthclass;
    }

    /**
     * Sets the value of the rthclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRTHCLASS(String value) {
        this.rthclass = value;
    }

    /**
     * Gets the value of the assetcatlist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSETCATLIST() {
        return assetcatlist;
    }

    /**
     * Sets the value of the assetcatlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSETCATLIST(String value) {
        this.assetcatlist = value;
    }

    /**
     * Gets the value of the locationlist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCATIONLIST() {
        return locationlist;
    }

    /**
     * Sets the value of the locationlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCATIONLIST(String value) {
        this.locationlist = value;
    }

    /**
     * Gets the value of the genmt103P property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGENMT103P() {
        return genmt103P;
    }

    /**
     * Sets the value of the genmt103P property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGENMT103P(String value) {
        this.genmt103P = value;
    }

    /**
     * Gets the value of the includetdscalc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDETDSCALC() {
        return includetdscalc;
    }

    /**
     * Sets the value of the includetdscalc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDETDSCALC(String value) {
        this.includetdscalc = value;
    }

    /**
     * Gets the value of the instrprodallow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTRPRODALLOW() {
        return instrprodallow;
    }

    /**
     * Sets the value of the instrprodallow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTRPRODALLOW(String value) {
        this.instrprodallow = value;
    }

    /**
     * Gets the value of the protfolioprodallow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROTFOLIOPRODALLOW() {
        return protfolioprodallow;
    }

    /**
     * Sets the value of the protfolioprodallow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROTFOLIOPRODALLOW(String value) {
        this.protfolioprodallow = value;
    }

    /**
     * Gets the value of the maker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAKER() {
        return maker;
    }

    /**
     * Sets the value of the maker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAKER(String value) {
        this.maker = value;
    }

    /**
     * Gets the value of the mmakerstamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMMAKERSTAMP() {
        return mmakerstamp;
    }

    /**
     * Sets the value of the mmakerstamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMMAKERSTAMP(String value) {
        this.mmakerstamp = value;
    }

    /**
     * Gets the value of the checker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECKER() {
        return checker;
    }

    /**
     * Sets the value of the checker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECKER(String value) {
        this.checker = value;
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
     * Gets the value of the onceauth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getONCEAUTH() {
        return onceauth;
    }

    /**
     * Sets the value of the onceauth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setONCEAUTH(String value) {
        this.onceauth = value;
    }

    /**
     * Gets the value of the rtProductPreference property.
     * 
     * @return
     *     possible object is
     *     {@link DedrtprmIOType.RTProductPreference }
     *     
     */
    public DedrtprmIOType.RTProductPreference getRTProductPreference() {
        return rtProductPreference;
    }

    /**
     * Sets the value of the rtProductPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DedrtprmIOType.RTProductPreference }
     *     
     */
    public void setRTProductPreference(DedrtprmIOType.RTProductPreference value) {
        this.rtProductPreference = value;
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
     * {@link ProductUDFCreateIOType }
     * 
     * 
     */
    public List<ProductUDFCreateIOType> getProductUDF() {
        if (productUDF == null) {
            productUDF = new ArrayList<ProductUDFCreateIOType>();
        }
        return this.productUDF;
    }

    /**
     * Gets the value of the productMISDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ProdMisDetailsCreateIOType }
     *     
     */
    public ProdMisDetailsCreateIOType getProductMISDetails() {
        return productMISDetails;
    }

    /**
     * Sets the value of the productMISDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdMisDetailsCreateIOType }
     *     
     */
    public void setProductMISDetails(ProdMisDetailsCreateIOType value) {
        this.productMISDetails = value;
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
     *         &lt;element name="PRDCD" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="RDPAYMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CASHGLPOST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TRACKRECV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TXNLIMIT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
        "prdcd",
        "rdpayment",
        "cashglpost",
        "trackrecv",
        "txnlimit"
    })
    public static class RTProductPreference {

        @XmlElement(name = "PRDCD", required = true)
        protected String prdcd;
        @XmlElement(name = "RDPAYMENT")
        protected String rdpayment;
        @XmlElement(name = "CASHGLPOST")
        protected String cashglpost;
        @XmlElement(name = "TRACKRECV")
        protected String trackrecv;
        @XmlElement(name = "TXNLIMIT")
        protected BigDecimal txnlimit;

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
         * Gets the value of the rdpayment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRDPAYMENT() {
            return rdpayment;
        }

        /**
         * Sets the value of the rdpayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRDPAYMENT(String value) {
            this.rdpayment = value;
        }

        /**
         * Gets the value of the cashglpost property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCASHGLPOST() {
            return cashglpost;
        }

        /**
         * Sets the value of the cashglpost property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCASHGLPOST(String value) {
            this.cashglpost = value;
        }

        /**
         * Gets the value of the trackrecv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTRACKRECV() {
            return trackrecv;
        }

        /**
         * Sets the value of the trackrecv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTRACKRECV(String value) {
            this.trackrecv = value;
        }

        /**
         * Gets the value of the txnlimit property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTXNLIMIT() {
            return txnlimit;
        }

        /**
         * Sets the value of the txnlimit property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTXNLIMIT(BigDecimal value) {
            this.txnlimit = value;
        }

    }

}
