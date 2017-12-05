//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.18 at 10:56:38 PM EET 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="dance" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="type" type="{}type"/>
 *                   &lt;element name="scene" type="{}scene"/>
 *                   &lt;element name="numberOfDancers" type="{}numberOfDancers"/>
 *                   &lt;element name="music" type="{}music"/>
 *                   &lt;element name="dancers" type="{}dancers"/>
 *                   &lt;element name="number">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="50"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
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
    "dance"
})
@XmlRootElement(name = "dances")
public class Dances {

    @XmlElement(required = true)
    protected List<Dances.Dance> dance;

    /**
     * Gets the value of the dance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dances.Dance }
     * 
     * 
     */
    public List<Dances.Dance> getDance() {
        if (dance == null) {
            dance = new ArrayList<Dances.Dance>();
        }
        return this.dance;
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
     *         &lt;element name="type" type="{}type"/>
     *         &lt;element name="scene" type="{}scene"/>
     *         &lt;element name="numberOfDancers" type="{}numberOfDancers"/>
     *         &lt;element name="music" type="{}music"/>
     *         &lt;element name="dancers" type="{}dancers"/>
     *         &lt;element name="number">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="50"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "scene",
        "numberOfDancers",
        "music",
        "dancers",
        "number"
    })
    public static class Dance {

        @XmlElement(required = true)
        protected Type type;
        @XmlElement(required = true)
        protected Scene scene;
        @XmlElement(required = true)
        protected NumberOfDancers numberOfDancers;
        @XmlElement(required = true)
        protected Music music;
        @XmlElement(required = true)
        protected Dancers dancers;
        protected int number;
        @XmlAttribute(name = "id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link Type }
         *     
         */
        public Type getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link Type }
         *     
         */
        public void setType(Type value) {
            this.type = value;
        }

        /**
         * Gets the value of the scene property.
         * 
         * @return
         *     possible object is
         *     {@link Scene }
         *     
         */
        public Scene getScene() {
            return scene;
        }

        /**
         * Sets the value of the scene property.
         * 
         * @param value
         *     allowed object is
         *     {@link Scene }
         *     
         */
        public void setScene(Scene value) {
            this.scene = value;
        }

        /**
         * Gets the value of the numberOfDancers property.
         * 
         * @return
         *     possible object is
         *     {@link NumberOfDancers }
         *     
         */
        public NumberOfDancers getNumberOfDancers() {
            return numberOfDancers;
        }

        /**
         * Sets the value of the numberOfDancers property.
         * 
         * @param value
         *     allowed object is
         *     {@link NumberOfDancers }
         *     
         */
        public void setNumberOfDancers(NumberOfDancers value) {
            this.numberOfDancers = value;
        }

        /**
         * Gets the value of the music property.
         * 
         * @return
         *     possible object is
         *     {@link Music }
         *     
         */
        public Music getMusic() {
            return music;
        }

        /**
         * Sets the value of the music property.
         * 
         * @param value
         *     allowed object is
         *     {@link Music }
         *     
         */
        public void setMusic(Music value) {
            this.music = value;
        }

        /**
         * Gets the value of the dancers property.
         * 
         * @return
         *     possible object is
         *     {@link Dancers }
         *     
         */
        public Dancers getDancers() {
            return dancers;
        }

        /**
         * Sets the value of the dancers property.
         * 
         * @param value
         *     allowed object is
         *     {@link Dancers }
         *     
         */
        public void setDancers(Dancers value) {
            this.dancers = value;
        }

        /**
         * Gets the value of the number property.
         * 
         */
        public int getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         */
        public void setNumber(int value) {
            this.number = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }

}
