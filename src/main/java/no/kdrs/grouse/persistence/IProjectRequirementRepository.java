package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.ProjectRequirement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRequirementRepository
        extends CrudRepository<ProjectRequirement, Long> {

}
