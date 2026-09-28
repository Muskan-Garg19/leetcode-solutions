class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                ans = Math.max(ans, stack.size() + 1);
                stack.push('(');
            }
            else if(s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return ans;
    }
}