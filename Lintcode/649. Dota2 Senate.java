class Solution {
    public String predictPartyVictory(String senate) {
        //队列
        Queue<Integer> r = new LinkedList<Integer>();
        Queue<Integer> d = new LinkedList<Integer>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int rPoll = r.poll(), dPoll = d.poll();
            if (rPoll < dPoll) {
                r.offer (rPoll + length); //让r进入下面一轮，不能干扰第一轮的选择
            } else {
                d.offer (dPoll + length);
            }
        }
        return d.isEmpty()? "Radiant" : "Dire";
    }
}