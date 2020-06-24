package com.bigjava.thread;

public class Test02 {

//	static MyThreadLocal<User> local = new MyThreadLocal<>();

	static ThreadLocal<User> local = new ThreadLocal<>();

	public static void main(String[] args) {
		local.set(new User());
		System.out.println(local.get());
		System.out.println(local.get());
		System.out.println(local.get());

		new Thread(new Runnable() {

			@Override
			public void run() {
				local.set(new User());
				System.out.println(local.get());
			}
		}).start();

	}
}

class User {
	public User() {
		System.out.println("User.user()");
	}
}
