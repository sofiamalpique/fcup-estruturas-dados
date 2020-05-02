public class NumbersAndSum {
    public static void main(String[] args){
        int n = 10;

        System.out.print("Números de 1 a " + n + ": ");
        for (int i = 1; i <  n; i++){
            System.out.print(i + ", ");
        }
        System.out.println(n);

        int sum = 0;

        for (int j = 1; j <= n; j++){
            sum = sum + j;
        }
        System.out.print("A soma de 1 até " + n + " é: " + sum);
    } 
    
}