package eu.xenit.tools.system.servletinfo.model;

import java.util.HashMap;
import java.util.List;

public class CatalinaInfo {

    private final HashMap<String, String> properties;
    private final List<ClassLoaderInfo> classloaders;

    public CatalinaInfo(HashMap<String, String> properties, List<ClassLoaderInfo> classloaders) {
        this.properties = properties;
        this.classloaders = classloaders;
    }

    public HashMap<String, String> getProperties() {
        return this.properties;
    }

    public List<ClassLoaderInfo> getClassloaders() {
        return this.classloaders;
    }
}
