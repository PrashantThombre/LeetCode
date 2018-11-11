package array;

public class Solution07MoveZerosToEnd {
	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/567/
	 * 
	 * Problem Title: Move Zeroes
	 * 
	 * Problem Description: Given an array nums, write a function to move all
	 * 0's to the end of it while maintaining the relative order of the non-zero
	 * elements.
	 * 
	 * 
	 * 
	 * Ex 1: Input: Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
	 * 
	 * You must do this in-place without making a copy of the array. Minimize
	 * the total number of operations.
	 */

	public void moveZeroes(int[] nums) {
        int i = 0 ;
        
        for(int j = 0 ; j < nums.length ; j++ ){
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}
