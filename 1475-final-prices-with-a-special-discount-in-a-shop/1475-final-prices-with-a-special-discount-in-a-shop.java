class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                ans[i] = prices[i];
            }
            else {
                ans[i] = prices[i] - prices[s.peek()];
            }
            s.push(i);
        }
        return ans;
    }
}