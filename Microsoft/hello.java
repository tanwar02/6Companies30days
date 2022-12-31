class Solution {

    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){

            try{

                Integer val = Integer.valueOf(token);
                stack.push(val);
            }
            catch(NumberFormatException ex){

                Integer b = stack.pop(), a = stack.pop();
                Integer cal;

                if(token.equals("+")) cal = a + b;
                else if(token.equals("-")) cal = a - b;
                else if(token.equals("*")) cal = a * b;
                else cal = a / b; 

                stack.push(cal);
            }
        }
        return stack.pop();
    }
}
