class Solution {
    private static int getgcd(int a, int b){
    while(b != 0){
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
    }
    public long gcdSum(int[] arr) {
        int[] max=new int[arr.length];
        max[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            max[i]=Math.max(max[i-1],arr[i]);
        }
        int[] gcd=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            gcd[i]=getgcd(arr[i],max[i]);
        }
        Arrays.sort(gcd);
        int ptr1=0;
        int ptr2=arr.length-1;
        long sum=0;
        while(ptr1<ptr2){
            sum+=getgcd(gcd[ptr1],gcd[ptr2]);
            ptr1++;
            ptr2--;
        }
        return sum;
    }
}