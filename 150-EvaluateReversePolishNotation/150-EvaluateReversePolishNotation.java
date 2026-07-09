// Last updated: 7/9/2026, 5:23:53 PM
import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        return value(tokens);
        
    }
    public static boolean isInteger(String s){
        return s.matches("^[+-]?\\d+$");
    }
    public static int value(String[] arr){
        Stack<Integer> stack = new Stack<>();
        for(String item:arr){
            if(isInteger(item)){
                stack.push(Integer.parseInt(item));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                switch(item){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                }
                    

                
            }
        }
        return stack.pop();
    }
}