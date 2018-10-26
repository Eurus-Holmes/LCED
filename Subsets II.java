class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        res.add(tmp);
        helper(nums, res, tmp, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int index){
        if(index >= nums.length) return;
        int oldIndex = index;
        //跳过重复元素，重复元素的个数根据index和oldIndex可以得到
        while(index < nums.length - 1 && nums[index] == nums[index+1]) index++;
        helper(nums, res, tmp, index + 1);
        //依次在集合中加入1个、2个...重复的元素
        for(int i = oldIndex; i <= index; i++){
            List<Integer> tmp2 = new ArrayList<Integer>(tmp);
            //这里需要一个循环保证这次加的元素个数
            for(int j = i; j <= index; j++){
                tmp2.add(nums[index]);
            }
            res.add(tmp2);
            helper(nums, res, tmp2, index + 1);
        }
    }
}
