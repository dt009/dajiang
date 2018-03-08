/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Cko;
import com.dajiang.app.business.po.req.CKOQueryReqDTO;
import com.dajiang.app.business.po.resp.CkoBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.CkoRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface CkoDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param ckoKey
     */
    @Delete({
            "delete from t_cko",
            "where cko_key = #{ckoKey,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ckoKey);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = CkoSqlProvider.class, method = "insertSelective")
    int insertSelective(Cko record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param ckoKey
     */
    @Select({
            "select",
            "cko_key, user_id, cko_name, cko_nickname, cko_phone, cko_email, region_id, cko_issearch, ",
            "cko_iscertification, cko_IDCard, cko_ID_front, cko_ID_back, cko_insertDT, cko_updateDT",
            "from t_cko",
            "where cko_key = #{ckoKey,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "cko_key", property = "ckoKey", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cko_name", property = "ckoName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_nickname", property = "ckoNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_phone", property = "ckoPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_email", property = "ckoEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "cko_issearch", property = "ckoIssearch", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_iscertification", property = "ckoIscertification", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_IDCard", property = "ckoIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_front", property = "ckoIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_back", property = "ckoIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_insertDT", property = "ckoInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "cko_updateDT", property = "ckoUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    Cko selectByPrimaryKey(Integer ckoKey);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = CkoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Cko record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_cko",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "cko_name = #{ckoName,jdbcType=VARCHAR},",
            "cko_nickname = #{ckoNickname,jdbcType=VARCHAR},",
            "cko_phone = #{ckoPhone,jdbcType=VARCHAR},",
            "cko_email = #{ckoEmail,jdbcType=VARCHAR},",
            "region_id = #{regionId,jdbcType=INTEGER},",
            "cko_issearch = #{ckoIssearch,jdbcType=TINYINT},",
            "cko_iscertification = #{ckoIscertification,jdbcType=TINYINT},",
            "cko_IDCard = #{ckoIdcard,jdbcType=VARCHAR},",
            "cko_ID_front = #{ckoIdFront,jdbcType=VARCHAR},",
            "cko_ID_back = #{ckoIdBack,jdbcType=VARCHAR},",
            "cko_insertDT = #{ckoInsertdt,jdbcType=TIMESTAMP},",
            "cko_updateDT = #{ckoUpdatedt,jdbcType=TIMESTAMP}",
            "where cko_key = #{ckoKey,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Cko record);

    @Select({
            "<script>",
            "select",
            "cko_key, t_cko.user_id, cko_name,t_user.user_nickname as cko_nickname,t_user.user_photo_path, cko_phone, cko_email, t_cko.region_id,f_regionname(region_id) as region_name ",
            "from t_cko",
            "left join t_user on t_cko.user_id=t_user.user_id",
            "where 1=1 and cko_issearch=1 ",
            "<if test=\"reqDTO!=null and reqDTO.regionIds != null and reqDTO.regionIds.size() > 0\">",
            "and region_id in",
            "<foreach collection=\"reqDTO.regionIds\" item=\"temp\" open=\"(\" separator=\",\" close=\")\">",
            "#{temp}",
            "</foreach>",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.keyWord!=null and reqDTO.keyWord!='' \">",
            " and t_user.user_nickname like CONCAT('%',#{reqDTO.keyWord},'%')",
            "</if>",
            "</script>",

    })
    @Results({
            @Result(column = "cko_key", property = "ckoKey", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cko_name", property = "ckoName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_nickname", property = "ckoNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_phone", property = "ckoPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_email", property = "ckoEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_name", property = "regionName", jdbcType = JdbcType.VARCHAR),
    })
    List<CkoRespDTO> selectForMore(@Param("reqDTO") CKOQueryReqDTO reqDTO);


    @Select({
            "select",
            "cko_key, user_id, cko_name, cko_nickname, cko_phone, cko_email, region_id, f_regionname(region_id) as region_name, cko_issearch, ",
            "cko_iscertification, cko_IDCard, cko_ID_front, cko_ID_back, cko_insertDT, cko_updateDT",
            "from t_cko",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "cko_key", property = "ckoKey", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cko_name", property = "ckoName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_nickname", property = "ckoNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_phone", property = "ckoPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_email", property = "ckoEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_name", property = "regionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_issearch", property = "ckoIssearch", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_iscertification", property = "ckoIscertification", jdbcType = JdbcType.TINYINT),
            @Result(column = "cko_IDCard", property = "ckoIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_front", property = "ckoIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_ID_back", property = "ckoIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_insertDT", property = "ckoInsertdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "cko_updateDT", property = "ckoUpdatedt", jdbcType = JdbcType.TIMESTAMP)
    })
    Cko selectByUserId(@Param("userId") Long userId);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param ckoKey
     */
    @Select({
            "select",
            "cko_key, user_id, cko_name, cko_nickname, cko_phone, cko_email, region_id, f_regionname(region_id) as region_name, cko_issearch, ",
            "cko_insertDT",
            "from t_cko",
            "where cko_key = #{ckoKey,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "cko_key", property = "ckoKey", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cko_name", property = "ckoName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_nickname", property = "ckoNickname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_phone", property = "ckoPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_email", property = "ckoEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_name", property = "regionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "cko_insertDT", property = "ckoInsertdt", jdbcType = JdbcType.TIMESTAMP),
    })
    CkoBaseInfoRespDTO selectBaseInfoByPrimaryKey(Integer ckoKey);

    class CkoSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Cko record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_cko");

            if (record.getCkoKey() != null) {
                sql.VALUES("cko_key", "#{ckoKey,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getCkoName() != null) {
                sql.VALUES("cko_name", "#{ckoName,jdbcType=VARCHAR}");
            }

            if (record.getCkoNickname() != null) {
                sql.VALUES("cko_nickname", "#{ckoNickname,jdbcType=VARCHAR}");
            }

            if (record.getCkoPhone() != null) {
                sql.VALUES("cko_phone", "#{ckoPhone,jdbcType=VARCHAR}");
            }

            if (record.getCkoEmail() != null) {
                sql.VALUES("cko_email", "#{ckoEmail,jdbcType=VARCHAR}");
            }

            if (record.getRegionId() != null) {
                sql.VALUES("region_id", "#{regionId,jdbcType=INTEGER}");
            }

            if (record.getCkoIssearch() != null) {
                sql.VALUES("cko_issearch", "#{ckoIssearch,jdbcType=TINYINT}");
            }

            if (record.getCkoIscertification() != null) {
                sql.VALUES("cko_iscertification", "#{ckoIscertification,jdbcType=TINYINT}");
            }

            if (record.getCkoIdcard() != null) {
                sql.VALUES("cko_IDCard", "#{ckoIdcard,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdFront() != null) {
                sql.VALUES("cko_ID_front", "#{ckoIdFront,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdBack() != null) {
                sql.VALUES("cko_ID_back", "#{ckoIdBack,jdbcType=VARCHAR}");
            }

            if (record.getCkoInsertdt() != null) {
                sql.VALUES("cko_insertDT", "#{ckoInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getCkoUpdatedt() != null) {
                sql.VALUES("cko_updateDT", "#{ckoUpdatedt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Cko record) {
            SQL sql = new SQL();
            sql.UPDATE("t_cko");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getCkoName() != null) {
                sql.SET("cko_name = #{ckoName,jdbcType=VARCHAR}");
            }

            if (record.getCkoNickname() != null) {
                sql.SET("cko_nickname = #{ckoNickname,jdbcType=VARCHAR}");
            }

            if (record.getCkoPhone() != null) {
                sql.SET("cko_phone = #{ckoPhone,jdbcType=VARCHAR}");
            }

            if (record.getCkoEmail() != null) {
                sql.SET("cko_email = #{ckoEmail,jdbcType=VARCHAR}");
            }

            if (record.getRegionId() != null) {
                sql.SET("region_id = #{regionId,jdbcType=INTEGER}");
            }

            if (record.getCkoIssearch() != null) {
                sql.SET("cko_issearch = #{ckoIssearch,jdbcType=TINYINT}");
            }

            if (record.getCkoIscertification() != null) {
                sql.SET("cko_iscertification = #{ckoIscertification,jdbcType=TINYINT}");
            }

            if (record.getCkoIdcard() != null) {
                sql.SET("cko_IDCard = #{ckoIdcard,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdFront() != null) {
                sql.SET("cko_ID_front = #{ckoIdFront,jdbcType=VARCHAR}");
            }

            if (record.getCkoIdBack() != null) {
                sql.SET("cko_ID_back = #{ckoIdBack,jdbcType=VARCHAR}");
            }

            if (record.getCkoInsertdt() != null) {
                sql.SET("cko_insertDT = #{ckoInsertdt,jdbcType=TIMESTAMP}");
            }

            if (record.getCkoUpdatedt() != null) {
                sql.SET("cko_updateDT = #{ckoUpdatedt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("cko_key = #{ckoKey,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}