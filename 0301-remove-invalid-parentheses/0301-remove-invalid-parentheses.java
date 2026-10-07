class Solution {
    private static void helper(String s, int i, int count, StringBuilder sb, Set<String> set) {
        if(i == s.length()) {
            if(count == 0) {
                String str = sb.toString();
                set.add(str);
            }
            return;
        }
        char ch = s.charAt(i);
        if(ch != '(' && ch != ')') {
            helper(s, i + 1, count, sb.append(ch), set);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if(ch == '(') {
            helper(s, i + 1, count + 1, sb.append(ch), set);
            sb.deleteCharAt(sb.length() - 1);
            helper(s, i + 1, count, sb, set);
            return;
        }
        else {
            if(count > 0) {
                helper(s, i + 1, count - 1, sb.append(ch), set);
                sb.deleteCharAt(sb.length() - 1);
            }
            helper(s, i + 1, count, sb, set);
            return;
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        helper(s, 0, 0, new StringBuilder(), set);
        int max = 0;
        for(String str : set) {
            max = Math.max(max, str.length());
        }
        List<String> ans = new ArrayList<>();
        for(String str : set) {
            if(str.length() == max) {
                ans.add(str);
            }
        }

        return ans;
    }
}