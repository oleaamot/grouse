package no.kdrs.grouse.service;


import no.kdrs.grouse.model.Project;

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
    // projectNumber
    Project findByProjectNumberOrderByProjectName(String projectNumber);

}
