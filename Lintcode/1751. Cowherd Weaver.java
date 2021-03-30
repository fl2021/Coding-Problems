class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public boolean findHer(String[] maze) {
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};

    int rows = maze.length;
    int columns = maze[0].length();

    Queue<Point> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][columns];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (maze[i].charAt(j) == "S") {
                queue.offer(new Point(i,j));
                visited[i][j] = true;
            }
        }
    }
    while (!queue.isEmpty()) {
        Point point = queue.poll();
        for (int k = 0; k < 4; k++) {
            int nx = point.x + dx[k];
            int ny = point.y + dy[k];
            if (nx >= 0 && nx < rows && ny < columns && ny >= 0 && maze[nx].charAt(ny) == "."
            && !visited[nx][ny]) {
                queue.offer(new Point(nx, ny));
                if (maze[nx].charAt(ny) == "T") {
                    return true;
                }
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
    return false;
}
