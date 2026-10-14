class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9) {
            return "";
        }
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        int rem = sum % 9;
        for(int i = 0; i < nines; i++) {
            sb.append("9");
            digit++;
        }
        if(digit < num) {
            sb.append(rem);
            digit++;
        }
        while(digit < num) {
            sb.append("0");
            digit++;
        }

        return sb.toString();
    }
}