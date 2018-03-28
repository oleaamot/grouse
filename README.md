# Grouse

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/43102973d4064f63b8fdb4443fb39e26)](https://www.codacy.com/app/tsodring/grouse?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=KDRS-SA/grouse&amp;utm_campaign=Badge_Grade)

Grouse is a tool that can be used to generate a requirements document when 
purchasing a Noark 5 system

The application has two components, a spring-boot rest app running on
http://localhost:9294 and a web-gui part that needs a webserver to run.

See [INSTALL](INSTALL.md) for more details on how to get the application running

Once compiled to run the Grouse API simply run

    mvn spring-boot:run

Grouse runs in two persistence modes, the default is demo (no assigned profile,
as shown above) or a 'production' mode using a mysql database 
(mvn spring-boot:run -Dspring-boot.run.profiles=mysql). In demo mode the 
properties for the application are taken application.yml. Here Grouse uses H2
as a database. 

You can test that Grouse is running with one of the following commands: 

    curl -i -X GET http://localhost:9294/grouse/funksjon    
    curl -i -X GET http://localhost:9294/grouse/funksjon/meny/1

It will show you a list of the functionality areas Grouse supports.

Note, the codebase is under active development and has not yet exposed a lot of 
the required functionality.
