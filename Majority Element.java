class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], cnt = 0;
        for(int i=1;i<nums.length;i++){
            if(candidate == nums[i]){
                cnt++;
            }else if(cnt == 0){
                candidate = nums[i];
            }else{
                cnt--;
            }
        }
        return candidate;
    }
}
