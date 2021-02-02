package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    /*public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int idx=0;
        boolean rFlag = true;

        if(null==s)
            return false;

        while (idx<s.length()){
            char ch = s.charAt(idx);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(s.charAt(idx));
                idx++;
            }else {
                if(stack.isEmpty())
                    return false;

                char top = stack.peek();
                if(top=='(' && ch==')' || top=='[' && ch==']' || top=='{' && ch=='}'){
                    stack.pop();
                    idx++;
                    continue;
                }else {
                    rFlag = false;
                    break;
                }
            }
        }

        if(!stack.isEmpty())
            return false;

        if(rFlag)
            return true;


        return false;
    }*/

    public boolean isValid(String s){
        Map<Character, Character> cMap = new HashMap<>();
        cMap.put('(', ')');
        cMap.put('{', '}');
        cMap.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(cMap.containsKey(ch)){
                stack.push(ch);
            }else if(cMap.values().contains(ch)){
                if(!stack.isEmpty() && cMap.get(stack.peek())==ch){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vP = new ValidParentheses();
        System.out.println(vP.isValid("{{{[]}}))"));
    }

}
