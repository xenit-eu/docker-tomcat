package eu.xenit.docker.tomcat;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class JdkTests extends TomcatIntegrationTest {

    @Test
    public void testJdkVersion() {
        given()
                .log().method()
                .log().uri()
                .get(getTomcatUrl() + "/")

                .then()
                .log().status()
                .log().ifValidationFails()
                .statusCode(200)
                .body("server.java.spec.version", is(System.getProperty("test.java.version")));
    }
}
