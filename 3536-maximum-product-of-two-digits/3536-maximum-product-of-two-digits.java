class Solution {
    public int maxProduct(int n) {
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        while (n > 0) {
            int rem = n % 10;

            if (rem >= first) {
                sec = first;
                first = rem;
            } else if (rem > sec) {
                sec = rem;
            }

            n /= 10;
        }

        return first * sec;
    }
}