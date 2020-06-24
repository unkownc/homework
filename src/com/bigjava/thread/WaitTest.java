package com.bigjava.thread;

public class WaitTest {
	public static void main(String[] args) {

		Object object = new Object();

		Wait wait = new Wait(object);

		wait.start();
		
		Notify notify = new Notify(object);

		notify.start();

	}
}

class Wait extends Thread {

	private Object obj;

	public Wait() {

	}

	public Wait(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		System.out.println("1111");

		synchronized (obj) {
			try {
				System.out.println("释放锁进入等待池");
				obj.wait();
			} catch (InterruptedException e) {
				System.out.println(getName() + "被中断");
			}
		}

		System.out.println("2222");
	}
}

class Notify extends Thread {

	private Object obj;

	public Notify() {

	}

	public Notify(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		synchronized (obj) {
			obj.notifyAll();
			System.out.println(getName() + "已唤醒等待池中的线程....");
		}
	}
}
