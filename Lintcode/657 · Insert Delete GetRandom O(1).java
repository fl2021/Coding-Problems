public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map; 
    Random random;
    public RandomizedSet() {
        // do intialization if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (map.containsKey(val)) {
          return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int randIndex = random.nextInt(list.size());
        return list.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */