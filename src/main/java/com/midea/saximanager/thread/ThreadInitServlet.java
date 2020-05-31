package com.midea.saximanager.thread;//package com.midea.saximanager.thread;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//
//public class ThreadInitServlet extends HttpServlet {
//    public static ThreadPoolManager tpm=ThreadPoolManager.newInstance();
//    public static MsgQueue<String> queue=new MsgQueue<String>(10);
//
//    public ThreadInitServlet() {
//        super();
//    }
//
//    public void execute(Runnable task) {
//        tpm.executeTask(task);
//    }
//
//    public void clear() throws InterruptedException {
//        tpm.clear();
//    }
//
//    public void init() throws ServletException {
//        MessageDriver td = new MessageDriver();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("初始化五个线程");
//            MsgConsummer consumer = new MsgConsummer();
//            td.excute(consumer);
//        }
//    }
//}
