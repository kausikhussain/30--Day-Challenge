public class ReverseString {
    /**
     * Returns the reversed version of the input string.
     * Runs in O(n) time and O(1) extra space.
     */
    public String reverse(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return new String(arr);
    }
}
