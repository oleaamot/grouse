
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.ProjectRequirement;
import no.kdrs.grouse.service.interfaces.IDocumentService;
import no.kdrs.grouse.service.interfaces.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    public ResponseEntity<String> getRequirement(
            @PathVariable("prosjektnummer") String projectNumber)
            throws IOException {
        documentService.createDocument(projectNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Dokument oppretet");
    }

    @RequestMapping(value = "/{prosjektnummer}/krav/{funksjonalitet}",
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
}
