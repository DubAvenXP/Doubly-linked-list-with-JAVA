public class ListaDoble {
    private Node head; //head
    private Node tail;  //tail

    //agregar recibe un valor
    public void append(int value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (head == null) { // primera vez
            head = newNode;
            tail = head;
        } else {
            Node previousTail = tail; // nodo temporal sera igual a la cola actual
            tail = newNode; // el ultimo nodo sera el nuevo nodo
            tail.setPrevious(previousTail);  // el ultimo nodo que ahora es el nuevo... su anterior sera el temporal que era el ultimo antiguo
            previousTail.setNext(newNode); //al antiguo nodo ultimo, se le agrega como siguiente el nuevo nodo
            tail.setNext(null);
        }
    }

    public void pop() {
        if (tail != null) {
            Node temporal = null;
            temporal = tail;
            tail = temporal.getPrevious();
            tail.setNext(null);
        }
    }

    public void shift() {
        if (head != null) {
            Node temporal = head;
            head = temporal.getNext(); //el primer nodo ahora sera el siguiente del anterior primer nodo
            //Verificar si el nuevo primer nodo es null
            if (head == null) {// si es null, el ultimo tambien sera null
                tail = null;
            } else { // si el nuevo primero nodo no era nulo... el anterior a ese si debe ser nulo
                head.setPrevious(null);
            }
        }
    }

    public void remove(int value) {
        Node nodeToRemove = head.getNext(); //Nodo que queremos elminar
        Node previousNodeToRemove = head; //Nodo anterior al que queremos elimnar

        if (head.getValue() == value) this.shift();
        if (tail.getValue() == value) this.pop();

        while (nodeToRemove != null) {
            if (nodeToRemove.getValue() == value) {
                previousNodeToRemove.setNext(nodeToRemove.getNext());
                nodeToRemove.getNext().setPrevious(previousNodeToRemove);
                break;
            }
            previousNodeToRemove = nodeToRemove;
            nodeToRemove = nodeToRemove.getNext();
        }
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.getValue() + "->");
            currentNode = currentNode.getNext();
        }
        System.out.println(head.getValue());

        currentNode = tail;

        while (currentNode != null) {
            System.out.print(currentNode.getValue() + "->");
            currentNode = currentNode.getPrevious();
        }
        System.out.println(tail.getValue());
    }
}
