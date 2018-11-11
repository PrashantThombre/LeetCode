package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution05Intersection_of_Two_Arrays_II {
	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/674
	 * 
	 * Problem Title: Intersection of Two Arrays II
	 * 
	 * Problem Description: Given two arrays, write a function to compute their
	 * intersection.
	 * 
	 * 
	 * 
	 * Ex 1: Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2]
	 * 
	 * Note:
	 * 
	 * Each element in the result should appear as many times as it shows in
	 * both arrays. The result can be in any order.
	 * 
	 * ----------------------------------------------------------------------
	 * Follow up:
	 * 
	 * What if the given array is already sorted? How would you optimize your
	 * algorithm? ==> use two pointers starting from 1st element from both arrays.
	 * If a==b 		->	push 'a' to the answer -> Increment both pointers
	 * else if a>b 	->	increment b's pointer
	 * else			-> increment a's pointer
	 * ----------------------------------------------------------------------
	 * What if nums1's size is small compared to nums2's size? Which
	 * algorithm is better?
	 * --> Just use the hashmap on the smaller array
	 * 
	 * 
	 * What if elements of nums2 are stored on disk, and
	 * the memory is limited such that you cannot load all elements into the
	 * memory at once?
	 * --> create a hashmap on array that fits
	 * --> then pick one element at a time and compare.
	 */

	public int[] intersect(int[] nums1, int[] nums2) {
		
		// Could have used this.. but it appends extra zeros at the end
		// int nums1Len = nums1.length;
		// int nums2Len = nums2.length;
		// int[] result = new int[(nums1Len>=nums2Len)?nums2Len:nums1Len];
		
		List<Integer> result = new ArrayList<>();

		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		for (int t : nums1) {
			if (map1.containsKey(t)) {
				map1.put(t, map1.get(t) + 1);
			} else {
				map1.put(t, 1);
			}
		}

		for (int t : nums2) {
			if (map1.containsKey(t)) {
				if (map1.get(t) > 0) {
					map1.put(t, map1.get(t) - 1);
					result.add(t);
				}
			}
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}
}
