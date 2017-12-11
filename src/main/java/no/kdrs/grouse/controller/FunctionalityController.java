
package no.kdrs.grouse.controller;
import no.kdrs.grouse.model.Functionality;
import no.kdrs.grouse.service.IFunctionalityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

import static no.kdrs.grouse.utils.Constants.*;

/**
 * Created by tsodring on 9/25/17.
 */
@RestController
@RequestMapping(value = SLASH + FUNCTIONALITY)
public class FunctionalityController {

    private IFunctionalityService functionalityService;

    FunctionalityController(IFunctionalityService functionalityService) {
        this.functionalityService = functionalityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getFunctionalities() {
        Set<Functionality> functionalitys = functionalityService.findAll();
        return new ResponseEntity<Object> (functionalitys, HttpStatus.OK);
    }

    @RequestMapping(value = "/{funksjon:.+}", method = RequestMethod.GET)
    public ResponseEntity<Functionality> getFunctionality(@PathVariable("funksjon") String functionalityNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(functionalityService.findByFunctionalityNumber(functionalityNumber));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Functionality> saveFunctionality(@RequestBody Functionality Functionality) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(functionalityService.save(Functionality));
    }

    @RequestMapping(value = "/{funksjon:.+}", method = RequestMethod.PUT)
    public ResponseEntity<Functionality> updateFunctionality(
            @PathVariable("funksjon") String functionalityId,
            @RequestBody Functionality functionality) throws Exception{
        return ResponseEntity.status(HttpStatus.OK)
                .body(functionalityService.update(functionalityId, functionality));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFunctionality(@PathVariable Long id) {
        functionalityService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Functionality with id " + Long.toString(id) + " was deleted");
    }
}
