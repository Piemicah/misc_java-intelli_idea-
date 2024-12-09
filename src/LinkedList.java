

class Node{
    private int value;
    private  Node next;

    public Node(int v,Node n){
        value=v;
        next=n;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class LinkedList {
    private Node head,tail;
    public LinkedList(){
        head =tail=null;
    }
    public boolean isEmpty(){return head==null;}

    public void addBack(int v){
        Node node = new Node(v,null);
        if(isEmpty()){
            head=tail=node;
        }
        else{
            tail.setNext(node);
            tail=node;
        }
    }

    public void addFront(int v){
        Node node = new Node(v,null);
        if(isEmpty()){
            head=tail=node;
        }
        else{
            node.setNext(head);
            head=node;
        }
    }

    public void print(){
        Node h = head;
        while (h!=null){
            System.out.print(h.getValue()+" ==> ");
            h = h.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i=1;i<=10;i++) list.addBack(i);
        list.print();
        list.addFront(-9);
        list.print();
    }
}
