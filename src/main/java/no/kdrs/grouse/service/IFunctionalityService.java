package no.kdrs.grouse.service;


import no.kdrs.grouse.model.Functionality;

import java.util.Set;

/**
 * Created by tsodring on 9/25/17.
 */
public interface IFunctionalityService {
    Set findAll();
    Functionality findOne(String id);
    Functionality save(Functionality functionality);
    Functionality update(String functionalityId, Functionality functionality) throws Exception;
    void delete(String id);
    // functionalityNumber
    Functionality findByFunctionalityNumber(String functionalityNumber);
    Set<Functionality> findByShowMe(Boolean menuItem);
}
