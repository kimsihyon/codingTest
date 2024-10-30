import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String xy = sc.nextLine();
        int[] parts = Stream.of(xy.split(" ")).mapToInt(Integer::parseInt).toArray();
        long x = parts[0];
        long y = parts[1];

        int currentWinRate = (int) ((double) y * 100 / x);

        if (currentWinRate >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = (int)1e9;

        while (left < right) {
            long mid = (left + right) / 2;
            long totalGame = x + mid;
            long newWins = y + mid;
            long newWinRate = (int) ((double) newWins * 100 / totalGame);

            if (newWinRate > currentWinRate) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}