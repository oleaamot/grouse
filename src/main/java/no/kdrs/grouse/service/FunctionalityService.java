package no.kdrs.grouse.service;

import no.kdrs.grouse.model.Functionality;
import no.kdrs.grouse.persistence.IFunctionalityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Functionality findOne(String id) {
        return functionalityRepository.findOne(id);
    }

    @Override
    public Functionality save(Functionality Functionality) {
        return functionalityRepository.save(Functionality);
    }

    @Override
    public Functionality update(String functionalityId, Functionality functionality) throws Exception {
        Functionality originalFunctionality = functionalityRepository.findByFunctionalityNumber(functionalityId);
        if (originalFunctionality == null){
            throw new Exception("No Noark Functionality exists, identified by functionality number  " + functionalityId);
        }
        originalFunctionality.setDescription(functionality.getDescription());
        originalFunctionality.setConsequence(functionality.getConsequence());
        originalFunctionality.setExplanation(functionality.getExplanation());
        return originalFunctionality;
    }
    
    @Override
    public void delete(String id) {
        functionalityRepository.delete(id);
    }

    @Override
    public Functionality findByFunctionalityNumber(String functionalityNumber) {
        return functionalityRepository.findByFunctionalityNumber(functionalityNumber);
    }
}
