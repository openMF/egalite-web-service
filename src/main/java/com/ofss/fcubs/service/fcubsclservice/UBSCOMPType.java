
package com.ofss.fcubs.service.fcubsclservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UBSCOMPType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UBSCOMPType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FCUBS"/>
 *     &lt;enumeration value="FCIS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UBSCOMPType")
@XmlEnum
public enum UBSCOMPType {

    FCUBS,
    FCIS;

    public String value() {
        return name();
    }

    public static UBSCOMPType fromValue(String v) {
        return valueOf(v);
    }

}
