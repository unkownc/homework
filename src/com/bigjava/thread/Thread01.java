package com.bigjava.thread;

/**
 * JVM����ʱ�ᴴ��һ�����̣߳�����ִ��main���� Ҫ��ʵ�ֶ��̣߳���Ҫ�����߳��д����µ��߳�
 * 
 * ʵ���ϣ�Java����������ʱ���ٻ����������̣߳�main�̣߳����������߳�gc
 * 
 * @author CJP
 *
 */
public class Thread01 {
	public static void main(String[] args) {
		System.out.println(1111);

		for (int i = 0; i < 10; i++) {
			MyThread mt = new MyThread("�߳�" + i);
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
