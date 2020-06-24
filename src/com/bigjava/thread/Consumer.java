package com.bigjava.thread;

public class Consumer extends Thread {

	private String name;

	private ProductPool pool;

	public Consumer(String name, ProductPool pool) {
		this.name = name;
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				if (pool.isEmpty()) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					pool.get();
					System.out.println(this.name + "消费了一个商品,现在商品数量是:" + pool.getNum());
					pool.notifyAll();
				}
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
