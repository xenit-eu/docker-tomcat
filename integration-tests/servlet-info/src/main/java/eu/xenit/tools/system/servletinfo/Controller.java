package eu.xenit.tools.system.servletinfo;

import eu.xenit.tools.system.servletinfo.model.HttpRequestInfo;

import eu.xenit.tools.system.servletinfo.model.SystemInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, Object> info(final HttpServletRequest request) {
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("request", new HttpRequestInfo(request));
        result.put("server", new SystemInfo());

        return result;
    }
}
