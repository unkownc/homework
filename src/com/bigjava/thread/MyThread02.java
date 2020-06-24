package com.bigjava.thread;

/*
 * ��������ӿڿ���δ����˳����ʾ
 * ԭ����Ȼִ���˳�Ʊ�Ĳ�������������ʱ��ʾ��ӡ���������һ���߳��ȴ�ӡ������
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
	static int num = 100;// 100��Ʊ

	@Override
	public void run() {

		while (num > 0) {
			System.out.println(getName() + "---------->>>" + num--);
		}

	}
}

class Runnable02 implements Runnable {
	int num = 100;// 100��Ʊ

	@Override
	public void run() {

		while (num > 0) {
			System.out.println(Thread.currentThread().getName() + "---------->>>" + num--);
		}

	}
}
