import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXYZ {
    int height, row, col;
    public PointXYZ(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dRow = {-1, 0, 1, 0, 0, 0};
    static int[] dCol = {0, 1, 0, -1, 0, 0};
    static int[] dHeight = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int[][][] arr;
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];

        boolean allRipe = true;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());

                    if (arr[i][j][k] == 1) {
                        queue.add(new PointXYZ(i, j, k));
                    } else if (arr[i][j][k] == 0) {
                        allRipe = false;
                    }
                }
            }
        }

        
        if (allRipe) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        int result = 0;

        while (!queue.isEmpty()) {
            PointXYZ point = queue.poll();
            int height = point.height;
            int row = point.row;
            int col = point.col;

            for (int i = 0; i < 6; i++) {
                int newHeight = height + dHeight[i];
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newHeight >= 0 && newHeight < h && newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && arr[newHeight][newRow][newCol] == 0) {

                    arr[newHeight][newRow][newCol] = arr[height][row][col] + 1;
                    queue.add(new PointXYZ(newHeight, newRow, newCol));
                    result = Math.max(result, arr[newHeight][newRow][newCol]);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) return -1;
                }
            }
        }

        return result - 1;
    }
}
