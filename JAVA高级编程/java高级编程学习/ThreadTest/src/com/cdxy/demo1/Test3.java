package com.cdxy.demo1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
	ReentrantLock reentrantLock = new ReentrantLock();
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition conditionA = reentrantLock.newCondition();
		Condition conditionB = reentrantLock.newCondition();
		Condition conditionC = reentrantLock.newCondition();
		new A(reentrantLock, conditionA, conditionB).start();
		new B(reentrantLock,conditionB,conditionC).start();
		new C(reentrantLock, conditionA, conditionC).start();
	
	
	}
	
	
}
class A extends Thread{
	private ReentrantLock reentrantLock;
	private Condition conditionA ;
	private Condition conditionB ;

	
	public A(ReentrantLock reentrantLock,Condition conditionA,Condition conditionB){
		this.reentrantLock = reentrantLock;
		this.conditionA = conditionA;
		this.conditionB = conditionB;
	}
	@Override
	public void run() {
		reentrantLock.lock();
		try {
			for(int i=65;i<91;i++){
				if (i%3==0) 
					System.out.println(Thread.currentThread().getName()+":"+(char)i);
				conditionB.signal();
				conditionA.await();
			}
			conditionB.signal();
		} catch (Exception e) {

		}finally {
			reentrantLock.unlock();
		}
	}
}


class B extends Thread{
	private ReentrantLock reentrantLock;
	private Condition conditionC ;
	private Condition conditionB ;

	
	public B(ReentrantLock reentrantLock,Condition conditionB,Condition conditionC){
		this.reentrantLock = reentrantLock;
		this.conditionC = conditionC;
		this.conditionB = conditionB;
	}
	@Override
	public void run() {
		reentrantLock.lock();
		try {
			for(int i=65;i<91;i++){
				if (i%3==1) 
					System.out.println(Thread.currentThread().getName()+":"+(char)i);
				conditionC.signal();
				conditionB.await();
			}
			conditionC.signal();
		} catch (Exception e) {

		}finally {
			reentrantLock.unlock();
		}
	}
}

class C extends Thread{
	private ReentrantLock reentrantLock;
	private Condition conditionA ;
	private Condition conditionC ;
	public C(ReentrantLock reentrantLock,Condition conditionA,Condition conditionC){
		this.reentrantLock = reentrantLock;
		this.conditionA = conditionA;
		this.conditionC = conditionC;
	}
	@Override
	public void run() {
		reentrantLock.lock();
		try {
			for(int i=65;i<91;i++){
				if (i%3==2) 
					System.out.println(Thread.currentThread().getName()+":"+(char)i);
				conditionA.signal();
				conditionC.await();
			}
			conditionC.signal();
		} catch (Exception e) {

		}finally {
			reentrantLock.unlock();
		}
	}
}







