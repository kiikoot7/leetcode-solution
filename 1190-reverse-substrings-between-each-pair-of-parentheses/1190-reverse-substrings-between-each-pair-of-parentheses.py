class Solution(object):
    def reverseParentheses(self, s):
        """
        :type s: str
        :rtype: str
        """
        st = []
        res = []

        for ch in s:
            if ch == '(':
                st.append(len(res))
            elif ch == ')':
                start = st.pop()
                end = len(res) - 1
                self.reverse(res, start, end)
            else:
                res.append(ch)

        return ''.join(res)

    def reverse(self, sb, start, end):
        while start < end:
            sb[start], sb[end] = sb[end], sb[start]
            start += 1
            end -= 1
