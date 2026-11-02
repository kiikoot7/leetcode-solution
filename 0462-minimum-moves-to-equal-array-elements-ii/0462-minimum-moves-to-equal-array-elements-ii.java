class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int median = select(nums, 0, n - 1, n / 2);
        long moves = 0;
        for (int x : nums) {
            moves += Math.abs((long) x - median);
        }
        return (int) moves;
    }
    private int select(int[] a, int lo, int hi, int k) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < a[lo]) swap(a, mid, lo);
            if (a[hi] < a[lo]) swap(a, hi, lo);
            if (a[hi] < a[mid]) swap(a, hi, mid);
            int pivot = a[mid];

            int i = lo, j = hi;
            while (i <= j) {
                while (a[i] < pivot) i++;
                while (a[j] > pivot) j--;
                if (i <= j) {
                    swap(a, i++, j--);
                }
            }

            if (k <= j) hi = j;
            else if (k >= i) lo = i;
            else return a[k];
        }
        return a[k];
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}