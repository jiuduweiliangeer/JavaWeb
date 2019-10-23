package com.cdxy.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test5 {

	public static void main(String[] args) {

		ExecutorService es1 = Executors.newFixedThreadPool(2);
		ExecutorService es2 = Executors.newCachedThreadPool();
		ExecutorService es3 = Executors.newSingleThreadExecutor();
		ScheduledExecutorService es4 = Executors.newScheduledThreadPool(2);
		es1.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "hello world");

			}
		});
		es1.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "hello world 2");

			}
		});
		es1.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "hello world 3");

			}
		});

		es4.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello world 444");

			}
		}, 2000, TimeUnit.MILLISECONDS);
		es4.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello world 555");

			}
		}, 2000,5000, TimeUnit.MILLISECONDS);
		es1.shutdown();

	}

}
