//   Thought1
/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0||matrix==null)
            return false;
            
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = 0;
        int high = rows*cols-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            int midValue = matrix[mid/cols][mid%cols];
            if(midValue == target)
                return true;
            else if(midValue < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}
*/

//   Thought2
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0)  
            return false;  
        int low = 0;  
        int high = matrix.length-1;  
        while(low<=high){  
            int mid = (low+high)/2;  
            if(matrix[mid][0] == target)
                return true;  
            else if(matrix[mid][0] > target)  
                high = mid-1; 
            else
                low = mid+1;  
        }
        
        int row = high; //当从while中跳出时，low指向的值肯定比target大，而high指向的值肯定比target小
        
        if(row<0)  
            return false; 
            
        low = 0;  
        high = matrix[0].length-1;  
        while(low<=high){  
            int mid = (low+high)/2;  
            if(matrix[row][mid] == target)
                return true;  
            else if(matrix[row][mid] > target)  
                high = mid-1;
            else 
                low = mid+1;  
        }     
        return false;  
    }
}
