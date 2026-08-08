#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> validSequence(string word1, string word2) {
        int n = word1.length();
        int m = word2.length();

        // pos[c] stores all 0-based indices in word1 where word1[idx] == 'a' + c
        vector<vector<int>> pos(26);
        for (int i = 0; i < n; ++i) {
            pos[word1[i] - 'a'].push_back(i);
        }

        // last_pos[k] = rightmost index in word1 to match word2[k...m-1] exactly
        vector<int> last_pos(m + 1, -1);
        last_pos[m] = n;
        int p = n - 1;
        for (int k = m - 1; k >= 0; --k) {
            while (p >= 0 && word1[p] != word2[k]) {
                p--;
            }
            if (p < 0) break;
            last_pos[k] = p;
            p--; // next character must be strictly before p
        }

        vector<int> ans(m);
        int i = 0;
        bool changed = false;

        for (int j = 0; j < m; ++j) {
            if (i >= n) return {};

            if (changed) {
                // Must match word1[i'] == word2[j]
                int c = word2[j] - 'a';
                auto it = lower_bound(pos[c].begin(), pos[c].end(), i);
                if (it == pos[c].end()) return {};
                ans[j] = *it;
                i = *it + 1;
            } else {
                if (word1[i] == word2[j]) {
                    ans[j] = i;
                    i = i + 1;
                } else {
                    // Try using modification at index i
                    if (j == m - 1 || i < last_pos[j + 1]) {
                        ans[j] = i;
                        changed = true;
                        i = i + 1;
                    } else {
                        // Cannot modify at i; must match word2[j] exactly at i' > i
                        int c = word2[j] - 'a';
                        auto it = lower_bound(pos[c].begin(), pos[c].end(), i);
                        if (it == pos[c].end()) return {};
                        ans[j] = *it;
                        i = *it + 1;
                    }
                }
            }
        }

        return ans;
    }
};