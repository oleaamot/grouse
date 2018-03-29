package no.kdrs.grouse.document;

import no.kdrs.grouse.model.Functionality;
import no.kdrs.grouse.model.Requirement;
import org.apache.poi.xwpf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

import static no.kdrs.grouse.utils.Constants.*;

/**
 * Created by tsodring on 10/28/17.
 */
public class Document {

    private OutputStream out;
    private XWPFDocument document;

    // A table object that gets reinstantiated every time a new table is
    // created. Not using an array of tables as we likely do not need access
    // to the table after it has been added to the document
    private XWPFTable table;

    // The current row in the table when adding content
    // is reset every time a table is created
    private int rowNumber = 1;

    public Document(OutputStream out) {
        this.out = out;
        this.document = new XWPFDocument();
    }

    public void addRow(Requirement requirement) {
        XWPFTableRow row = table.getRow(rowNumber++);
        row.getCell(COLUMN_NUMBER).setText(requirement.getOrder().toString());
        row.getCell(COLUMN_FUNCTIONALITY_TITLE).setText(requirement.getRequirementText());
        row.getCell(COLUMN_PRIORITY).setText(requirement.getPriority());
        row.getCell(COLUMN_ANSWER).setText("XQ");
        row.getCell(COLUMN_REFERENCE).setText("XQ");
     }

    public void addSection(String sectionTitle) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(sectionTitle);
        run.addBreak();
    }

    public void createTable(Integer numberOfRows, Functionality functionality) {
        rowNumber = 1;
        // Add 1 to include the header
        table = document.createTable(numberOfRows+1, REQUIRMENT_TABLE_NUMBER_COLUMNS);
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(REQUIRMENT_TABLE_NUMBER_WIDTH));
        table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(REQUIRMENT_TABLE_TITLE_WIDTH));
        table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(REQUIRMENT_TABLE_PRIORITY_WIDTH));
        table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(REQUIRMENT_TABLE_ANSWER_WIDTH));
        table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(REQUIRMENT_TABLE_REFERENCE_WIDTH));

        // Get the first row and add header values
        XWPFTableRow row = table.getRow(0);
        row.getCell(COLUMN_NUMBER).setText(TEXT_REQUIREMENT_NUMBER);
        row.getCell(COLUMN_FUNCTIONALITY_TITLE).setText(functionality.getTitle());
        row.getCell(COLUMN_PRIORITY).setText(TEXT_REQUIREMENT_PRIORITY);
        row.getCell(COLUMN_ANSWER).setText(TEXT_REQUIREMENT_ANSWER);
        row.getCell(COLUMN_REFERENCE).setText(TEXT_REFERENCE_REQUIREMENT);
    }

    public void close() throws IOException {
        document.write(out);
    }
}
