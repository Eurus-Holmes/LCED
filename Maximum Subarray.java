// dp
/*  
class Solution {
    public int maxSubArray(int[] nums) {
        int dp=nums[0],max=dp;
        for(int i=1;i<nums.length;i++){
            dp=nums[i]+(dp>0?dp:0);
            if(dp>max){
                max=dp;
            }
        }
        return max;
    }
}
*/

// divide conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return DivideConquer(nums,0,nums.length-1);
    }
    public int DivideConquer(int[] nums,int left,int right){
        if(left>=right){
            return nums[left];
        }
        int mid=(left+right)/2;
        int leftAns=DivideConquer(nums,left,mid);
        int rightAns=DivideConquer(nums,mid+1,right);
        int leftmax=nums[mid],rightmax=nums[mid+1];
        int temp=0;
        for(int i=mid;i>=left;i--){
            temp+=nums[i];
            if(temp>leftmax){
                leftmax=temp;
            }
        }
        temp=0;
        for(int i=mid+1;i<=right;i++){
            temp+=nums[i];
            if(temp>rightmax){
                rightmax=temp;
            }
        }
        return Math.max(Math.max(leftAns,rightAns),leftmax+rightmax);
    }
}
