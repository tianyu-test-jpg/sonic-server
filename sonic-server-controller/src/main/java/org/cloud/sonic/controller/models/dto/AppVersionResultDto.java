package org.cloud.sonic.controller.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cloud.sonic.controller.models.domain.ResultPerformance;

import java.util.List;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/24/19:14
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppVersionResultDto {
    private String appVersion;
    private List<ResultPerformance> resultPerformances;
}
