package com.cdxy.demo;

import java.util.concurrent.locks.Lock;

public class Test4 {

	public static void main(String[] args) {
		Object lock = new Object();
		DemoTest demo = new DemoTest(lock);
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.method1();
			}
		},"A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.method2();
			}
		},"B").start();

	}

}
class DemoTest{
	private Object lock;
	public DemoTest(Object lock){
		this.lock = lock;
	}
	public void method1(){
		synchronized (lock) {
			String name = Thread.currentThread().getName();
			System.out.println("线程"+name+":method1 ing...");
			try {
				lock.wait();
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程"+name+":method1 over");
			lock.notify();
		}
	}
	
	
	public void method2(){
		synchronized (lock) {
			String name = Thread.currentThread().getName();
			System.out.println("线程"+name+":method2 ing...");
			lock.notify();
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程"+name+":method2 over");
		}
	}
	
}



























