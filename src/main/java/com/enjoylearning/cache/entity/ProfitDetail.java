package com.enjoylearning.cache.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProfitDetail extends ProfitDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column profitdetail.creattime
     *
     * @mbggenerated
     */
    private Date creattime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profitdetail
     *
     * @mbggenerated
     */
    public ProfitDetail(String code, String pcode, BigDecimal price, String usercode, Date creattime) {
        super(code, pcode, price, usercode);
        this.creattime = creattime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column profitdetail.creattime
     *
     * @return the value of profitdetail.creattime
     *
     * @mbggenerated
     */
    public Date getCreattime() {
        return creattime;
    }
}