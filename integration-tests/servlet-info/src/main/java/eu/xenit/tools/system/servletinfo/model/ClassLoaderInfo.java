package eu.xenit.tools.system.servletinfo.model;

import java.net.URL;

public class ClassLoaderInfo {

    private final String name;
    private final String type;
    private final URL[] urls;

    public ClassLoaderInfo(String name, String type, URL[] urls) {
        this.name = name;
        this.type = type;
        this.urls = urls;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public URL[] getUrls() {
        return this.urls;
    }
}
