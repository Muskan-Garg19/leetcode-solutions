class Solution {
    public int timeRequiredToBuy(int[] arr, int k){
        Queue<Integer> q = new LinkedList<>();
        int sec = 0;
        for(int i=0; i<arr.length; i++){
            q.add(i);
        }
        while(arr[k] != 0){
            arr[q.peek()]--;
            if(arr[q.peek()] != 0){
                q.add(q.remove());
            }
            else{
                q.remove();
            }
            sec++;
        }
        return sec;
    }
}