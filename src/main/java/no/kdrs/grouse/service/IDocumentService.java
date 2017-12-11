package no.kdrs.grouse.service;

import no.kdrs.grouse.document.Document;

import java.io.IOException;

/**
 * Created by tsodring on 10/28/17.
 */
public interface IDocumentService {

    void createDocument(String projectNumber) throws IOException;
    void processRequirements(Document document, String projectNumber) throws IOException;
}
