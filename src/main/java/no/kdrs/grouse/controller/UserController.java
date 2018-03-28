
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.GrouseUser;
import no.kdrs.grouse.service.interfaces.IGrouseUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static no.kdrs.grouse.utils.Constants.SLASH;
import static no.kdrs.grouse.utils.Constants.USER;

/**
 * Created by tsodring on 28/03/18.
 */
@RestController
@RequestMapping(value = SLASH + USER)
public class UserController {

    private IGrouseUserService grouseUserService;

    UserController(IGrouseUserService grouseUserService) {
        this.grouseUserService = grouseUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GrouseUser>> getGrouseUsers() {
        return ResponseEntity.status(HttpStatus.OK).
                body(grouseUserService.findAll());
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
    public ResponseEntity<GrouseUser> getGrouseUser(
            @PathVariable("userid") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(grouseUserService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GrouseUser> saveGrouseUser(
            @RequestBody GrouseUser GrouseUser) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(grouseUserService.save(GrouseUser));
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
