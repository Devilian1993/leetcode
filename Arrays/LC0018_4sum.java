package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/*
LeetCode #18 - 4Sum

Given an array of integers nums and an integer target, return all unique quadruplets that
sum up to target

Pattern:
- Two pointers (to find two elements that sum up to a target value efficiently after sorting)
- Sorting (enables two-pointer approach in O(n log n) time and ensures ascending order)

Approach:
1. Sort the array.
2. Iterate through the array with index i:
   - For each nums[i], iterate through the array starting with index j = i + 1
3. For each unique nums[i], nums[j] pair initialize two pointers:
    - left = j + 1
    - right = n - 1 (where n = nums.length)
4. Compute the sum of nums[i] + nums[j] + nums[left] + nums[right]:
   - If the sum equals the target → add it to list of all quadruplets.
   - If the sum < target → increase left (to try a larger number).
   - If the sum > target → decrease right (to try a smaller number).

Time Complexity: O(n^3)
Space Complexity: O(1)

Example:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/

public class LC0018_4sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length;

        if (n < 4) {
            return quadruplets;
        }

        Arrays.sort(nums);

        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;

                while(left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
