import java.util.Stack;

class Solution {
    public boolean isValid(String s){
        if (s == null) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } 
            else if (c == ')' && !stack.isEmpty() && stack.pop() == '('){
                continue;
            } else if (c == '}' && !stack.isEmpty() && stack.pop() == '{'){
                continue;
            } else if (c == ']' && !stack.isEmpty() && stack.pop() == '['){
                continue;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}   