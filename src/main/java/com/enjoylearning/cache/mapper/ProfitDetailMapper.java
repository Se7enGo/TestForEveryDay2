package com.enjoylearning.cache.mapper;

public interface ProfitDetailMapper {/*
    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     *//*
    @Delete({
        "delete from profitdetail",
        "where code = #{code,jdbcType=CHAR}",
          "and pcode = #{pcode,jdbcType=CHAR}",
          "and price = #{price,jdbcType=DECIMAL}",
          "and usercode = #{usercode,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(ProfitDetailKey key);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     *//*
    @Insert({
        "insert into profitdetail (code, pcode, price, ",
        "usercode, creattime)",
        "values (#{code,jdbcType=CHAR}, #{pcode,jdbcType=CHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{usercode,jdbcType=CHAR}, #{creattime,jdbcType=TIMESTAMP})"
    })
    int insert(ProfitDetail record);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     *//*
    int insertSelective(ProfitDetail record);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     *//*
    @Select({
        "select",
        "code, pcode, price, usercode, creattime",
        "from profitdetail",
        "where code = #{code,jdbcType=CHAR}",
          "and pcode = #{pcode,jdbcType=CHAR}",
          "and price = #{price,jdbcType=DECIMAL}",
          "and usercode = #{usercode,jdbcType=CHAR}"
    })
    @ResultMap("BaseResultMap")
    ProfitDetail selectByPrimaryKey(ProfitDetailKey key);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     *//*
    int updateByPrimaryKeySelective(ProfitDetail record);

    *//**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     *//*
    @Update({
        "update profitdetail",
        "set creattime = #{creattime,jdbcType=TIMESTAMP}",
        "where code = #{code,jdbcType=CHAR}",
          "and pcode = #{pcode,jdbcType=CHAR}",
          "and price = #{price,jdbcType=DECIMAL}",
          "and usercode = #{usercode,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(ProfitDetail record);

    BigDecimal getProfitAmount(String usercode);*/
}