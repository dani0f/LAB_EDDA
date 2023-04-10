public class Algorithm1Sol {
    public static int LinearSearch(int key, int [] a){
        for (int i = 0 ; i < a.length ; i ++){
            if(a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 4, 6};
        long start = System.currentTimeMillis();
        System.out.println(LinearSearch(6,arr  ));
        long end = System.currentTimeMillis();
        System.out.println("Time is " +  (end - start) + "ms" );
    }
}
