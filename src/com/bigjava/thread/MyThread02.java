package com.bigjava.thread;

/*
 * 现象，输出接口可能未按照顺序显示
 * 原因，虽然执行了出票的操作，但可能暂时显示打印结果，而另一个线程先打印出来了
 */
public class MyThread02 extends Thread {
	public static void main(String[] args) {
//		Thread t1 = new Thread02();
//		t1.start();
//
//		Thread t2 = new Thread02();
//		t2.start();

		Runnable02 runnable02 = new Runnable02();
		Thread t = new Thread(runnable02);
		t.start();
		Thread t2 = new Thread(runnable02);
		t2.start();
	}

}

class Thread02 extends Thread {
	static int num = 100;// 100张票

	@Override
	public void run() {

		while (num > 0) {
			System.out.println(getName() + "---------->>>" + num--);
		}

	}
}

class Runnable02 implements Runnable {
	int num = 100;// 100张票

	@Override
	public void run() {

		while (num > 0) {
			System.out.println(Thread.currentThread().getName() + "---------->>>" + num--);
		}

	}
}
