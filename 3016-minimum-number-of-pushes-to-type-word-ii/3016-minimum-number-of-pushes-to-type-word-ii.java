class Solution {

    class Pair implements Comparable<Pair> {
        char ch;
        int free;
        public Pair(char ch, int free) {
            this.ch = ch;
            this.free = free;
        }
        public int compareTo(Pair p) {
            return p.free - this.free;
        }
    }

    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char key: map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }

        int ans = 0;
        int i = 1;

        while(!pq.isEmpty()) {
            int j = 1;
            while(!pq.isEmpty() && j<= 8) {
                Pair p = pq.remove();
                int free = p.free;
                ans += (free * i);
                j++;
            }
            i++;
        }

        return ans;
    }
}