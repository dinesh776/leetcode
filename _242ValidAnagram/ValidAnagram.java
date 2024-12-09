package Github._242ValidAnagram;

//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/description/

public class ValidAnagram {
    public static void main(String[] args) {
       String s1 = "aa", s2 = "bb";
        System.out.println(isAnagram(s1, s2));
    }
    static boolean isAnagram(String s1, String s2) {
        // runtime 1ms
        if (s1.length() != s2.length()) return false;
        int[] map = new int[26];
        for(char ch : s1.toCharArray()){
            map[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            map[ch-'a']--;
        }
        for(int x:map){
            if(x!=0)return false;
        }
        return true;

        // runtime 5ms
        //  if (s1.length() != s2.length()) return false;
        // int[] map = new int[26];
        // for (int i = 0; i < s1.length(); i++) {
        //     map[s1.charAt(i) - 97]++;
        //     map[s2.charAt(i) - 97]--;
        // }

        // for (int x : map)
        //     if (x != 0) return false;

        // return true;

//        runtime is 16ms
//        if(s1.length()!=s2.length()){
//            return false;
//        }
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        for(int i=0; i<s1.length(); i++){
//            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
//            map1.put(s2.charAt(i), map1.getOrDefault(s2.charAt(i), 0)-1);
//        }
//        for(int val: map1.values()){
//            if(val!=0){
//                return false;
//            }
//        }
//        return true;

//        runtime 27ms
//        if(s1.length()!=s2.length()){
//            return false;
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
//            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
//        }
//        for(char c : map.keySet()){
//            if(!map.get(c).equals(map2.get(c))){
//                return false;
//            }
//        }
//        return true;
    }
}
