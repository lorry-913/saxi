//package com.midea.saximanager.thread;
//
//import com.aliyuncs.CommonResponse;
//import com.midea.saximanager.aliyun.AliMessage;
//import com.midea.saximanager.aliyun.RRpcUtil;
//import com.midea.saximanager.util.JacksonUtils;
//import org.apache.log4j.Logger;
//
//import java.util.Map;
//
//public class MsgConsummer implements Runnable{
//	protected Logger logger = Logger.getLogger(this.getClass());
//	public boolean isRunning=true;
//
//	public static void sendMsg(AliMessage message){
//		try {
//			MessageDriver.msgQueue.enqueue(message);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void stop(){
//		this.isRunning=false;
//	}
//
//	@Override
//	public void run() {
//		while(isRunning){
//			try {
//				AliMessage message=MessageDriver.msgQueue.dequeue();//出队拿出消息
//				CommonResponse response=RRpcUtil.RRpcRequest(message);
//				logger.info(response.getData());
//				System.out.println("消费者在消费:"+ JacksonUtils.toJSon(message));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public int over(){
//		return 0;
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//		for(int i=0;i<5;i++){
//			Thread t=new Thread(new MsgConsummer());
//			MessageDriver messageDriver=new MessageDriver();
//			messageDriver.excute(t);
//		}
//	}
//}
