//Problem Statement: https://leetcode.com/problems/remove-k-digits/
class Solution {
    public String removeKdigits(String num, int k) {
        //case-1 if k == num.length()
        if(k==num.length())
            return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++) {
            //check if curr num is greater than 0 and if stack is empty
            char currChar=num.charAt(i);
            if(currChar=='0' && stack.isEmpty())
                continue;
            if(currChar>'0' && stack.isEmpty()) {
                stack.push(currChar);
            }
            else {
                if(currChar>stack.peek()) {
                    stack.push(currChar);
                }
                else {
                    while(k>0 && !stack.isEmpty() && stack.peek()>currChar) {
                        stack.pop();
                        k--;
                    }
                    if(stack.isEmpty() && currChar=='0')
                        continue;
                    stack.push(currChar);
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty())
            return "0";
        while(k>0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
        
    }
}
