package com.cdxy.demo;

public class Test3 {
	public static void main(String[] args) {
		Demo demo = new Demo();
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
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.method3();
			}
		},"c").start();
	}
}
class Demo{
	
	public synchronized void method1() {
	
		String name = Thread.currentThread().getName();
		System.out.println("�߳�"+name+":ִ��method1����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�߳�"+name+":ִ��method1��������");
	}
	
	public synchronized void method2(){
		String name = Thread.currentThread().getName();
		System.out.println("�߳�"+name+":ִ��method2����");
		System.out.println("�߳�"+name+":ִ��method2��������");
	}
	
	public void method3(){
		synchronized (new Object()) {
			String name = Thread.currentThread().getName();
			System.out.println("�߳�"+name+":ִ��method3����");
			System.out.println("�߳�"+name+":ִ��method3��������");
		}
	}
}








