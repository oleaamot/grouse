CREATE TABLE refkrav (
       navn varchar(100)
);

CREATE TABLE kravspec (
       kravnr varchar(100),
       beskrivelse varchar(2000),
       kravtype char(2),
       merknad varchar(1000),
       forklaring varchar(1000),
       konsekvens varchar(1000),
       konfnivaa varchar(100),
       refkrav varchar(100) REFERENCES refkrav(navn)
);

INSERT INTO refkrav VALUES ('systemtype');

INSERT INTO kravspec VALUES ('5.1.1', 'For at et system skal kunne godkjennes etter Noark 5-standarden, må den konseptuelle modellen av arkivstrukturen og de funksjonelle muligheter den gir, kunne implementeres i det aktuelle systemets (fysiske) datastrukturer.','O','','','','systemtype','TEJ');
