class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int max = 0;
        for(int num : nums){
            max=Math.max(num,max);
        }
        for(int num : nums){
            count+=(max - num);
        }
        return count;
    }
}