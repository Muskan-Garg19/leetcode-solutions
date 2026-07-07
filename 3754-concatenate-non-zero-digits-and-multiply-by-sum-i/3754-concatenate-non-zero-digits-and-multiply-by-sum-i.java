class Solution {
    public long sumAndMultiply(int n) {
        int num=0;
        
        while(n>0){
            int rem=n%10;
            if(rem!=0){
                num=num*10+rem;
            }
            n=n/10;
        }

        int newnum=0;
        int sum=0;
        while(num>0){
            int rem=num%10;
            sum+=rem;
            newnum=newnum*10+rem;
            num/=10;
        }

        return (long)newnum*sum;
    }
}