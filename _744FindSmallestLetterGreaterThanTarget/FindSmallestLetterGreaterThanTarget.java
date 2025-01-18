package Github._744FindSmallestLetterGreaterThanTarget;
//744. Find Smallest Letter Greater Than Target
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters={'c','f','z'};
        char target='d';
        System.out.println(nextGreatestLetter(letters,target));
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start=0,end=letters.length;
        char res=letters[0];
        while(start<end){
            int mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }
            else{
                res=letters[mid];
                end=mid;
            }
        }
        return res;
    }
}
