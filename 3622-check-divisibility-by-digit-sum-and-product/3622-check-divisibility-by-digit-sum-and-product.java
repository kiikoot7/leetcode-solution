class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0, p = 1;
        int x = n;
        
        while (x != 0) {
            int v = x % 10; // Extract the last digit
            x /= 10;        // Remove the last digit
            s += v;         // Add to digit sum
            p *= v;         // Multiply with digit product
        }
        
        // Check if n is divisible by the sum of digit sum and digit product
        return n % (s + p) == 0;
    }
}