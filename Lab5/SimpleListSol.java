
package com.mycompany.class5;

public class SimpleListSol {
    private Node head;
    public SimpleListSol(){
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

    public void insertEnd(Node n){
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
        if (head != null) {
            n.next = head;
        }
        head = n;
    }

    public void removeBegin(){
        if(head != null){
            head = head.next;
        }
    }


    public void removeLast(){
        if(head == null){
            System.out.println("Lista vacía");
        }
        else if (head.next == null){
            head = null;
        }
        else{
            Node actual = head;
            Node prev = head;
            while (actual.next != null){
                prev = actual;
                actual = actual.next;
            }
            prev.next = null;
        }
    }


    //BubbleSort
    public void reorderList(){
        Node i=head;
        int len=0;
        while(i!=null)
        {
            i=i.next;
            ++len;
        }
        int itr=0;
        // Se itera en toda la lista
        while(itr<len)
        {
            Node j=head;
            Node prev=head;
            while(j.next!=null)
            {
                // Puntero temporal que guarda el siguiente a j 
                Node temp=j.next;
                if(j.getData()>temp.getData())
                {
                    if(j==head)
                    {
                        // Realiza intercambio de posición en los nodos cuando el cambio se realiza con el head
                        j.next=temp.next;
                        temp.next=j;
                        prev=temp;
                        head=prev;
                    }
                    else
                    {
                        // Realiza intercambio de posición de nodos cuando el cambio no se realiza con el head
                        j.next=temp.next;
                        temp.next=j;
                        prev.next=temp;
                        prev=temp;
                    }
                    continue; 
                }
                prev=j;
                j=j.next;
            }
            ++itr;
        }
    }

    
    public static void main(String[] args) {
        SimpleListSol list = new SimpleListSol();
        Node node1 = new Node(78);
        Node node2 = new Node(20);
        Node node3 = new Node(10);
        Node node4 = new Node(32);
        Node node5 = new Node(1);
        Node node6 = new Node(5);

        list.insertBegin(node1);
        
        list.removeBegin();
        
        list.insertEnd(node2);
        list.insertEnd(node3);
        list.insertEnd(node4);
        list.insertEnd(node5);
        list.insertEnd(node6);
        
        list.removeLast();

        list.reorderList();
        list.printList();
    }

}
