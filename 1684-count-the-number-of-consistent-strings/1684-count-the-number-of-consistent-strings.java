class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<allowed.length();i++){
            map.put(allowed.charAt(i),i);
        }
        int ans=0;
        for(int i=0;i<words.length;i++){
            boolean flag=true;
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                if(!map.containsKey(ch)){
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