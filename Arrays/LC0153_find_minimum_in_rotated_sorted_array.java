package Arrays;

/*
LeetCode #153 - Find Minimum in Rotated Sorted Array

Given a rotated sorted array of unique integers, return the minimum element.
The array was originally sorted in ascending order but then rotated between 1 and n times.

Pattern:
- Binary Search (modified to account for rotation)

Approach:
1. Initialize two pointers:
   - `left = 0`
   - `right = nums.length - 1`
2. While `left < right`:
   - Compute `mid = (left + right) / 2`.
   - If `nums[mid] > nums[right]`:
       - The minimum must be in the right half (excluding mid), so set `left = mid + 1`.
   - Else:
       - The minimum is in the left half (including mid), so set `right = mid`.
3. When the loop ends, `left == right` and points to the minimum element.
4. Return `nums[left]`.

Explanation:
- If `nums[mid] > nums[right]`, rotation pivot lies to the right of mid, so the min is on the right.
- Otherwise, the min lies at mid or to the left of mid.
- By narrowing the search range using binary search logic, we find the min in O(log n).

Time Complexity: O(log n) — binary search halves the search space each iteration.
Space Complexity: O(1) — only constant extra variables are used.

Examples:
Input: nums = [3,4,5,1,2]
Output: 1

Input: nums = [4,5,6,7,0,1,2]
Output: 0

Input: nums = [11,13,15,17]
Output: 11
*/

public class LC0153_find_minimum_in_rotated_sorted_array {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
