class Patient
{
    private String name;
    private int age;
    private String rut;

    public Patient(String name, int age, String rut)
    {
        this.name = name;
        this.age = age;
        this.rut = rut;
    }

    public String getName(){ return name;}
    public int getAge(){ return age;}
    public String getRut(){return rut;}
}

class MaxHeap
{
    private int capacity;
    private Patient[] pq;
    private int size;

    public MaxHeap(int capacity)
    {
        this.capacity = capacity;
        this.pq = new Patient[capacity];
        this.size = 0;
    }

    private void swap(int i, int j)
    {
        Patient temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private int compare(Patient a, Patient b)
    {
        if (a.getAge() != b.getAge())
        {
            return(a.getAge() - b.getAge());
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

    public Patient getHead()
    {
        if( size == 0){
            throw new IllegalStateException("La cola de prioridad está vacía");
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
    public void insert( Patient patient)
    {
        if (size == capacity)
        {
            throw new IllegalStateException("La cola de prioridad está llena");
        }
        pq[size++] = patient;
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


    public Patient delete(){
        if (size == capacity)
        {
            throw new IllegalStateException("La cola de prioridad está vacía");
        }
        Patient patient = pq[0];
        pq[0] = pq[--size];
        pq[size] = null;
        sink(0);
        return patient;
    }

    public Patient getPatient(int k)
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
        System.out.println("Lista de patientes en la cola de prioridad");
        for (int i=0; i<size; i++)
        {
            if(pq[i] != null)
            {
                System.out.println(getPatient(i).getName());
            }
        }
    }
}

public class Solution {

    public static void main(String[] args)
    {
        MaxHeap pq = new MaxHeap(50);

        Patient p1 = new Patient("Juan", 30, "11111111-1");
        Patient p2 = new Patient("Pedro", 35, "22222222-2");
        Patient p3 = new Patient("Ana", 40, "33333333-3");
        Patient p4 = new Patient("Maria", 25, "44444444-4");
        Patient p5 = new Patient("Luis", 30, "55555555-5");
        Patient p6 = new Patient("Sofia", 45, "66666666-6");
        Patient p7 = new Patient("Pablo", 35, "77777777-7");
        Patient p8 = new Patient("Carla", 50, "88888888-8");
        Patient p9 = new Patient("Marta", 30, "99999999-9");
        Patient p10 = new Patient("Jorge", 25, "10101010-0");

        pq.insert(p1);
        pq.insert(p2);
        pq.insert(p3);
        pq.insert(p4);
        pq.insert(p5);
        pq.insert(p6);
        pq.insert(p7);
        pq.insert(p8);
        pq.insert(p9);
        pq.insert(p10);

        System.out.println("=====");
        pq.printPriorityQueue();
        System.out.println("=====");

        System.out.println("El primer patiente en la pq es: " + pq.getHead().getName());
        System.out.println("=====");

        while (!pq.isEmpty())
        {
            Patient patient = pq.delete();
            System.out.println("Se atiende a " + patient.getName() + " (edad " + patient.getAge() + ", rut " + patient.getRut() + ")");
        }
    }
}
