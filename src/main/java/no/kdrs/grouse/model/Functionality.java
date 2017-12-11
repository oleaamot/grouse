package no.kdrs.grouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tsodring on 9/11/17.
 */

@Entity
@Table(name = "functionality_areas")
@XmlRootElement
public class Functionality implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    /**
     * Text of the functionality
     *
     * e.g functionality_number '1.7.2.19' has title
     *    'Krav knyttet til masseoppdatering'
     *
     */
    @Column(name = "title")
    private String title;

     /**
     * Number of the functional area. e.g 1.2.3
     *  This is an internal number that the project themselves decides
     *
     */
    @NaturalId
    @Column(name = "functionality_number", unique = true)
    private String functionalityNumber;

    /**
     * Description of functionality
     *
     */
    @Column(name = "description", length = 10000)
    private String description;


    /**
     * Description of consequence of excluding this functionality
     *
     */
    @Column(name = "consequence", length = 10000)
    private String consequence;

    /**
     * Description of consequence of excluding this functionality
     *
     */
    @Column(name = "explanation", length = 10000)
    private String explanation;

    // Link to parent Functionality
    @ManyToOne
    @JoinColumn(name="parent")
    private Functionality referenceParentFunctionality;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFunctionalityNumber() {
        return functionalityNumber;
    }

    public void setFunctionalityNumber(String functionalityNumber) {
        this.functionalityNumber = functionalityNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @JsonIgnore
    public Functionality getReferenceParentFunctionality() {
        return referenceParentFunctionality;
    }

    @XmlTransient
    public void setReferenceParentFunctionality(Functionality referenceParentFunctionality) {
        this.referenceParentFunctionality = referenceParentFunctionality;
    }
}
