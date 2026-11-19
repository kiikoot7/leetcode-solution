class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        int l1, l2, l3, r1, r2, r3;
        l1 = l2 = l3 = Integer.MAX_VALUE;
        r1 = r2 = r3 = Integer.MIN_VALUE;

        for(int x: nums){
            if(x < l1){
                l3 =l2;
                l2 = l1;
                l1 = x;
            }else if(x < l2){
                l3 = l2;
                l2 = x;
            }else if(x < l3){
                l3 = x;
            }

            if(x > r1){
                r3 = r2;
                r2 = r1;
                r1 = x;
            }else if(x > r2){
                r3 = r2;
                r2 = x;
            }else if(x > r3){
                r3 = x;
            }
        }

        return Math.min(r2 - l2, Math.min(r1 - l3, r3 - l1));

    }
}