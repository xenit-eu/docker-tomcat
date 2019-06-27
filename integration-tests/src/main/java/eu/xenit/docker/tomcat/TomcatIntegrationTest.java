package eu.xenit.docker.tomcat;

public class TomcatIntegrationTest {

    public static String getTomcatHostname() {
        return System.getProperty("tomcat.host", "localhost");
    }

    public static int getTomcatPort() {
        return Integer.parseInt(System.getProperty("tomcat.tcp.8080", "32784"));
    }

    public static String getTomcatUrl() {
        return "http://" + getTomcatHostname() + ":" + getTomcatPort();
    }
}
