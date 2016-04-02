
package com.ofss.fcubs.service.fcubsrtservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="FCUBS_HEADER" type="{http://fcubs.ofss.com/service/FCUBSRTService}FCUBS_HEADERType"/>
 *         &lt;element name="FCUBS_BODY">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Transaction-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}Retail-Teller-Type-Full"/>
 *                   &lt;element name="FCUBS_ERROR_RESP" type="{http://fcubs.ofss.com/service/FCUBSRTService}ERRORType" minOccurs="0"/>
 *                   &lt;element name="FCUBS_WARNING_RESP" type="{http://fcubs.ofss.com/service/FCUBSRTService}WARNINGType" minOccurs="0"/>
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
    "fcubsheader",
    "fcubsbody"
})
@XmlRootElement(name = "CREATETRANSACTION_FSFS_RES")
public class CREATETRANSACTIONFSFSRES {

    @XmlElement(name = "FCUBS_HEADER", required = true)
    protected FCUBSHEADERType fcubsheader;
    @XmlElement(name = "FCUBS_BODY", required = true)
    protected CREATETRANSACTIONFSFSRES.FCUBSBODY fcubsbody;

    /**
     * Gets the value of the fcubsheader property.
     * 
     * @return
     *     possible object is
     *     {@link FCUBSHEADERType }
     *     
     */
    public FCUBSHEADERType getFCUBSHEADER() {
        return fcubsheader;
    }

    /**
     * Sets the value of the fcubsheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link FCUBSHEADERType }
     *     
     */
    public void setFCUBSHEADER(FCUBSHEADERType value) {
        this.fcubsheader = value;
    }

    /**
     * Gets the value of the fcubsbody property.
     * 
     * @return
     *     possible object is
     *     {@link CREATETRANSACTIONFSFSRES.FCUBSBODY }
     *     
     */
    public CREATETRANSACTIONFSFSRES.FCUBSBODY getFCUBSBODY() {
        return fcubsbody;
    }

    /**
     * Sets the value of the fcubsbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link CREATETRANSACTIONFSFSRES.FCUBSBODY }
     *     
     */
    public void setFCUBSBODY(CREATETRANSACTIONFSFSRES.FCUBSBODY value) {
        this.fcubsbody = value;
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
     *         &lt;element name="Transaction-Details" type="{http://fcubs.ofss.com/service/FCUBSRTService}Retail-Teller-Type-Full"/>
     *         &lt;element name="FCUBS_ERROR_RESP" type="{http://fcubs.ofss.com/service/FCUBSRTService}ERRORType" minOccurs="0"/>
     *         &lt;element name="FCUBS_WARNING_RESP" type="{http://fcubs.ofss.com/service/FCUBSRTService}WARNINGType" minOccurs="0"/>
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
        "transactionDetails",
        "fcubserrorresp",
        "fcubswarningresp"
    })
    public static class FCUBSBODY {

        @XmlElement(name = "Transaction-Details", required = true)
        protected RetailTellerTypeFull transactionDetails;
        @XmlElement(name = "FCUBS_ERROR_RESP")
        protected ERRORType fcubserrorresp;
        @XmlElement(name = "FCUBS_WARNING_RESP")
        protected WARNINGType fcubswarningresp;

        /**
         * Gets the value of the transactionDetails property.
         * 
         * @return
         *     possible object is
         *     {@link RetailTellerTypeFull }
         *     
         */
        public RetailTellerTypeFull getTransactionDetails() {
            return transactionDetails;
        }

        /**
         * Sets the value of the transactionDetails property.
         * 
         * @param value
         *     allowed object is
         *     {@link RetailTellerTypeFull }
         *     
         */
        public void setTransactionDetails(RetailTellerTypeFull value) {
            this.transactionDetails = value;
        }

        /**
         * Gets the value of the fcubserrorresp property.
         * 
         * @return
         *     possible object is
         *     {@link ERRORType }
         *     
         */
        public ERRORType getFCUBSERRORRESP() {
            return fcubserrorresp;
        }

        /**
         * Sets the value of the fcubserrorresp property.
         * 
         * @param value
         *     allowed object is
         *     {@link ERRORType }
         *     
         */
        public void setFCUBSERRORRESP(ERRORType value) {
            this.fcubserrorresp = value;
        }

        /**
         * Gets the value of the fcubswarningresp property.
         * 
         * @return
         *     possible object is
         *     {@link WARNINGType }
         *     
         */
        public WARNINGType getFCUBSWARNINGRESP() {
            return fcubswarningresp;
        }

        /**
         * Sets the value of the fcubswarningresp property.
         * 
         * @param value
         *     allowed object is
         *     {@link WARNINGType }
         *     
         */
        public void setFCUBSWARNINGRESP(WARNINGType value) {
            this.fcubswarningresp = value;
        }

    }

}
