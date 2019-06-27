package eu.xenit.tools.system.servletinfo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URL;

@Getter
@AllArgsConstructor
public class ClassLoaderInfo {

    private final String name;
    private final String type;
    private final URL[] urls;

}
