class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int n = 1;
        int i = 0;
        while(i< word.length()){
            int j= 1;
            while(i< word.length() && j<= 8){
                ans+= n;
                i++;
                j++;
            }
            n++;
        }

        return ans;
    }
}