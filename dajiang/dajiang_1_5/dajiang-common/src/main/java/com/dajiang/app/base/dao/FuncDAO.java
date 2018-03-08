package com.dajiang.app.base.dao;

import com.dajiang.app.base.po.dmo.FuncDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface FuncDAO {
    @Insert({"insert into t_sys_func (company_id, ", "parent_id, func_name, ", "func_type, func_action, ", "func_desc, display_sequence)", "values (#{companyId,jdbcType=INTEGER}, ", "#{parentId,jdbcType=INTEGER}, #{funcName,jdbcType=VARCHAR}, ", "#{funcType,jdbcType=VARCHAR}, #{funcAction,jdbcType=VARCHAR}, ", "#{funcDesc,jdbcType=VARCHAR}, #{displaySequence,jdbcType=INTEGER})"})
    @SelectKey(
            statement = {"SELECT LAST_INSERT_ID()"},
            keyProperty = "id",
            before = true,
            resultType = Integer.class
    )
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id"
    )
    int insertFuncDTO(FuncDTO var1);

    @Select({"select", "id, company_id, parent_id, func_name, func_type, func_action, func_desc, display_sequence", "from t_sys_func", "where id = #{id,jdbcType=INTEGER}"})
    @Results(
            {@Result(
                    column = "id",
                    property = "id",
                    jdbcType = JdbcType.INTEGER,
                    id = true
            ), @Result(
                    column = "company_id",
                    property = "companyId",
                    jdbcType = JdbcType.INTEGER
            ), @Result(
                    column = "parent_id",
                    property = "parentId",
                    jdbcType = JdbcType.INTEGER
            ), @Result(
                    column = "func_name",
                    property = "funcName",
                    jdbcType = JdbcType.VARCHAR
            ), @Result(
                    column = "func_type",
                    property = "funcType",
                    jdbcType = JdbcType.VARCHAR
            ), @Result(
                    column = "func_action",
                    property = "funcAction",
                    jdbcType = JdbcType.VARCHAR
            ), @Result(
                    column = "func_desc",
                    property = "funcDesc",
                    jdbcType = JdbcType.VARCHAR
            ), @Result(
                    column = "display_sequence",
                    property = "displaySequence",
                    jdbcType = JdbcType.INTEGER
            )})
    FuncDTO selectById(Integer var1);

    @Select({"select func_name from t_sys_func"})
    List<String> selectAllFunName();

    @Select({"select", "id, id `key`, id value, company_id, parent_id, func_name, func_type, func_action, func_desc, func_desc label, display_sequence", "from t_sys_func", "where func_type = #{funcType,jdbcType=VARCHAR} order by display_sequence"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "key",
            property = "key",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "value",
            property = "value",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "label",
            property = "label",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllFunByCompanyIdFuncDTOType(@Param("companyId") Integer var1, @Param("funcType") String var2);

    @Select({"select", "id, id `key`, id value, company_id, parent_id, func_name, func_type, func_action, func_desc, func_desc label, icon ,display_sequence", "from t_sys_func", "where func_type = #{funcType,jdbcType=VARCHAR} order by display_sequence"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "key",
            property = "key",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "value",
            property = "value",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "label",
            property = "label",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "icon",
            property = "icon",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectHisAllFunByCompanyIdFuncDTOType(@Param("companyId") Integer var1, @Param("funcType") String var2);

    @Select({"select", "id, id `key`, id value, company_id, parent_id, func_name, func_type, func_action, func_desc, func_desc label, display_sequence", "from t_sys_func", "where func_type = #{funcType,jdbcType=VARCHAR} order by display_sequence"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "key",
            property = "key",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "value",
            property = "value",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "label",
            property = "label",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllFunByFuncDTOType(@Param("funcType") String var1);

    @Select({"select DISTINCT t_sys_func.id, t_sys_func.company_id, t_sys_func.parent_id, t_sys_func.func_name, t_sys_func.func_type, ", "t_sys_func.func_action, t_sys_func.func_desc, t_sys_func.display_sequence  from t_sys_func ", "left join t_sys_role_func on t_sys_func.id = t_sys_role_func.t_sys_func_id ", "left join t_sys_role_user on t_sys_role_func.t_sys_role_id = t_sys_role_user.t_sys_role_id ", "left join t_sys_role on t_sys_role_user.t_sys_role_id = t_sys_role.id ", "where t_sys_role.company_id = #{companyId,jdbcType=INTEGER} and t_sys_role_user.user_id = #{userId,jdbcType=VARCHAR}  and t_sys_func.func_type = #{funcType,jdbcType=VARCHAR} order by t_sys_func.display_sequence "})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllFunByCompanyIdUserIdFunType(@Param("companyId") Integer var1, @Param("userId") String var2, @Param("funcType") String var3);

    @Select({"select DISTINCT t_sys_func.id, t_sys_func.company_id, t_sys_func.parent_id, t_sys_func.func_name, t_sys_func.func_type, ", "t_sys_func.func_action, t_sys_func.func_desc, t_sys_func.display_sequence,t_sys_func.icon  from t_sys_func ", "left join t_sys_role_func on t_sys_func.id = t_sys_role_func.t_sys_func_id ", "left join t_sys_role_user on t_sys_role_func.t_sys_role_id = t_sys_role_user.t_sys_role_id ", "left join t_sys_role on t_sys_role_user.t_sys_role_id = t_sys_role.id ", "where t_sys_role.company_id = #{companyId,jdbcType=INTEGER} and t_sys_role_user.user_id = #{userId,jdbcType=VARCHAR}  and t_sys_func.func_type = #{funcType,jdbcType=VARCHAR} order by t_sys_func.display_sequence "})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "icon",
            property = "icon",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectHisAllFunByCompanyIdUserIdFunType(@Param("companyId") Integer var1, @Param("userId") String var2, @Param("funcType") String var3);

    @Select({"select DISTINCT t_sys_func.id, t_sys_func.company_id, t_sys_func.parent_id, t_sys_func.func_name, t_sys_func.func_type, ", "t_sys_func.func_action, t_sys_func.func_desc, t_sys_func.display_sequence  from t_sys_func ", "left join t_sys_role_func on t_sys_func.id = t_sys_role_func.t_sys_func_id ", "left join t_sys_role_user on t_sys_role_func.t_sys_role_id = t_sys_role_user.t_sys_role_id ", "left join t_sys_role on t_sys_role_user.t_sys_role_id = t_sys_role.id ", "where t_sys_role_user.user_id = #{userId,jdbcType=VARCHAR}  and t_sys_func.func_type = #{funcType,jdbcType=VARCHAR} order by t_sys_func.display_sequence "})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllFunByUserIdFunType(@Param("userId") String var1, @Param("funcType") String var2);

    @Select({"select DISTINCT t_sys_func.id, t_sys_func.company_id, t_sys_func.parent_id, t_sys_func.func_name, t_sys_func.func_type, ", "t_sys_func.func_action, t_sys_func.func_desc, t_sys_func.display_sequence  from t_sys_func ", "left join t_sys_role_func on t_sys_func.id = t_sys_role_func.t_sys_func_id ", "left join t_sys_role_user on t_sys_role_func.t_sys_role_id = t_sys_role_user.t_sys_role_id ", "left join t_sys_role on t_sys_role_user.t_sys_role_id = t_sys_role.id ", "where t_sys_role.company_id = #{companyId,jdbcType=INTEGER} and t_sys_role_func.t_sys_role_id = #{roleId,jdbcType=VARCHAR}  and t_sys_func.func_type = #{funcType,jdbcType=VARCHAR} order by t_sys_func.display_sequence "})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllFunByCompanyIdRoleIdFunType(@Param("companyId") Integer var1, @Param("roleId") Integer var2, @Param("funcType") String var3);

    @Select({"select DISTINCT t_sys_func.id, t_sys_func.company_id, t_sys_func.parent_id, t_sys_func.func_name, t_sys_func.func_type, ", "t_sys_func.func_action, t_sys_func.func_desc, t_sys_func.display_sequence  from t_sys_func ", "LEFT JOIN t_sys_role_func ON t_sys_func.id = t_sys_role_func.t_sys_func_id ", "left join t_sys_role on t_sys_role_func.t_sys_role_id = t_sys_role.id ", "where t_sys_role_func.t_sys_role_id = #{roleId,jdbcType=VARCHAR} order by t_sys_func.display_sequence "})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllFunByCompanyIdAndRoleId(@Param("companyId") Integer var1, @Param("roleId") Integer var2);

    @Select({"select t_sys_func.func_name from t_sys_func ", "left join t_sys_role_func on t_sys_func.id = t_sys_role_func.t_sys_func_id ", "left join t_sys_role on t_sys_role_func.t_sys_role_id = t_sys_role.id ", "left join t_sys_role_user on t_sys_role.id = t_sys_role_user.t_sys_role_id ", "where t_sys_role.company_id= #{companyId,jdbcType=INTEGER} and t_sys_role_user.user_id = #{userId,jdbcType=VARCHAR}"})
    List<String> selectUserRoleFuncListByCompanyIdUserId(@Param("companyId") Integer var1, @Param("userId") String var2);

    @Select({"select", "id, company_id, parent_id, func_name, func_type, func_action, func_desc, display_sequence", "from t_sys_func", "where company_id = #{companyId,jdbcType=INTEGER} and func_action = #{funcAction,jdbcType=VARCHAR}"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    FuncDTO selectFunDTOByCompanyIdFuncDTOAction(@Param("companyId") Integer var1, @Param("funcAction") String var2);

    @Select({"select", "id, company_id, parent_id, func_name, func_type, func_action, func_desc, display_sequence", "from t_sys_func", "where parent_id = #{parentId,jdbcType=INTEGER} and func_type != \'BUTTON\'"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectFunsByParentId(@Param("parentId") Integer var1);

    @Select({"select", "id, company_id, parent_id, func_name, func_type, func_action, func_desc, display_sequence", "from t_sys_func", "where parent_id = #{parentId,jdbcType=INTEGER} and func_type = \'BUTTON\' order by func_type"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectButtonByParentId(@Param("parentId") Integer var1);

    @Select({"select", "id, company_id, parent_id, func_name, func_type, func_action, func_desc, display_sequence", "from t_sys_func", "where company_id = #{companyId,jdbcType=INTEGER} and func_type = \'BUTTON\' order by func_type"})
    @Results({@Result(
            column = "id",
            property = "id",
            jdbcType = JdbcType.INTEGER,
            id = true
    ), @Result(
            column = "company_id",
            property = "companyId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "parent_id",
            property = "parentId",
            jdbcType = JdbcType.INTEGER
    ), @Result(
            column = "func_name",
            property = "funcName",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_type",
            property = "funcType",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_action",
            property = "funcAction",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "func_desc",
            property = "funcDesc",
            jdbcType = JdbcType.VARCHAR
    ), @Result(
            column = "display_sequence",
            property = "displaySequence",
            jdbcType = JdbcType.INTEGER
    )})
    List<FuncDTO> selectAllButtonByCompany(@Param("companyId") Integer var1);
}