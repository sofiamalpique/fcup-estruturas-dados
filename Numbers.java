public class Numbers{
    public static void main(String[] args) {
        int n=10;
        int Soma=0;

        System.out.print("Numeros de 1 a " + n + ": ");
        for(int i=1; i<=n; i++) {
            if(i<n)
                System.out.print(i + ",");
            else           
                System.out.println(i);
    
        
            Soma= Soma + i;
        }
        System.out.print(Soma);
    }
    
}