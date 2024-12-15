package Github._1342NumberSteps;

//1342. Number of Steps to Reduce a Number to Zero
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

public class CountSteps {
    public static void main(String[] args) {
        int num=8;
        System.out.println(numberOfSteps(num));
    }
    static int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        return 1+((num%2==0)?numberOfSteps(num/2):numberOfSteps(num-1));
    }
}
