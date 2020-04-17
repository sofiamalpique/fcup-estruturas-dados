public class NewSquare {

    public static void main(String[] args) {
        line('#', '-', '|', '.', 6);
    }

    static void line(char a, char b, char c, char d, int n) {

        for (int i = 0; i < n; i++) {

            if (i == 0 || i == n - 1) {

                System.out.print(a);

                for (int j = 1; j < n - 1; j++) {

                    System.out.print(b);

                }

                System.out.println(a);

            } else {

                System.out.print(c);

                for (int h = 1; h < n - 1; h++) {

                    System.out.print(d);

                }

                System.out.println(c);

            }

        }

    }

}