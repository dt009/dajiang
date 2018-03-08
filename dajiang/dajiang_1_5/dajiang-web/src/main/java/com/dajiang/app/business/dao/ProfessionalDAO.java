/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Professional;
import com.dajiang.app.business.po.req.ProfessionalQueryReqDTO;
import com.dajiang.app.business.po.resp.ProfessionalBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.ProfessionalRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface ProfessionalDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param professionalId
     */
    @Delete({
            "delete from t_professional",
            "where professional_id = #{professionalId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer professionalId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = ProfessionalSqlProvider.class, method = "insertSelective")
    int insertSelective(Professional record);


    @Select({
            "select",
            "professional_id, user_id, professional_name, professional_type_id, region_id, f_regionname(region_id) as region_str,",
            "professional_workunit, professional_workDT, professional_high_educ, ",
            "professional_position, professional_photo_path, professional_ID_front, professional_ID_back, ",
            "professional_level, professional_gender, professional_email, professional_phone, ",
            "professional_birth, professional_field, professional_IDCard, professional_indroduction, ",
            "professional_insertDT",
            "from t_professional",
            "where professional_id = #{professionalId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_str", property = "regionStr", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_workunit", property = "professionalWorkunit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workDT", property = "professionalWorkdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_high_educ", property = "professionalHighEduc", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_photo_path", property = "professionalPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_level", property = "professionalLevel", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_gender", property = "professionalGender", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_email", property = "professionalEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phone", property = "professionalPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_birth", property = "professionalBirth", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_field", property = "professionalField", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_indroduction", property = "professionalIndroduction", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_insertDT", property = "professionalInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    ProfessionalRespDTO selectBaseInfoByPrimaryKey(Integer professionalId);
    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param professionalId
     */
    @Select({
            "select",
            "professional_id, user_id, professional_name, professional_type_id, region_id, ",
            "professional_workunit, professional_workDT, professional_high_educ, ",
            "professional_position, professional_photo_path, professional_ID_front, professional_ID_back, ",
            "professional_level, professional_gender, professional_email, professional_phone, ",
            "professional_birth, professional_field, professional_IDCard, professional_indroduction, ",
            "professional_insertDT",
            "from t_professional",
            "where professional_id = #{professionalId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_workunit", property = "professionalWorkunit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workDT", property = "professionalWorkdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_high_educ", property = "professionalHighEduc", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_photo_path", property = "professionalPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_front", property = "professionalIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_back", property = "professionalIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_level", property = "professionalLevel", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_gender", property = "professionalGender", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_email", property = "professionalEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phone", property = "professionalPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_birth", property = "professionalBirth", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_field", property = "professionalField", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_IDCard", property = "professionalIdcard", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_indroduction", property = "professionalIndroduction", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_insertDT", property = "professionalInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    Professional selectByPrimaryKey(Integer professionalId);


    @Select({
            "select",
            "professional_id, user_id, professional_name, professional_type_id, f_prof_type(professional_type_id) as professional_type_str, region_id, f_regionname(region_id) as region_str, ",
            "professional_workunit, professional_workDT, professional_high_educ, ",
            "professional_position, professional_photo_path, professional_ID_front, professional_ID_back, ",
            "professional_level, professional_gender, professional_email, professional_phone, ",
            "professional_birth, professional_field, professional_IDCard, professional_indroduction, ",
            "professional_insertDT",
            "from t_professional",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_type_id", property = "professionalTypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_type_str", property = "professionalTypeStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER),
            @Result(column = "region_str", property = "regionStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workunit", property = "professionalWorkunit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workDT", property = "professionalWorkdt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_high_educ", property = "professionalHighEduc", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_photo_path", property = "professionalPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_front", property = "professionalIdFront", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_ID_back", property = "professionalIdBack", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_level", property = "professionalLevel", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_gender", property = "professionalGender", jdbcType = JdbcType.TINYINT),
            @Result(column = "professional_email", property = "professionalEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_phone", property = "professionalPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_birth", property = "professionalBirth", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "professional_field", property = "professionalField", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_indroduction", property = "professionalIndroduction", jdbcType = JdbcType.VARCHAR),
    })
    ProfessionalRespDTO selectByUserId(@Param("userId") Long userId);

    @Select({
            "select user_id from t_professional",
            "where professional_id = #{professionalId,jdbcType=BIGINT}"
    })
    Long selectUserIdByPrimaryKey(@Param("professionalId") Integer professionalId);


    @Select({
            "<script>",
            "select p.professional_id, p.professional_name, u.user_photo_path, p.professional_position, p.professional_workunit, p.professional_indroduction, f_regionname(region_id) as region_str, (select count(collection_id) from t_collection where professional_id=p.professional_id) as collection_num  from t_professional p",
            "left join t_user u on p.user_id=u.user_id",
            "where 1=1 ",
            "<if test=\"reqDTO != null and reqDTO.keyWord!=null and reqDTO.keyWord!='' \">",
            " and professional_name like CONCAT('%',#{reqDTO.keyWord},'%')",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.professionalTypeIds != null and reqDTO.professionalTypeIds.size() > 0\">",
            "and professional_type_id in",
            "<foreach collection=\"reqDTO.professionalTypeIds\" item=\"temp\" open=\"(\" separator=\",\" close=\")\">",
            "#{temp}",
            "</foreach>",
            "</if>",
            "<if test=\"reqDTO != null and reqDTO.regionIds != null and reqDTO.regionIds.size() > 0\">",
            "and region_id in",
            "<foreach collection=\"reqDTO.regionIds\" item=\"temp\" open=\"(\" separator=\",\" close=\")\">",
            "#{temp}",
            "</foreach>",
            "</if>",
            "order by professional_insertDT",
            "</script>",
    })
    @Results({
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_workunit", property = "professionalWorkunit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "region_str", property = "regionStr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_indroduction", property = "professionalIndroduction", jdbcType = JdbcType.VARCHAR),
            @Result(column = "collection_num", property = "collectionNum", jdbcType = JdbcType.INTEGER),
    })
    List<ProfessionalBaseInfoRespDTO> selectShowList(@Param("reqDTO") ProfessionalQueryReqDTO reqDTO);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = ProfessionalSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Professional record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_professional",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "professional_name = #{professionalName,jdbcType=VARCHAR},",
            "professional_type_id = #{professionalTypeId,jdbcType=INTEGER},",
            "region_id = #{regionId,jdbcType=INTEGER},",
            "professional_workunit = #{professionalWorkunit,jdbcType=VARCHAR},",
            "professional_workDT = #{professionalWorkdt,jdbcType=TIMESTAMP},",
            "professional_high_educ = #{professionalHighEduc,jdbcType=TINYINT},",
            "professional_position = #{professionalPosition,jdbcType=VARCHAR},",
            "professional_photo_path = #{professionalPhotoPath,jdbcType=VARCHAR},",
            "professional_ID_front = #{professionalIdFront,jdbcType=VARCHAR},",
            "professional_ID_back = #{professionalIdBack,jdbcType=VARCHAR},",
            "professional_level = #{professionalLevel,jdbcType=TINYINT},",
            "professional_gender = #{professionalGender,jdbcType=TINYINT},",
            "professional_email = #{professionalEmail,jdbcType=VARCHAR},",
            "professional_phone = #{professionalPhone,jdbcType=VARCHAR},",
            "professional_birth = #{professionalBirth,jdbcType=TIMESTAMP},",
            "professional_field = #{professionalField,jdbcType=VARCHAR},",
            "professional_IDCard = #{professionalIdcard,jdbcType=VARCHAR},",
            "professional_indroduction = #{professionalIndroduction,jdbcType=VARCHAR},",
            "professional_insertDT = #{professionalInsertdt,jdbcType=TIMESTAMP}",
            "where professional_id = #{professionalId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Professional record);

    class ProfessionalSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Professional record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_professional");

            if (record.getProfessionalId() != null) {
                sql.VALUES("professional_id", "#{professionalId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalName() != null) {
                sql.VALUES("professional_name", "#{professionalName,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalTypeId() != null) {
                sql.VALUES("professional_type_id", "#{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getRegionId() != null) {
                sql.VALUES("region_id", "#{regionId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalWorkunit() != null) {
                sql.VALUES("professional_workunit", "#{professionalWorkunit,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalWorkdt() != null) {
                sql.VALUES("professional_workDT", "#{professionalWorkdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalHighEduc() != null) {
                sql.VALUES("professional_high_educ", "#{professionalHighEduc,jdbcType=TINYINT}");
            }

            if (record.getProfessionalPosition() != null) {
                sql.VALUES("professional_position", "#{professionalPosition,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhotoPath() != null) {
                sql.VALUES("professional_photo_path", "#{professionalPhotoPath,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdFront() != null) {
                sql.VALUES("professional_ID_front", "#{professionalIdFront,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdBack() != null) {
                sql.VALUES("professional_ID_back", "#{professionalIdBack,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalLevel() != null) {
                sql.VALUES("professional_level", "#{professionalLevel,jdbcType=TINYINT}");
            }

            if (record.getProfessionalGender() != null) {
                sql.VALUES("professional_gender", "#{professionalGender,jdbcType=TINYINT}");
            }

            if (record.getProfessionalEmail() != null) {
                sql.VALUES("professional_email", "#{professionalEmail,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhone() != null) {
                sql.VALUES("professional_phone", "#{professionalPhone,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalBirth() != null) {
                sql.VALUES("professional_birth", "#{professionalBirth,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalField() != null) {
                sql.VALUES("professional_field", "#{professionalField,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdcard() != null) {
                sql.VALUES("professional_IDCard", "#{professionalIdcard,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIndroduction() != null) {
                sql.VALUES("professional_indroduction", "#{professionalIndroduction,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalInsertdt() != null) {
                sql.VALUES("professional_insertDT", "#{professionalInsertdt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Professional record) {
            SQL sql = new SQL();
            sql.UPDATE("t_professional");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalName() != null) {
                sql.SET("professional_name = #{professionalName,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalTypeId() != null) {
                sql.SET("professional_type_id = #{professionalTypeId,jdbcType=INTEGER}");
            }

            if (record.getRegionId() != null) {
                sql.SET("region_id = #{regionId,jdbcType=INTEGER}");
            }

            if (record.getProfessionalWorkunit() != null) {
                sql.SET("professional_workunit = #{professionalWorkunit,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalWorkdt() != null) {
                sql.SET("professional_workDT = #{professionalWorkdt,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalHighEduc() != null) {
                sql.SET("professional_high_educ = #{professionalHighEduc,jdbcType=TINYINT}");
            }

            if (record.getProfessionalPosition() != null) {
                sql.SET("professional_position = #{professionalPosition,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhotoPath() != null) {
                sql.SET("professional_photo_path = #{professionalPhotoPath,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdFront() != null) {
                sql.SET("professional_ID_front = #{professionalIdFront,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdBack() != null) {
                sql.SET("professional_ID_back = #{professionalIdBack,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalLevel() != null) {
                sql.SET("professional_level = #{professionalLevel,jdbcType=TINYINT}");
            }

            if (record.getProfessionalGender() != null) {
                sql.SET("professional_gender = #{professionalGender,jdbcType=TINYINT}");
            }

            if (record.getProfessionalEmail() != null) {
                sql.SET("professional_email = #{professionalEmail,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalPhone() != null) {
                sql.SET("professional_phone = #{professionalPhone,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalBirth() != null) {
                sql.SET("professional_birth = #{professionalBirth,jdbcType=TIMESTAMP}");
            }

            if (record.getProfessionalField() != null) {
                sql.SET("professional_field = #{professionalField,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIdcard() != null) {
                sql.SET("professional_IDCard = #{professionalIdcard,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalIndroduction() != null) {
                sql.SET("professional_indroduction = #{professionalIndroduction,jdbcType=VARCHAR}");
            }

            if (record.getProfessionalInsertdt() != null) {
                sql.SET("professional_insertDT = #{professionalInsertdt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("professional_id = #{professionalId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}