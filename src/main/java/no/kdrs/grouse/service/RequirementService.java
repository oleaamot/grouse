package no.kdrs.grouse.service;

import no.kdrs.grouse.model.Requirement;
import no.kdrs.grouse.persistence.IRequirementRepository;
import no.kdrs.grouse.service.interfaces.IRequirementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsodring on 9/25/17.
 */
@Service
@Transactional
public class RequirementService implements IRequirementService {

    private IRequirementRepository requirementRepository;

    public RequirementService(IRequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    @SuppressWarnings("unchecked")
    public List<Requirement> findAll() {
        return (ArrayList) requirementRepository.findAll();
    }

    @Override
    public Requirement findById(String id) {
        return getRequirementOrThrow(id);
    }

    @Override
    public Requirement save(Requirement Requirement) {
        return requirementRepository.save(Requirement);
    }

    @Override
    public Requirement update(String id, Requirement requirement)
            throws EntityNotFoundException {
        Requirement originalRequirement = getRequirementOrThrow(id);

        originalRequirement.setRequirementText(requirement.getRequirementText());
        originalRequirement.setConformityLevel(requirement.getConformityLevel());
        originalRequirement.setConsequence(requirement.getConsequence());
        originalRequirement.setExplanation(requirement.getExplanation());
        originalRequirement.setRequirementType(requirement.getRequirementType());

        return originalRequirement;
    }

    @Override
    public void delete(String id) {
        requirementRepository.deleteById(id);
    }

    @Override
    public Requirement findByRequirementNumber(String requirementNumber) {
        return requirementRepository.findByRequirementNumber(requirementNumber);
    }

    @Override
    public List<Requirement> findByRequirementType(String requirementType) {
        return requirementRepository.findByRequirementType(requirementType);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Requirement back. If there is no
     * valid Requirement, a EntityNotFoundException exception is thrown
     *
     * @param id The systemId of the requirement object to retrieve
     * @return the requirement object
     */
    private Requirement getRequirementOrThrow(@NotNull String id)
            throws EntityNotFoundException {
        return requirementRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No Requirement exists with Id " + id));
    }
}
