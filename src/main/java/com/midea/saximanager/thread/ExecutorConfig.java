//package com.midea.saximanager.thread;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//
//@Configuration
//@EnableAsync
//public class ExecutorConfig {
//    protected Logger logger = Logger.getLogger(this.getClass());
//    // 线程池维护线程的最少数量
//    private final static int CORE_POOL_SIZE = 5;
//    // 线程池维护线程的最大数量
//    private final static int MAX_POOL_SIZE = 10;
//    // 线程池维护线程所允许的空闲时间
//    private final static int KEEP_ALIVE_TIME = 60;
//    // 线程池所使用的缓冲队列大小
//    private final static int WORK_QUEUE_SIZE = 30;
//
//    @Bean
//    public Executor asyncServiceExecutor() {
//        logger.info("线程开始初始化....");
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//
//        //配置核心线程数
//        executor.setCorePoolSize(CORE_POOL_SIZE);
//        //配置最大线程数
//        executor.setMaxPoolSize(MAX_POOL_SIZE);
//        //配置队列大小
//        executor.setQueueCapacity(30);
//        //配置线程池中的线程的名称前缀
//        executor.setThreadNamePrefix("线程池-线程-");
//        // rejection-policy：当pool已经达到max size的时候，如何处理新任务// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        //执行初始化
//        executor.initialize();
//        for(int i=0;i<5;i++){
//            MsgConsummer msgConsummer=new MsgConsummer();
//            executor.execute(msgConsummer);
//        }
//        return executor;
//    }
//
//}
