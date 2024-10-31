
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<Integer>> line = new ArrayList<>();
    static int[] check;
    static int c;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());


        check = new int[vertex+1];


        for(int i =0; i < vertex+1; i++) {
            line.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int goVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());


            line.get(goVertex).add(toVertex);
            line.get(toVertex).add(goVertex);
        }


        for(int i = 1; i < line.size(); i++) {
            Collections.sort(line.get(i));
        }


        c = 1;

        dfs(startVertex);

        for(int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }


    private static void dfs(int vertex) {
        check[vertex] = c;


        for (int newVertex : line.get(vertex)) {
            if (check[newVertex] == 0) {
                c++;
                dfs(newVertex);
            }
        }
    }
}
