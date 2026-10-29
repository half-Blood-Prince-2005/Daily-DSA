package stack;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElement = new int[1001];
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            nextGreaterElement[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterElement[nums1[i]];
        }
        return nums1;
    }

}

public class NextGreaterElement {

    public static void main(String[] args) {
        System.out
                .println(Arrays.toString(Solution.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
    }

}