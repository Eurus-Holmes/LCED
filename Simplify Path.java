//   Thought1
/*
class Solution {
    public String simplifyPath(String path) {
        if(path == null||path.length()==0)
            return path;
        
        Stack<String> stack = new Stack<String>();
        String[] list = path.split("/");
        
        for(int i=0; i<list.length; i++){
            if(list[i].equals(".")||list[i].length()==0)
                continue;
            else if(!list[i].equals(".."))
                stack.push(list[i]);
            else{
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        Stack<String> temp = new Stack<String>();
        while(!stack.isEmpty())  
            temp.push(stack.pop());
        
        while(!temp.isEmpty())
            res.append("/"+temp.pop());
        
        if(res.length()==0)
            res.append("/");
        
        return res.toString();
    }
}
*/


//   Thought2
class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0){  
            return path;  
        }  
          
        String[] splits = path.split("/");  
        LinkedList<String> stack = new LinkedList<String>();  
        for (String s : splits) {  
            if(s.length()==0 || s.equals(".")){  
                continue;  
            }else if(s.equals("..")){  
                if(!stack.isEmpty()){  
                    stack.pop();  
                }  
            }else{  
                stack.push(s);  
            }  
        }  
          
        if(stack.isEmpty()){  
            stack.push("");  
        }  
        String ret = "";  
        while(!stack.isEmpty()){  
            ret += "/" + stack.removeLast();  
        }  
          
        return ret; 
    }
}
