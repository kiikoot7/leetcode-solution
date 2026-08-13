import java.util.Arrays;

class Solution {
    static class Node {
        char prefChar, suffChar;
        int prefLen, suffLen, maxLen, len;

        Node() {}

        Node(char c) {
            this.prefChar = c;
            this.suffChar = c;
            this.prefLen = 1;
            this.suffLen = 1;
            this.maxLen = 1;
            this.len = 1;
        }
    }

    private Node[] tree;

    private Node merge(Node L, Node R) {
        Node res = new Node();
        res.len = L.len + R.len;

        res.prefChar = L.prefChar;
        res.prefLen = L.prefLen;
        if (L.prefLen == L.len && L.prefChar == R.prefChar) {
            res.prefLen += R.prefLen;
        }

        res.suffChar = R.suffChar;
        res.suffLen = R.suffLen;
        if (R.suffLen == R.len && R.suffChar == L.suffChar) {
            res.suffLen += L.suffLen;
        }

        res.maxLen = Math.max(L.maxLen, R.maxLen);
        if (L.suffChar == R.prefChar) {
            res.maxLen = Math.max(res.maxLen, L.suffLen + R.prefLen);
        }

        return res;
    }

    private void build(String s, int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(s.charAt(start));
            return;
        }
        int mid = start + (end - start) / 2;
        build(s, 2 * node, start, mid);
        build(s, 2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node] = new Node(c);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        tree = new Node[4 * n];
        build(s, 1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }
}