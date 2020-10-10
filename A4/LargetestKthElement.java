package assignment3;
import java.util.Arrays; 

public class LargetestKthElement {
	
	public static int largetestKthElement (int[] nums, int K) {
	    Arrays.sort(nums);
	    return nums[nums.length - K];
	}
	
	public static void main(String[] args) {
		int[] arr1 = {3, 2, 1, 5, 6, 4};
		System.out.println(largetestKthElement(arr1, 2));
		
		int[] arr2 = {3,2,3,1,2,4,5,5,6};
		System.out.println(largetestKthElement(arr2, 4));
		
		int[] arr3 = {5,5,5,5,5,5,5,5,5};   
		System.out.println(largetestKthElement(arr3, 4));
		
		int[] arr4 = {1};
		System.out.println(largetestKthElement(arr4, 1));
		
		int[] arr5 = {-3,-2,-3,-1,-2,-4,-5,-5,-6};
		System.out.println(largetestKthElement(arr5, 4));
	}  
}
