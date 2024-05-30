package org.cloud.sonic.controller.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cloud.sonic.controller.models.domain.ResultPerformance;

import java.util.List;
import java.util.Map;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/24/19:10
 * @Description:
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlatformResultDto {
    private String platform;
    private Map<String, List<ResultPerformance>> appVersions;
}
