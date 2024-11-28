package Github._1539KthMissingPositiveNumber;

//1539. Kth Missing Positive Number
//https://leetcode.com/problems/kth-missing-positive-number/description/

public class KthMissingElement {
    public static void main(String[] args) {
        int[] arr={1,3};
        int k=1;
        System.out.println(findKthPositive(arr,k));
    }
    static  int findKthPositive(int[] arr, int k) {
        int n =arr.length;
        int start=0,end=n-1;
        if(k<arr[0]){
            return k;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            int temp=arr[mid]-(mid+1);
            if(temp<k){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return arr[end]+(k-(arr[end]-(end+1)));
    }
}
