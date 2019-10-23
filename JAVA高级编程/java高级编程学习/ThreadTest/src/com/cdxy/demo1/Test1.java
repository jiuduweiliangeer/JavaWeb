package com.cdxy.demo1;

import java.util.List;
import java.util.ArrayList;

public class Test1 {
	
	public static void main(String[] args) {
		Storage storage = new Storage();
		new Producer(storage, "A").start();
		new Producer(storage, "B").start();
		new Producer(storage, "C").start();
		
		new Consumer(storage, "X").start();
		new Consumer(storage, "Y").start();
		new Consumer(storage, "Z").start();
	}

}

class Storage{
	public int max = 10;
	public List<Object> storage_list = new ArrayList<>();	
}
class Consumer extends Thread{
	private Storage storage;
	public Consumer(Storage storage,String name) {
		super(name);
		this.storage = storage;
	} 
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			consume();
		}
	}
	public void consume(){
		synchronized(storage){
			while(storage.storage_list.size() == 0){
				System.out.println("�ֿ�û������");
				try {
					storage.wait();
				} catch (InterruptedException e) {
				}
			}
			storage.storage_list.remove(0);
			System.out.println(Thread.currentThread().getName()
					+"������һ����Ʒ����ʣ��"+storage.storage_list.size()+"����Ʒ");
			storage.notifyAll();
		}
	}
	
}


class Producer extends Thread{
	
	private Storage storage;
	
	public Producer(Storage storage,String name) {
		super(name);
		this.storage = storage;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			product();
		}
	}
	
	public void product(){
		synchronized (storage) {
			while(storage.storage_list.size()>=10){
				System.out.println("�ֿ����ˣ�");
				try {
					storage.wait();
				} catch (InterruptedException e) {
					
				}
			}
			storage.storage_list.add(new Object());
			System.out.println(Thread.currentThread().getName()
					+"������һ����Ʒ����ǰ�ֿ���"+storage.storage_list.size()+"��Ʒ");
			storage.notifyAll();
		}
	}
}

















































