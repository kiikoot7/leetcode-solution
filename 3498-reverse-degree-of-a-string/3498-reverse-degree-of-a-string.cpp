#include <string>

class Solution {
public:
    int reverseDegree(std::string s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            ans += (26 - (s[i] - 'a')) * (i + 1);
        }
        return ans;
    }
};