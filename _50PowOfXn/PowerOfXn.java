package Github._50PowOfXn;

//50. Pow(x, n)
//https://leetcode.com/problems/powx-n/description/

public class PowerOfXn {
    public static void main(String[] args) {
        double x=2.00000;
        int n=10;
        System.out.println(myPow(x,n));
    }

    // using recursion 0ms beats 100%
    static double myPow(double x, int n) {
        long nn=n;
        nn=(nn<0)?nn*-1:nn;
        double res=helper(x,nn,1.0);
        if(n<0){
            res=1/res;
        }
        return res;
    }
    static double helper(double x, long n,double ans) {
        if(n<=0){
            return ans;
        }
        if(n%2==1){
            ans=ans*x;
           return helper(x,n-1,ans);
        }
        else{
            x=x*x;
            return helper(x,n/2,ans);
        }
    }

    // normal method 0ms beats 100%
    static double myPow1(double x, int n) {
       double ans=1.0;
       long nn=n;
       nn=(nn<0)?nn*-1:nn;
       while(nn>0){
           if(nn%2==1){
               ans=ans*x;
               nn=nn-1;
           }
           else{
               x=x*x;
               nn=nn/2;
           }
       }
       if(n<0){
           ans=1.0/(ans);
       }
       return ans;
    }

}
