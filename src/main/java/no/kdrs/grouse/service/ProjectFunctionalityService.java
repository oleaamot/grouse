package no.kdrs.grouse.service;

import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.persistence.IProjectFunctionalityRepository;
import no.kdrs.grouse.service.interfaces.IProjectFunctionalityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tsodring on 01/04/18.
 */
@Service
@Transactional
public class ProjectFunctionalityService
        implements IProjectFunctionalityService {

    private IProjectFunctionalityRepository projectFunctionalityRepository;

    public ProjectFunctionalityService(
            IProjectFunctionalityRepository projectFunctionalityRepository) {
        this.projectFunctionalityRepository = projectFunctionalityRepository;
    }

    @Override
    public ProjectFunctionality getProjectFunctionality(
            String functionalityNumber) {
        return projectFunctionalityRepository.
                findByFunctionalityNumber(functionalityNumber);
    }
}
