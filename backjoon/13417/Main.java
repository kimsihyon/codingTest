import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            Deque<Character> cards = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                cards.addLast(scanner.next().charAt(0));
            }

            Deque<Character> result = new ArrayDeque<>();

            while (!cards.isEmpty()) {
                char current = cards.removeFirst();

                if (result.isEmpty() || current <= result.peekFirst()) {
                    result.addFirst(current);
                } else {
                    result.addLast(current);
                }
            }

            StringBuilder output = new StringBuilder();
            for (char c : result) {
                output.append(c);
            }
            System.out.println(output);
        }

        scanner.close();
    }
}
