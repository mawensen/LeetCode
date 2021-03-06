package leetcode.to100;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * Subject: Stack
 * #Hard
 */
public class _85_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (matrix == null || m == 0) return 0;
        int n = matrix[0].length;
        int res = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(curLeft, left[j]);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] height = new int[n + 1];
        height[n] = 0;
        int res = 0;

        for (char[] chars : matrix) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n + 1; i++) {
                if (i < n) {
                    if (chars[i] == '1') {
                        height[i]++;
                    } else height[i] = 0;
                }
                while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                    int cur = height[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                    res = Math.max(res, cur);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
