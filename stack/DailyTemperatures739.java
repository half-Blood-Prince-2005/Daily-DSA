package stack;

import java.util.Stack;

class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] idxOfNextWarmerDay = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                    temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            idxOfNextWarmerDay[i] = !st.isEmpty() ? st.peek() : -1;

            st.push(i);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            if (idxOfNextWarmerDay[i] == -1) {
                answer[i] = 0;
            } else {
                answer[i] = idxOfNextWarmerDay[i] - i;
            }
        }

        return answer;
    }
}

public class DailyTemperatures739 {

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] answer = Solution.dailyTemperatures(temperatures);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}