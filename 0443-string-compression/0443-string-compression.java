class Solution {
    public int compress(char[] chars) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i < chars.length) {
            char ch = chars[i];
            int free = 0;
            while(i< chars.length && chars[i] == ch) {
                free++;
                i++;
            }
            sb.append(ch);
            if(free > 1) {
                sb.append(free);
            }
        }

        int ans = sb.length();

        for(int j = 0; j < sb.length(); j++) {
            char ch = sb.charAt(j);
            chars[j] = ch;
        }

        return ans;
    }
}