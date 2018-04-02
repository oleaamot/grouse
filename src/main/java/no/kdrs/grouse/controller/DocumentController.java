
package no.kdrs.grouse.controller;

import no.kdrs.grouse.model.Project;
import no.kdrs.grouse.service.interfaces.IDocumentService;
import no.kdrs.grouse.service.interfaces.IProjectService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static no.kdrs.grouse.utils.Constants.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by tsodring on 9/25/17.
 * <p>
 * Controller that has two tasks.
 * <p>
 * 1. Call for the creation of a requirements document
 * 2. Download the requirements document
 */
@RestController
@RequestMapping(value = SLASH + DOCUMENT)
public class DocumentController {

    private IDocumentService documentService;
    private IProjectService projectService;

    @Value("${storage.location}")
    private String directoryPath;

    public DocumentController(IDocumentService documentService,
                              IProjectService projectService) {
        this.documentService = documentService;
        this.projectService = projectService;
    }

    @RequestMapping(value = "/{prosjektnummer}", method = RequestMethod.POST)
    public ResponseEntity<Project> getRequirement(
            @PathVariable("prosjektnummer") Long projectId)
            throws Exception {

        Project project = projectService.findById(projectId);
        documentService.createDocument(project);
        project.setChangedDate(new Date());
        project.setDocumentCreated(true);
        project.setProjectComplete(true);
        projectService.update(projectId, project);

        project.add(linkTo(methodOn(ProjectController.class).
                getProject(projectId)).withSelfRel());

        project.add(linkTo(methodOn(ProjectController.class).
                getFunctionalityForProject(projectId))
                .withRel(FUNCTIONALITY));

        project.add(linkTo(DocumentController.class, DocumentController.class.
                getMethod("downloadDocument", Long.class,
                        HttpServletResponse.class), projectId).
                withRel(DOCUMENT));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(project);
    }

    @RequestMapping("/{prosjektnummer}")
    public void downloadDocument(
            @PathVariable("prosjektnummer") Long projectId,
                HttpServletResponse response)
            throws IOException {

        Project project = projectService.findById(projectId);

        if (null != project.getFileNameInternal()) {
            // throw an exception
        }

        Path file = Paths.get(project.getFileNameInternal());
        Resource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.addHeader("Content-disposition", "\"attachment;" +
                    "filename=somefile.ext\"" + project.getFileName());
            InputStream filestream = resource.getInputStream();
            try {
                long bytesTotal = IOUtils.copyLarge(filestream,
                        response.getOutputStream());
                filestream.close();
            } finally {
                try {
                    // Try close without exceptions if copy() threw an
                    // exception.  If close() is called twice, the second
                    // close() should be ignored.
                    filestream.close();
                } catch (IOException e) {
                    // swallow any error to expose exceptions from
                    // IOUtil.copy() if the second close() failed.
                }
            }
            response.flushBuffer();
        }
    }
}
