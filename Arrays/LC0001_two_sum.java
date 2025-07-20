package Arrays;

/*
LeetCode #1 - Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
Pattern: Hash Map / Complement Lookup

Approach:
1. Iterate through the array.
2. For each element, calculate complement = target - nums[i].
3. Check if complement exists in the map.
4. If yes, return indices.
5. Else, add current element and index to map.

Time Complexity: O(n)
Space Complexity: O(n)

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1] / [1, 0]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0001_two_sum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valuesMap = new HashMap<>();
        int[] solution = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(valuesMap.containsKey(complement)) {
                solution[0] = i;
                solution[1] = valuesMap.get(complement);
                break;
            }

            valuesMap.put(nums[i], i);
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
