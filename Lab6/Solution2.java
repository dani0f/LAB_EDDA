public class Solution2 {

    public static void reOrder(int min, int max, int[] arr){
        int i = 0;
        int j = arr.length - 1;
        int aux;
        for (int k=0; k <= j ; k++ ){
            if( arr[k] == min ){
                aux = arr[i];
                arr[i] = arr[k];
                arr[k] = aux;
                i++;
            }
            if( arr[k] == max){
                if(arr[j] == min){
                    aux = arr[j];
                    arr[j] = arr[k];
                    arr[k] = arr[i];
                    arr[i] = aux;
                    i++;
                }
                else{
                    aux = arr[j];
                    arr[j] = arr[k];
                    arr[k] = aux;
                }
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 3, 5, 9, 5, 9, 3, 3, 3, 5};
        reOrder(3, 9 , arr);
        for (int elem: arr ) {
            System.out.printf(elem + " ");
        }
    }
}
