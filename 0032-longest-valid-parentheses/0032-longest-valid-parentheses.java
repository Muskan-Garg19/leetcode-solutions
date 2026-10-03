class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(close > open) {
                open = 0;
                close = 0;
            }
            if(open == close) {
                ans = Math.max(ans, open + close);
            }
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
            }
            else {
                close++;
            }
        }
        if(open == close) {
            ans = Math.max(ans, open + close);
        }
        open = 0;
        close = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(open > close) {
                open = 0;
                close = 0;
            }
            if(open == close) {
                ans = Math.max(ans, open + close);
            }
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
            }
            else {
                close++;
            }
        }

        if(open == close) {
            ans = Math.max(ans, open + close);
        }

        return ans;
    }
}