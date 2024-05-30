package org.cloud.sonic.controller.models.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.ResultPerformance;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/15/21:37
 * @Description:
 */

@Schema(name = "ResultPerformanceDTO对象", description = "测试性能结果数据传输对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultPerformanceDTO  implements Serializable , TypeConverter<ResultPerformanceDTO, ResultPerformance> {

    @Schema(description = "ID")
    private Integer id;

    @NotBlank
    @Schema(description = "用例名称", required = true, example = "测试用例")
    String name;

    @Schema(description = "app版本")
    private String appVersion;

    @Schema(description = "app包名")
    private String appPackage;

    @Schema(description = "测试用例ID")
    private Integer caseId;


    @Schema(description = "结果ID")
    private Integer resultId;

    @Schema(description = "FPS")
    private Double fps;

    @Schema(description = "物理内存(RSS)")
    private Double phyRSS;

    @Schema(description = "虚拟内存(RSS)")
    private Double vmRSS;

    @Schema(description = "总PSS")
    private Double totalPSS;

    @Schema(description = "CPU使用率")
    private Double cpu;

    @Schema(description = "设备系统类型")
    private Integer platform;


    @Schema(description = "设备uid")
    private String udid;

    @Schema(description = "是否删除，0为未删除，1为删除")
    private int isDeleted;

    @Schema(description = "创建时间", example = "2021-08-15 11:23:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;



}
