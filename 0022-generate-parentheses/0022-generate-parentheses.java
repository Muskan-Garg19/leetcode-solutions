class Solution {
    private static List<String> helper(int n) {
        List<List<StringBuilder>> ans = new ArrayList<>();
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder(""));
        ans.add(list);
        list = new ArrayList<>();
        list.add(new StringBuilder("()"));
        ans.add(list);
        for(int i=2; i<n+1; i++) {
            list = new ArrayList<>();
            for(int j=0; j<i; j++) {
                for(int k=0; k<ans.get(j).size(); k++) {
                    StringBuilder outer = new StringBuilder(ans.get(j).get(k));
                    outer.insert(0, '(');
                    outer.append(")");
                    for(int l=0; l<ans.get(i-j-1).size(); l++) {
                        StringBuilder newOuter = new StringBuilder(outer);
                        newOuter.append(ans.get(i-j-1).get(l));
                        list.add(newOuter);
                    }
                }
            }
            ans.add(list);
        }

        list = ans.get(n);
        List<String> finalAns = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            finalAns.add(list.get(i).toString());
        }

        return finalAns;
    }
    public List<String> generateParenthesis(int n) {
        return helper(n);
    }
}