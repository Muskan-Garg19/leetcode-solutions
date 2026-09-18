class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] end = new int[26];
        int[] start = new int[26];
        Arrays.fill(start, -1);

        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid, true);
        
        List<String> ans = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int ind = ch - 'a';
            if(start[ind] == -1) {
                start[ind] = i;
            }
            end[ind] = i;
        }

        for(int i=0; i<26; i++) {
            if(start[i] == -1) {
                continue;
            }
            for(int j=start[i]; j<=end[i]; j++) {
                char ch = s.charAt(j);
                if(start[ch - 'a'] < start[i]) {
                    isValid[i] = false;
                    break;
                }
                end[i] = Math.max(end[i], end[ch - 'a']);
            }
        }

        int lastTakenStart = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);
            int ind = ch - 'a';
            if(!isValid[ind]) {
                continue;
            }
            if(start[ind] == i && end[ind] < lastTakenStart) {
                ans.add(s.substring(i, end[ind]+1));
                lastTakenStart = i;
            }
        }

        return ans;
    }
}