package com.bigjava.thread;

/**
 * �߳����ȼ�<br/>
 * ��Χ[1,10]<br/>
 * ���ȼ�Խ��,ִ�л���Խ��,ֻ�Ǹ���,����һ��
 * 
 * @author CJP
 *
 */
public class Thread03 {

	public static void main(String[] args) {
		System.out.println("������ȼ�" + Thread.MAX_PRIORITY);
		System.out.println("��С���ȼ�" + Thread.MIN_PRIORITY);
		System.out.println("��ͨ���ȼ�" + Thread.NORM_PRIORITY);

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
