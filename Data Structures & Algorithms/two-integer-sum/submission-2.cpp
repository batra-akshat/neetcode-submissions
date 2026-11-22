class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> elementToIndex;
        for(int i=0;i<nums.size();i++) {
            if(elementToIndex.find(target - nums[i]) != elementToIndex.end()){
                return {elementToIndex[target - nums[i]], i};
            }
            elementToIndex[nums[i]] = i;
        }
    }
};
