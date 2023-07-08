import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class client {
    static App app = new App();
    static String morning = "manana.dat";
    static String late = "tarde.dat";
    static String night = "noche.dat";
    static String request_1 = "requests_1.dat";
    static String request_2 = "requests_2.dat";
    static String request_3 = "requests_3.dat" ;
    static String schedule = "";

    public static void selectScheduler(BufferedReader br) throws IOException {
        boolean exit = false;
        while (!exit){
            System.out.println("Seleccione un horario: 1. mañana, 2. tarde, 3. noche, 4. finalizar programa");
            switch (br.readLine()) {
                case "1" -> {
                    System.out.println("horario 1");
                    schedule = "h1";
                    app.readDrivers(morning);
                    app.readUsers(request_1);
                    exit = true;
                }
                case "2" -> {
                    System.out.println("horario 2");
                    schedule = "h2";
                    app.readDrivers(late);
                    app.readUsers(request_2);
                    exit = true;
                }
                case "3" -> {
                    System.out.println("horario 3");
                    schedule = "h3";
                    app.readDrivers(night);
                    app.readUsers(request_3);
                    exit = true;
                }
                case "4" -> exit = true;
                default -> System.out.println("Ingrese opción válida");
            }
        }
    }

    public static void selectAlgorithm(BufferedReader br) throws IOException {
        boolean exit = false;
        while (!exit){
            System.out.println("Seleccione un algoritmo: 1. greedy, 2. uniforme, 3. finalizar programa");
            switch (br.readLine()) {
                case "1" -> {
                    System.out.println("Greedy");
                    app.greedySolver();
                    app.generateResultFile(schedule +"_result_greedy.csv");
                    exit = true;
                }
                case "2" -> {
                    System.out.println("Uniform");
                    app.uniformSolver();
                    app.generateResultFile(schedule +"_result_uniform.csv");
                    exit = true;
                }
                case "3" -> exit = true;
                default -> System.out.println("Ingrese opción válida");
            }
        }
    }



    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))){
            boolean exit = false;
            while(!exit){
                System.out.println("1 para continuar, 2 para salir");
                switch (br.readLine()) {
                    case "1" -> {
                        selectScheduler(br);
                        selectAlgorithm(br);
                    }
                    case "2" -> exit = true;
                    default -> System.out.println("Ingrese opción válida");
                }


            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
