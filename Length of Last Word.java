class Solution {
    public int lengthOfLastWord(String s) {
        int p = s.length()-1;
        while(p>=0 && s.charAt(p)==' '){
            p--;
        }
        int end = p;
        while(p>=0 && s.charAt(p)!=' '){
            p--;
        }
        return end-p;
    }
}
