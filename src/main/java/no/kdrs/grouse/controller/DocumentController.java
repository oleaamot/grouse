
package no.kdrs.grouse.controller;

import no.kdrs.grouse.service.IDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static no.kdrs.grouse.utils.Constants.*;

/**
 * Created by tsodring on 9/25/17.
 */
@RestController
@RequestMapping(value = SLASH + DOCUMENT)
public class DocumentController {

    private IDocumentService documentService;

    public DocumentController(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/{prosjektnummer}", method = RequestMethod.GET)
    public ResponseEntity<String> getRequirement(@PathVariable("prosjektnummer")
                                                         String projectNumber) throws IOException {
        documentService.createDocument(projectNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Dokument oppretet");
    }

}
