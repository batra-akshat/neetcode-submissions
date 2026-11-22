class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<vector<int>, vector<string>> charStringToStrings;
        for(auto str : strs) {
            vector<int> charString = convertToCharString(str);
            if(charStringToStrings.find(charString) == charStringToStrings.end()) {
                charStringToStrings[charString] = {str};
            } else {
                charStringToStrings[charString].push_back(str);
            }
        }
        vector<vector<string>> ans;
        for (auto [charString, strings] : charStringToStrings) {
            ans.push_back(strings);
        }
        return ans;
    }

private: 
    vector<int> convertToCharString(string s) {
        vector<int> cnt(26,0);
        for(auto character : s) {
            cnt[character - 'a']++;
        }
        return cnt;
    }
};
