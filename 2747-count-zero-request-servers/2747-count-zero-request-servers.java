class Solution {

    public class Pair implements Comparable<Pair> {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {
            if (this.a != p.a) {
                return Integer.compare(this.a, p.a);
            }
            return Integer.compare(this.b, p.b);
        }
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int[] ans = new int[queries.length];

        Pair[] q = new Pair[queries.length];

        for (int i = 0; i < queries.length; i++) {
            q[i] = new Pair(queries[i], i);
        }

        Arrays.sort(q);

        Arrays.sort(logs, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int i = 0; i < q.length; i++) {

            int time = q[i].a;
            int idx = q[i].b;

            while (right < logs.length &&
                   logs[right][1] <= time) {

                int id = logs[right][0];

                if (freq[id] == 0) {
                    active++;
                }

                freq[id]++;
                right++;
            }

            while (left < right &&
                   logs[left][1] < time - x) {

                int id = logs[left][0];

                freq[id]--;

                if (freq[id] == 0) {
                    active--;
                }

                left++;
            }

            ans[idx] = n - active;
        }

        return ans;
    }
}