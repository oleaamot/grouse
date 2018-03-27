package no.kdrs.grouse.service;


import no.kdrs.grouse.model.Project;

import java.util.Set;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IProjectService {
    Set findAll(String projectOwner);
    Project findById(Long id);
    Project save(Project Project);
    Project update(Long id, Project Project) throws Exception;
    void delete(Long id);
    // projectNumber
    Project findByProjectNumberOrderByProjectName(String projectNumber);

}
