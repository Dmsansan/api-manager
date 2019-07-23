package com.sansan.tool.api.user.mapper;

import com.sansan.tool.api.entity.user.ApiUser;
import com.sansan.tool.api.entity.user.ApiUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    long countByExample(ApiUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int deleteByExample(ApiUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int insert(ApiUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int insertSelective(ApiUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    List<ApiUser> selectByExample(ApiUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    ApiUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ApiUser record, @Param("example") ApiUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ApiUser record, @Param("example") ApiUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ApiUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table api_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ApiUser record);
}