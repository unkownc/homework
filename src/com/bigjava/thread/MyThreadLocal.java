package com.bigjava.thread;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
	private Map<Thread, T> map = new HashMap<>();

	public void set(T t) {
		map.put(Thread.currentThread(), t);
	}

	public T get() {
		T t = map.get(Thread.currentThread());
		if (t == null) {

		}
		return map.get(Thread.currentThread());
	}

}
