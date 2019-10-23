package com.cdxy.demo;

public class Test1 {

	public static void main(String[] args) {
		String name = Thread.currentThread().getName();
		System.out.println(name);
		new MThread("mythread").start();
		new Thread(new MR(),"myrunnable").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(name);
			}
		},"runnableImpl").start();
	}

}
class MThread extends Thread{
	public MThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name);
	}
}
class MR implements Runnable{
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name);
	}
}






