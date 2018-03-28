package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository
        extends CrudRepository<Project, Long> {

    List<Project> findByProjectOwner(String projectOwner);
    // projectNumber
    Project findByProjectNumberOrderByProjectName(String projectFirstName);
}
