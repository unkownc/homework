package com.bigjava.thread;

/**
 * JVM启动时会创建一个主线程，用来执行main方法 要想实现多线程，需要在主线程中创建新的线程
 * 
 * 实际上，Java程序在运行时至少会启动两个线程，main线程，垃圾回收线程gc
 * 
 * @author CJP
 *
 */
public class Thread01 {
	public static void main(String[] args) {
		System.out.println(1111);

		for (int i = 0; i < 10; i++) {
			MyThread mt = new MyThread("线程" + i);
			mt.start();
		}
		
		System.out.println(MyThread.count);

		// while (true) {
		// System.out.println(Thread.currentThread().getName());
		// }
	}
}

class MyThread extends Thread {

	public static int count = 0;

	public MyThread() {
	}

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(getName() + "--------------" + i);
			count++;
		}
	}
}
