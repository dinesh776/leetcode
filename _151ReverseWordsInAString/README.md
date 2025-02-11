# Reverse Words in a String

## Problem Description
Given an input string `s`, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space. Return a string of words in reverse order concatenated by a single space.

### Example
#### Input:
```
s = "a good   example"
```
#### Output:
```
"example good a"
```

## Solution
This solution trims leading and trailing spaces, splits the string into words, reverses their order, and joins them back with a single space.

## Code Example
```java[]
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String s) {
       s= s.trim();
       String[] words = s.split(" ");
       StringBuilder res=new StringBuilder();
       for(int i= words.length-1;i>=0;i--){
           if(!words[i].equals("")){
               words[i]=words[i].trim();
               if(i!=0){
                   res.append(words[i]);
                   res.append(" ");
               }
               else{
                   res.append(words[i]);
               }
           }
       }
       return res.toString();
    }
}
```

## How It Works
1. **Trim**: Removes leading and trailing spaces from the string.
2. **Split**: Splits the string into words using a space as the delimiter.
3. **Reverse Order**: Iterates from the last word to the first and appends them to a `StringBuilder`.
4. **Join Words**: Ensures words are joined with a single space.

## Usage
Run the `main` method in `ReverseWordsInAString` class, passing an input string. The output will be the reversed words in correct order with a single space.

## Complexity Analysis
- **Time Complexity**: O(n), where `n` is the length of the input string.
- **Space Complexity**: O(n), for storing words and the result string.

