package com.bigjava.algorithm;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(1534236469);
		System.out.println(solution.reverse2(1534236469));

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
