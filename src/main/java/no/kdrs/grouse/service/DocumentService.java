package no.kdrs.grouse.service;

import no.kdrs.grouse.document.Document;
import no.kdrs.grouse.model.Functionality;
import no.kdrs.grouse.model.Requirement;
import no.kdrs.grouse.service.interfaces.IDocumentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tsodring on 10/28/17.
 */
@Component
public class DocumentService implements IDocumentService {

    private EntityManager em;

    @Value("${storage.location}")
    private String storageLocation;

    public DocumentService(EntityManager em) {
        this.em = em;
    }

    @Override
    public void createDocument(Long projectId) throws IOException {
        String filename = storageLocation + File.separator + "kravspec.docx";
        FileOutputStream file = new FileOutputStream(filename);
        Document document = new Document(file);
        processRequirements(document, projectId);
        document.close();
        file.flush();
        file.close();
    }

    /**
     * Using the project number generate a requirements document from all the
     * requirements
     *
     * @param document The Word document
     * @param projectId The project number from which to retreive details
     *                      to insert into document
     */
    @Override
    @SuppressWarnings("unchecked")
    public void processRequirements(Document document, Long projectId) {

        Query queryFunctionality =
                em.createQuery("SELECT f FROM Functionality f");
        ArrayList<Functionality> functionalityList =
                (ArrayList<Functionality>) queryFunctionality.getResultList();

        for (Functionality functionality : functionalityList) {

            Query query =
                    em.createQuery(
                            "SELECT r FROM Requirement r JOIN r.functionality f WHERE f.id = :idFunctionality");
            query.setParameter("idFunctionality",
                    functionality.getFunctionalityNumber());
            ArrayList<Requirement> requirementsList =
                    (ArrayList<Requirement>) query.getResultList();

            document.addSection(functionality.getTitle());
            document.createTable(requirementsList.size(), functionality);

            for (Requirement requirement : requirementsList) {
                document.addRow(requirement);
            }
        }
    }
}
