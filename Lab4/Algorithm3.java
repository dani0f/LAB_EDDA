public class Algorithm3 {
    public static int binarySearch(int key, int[] arr, int l, int r){
        //Complete la función
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 5, 7, 8, 9};
        long start = System.currentTimeMillis();
        System.out.println(binarySearch(2,arr, 0, arr.length -1));
        long end = System.currentTimeMillis();
        System.out.println("Time is " +  (end - start) + "ms" );
    }

}
