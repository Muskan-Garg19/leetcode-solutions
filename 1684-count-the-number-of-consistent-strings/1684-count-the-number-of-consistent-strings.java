class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] contains=new boolean[26];

        for(int i=0;i<allowed.length();i++){
            char ch=allowed.charAt(i);
            int index=ch-'a';
            contains[index]=true;
        }
        int ans=0;
        for(int i=0;i<words.length;i++){
            boolean flag=true;
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                int index=ch-'a';
                if(!contains[index]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }

        return ans;
    }
}