
package com.ofss.fcubs.service.fcubsrtservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UDFDETAILSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UDFDETAILSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FUNCTIONID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIELD_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DATATYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIELD_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VAL_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UDFDETAILSType", propOrder = {
    "functionid",
    "fieldname",
    "datatype",
    "fieldvalue",
    "valtype"
})
public class UDFDETAILSType {

    @XmlElement(name = "FUNCTIONID")
    protected String functionid;
    @XmlElement(name = "FIELD_NAME", required = true)
    protected String fieldname;
    @XmlElement(name = "DATATYPE")
    protected String datatype;
    @XmlElement(name = "FIELD_VALUE")
    protected String fieldvalue;
    @XmlElement(name = "VAL_TYPE")
    protected String valtype;

    /**
     * Gets the value of the functionid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNCTIONID() {
        return functionid;
    }

    /**
     * Sets the value of the functionid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNCTIONID(String value) {
        this.functionid = value;
    }

    /**
     * Gets the value of the fieldname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDNAME() {
        return fieldname;
    }

    /**
     * Sets the value of the fieldname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDNAME(String value) {
        this.fieldname = value;
    }

    /**
     * Gets the value of the datatype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATATYPE() {
        return datatype;
    }

    /**
     * Sets the value of the datatype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATATYPE(String value) {
        this.datatype = value;
    }

    /**
     * Gets the value of the fieldvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDVALUE() {
        return fieldvalue;
    }

    /**
     * Sets the value of the fieldvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDVALUE(String value) {
        this.fieldvalue = value;
    }

    /**
     * Gets the value of the valtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALTYPE() {
        return valtype;
    }

    /**
     * Sets the value of the valtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALTYPE(String value) {
        this.valtype = value;
    }

}
