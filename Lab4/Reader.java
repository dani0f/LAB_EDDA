import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Código que lee el archivo test.txt y realiza pruebas de tiempo de ejecución
public class Reader {
    public static void main(String[] args)
            throws IOException
    {
        List<Integer> listOfStrings = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader("test.txt"));
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(   Integer.parseInt(line) );
            line = bf.readLine();
        }
        bf.close();
        int[] array = listOfStrings.stream().mapToInt(Integer::intValue).toArray();


        // Prueba para el primer algoritmo con 1000000 datos
        long start = System.currentTimeMillis();
        System.out.println(Algorithm1.LinearSearch(403161 , array));
        long end = System.currentTimeMillis();
        System.out.println("Time is " +  (end - start) + "ms" );

        // Prueba para el segundo algoritmo con 1000000 datos
        Arrays.sort(array);
        start = System.currentTimeMillis();
        System.out.println(Algorithm3.binarySearch(999999 , array, 0, array.length-1));
        end = System.currentTimeMillis();
        System.out.println("Time is " +  (end - start) + "ms" );
    }
}
