class Solution {

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int right = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {

            if (isVowel(arr[i])) {

                while (right > i && !isVowel(arr[right])) {
                    right--;
                }

                if (right > i) {
                    char temp = arr[i];
                    arr[i] = arr[right];
                    arr[right] = temp;

                    right--;
                }
            }
        }

        return new String(arr);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U';
    }
}