class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n); // 初始右边界为最右
        
        int max = 0;      
        for (int i = 0; i < m; i++) {
            int currLeft = 0;
            int currRight = n;
            
            // 从左到右算height及left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0; 
                    currLeft = j + 1;
                }
            }
            
            // 从右到左算right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] =  Math.min(right[j], currRight);
                } else {
                    right[j] = n; 
                    currRight = j;
                }
            }
                       
            for (int j = 0; j < n; j++) {
                int area = (right[j] - left[j]) * height[j];
                max = Math.max(max, area);
            }
        }
        
        return max;
    }
}
