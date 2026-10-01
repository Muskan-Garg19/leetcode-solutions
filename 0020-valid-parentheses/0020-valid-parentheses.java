class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            else {
                if(s.isEmpty()) {
                    return false;
                }
                if(ch == ')') {
                    if(s.peek() != '(') {
                        return false;
                    }
                    else {
                        s.pop();
                    }
                }
                else if(ch == '}') {
                    if(s.peek() != '{') {
                        return false;
                    }
                    else {
                        s.pop();
                    }
                }
                else {
                    if(s.peek() != '[') {
                        return false;
                    }
                    else {
                        s.pop();
                    }
                }
            }
        }
        return s.isEmpty();
    }
}