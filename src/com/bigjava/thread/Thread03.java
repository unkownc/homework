package com.bigjava.thread;

/**
 * 线程优先级<br/>
 * 范围[1,10]<br/>
 * 优先级越高,执行机会越大,只是概率,并不一定
 * 
 * @author CJP
 *
 */
public class Thread03 {

	public static void main(String[] args) {
		System.out.println("最大优先级" + Thread.MAX_PRIORITY);
		System.out.println("最小优先级" + Thread.MIN_PRIORITY);
		System.out.println("普通优先级" + Thread.NORM_PRIORITY);

		for (int i = 0; i < 20; i++) {

			MyThread03 t1 = new MyThread03();
			MyThread03 t2 = new MyThread03();
			t1.setPriority(10);
			t2.setPriority(1);

			t1.start();
			t2.start();

		}

	}

}

class MyThread03 extends Thread {

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		@SuppressWarnings("unused")
		String str = "";
		for (int i = 0; i < 10000; i++) {
			str += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(getPriority() + "-------------" + (end - startTime) + "ms");
	}

}
