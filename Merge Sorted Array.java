class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        int i = m + n + 1;
        while(m >= 0 || n >= 0){
            if(m < 0){
                nums1[i--] = nums2[n--];
            } else if(n < 0) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
        }
    }
}
