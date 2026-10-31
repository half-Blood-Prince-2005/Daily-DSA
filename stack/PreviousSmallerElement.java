package stack;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length;
        int[] prevSmallerElementIdx = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            prevSmallerElementIdx[i] = !st.isEmpty() ? st.peek() : -1;

            st.push(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (prevSmallerElementIdx[i] == -1) {
                ans.add(-1);
            } else {
                ans.add(arr[prevSmallerElementIdx[i]]);
            }
        }

        return ans;
    }
}

public class PreviousSmallerElement {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        ArrayList<Integer> answer = Solution.prevSmaller(arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}