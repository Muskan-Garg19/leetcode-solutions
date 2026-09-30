class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<n; i++) {
            char ch = seq.charAt(i);
            if(ch == '(') {
                if(count1 <= count2) {
                    count1++;
                    ans[i] = 0;
                }
                else {
                    count2++;
                    ans[i] = 1;
                }
            }
            else {
                if(count1 >= count2) {
                    count1--;
                    ans[i] = 0;
                }
                else {
                    count2--;
                    ans[i] = 1;
                }
            }
        }

        return ans;
    }
}