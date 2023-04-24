public class Solution1 {

    public static void reOrder(int [] arr){
        boolean par = true;
        boolean swap;
        for(int i = 0; i < arr.length -1 ; i++){
            if(par){
                swap = arr[i] >= arr[i+1];
            }
            else {
                swap = arr[i] <= arr[i+1];
            }
            if(!swap){
                int aux = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = aux;
            }
            par = !par;
        }
    }

    public static void main(String[] args) {

        int[] arr = {12, 4, 6, 4, 2, 22, 30, 25};
        reOrder(arr);
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
