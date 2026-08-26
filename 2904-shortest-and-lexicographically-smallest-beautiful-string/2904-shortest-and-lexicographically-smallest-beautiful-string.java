class Solution {
    private static String helper(String s, int k, String ans, int ansCount) {
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < s.length()) {
            if(s.charAt(right) == '0') {
                right++;
            }
            else if(s.charAt(right) == '1') {
                count++;
                if(count < k) {
                    right++;
                    continue;
                }
                if(count > k) {
                    left++;
                    count--;
                }
                while(left < right && s.charAt(left) == '0') {
                    left++;
                }
                String str = s.substring(left, right+1);
                if(right - left + 1 < ansCount) {
                    ans = str;
                    ansCount = right - left + 1;
                }
                else if(right - left + 1 == ansCount && str.compareTo(ans) < 0) {
                    ans = str;
                }
                right++;
            }
        }
        return ans;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        return helper(s, k, "", Integer.MAX_VALUE);
    }
}