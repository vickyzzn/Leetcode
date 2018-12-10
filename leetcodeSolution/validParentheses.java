/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

 */

package leetcodeSolution;

import java.util.Stack;

public class validParentheses {
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(ch == ')' && !st.isEmpty()&& st.peek() == '('){
                st.pop();
            }else if(ch == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }else if(ch == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            }else{
                return false;
            }
        }
        return st.isEmpty();



    }

}
