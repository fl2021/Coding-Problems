class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        //create an array to record the 26 characters' times.
        int[] compare = new int[26];
        for (int i = 0; i < s.length(); i++) {
            compare[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (compare[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
        
    }
}
//Time Complexity : O(n)
//Space Complexitiy: O(1)