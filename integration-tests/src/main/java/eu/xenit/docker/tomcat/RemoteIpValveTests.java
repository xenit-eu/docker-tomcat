package eu.xenit.docker.tomcat;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RemoteIpValveTests extends TomcatIntegrationTest {

    @Test
    public void testDefaultIndex() {

        given()
                .log().method()
                .log().uri()
                .get(getTomcatUrl() + "/")

                .then()
                .log().status()
                .log().ifValidationFails()
                .statusCode(200)
                .body("request.scheme", is("http"))
                .body("request.serverName", is(getTomcatHostname()))
                .body("request.serverPort", is(getTomcatPort()));
    }

    @Test
    public void testRemoteIpValve() {
        // Example request through our Nginx load-balancer
        // GET /alfresco/ HTTP/1.0
        // Host: alf1hubspot.dev.xenit.eu
        // X-Real-IP: 81.82.199.31
        // X-Forwarded-For: 81.82.199.31
        // X-Forwarded-Proto: https
        // Connection: close
        // User-Agent: HTTPie/0.9.4
        // Accept-Encoding: gzip, deflate
        // Accept: */*

        given()
                .log().method()
                .log().uri()
                .log().headers()
                .header("Host", "alf1hubspot.dev.xenit.eu") // public/proxy hostname
                .header("X-Forwarded-For", "81.82.199.31")  // client ip address
                .header("X-Forwarded-Proto", "https")       // public/proxy protocol
                .get(getTomcatUrl() + "/")

                .then()
                .log().status()
                .log().ifValidationFails()
                .statusCode(200)
                .body("request.scheme", is("https"))
                .body("request.serverName", is("alf1hubspot.dev.xenit.eu"))
                .body("request.serverPort", is(443))
                .body("request.remoteHost", is("81.82.199.31"));

    }
}
