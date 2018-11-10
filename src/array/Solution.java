package array;

public class Solution {

	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/727/
	 * 
	 * Problem Title: Remove Duplicates from Sorted Array
	 * 
	 * Problem Description: Given a sorted array nums, remove the duplicates
	 * in-place such that each element appear only once and return the new
	 * length. Do not allocate extra space for another array, you must do this
	 * by modifying the input array in-place with O(1) extra memory.
	 * 
	 * Ex 1: Given nums = [1,1,2], Your function should return length = 2, with
	 * the first two elements of nums being 1 and 2 respectively. It doesn't
	 * matter what you leave beyond the returned length.
	 */

	public int removeDuplicates(int[] nums) {
		int slower = 0;
		for (int faster = 1; faster < nums.length; faster++) {
			if (nums[faster] != nums[slower]) {
				slower++;
				nums[slower] = nums[faster];
			}
		}
		return slower + 1;
	}
}
