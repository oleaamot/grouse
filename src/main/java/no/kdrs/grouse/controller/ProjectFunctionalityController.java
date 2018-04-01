
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.model.ProjectRequirement;
import no.kdrs.grouse.service.interfaces.IProjectFunctionalityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static no.kdrs.grouse.utils.Constants.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by tsodring on 29/03/18.
 */
@RestController
@RequestMapping(value = SLASH + PROJECT_FUNCTIONALITY)
public class ProjectFunctionalityController {
    private IProjectFunctionalityService projectFunctionalityService;

    public ProjectFunctionalityController(
            IProjectFunctionalityService projectFunctionalityService) {
        this.projectFunctionalityService = projectFunctionalityService;
    }

    @RequestMapping(value = "/{krav}/" + REQUIREMENT,
            method = RequestMethod.GET)
    public ResponseEntity<ProjectFunctionality> getRequirements(
            @PathVariable("krav") Long projectFunctionalityId) {

        ProjectFunctionality projectFunctionality = projectFunctionalityService.
                getProjectFunctionality(projectFunctionalityId);

        List<ProjectRequirement> projectRequirements =
                projectFunctionality.getReferenceProjectRequirement();

        for (ProjectRequirement projectRequirement : projectRequirements) {
            projectRequirement.add(linkTo(methodOn
                    (ProjectRequirementController.class).
                    getRequirement(projectRequirement.
                            getProjectRequirementId())).withSelfRel());
        }
        projectFunctionality.add(linkTo(methodOn
                (ProjectFunctionalityController.class).
                getRequirements(projectFunctionalityId)).withSelfRel());

        projectFunctionality.add(linkTo(methodOn
                (ProjectFunctionalityController.class).
                getRequirements(projectFunctionalityId)).
                withRel(PROJECT_REQUIREMENT));

        return ResponseEntity.status(HttpStatus.OK)
                .body(projectFunctionality);
    }

    @RequestMapping(value = "/{krav}/" + REQUIREMENT,
            method = RequestMethod.POST)
    public ResponseEntity<ProjectRequirement> createProjectRequirement(
            @PathVariable("krav") Long projectFunctionalityId,
            @RequestBody ProjectRequirement projectRequirement) {

        projectFunctionalityService.
                createProjectRequirement(projectFunctionalityId,
                        projectRequirement);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectRequirement);
    }
}
