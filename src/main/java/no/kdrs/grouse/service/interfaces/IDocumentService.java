package no.kdrs.grouse.service.interfaces;

import no.kdrs.grouse.document.Document;

import java.io.IOException;

/**
 * Created by tsodring on 10/28/17.
 */
public interface IDocumentService {

    void createDocument(Long projectId) throws IOException;
    void processRequirements(Document document, Long projectId) throws IOException;
}
