package to600;


public class _583_DeleteOperationforTwoStrings {


    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public int minDistance2(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] temp = new int[s2.length() + 1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    temp[j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[j] = dp[j - 1];
                } else {
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        return dp[s2.length()];
    }

}
