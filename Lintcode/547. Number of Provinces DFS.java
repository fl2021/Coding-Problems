class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0; // 计算器
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                //深度优先
                dfs(i, cities, visited, isConnected);
                provinces++;
            }
        }
        return provinces;
    }
    
    private static void dfs(int i, int cities, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, cities, visited, isConnected);
            }
        }
    }
}