package com.bigjava.thread;

public class ThreadSafe {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket, "����1");
		Thread t2 = new Thread(ticket, "����2");
		Thread t3 = new Thread(ticket, "����3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Ticket implements Runnable {

	private static int num = 100;// ����100��Ʊ

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "������Ʊ!");
		while (true) {
			sellTicket();
		}
	}

	// ͬ������,ʹ��this����
	// ���ھ�̬����,ʹ�õ��ǵ�ǰ���Class�������
	public static synchronized void sellTicket() {
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-----�۳���Ʊ:" + num--);
		}
	}

}
