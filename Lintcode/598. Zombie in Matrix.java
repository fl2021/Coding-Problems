class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column]; 
        Queue<Point> queue = new LinkedList<>(); 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    Point n = new Point(i,j); 
                    queue.offer(n);
                    visited[i][j] = true;
                }
            }
        }
        int day = 0;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                Point point = queue.poll();
                for (int t = 0; t < 4; t++) {
                    int nx = point.x + dx[t];
                    int ny = point.y + dy[t];
                    // define whether the point is in the grid; and whether it's human; and whether it was visited;
                    if (nx >= 0 && nx < row && ny >= 0 && ny < column && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        grid[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return day-1;
    }
}