package Strings;

import java.util.HashMap;
import java.util.Map;

/*
LeetCode #3 - Longest Substring Without Repeating Characters

Given a string `s`, return the length of the longest substring without repeating characters.

Pattern:
- Sliding Window with HashSet (to track characters in the current window in O(1) time)

Approach:
1. Initialize two pointers: `left = 0` (start of window) and `right = 0` (end of window).
2. Use a HashSet to store characters currently in the window.
3. Iterate while `right < s.length()`:
   - If `s[right]` is not in the set:
     - Add `s[right]` to the set.
     - Update the maximum length as `max(maxLen, right - left + 1)`.
     - Move `right` one step forward.
   - If `s[right]` is already in the set:
     - Remove `s[left]` from the set.
     - Move `left` one step forward.
4. Continue until the end of the string is reached.
5. Return the maximum length found.

Explanation:
The sliding window ensures that we always maintain a substring without duplicates.
The HashSet allows O(1) checks for duplicates and O(1) removal.
By only moving each pointer forward at most `n` times, the algorithm runs in linear time.

Time Complexity: O(n) — each character is added and removed at most once.
Space Complexity: O(min(n, Σ)) — where Σ is the character set size (for ASCII, up to 128; for lowercase a–z, up to 26).

Examples:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b".

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
*/


public class LC0003_longest_substring_without_repeating_character {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        Map<Character, Integer> lastOccurrences = new HashMap<>();
        int max = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(lastOccurrences.containsKey(c)) {
                left = Math.max(lastOccurrences.get(c) + 1, left);
            }
            lastOccurrences.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
