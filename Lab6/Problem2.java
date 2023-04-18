public class Problem2 {
    // Complejidad temporal n^2
    // Algoritmo Selection Sort:
    // -Primero busca el más pequeño y lo cambia con el primer elemento
    // -Luego busca el segundo más pequeño y lo cambia por el segundo elemento
    // -Continua de esa manera hasta que el arreglo esta ordenado
    public static int [] SelectionSort(int [] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;
            int aux = arr[min];
            arr[min] = arr[i];
            arr[i] = aux;
        }
        return arr;
    }

    // Complejidad temporal n
    public static void SelectionSortModified(int[] arr, int min, int max){
        //complete la función
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 3, 5, 9, 5, 9, 3, 3, 3, 5};
        SelectionSortModified(arr, 3, 5);
        for (int elem: arr ) {
            System.out.printf(elem + " ");
        }
    }
}
