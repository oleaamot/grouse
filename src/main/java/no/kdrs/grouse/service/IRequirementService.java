package no.kdrs.grouse.service;


import no.kdrs.grouse.model.Requirement;

import java.util.Set;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IRequirementService {
    Set findAll();
    Requirement findOne(Long id);
    Requirement save(Requirement requirement);
    Requirement update(String requirementId, Requirement requirement) throws Exception;
    void delete(Long id);
    // requirementNumber
    Requirement findByRequirementNumber(String requirementNumber);

    // requirementType
    Set<Requirement> findByRequirementType(String requirementType);

}
