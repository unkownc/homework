package com.bigjava.thread;

public class Singleton {
	private static Singleton instance;

	public Singleton() {
		System.out.println("Singleton.singleton()");
	}

	public synchronized static Singleton getInstace() throws InterruptedException {
		if (instance == null) {
			Thread.sleep(1000);
			instance = new Singleton();
		}
		return instance;
	}

}
