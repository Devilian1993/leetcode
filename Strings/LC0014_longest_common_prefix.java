package Strings;

/*
LeetCode #14 - Longest common prefix

Given an array of strings strs return the longest common prefix of all strings in that array

Pattern:
- Brute force (compare each letter of a chosen string to every letter at that position in every other strings)

Approach:
1. Iterate over strs and find the shortest string, that will be our maximum length for longest common prefix
2. Iterate over str again from 0 to that max length. Take char at position i of the first string, and compare it to
   char at position i in every other string. If you find any mismatch - return current lcp.
3. If there were no mismatches - add a letter at position i to current lcp.

Time Complexity: O(n * m) (n - number of strings, m - length of shortest string)
Space Complexity: O(1)

Examples:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
*/
public class LC0014_longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {
        int maxPrefixLength = 200;
        for(String str: strs) {
            if(str.length() < maxPrefixLength) {
                maxPrefixLength = str.length();
            }
        }

        String lcs = "";
        for(int i = 0; i < maxPrefixLength; i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != strs[0].charAt(i)) {
                    return lcs;
                }
            }
            lcs += c;
        }
        return lcs;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}

