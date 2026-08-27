class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] free = new int[26];
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            free[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<target.length(); i++) {
            char ch = target.charAt(i);
            if(free[ch - 'a'] > 0) {
                sb.append(ch);
                free[ch - 'a']--;
            }
            else {
                int j = ch - 'a' + 1;
                while(j < 26 && free[j] == 0) {
                    j++;
                }
                if(j < 26) {
                    sb.append((char)(j + 'a'));
                    free[j]--;
                    for(int k = 0; k < 26; k++) {
                        while(free[k] > 0) {
                            sb.append((char)(k + 'a'));
                            free[k]--;
                        }
                    }
                    return sb.toString();
                }
                int pos = sb.length() - 1;
                while(pos >= 0) {
                    char old = sb.charAt(pos);
                    free[old - 'a']++;
                    int bigger = old - 'a' + 1;
                    while(bigger < 26 && free[bigger] == 0) {
                        bigger++;
                    }
                    if(bigger < 26) {
                        sb.setCharAt(pos, (char) (bigger + 'a'));
                        free[bigger]--;
                        sb.setLength(pos + 1);
                        for(int k = 0; k<26; k++) {
                            while(free[k] > 0) {
                                sb.append((char) (k + 'a'));
                                free[k]--;
                            }
                        }
                        return sb.toString();
                    }
                    sb.deleteCharAt(pos);
                    pos--;
                }
                return "";
            }
        }
        int n = sb.length();
        int pivot = -1;
        if(sb.toString().equals(target)) {
            for(int i=n-2; i>=0; i--) {
                if(sb.charAt(i) < sb.charAt(i+1)) {
                    pivot = i;
                    break;
                }
            }
        }
        if(pivot == -1) {
            return "";
        }
        else {
            char ch = sb.charAt(pivot);
            int min = Integer.MAX_VALUE;
            int ind = -1;
            int j = pivot + 1;
            while(j < n) {
                int diff = sb.charAt(j) - ch;
                if(diff > 0 && diff < min) {
                    min = diff;
                    ind = j;
                }
                j++;
            }
            char temp = sb.charAt(pivot);
            sb.setCharAt(pivot, sb.charAt(ind));
            sb.setCharAt(ind, temp);
            for(int i=pivot+1; i<n-1; i++) {
                for(int k=i+1; k<n; k++) {
                    if(sb.charAt(i) > sb.charAt(k)) {
                        temp = sb.charAt(i);
                        sb.setCharAt(i, sb.charAt(k));
                        sb.setCharAt(k, temp);
                    }
                }
            }
        }
        return sb.toString();
    }
}