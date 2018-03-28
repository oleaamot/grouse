package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Requirement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequirementRepository
        extends CrudRepository<Requirement, String> {
}
