class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);
        
        int opt1 = j + 1;                 // Remove both from the front
        int opt2 = n - i;                 // Remove both from the back
        int opt3 = (i + 1) + (n - j);     // Remove one from the front and one from the back
        
        return Math.min(opt1, Math.min(opt2, opt3));
    }
}