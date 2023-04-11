public class SimpleList {
    private Node head;
    public SimpleList(){
        this.head = null;
    }
    static class Node{
        private int data;
        public Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public int getData(){
            return data;
        }
    }

    public void insertAtEnd(Node n){
        if(head == null){
            head = n;
        }
        else{
            Node actual = head;
            while (actual.next != null){
                actual = actual.next;
            }
            actual.next = n;
        }
        System.out.println("Nodo ingresado");
    }

    public void printList(){
        Node actual = head;
        while (actual != null){
            System.out.print(actual.getData() + " / ");
            actual = actual.next;
        }
    }

    public void insertBegin(Node n){
    }

    public void removeBegin(){
    }

    public void removeLast(){
    }

    public void reorderList(){
    }



    public static void main(String[] args) {
        SimpleList list = new SimpleList();
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
      
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        list.insertAtEnd(node3);
      
        list.printList();
    }
}
