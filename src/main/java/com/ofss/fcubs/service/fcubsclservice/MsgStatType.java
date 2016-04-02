
package com.ofss.fcubs.service.fcubsclservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MsgStatType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MsgStatType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUCCESS"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="FAILURE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MsgStatType")
@XmlEnum
public enum MsgStatType {

    SUCCESS,
    WARNING,
    FAILURE;

    public String value() {
        return name();
    }

    public static MsgStatType fromValue(String v) {
        return valueOf(v);
    }

}
