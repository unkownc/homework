package com.bigjava.thread;

public class ThreadSafe {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket, "窗口1");
		Thread t2 = new Thread(ticket, "窗口2");
		Thread t3 = new Thread(ticket, "窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Ticket implements Runnable {

	private static int num = 100;// 共计100张票

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在售票!");
		while (true) {
			sellTicket();
		}
	}

	// 同步方法,使用this对象
	// 对于静态方法,使用的是当前类的Class对象的锁
	public static synchronized void sellTicket() {
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-----售出车票:" + num--);
		}
	}

}
