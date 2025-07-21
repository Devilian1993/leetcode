package Arrays;

import java.util.Arrays;

/*
LeetCode #167 - Two Sum

Given an SORTED array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
Your solution must use O(1) additional space.
Pattern: Two pointers technique

I can utilize the fact, that the input array is sorted. I can check if edge indices sum up to target and move left if the
result is too big or move right if the result is too small.

Approach:
1. Initialize two pointer on the edges of the array
2. While pointers are not equal calculate the sum
3. If sum is equal to the target - return two indices (+1 due to how answer format was on the site); If sum is smaller than target - move the left pointer to the right;
If the sum is larger than target - move the right pointer to the left

Time Complexity: O(n)
Space Complexity: O(1)

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1] / [1, 0]
*/


public class LC0167_two_sum_II {
    public static int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while(leftPointer != rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(sum == target) {
                return new int[]{++leftPointer, ++rightPointer};
            } else if(sum < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return new int[1];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
