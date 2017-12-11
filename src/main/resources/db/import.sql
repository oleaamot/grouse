INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (0, '0', 'Kravspec', NULL);

INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (1, '1', 'Del 1', 0);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (2, '1.1', 'Dokumentets struktur', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (3, '1.1.1', 'Dokumentets struktur', 2);

INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (4, '1.2', 'Overordnet beskrivelse av ønsket løsning', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (5, '1.2.1', 'Innledning', 4);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (6, '1.2.2', 'Sentrale hensyn', 4);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (7, '1.2.3', 'Sentrale hensyn', 4);

INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (8, '1.3', 'Krav til ønsket løsning - veiledning til besvarelse', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (9, '1.3.1', 'Innledning', 8);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (10, '1.3.2', ' Om utfylling av tabellene', 8);

INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (11, '1.4', 'Funksjonelle krav til ønsket løsning', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (12, '1.5', 'Krav til oppfyllelse av NOARK5-krav O og B',
   'Å ivareta kravene stilt i den generelle lovgivningen som berører offentlig forvaltning.', 'Rediger meg',
   'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (13, '1.6', 'Krav til ivaretakelse av spesielle bestemmelser', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (14, '1.7', 'Krav til brukergrensesnitt og brukervennlighet',
   'Å sørge for at systemløsningen som velges både visuelt og strukturelt støtter brukernes oppgaver, fremmer bruk av systemet på en egnet måte, og letter arbeidshverdagen ved å være så intuitiv som mulig, samt ved å tilby brukeren målrettet hjelp med oppgavene ved behov.',
   'Rediger meg', 'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (15, '1.8', 'Krav til grunnleggende funksjonalitet for journalføring og arkivering', 'Rediger meg', 'Rediger meg',
   'Rediger meg', 14);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (16, '1.8.1', 'Krav til arkivstruktur, arkiv og arkivdeler', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (17, '1.8.2', 'Krav til klassifikasjonssystem og klasse', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (18, '1.8.3', 'Krav til mappe', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (19, '1.8.4', 'Krav til registrering', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (20, '1.8.5', 'Krav til dokumentbeskrivelse og dokumentobjekt', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (21, '1.8.6', 'Krav til nøkkelord', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (22, '1.8.7', 'Krav til kryssreferanse', 15);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (23, '1.8.8', 'Krav til dokumentfangst', 15);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (24, '1.9', 'Krav til gjenfinning – søk og rapporter', 'Rediger meg', 'Rediger meg', 'Rediger meg', 14);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (25, '1.9.1', 'Krav til søkefunksjonalitet', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (26, '1.9.2', 'Krav til bevaring og kassasjon', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (27, '1.9.3', 'Krav til periodisering', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (28, '1.9.4', 'Krav til avlevering', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (29, '1.9.5', 'Krav til administrasjon av kjernen', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (30, '1.9.6', 'Krav til sletting av dokumenter', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (31, '1.9.7', 'Krav til frysing av metadata og dokument', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (32, '1.9.8', 'Krav til oppsplitting og sammenslåing av mapper, flytting av registreringer', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (33, '1.9.9', 'Krav til presedens', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (34, '1.9.10', 'Krav til masseimport utløst fra NOARK5-kjerne', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (35, '1.9.11', 'Krav til elektroniske skjema for utfylling over internett', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (36, '1.9.12', 'Krav til elektronisk dokumentutveksling', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (37, '1.9.13', 'Krav til migrering mellom NOARK-løsninger', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (38, '1.9.14', 'Krav til tilgjengeliggjøring av offentlig journal på internett', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (39, '1.9.15', 'Krav til sikkerhet i kjernen', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (40, '1.9.16', 'Krav til rettighetsangivelser', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (41, '1.9.17', 'Krav til skjerming og gradering', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (42, '1.9.18', 'Krav knyttet til arkivformat og andre format', 24);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (43, '1.9.19', 'Krav knyttet til masseoppdatering', 24);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (44, '1.10', 'Krav til adresseregister', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (45, '0.0', 'Dummy - do not delete me. Im needed becuase of bad system design', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (46, '1.11', 'Krav til saksbehandlingsløsninger',
   'å sikre at saksbehandlere og ledere opplever at systemet har funksjonalitet som støtter dem i deres daglige arbeid, og at bruken av systemet ikke krever mer innsats enn den gevinsten som systemet gir.',
   'Rediger meg', 'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (47, '1.11.1', 'Krav til saksoppfølging', 46);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (48, '1.11.2', 'Krav til dokumentproduksjon', 46);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (49, '1.11.3', 'Krav til maler', 46);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (50, '1.11.4', 'Krav til saks- og dokumenthistorikk', 46);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (51, '1.11.5', 'Krav til dokumentflyt', 46);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (52, '1.11.6', 'Krav til arbeidsflyt', 46);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (53, '1.11.7', 'Øvrige krav til saksbehandlerfunksjonalitet', 46);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (54, '1.12', 'Krav til E-post', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (55, '1.12.1', 'Overordnede krav til e-postfunksjonalitet',
   'Sikre at all kommunikasjon mottatt og sendt via e-post blir journalført, samt effektivisere hverdagen ved å tilrettelegge for utstrakt bruk av e-post i saksbe­handlingen.',
   'Rediger meg', 'Rediger meg', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (56, '1.12.2', 'Krav til dokumentfangst, e-posthode og e-postmelding', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (57, '1.12.3', 'Ekspedering av dokumenter med epost / som e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (58, '1.12.4', 'Krav til import / registrering av innkommet e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (59, '1.12.5', 'Krav til å sende kopi av saksdokumenter per e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (60, '1.12.6', 'Krav til sikkerhetshåndtering av e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (61, '1.12.7', 'Tidsstempling av e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (62, '1.12.8', 'Ikke-benekting ved bruk av e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent) VALUES (63, '1.12.9', 'Konfidensialitet', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (64, '1.12.10', 'Kryptering av e-post', 54);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (65, '1.12.11', 'Integritetssikring ved elektronisk signering', 54);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (66, '1.13', 'Krav til funksjonalitet for utvalgsbehandling', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (67, '1.13.1', 'Krav til utvalgsbehandling – administrativ sak', 66);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (68, '1.13.2', 'Krav til utvalgsbehandling – generelle krav', 66);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (69, '1.13.3', 'Krav til utvalgsbehandling – administrere beslutningsorgan', 66);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (70, '1.13.4', 'Krav til utvalgsbehandling – forberede møte', 66);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (71, '1.13.5', 'Krav til utvalgsbehandling – selve møtet', 66);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (72, '1.13.6', 'Krav til utvalgsbehandling – etter møtet', 66);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (73, '1.13.7', 'Krav til utvalgsbehandling – administrasjon av møtebehandlingen', 66);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (74, '1.14', 'Krav til funksjonalitet for byggesaksmodul', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (75, '1.15', 'Krav til funksjonalitet for publisering av offentlige dokumenter', 'Rediger meg', 'Rediger meg',
   'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (76, '1.15.1', 'Funksjonalitet og presentasjon', 75);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (77, '1.15.2', 'Krav til sikkerhet og tilgjengelighet for offentlig journal', 75);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (78, '1.16', 'Krav til rapporter og statistikker', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (79, '1.16.1', 'Krav til anbefalte statistikker og rapporter jf. NOARK5', 78);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (80, '1.16.2', 'Krav til andre rapporter og statistikker', 78);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (81, '1.17', 'Krav til administrasjon av løsningen', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (82, '1.17.1', 'Overordnede krav til administrasjon av løsningen', 81);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (83, '1.17.2', 'Krav til administrativ struktur', 81);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (84, '1.17.3', 'Krav til brukeradministrasjon', 81);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (85, '1.17.4', 'Krav til roller, rettigheter og brukers relasjon til adm enhet, journalenhet og arkivdel', 81);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (86, '1.18', 'Krav til sikkerhet, sporbarhet og kontroll', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (87, '1.18.1', 'Overordnede krav til sikkerhet', 87);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (88, '1.18.2', 'Krav til roller og rettigheter', 87);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (89, '1.18.3', 'Krav til autorisasjon og autentisering', 87);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (90, '1.18.4', 'Krav til autorisasjon av stedfortredere', 87);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (91, '1.18.5', 'Krav til identifisering av virksomhetseksterne brukere', 87);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (92, '1.18.6', 'Krav til håndtering av historiske brukeridenter', 87);
INSERT INTO functionality_areas (id, functionality_number, title, parent)
VALUES (93, '1.18.7', 'Krav til sikring av elektronisk avsendte og mottatte dokumenter', 87);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (94, '1.19', 'Krav til sporbarhet og kontroll', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (95, '1.20', 'Krav til validering', 'Rediger meg', 'Rediger meg', 'Rediger meg', 1);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (96, '2', 'Del 2 - Tekniske krav til ønsket løsning', 'Rediger meg', 'Rediger meg', 'Rediger meg', 0);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (97, '2.1', 'Krav til arkivdatabase', 'Rediger meg', 'Rediger meg', 'Rediger meg', 96);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (98, '2.2', 'Tekniske krav', 'Rediger meg', 'Rediger meg', 'Rediger meg', 96);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (99, '2.3', 'Krav til servere', 'Rediger meg', 'Rediger meg', 'Rediger meg', 96);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (100, '2.4', 'Krav til klienter', 'Rediger meg', 'Rediger meg', 'Rediger meg', 96);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (101, '2.5', 'Generelle tekniske krav', 'Rediger meg', 'Rediger meg', 'Rediger meg', 96);

INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (102, '3', 'Del 3 - Krav til integrasjoner i ønsket løsning', 'Rediger meg', 'Rediger meg', 'Rediger meg', 0);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (103, '3.1', 'Overordnede og generelle krav knyttet til integrasjoner', 'Rediger meg', 'Rediger meg', 'Rediger meg',
   103);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (104, '3.2', 'Krav til skanning', 'Rediger meg', 'Rediger meg', 'Rediger meg', 103);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (105, '3.3', 'Krav til mottak av elektroniske skjema', 'Rediger meg', 'Rediger meg', 'Rediger meg', 103);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (106, '3.4', 'Krav til integrasjon mot kartsystem', 'Rediger meg', 'Rediger meg', 'Rediger meg', 103);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent) VALUES
  (107, '3.5', 'Krav til integrasjon mot fagsystemer og interne og eksterne systemer', 'Rediger meg', 'Rediger meg',
   'Rediger meg', 103);
INSERT INTO functionality_areas (id, functionality_number, title, description, explanation, consequence, parent)
VALUES (108, '3.6', 'Krav til konvertering', 'Rediger meg', 'Rediger meg', 'Rediger meg', 103);


INSERT INTO requirements (requirement_id, requirement_number, requirement_text, requirement_type, explanation, conformity_level, consequence, reference_requirement, functionality, priority, noark_version)
VALUES (1, '5.1.1', 'Dette er krav nummer 5.1.1.', 'O',
           'For at et system skal kunne godkjennes etter Noark 5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.',
           '', '', '', '0', '1', '4.0');
INSERT INTO requirements (requirement_id, requirement_number, requirement_text, requirement_type, explanation, conformity_level, consequence, reference_requirement, functionality, priority, noark_version)
VALUES (2, '5.1.2', 'Dette er krav nummer 5.1.1.', 'O',
           'For at et system skal kunne godkjennes etter Noark 5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.',
           '', '', '', '0', '1', '4.0');
INSERT INTO requirements (requirement_id, requirement_number, requirement_text, requirement_type, explanation, conformity_level, consequence, reference_requirement, functionality, priority, noark_version)
VALUES (3, '5.1.3', 'Dette er krav nummer 5.1.1.', 'O',
           'For at et system skal kunne godkjennes etter Noark 5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.',
           '', '', '', '0', 'O', '4.0');
INSERT INTO requirements (requirement_id, requirement_number, requirement_text, requirement_type, explanation, conformity_level, consequence, reference_requirement, functionality, priority, noark_version)
VALUES (4, '5.1.4', 'Dette er krav nummer 5.1.1.', 'O',
           'For at et system skal kunne godkjennes etter Noark 5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.',
           '', '', '', '0', '2', '4.0');

INSERT INTO projects (project_id, file_name, project_name, project_number, project_owner)
VALUES (1, 'kravspec', 'Eksempel kommune kravspec', '1', 'Link to user table when it is in place');


INSERT INTO project_requirement (requirement_id, project_id) VALUES (1, 1);
INSERT INTO project_requirement (requirement_id, project_id) VALUES (2, 1);
INSERT INTO project_requirement (requirement_id, project_id) VALUES (3, 1);
INSERT INTO project_requirement (requirement_id, project_id) VALUES (4, 1);
