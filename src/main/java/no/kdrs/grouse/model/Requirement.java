package no.kdrs.grouse.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tsodring on 9/8/17.
 */

@Entity
@Table(name = "requirements")
@XmlRootElement
public class Requirement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * requirement (no:kravnr)
     * An actual requirement number from the standard
     * e.g 5.2.1
     */
    @Id
    @Column(name = "requirement_number", nullable = false, updatable = false)
    private String requirementNumber;


    /**
     * noarkVersion (no:noarkVersjon)
     * The Noark version the requirement belongs to
     * e.g n5v31, n5v4
     */
    @Column(name = "noark_version")
    private String noarkVersion;


    /**
     * requirementType (no:kravtype)
     * A mandatory requirement, 'O'
     *  e.g 'B','Obligatorisk for sakarkiver' where
     *  'B' is requirementType and
     *  'Obligatorisk for sakarkiver' is explanation
     */
    @Column(name = "requirement_type")
    private String requirementType;


    /**
     * requirementText (no:tekst)*
     */
    @Column(name = "requirement_text")
    private String requirementText;

    /**
     * explanation (no:forklaring)
     * See requirementType
     */
    @Column(name = "explanation")
    private String explanation;


    /**
     * consequence (no:konsekvens)
     *
     * The requirement may have an additional consequence that has to be dealt with, this is described here
     */
    @Column(name = "consequence")
    private String consequence;

    /**
     * conformityLevel (no:konformitetsnivaa)
     *
     * This is in relation to n5v4 that introduces conformityLevel
     */
    @Column(name = "conformity_level")
    private String conformityLevel;

     /**
     * priority (no:prioritet)
     *
     * An assigned values as to how important this is in the requirements specifcation
     * e.g.
     *   O - Obligatorisk
     *   1 - Svært viktig for oppdragsgiver
     *   2 - Viktig for oppdragsgiver
     */
    @Column(name = "priority")
    private String priority;

    /**
     * referenceRequirement (no:referansekrav)
     *
     * Foreign key for a 1:m relationship where a requirement can have dependencies to many other requirements
     */
    @Column(name = "reference_requirement")
    private String referenceRequirement;

    @XmlTransient
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="requirements")
    private Set<Project> projects = new HashSet<>();

    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "functionality",
            referencedColumnName = "functionality_number"
    )
    private Functionality functionality;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRequirementNumber() {
        return requirementNumber;
    }

    public void setRequirementNumber(String requirementNumber) {
        this.requirementNumber = requirementNumber;
    }

    public String getNoarkVersion() {
        return noarkVersion;
    }

    public void setNoarkVersion(String noarkVersion) {
        this.noarkVersion = noarkVersion;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementText() {
        return requirementText;
    }

    public void setRequirementText(String requirementText) {
        this.requirementText = requirementText;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public String getConformityLevel() {
        return conformityLevel;
    }

    public void setConformityLevel(String conformityLevel) {
        this.conformityLevel = conformityLevel;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getReferenceRequirement() {
        return referenceRequirement;
    }

    public void setReferenceRequirement(String referenceRequirement) {
        this.referenceRequirement = referenceRequirement;
    }

/*
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
*/
    @XmlTransient
    public Functionality getFunctionality() {
        return functionality;
    }

    @XmlTransient
    public void setFunctionality(Functionality functionality) {
        this.functionality = functionality;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                ", requirementNumber='" + requirementNumber + '\'' +
                ", noarkVersion='" + noarkVersion + '\'' +
                ", requirementType='" + requirementType + '\'' +
                ", explanation='" + explanation + '\'' +
                ", consequence='" + consequence + '\'' +
                ", conformityLevel='" + conformityLevel + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
