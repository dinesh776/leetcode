package Github._268.MissingNumber;


//https://leetcode.com/problems/missing-number/description/
//268.MissingNumber

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={2,1,0};
        cycle_sort(arr);
        int missing_number= arr.length;
        for(int i=0;i< arr.length;i++){
            if(arr[i]!=i){
                missing_number=i;
            }
        }
        System.out.println(missing_number);
    }

    static void cycle_sort(int[] arr){
        int i=0;
        while(i<arr.length) {
            int correctIndex = arr[i];
            if(arr[i]< arr.length && arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
