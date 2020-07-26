public class BrincarComLinkedLists {
    public static void main(String[] args){
        //Criar exemplo de input 1 (lista de inteiros)
        SinglyLinkedList<Integer> input01 = new SinglyLinkedList<Integer>();

        input01.addLast(2);
        input01.addLast(4);
        input01.addLast(6);
        System.out.println(input01);

        System.out.println(input01.get(1));

        System.out.println(input01.remove(1));

        System.out.println(input01);

        /*
        SinglyLinkedList<Character> input02 = new SinglyLinkedList<Character>();
        
        input02.addLast('a');
        input02.addLast('b');
        input02.addLast('c');
        input02.addLast('d');

        System.out.println(input02);


        System.out.println(input02.get(3));*/
    }

}