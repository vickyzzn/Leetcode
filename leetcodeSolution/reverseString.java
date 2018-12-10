package leetcodeSolution;
/*
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
 */
public class reverseString {
    public String reverseString(String s){
        if(s == null || s.length() == 0) return null;

        int i = 0;
        int j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j) {
            char tmp = ch[i];
            ch[i] =ch[j];
            ch[j] =tmp;
            i++;
            j--;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        reverseString s = new reverseString();
        String s1 = "Hello";
        System.out.println(s.reverseString(s1));
    }
}
