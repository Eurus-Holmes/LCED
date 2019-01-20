public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mark = 0b1, count = 0;
        while(n != 0b0){
            if((n & mark)==0b1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
