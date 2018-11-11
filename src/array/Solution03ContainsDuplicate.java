package array;

import java.util.HashSet;
import java.util.Set;

public class Solution03ContainsDuplicate {
	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/578/
	 * 
	 * Problem Title: Contains Duplicate
	 * 
	 * Problem Description: Given an array of integers, find if the array
	 * contains any duplicates.
	 * 
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 * 
	 * Ex 1: Input: [1,2,3,1] Output: true
	 */

	public boolean containsDuplicate(int[] nums) {
		int len = nums.length;

		if (len == 0) {
			return false;
		}
		Set<Integer> hs = new HashSet<>();
		for (int i : nums) {
			// System.out.println(hm.get(i));
			if (hs.contains(i)) {
				return true;
			} else {
				hs.add(i);
			}
		}
		return false;
	}

}
