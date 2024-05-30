package org.cloud.sonic.controller.models.enums;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/24/16:26
 * @Description:
 */
public enum StepKeyType {
    STEP("step"),
    PERFORMANCE("perform"),
    STATUS("status");
    private String key;

    StepKeyType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
