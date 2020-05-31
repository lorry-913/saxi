//package com.midea.saximanager.thread;
//
//import com.midea.saximanager.aliyun.AliMessage;
//
//
//public class MessageDriver {
//	public ThreadPoolManager threadPoolManager=ThreadPoolManager.newInstance();
//
//	public static MsgQueue<AliMessage> msgQueue=new MsgQueue<>(100);
//
//	public void excute(Runnable task){
//		threadPoolManager.executeTask(task);
//	}
//}
