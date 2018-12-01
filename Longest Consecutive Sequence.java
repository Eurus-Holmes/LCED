class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null||nums.length == 0)
            return 0;
        
        HashSet<Integer> hs = new HashSet<Integer>();  
        
        for (int i = 0 ;i<nums.length; i++)   
            hs.add(nums[i]);  
         
        int max = 0;  
        for(int i=0; i<nums.length; i++){  
            if(hs.contains(nums[i])){
                int count = 1;  
                hs.remove(nums[i]);
                
                int low = nums[i] - 1; 
                while(hs.contains(low)){  
                    hs.remove(low);  
                    low--;  
                    count++;  
                }
                
                int high = nums[i] + 1;  
                while(hs.contains(high)){  
                    hs.remove(high);  
                    high++;  
                    count++;  
                }  
                max = Math.max(max, count);  
            }  
        }  
        return max;  
    }
}
