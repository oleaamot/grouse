package no.kdrs.grouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
@SpringBootApplication
public class Grouse {
	public static void main(String[] args) {
		// SpringApplication.run(Grouse.class, args);
		System.out.println("Grouse + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
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
