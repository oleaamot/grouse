package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Functionality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IFunctionalityRepository extends CrudRepository<Functionality, Long> {

    @Override
    Functionality save(Functionality Functionality);

    @Override
    Set<Functionality> findAll();

    // functionalityNumber
    Functionality findByFunctionalityNumber(String functionalityNumber);

}
