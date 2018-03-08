/* github.com/zhouwd */
package com.dajiang.app.base.dao;

import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.base.po.resp.UserRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface UserDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param userId
     */
    @Delete({
            "delete from t_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    int insertSelective(User record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param userId
     */
    @Select({
            "select",
            "user_id, user_type, login_id, user_photo_path, user_nickname, user_email, user_phone, ",
            "user_bank_accname, user_bankname, user_bankno, user_weixin, user_insertDT, user_updateDT",
            "from t_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_type", property = "userType", jdbcType = JdbcType.TINYINT),
            @Result(column = "login_id", property = "loginId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_nickname", property = "userNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_email", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_bank_accname", property = "userBankAccname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_bankname", property = "userBankname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_bankno", property = "userBankno", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_weixin", property = "userWeixin", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_insertDT", property = "userInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_updateDT", property = "userUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Long userId);

    @Select({
            "select",
            "user_id, user_nickname, login_id, user_phone, user_email, user_photo_path, user_type ",
            "from t_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "login_id", property = "loginId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_nickname", property = "userNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_email", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_type", property = "userType", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
    })
    User selectBaseInfo(@Param("userId") Long userId);

    @Select({
            "select",
            "user_id, user_type, login_id, user_phone, user_email, user_photo_path, user_insertDT",
            "from t_user",
            "where login_id = #{loginId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_type", property = "userType", jdbcType = JdbcType.INTEGER),
            @Result(column = "login_id", property = "loginId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_email", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_insertDT", property = "userInsertdt", jdbcType = JdbcType.TIMESTAMP),
    })
    UserRespDTO selectByLoginId(@Param("loginId") Integer loginId);

    @Select({
            "select",
            "user_id, user_type, login_id, user_phone, user_bankno, user_email, user_photo_path, ",
            "user_weixin, user_insertDT, user_updateDT",
            "from t_user",
            "where user_phone = #{userPhone,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_type", property = "userType", jdbcType = JdbcType.INTEGER),
            @Result(column = "login_id", property = "loginId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_bankno", property = "userBankno", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_email", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_weixin", property = "userWeixin", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_insertDT", property = "userInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_updateDT", property = "userUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<User> selectByPhone(@Param("userPhone") String userPhone);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_user",
            "set user_type = #{userType,jdbcType=TINYINT},",
            "login_id = #{loginId,jdbcType=INTEGER},",
            "user_photo_path = #{userPhotoPath,jdbcType=VARCHAR},",
            "user_nickname = #{userNickname,jdbcType=VARCHAR},",
            "user_email = #{userEmail,jdbcType=VARCHAR},",
            "user_phone = #{userPhone,jdbcType=VARCHAR},",
            "user_bank_accname = #{userBankAccname,jdbcType=VARCHAR},",
            "user_bankname = #{userBankname,jdbcType=VARCHAR},",
            "user_bankno = #{userBankno,jdbcType=VARCHAR},",
            "user_weixin = #{userWeixin,jdbcType=VARCHAR},",
            "user_insertDT = #{userInsertdt,jdbcType=TIMESTAMP},",
            "user_updateDT = #{userUpdatedt,jdbcType=TIMESTAMP}",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);

    class UserSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(User record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_user");

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getUserType() != null) {
                sql.VALUES("user_type", "#{userType,jdbcType=TINYINT}");
            }

            if (record.getLoginId() != null) {
                sql.VALUES("login_id", "#{loginId,jdbcType=INTEGER}");
            }

            if (record.getUserPhotoPath() != null) {
                sql.VALUES("user_photo_path", "#{userPhotoPath,jdbcType=VARCHAR}");
            }

            if (record.getUserNickname() != null) {
                sql.VALUES("user_nickname", "#{userNickname,jdbcType=VARCHAR}");
            }

            if (record.getUserEmail() != null) {
                sql.VALUES("user_email", "#{userEmail,jdbcType=VARCHAR}");
            }

            if (record.getUserPhone() != null) {
                sql.VALUES("user_phone", "#{userPhone,jdbcType=VARCHAR}");
            }

            if (record.getUserBankAccname() != null) {
                sql.VALUES("user_bank_accname", "#{userBankAccname,jdbcType=VARCHAR}");
            }

            if (record.getUserBankname() != null) {
                sql.VALUES("user_bankname", "#{userBankname,jdbcType=VARCHAR}");
            }

            if (record.getUserBankno() != null) {
                sql.VALUES("user_bankno", "#{userBankno,jdbcType=VARCHAR}");
            }

            if (record.getUserWeixin() != null) {
                sql.VALUES("user_weixin", "#{userWeixin,jdbcType=VARCHAR}");
            }

            if (record.getUserInsertdt() != null) {
                sql.VALUES("user_insertDT", "#{userInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getUserUpdatedt() != null) {
                sql.VALUES("user_updateDT", "#{userUpdatedt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(User record) {
            SQL sql = new SQL();
            sql.UPDATE("t_user");

            if (record.getUserType() != null) {
                sql.SET("user_type = #{userType,jdbcType=TINYINT}");
            }

            if (record.getLoginId() != null) {
                sql.SET("login_id = #{loginId,jdbcType=INTEGER}");
            }

            if (record.getUserPhotoPath() != null) {
                sql.SET("user_photo_path = #{userPhotoPath,jdbcType=VARCHAR}");
            }

            if (record.getUserNickname() != null) {
                sql.SET("user_nickname = #{userNickname,jdbcType=VARCHAR}");
            }

            if (record.getUserEmail() != null) {
                sql.SET("user_email = #{userEmail,jdbcType=VARCHAR}");
            }

            if (record.getUserPhone() != null) {
                sql.SET("user_phone = #{userPhone,jdbcType=VARCHAR}");
            }

            if (record.getUserBankAccname() != null) {
                sql.SET("user_bank_accname = #{userBankAccname,jdbcType=VARCHAR}");
            }

            if (record.getUserBankname() != null) {
                sql.SET("user_bankname = #{userBankname,jdbcType=VARCHAR}");
            }

            if (record.getUserBankno() != null) {
                sql.SET("user_bankno = #{userBankno,jdbcType=VARCHAR}");
            }

            if (record.getUserWeixin() != null) {
                sql.SET("user_weixin = #{userWeixin,jdbcType=VARCHAR}");
            }

            if (record.getUserInsertdt() != null) {
                sql.SET("user_insertDT = #{userInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getUserUpdatedt() != null) {
                sql.SET("user_updateDT = #{userUpdatedt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("user_id = #{userId,jdbcType=BIGINT}");

            return sql.toString();
        }
    }
}