package no.kdrs.grouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
@SpringBootApplication
public class Grouse {
	public static void main(String[] args) {
		// SpringApplication.run(Grouse.class, args);
		System.out.println("Grouse + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Iterator iter = session.createQuery("from GrouseDocument").iterate();
		while (iter.hasNext()) {
			GrouseDocument doc = (GrouseDocument) iter.next();
			System.out.println("kravnr=" + doc.getKravnr() + "\n");
			try {
				XWPFDocument document = new XWPFDocument();
				XWPFParagraph tmpParagraph = document.createParagraph();
				XWPFRun titleRun = tmpParagraph.createRun();
				titleRun.setText(doc.getKravnr() + "\n");
				titleRun.setFontSize(18);
				XWPFRun spaceRun = tmpParagraph.createRun();
				spaceRun.setText(doc.getOokrav() + "\n");
				spaceRun.setFontSize(18);
				XWPFRun commentRun = tmpParagraph.createRun();
				commentRun.setText(doc.getComment());
				commentRun.setFontSize(18);
				XWPFRun cRun = tmpParagraph.createRun();
				cRun.setText("\n");
				cRun.setFontSize(18);
				XWPFRun referenceRun = tmpParagraph.createRun();
				referenceRun.setText("Referanse: " + doc.getReference());
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
				FileOutputStream fos = new FileOutputStream(new File(doc.getKravnr() + ".doc"));
				document.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		session.beginTransaction();
		GrouseDocument doc = new GrouseDocument();
		doc.setKravnr("5.1.1");
		doc.setOokrav("For at et system skal kunne godkjennes etter Noark5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.");
		doc.setKravtype("O");
		doc.setMerknad("TEST");
		doc.setForklaring("TEST");
		doc.setKonsekvens("TEST");
		doc.setKonfnivaa("TEST");
		doc.setRefkrav("TEST");
		doc.setStatus("TEST");
		doc.setAnsvar("TEJ");
		session.save(doc);
		session.getTransaction().commit();
	}
}
