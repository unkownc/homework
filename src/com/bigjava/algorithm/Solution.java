package com.bigjava.algorithm;

import java.math.BigInteger;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(Integer.toBinaryString(12) + "");

		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

		
		for (int i = 0; i < a.length(); i++) {
			System.out.println();
		}
		
		System.out.println(solution.addBinary(a, b));

	}

	/**
	 * 数字转二进制
	 * 
	 * @return
	 */
	public String toBinaryString(BigInteger num) {
		String binary = "";
		BigInteger number = new BigInteger("2");
		while (!num.equals(new BigInteger("0"))) {
			binary += num.remainder(number);
			num = num.divide(number);
		}

		String binary2 = "";
		for (int i = binary.length(); i > 0; i--) {
			binary2 += binary.charAt(i - 1);
		}
		return binary2;
	}

	/**
	 * 二进制转数字
	 * 
	 * @param binaryStr
	 * @return
	 */
	public BigInteger binaryToInteger(String binaryStr) {
		BigInteger num = new BigInteger("0");
		BigInteger j = new BigInteger("1");
		for (int i = 1; i <= binaryStr.length(); i++, j = j.multiply(new BigInteger("2"))) {
			if ('0' != binaryStr.charAt(binaryStr.length() - i)) {
				num = num.add(j);
			}
		}
		return num;
	}

	/**
	 * 二进制求和
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		String binary = toBinaryString(binaryToInteger(a).add(binaryToInteger(b)));
		return "".equals(binary) ? "0" : binary;
	}

	/**
	 * 一维数组的动态和
	 * 
	 * @param nums
	 * @return
	 */
	public int[] runningSum(int[] nums) {
		int[] numbers = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			numbers[i] = sum;
		}
		return numbers;
	}

	/**
	 * 验证回文串
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		s = s.replaceAll(" |[^a-zA-Z0-9]", "").toLowerCase();

		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length / 2; i++) {
			if (chars[i] != chars[chars.length - 1 - i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 回文数
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		boolean flag = true;

		String strx = String.valueOf(x);

		char[] chars = strx.toCharArray();

		for (int i = 0; i < chars.length / 2; i++) {
			if (chars[i] != chars[chars.length - 1 - i]) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	/**
	 * 整数反转
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {

		if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
			return 0;

		String strx = String.valueOf(x);

		char[] chars = strx.toCharArray();

		String num = "";

		for (int i = chars.length - 1; i >= 0; i--) {
			num += chars[i];
		}

		long num2 = Long.valueOf(num);

		if (num2 > Integer.MAX_VALUE || num2 < Integer.MIN_VALUE) {
			return 0;
		}

		return x < 0 ? -Integer.valueOf(num2 + "") : Integer.valueOf(num2 + "");

	}

	public int reverse2(int x) {

		if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
			return 0;

		String strx = String.valueOf(x < 0 ? -x : x);

		long num = 0;

		for (int i = strx.length() - 1; i >= 0; i--) {

			long n = 1;
			for (int j = 0; j < i; j++) {
				n *= 10;
			}
			num += (x % 10) * n;

			x = x / 10;
		}

		if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
			return 0;
		}

		return x < 0 ? -Integer.valueOf(num + "") : Integer.valueOf(num + "");
	}

}
