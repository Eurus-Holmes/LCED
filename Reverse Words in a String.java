public class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0)
            return s;
        String [] result = s.split(" ");
        if(result==null||result.length==0)
            return "";
            
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0; i<result.length;i++){
            if(!result[i].isEmpty())
                list.add(result[i]);
        }
        Collections.reverse(list);
        
        String ans = new String();
        for(int i = 0; i<list.size()-1;i++){
            ans += list.get(i)+" ";
        }
        ans +=list.get(list.size()-1);
        return ans;
    }
}
