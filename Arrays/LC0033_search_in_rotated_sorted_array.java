package Arrays;

/*
LeetCode #33 - Search in rotated sorted array

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

Pattern:
- Binary search (finding an element in sorted array in O(log(n)) time)

Approach:
1. Do a binary search for a pivot element - smallest element in array that separates two sorted parts
2. If a middle element is greater than right element, that means the pivot is in the right part of the array;
otherwise - pivot is in the left half of the array
3. After finding a pivot do a standard binary search for a target in the array
   Set the right boundary to pivot - 1 if target is greater than nums[right] - that means target can be only in the first (greater) sorted part.
   Otherwise - set the left boundary to pivot - the target must be in a smaller sorted part.


Time Complexity: O(log(n)) - binary search
Space Complexity: O(1) — constant space

Example:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

public class LC0033_search_in_rotated_sorted_array {
    static int searchForPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int search(int[] nums, int target) {
        int pivot = searchForPivot(nums);

        int left = 0;
        int right = nums.length - 1;

        if (target > nums[right]) {
            right = pivot - 1;
        } else {
            left = pivot;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{7, 6, 5, 4, 0, 1, 2}, 0));
    }
}
