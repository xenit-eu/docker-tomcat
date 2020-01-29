package eu.xenit.tools.system.servletinfo.model;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

public class HttpRequestInfo {

    private final String scheme;
    private final String serverName;
    private final int serverPort;
    private final String localName;
    private final int localPort;
    private final String remoteHost;
    private final String remoteUser;
    private final String remoteAddr;
    private final int remotePort;

    private final HttpHeaders headers;
    private final Cookie[] cookies;

    public HttpRequestInfo(HttpServletRequest request) {
        this.serverName = request.getServerName();
        this.serverPort = request.getServerPort();
        this.scheme = request.getScheme();
        this.localName = request.getLocalName();
        this.localPort = request.getLocalPort();

        this.remoteHost = request.getRemoteHost();
        this.remoteAddr = request.getRemoteAddr();
        this.remotePort = request.getRemotePort();
        this.remoteUser = request.getRemoteUser();

        this.headers = new HttpHeaders();
        List<String> headerNames = Collections.list(request.getHeaderNames());
        for (String headerName : headerNames) {
            for (String headerValue : Collections.list(request.getHeaders(headerName)))
            this.headers.add(headerName, headerValue);
        }

        this.cookies = request.getCookies();
    }

    public HttpRequestInfo(String scheme, String serverName, int serverPort, String localName, int localPort,
            String remoteHost, String remoteUser, String remoteAddr, int remotePort, HttpHeaders headers,
            Cookie[] cookies) {
        this.scheme = scheme;
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.localName = localName;
        this.localPort = localPort;
        this.remoteHost = remoteHost;
        this.remoteUser = remoteUser;
        this.remoteAddr = remoteAddr;
        this.remotePort = remotePort;
        this.headers = headers;
        this.cookies = cookies;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getServerName() {
        return this.serverName;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public String getLocalName() {
        return this.localName;
    }

    public int getLocalPort() {
        return this.localPort;
    }

    public String getRemoteHost() {
        return this.remoteHost;
    }

    public String getRemoteUser() {
        return this.remoteUser;
    }

    public String getRemoteAddr() {
        return this.remoteAddr;
    }

    public int getRemotePort() {
        return this.remotePort;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public Cookie[] getCookies() {
        return this.cookies;
    }
}
