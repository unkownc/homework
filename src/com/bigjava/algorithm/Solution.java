package com.bigjava.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.minCount(new int[] { 2, 3, 10 }));
	}

	public int minCount(int[] coins) {
		int sum = 0;

		for (int i : coins) {
			sum += (i % 2 == 0) ? i / 2 : (i / 2 + 1);
		}

		return sum;
	}

	/**
	 * ��ָ Offer 05. �滻�ո�
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
	 * 1389. ���ȶ�˳�򴴽�Ŀ������
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
	 * 1512. �����Ե���Ŀ
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
	 * 1342. �����ֱ�� 0 �Ĳ�������
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
	 * 1108. IP ��ַ��Ч��
	 * 
	 * @param address
	 * @return
	 */
	public String defangIPaddr(String address) {
		String newAddress = "";
		for (int i = 0; i < address.length(); i++) {
			if (".".equals(address.charAt(i) + "")) {
				newAddress += "[.]";
			} else {
				newAddress += address.charAt(i);
			}
		}
		return newAddress;
	}

	/**
	 * 1281. �����ĸ�λ����֮��
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
	 * 771. ��ʯ��ʯͷ
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
	 * LCP 01. ������
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
	 * ��ָ Offer 58 - II. ����ת�ַ���
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
		String newStr = "";
		for (int i = 0, j = 0; i < str.length; i++) {
			if ((n + i) >= str.length) {// ����ת���ּ�i���ڲ�ֳ���
				newStr += str[j++];// β����ʼ��ǰ���
			} else {
				newStr += str[n + i];// ����Ӻ�����ַ���
			}
		}
		return newStr;
	}

	/**
	 * 1486. ����������
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
	 * 1470. ������������
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
	 * ӵ������ǹ��ĺ���
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
	 * ����ת������
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
	 * ������ת����
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
	 * ���������
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
	 * һά����Ķ�̬��
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
	 * ��֤���Ĵ�
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
	 * ������
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
	 * ������ת
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
	 * ������ת
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
