class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<knowledge.size(); i++) {
            List<String> list = knowledge.get(i);
            String key = list.get(0);
            String value = list.get(1);
            map.put(key, value);
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch != '(') {
                ans.append(ch);
                i++;
            }
            else {
                i++;
                StringBuilder key = new StringBuilder();
                while(s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }
                String k = key.toString();
                if(map.containsKey(k)) {
                    ans.append(map.get(k));
                }
                else {
                    ans.append('?');
                }
                i++;
            }
        }

        return ans.toString();
    }
}