package eu.xenit.docker.tomcat;

import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Test to check if the env TOMCAT_MAX_HTTP_HEADER_SIZE has any effect.
 * We rely on the value in docker compose:
 *      TOMCAT_MAX_HTTP_HEADER_SIZE=16384
 */
public class MaxHttpHeaderSizeTest extends TomcatIntegrationTest {

    public static final int HEADER_SIZE = 16384;

    @Test
    public void testHeaderSizeOK() {
        CheckRequestWithHeader(HEADER_SIZE-1000, 200);
    }

    @Test
    public void testHeaderSizeTooBig() {
        CheckRequestWithHeader(HEADER_SIZE+1000, 400);
    }

    private void CheckRequestWithHeader(int headerSizeInBytes, int expectedStatusCode) {
        given()
                .log().method()
                .log().uri()
                .log().headers()
                .header("BigHeader", RandomStringUtils.randomAlphabetic(headerSizeInBytes)) // public/proxy hostname
                .get(getTomcatUrl() + "/")

                .then()
                .log().status()
                .log().ifValidationFails()
                .statusCode(expectedStatusCode);
    }

}
