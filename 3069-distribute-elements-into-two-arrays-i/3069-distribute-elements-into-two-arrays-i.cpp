#include <vector>

class Solution {
public:
    std::vector<int> resultArray(std::vector<int>& nums) {
        std::vector<int> arr1, arr2;
        
        // First operation: append nums[1] to arr1 (0-indexed: nums[0])
        arr1.push_back(nums[0]);
        
        // Second operation: append nums[2] to arr2 (0-indexed: nums[1])
        arr2.push_back(nums[1]);
        
        // Subsequent operations from index 2 to n-1
        for (size_t i = 2; i < nums.size(); ++i) {
            if (arr1.back() > arr2.back()) {
                arr1.push_back(nums[i]);
            } else {
                arr2.push_back(nums[i]);
            }
        }
        
        // Concatenate arr2 to the end of arr1
        arr1.insert(arr1.end(), arr2.begin(), arr2.end());
        
        return arr1;
    }
};