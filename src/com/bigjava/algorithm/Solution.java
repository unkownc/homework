package com.bigjava.algorithm;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		String aString = "A man, a plan, a canal: Panama";

		System.out.println(solution.isPalindrome(aString));
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
