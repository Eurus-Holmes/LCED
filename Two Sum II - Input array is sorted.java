class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int l = 0,r = numbers.length-1;
        if(numbers == null || numbers.length<=1){
            return res;
        }
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(sum == target){
                return new int[]{l+1,r+1};
            }else if(sum < target){
                l++;
            }else{
                r--;
            }
        }
        
        return res;
    }
}
