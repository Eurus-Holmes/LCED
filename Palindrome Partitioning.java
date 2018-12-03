class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<String>(), 0);
        return res;
    }
    private void dfs(String s, List<List<String>> res, List<String> temp, int i) {
        if(i == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {  //如果[i,j]中字符不构成回文，那么不进行下一次递归，直接进入下一次循环判断[i,j+1]
                temp.add(s.substring(i,j+1));
                dfs(s, res, temp, j+1);  //如果[i,j]中字符构成回文，那么进行下一次递归，判断j+1之后字符是否构成回文
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {  //判断s中[start,end]字符是否构成回文
        while(start < end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}
