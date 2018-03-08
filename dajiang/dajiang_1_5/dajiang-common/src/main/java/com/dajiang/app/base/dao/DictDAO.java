package com.dajiang.app.base.dao;

import com.dajiang.app.base.po.dmo.DictDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Joe on 2017/9/23.
 */
public interface DictDAO {

    @Select({
            "select item_code,item_value from t_dict where dict_code=#{dictCode} order by display_seq asc",
    })
    @Results({
            @Result(column = "item_code", property = "itemCode", jdbcType = JdbcType.INTEGER),
            @Result(column = "item_value", property = "itemValue", jdbcType = JdbcType.VARCHAR),
    })
    List<DictDTO> selectByDictCode(@Param("dictCode") String dictCode);
}
