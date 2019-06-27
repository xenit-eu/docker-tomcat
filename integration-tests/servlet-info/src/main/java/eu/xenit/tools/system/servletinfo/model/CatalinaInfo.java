package eu.xenit.tools.system.servletinfo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
@AllArgsConstructor
public class CatalinaInfo {

    private final HashMap<String, String> properties;
    private final List<ClassLoaderInfo> classloaders;
}
