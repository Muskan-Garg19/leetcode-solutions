class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            ans += (i + 1) * ('z' - ch + 1);
        }
        return ans;
    }
}