package com.enjoylearning.cache.entity;

import java.math.BigDecimal;

public class ProfitDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column profitdetail.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column profitdetail.pcode
     *
     * @mbggenerated
     */
    private String pcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column profitdetail.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column profitdetail.usercode
     *
     * @mbggenerated
     */
    private String usercode;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     */
    public ProfitDetailKey(String code, String pcode, BigDecimal price, String usercode) {
        this.code = code;
        this.pcode = pcode;
        this.price = price;
        this.usercode = usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column profitdetail.code
     *
     * @return the value of profitdetail.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column profitdetail.pcode
     *
     * @return the value of profitdetail.pcode
     *
     * @mbggenerated
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column profitdetail.price
     *
     * @return the value of profitdetail.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column profitdetail.usercode
     *
     * @return the value of profitdetail.usercode
     *
     * @mbggenerated
     */
    public String getUsercode() {
        return usercode;
    }
}