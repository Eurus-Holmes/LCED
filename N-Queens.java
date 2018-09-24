class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();  
        if(n < 1) return result;  
        int[] positions = new int[n];  
        nQueens(result, positions, 0, n);  
        return result;  
    }
    public void nQueens(List<List<String>> result, int[] positions, int cur, int n) {  
        if(cur == n) {  
            result.add(generatePosition(positions, n));  
            return;  
        }  
        for(int i = 0; i < n; i++) {  
            if(validPosition(i, cur, positions)) {  
                positions[cur] = i;  
                nQueens(result, positions, cur + 1, n);  
            }  
        }  
    }  
      
    public boolean validPosition(int i, int cur, int[] positions) {  
        for(int j = 0; j < cur; j++) {  
            if(positions[j] == i || Math.abs(j - cur) == Math.abs(i - positions[j])) return false;  
        }  
        return true;  
    }  
      
    public List<String> generatePosition(int[] positions, int n) {  
        List<String> list = new ArrayList<>();  
        for(int i = 0; i < positions.length; i++) {  
            StringBuilder sb = new StringBuilder();  
            for(int j = 0; j < n; j++) {  
                if(j == positions[i]) sb.append('Q');  
                else sb.append('.');  
            }  
            list.add(sb.toString());  
        }  
        return list;  
    }  
}
