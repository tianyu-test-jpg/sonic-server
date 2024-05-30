package org.cloud.sonic.controller.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.cloud.sonic.common.config.WebAspect;
import org.cloud.sonic.common.http.RespEnum;
import org.cloud.sonic.common.http.RespModel;
import org.cloud.sonic.controller.models.base.CommentPage;
import org.cloud.sonic.controller.models.domain.ResultDetail;
import org.cloud.sonic.controller.models.domain.ResultPerformance;
import org.cloud.sonic.controller.services.ResultPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/24/19:35
 * @Description:
 */

@Tag(name = "性能测试结果相关")
@RestController
@RequestMapping("/resultPerformance")
public class ResultPerformanceController {
    @Autowired
    ResultPerformanceService resultPerformanceService;

    @WebAspect
    @Operation(summary = "查找性能测试结果", description = "查找性能测试结果")
    @Parameters(value = {
            @Parameter(name = "platform", description = "系统类型"),
            @Parameter(name = "projectId", description = "项目id"),
            @Parameter(name = "caseId", description = "测试用例id"),
            @Parameter(name = "resultId", description = "测试结果id"),
            @Parameter(name = "udid", description = "设备id"),
            @Parameter(name = "appVersion", description = "app版本"),
            @Parameter(name = "appPackage", description = "app包名"),
            @Parameter(name = "page", description = "页码")
    })
    @GetMapping("/list")
    public RespModel<CommentPage<ResultPerformance>> findAll(@RequestParam(name = "platform") int platform,
                                                             @RequestParam(name = "projectId") int projectId,
                                                             @RequestParam(name = "caseId",required = false,defaultValue = "0") int caseId,
                                                             @RequestParam(name = "resultId",required = false,defaultValue = "0") int resultId,
                                                             @RequestParam(name = "udid",required = false) String udid,
                                                             @RequestParam(name = "appVersion",required = false) String appVersion,
                                                             @RequestParam(name = "appPackage",required = false) String appPackage,
                                                             @RequestParam(name = "page") int page) {
        Page<ResultPerformance> pageable = new Page<>(page, 20);

        return new RespModel<>(RespEnum.SEARCH_OK, CommentPage.convertFrom(resultPerformanceService.findAll(platform, projectId,caseId, resultId, udid, appVersion, appPackage, pageable)));
    }



    @WebAspect
    @Operation(summary = "删除性能测试结果", description = "删除对应的性能测试结果")
    @Parameter(name = "id", description = "id")
    @DeleteMapping
    public RespModel<String> delete(@RequestParam(name = "id") int id) {
        if (resultPerformanceService.delete(id)) {
            return new RespModel<>(RespEnum.DELETE_OK);
        } else {
            return new RespModel<>(RespEnum.ID_NOT_FOUND);
        }
    }
}
