
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //edge case
        if (s == null || s.length() == 0) {
            return 0;
        }
        //give two points, one in the position 0, one in the position 1
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (left < s.length()) {
            
            if (!set.contains(s.charAt(left))) {
                set.add(s.charAt(left));
                left++;
               
                max = Math.max(max, set.size());
            } else {
                
                set.remove(s.charAt(right));
                right++; 
            }    
        }
        return max;   
    }
}