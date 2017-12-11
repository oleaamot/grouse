package no.kdrs.grouse.service;

import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.persistence.IProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by tsodring on 9/25/17.
 */
@Service
@Transactional
public class ProjectService implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Set<Project> findAll() {
        Set<Project> projects = projectRepository.findAll();
        return projects;
    }

    @Override
    public Project findOne(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public Project save(Project Project) {
        return projectRepository.save(Project);
    }

    @Override
    public Project update(Long id, Project Project) throws Exception {
        Project originalProject = projectRepository.findOne(id);
        if (originalProject == null){
            throw new Exception("No Project exists with Id " + id);
        }
        return originalProject;
    }
    
    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public Project findByProjectNumberOrderByProjectName(String projectNumber) {
        return projectRepository.findByProjectNumberOrderByProjectName(projectNumber);
    }
}
