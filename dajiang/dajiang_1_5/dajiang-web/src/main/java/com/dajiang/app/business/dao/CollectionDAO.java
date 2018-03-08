/* github.com/zhouwd */
package com.dajiang.app.business.dao;

import com.dajiang.app.business.po.dmo.Collection;
import com.dajiang.app.business.po.resp.CollectionRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 本文件由 github.com/zhouwd/mybatis-generator-core 自动生成
 *
 * @author zhouwd code generator
 */
public interface CollectionDAO {
    /**
     * 根据主键删除数据库的记录
     *
     * @param userId
     * @param professionalId
     */
    @Delete({
            "delete from t_collection",
            "where user_id=#{userId} and professional_id = #{professionalId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("professionalId") Integer professionalId);

    /**
     * 动态字段,写入数据库记录
     *
     * @param record
     */
    @InsertProvider(type = CollectionSqlProvider.class, method = "insertSelective")
    int insertSelective(Collection record);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param collectionId
     */
    @Select({
            "select",
            "collection_id, user_id, professional_id, collection_insertDT",
            "from t_collection",
            "where collection_id = #{collectionId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "collection_id", property = "collectionId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER),
            @Result(column = "collection_insertDT", property = "collectionInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    Collection selectByPrimaryKey(Integer collectionId);

    @Select({
            "select",
            "collection_id, user_id, professional_id, collection_insertDT",
            "from t_collection",
            "where user_id = #{userId,jdbcType=BIGINT} and professional_id=#{professionalId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "collection_id", property = "collectionId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER),
            @Result(column = "collection_insertDT", property = "collectionInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    Collection selectByUserIdProId(@Param("userId") Long userId, @Param("professionalId") Integer professionalId);

    @Select({
            "select",
            "count(1)",
            "from t_collection",
            "where professional_id=#{professionalId,jdbcType=INTEGER}"
    })
    int selectCountByProId(@Param("professionalId") Integer professionalId);

    /**
     * 根据用户ID查询用户的收藏
     *
     * @param userId
     * @return
     */
    @Select({
            "select",
            "c.collection_id, c.user_id, c.professional_id, p.professional_name, p.professional_position, pu.user_photo_path, c.collection_insertDT",
            "from t_collection c",
            "left join t_professional p on c.professional_id=p.professional_id ",
            "left join t_user pu on pu.user_id=p.user_id ",
            "where c.user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "collection_id", property = "collectionId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "professional_id", property = "professionalId", jdbcType = JdbcType.INTEGER),
            @Result(column = "professional_name", property = "professionalName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "professional_position", property = "professionalPosition", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_photo_path", property = "userPhotoPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "collection_insertDT", property = "collectionInsertdt", jdbcType = JdbcType.TIMESTAMP)
    })
    List<CollectionRespDTO> selectByUserId(@Param("userId") Long userId);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @UpdateProvider(type = CollectionSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Collection record);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    @Update({
            "update t_collection",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "professional_id = #{professionalId,jdbcType=INTEGER},",
            "collection_insertDT = #{collectionInsertdt,jdbcType=TIMESTAMP}",
            "where collection_id = #{collectionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Collection record);


    class CollectionSqlProvider {

        /**
         * 动态字段,写入数据库记录
         *
         * @param record
         */
        public String insertSelective(Collection record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("t_collection");

            if (record.getCollectionId() != null) {
                sql.VALUES("collection_id", "#{collectionId,jdbcType=INTEGER}");
            }

            if (record.getUserId() != null) {
                sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalId() != null) {
                sql.VALUES("professional_id", "#{professionalId,jdbcType=INTEGER}");
            }

            if (record.getCollectionInsertdt() != null) {
                sql.VALUES("collection_insertDT", "#{collectionInsertdt,jdbcType=TIMESTAMP}");
            }

            return sql.toString();
        }

        /**
         * 动态字段,根据主键来更新符合条件的数据库记录
         *
         * @param record
         */
        public String updateByPrimaryKeySelective(Collection record) {
            SQL sql = new SQL();
            sql.UPDATE("t_collection");

            if (record.getUserId() != null) {
                sql.SET("user_id = #{userId,jdbcType=BIGINT}");
            }

            if (record.getProfessionalId() != null) {
                sql.SET("professional_id = #{professionalId,jdbcType=INTEGER}");
            }

            if (record.getCollectionInsertdt() != null) {
                sql.SET("collection_insertDT = #{collectionInsertdt,jdbcType=TIMESTAMP}");
            }

            sql.WHERE("collection_id = #{collectionId,jdbcType=INTEGER}");

            return sql.toString();
        }
    }
}