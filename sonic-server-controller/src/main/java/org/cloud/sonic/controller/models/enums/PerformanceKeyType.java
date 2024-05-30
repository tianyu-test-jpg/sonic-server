package org.cloud.sonic.controller.models.enums;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/24/16:24
 * @Description:
 */
public enum PerformanceKeyType {
    PROCESS("process"),
    FPS_INFO("fpsInfo"),
    CPU_INFO("cpuInfo"),
    MEMORY_INFO("memInfo"),
    FPS("fps"),
    CPU_UTILIZATION("cpuUtilization"),
    PHY_RSS("phyRSS"),
    VM_RSS("vmRSS"),
    TOTAL_PSS("totalPSS");

    private String key;

    PerformanceKeyType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
