
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.model.ProjectRequirement;
import no.kdrs.grouse.service.interfaces.IDocumentService;
import no.kdrs.grouse.service.interfaces.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.kdrs.grouse.utils.Constants.PROJECT;
import static no.kdrs.grouse.utils.Constants.SLASH;

/**
 * Created by tsodring on 9/25/17.
 */
@RestController
@RequestMapping(value = SLASH + PROJECT)
public class ProjectController {

    private IDocumentService documentService;
    private IProjectService projectService;

    public ProjectController(IDocumentService documentService,
                             IProjectService projectService) {
        this.documentService = documentService;
        this.projectService = projectService;
    }

    @RequestMapping(value = "/{prosjektnummer}", method = RequestMethod.GET)
    public ResponseEntity<Project> getRequirement(
            @PathVariable("prosjektnummer") Long projectNumber) {

        Project project =  projectService.findById(projectNumber);
        //documentService.createDocument(projectNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(project);
    }

    @RequestMapping(value = "/{prosjektnummer}/funksjonalitet/{funksjonalitet}",
            method = RequestMethod.GET)
    public ResponseEntity<List<ProjectRequirement>>
    getRequirementsForFunctionaltiy(
            @PathVariable("prosjektnummer") String projectNumber,
            @PathVariable("funksjonalitet") String functionalityNumber) {

        List<ProjectRequirement> projectRequirements =
                projectService.findByProjectNumberOrderByProjectName(
                projectNumber, functionalityNumber);

        return ResponseEntity.status(HttpStatus.OK)
                .body(projectRequirements);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> createProject (
            @RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.createProject(project));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProject (
            @PathVariable("prosjektnummer") Long projectNumber) {
        projectService.delete(projectNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Prosjekt med id " + projectNumber + "ble slettet");
    }
}
