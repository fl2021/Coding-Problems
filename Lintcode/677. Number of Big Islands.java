class Point {
    int x, y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Solution {
    /**
     * @param grid: a 2d boolean array
     * @param k: an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        //1.从为1的地方（该点是一个岛屿，且没有被访问过，开始bfs
        //2.在bfs的过程中，记录经过的岛屿规模，返回岛屿规模
        //3.判断岛屿规模是否大于k

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int number = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && visited[i][j] == false) {
                    int size = bfs(grid, i, j, visited);
                    if (size >= k) {
                        number++;
                    }
                }
            }
        }
        return number;
        
    }

    private int bfs(boolean[][]grid, int i, int j, boolean[][] visited) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (isValid(grid, nx, ny, visited)) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
        
    }

    private boolean isValid(boolean[][] grid, int nx, int ny, boolean[][]visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] && !visited[nx][ny]) {
            return true;
        }
        return false;
    }
}