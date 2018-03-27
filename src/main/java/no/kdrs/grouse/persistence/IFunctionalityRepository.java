package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Functionality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IFunctionalityRepository extends CrudRepository<Functionality, String> {

    @Override
    Functionality save(Functionality Functionality);

    @Override
    Set<Functionality> findAll();

    Functionality findByFunctionalityNumber(String functionalityNumber);

    Set<Functionality> findByShowMeAndReferenceParentFunctionality(
            Boolean menuItem, Functionality parent);
}
