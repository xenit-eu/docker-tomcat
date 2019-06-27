package eu.xenit.tools.system.servletinfo.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.apache.catalina.startup.CatalinaProperties;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class SystemInfo {

    public SystemInfo()
    {

    }

    @JsonGetter("os")
    public Map<String, String> getOperationSystemInfo() {
        OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();

        Map<String,String> os = new LinkedHashMap<>();

        os.put("arch", osMxBean.getArch());
        os.put("name", osMxBean.getName());
        os.put("version", osMxBean.getVersion());
        os.put("cores", String.valueOf(osMxBean.getAvailableProcessors()));

        return os;
    }

    @JsonGetter("java")
    public Map<String, Object> getJavaInfo() {
        Map<String, Object> javaInfo = new LinkedHashMap<>();

        final RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();




        javaInfo.put("classpath", runtimeMxBean.getClassPath());
        //javaInfo.put("boot-classpath", runtimeMxBean.getBootClassPath());

        javaInfo.put("input-args", runtimeMxBean.getInputArguments());
//        javaInfo.put("system-properties", runtimeMxBean.getSystemProperties());
        javaInfo.put("spec", new HashMap<String, String>() {{
            put("name", runtimeMxBean.getSpecName());
            put("version", runtimeMxBean.getSpecVersion());
            put("vendor", runtimeMxBean.getSpecVendor());
        }});
//        javaInfo.put("vm", new HashMap<String, String>() {{
//            put("name", runtimeMxBean.getVmName());
//            put("version", runtimeMxBean.getVmVersion());
//            put("vendor", runtimeMxBean.getVmVendor());
//        }});

        final ClassLoader cl = SystemInfo.class.getClassLoader();
        javaInfo.put("catalina", this.getCatalinaInfo());

        return javaInfo;
    }

    private CatalinaInfo getCatalinaInfo() {
        return new CatalinaInfo(
                new HashMap<String, String>() {{
                    put("common.loader", CatalinaProperties.getProperty("common.loader"));
                    put("shared.loader", CatalinaProperties.getProperty("shared.loader"));
                }},
                this.getClassLoaderInfo()
        );
    }

    /**
     * Tomcat Classloader Hierarchy looks like this:
     *
     *      Bootstrap
     *          |
     *       System
     *          |
     *       Common
     *          |
     *      (Shared)* optional
     *       /     \
     *  Webapp1   Webapp2
     *
     * Starting from a webapp-classloader, we want to 'index' the classpaths,
     * It's a bit fishy to 'index' the classpath, starting from the assumption
     * this holds for all Tomcat-versions, but it's the best I can currently
     * come up with.
     *
     * We use this to test if our `common.loader` & `shared.loader` classpath
     * customizations actually work.
     *
     * @return
     */
    private List<ClassLoaderInfo> getClassLoaderInfo() {
        List<ClassLoaderInfo> result = new ArrayList<>();

        // The 'webapp' classloader
        ClassLoader classLoader = SystemInfo.class.getClassLoader();
        result.add(getClassLoaderProperties("webapp", classLoader));

        // The 'shared' class-loader will only be initialized if
        // `shared.loader` in catalina.properties is NOT empty
        // See http://svn.apache.org/viewvc/tomcat/trunk/java/org/apache/catalina/startup/Bootstrap.java?view=markup#l153
        String sharedLoaderValue = CatalinaProperties.getProperty("shared.loader");
        if ((sharedLoaderValue != null) && !sharedLoaderValue.equals(""))
        {
            classLoader = classLoader.getParent();
            result.add(getClassLoaderProperties("shared", classLoader));
        }

        // The 'common' class-loader will only be initialized if
        // `common.loader` in catalina.properties is NOT empty
        // See http://svn.apache.org/viewvc/tomcat/trunk/java/org/apache/catalina/startup/Bootstrap.java?view=markup#l147
        String commonLoaderValue = CatalinaProperties.getProperty("common.loader");
        if ((commonLoaderValue != null) && !commonLoaderValue.equals(""))
        {
            classLoader = classLoader.getParent();
            result.add(getClassLoaderProperties("common", classLoader));
        }

        // The 'system' classloader
        classLoader = classLoader.getParent();
        result.add(getClassLoaderProperties("system", classLoader));

        return result;
    }

    private ClassLoaderInfo getClassLoaderProperties(String name, ClassLoader classLoader) {

        boolean isUrlClassLoader = classLoader instanceof URLClassLoader;
        URL[] urls = isUrlClassLoader
                ? ((URLClassLoader) classLoader).getURLs()
                : new URL[0];

        return new ClassLoaderInfo(name, classLoader.getClass().getName(), urls);
    }


    private static List<Map<String, Object>> getGarbageCollectorInfo() {
        List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
        List<Map<String, Object>> gcSystems = new ArrayList<>();
        for (GarbageCollectorMXBean gcBean : gcMxBeans) {
            Map<String, Object> gcInstance = new LinkedHashMap<>();
            gcInstance.put("name", gcBean.getName());
            gcInstance.put("memory-pools", gcBean.getMemoryPoolNames());
            gcSystems.add(gcInstance);
        }
        return gcSystems;
    }
}
