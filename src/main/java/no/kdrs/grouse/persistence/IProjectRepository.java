package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Project save(Project Project);

    @Override
    Set<Project> findAll();

    // projectNumber
    Project findByProjectNumberOrderByProjectName(String projectFirstName);
}
