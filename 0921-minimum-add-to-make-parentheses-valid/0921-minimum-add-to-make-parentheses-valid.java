class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                count++;
            }
            else {
                count--;
                if(count == -1) {
                    ans++;
                    count = 0;
                }
            }
        }
        ans += count;
        return ans;
    }
}