package com.bigjava.thread;

public class Producer extends Thread {

	private String name;// 生产者名字

	private ProductPool pool;// 商品池

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
					System.out.println(this.name + "生产了一个商品,现在商品数量:" + pool.getNum());
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
