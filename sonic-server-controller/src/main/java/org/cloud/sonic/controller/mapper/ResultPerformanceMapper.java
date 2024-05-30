package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.cloud.sonic.controller.models.domain.ResultPerformance;
import org.cloud.sonic.controller.models.domain.Roles;

import java.util.List;

/**
 * @Author: Tian Yu
 * @Date: 2024/05/15/23:54
 * @Description:
 */
@Mapper
public interface ResultPerformanceMapper extends BaseMapper<ResultPerformance> {
}
