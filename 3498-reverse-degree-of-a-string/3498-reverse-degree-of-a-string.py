class Solution(object):
    def reverseDegree(self, s):
        """
        :type s: str
        :rtype: int
        """
        total = 0

        for i in range(len(s)):
            total += (ord('z') - ord(s[i]) + 1) * (i + 1)

        return total