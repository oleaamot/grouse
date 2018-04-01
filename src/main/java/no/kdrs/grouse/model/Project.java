package no.kdrs.grouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by tsodring on 9/8/17.
 */

@Entity
@Table(name = "projects")
@XmlRootElement
public class Project
        extends ResourceSupport {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id", nullable = false, updatable = false)
    private Long projectId;

    /**
     * Assignable descriptive name to the project e.g
     * 'Eksempel kommune nytt sak/arkiv system 2017'
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * Name of the organisation
     */
    @Column(name = "organisation_name")
    private String organisationName;

    /**
     * Name of the requirements document
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * The date the project was created
     */
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    /**
     * The date the project was accessed
     */
    @Column(name = "changed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "referenceProject", fetch = FetchType.LAZY)
    private List<ProjectRequirement> referenceProjectRequirement;

    @JsonIgnore
    @OneToMany(mappedBy = "referenceProject", fetch = FetchType.LAZY)
    private List<ProjectFunctionality> referenceProjectFunctionality;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",
            referencedColumnName = "username")
    private GrouseUser referenceUser;

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public List<ProjectRequirement> getReferenceProjectRequirement() {
        return referenceProjectRequirement;
    }

    public void setReferenceProjectRequirement(List<ProjectRequirement> referenceProjectRequirement) {
        this.referenceProjectRequirement = referenceProjectRequirement;
    }

    public GrouseUser getReferenceUser() {
        return referenceUser;
    }

    public void setReferenceUser(GrouseUser referenceUser) {
        this.referenceUser = referenceUser;
    }

    public List<ProjectFunctionality> getReferenceProjectFunctionality() {
        return referenceProjectFunctionality;
    }

    public void setReferenceProjectFunctionality(
            List<ProjectFunctionality> referenceProjectFunctionality) {
        this.referenceProjectFunctionality = referenceProjectFunctionality;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", organisationName='" + organisationName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createdDate=" + createdDate +
                ", changedDate=" + changedDate +
                '}';
    }
}
