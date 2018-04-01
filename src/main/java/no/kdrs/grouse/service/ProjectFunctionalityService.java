package no.kdrs.grouse.service;

import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.model.ProjectRequirement;
import no.kdrs.grouse.persistence.IProjectFunctionalityRepository;
import no.kdrs.grouse.persistence.IProjectRequirementRepository;
import no.kdrs.grouse.service.interfaces.IProjectFunctionalityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

/**
 * Created by tsodring on 01/04/18.
 */
@Service
@Transactional
public class ProjectFunctionalityService
        implements IProjectFunctionalityService {

    private IProjectFunctionalityRepository projectFunctionalityRepository;
    private IProjectRequirementRepository projectRequirementRepository;

    public ProjectFunctionalityService(
            IProjectFunctionalityRepository projectFunctionalityRepository,
            IProjectRequirementRepository projectRequirementRepository) {
        this.projectFunctionalityRepository = projectFunctionalityRepository;
        this.projectRequirementRepository = projectRequirementRepository;
    }

    @Override
    public ProjectFunctionality getProjectFunctionality(
            Long projectFunctionalityId) {
        return getProjectFunctionalityOrThrow(projectFunctionalityId);
    }

    @Override
    public ProjectRequirement createProjectRequirement(
            Long projectFunctionalityId, ProjectRequirement projectRequirement) {
        return projectRequirementRepository.save(projectRequirement);
    }

    @Override
    public void delete(Long functionalityID) {
        projectFunctionalityRepository.deleteById(functionalityID);
    }
    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Project back. If there is no valid
     * ProjectRequirement, a EntityNotFoundException exception is thrown
     *
     * @param id The id  of the ProjectRequirement object to retrieve
     * @return the ProjectRequirement object
     */
    private ProjectFunctionality getProjectFunctionalityOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return projectFunctionalityRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No ProjectRequirement exists with Id " + id));
    }
}
