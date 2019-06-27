package eu.xenit.tools.system.servletinfo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
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

}
