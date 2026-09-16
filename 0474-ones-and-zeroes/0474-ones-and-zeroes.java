class Solution {
    private static int helper(String[] strs, int m, int n, HashMap<Integer, int[]> map, int i, int[][][] dp) {
        if((n == 0 && m == 0) || i == 0) {
            return 0;
        }
        if(dp[m][n][i] != -1) {
            return dp[m][n][i];
        }
        int[] mat = map.get(i-1);
        if(mat[0] <= m && mat[1] <= n) {
            int ans1 = helper(strs, m-mat[0], n-mat[1], map, i-1, dp) + 1;
            int ans2 = helper(strs, m, n, map, i-1, dp);
            return dp[m][n][i] = Math.max(ans1, ans2);
        }
        else {
            return dp[m][n][i] = helper(strs, m, n, map, i-1, dp);
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            String s = strs[i];
            int[] matrix  = new int[2];
            int zero = 0;
            int one = 0;
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '0') {
                    zero++;
                }
                else {
                    one++;
                }
            }
            map.put(i, new int[]{zero, one});
        } 
        int[][][] dp = new int[m+1][n+1][strs.length+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(strs, m, n, map, strs.length, dp);
    }
}