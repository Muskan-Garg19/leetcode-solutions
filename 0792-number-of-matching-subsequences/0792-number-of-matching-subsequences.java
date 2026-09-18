class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int ans = 0;
        ArrayList<Integer>[] free = new ArrayList[26];
        for(int i=0; i<26; i++) {
            free[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            int ind = ch - 'a';
            free[ind].add(i);
        }
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            int last = Integer.MIN_VALUE;
            boolean isAns = true;
            for(int j=0; j<word.length(); j++) {
                char ch = word.charAt(j);
                int ind = ch - 'a';
                ArrayList<Integer> list = free[ind];
                if(list.size() == 0 || list.get(list.size() - 1) <= last) {
                    isAns = false;
                    break;
                }
                else if(list.get(0) > last) {
                    last = list.get(0);
                }
                else {
                    int next = -1;
                    int low = 0;
                    int high = list.size()-1;
                    while(low <= high) {
                        int mid = low + (high - low)/2;
                        if(list.get(mid) <= last) {
                            low = mid + 1;
                        }
                        else {
                            next = list.get(mid);
                            high = mid - 1;
                        }
                    }
                    last = next;
                }
            }
            if(isAns) {
                ans++;
            }
        }

        return ans;
    }
}