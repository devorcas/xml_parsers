//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.18 at 10:56:38 PM EET 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for scene.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="scene">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="assembly hall"/>
 *     &lt;enumeration value="outdoor playground"/>
 *     &lt;enumeration value="TV studio"/>
 *     &lt;enumeration value="stadium"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "scene")
@XmlEnum
public enum Scene {

    @XmlEnumValue("assembly hall")
    ASSEMBLY_HALL("assembly hall"),
    @XmlEnumValue("outdoor playground")
    OUTDOOR_PLAYGROUND("outdoor playground"),
    @XmlEnumValue("TV studio")
    TV_STUDIO("TV studio"),
    @XmlEnumValue("stadium")
    STADIUM("stadium");
    private final String value;

    Scene(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Scene fromValue(String v) {
        for (Scene c: Scene.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
