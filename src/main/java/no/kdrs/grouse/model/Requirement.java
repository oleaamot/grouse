package no.kdrs.grouse.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tsodring on 9/8/17.
 */

@Entity
@Table(name = "requirements")
public class Requirement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functionality",
            referencedColumnName = "functionality_number")
    private Functionality referenceFunctionality;

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

    public Functionality getFunctionality() {
        return referenceFunctionality;
    }

    public void setFunctionality(Functionality referenceFunctionality) {
        this.referenceFunctionality = referenceFunctionality;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + id +
                ", order=" + order +
                ", requirementText='" + requirementText + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
