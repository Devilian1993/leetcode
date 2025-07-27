package Arrays;
import java.util.Arrays;

/*
LeetCode #16 - 3Sum Closest

Given an array of integers nums and an integer target, return the sum of three integers in nums
such that the sum is closest to target. You may assume that each input would have exactly one solution.

Pattern:
- Two pointers (to find two elements that sum up to a target value efficiently after sorting)
- Sorting (enables two-pointer approach in O(n log n) time and ensures ascending order)

Approach:
1. Sort the array.
2. Iterate through the array with index i:
   - For each nums[i], initialize two pointers:
     - left = i + 1
     - right = end of the array
3. Compute the sum of nums[i] + nums[left] + nums[right]:
   - If the sum equals the target → return it immediately.
   - If the sum is closer to the target than the previous closest sum → update the closest sum.
   - If the sum < target → increase left (to try a larger number).
   - If the sum > target → decrease right (to try a smaller number).

Time Complexity: O(n^2)
Space Complexity: O(1)

Example:
Input: nums = [-1, 2, 1, -4], target = 1
Output: 2
*/

public class LC0016_3sum_closest {
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if(sum == target) {
                    return sum;
                }

                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
