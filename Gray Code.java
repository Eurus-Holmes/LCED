//   Thought1
/*
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        // 加入初始值0
        res.add(0);
        for(int i = 0; i < n; i++){
            // 每一轮的最高位
            int highestBit = 1 << i;
            int size = res.size();
            // 逆序添加上一轮里出现的数，不过开头加上这一轮的最高位
            for(int j = size - 1; j >= 0; j--){
                int num = res.get(j);
                num += highestBit;
                res.add(num);
            }
        }
        return res;
    }
}
*/


//   Thought2
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < 1 << n; i++) res.add((i >> 1)^i);
        return res;
    }
}
