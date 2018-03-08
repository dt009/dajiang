/* github.com/zhouwd */
package com.dajiang.app.base.dao;

import com.dajiang.app.base.po.dmo.LoginDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface LoginDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param loginId
     */
    @Delete({
            "delete from t_login",
            "where login_id = #{loginId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer loginId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = LoginSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "loginId", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "loginId", keyColumn = "login_id")
    int insertSelective(LoginDTO record);


    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param loginId
     */
    @Select({
            "select",
            "login_id, login_name, login_passwd, login_errornum, login_insertDT, login_lastDT",
            "from t_login",
            "where login_id = #{loginId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "login_id", property = "loginId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "login_name", property = "loginName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "login_passwd", property = "loginPasswd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "login_errornum", property = "loginErrornum", jdbcType = JdbcType.INTEGER),
            @Result(column = "login_insertDT", property = "loginInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "login_lastDT", property = "loginLastdt", jdbcType = JdbcType.TIMESTAMP)
    })
    LoginDTO selectByPrimaryKey(Integer loginId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = LoginSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoginDTO record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_login",
            "set login_name = #{loginName,jdbcType=VARCHAR},",
            "login_passwd = #{loginPasswd,jdbcType=VARCHAR},",
            "login_errornum = #{loginErrornum,jdbcType=INTEGER},",
            "login_insertDT = #{loginInsertdt,jdbcType=TIMESTAMP},",
            "login_lastDT = #{loginLastdt,jdbcType=TIMESTAMP}",
            "where login_id = #{loginId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LoginDTO record);

    @Update({
            "update t_login",
            "set",
            "login_passwd = #{loginPasswd,jdbcType=VARCHAR},",
            "login_errornum = 0",
            "where login_name = #{loginName,jdbcType=VARCHAR}"
    })
    int updatePasswordByUserPhone(LoginDTO record);

    @Select({
            "select",
            "login_id, login_name, login_passwd, login_errornum, login_insertDT, login_lastDT",
            "from t_login",
            "where login_name = #{loginName,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "login_id", property = "loginId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "login_name", property = "loginName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "login_passwd", property = "loginPasswd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "login_errornum", property = "loginErrornum", jdbcType = JdbcType.INTEGER),
            @Result(column = "login_insertDT", property = "loginInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "login_lastDT", property = "loginLastdt", jdbcType = JdbcType.TIMESTAMP)
    })
    LoginDTO selectByLoginName(@Param("loginName") String loginName);


    class LoginSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(LoginDTO record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_login");

            if (record.getLoginId() != null) {
                sql.VALUES("login_id", "#{loginId,jdbcType=INTEGER}");
            }

            if (record.getLoginName() != null) {
                sql.VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
            }

            if (record.getLoginPasswd() != null) {
                sql.VALUES("login_passwd", "#{loginPasswd,jdbcType=VARCHAR}");
            }

            if (record.getLoginErrornum() != null) {
                sql.VALUES("login_errornum", "#{loginErrornum,jdbcType=INTEGER}");
            }

            if (record.getLoginInsertdt() != null) {
                sql.VALUES("login_insertDT", "#{loginInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getLoginLastdt() != null) {
                sql.VALUES("login_lastDT", "#{loginLastdt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(LoginDTO record) {
            SQL sql = new SQL();
            sql.UPDATE("t_login");

            if (record.getLoginName() != null) {
                sql.SET("login_name = #{loginName,jdbcType=VARCHAR}");
            }

            if (record.getLoginPasswd() != null) {
                sql.SET("login_passwd = #{loginPasswd,jdbcType=VARCHAR}");
            }

            if (record.getLoginErrornum() != null) {
                sql.SET("login_errornum = #{loginErrornum,jdbcType=INTEGER}");
            }

            if (record.getLoginInsertdt() != null) {
                sql.SET("login_insertDT = #{loginInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getLoginLastdt() != null) {
                sql.SET("login_lastDT = #{loginLastdt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("login_id = #{loginId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}