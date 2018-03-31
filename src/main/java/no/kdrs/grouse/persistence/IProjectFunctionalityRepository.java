package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.ProjectFunctionality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectFunctionalityRepository
        extends CrudRepository<ProjectFunctionality, Long> {
}
