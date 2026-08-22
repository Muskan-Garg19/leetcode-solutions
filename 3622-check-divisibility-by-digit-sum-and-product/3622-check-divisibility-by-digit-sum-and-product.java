class Solution {
    private static int helper(int n) {
        int sum = 0;
        int product = 1;
        while(n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n = n/10;
        }

        return sum + product;
    }
    public boolean checkDivisibility(int n) {
        int sum = helper(n);
        return n % sum == 0 ? true : false;
    }
}