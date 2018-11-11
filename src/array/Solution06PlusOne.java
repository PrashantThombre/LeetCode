package array;

public class Solution06PlusOne {
	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/559/
	 * 
	 * Problem Title: Plus One
	 * 
	 * Problem Description: Given a non-empty array of digits representing a
	 * non-negative integer, plus one to the integer.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list, and each element in the array contain a single digit.
	 * 
	 * You may assume the integer does not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * 
	 * 
	 * Ex 1: Input: [1,2,3] Output: [1,2,4] Explanation: The array represents
	 * the integer 123.
	 */

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}
}
