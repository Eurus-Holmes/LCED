class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mapping;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++)
        {
            mapping[nums[i]] = i;
        }
        for (int i = 0; i < nums.size(); i++)
        {
            int searched = target - nums[i];
            if (mapping.find(searched) != mapping.end()
                && mapping.at(searched) != i)
            {
                result.push_back(i);
                result.push_back(mapping[searched]);
                break;
            }
        }
        return result;     
    }
};
