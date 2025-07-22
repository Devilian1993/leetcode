package Arrays;

import java.util.Arrays;

/*
LeetCode #26 - Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
Return the number of unique elements in nums.

Pattern:
- Two pointers (slow/fast) to traverse and overwrite duplicates in-place without extra memory

Approach:
1. If array has less than 2 elements, return its length (already unique).
2. Initialize two pointers:
   - slow = 0 → keeps track of position of last unique element
   - fast = 1 → scans through the array looking for new unique elements
3. If nums[fast] != nums[slow], increment slow and assign nums[slow] = nums[fast]
4. After the loop ends, return slow + 1 (total count of unique elements)

Time Complexity: O(n)
Space Complexity: O(1) – in-place modification

Example:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_...]
*/

public class LC0026_remove_duplicates {
    public static int removeDuplicates(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 1;

        while(fastPointer < nums.length) {
            if(nums[slowPointer] != nums[fastPointer]) {
                nums[++slowPointer] = nums[fastPointer];
            }
            fastPointer++;
        }

        return ++slowPointer;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
