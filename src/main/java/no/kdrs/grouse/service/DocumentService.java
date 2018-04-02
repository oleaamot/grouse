package no.kdrs.grouse.service;

import no.kdrs.grouse.document.Document;
import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.model.ProjectFunctionality;
import no.kdrs.grouse.model.ProjectRequirement;
import no.kdrs.grouse.service.interfaces.IDocumentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static no.kdrs.grouse.utils.Constants.GROUSE;

/**
 * Created by tsodring on 10/28/17.
 */
@Component
@Transactional
public class DocumentService
        implements IDocumentService {

    @Value("${storage.location}")
    private String storageLocation;

    @Override
    public void createDocument(Project project) throws IOException {

        String filename = storageLocation + File.separator +
                GROUSE  + "-" + project.getProjectId().toString() + ".docx";
        project.setFileNameInternal(filename);
        FileOutputStream file = new FileOutputStream(filename);
        Document document = new Document(file);
        processRequirements(document, project);
        document.close();
        file.flush();
        file.close();
        project.setDocumentCreated(true);
    }

    /**
     * Populate the requirements document with details from the database
     *
     * @param document The Word document
     * @param project An instance of the relevant Project object
     */
    @Override
    @SuppressWarnings("unchecked")
    public void processRequirements(Document document, Project project) {


        List<ProjectFunctionality> projectFunctionalities =
                project.getReferenceProjectFunctionality();

        for (ProjectFunctionality functionality : projectFunctionalities) {

            List<ProjectRequirement> projectRequirements =
                    functionality.getReferenceProjectRequirement();

            document.addSection(functionality.getTitle());
            document.createTable(projectRequirements.size(), functionality);

            for (ProjectRequirement projectRequirement :
                    projectRequirements) {
                   document.addRow(projectRequirement);
            }
        }
    }
}
