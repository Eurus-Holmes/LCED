class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0)
         return false;
        
       int low = 0;
       int high = nums.length-1;
      
       while(low <= high){
           int mid = (low + high)/2;
           if(target < nums[mid]){
               if(nums[mid]<nums[high])//right side is sorted
                 high = mid - 1;//target must in left side
               else if(nums[mid]==nums[high])//cannot tell right is sorted, move pointer high
                 high--;
               else//left side is sorted
                 if(target<nums[low])
                    low = mid + 1;
                 else 
                    high = mid - 1;
           }else if(target > nums[mid]){
               if(nums[low]<nums[mid])//left side is sorted
                 low = mid + 1;//target must in right side
               else if(nums[low]==nums[mid])//cannot tell left is sorted, move pointer low
                 low++;
               else//right side is sorted
                 if(target>nums[high])
                    high = mid - 1;
                 else
                    low = mid + 1;
           }else
             return true;
       }
       
       return false;
    }
}
