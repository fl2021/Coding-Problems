class TwoSum {
    public Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<Integer, Integer>();
        
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for(Integer num1: map.keySet()) {
            int num2 = value - num1;
            if (num2 == num1 && map.getOrDefault(num2, 0) >= 2) {
                return true;
            }
            if (num2 != num1 && map.getOrDefault(num2, 0) >= 1) {
                return true;
            }
            
        }
        return false;
        
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */