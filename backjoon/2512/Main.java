import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bu.readLine());

        int[] c = new int[n];
        StringTokenizer st = new StringTokenizer(bu.readLine());

        int r = 0;
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, c[i]);
        }

        int m = Integer.parseInt(bu.readLine());
        int l = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            long budget = 0;
            for (int i = 0; i < n; i++) {
                if (c[i] > mid) budget += mid;
                else budget += c[i];
            }
            if (budget <= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }
}
