
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.GrouseUser;
import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.service.interfaces.IGrouseUserService;
import no.kdrs.grouse.service.interfaces.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static no.kdrs.grouse.utils.Constants.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by tsodring on 28/03/18.
 */
@RestController
@RequestMapping(value = SLASH + USER)
public class UserController {

    private IGrouseUserService grouseUserService;
    private IProjectService projectService;

    public UserController(IGrouseUserService grouseUserService,
                          IProjectService projectService) {
        this.grouseUserService = grouseUserService;
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GrouseUser>> getGrouseUsers() {
        return ResponseEntity.status(HttpStatus.OK).
                body(grouseUserService.findAll());
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
    public ResponseEntity<GrouseUser> getGrouseUser(
            @PathVariable("userid") String id) {
        GrouseUser user = grouseUserService.findById(id);
        user.add(linkTo(methodOn(UserController.class).
                getGrouseUser(id)).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

    @RequestMapping(value = "/{username}/"+ PROJECT, method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getGrouseUserProjects(
            @PathVariable("username") String username) {
        GrouseUser user = new GrouseUser();
        user.setUsername(username);
        List<Project> projects = projectService.findByReferenceUser(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(projects);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GrouseUser> saveGrouseUser(
            @RequestBody GrouseUser grouseUser) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(grouseUserService.save(grouseUser));
    }

    @RequestMapping(value = "/{krav:.+}", method = RequestMethod.PUT)
    public ResponseEntity<GrouseUser> updateGrouseUser(
            @PathVariable("krav") String grouseUserId,
            @RequestBody GrouseUser grouseUser) throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(grouseUserService.update(grouseUserId, grouseUser));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteGrouseUser(@PathVariable String id) {
        grouseUserService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("GrouseUser with id " + id + " was deleted");
    }
}
