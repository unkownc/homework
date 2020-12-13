package com.bigjava.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.addDigits(119));
	}

	/**
	 * leetcode - 258. 各位相加
	 * 
	 * 两个for O(n^2)
	 * 
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {

		/**
		 * return (num - 1) % 9 + 1; 时间复杂度 O(1),空间复杂度O(1)
		 */

		// 总合
		int sum = 0;

		// 时间复杂度为O(1)
		while (num != 0) { // num 为 0 跳出对应的循环

			sum += num % 10;// 获取对应数字的余数 - 123 -> 3，然后使用sum对对应余数进行相加
			num /= 10;// 加完之后减去对应尾数 123 -> 12

			if (num == 0 && sum >= 10) {
				num = sum;
				sum = 0;
			}

		}

		return sum;
	}

	/**
	 * leetcode - 13. 罗马数字转整数
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		HashMap<String, Integer> nums = new HashMap<>();
		nums.put("I", 1);
		nums.put("IV", 4);
		nums.put("V", 5);
		nums.put("IX", 9);
		nums.put("X", 10);
		nums.put("XL", 40);
		nums.put("L", 50);
		nums.put("XC", 90);
		nums.put("C", 100);
		nums.put("CD", 400);
		nums.put("D", 500);
		nums.put("CM", 900);
		nums.put("M", 1000);

		int sum = 0;

		int numIndex = 0;
		for (int i = 0; i < s.length(); i++) {

			if (numIndex < s.length()) {
				String s2 = s.substring(numIndex, numIndex + 2);
				if (nums.get(s2) != null) {
					sum += nums.get(s2);
					System.out.println("numIndex:" + numIndex + " s2:" + s2 + ":" + nums.get(s2));
					numIndex += 2;
				} else {
					sum += nums.get(s.charAt(numIndex) + "");
					System.out.println("numIndex:" + numIndex + " s:" + s.charAt(numIndex) + ":"
							+ nums.get(s.charAt(numIndex) + ""));
					numIndex++;
				}

			}
		}

		return sum;
	}

	/**
	 * leetcode - 283. 移动零算法
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {

		// 不是0的下标+1，并且赋值
		int newIndex = 0;
		// 计算0次数
		int zeroCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[newIndex++] = nums[i];
			else
				zeroCount++;
		}
		// 根据0的次数末尾赋值0
		for (int i = 1; i <= zeroCount; i++) {
			nums[nums.length - i] = 0;
		}

	}

	public int minCount(int[] coins) {
		int sum = 0;

		for (int i : coins) {
			sum += (i % 2 == 0) ? i / 2 : (i / 2 + 1);
		}

		return sum;
	}

	/**
	 * 剑指 Offer 05. 替换空格
	 * 
	 * @param s
	 * @return
	 */
	public String replaceSpace(String s) {
		StringBuffer s2 = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			s2.append(' ' == s.charAt(i) ? "%20" : s.charAt(i));
		}
		return s2.toString();
	}

	/**
	 * 1389. 按既定顺序创建目标数组
	 * 
	 * @param nums
	 * @param index
	 * @return
	 */
	public int[] createTargetArray(int[] nums, int[] index) {

		List<Integer> numbers = new ArrayList<Integer>(nums.length);

		for (int i = 0; i < nums.length; i++) {

			int index2 = index[i];

			numbers.add(index2, nums[i]);

		}

		int[] nums2 = new int[nums.length];

		for (int i = 0; i < numbers.size(); i++) {
			nums2[i] = numbers.get(i);
		}

		return nums2;
	}

	/**
	 * 1512. 好数对的数目
	 * 
	 * @param nums
	 * @return
	 */
	public int numIdenticalPairs(int[] nums) {

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j] && i < j)
					sum++;
			}
		}

		return sum;
	}

	/**
	 * 1342. 将数字变成 0 的操作次数
	 * 
	 * @param num
	 * @return
	 */
	public int numberOfSteps(int num) {
		int sum = 0;

		while (num != 0) {
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num -= 1;
			}
			sum++;
		}

		return sum;
	}

	/**
	 * 1108. IP 地址无效化
	 * 
	 * @param address
	 * @return
	 */
	public String defangIPaddr(String address) {
		StringBuffer newAddress = new StringBuffer();
		for (int i = 0; i < address.length(); i++) {
			newAddress.append('.' == address.charAt(i) ? "[.]" : address.charAt(i));
		}
		return newAddress.toString();
	}

	/**
	 * 1281. 整数的各位积和之差
	 * 
	 * @param n
	 * @return
	 */
	public int subtractProductAndSum(int n) {

		int sum = 0;
		int mut = 1;

		while (n != 0) {
			sum += n % 10;
			mut *= n % 10;
			n = n / 10;
		}

		return mut - sum;
	}

	/**
	 * 771. 宝石与石头
	 * 
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones(String J, String S) {
		int sum = 0;

		char[] chars = S.toCharArray();
		char[] chars2 = J.toCharArray();
		for (char c : chars) {
			for (char c2 : chars2) {
				if (c == c2) {
					sum++;
					break;
				}
			}
		}

		return sum;
	}

	/**
	 * LCP 01. 猜数字
	 * 
	 * @param guess
	 * @param answer
	 * @return
	 */
	public int game(int[] guess, int[] answer) {
		int sum = 0;

		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == answer[i]) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * 剑指 Offer 58 - II. 左旋转字符串
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	public String reverseLeftWords(String s, int n) {
		return s.substring(n) + s.substring(0, n);
	}

	public String reverseLeftWords2(String s, int n) {
		char[] str = s.toCharArray();
		StringBuffer newStr = new StringBuffer();
		for (int i = 0, j = 0; i < str.length; i++) {
			newStr.append((n + i) >= str.length ? str[j++] : str[n + i]);// 尾部开始加前面的
		}
		return newStr.toString();
	}

	/**
	 * 1486. 数组异或操作
	 * 
	 * @param n
	 * @param start
	 * @return
	 */
	public int xorOperation(int n, int start) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			num ^= start + 2 * i;
		}
		return num;
	}

	/**
	 * 1470. 重新排列数组
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	public int[] shuffle(int[] nums, int n) {
		int[] nums2 = new int[nums.length];
		int numIndex = 0;
		for (int i = 0; i < n; i++) {
			nums2[numIndex++] = nums[i];
			nums2[numIndex++] = nums[n + i];
		}
		return nums2;
	}

	/**
	 * 拥有最多糖果的孩子
	 * 
	 * @param candies
	 * @param extraCandies
	 * @return
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> flags = new ArrayList<>();

		int maxNum = 0;

		for (int i = 0; i < candies.length; i++) {
			if (candies[i] > maxNum) {
				maxNum = candies[i];
			}
		}

		for (int i = 0; i < candies.length; i++) {
			flags.add((candies[i] + extraCandies) >= maxNum);
		}

		return flags;
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
		// 11123>>>32111
		for (int i = strx.length() - 1; i >= 0; i--) {
			num = num * 10 + (x % 10);
			x = x / 10;
		}

		if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
			return 0;
		}

		return x < 0 ? -Integer.valueOf(num + "") : Integer.valueOf(num + "");
	}

	/**
	 * 整数反转
	 * 
	 * @param x
	 * @return
	 */
	public int reverse3(int x) {

		long num = 0;

		while (x != 0) {

			num = num * 10 + (x % 10);
			x = x / 10;

		}

		return (int) num == num ? (int) num : 0;
	}

}
