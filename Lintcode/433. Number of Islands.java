class Point{
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][]visited = new boolean[rows][columns];
        int number = 0;

        for(int i = 0;i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]&&visited[i][j] == false) {
                    number++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return number;
    }
    private void bfs(boolean[][]grid, int i, int j, boolean[][]visited) {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (isValid(grid, nx, ny, visited)) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }

    private boolean isValid(boolean[][]grid, int nx, int ny, boolean[][]visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx < 0 || nx >= rows || ny < 0 || ny >= columns) {
            return false;
        }
        if (!grid[nx][ny]) {
            return false;
        }
        if (visited[nx][ny] == true) {
            return false;
        }
        return true;
    }
}