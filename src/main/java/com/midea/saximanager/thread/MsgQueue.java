package com.midea.saximanager.thread;

import java.util.LinkedList;
import java.util.List;

public class MsgQueue<E> {
	public List<E> list=new LinkedList<E>();
	public int length=10;
	public MsgQueue(int length) {
		this.length = length;
	}

	public synchronized void enqueue(E e) throws InterruptedException{
		while(this.list.size()==length){
			System.out.println(this.list.size());
			System.out.println("队列已满");
			wait();
		}
		if(this.list.size()==0){
			notifyAll();
		}
		this.list.add(e);
	}

	public synchronized E dequeue() throws InterruptedException{
		if(this.list.size()==this.length){
			notifyAll();
		}
		while(this.list.size()==0){
			System.out.println("队列已空");
			wait();
		}
		return this.list.remove(0);
	}


	public Boolean isEmpty() {
		if (this.list.size() == 0)
			return true;
		else
			return false;
	}

	public Boolean isFull() {
		if (this.list.size() == this.length)
			return true;
		else
			return false;
	}

}
