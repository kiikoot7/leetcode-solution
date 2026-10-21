class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        if(n==2 && s.charAt(0)!=sorted[0]) return -1; 
        int err = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=sorted[i])err++;
        }

        if(err==0) return 0;

        if(s.charAt(0)==sorted[0] || s.charAt(n-1)==sorted[n-1]){
            return 1;
        }

        boolean minInPrefix = false;
        boolean maxInSuffix = false;
        char min = sorted[0];
        char max = sorted[n-1];
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==min) minInPrefix = true;
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)==max) maxInSuffix = true;
        }

        if(maxInSuffix||minInPrefix) return 2;

        return 3;
        
    }
}