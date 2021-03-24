/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

        int rows = grid.length;
        int columns = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        queue.add(source);
        visited[source.x][source.y] = true;
        int path = 0;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();

                for (int k = 0; k < 8; k++) {
                    int nx = point.x + dx[k];
                    int ny = point.y + dy[k];
                    if (isValid(grid, nx, ny, visited)) {
                        if (nx == destination.x && ny == destination.y) {
                            return path;
                        }

                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                    }

                }
            }
        }
        return -1;

    }
    private boolean isValid(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx < 0 || nx >= rows || ny < 0 || ny >= columns) {
            return false;
        }
        if (grid[nx][ny]) {
            return false;
        }
        if (visited[nx][ny]) {
            return false;
        }
        return true;




    }
}