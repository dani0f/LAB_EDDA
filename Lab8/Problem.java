class Client
{
    private String name;
    private String number;
    private String rut;
    private int priority;

    public Client(String name, String number, String rut, int priority)
    {
        this.name = name;
        this.number = number;
        this.rut = rut;
        this.priority = priority;
    }
    public String getName(){ return name;}
    public String getNumber(){ return number;}
    public String getRut(){return rut;}
    public int getPriority(){return priority;}
}

class MaxHeap
{
    private int capacity;
    private Client[] pq;
    private int size;


    public MaxHeap(int capacity)
    {
        this.capacity = capacity;
        this.pq = new Client[capacity];
        this.size = 0;
    }

    public MaxHeap(Client [] clients)
    {
        //Complete la función
    }



    private void swap(int i, int j)
    {
        Client temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private int compare(Client a, Client b)
    {
        if (a.getPriority() != b.getPriority())
        {
            return(a.getPriority() - b.getPriority());
        }

        else if (!a.getRut().equals(b.getRut()))
        {
            return a.getRut().compareTo(b.getRut());
        }
        else
        {
            return a.getName().compareTo(b.getName());
        }
    }

    public Client getHead()
    {
        if( size == 0){
            throw new IllegalStateException("La lista de prioridad está vacía");
        }
        return pq[0];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private void swim(int k)
    {
        int parent = (k-1)/2;
        if (k>0 && compare(pq[parent], pq[k]) < 0)
        {
            swap(k,parent);
            swim(parent);
        }
    }
    public void insert( Client client)
    {
        if (size == capacity)
        {
            throw new IllegalStateException("La lista de prioridad está llena");
        }
        pq[size++] = client;
        swim(size-1);
    }


    private void sink(int k){
        int left = 2*k+1;
        int right = 2*k+2;
        int greater = k;
        if (left < size && compare(pq[left], pq[greater]) > 0 ){
            greater = left;
        }
        if (right < size && compare(pq[right], pq[greater]) > 0){
            greater = right;
        }
        if (greater != k)
        {
            swap(k, greater);
            sink(greater);
        }
    }


    public Client delete(){
        if (size == capacity)
        {
            throw new IllegalStateException("La lista de prioridad está vacía");
        }
        Client client = pq[0];
        pq[0] = pq[--size];
        pq[size] = null;
        sink(0);
        return client;
    }

    public Client getClient(int k)
    {
        if ( k < size && k >= 0 )
        {
            return pq[k];
        }
        else
        {
            return null;
        }
    }

    public void printPriorityQueue()
    {
        System.out.println("Lista ordenada de clientes en la lista de prioridad");
        for (int i=0; i<size; i++)
        {
            if(pq[i] != null)
            {
                System.out.println(getClient(i).getName() + " " + getClient(i).getNumber());
            }
        }
    }
}

public class Problem {

    public static void main(String[] args)
    {
        Client p1 = new Client("Juan", "98796343", "11111111-1", 1);
        Client p2 = new Client("Pedro", "86651445", "22222222-2", 2);
        Client p3 = new Client("Ana", "75591623", "33333333-3", 3);
        Client p4 = new Client("Maria", "29470349", "44444444-4", 4);
        Client p5 = new Client("Luis", "13409064", "55555555-5", 5);
        Client p6 = new Client("Sofia", "98710360", "66666666-6", 6);
        Client p7 = new Client("Pablo", "43867715", "77777777-7", 7);
        Client p8 = new Client("Carla", "90759199", "88888888-8", 8);
        Client p9 = new Client("Marta", "96517499", "99999999-9", 9);

        Client clients[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
        MaxHeap pq = new MaxHeap(clients);

        System.out.println("=====");
        pq.printPriorityQueue();
        System.out.println("=====");

        System.out.println("El primer cliente en la pq es: " + pq.getHead().getName());
        System.out.println("=====");

        System.out.println("Nueva llamada");
        pq.insert(new Client("Martin", "255446658", "11444245-9",12));
        System.out.println("=====");

        while (!pq.isEmpty())
        {
            Client client = pq.delete();
            System.out.println("Se atiende a " + client.getName() + " (prioridad " + client.getPriority() + ", rut " + client.getRut() + ")");
        }
    }
}
