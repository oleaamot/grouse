package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.model.ProjectFunctionality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectFunctionalityRepository
        extends CrudRepository<ProjectFunctionality, Long> {

    List<ProjectFunctionality> findByReferenceProjectAndShowMe(
            Project project, Boolean showMe);
    ProjectFunctionality findByFunctionalityNumber(String functionalityNumber);
}
