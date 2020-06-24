package com.bigjava.thread;

public class Producer extends Thread {

	private String name;// ����������

	private ProductPool pool;// ��Ʒ��

	public Producer(String name, ProductPool pool) {
		this.name = name;
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				if (pool.isFull()) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					pool.put();
					System.out.println(this.name + "������һ����Ʒ,������Ʒ����:" + pool.getNum());
					pool.notifyAll();
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
