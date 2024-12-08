package Github._796RotateString;

//796. Rotate String
//https://leetcode.com/problems/rotate-string/description/

public class RotateString {
    public static void main(String[] args) {
        String s="abcde",goal="cdeab";
        System.out.println(rotateString(s,goal));
    }
    static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubleS = s + s;
        return doubleS.contains(goal);
    }
}
