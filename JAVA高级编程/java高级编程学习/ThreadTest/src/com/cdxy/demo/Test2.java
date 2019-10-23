package com.cdxy.demo;

public class Test2 {
	public static void main(String[] args) {
		Object lock = new Object();
		Station station = new Station();
		new Thread(new Win(station,lock),"A").start();
		new Thread(new Win(station,lock),"B").start();
		new Thread(new Win(station,lock),"C").start();
	}
}
class Station{
	public int ticket = 10;
	public void sale(){
		ticket--;
	}
}
class Win implements Runnable{
	private Station station;
	private Object lock;
	public Win(Station station,Object lock){
		this.station = station;
		this.lock = lock;
	}
	@Override
	public void run() {//synchronized
		synchronized (lock) {
			while(station.ticket>0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				station.sale();
				System.out.println("窗口"+Thread.currentThread().getName()+"卖了一张票，余票:"+station.ticket);
			}
		}
	}
}







