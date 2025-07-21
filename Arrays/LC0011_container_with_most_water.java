package Arrays;

/*
LeetCode #11 - Container with most water

Given an array of integers height, that represents different heights (lines parallel to Y axis) find the maximum
area of a container

Pattern:
- Two pointers (allows us to move in the correct direction - keeping the larger value and looking to change the smaller)

Approach:
1. Initialize a left pointer at the beginning of the array and a right pointer at the end
2. Check the area between two pointers (using the minimal height as a height and distance between pointers as a width)
3. If the area is greater than the current maximal area - make maxArea equal to current area
4. Return area

Time Complexity: O(n)
Space Complexity: O(1)

Example:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
*/

public class LC0011_container_with_most_water {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while(leftPointer < rightPointer) {
            int minHeight = Math.min(height[leftPointer], height[rightPointer]);
            int area = minHeight * (rightPointer - leftPointer);

            if(area > maxArea) {
                maxArea = area;
            }

            if(height[leftPointer] < height[rightPointer]) {
                ++leftPointer;
            } else {
                --rightPointer;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
