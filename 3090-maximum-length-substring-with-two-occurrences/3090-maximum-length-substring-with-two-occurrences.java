class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int[] free = new int[26];
        while(right < s.length()) {
            char ch = s.charAt(right);
            free[ch - 'a']++;
            if(free[ch - 'a'] > 2) {
                ans = Math.max(ans, right-left);
                while(s.charAt(left) != ch) {
                    free[s.charAt(left) - 'a']--;
                    left++;
                }
                free[s.charAt(left) - 'a']--;
                left++;
                right++;
            }
            else {
                right++;
            }
        }

        ans = Math.max(ans, right-left);
        return ans;
    }
}