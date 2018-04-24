package humanResources;

public class CircleLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
    }

    public void addNode(T value){
        Node<T> node = new Node<T>(value);
        if(head == null) {
            head = node;
            tail = node;
            tail.setNext(head);
        }
        else {
            node.setNext(head);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public boolean reamoveNode(T value){
        Node<T> current = head;
        Node<T> previous = null;

        if(isEmpty())
            return false;

        do{
            if(current.getValue().equals(value)){
                if(previous != null){
                    previous.setNext(current.getNext());
                    if(current == tail)
                        tail = previous;
                }
                else{
                    head = current.getNext();
                    tail.setNext(current.getNext());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }while(current != head);

        return false;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clearList(){
        head = null;
        tail = null;
        size =  0;
    }

    public boolean contains(T value){
        Node<T> current = head;
        while(current != null){
            if(current.getValue().equals(value))
                return true;
            current = current.getNext();
        }
        return false;
    }

    public BusinessTravel[] getBusinessTravels(){
        BusinessTravel[] businessTravels = new BusinessTravel[size];
        Node node = head;
        int counter = 0;
        do {
            businessTravels[counter] = (BusinessTravel) node.getValue();
            node = node.getNext();
            counter++;
        }while(node != head);
        return businessTravels;
    }
}