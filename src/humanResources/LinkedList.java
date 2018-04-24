package humanResources;

public class LinkedList<T> {
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
        if(head == null)
            head = node;
        else
            tail.setNext(node);
        tail = node;
        size++;
    }

    public boolean reamoveNode(T value){
        Node<T> current = head;
        Node<T> previous = null;

        while(current != null){
            if(current.getValue().equals(value)){
                if(previous != null){
                    previous.setNext(current.getNext());
                    if(current.getNext() == null)
                        tail = previous;
                }
                else{
                    head = head.getNext();
                    if(head == null)
                        tail = null;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public int getSize() {
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

    public Employee[] getEmployees(){
        Employee[] employee = new Employee[size];
        Node node = head;
        int counter = 0;
        while(node != null){
            employee[counter] = (Employee) node.getValue();
            node = node.getNext();
            counter++;
        }
        return employee;
    }
}
