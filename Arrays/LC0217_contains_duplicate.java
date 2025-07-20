package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
LeetCode #217 - Contains duplicate

Given an array of integers nums return true, if nums contains a duplicate (a number appears more than once) and false otherwise

Pattern:
- Hash Set (to detect duplicates efficiently)

Approach:
1. Create a HashSet to store elements already visited
2. Iterate through an array
3. Check if we have seen a current element (check if set contains this element)
3.1. If set contains this element - duplicate found, return true
3.2. If not - add element to the set and continue
4. If duplicate was not found after we left the loop - return false, there are no duplicates

Time Complexity: O(n)
Space Complexity: O(n)

Example:
Input: nums = [1,2,3,1]
Output: true

Input: nums = [1,2,3,4]
Output: false
*/

public class LC0217_contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
