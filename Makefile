all: run sql

build:
	mvn -Dmaven.test.skip=true clean install

run: build
	mvn -f pom.xml spring-boot:run

sql:	src/grouse.sql
	mysql grouse -uroot -ppassword -hlocalhost <src/grouse.sql

clean:
	mvn -Dmaven.test.skip=true clean
