package com.bigjava.algorithm;

import java.util.Arrays;

public class ZeroCountDemo {

	public static void main(String[] args) {
		
		int[] numbers = { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 };
		int[] numbers2 = { 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0 };
		int k = 2;
		int k2 = 3;
		
		System.out.println(repalceNumber(numbers, k));
		System.out.println(repalceNumber(numbers2, k2));
	}

	/**
	 * ����k�ĸ����Ͷ�Ӧ����0���±����Ҫ�滻�Ĵ����Ͷ�Ӧ�滻�±�
	 * 
	 * 1,2;2,3 -> 1,2 2,3�±� ƥ����� ";" �ָ����, "," ��Ӧ�±�
	 * 
	 * @param numbers
	 * @param k
	 * @return
	 */
	public static String getReplaceCount(int[] numbers, int k) {
		int resetCount = 0;
		String indexsStr = "";
		for (int i = 0; i < numbers.length; i++) {
			if (i + k <= numbers.length) {
				while (k != 0) {
					k--;
					indexsStr += numbers[i + resetCount] + ",";
					resetCount++;
				}
				k = resetCount;
				resetCount = 0;
				indexsStr = indexsStr.substring(0, indexsStr.length() - 1) + ";";
			}
		}
		return indexsStr;
	}

	/**
	 * ��ȡ����0�������±�
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] noZeroIndexs(int[] numbers) {
		int noZeroCount = noZeroCount(numbers);// ����0�ĸ���

		int noZeroIndex = 0;
		int[] noZeroIndexs = new int[noZeroCount];// ����0�ĸ������±�

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0)
				noZeroIndexs[noZeroIndex++] = i;
		}
		return noZeroIndexs;
	}

	/**
	 * ����0�ĸ���
	 * 
	 * @param numbers
	 * @return
	 */
	public static int noZeroCount(int[] numbers) {
		int noZeroCount = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0)
				noZeroCount++;
		}
		return noZeroCount;
	}

	/**
	 * ���ݸ����������k���������滻��ȡ�����0�ĸ���
	 * 
	 * @param numbers
	 * @param k
	 * @return
	 */
	public static int repalceNumber(int[] numbers, int k) {
		int[] noZeroIndexs = noZeroIndexs(numbers);
		int maxZeroCount = 0;
		String[] indexs = getReplaceCount(noZeroIndexs, k).split(";");
		for (int i = 0; i < indexs.length; i++) {
			String[] index = indexs[i].split(",");
			int[] numIdx = new int[index.length];
			for (int j = 0; j < index.length; j++) {
				numIdx[j] = Integer.valueOf(index[j]);
			}
			int newZeroCount = repalceNumberByIndex(Arrays.copyOf(numbers, numbers.length), numIdx);
			maxZeroCount = newZeroCount > maxZeroCount ? newZeroCount : maxZeroCount;
		}
		return maxZeroCount;
	}

	/**
	 * ���ݸ������±��滻����Ϊ0
	 * 
	 * @param numbers
	 * @param indexs
	 * @return
	 */
	public static int repalceNumberByIndex(int[] numbers, int... indexs) {
		for (int i = 0; i < indexs.length; i++) {
			numbers[indexs[i]] = 0;
		}
		return zeroCount(numbers)[0];
	}

	/**
	 * ����0����������±�λ��
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] zeroCount(int[] numbers) {
		int zeroCount = 0;// 0����
		int maxZeroCount = 0;// ���0������
		int zeroIndex = 0;// 0�±�
		int maxZeroIndex = 0;// ���0�±�
		while (zeroIndex != numbers.length) {
			if (numbers[zeroIndex] == 0) {
				zeroCount++;
			} else {

				if (zeroCount > maxZeroCount) {
					maxZeroCount = zeroCount;
					maxZeroIndex = zeroIndex;
				}
				zeroCount = 0;
			}
			zeroIndex++;
		}
		maxZeroIndex = (maxZeroIndex - maxZeroCount);
		return new int[] { maxZeroCount == 0 ? zeroCount : maxZeroCount, maxZeroIndex };
	}

}
