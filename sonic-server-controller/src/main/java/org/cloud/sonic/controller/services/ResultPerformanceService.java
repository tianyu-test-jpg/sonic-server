package org.cloud.sonic.controller.services;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.cloud.sonic.controller.models.domain.ResultPerformance;


/**
 * @Author: Tian Yu
 * @Date: 2024/05/15/23:39
 * @Description:
 */
public interface ResultPerformanceService extends IService<ResultPerformance> {
    Page<ResultPerformance> findAll(int platform, int projectId, int caseId, int resultId, String udid, String appVersion, String appPackage, Page<ResultPerformance> pageable);

    boolean delete(int id);
}
