class Solution {
    public int longestPalindrome(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                int ind = ch - 'a';
                lower[ind]++;
            }
            else {
                int ind = ch - 'A';
                upper[ind]++;
            }
        }

        int ans = 0;
        boolean odd = false;

        for(int i = 0; i < 26; i++) {
            if(lower[i] % 2 == 0) {
                ans += lower[i];
            }
            else {
                ans += lower[i] - 1;
                odd = true;
            }

            if(upper[i] % 2 == 0) {
                ans += upper[i];
            }
            else {
                ans += upper[i] - 1;
                odd = true;
            }
        }

        if(odd)
            ans++;

        return ans;
    }
}
