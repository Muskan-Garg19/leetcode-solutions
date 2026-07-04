class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int[] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int row = startPos[0];
            int col = startPos[1];
            int steps = 0;

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                if (ch == 'R') {
                    if (col + 1 >= n) break;
                    col++;
                }
                else if (ch == 'L') {
                    if (col - 1 < 0) break;
                    col--;
                }
                else if (ch == 'U') {
                    if (row - 1 < 0) break;
                    row--;
                }
                else { // 'D'
                    if (row + 1 >= n) break;
                    row++;
                }

                steps++;
            }

            ans[i] = steps;
        }

        return ans;
    }
}