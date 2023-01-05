package com.enjoylearning.cache.day0403;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MySqlClock {

    @Test
    public void sayAboutLock(){


        // 数据库中 内置有加锁 的工具
        // 锁 按照执行范围 分为 行锁 页锁  和表锁
        // 顾名思义 他们分别针对了 行级别 页面级别 和 表级别的 范围进行上锁
        // 锁 按照行为又划分为 写锁（排它锁）  读锁（共享锁）

        // 锁会在一个事务要求对某些数据进行上锁的时候 对数据加锁
        // 查询中 加上 for  update 是 加上写锁
        // 加上 lock in SHARE_MODE

        // 加上排它锁的数据 会一直独占 直到事务提交
    }
}
