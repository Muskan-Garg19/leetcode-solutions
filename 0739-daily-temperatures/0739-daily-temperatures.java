class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] greater = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                greater[i] = -1;
            }
            else{
                greater[i] = s.peek();
            }
            s.push(i);
        }
        int[] output = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            if(greater[i] == -1){
                output[i] = 0;
            }
            else{
                output[i] = greater[i] - i;
            }
        }
        return output;
    }
}