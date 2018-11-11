package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution08KSumVariations {
	/*
	 * Link:
	 * https://leetcode.com/problems/two-sum/description/
	 * 
	 * Problem Title: Two Sum
	 * 
	 * Problem Description: 
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * 
	 * Ex 1: 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 */
	
	 public int[] twoSum(int[] nums, int target) {
		 HashMap<Integer, Integer> hm = new HashMap<>();
		 hm.put(nums[0], 0);
		 
		 for(int i = 1 ; i < nums.length ; i++){
			 if(hm.containsKey(target - nums[i])){
				 return new int[]{hm.get(target - nums[i]), i};
			 }else{
				 hm.put(nums[i], i);
			 }
		 }
		 return new int[2];
	 }
	 
	 
	 
	 
	/*
	 * Link:
	 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description
	 * /
	 * 
	 * Problem Title: 167. Two Sum II - Input array is sorted
	 * 
	 * Problem Description: Given an array of integers that is already sorted in
	 * ascending order, find two numbers such that they add up to a specific
	 * target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2.
	 * 
	 * Note:
	 * 
	 * - Your returned answers (both index1 and index2) are not zero-based.
	 * - You may assume that each input would have exactly one solution and
	 * - You may not use the same element twice.
	 * 
	 * Ex 1: Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation:
	 * The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	 */
	public int[] twoSumSorted(int[] numbers, int target) {

		int len = numbers.length;

		int start = 0;
		int end = len - 1;

		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				return new int[] { start + 1, end + 1 };
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return new int[2];
	}
	 
	 
	 
	 
	/*
	 * Link: https://leetcode.com/problems/3sum/description/
	 * 
	 * Problem Title: Three Sum
	 * 
	 * Problem Description: Given an array nums of n integers, are there
	 * elements a, b, c in nums such that a + b + c = 0? Find all unique
	 * triplets in the array which gives the sum of zero.
	 * 
	 * Note: 
	 * The solution set must not contain duplicate triplets.
	 * 
	 * Ex 1: Given array nums = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 */
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);
	        
	        int arrLen = nums.length;
	        for(int i = 0 ; i < arrLen - 2 ; i++){
	            if(i > 0 && nums[i] == nums[i-1]){
	                //Skipping the same elements in the sorted array
	                continue;                       
	            }
	            int target = -nums[i];
	            int start = i + 1;
	            int end = arrLen - 1;
	            while(start < end){
	                if(nums[start] + nums[end] == target){
	                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
	                    start++;
	                    end--;
	                    //Skipping the same elements from the start
	                    while(start < end && nums[start] == nums[start-1]) start++;
	                    //Skipping the same elements from tht end
	                    while(start < end && nums[end] == nums[end+1]) end--;
	                }else if(nums[start] + nums[end] > target){
	                    end--;
	                }else{
	                    start++;
	                }
	            }
	        }
	        return res;
	    }
	 
	 
	 
	/*
	 * Link: https://leetcode.com/problems/4sum/description/
	 * 
	 * Problem Title: Four Sum / KSum Generic Solution
	 * 
	 * Problem Description: Given an array nums of n integers and an integer
	 * target, are there elements a, b, c, and d in nums such that a + b + c + d
	 * = target? Find all unique quadruplets in the array which gives the sum of
	 * target.
	 * 
	 * Note: The solution set must not contain duplicate quadruplets.
	 * 
	 * Ex 1: Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
	 * 
	 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
	 */
	 	
	// Just a global variable that won't change throughout the problem 
	int len = 0;

	// Function for four sum problem
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int k = 4;
		len = nums.length;
		
		// Any k sum problem apart from 2-sum needs the array to be sorted with this approach
		Arrays.sort(nums);

		return kSum(nums, target, k, 0);
	}

	private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
		List<List<Integer>> res = new ArrayList<>();
		//Sanity check
		if (index > len) {
			return res;
		}

		// If k = 2 just perform the 2 sum problem
		if (k == 2) {
			// performTwoSum(nums, target, k, index);
			int start = index;
			int end = len - 1;
			while (start < end) {
				if (nums[start] + nums[end] == target) {
					List<Integer> tempList = new ArrayList<>();
					tempList.add(nums[end]);
					tempList.add(nums[start]);
					res.add(tempList);

					start++;
					end--;
					while (start < end && nums[start] == nums[start - 1])
						start++;
					while (start < end && nums[end] == nums[end + 1])
						end--;
				} else if (nums[start] + nums[end] > target) {
					end--;
				} else {
					start++;
				}
			}
		} else {
			// Call the function recursively each time decreasing the k value to k-1.
			// The target changes to target - nums[i]
			// The index is incremented to the next element
			// Note: You can only iterate i from --INDEX-- to -- nums.length - k + 1 (Imagine 3Sum problem for easier understanding of this..)
			for (int i = index; i < len - k + 1; i++) {
				//Store the result of k-1Sum in a temp list
				List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1,
						i + 1);

				if (temp != null) {
					// If results found, add the nums[i] value to all the lists returned in the temp list.
					for (List<Integer> t : temp) {
						t.add(nums[i]);
					}
					// Finally add all the updated lists to our final result list
					res.addAll(temp);
				}
				
				// Skip same elements in the outer array walk
				while (i < len - 1 && nums[i] == nums[i + 1]) {
					i++;
				}
			}
		}
		return res;
	}
}
