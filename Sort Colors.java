class Solution {
    public static void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
    public void sortColors(int[] nums) {
        if(nums == null || nums.length==0)
            return;
            
        int notred=0;
        int notblue=nums.length-1;
         
        while (notred<nums.length&&nums[notred]==0)
            notred++;
            
        while (notblue>=0&&nums[notblue]==2)
            notblue--;
         
        int i=notred;
        while (i<=notblue){
            if (nums[i]==0) {
                swap(nums,i,notred);
                notred++;
                i++;
            }else if (nums[i]==2) {
                swap(nums,i,notblue);
                notblue--;
            }else
                i++;
        }
    }
}
