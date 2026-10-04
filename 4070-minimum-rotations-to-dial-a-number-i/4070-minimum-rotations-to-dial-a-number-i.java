class Solution {
    public int minRotations(String s) {
        int ans = 0;
        int curr = 0;
        for(int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - '0';
            if(curr == pos) {
                continue;
            }
            int diff1 = Math.abs(pos - curr);
            int diff2  = 10 - diff1;
            if(diff1 < diff2) {
                ans += diff1;
            }
            else {
                ans += diff2;
            }
            curr = pos;
        }
        return ans;
    }
}