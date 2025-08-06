package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
LeetCode #22 - Generate Parentheses

Given an integer n, return all combinations of well-formed parentheses with n pairs of parentheses.

Pattern:
- Backtracking (DFS with constraints to prune invalid combinations)

Approach:
1. Start DFS with 0 opening and 0 closing brackets and an empty string
2. At each step, try to add either '(' or ')'
3. Only add '(' if number of opening brackets is less than n
4. Only add ')' if number of closing brackets is less than number of opening brackets
5. Stop and add result when both counts equal n

Time Complexity: O(4^n / √n) — number of valid parentheses combinations (Catalan number)
Space Complexity: O(2n) for recursion stack, O(C_n * 2n) for storing results

Examples:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 1
Output: ["()"]
*/


class LC0022_valid_parentheses {
    private static final List<String> answer = new ArrayList<>();
    private static int maxCount;

    public static List<String> generateParenthesis(int n) {
        maxCount = n;
        dfs(0, 0, "");
        return answer;
    }

    private static void dfs(int starting, int ending, String current) {
        if(starting > maxCount || ending > maxCount || starting < ending) {
            return;
        }
        if(starting == maxCount && ending == maxCount) {
            answer.add(current);
            return;
        }

        dfs(starting + 1, ending, current + "(");
        dfs(starting, ending + 1, current + ")");
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
