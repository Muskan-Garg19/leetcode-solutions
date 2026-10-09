class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        int i = 0;
        int ans = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
                i++;
            }
            else {
                while(i < n && s.charAt(i) == ')') {
                    close++;
                    i += 1;
                }
                if(close % 2 != 0) {
                    close++;
                    ans++;
                }
                int half = close / 2;
                if(open < half) {
                    ans += (half - open);
                    open = 0;
                }
                else {
                    open -= half;
                }
                close = 0;
            }
        }

        if(open != 0) {
            int twice = open * 2;
            ans += twice - close;
        }
        else {
            if(close != 0) {
                if(close % 2 != 0) {
                    close++;
                }
                int half = close / 2;
                ans += (half - open);
            }
        }

        return ans;
    }
}