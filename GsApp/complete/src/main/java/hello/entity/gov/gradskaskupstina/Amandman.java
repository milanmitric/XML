//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.02 at 07:17:21 PM CEST 
//


package hello.entity.gov.gradskaskupstina;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="PravniOsnov" type="{http://www.gradskaskupstina.gov/}TReferenca"/>
 *         &lt;element name="Akt" type="{http://www.gradskaskupstina.gov/}TReferenca"/>
 *         &lt;element name="Amandman" type="{http://www.gradskaskupstina.gov/}TAmandman" maxOccurs="unbounded"/>
 *         &lt;element name="Potpisnici" type="{http://www.gradskaskupstina.gov/}TPotpisnici"/>
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
    "pravniOsnov",
    "akt",
    "amandman",
    "potpisnici"
})
@XmlRootElement(name = "Amandman")
public class Amandman {

    @XmlElement(name = "PravniOsnov", required = true)
    protected TReferenca pravniOsnov;
    @XmlElement(name = "Akt", required = true)
    protected TReferenca akt;
    @XmlElement(name = "Amandman", required = true)
    protected List<TAmandman> amandman;
    @XmlElement(name = "Potpisnici", required = true)
    protected TPotpisnici potpisnici;

    /**
     * Gets the value of the pravniOsnov property.
     * 
     * @return
     *     possible object is
     *     {@link TReferenca }
     *     
     */
    public TReferenca getPravniOsnov() {
        return pravniOsnov;
    }

    /**
     * Sets the value of the pravniOsnov property.
     * 
     * @param value
     *     allowed object is
     *     {@link TReferenca }
     *     
     */
    public void setPravniOsnov(TReferenca value) {
        this.pravniOsnov = value;
    }

    /**
     * Gets the value of the akt property.
     * 
     * @return
     *     possible object is
     *     {@link TReferenca }
     *     
     */
    public TReferenca getAkt() {
        return akt;
    }

    /**
     * Sets the value of the akt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TReferenca }
     *     
     */
    public void setAkt(TReferenca value) {
        this.akt = value;
    }

    /**
     * Gets the value of the amandman property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amandman property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmandman().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAmandman }
     * 
     * 
     */
    public List<TAmandman> getAmandman() {
        if (amandman == null) {
            amandman = new ArrayList<TAmandman>();
        }
        return this.amandman;
    }

    /**
     * Gets the value of the potpisnici property.
     * 
     * @return
     *     possible object is
     *     {@link TPotpisnici }
     *     
     */
    public TPotpisnici getPotpisnici() {
        return potpisnici;
    }

    /**
     * Sets the value of the potpisnici property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPotpisnici }
     *     
     */
    public void setPotpisnici(TPotpisnici value) {
        this.potpisnici = value;
    }

}
