class Solution {
    public String smallestPalindrome(String s) {
        int[] free=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            free[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        char middle='A';
        for(int i=0;i<free.length;i++){
            char ch=(char)(i+'a');
            if(free[i]%2!=0){
                middle=ch;
            }
            for(int j=0;j<free[i]/2;j++){
                sb.append(ch);
            }
        }
        StringBuilder original=new StringBuilder(sb);
        if(middle!='A'){
            sb.append(middle);
        }
        for(int i=original.length()-1;i>=0;i--){
            sb.append(original.charAt(i));
        }

        return sb.toString();
    }
}