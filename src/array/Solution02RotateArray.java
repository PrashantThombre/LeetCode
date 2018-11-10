package array;

public class Solution02RotateArray {

	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
	 * 
	 * Problem Title: Rotate Array
	 * 
	 * Problem Description: Given an array, rotate the array to the right by k steps, where k is non-negative.
	 * 
	 * Ex 1: Input: [1,2,3,4,5,6,7] and k = 3
	 * Output: [5,6,7,1,2,3,4]
	 * Explanation:
	 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
	 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
	 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
	 */
	
	public void rotate(int[] nums, int k) {
		if (nums.length <= 1)
			return;
		k %= nums.length;

		int arrLen = nums.length - 1;

		reverseArr(nums, 0, arrLen);
		reverseArr(nums, 0, k - 1);
		reverseArr(nums, k, arrLen);

	}

	private void reverseArr(int[] nums, int start, int end) {
		int temp;
		while (start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

			start++;
			end--;
		}
	}
}
