class Solution {
    public String largestNumber(int[] nums) {
        Integer[] ints = new Integer[nums.length];
        // 将其放入Integer数组方便排序
        for(int i=0;i<nums.length;i++){
            ints[i]=nums[i];
        }
        // 排序的方法是前后相拼再后前相拼，比较大小
        Arrays.sort(ints, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                String str1 = String.valueOf(n1);
                String str2 = String.valueOf(n2);
                return (str2+str1).compareTo(str1+str2);
            }
        });
        // 如果第一个数是0，则直接返回0
        if(ints[0]==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // 将数从大到小拼起来就行了
        for(int i=0;i<nums.length;i++){
            sb.append(ints[i]);
        }
        return sb.toString();
    }
}
