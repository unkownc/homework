package com.bigjava.thread;

public class Thread05 {
	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					if (i == 8) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							System.out.println(Thread.currentThread().getName() + "被打断了");
						}
						// Thread.yield();// 暂停放行,放弃CPU控制权,进入就绪状态
					}
					System.out.println(Thread.currentThread().getName() + "------------" + i);
				}
			}
		}, "t");
		thread.start();

		Thread.sleep(2000);
		for (int i = 0; i < 50; i++) {
//			if (i == 3) {
//				Thread.currentThread().join();
//			}
			System.out.println(Thread.currentThread().getName() + "---------" + i);
		}

		thread.interrupt();

	}
}
