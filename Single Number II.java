class Solution {
    public int singleNumber(int[] nums) {
        int low = 0, high = 0;
	    for(int i = 0; i < nums.length; i++){
		    low = (low ^ nums[i]) & ~high;
		    high = (high ^ nums[i]) & ~low;
	    }
	    return low;
    }
}
