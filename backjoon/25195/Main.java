import java.io.*;
import java.util.*;

public class Main2 {
    static List<List<Integer>> graph;
    static Set<Integer> fans = new HashSet<>();
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        int s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            fans.add(Integer.parseInt(st.nextToken()));
        }

        dfs(1);
        System.out.println(check ? "yes" : "Yes");
    }

    static void dfs(int current){

        if(check || fans.contains(current)) return;

        if(graph.get(current).isEmpty()){
            check = true;
            return;
        }
        for(int next : graph.get(current)) dfs(next);
    }

}