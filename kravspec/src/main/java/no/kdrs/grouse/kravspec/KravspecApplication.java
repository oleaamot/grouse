package no.kdrs.grouse.kravspec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

@SpringBootApplication
public class KravspecApplication {
	public static void main(String[] args) {
		SpringApplication.run(KravspecApplication.class, args);
	}
	public static void run(String[] args) {
		KravspecApplication app = new KravspecApplication();
		app.newWordDoc("noark5-kravspec", "TESTDATA: Noark5 Kravspec Word dokument");
	}
	public void newWordDoc(String filename, String fileContent) {
		try {
			XWPFDocument document = new XWPFDocument();
			XWPFParagraph tmpParagraph = document.createParagraph();
			XWPFRun tmpRun = tmpParagraph.createRun();
			tmpRun.setText(fileContent);
			tmpRun.setFontSize(18);
			FileOutputStream fos = new FileOutputStream(new File(filename + ".doc"));
			document.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
