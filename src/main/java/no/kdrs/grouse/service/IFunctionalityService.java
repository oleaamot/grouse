package no.kdrs.grouse.service;


import no.kdrs.grouse.model.Functionality;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IFunctionalityService {
    List<Functionality> findAll();
    Functionality findById(String id);
    Functionality save(Functionality functionality);
    Functionality update(String functionalityId, Functionality functionality)
            throws EntityNotFoundException;
    void delete(String id);

    List<Functionality> findByShowMeAndReferenceParentFunctionality(
            Boolean menuItem, String parent);
}
