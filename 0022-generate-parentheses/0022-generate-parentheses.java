class Solution {
    private static void helper(List<String> ans, int n, int opening, int closing, StringBuilder sb) {
        if(opening == n && closing == n) {
            ans.add(sb.toString());
        }
        if(opening < n) {
            helper(ans, n, opening+1, closing, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closing < opening) {
            helper(ans, n, opening, closing+1, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, n, 0, 0, new StringBuilder());
        return ans;
    }
}