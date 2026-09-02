class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> dp[][] = new ArrayList[n+1][target+1];
        for(int i=0; i<n+1; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(new ArrayList<>());
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<target+1; j++) {
                if(candidates[i-1] <= j) {
                    if(dp[i-1][j] == null && dp[i][j-candidates[i-1]] == null) {
                        continue;
                    }
                    List<List<Integer>> list = new ArrayList<>();
                    if(dp[i-1][j] != null) {
                        for(int k=0; k<dp[i-1][j].size(); k++) {
                            list.add(new ArrayList<>(dp[i-1][j].get(k)));
                        }
                    }
                    if(dp[i][j-candidates[i-1]] != null) {
                        for(int k=0; k<dp[i][j-candidates[i-1]].size(); k++) {
                            List<Integer> sublist = dp[i][j-candidates[i-1]].get(k);
                            List<Integer> newCombo = new ArrayList<>(sublist);
                            newCombo.add(candidates[i-1]);
                            list.add(newCombo);
                        }
                    }
                    dp[i][j] = new ArrayList<>(list);
                }

                else {
                    if(dp[i-1][j] != null) {
                        List<List<Integer>> list = new ArrayList<>();
                        for(int k=0; k<dp[i-1][j].size(); k++) {
                            list.add(dp[i-1][j].get(k));
                        }
                        dp[i][j] = new ArrayList<>(list);
                    }
                }
            }
        }

        if(dp[n][target] != null) {
            return dp[n][target];
        }

        return new ArrayList<>();
    }
}