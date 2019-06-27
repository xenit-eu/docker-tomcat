package eu.xenit.docker.tomcat;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class ClasspathTests extends TomcatIntegrationTest {

    @Test
    public void testCommonClasspath() {
        given()
                .log().method()
                .log().uri()
                .get(getTomcatUrl() + "/")

                .then()
                .log().status()
                .log().ifValidationFails()
                .statusCode(200)
                .body("server.java.catalina.classloaders.name", hasItems("common", "shared"))
                .body("server.java.catalina.classloaders.find { it.name == 'common'}.urls",
                      hasItems("file:/jdbc/mysql-connector-java-5.1.42.jar"))
                .body("server.java.catalina.classloaders.find { it.name == 'shared'}.urls",
                        hasItems("file:/jdbc/mysql-connector-java-5.1.42.jar"))
        ;
    }
}
