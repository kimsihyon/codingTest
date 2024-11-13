import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static int fibo(int n){

        if(n == 0)return 0;
        if(n==1)return 1;

        return fibo(n -1) + fibo(n -2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bu.readLine());
        System.out.println(fibo(num));

    }
}
