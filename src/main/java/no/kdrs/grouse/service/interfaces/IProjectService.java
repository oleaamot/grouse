package no.kdrs.grouse.service.interfaces;


import no.kdrs.grouse.model.GrouseUser;
import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.model.ProjectRequirement;

import java.util.List;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IProjectService {
    List<Project> findAll();
    Project findById(Long id);
    //Project createProject(Project Project);
    void createProject_A(Project Project);
    void createProject_B(Project Project);
    void createProject_C(Project Project);
    Project update(Long id, Project Project) throws Exception;
    void delete(Long id);
    List<Project> findByReferenceUser (GrouseUser user);
    List<ProjectRequirement> findByProjectIdOrderByProjectName (
            Long projectId, String functionalityNumber);
    List<ProjectFunctionality> findFunctionalityForProject(Long projectId);

}
