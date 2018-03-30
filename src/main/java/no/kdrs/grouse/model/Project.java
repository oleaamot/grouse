package no.kdrs.grouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by tsodring on 9/8/17.
 */

@Entity
@Table(name = "projects")
@XmlRootElement
public class Project {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id", nullable = false, updatable = false)
    private Long id;

    /**
     * Acts as a secondary key for a row of information. project_number
     * is what you search on. Normally automatically set to a UUID
     */
    @Column(name = "project_number")
    private String projectNumber;

    /**
     * Assignable descriptive name to the project e.g
     * 'Eksempel kommune nytt sak/arkiv system 2017'
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * Name of the requirements document
     */
    @Column(name = "file_name")
    private String fileName;


    @OneToMany(mappedBy = "referenceProject", fetch = FetchType.LAZY)
    private List<ProjectRequirement> referenceProjectRequirement;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",
            referencedColumnName = "username")
    private GrouseUser referenceUser;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectNumber='" + projectNumber + '\'' +
                ", projectName='" + projectName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
