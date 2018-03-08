package com.dajiang.app.base.dao;

import com.dajiang.app.base.po.dmo.RegionDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Joe on 2017/9/23.
 */
public interface RegionDAO {


    @Select({
            "select region_id, region_name, region_level from t_region where region_parentid=#{parentId} and region_status=1",
    })
    @Results({
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_name", property = "regionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_level", property = "regionLevel", jdbcType = JdbcType.INTEGER),
    })
    List<RegionDTO> selectByPid(@Param("parentId") Integer parentId);

}
