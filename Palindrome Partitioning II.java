class Solution {
    public int minCut(String s) {
        int min = 0;  
        int len = s.length();  
        boolean[][] matrix = new boolean[len][len];  
        int cuts[] = new int[len+1];  
          
        if (s == null || s.length() == 0)  
            return min;  
         
        for (int i=0; i<len; ++i){  
            cuts[i] = len - i;  //cut nums from i to len [i,len]
        }  
          
        for (int i=len-1; i>=0; --i){  
            for (int j=i; j<len; ++j){  
                if ((s.charAt(i) == s.charAt(j) && (j-i<2))  
                        || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))  
                {  
                    matrix[i][j] = true;  
                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);  
                }  
            }  
        }  
        min = cuts[0]-1;  
        return min;  
    }
}
