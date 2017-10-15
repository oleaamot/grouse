package no.kdrs.grouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
@SpringBootApplication
public class Grouse {

    private static void setTableColumnWidths(XWPFTable table) {
	table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(2000));
	table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(3200));
	table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1000));
	table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1000));
	table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1105));
	table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1105));
    }

	public static void main(String[] args) {
		// SpringApplication.run(Grouse.class, args);
		System.out.println("Grouse + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Iterator iter = session.createQuery("from GrouseDocument").iterate();

		try {
		    FileOutputStream fos = new FileOutputStream(new File("noark5kravspec.doc"));
		    XWPFDocument document = new XWPFDocument();
		    XWPFTable tableOne = document.createTable(1877,11);
		    setTableColumnWidths(tableOne);
		    tableOne.setWidth(5*1440);
		    Integer i = 0;
		    while (iter.hasNext()) {
			GrouseDocument doc = (GrouseDocument) iter.next();
			System.out.println("kravnr=" + doc.getKravnr() + "\n");
			XWPFTableRow tableRowOne = tableOne.getRow(i);
			tableRowOne.getCell(0).setText(doc.getKravnr());

			tableRowOne.getCell(1).setText(doc.getOokrav());

			tableRowOne.getCell(2).setText(doc.getKravtype());

			tableRowOne.getCell(3).setText(doc.getMerknad());

			tableRowOne.getCell(4).setText(doc.getForklaring());

			tableRowOne.getCell(5).setText(doc.getKonsekvens());

			tableRowOne.getCell(6).setText(doc.getKonfnivaa());

			tableRowOne.getCell(7).setText(doc.getRefkrav());

			tableRowOne.getCell(8).setText(doc.getStatus());

			tableRowOne.getCell(9).setText(doc.getAnsvar());

			tableRowOne.getCell(10).setText(doc.getForklaring());

			i = i + 1;
		    }
		    document.write(fos);
		    fos.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		session.beginTransaction();
		GrouseDocument doc = new GrouseDocument();
		// doc.setKravnr("5.1.1");
		// doc.setOokrav("For at et system skal kunne godkjennes etter Noark5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.");
		// doc.setKravtype("O");
		// doc.setMerknad("TEST");
		// doc.setForklaring("TEST");
		// doc.setKonsekvens("TEST");
		// doc.setKonfnivaa("TEST");
		// doc.setRefkrav("TEST");
		// doc.setStatus("TEST");
		// doc.setAnsvar("TEJ");
		session.save(doc);
		session.getTransaction().commit();
	}
}
