package com.midea.saximanager.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolManager {
		/**
		 * ThreadPoolExecutor将根据corePoolSize和maximumPoolSize设置的值调整线程池大小。
		 * 当新任务调用方法execute(Runnable)提交时，如果运行的线程少于corePoolSize，
		 * 则创建新线程来处理请求。如果正在运行的线程数等于corePoolSize时，
		 * 则新任务被添加到队列中，直到队列满。当队列满了后，会继续开辟新线程来处理任务，
		 * 但不超过最大线程数。当任务队列满了并且已开辟了最大线程数，此时又来了新任务，ThreadPoolExecutor会拒绝服务
		 */

		//小程序使用这些快捷方法没什么问题，对于服务端需要长期运行的程序，创建线程池应该直接使用ThreadPoolExecutor的构造方法。没错，上述Executors方法创建的线程池就是ThreadPoolExecutor

	    //单例模式
		/**
		 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。
		 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
		         这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。
		         这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
		 */
		private static ThreadPoolManager tpm = new ThreadPoolManager();
		// 线程池维护线程的最少数量
		private final static int CORE_POOL_SIZE = 10;
		// 线程池维护线程的最大数量
		private final static int MAX_POOL_SIZE = 30;
		// 线程池维护线程所允许的空闲时间
		private final static int KEEP_ALIVE_TIME = 0;
		// 线程池所使用的缓冲队列大小
		private final static int WORK_QUEUE_SIZE = 30;
		// 管理数据库访问的线程池
		final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
				CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(WORK_QUEUE_SIZE), new ThreadPoolExecutor.CallerRunsPolicy()
				);

		// CallerRunsPolicy线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度
		/**
		 *  优点：饿汉模式天生是线程安全的，使用时没有延迟。
 			缺点：启动时即创建实例，启动慢，有可能造成资源浪费。
 			这里用的是恶汉模式，

 			static修饰的方法叫类方法，通过类方法实例化对象
		 * @return
		 */
		public static ThreadPoolManager newInstance() {
			return tpm;
		}

		private ThreadPoolManager() {

		}

		public void executeTask(Runnable task){
			threadPool.execute(task);
		}

		public void clear() throws InterruptedException{
			threadPool.shutdown();
		}
}
