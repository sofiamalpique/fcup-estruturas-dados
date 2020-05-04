public class Primes {

    static boolean isPrime(int n) {
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) {

            if (n % i == 0) {

                return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {


        int n = 1000; // Limite dos números

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }
}