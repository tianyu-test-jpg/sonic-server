package org.cloud.sonic.controller.models.enums;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/24/16:46
 * @Description:
 */
public enum AppInfo {
    OPEN_APP("openApp"),
    CLOSED_APP("closedApp"),
    APP_Version("appVersion"),
    UDID("udid"),
    PLATFORM("platform"),
    APP_PACKAGE("appPackage");
    private String key;

    AppInfo(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


}
