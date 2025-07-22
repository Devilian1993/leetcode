package Arrays;
/*
LeetCode #941 - Valid Mountain Array

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:
- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
  - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
  - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Pattern:
- Two pointers (single pass approach simulating upward and downward climb)

Approach:
1. Check if the length is at least 3 — otherwise, return false
2. Use a single pointer `i` starting from index 0
3. Move `i` forward while the sequence is strictly increasing (climbing up)
4. Ensure the peak is not at the beginning or end of the array — return false if it is
5. Continue moving `i` forward while the sequence is strictly decreasing (descending)
6. Return true if `i` reached the end — this confirms both an upward and downward slope

Time Complexity: O(n) — single pass through the array
Space Complexity: O(1) — constant space

Example:
Input: arr = [3,5,5]
Output: false

Input: arr = [0,3,2,1]
Output: true
*/


public class LC0941_valid_mountain_array {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) return false;

        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
    }
}

