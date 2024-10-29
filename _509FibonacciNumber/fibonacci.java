package Github._509FibonacciNumber;

//509. Fibonacci Number
//https://leetcode.com/problems/fibonacci-number/description/

public class fibonacci {
    public static void main(String[] args) {
        int n=5;
        System.out.println(fib(n));
    }
    static int fib(int n) {
        // recursion
        // if(n<2){
        //     return n;
        // }
        // return fib(n-1)+fib(n-2);

        // formula
        double phi = (1 + Math.sqrt(5)) / 2;
        double sqrt5 = Math.sqrt(5);

        // Calculate Fibonacci using Binet's formula
        int k = (int) ((Math.pow(phi, n) - Math.pow(1 - phi, n)) / sqrt5);

        return k;
    }
}
