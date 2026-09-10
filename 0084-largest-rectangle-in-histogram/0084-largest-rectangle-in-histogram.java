class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        //right smaller
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = s.peek();
            }
            s.push(i);
        }

        //left smaller
        s = new Stack<>();

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                left[i] =- 1;
            }
            else{
                left[i] = s.peek();
            }
            s.push(i);
        }

        //main logic
        for(int i=0; i<n; i++){
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;
    }
}