package no.kdrs.grouse.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tsodring on 29/03/18.
 *
 * A copy of the fields in Requirements, with a project number. When creating a
 * project, we need to be able to copy all the fields from requirements to
 * project_requirements and associate the copy of the requirements with a
 * project number. This is because the user can change the text, add
 * additional requirements etc.
 *
 * The logic is simpler to implement if we do it this way rather than
 * tracking the requirements that have changed. That's why this approach was
 * chosen. Over time the requirements table might change and dealing or
 * not dealing with such changes might not be the expected functionality. So
 * copying the values from requirements to project_requirements reflects how
 * things were when the project was created.
 *
 */

@Entity
@Table(name = "project_requirements")
public class ProjectRequirement
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    /**
     * order (no:kravtype)
     * Used to identify an order that the requirements have to follow
     * Order == 0, is a formål
     */
    @Column(name = "show_order")
    private Integer order;

    /**
     * requirementText (no:tekst)*
     */
    @Column(name = "requirement_text", length = 10000)
    private String requirementText;

     /**
     * priority (no:prioritet)
     *
      * An assigned values as to how important this is in the requirements
      * specifcation
     * e.g.
     *   O - Obligatorisk
     *   1 - Svært viktig for oppdragsgiver
     *   2 - Viktig for oppdragsgiver
     */
    @Column(name = "priority")
    private String priority;

    /**
     * requirement (no:kravnr)
     * An actual requirement number from the standard
     * e.g 5.2.1
     */
    @Column(name = "noark_requirement_number")
    private String requirementNumber;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functionality",
            referencedColumnName = "functionality_number")
    private Functionality referenceFunctionality;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_number",
            referencedColumnName = "project_id")
    private Project referenceProject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getRequirementText() {
        return requirementText;
    }

    public void setRequirementText(String requirementText) {
        this.requirementText = requirementText;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRequirementNumber() {
        return requirementNumber;
    }

    public void setRequirementNumber(String requirementNumber) {
        this.requirementNumber = requirementNumber;
    }

    public Functionality getReferenceFunctionality() {
        return referenceFunctionality;
    }

    public void setReferenceFunctionality(Functionality referenceFunctionality) {
        this.referenceFunctionality = referenceFunctionality;
    }

    public Project getReferenceProject() {
        return referenceProject;
    }

    public void setReferenceProject(Project referenceProject) {
        this.referenceProject = referenceProject;
    }

    @Override
    public String toString() {
        return "ProjectRequirement{" +
                "id=" + id +
                ", order=" + order +
                ", requirementText='" + requirementText + '\'' +
                ", priority='" + priority + '\'' +
                ", requirementNumber='" + requirementNumber + '\'' +
                '}';
    }
}
