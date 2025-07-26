package Arrays;

/*
LeetCode #31 - Next Permutation

Given an integer array nums, rearrange it into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, rearrange it as the lowest possible order (i.e., sorted in ascending order).

Approach:
1. Starting from the end, find the first index 'pivot' such that nums[pivot] < nums[pivot + 1].
   This identifies the first position where the ascending order from the right is broken.
2. If no such pivot exists (pivot == -1), the entire array is in descending order,
   which means it's the highest permutation. Reverse the array to get the lowest permutation and return.
3. Otherwise, from the end of the array, find the first element 'successor' greater than nums[pivot].
4. Swap nums[pivot] and nums[successor].
5. Reverse the subarray from pivot + 1 to the end of the array to get the next permutation.

Time Complexity: O(n) – single pass from the end with in-place operations.
Space Complexity: O(1) – no extra memory allocation aside from variables.

Example:
Input: nums = [1, 3, 2]
Output: nums = [2, 1, 3]
*/


import java.util.Arrays;

public class LC0031_next_permutation {
    static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static void reverse(int[] array, int start, int end) {
        while(start < end) {
            swap(array, start++, end--);
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if(pivot == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        int successor = n - 1;
        while (nums[successor] <= nums[pivot]) {
            successor--;
        }

        swap(nums, pivot, successor);
        reverse(nums, pivot + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
