public class Algorithm1 {
    public static int LinearSearch(int key, int [] a){
        //Complete la función
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 4, 6};
        long start = System.currentTimeMillis();
        System.out.println(LinearSearch(6, arr));
        long end = System.currentTimeMillis();
        System.out.println("Time is " + (end - start) + "ms" );
    }

}
