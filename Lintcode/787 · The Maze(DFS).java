public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public int[] dx = new int[]{0, 0, 1, -1};
    public int[] dy = new int[]{1, -1, 0, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
          return false;
        }

        int rows = maze.length;
        int columns = maze[0].length;
        boolean[][] visited = new boolean[rows][columns];
        
        return dfs(maze, start, destination, visited);   
      }

      private boolean dfs(int[][] maze, int[] start, int[]destination, boolean[][] visited) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
          return true;
        }

        for (int k = 0; k < 4; k++) {
          int nx = start[0];
          int ny = start[1];
          while (isValid(maze, nx, ny)) {
            nx += dx[k];
            ny += dy[k];
          }
            nx -= dx[k];
            ny -= dy[k];
            if (visited[nx][ny]) {
              continue;
            }
            visited[nx][ny] = true;
            if (dfs (maze, new int[]{nx, ny}, destination, visited)) {
              return true;
            }
        }
        return false;
      }


      private boolean isValid(int[][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
          return true;
      }
        return false;
    }
}