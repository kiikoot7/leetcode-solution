class Solution {
    public void sortColors(int[] nums) {
        int[] counter = new int[3];

        for (int num : nums) {
            counter[num]++;
        }

        int j = 0;
        for (int i = 0; i < counter[0]; i++) {
            nums[j++] = 0;
        }

        for (int i = 0; i < counter[1]; i++) {
            nums[j++] = 1;
        }

        for (int i = 0; i < counter[2]; i++) {
            nums[j++] = 2;
        }
    }
}