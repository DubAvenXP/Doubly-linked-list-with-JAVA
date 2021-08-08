public class Main {
    public static void main(String[] args) {

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.append(8);
        list.append(7);
        list.append(5);
        list.append(4);
        list.append(9);
        list.append(15);
        list.append(14);
        list.append(25);
        list.append(21);
        list.append(16);
        list.append(0);
        list.append(1);
        list.append(2);
        list.append(3);

        list.remove(8);
        list.remove(15);
        list.remove(3);
        list.remove(25);

        list.append(25);
        list.append(3);

        list.print();
    }
}
