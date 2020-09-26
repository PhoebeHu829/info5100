package info5100;

public class ArrayMaxSum {
	 /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
	
    public static int maxSubArray(int[] nums) {
        //write your code here
    	if(nums == null||nums.length == 0 ) {
    		return 0;
    	}
    	
    	int [] record = new int[nums.length];
    	int max = nums[0];
    	for(int i = 0; i < nums.length; i++) {
    		if(i == 0) {
    			record[i] = nums[i];
    		} else {
    			record[i] = Math.max(nums[i], record[i - 1] + nums[i]);
    		}
    		
    		max = Math.max(max, record[i]);
    	}
    	return max;
    }

    public static void main(String[] args) {
        //write your code here
    	int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    	int val = maxSubArray(arr);
    	System.out.println(val);
    	
    	int[] arr2 = new int[]{1};
    	int val2 = maxSubArray(arr2);
    	System.out.println(val2);
    }
}
