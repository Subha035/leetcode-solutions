class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }
        while (i < n && s.charAt(i) == 'b') {
            i++;
        }
        // Leftover char means an 'a' after a 'b'
        return i == n;
    }
}