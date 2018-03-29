
package no.kdrs.grouse.controller;

import no.kdrs.grouse.service.interfaces.IDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static no.kdrs.grouse.utils.Constants.DOCUMENT;
import static no.kdrs.grouse.utils.Constants.SLASH;

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
