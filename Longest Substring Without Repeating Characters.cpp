class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> mymap;
        unordered_map<char,int>::iterator it;
        int len = 0,i = -1;
        for(int j=0;j < s.length();j++)
        {
            /***repeat?******/
            it = mymap.find(s.at(j));
            if(it != mymap.end())
            /*****repeat, move i*****/
                i = std::max(it->second,i);
            /****add new character*******/
            mymap[s.at(j)] = j;
            len = std::max(len,(j-i));
        }
        return len;
    }
};
