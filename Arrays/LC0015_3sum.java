package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/*
LeetCode #15 - 3Sum

Given an array of integers nums, return all the unique triplets (i, j, k) such that:
- i != j, i != k, j != k
- nums[i] + nums[j] + nums[k] == 0

Pattern:
- Two pointers (to find two elements that sum up to a target value in O(n) time after sorting)
- Sorting (enables two-pointer approach and simplifies skipping duplicates; O(n log n) time)

Approach:
1. Sort the array.
2. Iterate through the array:
   - For each element at index i, set two pointers:
     - left = i + 1
     - right = end of the array
3. Compute the sum of nums[i] + nums[left] + nums[right]:
   - If the sum is 0 → valid triplet → add to result, and skip duplicates by moving both pointers.
   - If the sum < 0 → increase left (to try a larger number).
   - If the sum > 0 → decrease right (to try a smaller number).
4. Skip duplicates for the current index i.
5. Break early if nums[i] > 0 (since array is sorted, no triplet can sum to 0).

Time Complexity: O(n^2)
Space Complexity: O(1) (excluding the result list)

Example:
Input: nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1, -1, 2], [-1, 0, 1]]
*/


public class LC0015_3sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        int leftPointer;
        int rightPointer;
        int twoSum;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int requiredTwoSum = -nums[i];

            leftPointer = i + 1;
            rightPointer = nums.length - 1;

            while(leftPointer < rightPointer) {
                twoSum = nums[leftPointer] + nums[rightPointer];
                if(twoSum == requiredTwoSum) {
                    triplets.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));

                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) leftPointer++;
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) rightPointer--;

                    leftPointer++;
                    rightPointer--;
                } else if (twoSum > requiredTwoSum) {
                    --rightPointer;
                } else {
                    ++leftPointer;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}


