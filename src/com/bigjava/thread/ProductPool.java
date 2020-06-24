package com.bigjava.thread;

/**
 * 商品池
 * 
 * @author CJP
 *
 */
public class ProductPool {

	private int num;// 商品数量
	private static final int MAX_COUNT = 20;// 最大数量

	// 放入商品
	public void put() {
		num++;
	}

	// 取出商品
	public void get() {
		num--;
	}

	// 获取商品的数量
	public int getNum() {
		return num;
	}

	// 商品是否为空
	public boolean isEmpty() {
		return this.num == 0;
	}

	// 是否已满
	public boolean isFull() {
		return this.num == MAX_COUNT;
	}

}
