package Github._1781SumOfBeauty;

//1781. Sum of Beauty of All Substrings
//https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

public class Beauty {
    public static void main(String[] args) {
        String s="aabcbaa";
        System.out.println(beautySum(s));
    }
//    75ms
    static int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int[] charCount=new int[26];
            for(int j=i;j<s.length();j++){
                int index=s.charAt(j)-'a';
                charCount[index]++;
                int[] temp=findMaxMin(charCount);
                sum=sum+(temp[0]-temp[1]);
            }
        }
        return sum;
    }
    static int[] findMaxMin(int[] arr){
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(arr[i]<min&&arr[i]>0){
                min=arr[i];
            }
        }
        return new int[]{max,min};
    }
}
