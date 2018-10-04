class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >=0 || j >=0){
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = m + n + carry;
            carry = sum / 2;
            sb.insert(0, String.valueOf(sum % 2));
            i--;
            j--;
        }
        if(carry != 0) sb.insert(0, '1');
        return sb.toString();
    }
}
