class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            String str = tokens[i];
            if(!str.equals("*") && !str.equals("+") && !str.equals("-") && !str.equals("/")) {
                s.push(Integer.parseInt(str));
            }
            else {
                int b = s.pop();
                int a = s.pop();
                if(str.equals("*")) {
                    s.push(a * b);
                }
                else if(str.equals("+")) {
                    s.push(a + b);
                }
                else if(str.equals("/")) {
                    s.push(a / b);
                }
                else {
                    s.push(a - b);
                }
            }
        }

        return s.pop();
    }
}