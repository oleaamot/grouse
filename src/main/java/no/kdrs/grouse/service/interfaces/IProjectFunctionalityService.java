package no.kdrs.grouse.service.interfaces;

import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.model.ProjectRequirement;

/**
 * Created by tsodring on 01/04/18.
 */
public interface IProjectFunctionalityService {
    ProjectFunctionality getProjectFunctionality(Long id);
    ProjectRequirement createProjectRequirement(
            Long functionalityNumber, ProjectRequirement projectRequirement);
    void delete(Long functionalityNumber);
}
