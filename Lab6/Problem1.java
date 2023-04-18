public class Problem1 {
    // Complejidad temporal n^2
    // Algoritmo Bubble Sort:
    // -Revisa el elemento actual con el siguiente
    // -Si el elemento actual es mayor al siguiente los intercambia
    // -Continua de esa manera hasta que el arreglo esta ordenado
    public static int [] BubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
        return arr;
    }

    // Complejidad temporal n
    public static void BubbleSortModified(int[] arr)
    {
        //Complete la función
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 4, 2, 22, 30, 25};
        BubbleSortModified(arr);
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
