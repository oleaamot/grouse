package no.kdrs.grouse.service;

import no.kdrs.grouse.model.Functionality;
import no.kdrs.grouse.model.Requirement;
import no.kdrs.grouse.persistence.IFunctionalityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by tsodring on 9/25/17.
 */
@Service
@Transactional
public class FunctionalityService implements IFunctionalityService {

    private IFunctionalityRepository functionalityRepository;

    public FunctionalityService(IFunctionalityRepository functionalityRepository) {
        this.functionalityRepository = functionalityRepository;
    }

    public Set<Functionality> findAll() {
        Set<Functionality> functionalitys = functionalityRepository.findAll();
        return functionalitys;
    }

    @Override
    public Set<Functionality> findByShowMe(Boolean menuItem) {
        return functionalityRepository.findByShowMe(menuItem);
    }

    @Override
    public Functionality findById(String id) {
        return getFunctionalityOrThrow(id);
    }
    @Override
    public Functionality save(Functionality Functionality) {
        return functionalityRepository.save(Functionality);
    }

    @Override
    public Functionality update(String id, Functionality functionality)
            throws EntityNotFoundException {
        Functionality originalFunctionality = getFunctionalityOrThrow(id);

        originalFunctionality.setDescription(functionality.getDescription());
        originalFunctionality.setConsequence(functionality.getConsequence());
        originalFunctionality.setExplanation(functionality.getExplanation());

        return originalFunctionality;
    }
    
    @Override
    public void delete(String id) {
        functionalityRepository.deleteById(id);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Functionality back. If there is no valid
     * Functionality, a EntityNotFoundException exception is thrown
     *
     * @param id The systemId of the functionality object to retrieve
     * @return the functionality object
     */
    private Functionality getFunctionalityOrThrow(@NotNull String id)
            throws EntityNotFoundException {
        Functionality functionality =
                functionalityRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException(
                                        "No Functionality exists with Id " + id));
        return functionality;
    }

}
