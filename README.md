# STEPS👀️ :

## PROJECT STARTER: SPRING INITIAZR

1. Check first your Java version in the terminal  =>    $java -version
2. Go to Spring Initlizr website and generate a new Spring Boot project

   * for this project, using the latest stable release: 2.6.0 and Java 17.
   * Choose Maven
3. Add the following dependencies:

   * Spring Boot DevTools
   * Lombok
   * Spring Web
   * Rest Repositories
   * Spring Security
   * Spring Data JPA
   * H2 Database
   * PostgresSQL Driver
4. Generate the project template and open it in IJ.

## Tips🚀️

* press option + command + L to format your code
* get the maven packages by reloading the project using maven
* use docker client for database
* 👀️ ****NOTE: Create first the Swagger UI or OPEN API before finishing the controller and REST API.
* 🚀️ ****NOTE:  Always run the application every time you create or a new file to check if it's still working / nothing is broken.

## POM.XML FILE

5. Add the javax.validation under the dependencies in the pom.xml file
6. Add the spring-boot-starter-validation under the dependencies in the pom.xml file

## CREATING MODELS/ENTITIES/DTOS

7. Create the following packages and files:

   1. [ ]  entity  =>. file ex. CharacterEntity
   2. [ ]  dto.    => file  ex. CharacterDto
   3. [ ]  contract (interface)
   4. [ ]  repository
   5. [ ]  service

## CREATING EXCEPTION PACKAGE

8. Create an exception package and add:

   1. [ ]  NotFoundException

## DTO Packages (One-time setup)

* Add modelmapper and mapstruct in the pom.xml

## Logging Package (One-time setup

* Add spring-boot-starter-log4j2 in the pom.xml
* Add log4j2-spring.xml in the main/resources folder

## Application Properties

* Update application.properties by adding h2 inmemory database for proof of concept

## Configurations (no-user and no-auth yet)

* Add spring-boot-configuration-processor in the pom.xml
* Create a config package inside the com.breakingbadspringboot.breakingbad folder
* Write a ModelMapperConfig configuration inside the config package
* Write a AppProperties configration inside the config package (DON'T PUT JWT SECRETS YET; JUST THE CLIENTURL)
* Write a CorsConfig configuration inside the config package, (DON'T PUT YET ANYTHING RELATED TO SECURITY)
* Write SecurityConfig configuration inside the config package, (NO SECURITY AND USER YET)
* NOTE: the SecurityConfig removes the default login page of the Spring Boot Security
* NOTE: Restart IDE if no beans can be found

## Creating Controller (no-auth yet)

* Create a controller file

## Seeding the Database

* Create a dataloader class to seed data into an empty database

## REST-Client for Postman/Insomnia Replacement

* Create REST-Client package in the root directory

## Swagger UI or OpenAPI

* Add springdoc-openapi-ui and springdoc-openapi-data-rest in the pom.xml
* Write SwaggerConfig configuration in the config package for custom Swagger UI
* Update the application.properties file with app.name, app.version, and app.description
* run the app and then go to this link: [http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/ (http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)

## Creating User Entity (for login/register)

* Create a user package under the com.breakingbad folder
* Add the following packages: entity, dto, service, repository, controller
* Add a BadRequestException interface inside the exception package

## Creating JWT

* Create a jwt package under the com.package
* Create models package under the jwt folder
* Add the ff files: UserPrincipal, AuthenticationRequest, AuthenticationResponse
* Create services package and add ApplicationUserDetailsService
* Add jjwt-api, jjwt-impl, and jjwt-jackson in the pom.xml
* Write AppProperties configuration in config package. For Jwt for now.
* Wrte PasswordConfig in config package
* Create util package under the jwt folder and add JwtUtil class
* Create filters package under the jwt folder and add JwtRequestFilter class
* Update the SecurityConfig with UserDetailsService, jwtFilter, configure, and http.addFilterBefore
* Create controllers package under the jwt folder and add AuthenticateController class
* Write and auth.http file inside the REST-Client folder
* Write a users.http file inside the REST-Client folder
* Run the application
* Trigger the POST http://localhost/8080/register
* Check the response if an object is returned
* Trigger the POST http://localhost/8080/authenticate
* Check if a token is returned

## Protected Endpoint
