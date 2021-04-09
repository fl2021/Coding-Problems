public class Solution {
    /**
     * @param codeList: The codeList
     * @param shoppingCart: The shoppingCart
     * @return: The answer
     */
    public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        // Write your code here
        List<String> list = new ArrayList<>();
        for (List<String> strs : codeList) {
            list.addAll(strs);
            //新语法：addAll可以跨越界限加入所有的string
        }
        if (list.size() > shoppingCart.size()) {
            return 0;
        }
     
        for (int i = 0; i < shoppingCart.size() - list.size() + 1; i++) {
             int j = 0;
            while (j < list.size() && (shoppingCart.get(i + j).equals(list.get(j)) || "anything".equals(list.get(j)))) {
              j++;
            }
            if (j == list.size()) {
              return 1;
            }
        }
        return 0;
    }
}