package no.kdrs.grouse.service.interfaces;


import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.model.ProjectRequirement;

import java.util.List;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IProjectService {
    List<Project> findAll(String projectOwner);
    Project findById(Long id);
    Project save(Project Project);
    Project update(Long id, Project Project) throws Exception;
    void delete(Long id);
    void deleteProjectRequirement(String projectNumber,
                                  String requirementNumber);
    List<ProjectRequirement> findByProjectNumberOrderByProjectName (
            String projectNumber, String functionalityNumber);

}
