class Solution {
public:
    string multiply(string num1, string num2) {
        int m = num1.size();
        int n = num2.size();
        vector<int> array(m+n);
        string ans = "";
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int index1 = i + j;
                int index2 = i + j + 1;
                int sum = (num1[i]-'0')*(num2[j]-'0')+array[index2];
                array[index1] += sum / 10;
                array[index2] = sum % 10;
            }
        }

        for (auto v:array) {
            if (ans.size() != 0 || v != 0)
                ans  += to_string(v);
        }

        return ans.size() == 0?"0":ans;
        
    }
};
