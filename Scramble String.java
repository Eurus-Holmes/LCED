//  Though1
/*
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length())
            return false;
        if(s1.length()==0)
            return true;
        boolean[][][] res = new boolean[s1.length()][s2.length()][s1.length()+1];
        for(int i=0;i<s1.length();i++)
        {
            for(int j=0;j<s2.length();j++)
            {
                res[i][j][1] = s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int len=2;len<=s1.length();len++)
        {
            for(int i=0;i<s1.length()-len+1;i++)
            {
                for(int j=0;j<s2.length()-len+1;j++)
                {
                    for(int k=1;k<len;k++)
                    {
                        res[i][j][len] |= res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k];
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
}
*/


//  Thought2 
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())  
            return false;  
        
        if(s1.length()==1 && s2.length()==1)
            return s1.charAt(0) == s2.charAt(0);  
    
       char[] t1 = s1.toCharArray(), t2 = s2.toCharArray();
       Arrays.sort(t1);
       Arrays.sort(t2);
       if(!new String(t1).equals(new String(t2)))
         return false;
         
       if(s1.equals(s2)) 
         return true;
         
       for(int split = 1; split < s1.length(); split++){
           String s11 = s1.substring(0, split);
           String s12 = s1.substring(split);
           
           String s21 = s2.substring(0, split);
           String s22 = s2.substring(split);
           if(isScramble(s11, s21) && isScramble(s12, s22))
             return true;
           
           s21 = s2.substring(0, s2.length() - split);
           s22 = s2.substring(s2.length() - split);
           if(isScramble(s11, s22) && isScramble(s12, s21))
            return true;
       }
       return false;
    }
}
