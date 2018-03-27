package no.kdrs.grouse.service;


import no.kdrs.grouse.model.Functionality;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IFunctionalityService {
    Set findAll();
    Functionality findById(String id);
    Functionality save(Functionality functionality);
    Functionality update(String functionalityId, Functionality functionality)
            throws EntityNotFoundException;
    void delete(String id);

    Set<Functionality> findByShowMe(Boolean menuItem);
}
