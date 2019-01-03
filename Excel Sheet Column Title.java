class Solution {
    public String convertToTitle(int n) {
        String title="";
        while(n>0){
            n = n-1;
            title = (char)('A'+n%26)+title;
            n/=26;
        }
        return title;
    }
}
