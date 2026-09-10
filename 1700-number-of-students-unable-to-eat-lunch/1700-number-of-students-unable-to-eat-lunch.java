class Solution {
    public int countStudents(int[] stu, int[] sand){
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<stu.length; i++){
            q.add(stu[i]);
        }
        for(int i=sand.length-1; i>=0; i--){
            s.push(sand[i]);
        }
        int count = 0;
        while(!q.isEmpty() && count < q.size()){
            if(q.peek() == s.peek()){
                q.remove();
                s.pop();
                count = 0;
            }
            else if(q.peek() != s.peek()){
                q.add(q.remove());
                count++;
            }
        }
        return q.size();
    }
}