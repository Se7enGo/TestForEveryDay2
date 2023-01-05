package com.enjoylearning.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class ProfitDetailServiceImpl implements ProfitDetailService {

    /*@Autowired
    private CacheServiceImpl cacheService;*/

    /*@Autowired
    private ProfitDetailMapper mapper;*/

    private static final String CACHE_NAME = "amount";

    private Random random = new Random();

    private Logger logger = LoggerFactory.getLogger(ProfitDetailServiceImpl.class);

    @Override
    @Cacheable(key = "#userCode" ,value = CACHE_NAME )
    public BigDecimal getProfitAmount(String userCode) {
        /*//去redis 里查一下 有没有这个key
        BigDecimal value = cacheService.cacheResult( userCode);
        if(value != null){
            logger.info("====== get from cache ========= >");
            return   value;
        }
        // 去数据库里查一下 有没有值
        BigDecimal value2 =
        if(value2 != null){
            logger.info("======= get from db ========= >");
            //如果有 就放在内存里 供后面的线程查询
            cacheService.cachePut(userCode,value2);
        }*/
       // return  mapper.getProfitAmount(userCode);
        return null;
    }
}
