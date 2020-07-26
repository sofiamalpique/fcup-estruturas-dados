import java.util.*;
/*
 * Nome: Sofia Vieira Santos Malpique Lopes
 *
 * Número mecanográfico: 201704877
 *
 * Sobre ajudas: Conversei com um colega do ISEP sobre a implementação da flag 3 sobre como utilizar as duas iterações para dar print à cardinalidade
 * correspondente. Utilizei o StackOverflow para perceber como se preenche um ArrayList no momento de criação
 * do mesmo (https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line).
 *
 * Explicação da solução: Na flag 1 iterei sobre os casos confirmados fazendo a diferença de cada 2 consecutivos e criei 2 funções para calcular o
 * valor minímo e máximo, sendo a sua complexidade O(n). Na flag 2 calculei as percentagens e depois iterei sobre as mesmas com um contador e uma
 * lista de períodos de baixa propagação vazia e fui adicionando a esta nova lista o número de dias consecutivos em que a percentagem era acima do
 * threshold, a maior dificuldade foi arranjar uma forma de adicionar o período consecutivo caso a lista de percentagens acabasse num momento de
 * baixa propagação. A complexiade também foi O(n). Na flag 3 tive que fazer 2 iterações encadeadas, a primeira a iterar sobre as linhas e a segunda
 * sobre as colunas, sendo que em cada uma das iterações tive que verificar se esse ponto era um ponto onde deveria printar um cardinal ou um ponto
 * dependendo da posição dessa mesma célula. Neste último a complexidade foi de O(n^2).
 */
public class ED231 {

    public static void main(String[] args) {
        List<Integer> casosConfirmadosFlag1 = Arrays.asList(2, 4, 8, 14, 19, 25, 28, 29);
        triagem(8, casosConfirmadosFlag1, 1);

        List<Integer> casosConfirmadosFlag2 = Arrays.asList(100, 105, 110, 116, 121, 128, 140, 141, 146, 150, 153);
        triagem(11, casosConfirmadosFlag2, 2);

        List<Integer> casosConfirmadosFlag3 = Arrays.asList(42, 100, 202, 299, 407, 603, 1045, 1320);
        triagem(8, casosConfirmadosFlag3, 3);
    }

    public static void triagem(int numDiasConsecutivos, List<Integer> casosConfirmados, int flag) {
        switch (flag) {
            case 1: {
                flag1(numDiasConsecutivos, casosConfirmados);
                break;
            }
            case 2: {
                flag2(numDiasConsecutivos, casosConfirmados);
                break;
            }
            case 3: {
                flag3(numDiasConsecutivos, casosConfirmados);
                break;
            }
        }
    }

    public static void flag1(int numDiasConsecutivos, List<Integer> casosConfirmados) {
        List<Integer> variacao = new ArrayList<>();

        for (int i = 0; i < casosConfirmados.size() - 1; i++) {
            int delta = casosConfirmados.get(i + 1) - casosConfirmados.get(i);
            variacao.add(delta);
        }

        int min = getMinFromList(variacao);
        int max = getMaxFromList(variacao);

        System.out.println(min + " " + max);
    }

    public static void flag2(int numDiasConsecutivos, List<Integer> casosConfirmados) {
        List<Double> percentagens = new ArrayList<>();

        for (int i = 0; i < casosConfirmados.size() - 1; i++) {
            double percentagem = (double) (casosConfirmados.get(i + 1) - casosConfirmados.get(i)) / casosConfirmados.get(i);
            percentagens.add(percentagem);
        }

        int contador = 0;
        List<Integer> periodosBaixaPropagacao = new ArrayList<>();

        for (int i = 0; i < percentagens.size(); i++) {
            double elemento = percentagens.get(i);
            boolean isLastElement = i == percentagens.size() - 1;

            if (elemento <= 0.05) {
                contador = contador + 1;
            } else if (contador != 0) {
                periodosBaixaPropagacao.add(contador);
                contador = 0;
            }

            if (isLastElement && contador != 0) {
                periodosBaixaPropagacao.add(contador);
            }
        }

        int max = getMaxFromList(periodosBaixaPropagacao);
        int tamanho = periodosBaixaPropagacao.size();

        System.out.println(tamanho + " " + max);
    }

    public static void flag3(int numDiasConsecutivos, List<Integer> casosConfirmados) {
        int numColunas = numDiasConsecutivos;
        int numLinhas = getMaxFromList(casosConfirmados) / 100;

        List<Integer> cardinais = new ArrayList<>();

        for (int k = 0; k < numColunas; k++) {
            int cardinal = casosConfirmados.get(k) / 100;
            cardinais.add(cardinal);
        }

        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                int cardinalidadeDaColuna = cardinais.get(j);
                boolean devePintar = i >= numLinhas - cardinalidadeDaColuna;

                if (devePintar) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static int getMaxFromList(List<Integer> lista) {
        int max = 0;

        for (int i = 0; i < lista.size(); i++) {
            int elemento = lista.get(i);
            if (elemento > max) {
                max = elemento;
            }
        }

        return max;
    }

    public static int getMinFromList(List<Integer> lista) {
        int min = lista.get(0);

        for (int i = 0; i < lista.size(); i++) {
            int elemento = lista.get(i);
            if (elemento < min) {
                min = elemento;
            }
        }

        return min;
    }
}
