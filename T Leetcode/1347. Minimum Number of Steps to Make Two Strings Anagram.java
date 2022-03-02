class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch : t.toCharArray()) {
        	if(map.containsKey(ch)) {
        		map.put(ch, map.get(ch) - 1);
        		if(map.get(ch) == 0)
        			map.remove(ch);
        	}
        }
        int ans = 0;
        for(char ch : map.keySet())
        	ans += map.get(ch);
        
        return ans;
    }
}
//O(n)O(n)

class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        int steps = 0;
        for(int step : count){
            if(step > 0)    steps += step;
        }
        return steps;
    }
}