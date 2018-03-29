package no.kdrs.grouse.service.interfaces;


import no.kdrs.grouse.model.Requirement;

import java.util.List;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IRequirementService {
    List<Requirement> findAll();
    Requirement findById(String id);
    Requirement save(Requirement requirement);
    Requirement update(String requirementId, Requirement requirement) throws Exception;
    void delete(String id);
}
