// Ejemplo de código 1:
/* crea un arreglo de enteros y una función para mostrar su contenido
con un for simple y un for each*/

// La clase debe tener el mismo nombre que el archivo
// En una clase se define una librería de métodos estáticos
public class Example1 {
    // El método main se utiliza en cada clase (librería) para realizar pruebas unitarias de cada método estático
    // En Java se puede tener un método main en cada clase (librería) esta caracteristica no se permite en algunos lenguajes de programación
    public static void main(String[] args) {
        // Creación de arreglo forma 1:
        // DataType [] nombre = new DataType[N]
        int [] arrInt1 = new int[3];
        arrInt1[0] = 5;
        arrInt1[1] = 6;
        arrInt1[2] = 8;
        // Creación de arreglo forma 2:
        // DataType [] nombre = { 1,3,5 }
        int [] arrInt2 = { 1,3,5};
        printArrFor(arrInt1);
        printArrForEach(arrInt2);
    }
    // Función que imprime un arreglo utilizando la sentencia for
    public static void printArrFor(int [] arrInt){
        for(int i=0; i < arrInt.length ; i ++  ){
            System.out.printf("Posición %d tiene valor %d\n", i,arrInt[i]);
        }
    }
    // Función que imprime un arreglo utilizando la sentencia foreach
    public static void printArrForEach(int [] arrInt){
        for (int element: arrInt) {
            System.out.print(element);
        }
    }
}
