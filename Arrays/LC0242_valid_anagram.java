package Arrays;

/*
LeetCode #242 - Valid Anagram

Given two strings, return true if one is an anagram of the other (i.e., both consist of the same letters with the same frequencies), and false otherwise.

Pattern:
- Hashing / Counting array (to count letter frequencies in linear time)

Approach:
1. If the strings are of different lengths, return false immediately.
2. Create a fixed-size array of length 26 to count occurrences of each letter (assuming lowercase a–z).
3. Iterate over both strings simultaneously.
4. For each index:
   - Increment the count for the character in `s`.
   - Decrement the count for the character in `t`.
5. After iteration, check if all values in the count array are zero.
   - If any value is non-zero, the strings are not anagrams — return false.
6. If all counts are zero, return true.

Explanation:
Using a single counting array, we increment for one string and decrement for the other.
If both strings have the same characters with the same frequencies, the net effect is zero in each position.

Time Complexity: O(n)
Space Complexity: O(1) — constant space for 26 letters

Examples:
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false
*/


public class LC0242_valid_anagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int count: counts) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
