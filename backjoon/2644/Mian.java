import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] visited;
    static StringTokenizer st;

    public static int findKinship(int current, int end, int count) {

        if (current == end) {
            return count;
        }

        visited[current] = 1;


        for (int next : list.get(current)) {
            if (visited[next] == 0) {
                int result = findKinship(next, end, count + 1);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bu.readLine());
        visited = new int[n + 1];


        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }


        st = new StringTokenizer(bu.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int m = Integer.parseInt(bu.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bu.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());


            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        int result = findKinship(start, end, 0);
        System.out.println(result);
    }
}