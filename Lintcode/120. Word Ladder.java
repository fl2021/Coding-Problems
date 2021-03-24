public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        //BFS + 构建新的单词
        if (start == null || end == null || dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(start);
        set.add(start);

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(end)) {
                    return distance;
                }

                for (String word : getWord(currentWord, dict)) {
                    if (!set.contains(word)) {
                        queue.add(word);
                        set.add(word);
                    }
                }
            }
        }
        return distance;
    }

    private List<String> getWord(String word, Set<String> dict) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                //构造一个新的字符串
                char[] chars = word.toCharArray();
                chars[i] = c;
                String temp = new String(chars);

                if (dict.contains(temp)) {
                    results.add(temp);
                }
            }
        }
        return results;
    }
}