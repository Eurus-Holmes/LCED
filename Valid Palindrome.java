class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0)
                return true;
            
            s = s.toUpperCase();
            int low1 = 'A', high1 = 'Z';
            int low2 = '0', high2 = '9';
            int low = 0, high = s.length()-1;
            
            while(low < high){
                if((s.charAt(low)<low1||s.charAt(low)>high1)
                    && (s.charAt(low)<low2||s.charAt(low)>high2)){
                        low++;
                        continue;
                    }
                    
                if((s.charAt(high)<low1||s.charAt(high)>high1)
                    && (s.charAt(high)<low2||s.charAt(high)>high2)){
                        high--;
                        continue;
                    }
                if(s.charAt(low) == s.charAt(high)){
                    low++;
                    high--;
                }else
                    return false;
            }
            return true;
    }
}
