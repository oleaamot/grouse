package no.kdrs.grouse.service;

import no.kdrs.grouse.model.Requirement;
import no.kdrs.grouse.persistence.IRequirementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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

    public Set<Requirement> findAll() {
        Set<Requirement> requirements = requirementRepository.findAll();
        return requirements;
    }

    @Override
    public Requirement findOne(String id) {
        return requirementRepository.findOne(id);
    }

    @Override
    public Requirement save(Requirement Requirement) {
        return requirementRepository.save(Requirement);
    }

    @Override
    public Requirement update(String requirementId, Requirement requirement) throws Exception {
        Requirement originalRequirement = requirementRepository.findByRequirementNumber(requirementId);
        if (originalRequirement == null){
            throw new Exception("No Noark Requirement exists, identified by requirement number  " + requirementId);
        }
        originalRequirement.setRequirementText(requirement.getRequirementText());
        originalRequirement.setConformityLevel(requirement.getConformityLevel());
        originalRequirement.setConsequence(requirement.getConsequence());
        originalRequirement.setExplanation(requirement.getExplanation());
        originalRequirement.setRequirementType(requirement.getRequirementType());
        return originalRequirement;
    }
    
    @Override
    public void delete(String id) {
        requirementRepository.delete(id);
    }

    @Override
    public Requirement findByRequirementNumber(String requirementNumber) {
        return requirementRepository.findByRequirementNumber(requirementNumber);
    }

    @Override
    public Set<Requirement> findByRequirementType(String requirementType) {
        return requirementRepository.findByRequirementType(requirementType);
    }
}
