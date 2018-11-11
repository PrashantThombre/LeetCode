package array;

public class Solution04SingleNumber {
	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/549/
	 * 
	 * Problem Title: Single Number
	 * 
	 * Problem Description: Given a non-empty array of integers, every element
	 * appears twice except for one. Find that single one.
	 * 
	 * Note:
	 * 
	 * Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 * 
	 * Ex 1: Input: [2,2,1] Output: 1
	 */

	// Note: XOR(^) ==> same is 0, opposite is 1
	// Thus, 0(0 0) ^ 2(1 0) = 2(1 0)
	// Next, 2(1 0) ^ 2(1 0) = 0(0 0)
	// Then, 0(0 0) ^ 1(0 1) = 1(0 1)==> Final Answer.
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int n : nums)
			res ^= n;
		return res;
	}
}
