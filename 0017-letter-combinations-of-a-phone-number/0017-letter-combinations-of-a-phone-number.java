class Solution {
    private static void helper(String digits, int i, List<String> ans, StringBuilder curr, String[] phone) {
        if(i == digits.length()) {
            String combo = curr.toString();
            ans.add(combo);
            return;
        }
        int ind = digits.charAt(i) - '0';
        String str = phone[ind];
        for(int j = 0; j < str.length(); j++) {
            helper(digits, i + 1, ans, curr.append(str.charAt(j)), phone);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        String[] phone = new String[10];
        phone[2] = "abc";
        phone[3] = "def";
        phone[4] = "ghi";
        phone[5] = "jkl";
        phone[6] = "mno";
        phone[7] = "pqrs";
        phone[8] = "tuv";
        phone[9] = "wxyz";
        List<String> ans = new ArrayList<>();
        helper(digits, 0, ans, new StringBuilder(), phone);
        return ans;
    }
}