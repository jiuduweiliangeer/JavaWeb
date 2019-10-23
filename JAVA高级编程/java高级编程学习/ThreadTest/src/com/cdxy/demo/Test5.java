package com.cdxy.demo;

import java.time.temporal.TemporalQueries;

public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new ThreadOne();
		t1.start();
		
	}
}
class ThreadOne extends Thread{
	@Override
	public void run() {
		int i=0;
		while(true){
			System.out.println("begin");
			try {
				sleep(1000);
			} catch (Exception e) {
				this.interrupt();
				System.out.println("interrupt");
			}
			System.out.println("over");
		}
	}
}