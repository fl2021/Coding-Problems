class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        //<the number the rabbit answers, the times of the same number                 
        //appears>
        for(int i: answers) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        int rabbitNum = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            //每组可以拥有的兔子数量 = 兔子回答的数字 + 1
            int numPerGroup = e.getKey() + 1;
            //兔子的回答的某个数字出现的次数
            int replyCnt = e.getValue();
            //numOfGroup代表有多少颜色不同的组
            int numOfGroup = replyCnt / numPerGroup;
            //落单的兔子作为另外一组
            if (replyCnt % numPerGroup != 0) {
                numOfGroup++;
            }
            //计入兔子总数
            rabbitNum += numOfGroup * numPerGroup;
            
        }
        
        return rabbitNum;        
    }
}