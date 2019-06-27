package eu.xenit.tools.system.servletinfo;

import java.lang.management.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SystemInfoService {

//    SystemInfo getSystemInfo() {
//        return new SystemInfo()
//                .os(osInfo())
//                .java(javaInfo())
//                .cpu(cpuInfo());
//
//    }
//
//    private static OperatingSystemInfo osInfo() {
//        OperatingSystemMXBean osMXBean = ManagementFactory.getOperatingSystemMXBean();
//
//        return new OperatingSystemInfo()
//                .name(osMXBean.getName())
//                .version(osMXBean.getVersion())
//                .arch(osMXBean.getArch());
//
//    }
//
//    private static JavaInfo javaInfo() {
//
//        List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
//        List<String> gcs = gcMxBeans.stream()
//                .map(MemoryManagerMXBean::getName)
//                .collect(Collectors.toList());
//
//        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
//        Map<String, String> javaProperties =
//                runtimeMXBean.getSystemProperties().entrySet().stream()
//                        .filter(entry -> entry.getKey().startsWith("java"))
//                        .sorted(Map.Entry.comparingByKey())
//                        .collect(Collectors.toMap(
//                                entry -> entry.getKey().replace("java.", ""),
//                                Map.Entry::getValue,
//                                (oldValue, newValue) -> oldValue, LinkedHashMap::new
//                        ));
//
//        return new JavaInfo()
//                .inputArguments(runtimeMXBean.getInputArguments())
//                .garbageCollectors(gcs)
//                .systemProperties(javaProperties);
//    }
//
//    private static CpuInfo cpuInfo() {
//        OperatingSystemMXBean osMXBean = ManagementFactory.getOperatingSystemMXBean();
//        return new CpuInfo()
//                .processors(osMXBean.getAvailableProcessors());
//    }

}
