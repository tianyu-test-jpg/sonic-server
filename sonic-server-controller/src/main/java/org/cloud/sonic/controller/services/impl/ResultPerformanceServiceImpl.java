package org.cloud.sonic.controller.services.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.cloud.sonic.controller.mapper.ResultPerformanceMapper;
import org.cloud.sonic.controller.models.domain.ResultDetail;
import org.cloud.sonic.controller.models.domain.ResultPerformance;

import org.cloud.sonic.controller.services.ResultPerformanceService;
import org.cloud.sonic.controller.services.impl.base.SonicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @Author: Tian Yu
 * @Date: 2024/05/15/23:49
 * @Description:
 */
@Service
@Slf4j
public class ResultPerformanceServiceImpl extends SonicServiceImpl<ResultPerformanceMapper, ResultPerformance> implements ResultPerformanceService {


    @Override
    public Page<ResultPerformance> findAll(int platform, int projectId, int caseId, int resultId, String udid, String appVersion, String appPackage, Page<ResultPerformance> pageable) {
        LambdaQueryChainWrapper<ResultPerformance> lambdaQuery = lambdaQuery();
        lambdaQuery.eq(ResultPerformance::getPlatform, platform);
        lambdaQuery.eq(ResultPerformance::getProjectId, projectId);

        if (resultId != 0) {
            lambdaQuery.eq(ResultPerformance::getResultId, resultId);
        }
        if (caseId != 0) {
            lambdaQuery.eq(ResultPerformance::getCaseId, caseId);
        }
        if (udid != null && !udid.isEmpty()) {
            lambdaQuery.eq(ResultPerformance::getUdid, udid);
        }
        if (appVersion != null && !appVersion.isEmpty()) {
            lambdaQuery.eq(ResultPerformance::getAppVersion, appVersion);
        }
        if (appPackage != null && !appPackage.isEmpty()) {
            lambdaQuery.eq(ResultPerformance::getAppPackage, appPackage);
        }
        return lambdaQuery.orderByDesc(ResultPerformance::getCreateTime)
                .page(pageable);
    }

    @Override
    public boolean delete(int id) {
        if (baseMapper.selectById(id)!=null) {
            UpdateWrapper<ResultPerformance> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("is_deleted",1).eq("id",id);
            baseMapper.update(null,updateWrapper);
            return true;
        }
        return false;
    }
}
