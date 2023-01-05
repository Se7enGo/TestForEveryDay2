package day0830;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 这个类主要实现一个可以自维护的ConcurrentHashMap
 * 1.多线程put
 * 2.单线程消费
 * 3.自动维护结束的任务
 *
 *
 * 数据结构
 *  1.生产者将提供任务id 任务节点数量  任务状态
 *  2.消费者根据 状态 进行消费任务
 *  3.当任务超过20分钟没有更新 就删除当前节点
 */
public class MainTest {

    public static ConcurrentHashMap<String, BlockingDeque<Object>> jobMap = new ConcurrentHashMap<>();
    //生成 一堆key 表示10个流程实例
    public static final List<String> keyList =
            Stream.generate(UUID::randomUUID).limit(10).map(uuid -> uuid.toString()).collect(Collectors.toList());

    // 设定一个 线程池  用于不断的消费任务
    public static final Executor threadPool = Executors.newFixedThreadPool(10);
    //
    class Producer{
        public void  putTask(){


        }
    }

}
