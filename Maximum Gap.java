class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;
        int max = getMax(nums);
        int min = getMin(nums);
        int len = (max - min) / (n - 1);//桶长
        if (len == 0)
            return max - min;
        int k = ((max - min) / len) + 1;//桶数
        Bucket[] buckets = new Bucket[k];
        init(buckets, min, len);
        fill(buckets, nums, min, len);
        int maxGap = find(buckets);
        return maxGap;
    }
    
    public int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int cur : nums)
            max = Math.max(cur, max);
        return max;
    }

    public int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int cur : nums)
            min = Math.min(cur, min);
        return min;
    }

    public int find(Bucket[] buckets) {
        int premax = Integer.MIN_VALUE;
        int curmin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].min != Integer.MAX_VALUE)
                curmin = buckets[i].min;
            if (premax != Integer.MIN_VALUE && curmin != Integer.MAX_VALUE)
                max = Math.max(curmin - premax, max);
            if (buckets[i].max != Integer.MIN_VALUE)
                premax = buckets[i].max;
        }
        return max;
    }

    public void fill(Bucket[] buckets, int[] nums, int min, int len){
        for (int cur : nums) {
            int whichBucket = (cur - min) / len;
            buckets[whichBucket].max = Math.max(buckets[whichBucket].max, cur);
            buckets[whichBucket].min = Math.min(buckets[whichBucket].min, cur);
        }
    }

    public void init(Bucket[] buckets, int min, int len) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket(min, min + len - 1);
            min = min + len;
        }
    }
    
    class Bucket {
        int left;//inclusive，其实这个是没必要的
        int right;//inclusive，其实这个是没必要的
        int max;
        int min;
        Bucket(int left, int right) {
            this.left = left;
            this.right = right;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
    }
    
    
}
