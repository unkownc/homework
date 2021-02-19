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
	 * 根据k的个数和对应不是0的下标求出要替换的次数和对应替换下标
	 * 
	 * 1,2;2,3 -> 1,2 2,3下标 匹配规则 ";" 分割次数, "," 对应下标
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
	 * 获取不是0的数字下标
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] noZeroIndexs(int[] numbers) {
		int noZeroCount = noZeroCount(numbers);// 不是0的个数

		int noZeroIndex = 0;
		int[] noZeroIndexs = new int[noZeroCount];// 不是0的个数的下标

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0)
				noZeroIndexs[noZeroIndex++] = i;
		}
		return noZeroIndexs;
	}

	/**
	 * 不是0的个数
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
	 * 根据给定的数组和k进行数字替换并取得最大0的个数
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
	 * 根据给定的下标替换数字为0
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
	 * 计算0最大数和其下标位置
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] zeroCount(int[] numbers) {
		int zeroCount = 0;// 0数量
		int maxZeroCount = 0;// 最大0的数量
		int zeroIndex = 0;// 0下标
		int maxZeroIndex = 0;// 最大0下标
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
