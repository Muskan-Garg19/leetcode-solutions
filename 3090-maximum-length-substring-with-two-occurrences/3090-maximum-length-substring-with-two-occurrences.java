class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) > 2) {
                ans = Math.max(ans, right-left);
                while(s.charAt(left) != ch) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
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