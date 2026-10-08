class Solution {
    public String removeOuterParentheses(String str) {
        List<Integer> ends=new ArrayList<>();
        int open=0;
        int close=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                open+=1;
            }
            else if(str.charAt(i)==')'){
                close+=1;
            }
            if(open==close){
                ends.add(i);
                open=0;
                close=0;
            }
        }

        StringBuilder result=new StringBuilder();
        int start=0;
        for(int end:ends){
            for(int i=start+1;i<end;i++){
                result.append(str.charAt(i));
            }
            start=end+1;
        }

        return result.toString();
    }
}