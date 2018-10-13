class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> tem = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, tem, nums,0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> tem, int[] nums, int index) {
        res.add(new ArrayList<Integer>(tem));//防止引用修改所以要new 一个list
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tem.add(nums[i]);
            helper(res, tem, nums, i + 1);
            tem.remove(tem.size() - 1);
        }
    }
}
