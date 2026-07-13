class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str=new String("123456789");
        List<Integer> ans=new ArrayList<>();
        for(int i=2;i<=str.length();i++){
            for(int j=0;j<=str.length()-i;j++){
                String sub=str.substring(j,j+i);
                int elem=Integer.parseInt(sub);
                if(low<= elem && elem<=high){
                    ans.add(elem);
                }
                else if(elem>high){
                    break;
                }
            }
        }
        return ans;
    }
}