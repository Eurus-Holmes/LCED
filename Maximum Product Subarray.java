class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = 1;
        int min = 1;
        
        int res = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int n1 = max*nums[i];
            int n2 = min*nums[i];
            
            max = Math.max(nums[i],Math.max(n1,n2));
            min = Math.min(nums[i],Math.min(n1,n2));
            
            res = Math.max(max,res);
        }
        return res;
    }
}
