class Solution {
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private static void helper(String s, List<String> list, List<List<String>> ans) {
        if(s.length() == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<s.length(); i++) {
            String part = s.substring(0, i+1);
            if(isPalindrome(part)) {
                list.add(part);
                helper(s.substring(i+1), list, ans);
                list.remove(list.size() - 1);
            }
        }
     }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, new ArrayList<>(), ans);
        return ans;
    }
}