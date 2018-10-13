class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, k, n, new ArrayList<Integer>());
        return res;
    }
    
    private void dfs(int start, int k, int n, List<Integer> tmp){
        // 当已经选择足够数字时，将tmp加入结果
        if(k == 0){
            res.add(new ArrayList<Integer>(tmp));
        }
        // 每一种选择数字的可能
        for(int i = start; i <= n; i++){
            tmp.add(i);
            dfs(i + 1, k - 1, n, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
