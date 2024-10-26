package Github._7ReverseInteger;

//7. Reverse Integer
//https://leetcode.com/problems/reverse-integer/description/


public class ReverseInteger {
    public static void main(String[] args) {
        int x=1534236469;
        System.out.println(reverse(x));
    }
    static int reverse(int x) {
//        0ms
        long ans=0;
        while(x!=0){
            int unit=x%10;
            ans=(ans*10)+(unit);
            x=x/10;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;
//        1ms
//        long res=0;
//        int n=1;
//        if(x<0){
//            n=-1;
//            x*=-1;
//        }
//        while(x>0){
//            int t=x%10;
//            res=res*10+t;
//            x/=10;
//        }
//        res*=n;
//        if(res<(Math.pow(-2,31))||res>(Math.pow(2,31))){
//            return 0;
//        }
//        return (int)res;
    }
}
