package com.bigjava.thread;

public class Runnable01 {
	public static void main(String[] args) {
		// ����ʵ�����һ��ʵ��
		MyRunnable mr = new MyRunnable();
	
		for (int i = 0; i < 10; i++) {

			Thread thread = new Thread(mr);
			thread.start();
			
		}
		

	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "-------------" + i);
		}
	}

}
