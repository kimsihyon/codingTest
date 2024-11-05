import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static int[] dx= {-2, -1, 1, 2, 2, 1, -1, -2};
    static  int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static String ans = "";
    public static void main(String []args) throws IOException {

        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(bu.readLine());

        for(int i = 0; i < total; i++){
            int l = Integer.parseInt(bu.readLine());
            int [][] visited = new int[l][l];

            StringTokenizer st = new StringTokenizer(bu.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bu.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            ans += bfs(l, sx, sy, ex, ey, visited) + "\n";


        }
        System.out.println(ans);

    }
    public static int bfs(int l, int sx, int sy, int ex, int ey, int [][] visited){

        if(sx == ex && sy == ey){
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy});

        visited[sx][sy] = 1;
        int mv = 0;
        while (!queue.isEmpty()){

            int size = queue.size();
            mv++;

            for(int i = 0; i < size; i++){
                int [] cu = queue.poll();
                int x = cu[0];
                int y = cu[1];

                for(int j = 0; j < 8; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < l && ny < l && visited[nx][ny] == 0){

                        if(nx == ex && ny == ey){
                            return mv;
                        }
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = 1;

                    }
                }
            }

        }

        return -1;
    }
}
