// Uma classe simples para representar um aluno
class Aluno {
    // Atributos da classe (variáveis para conter informação)
    public static int contador = 0;

    String nome;
    int numero;

    public String toString() {
        return "(" + nome + "," + numero + ")";
    }

    // Construtor "padrão"
    Aluno() {
        nome = "indefinido";
        numero = -1;
        contador++;
    }

    Aluno(String n, int mec) {
        nome = n;
        numero = mec;
        contador++;
    }

    int ano() {
        return numero / 100000;
    }
}

// Classe principal contendo o main para testar a classe Aluno
public class TestAluno {
    public static void main(String[] args) {

        System.out.println("contador = " + Aluno.contador);

        Aluno a = new Aluno();
        Aluno b = new Aluno();
        Aluno c = b;
        b.nome = "modificado";
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        Aluno d = new Aluno();
        Aluno e = new Aluno("Manuel", 201506234);
        System.out.println("d = " + d);
        System.out.println("e = " + e);

        Aluno f = new Aluno("Sofia", 201704877);

        Aluno g = new Aluno("Ana", 201408762);
        Aluno h = new Aluno("Bruno", 201508145);
        System.out.println(g.ano() + " " + h.ano());

        System.out.println("a.nome = " + a.nome);
        System.out.println("a.numero = " + a.numero);
        System.out.println("a = " + a);

        int n = 3;
        Aluno[] v = new Aluno[n];
        for (int i=0; i<n; i++){
            v[i] = new Aluno();
        }
        v[0].nome = "Pedro";
        for (int i=0; i<n; i++){
            System.out.println("v[" + i + "] = " + v[i]);
        }
        
        System.out.println("contador = " + Aluno.contador);
        

        

    }
}