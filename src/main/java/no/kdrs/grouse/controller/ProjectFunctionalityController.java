
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.service.interfaces.IProjectFunctionalityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static no.kdrs.grouse.utils.Constants.*;

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

    //http://localhost:9294/grouse/prosjektfunksjon/109/krav
    @RequestMapping(value = "/{krav}/" + REQUIREMENT,
            method = RequestMethod.GET)
    public ResponseEntity<ProjectFunctionality> getRequirements(
            @PathVariable("krav") String functionalityNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projectFunctionalityService.
                        getProjectFunctionality(functionalityNumber));
    }
}
