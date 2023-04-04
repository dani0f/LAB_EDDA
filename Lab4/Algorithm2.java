import java.util.concurrent.TimeUnit;

public class Algorithm2 {
    public static int foo(int n) throws InterruptedException {
        int i = 1;
        while ( i < n){
            i = i * 2;
            TimeUnit.SECONDS.sleep(1);
        }
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(foo(100));
        long end = System.currentTimeMillis();
        System.out.println("Time is " +  (end - start) + "ms" );
    }

}
