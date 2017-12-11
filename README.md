Grouse is a tool that can be used to generate a requirements document when 
purchasing a Noark 5 system

The application has two components, a spring-boot rest app running on
http://localhost:9294 and a web-gui part that needs a webserver to run.

See [INSTALL](INSTALL.md) for more details on how to get the application running


Once compiled to run the Grouse API simply run

    mvn spring-boot:run -Dspring.profiles.active=demo

Note, the codebase is under active development and has not yet exposed a lot of the required functionality.
