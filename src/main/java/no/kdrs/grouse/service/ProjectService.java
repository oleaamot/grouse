package no.kdrs.grouse.service;

import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.persistence.IProjectRepository;
import no.kdrs.grouse.service.interfaces.IProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by tsodring on 9/25/17.
 */
@Service
@Transactional
public class ProjectService
        implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll(String projectOwner) {
        return projectRepository.findByProjectOwner(projectOwner);
    }

    @Override
    public Project findById(@NotNull Long id) {
        return getProjectOrThrow(id);
    }

    @Override
    public Project save(Project Project) {
        return projectRepository.save(Project);
    }

    @Override
    public Project update(Long id, Project project)
            throws EntityNotFoundException {

        Project originalProject = getProjectOrThrow(id);
        // copy the values over
        originalProject.setFileName(project.getFileName());
        originalProject.setProjectName(project.getProjectName());
        originalProject.setProjectNumber(project.getProjectNumber());

        // probably don't want to expose this one
        //originalProject.ListProjectOwner(project.getProjectOwner());
        return originalProject;
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project findByProjectNumberOrderByProjectName(String projectNumber) {
        return projectRepository.findByProjectNumberOrderByProjectName(projectNumber);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Project back. If there is no valid
     * Project, a EntityNotFoundException exception is thrown
     *
     * @param id The systemId of the project object to retrieve
     * @return the project object
     */
    private Project getProjectOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No Project exists with Id " + id));
    }
}
