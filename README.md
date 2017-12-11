Grouse is a tool that can be used to generate a requirements document when 
purchasing a Noark 5 system

The application has two components, a spring-boot rest app running on
http://localhost:9294 and a web-gui part that needs a webserver to run.

See [INSTALL](INSTALL.md) for more details on how to get the application running


Once compiled to run the Grouse API simply run

    mvn spring-boot:run -Dspring.profiles.active=demo

Grouse runs in two modes, default is production (no assigned profile) and demo (as shown above). In demo mode the
properties for the application are taken application-demo.yml and Grouse uses H2 as a database. In production mode 
(default) Grouse expects access to a mysql database. You will have set properties accordingly in application.yml  

You can test that Grouse is running with the following command: 

    curl -v -s -X GET http://localhost:9294/grouse/funksjon

It will show you a list of the functionality areas Grouse supports.

Note, the codebase is under active development and has not yet exposed a lot of the required functionality.
