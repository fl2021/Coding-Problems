public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    public Map<Integer, Integer> map = new HashMap<>(); 
    public void add(int number) {
        // write your code here
        int count = map.getOrDefault(number, 0);
        map.put(number, count + 1);       
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (Integer num : map.keySet()) {
          int another = value - num;
          if (another == num && map.get(num) >= 2) {
            return true;
          }
          if (another != num && map.containsKey(another)) {
            return true;
          }
        }
        return false;
    }
}