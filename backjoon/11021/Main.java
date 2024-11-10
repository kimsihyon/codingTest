import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bu.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(bu.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int total = a + b;


            bw.write("Case #" + i + ": " + total + "\n");
        }


        bw.flush();
    }
}
