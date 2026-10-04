class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        int star = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
            }
            else if(ch == '*') {
                star++;
            }
            else {
                close++;
                if(close > open) {
                    int diff = close - open;
                    if(star < diff) {
                        return false;
                    }
                    open += diff;
                    star -= diff;
                }
            }
        }
        if(open == close) {
            return true;
        }
        
        open = 0;
        close = 0;
        star = 0;
        for(int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == ')') {
                close++;
            }
            else if(ch == '*') {
                star++;
            }
            else {
                open++;
                if(open > close) {
                    int diff = open - close;
                    if(star < diff) {
                        return false;
                    }
                    close += diff;
                    star -= diff;
                }
            }
        }

        return true;
    }
}