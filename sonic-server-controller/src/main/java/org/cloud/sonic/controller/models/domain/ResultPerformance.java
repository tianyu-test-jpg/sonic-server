package org.cloud.sonic.controller.models.domain;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.dto.ResultPerformanceDTO;
import org.cloud.sonic.controller.models.interfaces.PlatformType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * @Author: Tian Yu
 * @Date: 2024/05/15/21:34
 * @Description:
 */

@Schema(name = "ResultPerformance对象", description = "性能测试结果表")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("result_performance")
@TableComment("性能测试结果表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class ResultPerformance implements Serializable, TypeConverter<ResultPerformance, ResultPerformanceDTO> {

    @TableId(value = "id", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;

    @TableField
    @Column(value = "project_id", isNull = false, comment = "所属项目id")
    @Index(value = "IDX_PROJECT_ID", columns = {"project_id"})
    private Integer projectId;

    @TableField
    @Column(isNull = false, comment = "用例名称")
    private String name;

    @TableField
    @Column(comment = "app版本")
    private String appVersion;

    @TableField
    @Column(comment = "app包名")
    private String appPackage;


    @TableField
    @Column(value = "case_id", isNull = false, comment = "测试用例id")
    private Integer caseId;


    @TableField
    @Column(value = "result_id", isNull = false, comment = "结果id")
    private Integer resultId;



    @TableField
    @Column(comment = "平均FPS", defaultValue = "0")
    private Double fps;

    @TableField
    @Column(comment = "平均物理内存(RSS)", defaultValue = "0")
    private Double phyRSS;

    @TableField
    @Column(comment = "平均虚拟内存(RSS)", defaultValue = "0")
    private Double vmRSS;

    @TableField
    @Column(comment = "平均总内存totalPSS", defaultValue = "0")
    private Double totalPSS;

    @TableField
    @Column(comment = "平均CPU使用率", defaultValue = "0")
    private Double cpu;

    @TableField
    @Column(comment = "设备系统类型，android：1，ios:2,鸿蒙：3", defaultValue = "1")
    private Integer platform;


    @TableField
    @Column(comment = "设备uid")
    private String udid;

    @TableField
    @Column(comment = "是否删除，0为未删除，1为删除")
    private int isDeleted;

    @TableField
    @Column(value = "create_time", type = MySqlTypeConstant.DATETIME, comment = "创建时间")
    private Date createTime;
}
