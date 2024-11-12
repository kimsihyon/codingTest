import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int [][] grap = new int[9][9];
        st = new StringTokenizer(bu.readLine());


        grap[0][0] = Integer.parseInt(st.nextToken());
        int max = grap[0][0];
        int row = 1;
        int col = 1;


        for(int i = 0; i < 9; i++) {
            for(int j = i == 0 ? 1 : 0; j < 9; j++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(bu.readLine());
                }
                grap[i][j] = Integer.parseInt(st.nextToken());
                if(grap[i][j] > max) {
                    max = grap[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
