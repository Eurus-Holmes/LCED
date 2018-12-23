class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null){
            return -1;
        }
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        if(tokens.length < 3){
            return -1;
        }
        
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s == null || s==""){
                return -1;
            }
            if(isDigit(s)){
                stack.push(Integer.parseInt(s));
            }
            else{
                try{
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int num = 0;
                    if(s.equals("+")){
                        num = num1+num2;
                    }
                    else if(s.equals("-")){
                        num = num2-num1;
                    }
                    else if(s.equals("*")){
                        num = num1*num2;
                    }
                    else if(s.equals("/")){
                        if(num1 == 0){
                            return -1;
                        }
                        num = num2/num1;
                    }
                    stack.push(num);
                    
                }catch(IllegalArgumentException e){
                    return -1;
                }
            }
        }
        
        if(stack.isEmpty()){
            return -1;
        }
        else{
            int res = stack.pop();
            return res;
        }
    }
    
    public boolean isDigit(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(0) == '-'){
                if(s.length()==1){
                    return false;
                }
                else{
                    continue;
                }
            }
            
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
