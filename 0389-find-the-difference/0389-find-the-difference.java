class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int ind = t.charAt(i) - 'a';
            freq[ind]--;

            if (freq[ind] < 0) {
                return t.charAt(i);
            }
        }

        return ' ';
    }
}