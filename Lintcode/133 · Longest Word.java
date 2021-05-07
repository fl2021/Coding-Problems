public class Solution {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        // write your code here
      List<String> list = new ArrayList<>();
    	if (dictionary.length == 0) {
    		return list;
    	}
    	
    	list.add(dictionary[0]);
    	for (int i = 1; i < dictionary.length; i++) {
    		if (dictionary[i].length() > list.get(list.size() - 1).length()) {
    			list.clear();
    			list.add(dictionary[i]);
    		} else if (dictionary[i].length() == list.get(list.size() - 1).length()) {
    			list.add(dictionary[i]);
    		} else {
    			continue;
    		}
    	}
    	return list;

    }
}