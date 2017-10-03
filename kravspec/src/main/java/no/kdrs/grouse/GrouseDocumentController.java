package no.kdrs.grouse;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

@RestController
@RequestMapping(value = "/documents")
public class GrouseDocumentController {
	private List<GrouseDocument> documents = new ArrayList();	
	GrouseDocumentController() {
		this.documents = buildDocuments();
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<GrouseDocument> getDocuments() {
		return this.documents;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GrouseDocument getDocument(@PathVariable("id") Integer id) {
		GrouseDocument lastDocument = this.documents.stream().skip(this.documents.size() - 1).findFirst().orElse(null);
		try {
			XWPFDocument document = new XWPFDocument();
			XWPFParagraph tmpParagraph = document.createParagraph();
			XWPFRun titleRun = tmpParagraph.createRun();
			titleRun.setText(lastDocument.getTitle());
			titleRun.setFontSize(18);
			XWPFRun spaceRun = tmpParagraph.createRun();
			spaceRun.setText("\n");
			spaceRun.setFontSize(18);
			XWPFRun commentRun = tmpParagraph.createRun();
			commentRun.setText(lastDocument.getComment());
			commentRun.setFontSize(18);
			XWPFRun cRun = tmpParagraph.createRun();
			cRun.setText("\n");
			cRun.setFontSize(18);
			XWPFRun referenceRun = tmpParagraph.createRun();
			referenceRun.setText("Referanse: " + lastDocument.getReference());
			referenceRun.setFontSize(18);
			// XWPFTable table = document.createTable();
			// // create first row
			// XWPFTableRow tableRowOne = table.getRow(0);
			// tableRowOne.getCell(0).setText(lastDocument.getTitle());
			// tableRowOne.addNewTableCell().setText(lastDocument.getComment());
			// tableRowOne.addNewTableCell().setText(lastDocument.getReference());
			// // create second row
			// XWPFTableRow tableRowTwo = table.createRow();
			// tableRowTwo.getCell(0).setText("col one, row two");
			// tableRowTwo.getCell(1).setText("col two, row two");
			// tableRowTwo.getCell(2).setText("col three, row two");
			// // create third row
			// XWPFTableRow tableRowThree = table.createRow();
			// tableRowThree.getCell(0).setText("col one, row three");
		        // tableRowThree.getCell(1).setText("col two, row three");
			// tableRowThree.getCell(2).setText("col three, row three");
			FileOutputStream fos = new FileOutputStream(new File(lastDocument.getTitle() + ".doc"));
			document.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.documents.stream().filter(document-> document.getId() == id).findFirst().orElse(null);
	}
	@RequestMapping(method = RequestMethod.POST)
	public GrouseDocument saveDocument(@RequestBody GrouseDocument document) {
		Integer nextId = 0;
		if (this.documents.size() != 0) {
			GrouseDocument lastDocument = this.documents.stream().skip(this.documents.size() - 1).findFirst().orElse(null);
			nextId = lastDocument.getId() + 1;
		}

		document.setId(nextId);
		this.documents.add(document);
		return document;

	}
	@RequestMapping(method = RequestMethod.PUT)
	public GrouseDocument updateDocument(@RequestBody GrouseDocument document) {
		GrouseDocument modifiedDocument = this.documents.stream().filter(u -> u.getId() == document.getId()).findFirst().orElse(null);
		modifiedDocument.setTitle(document.getTitle());
		modifiedDocument.setComment(document.getComment());		
		modifiedDocument.setReference(document.getReference());
		return modifiedDocument;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteDocument(@PathVariable Integer id) {
		GrouseDocument deleteDocument = this.documents.stream().filter(document -> document.getId() == id).findFirst().orElse(null);
		if (deleteDocument != null) {
			this.documents.remove(deleteDocument);
			return true;
		} else  {
			return false;
		}
	}
	List<GrouseDocument> buildDocuments() {
		List<GrouseDocument> documents = new ArrayList<>();

		GrouseDocument document1 = buildDocument(1, "5.1.1", "For at et system skal kunne godkjennes etter Noark 5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.", "noark5");

		documents.add(document1);

		return documents;

	}
	GrouseDocument buildDocument(Integer id, String title, String comment, String reference) {
		GrouseDocument document = new GrouseDocument();
		document.setId(id);
		document.setTitle(title);
		document.setComment(comment);		
		document.setReference(reference);
		return document;
	}
}
