package Github._69SqrtOfX;
//Sqrt(x)
//https://leetcode.com/problems/sqrtx/description/
public class sqrtOfX {
    public static void main(String[] args) {
        int x=8;
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        if(x==0||x==1){
            return x;
        }
        int s=1,e=x,r=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            long m=(long)mid*mid;
            if(m==x){
                return mid;
            }
            else if(m<x){
                r=mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return r;
    }
}
