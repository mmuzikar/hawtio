# Hawtio Quarkus Example

This sample application shows how to run Hawtio with Quarkus.

## How to run

Run in development mode with:

```console
mvn compile quarkus:dev
```

Or build the project and execute the runnable JAR:

```console
mvn package && java -jar target/quarkus-app/quarkus-run.jar
```

Hawtio is available at <http://localhost:8080/hawtio>.

By default, authentication is enabled with username `hawtio` & password `hawtio`.
This can be customized together with some of the other Hawtio configuration options by editing
[src/main/resources/application.properties](./src/main/resources/application.properties).


### Enabling keycloak auth
For dev mode you can just specify to use the `keycloak` profile
```console
mvn quarkus:dev -Dquarkus.profile=keycloak
```

For jars you can produce a mutable jar, change the configuration and then run the jar:
```console
mvn install -Dquarkus.package.type=mutable-jar
java -jar -Dquarkus.launch.rebuild=true -Dquarkus.profile=keycloak target/quarkus-app/quarkus-run.jar
java -jar target/quarkus-app/quarkus-run.jar
```
