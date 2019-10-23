package com.cdxy.demo1;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test4 {

	public static void main(String[] args) {
		ReentrantLock lockFair = new SelfReentrantLock();
		new TestThread(lockFair, "A").start();
		new TestThread(lockFair, "B").start();
		new TestThread(lockFair, "C").start();
		new TestThread(lockFair, "D").start();
		new TestThread(lockFair, "E").start();
	}

}
class TestThread extends Thread{
	
	private Lock lock;
	private String name;
	
	public TestThread(Lock lock,String name) {
		super(name);
		this.lock = lock;
		this.name = name;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<5;i++){
			lock.lock();
			try {
				System.out.print(name+":"+i+"等待的线程是:");
				System.out.print(((SelfReentrantLock)lock).getQueuedThreads()+"\t\n");
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
class SelfReentrantLock extends ReentrantLock{
	
	public SelfReentrantLock(boolean fair) {
		super(fair);
	}
	
	public SelfReentrantLock() {
		super();
	}
	
	@Override
	protected Collection<Thread> getQueuedThreads() {
		// TODO Auto-generated method stub
		return super.getQueuedThreads();
	}
	
}











