# remote-ejb-injection

This is a sample project for demonstrating inter-artifact communication between
artifacts (WARs, EJB JARs, EARs) deployed inside the same application server.

Here’s a usage scenario:

You have a web application packaged as a WAR that needs to use a service from a
large monolithic application that is packaged as an EAR. You annotate the
service interface with `@Remote`, extract it into a separate API JAR and
reference the API JAR from both the WAR and EAR projects. Then you implement
the service in an EJB JAR that is packaged into the EAR and inject the
interface with `@EJB` annotation as an instance field into a servlet in the
WAR.

It’s a Maven project with the following modules:

* *service-client* – servlet that calls the service, open
  <http://localhost:8080/service-client-1.0-SNAPSHOT/hello> to access it
* *service-ejb-api* – service interface with `@Remote` annotation
* *service-ejb-impl* – `@Stateless` EJB that implements the service interface
* *service-ear* – packages the EJB JAR into an EAR.

Build it with `mvn package` and deploy `service-ear/target/service-ear.ear` and
`service-client/target/service-client-1.0-SNAPSHOT.war` to the application
server to run it.
