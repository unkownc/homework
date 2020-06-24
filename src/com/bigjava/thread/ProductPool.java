package com.bigjava.thread;

/**
 * ��Ʒ��
 * 
 * @author CJP
 *
 */
public class ProductPool {

	private int num;// ��Ʒ����
	private static final int MAX_COUNT = 20;// �������

	// ������Ʒ
	public void put() {
		num++;
	}

	// ȡ����Ʒ
	public void get() {
		num--;
	}

	// ��ȡ��Ʒ������
	public int getNum() {
		return num;
	}

	// ��Ʒ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return this.num == 0;
	}

	// �Ƿ�����
	public boolean isFull() {
		return this.num == MAX_COUNT;
	}

}
