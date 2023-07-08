import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;

import static java.lang.Math.abs;

class Vertex {
    int x;
    int y;
    Vertex(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int distanceTo(Vertex v2){
        int distance = abs(x - v2.x) + abs(y - v2.y);
        return distance;
    }
}

class User {
    Vertex v_i;
    Vertex v_f;
    int time;
    User(int x_i ,int y_i, int x_f, int y_f, int time){
        v_i = new Vertex(x_i,y_i);
        v_f = new Vertex(x_f,y_f);
        this.time = time;
    }
}

class Driver {
    Vertex v;
    int busyUntilTime;
    Driver(int x, int y){
        this.v = new Vertex(x,y);
        busyUntilTime = 0;
    }
    public void setV(Vertex v) {
        this.v = v;
    }
}


class App {
    int total;
    public ArrayList<Driver> bussyDrivers;
    public ArrayList<Driver> drivers;
    public PriorityQueue<User> users;
    public ArrayList<Integer> cost;

    App() {
        total = 0;
        drivers = new ArrayList<>();
        bussyDrivers = new ArrayList<>();
        users = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        cost = new ArrayList<>();
    }

    private void addDriver(Driver d) {
        drivers.add(d);
    }

    public void readDrivers(String file) {
        String string;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((string = br.readLine()) != null) {
                String[] arr = string.split(" ");
                Driver d = new Driver(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                addDriver(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readUsers(String file) {
        String string;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((string = br.readLine()) != null) {
                String[] arr = string.split(" ");
                int x_i = Integer.parseInt(arr[0]), y_i = Integer.parseInt(arr[1]);
                int x_f = Integer.parseInt(arr[3]), y_f = Integer.parseInt(arr[4]);
                int time = Integer.parseInt(arr[6]);
                users.add(new User(x_i, y_i, x_f, y_f, time));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateResultFile(String file){
        try {
            FileWriter myWriter = new FileWriter(file);
            for(int i = 0; i < cost.size(); i++)
                myWriter.write(i + " " + cost.get(i) + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void uniformSolver() {

        int i = 0;
        Random rand = new Random();
        while (i <= 12000) {
            int j = 0;
            while (bussyDrivers.size() > j && bussyDrivers.size() > 0){
                if(bussyDrivers.get(j).busyUntilTime == i){
                    bussyDrivers.get(j).busyUntilTime = 0;
                    drivers.add(bussyDrivers.remove(j));
                }
                j++;
            }
            while (users.size() > 0 && users.peek().time <= i){
                if(drivers.size() != 0){
                    User user = users.poll();
                    int index = rand.nextInt(drivers.size());
                    Driver driver = drivers.get(index);
                    int totalDist = driver.v.distanceTo(user.v_i) + user.v_i.distanceTo(user.v_f) + user.time;
                    driver.setV(user.v_f);
                    driver.busyUntilTime =  totalDist;
                    bussyDrivers.add(drivers.remove(index));
                }
            }
            if (cost.size() == 0) {
                cost.add(bussyDrivers.size());
            } else {
                int acum = cost.get(cost.size() - 1) + bussyDrivers.size();
                cost.add(acum);
            }
            i++;
        }



}

    public void greedySolver() {
        int i = 0;
        while (i <= 12000 ) {
            int j = 0;
            //Veo si se desocupa un conductor
            while (bussyDrivers.size() > j && bussyDrivers.size() > 0){
                if(bussyDrivers.get(j).busyUntilTime == i){
                    bussyDrivers.get(j).busyUntilTime = 0;
                    drivers.add(bussyDrivers.remove(j));
                }
                j++;
            }
            if (users.size() > 0 && users.peek().time <= i){
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (Driver d: drivers) {
                    int distance = d.v.distanceTo(users.peek().v_i);
                    if (min > distance){
                        min = distance;
                        minIndex = drivers.indexOf(d);
                    }
                }
                if(minIndex != -1){
                    User user = users.poll();
                    Driver driver = drivers.get(minIndex);
                    int totalDist = min + user.v_i.distanceTo(user.v_f) + user.time;
                    driver.setV(user.v_f);
                    driver.busyUntilTime =  totalDist;
                    bussyDrivers.add(drivers.remove(minIndex));
                }
            }
            if (cost.size() == 0) {
                cost.add(bussyDrivers.size());
            } else {
                int acum = cost.get(cost.size() - 1) + bussyDrivers.size();
                cost.add(acum);
            }
            i++;
        }
    }
}

public class test {

    public static void main(String[] args) {

        App manana = new App();
        manana.readDrivers("noche.dat");
        manana.readUsers("requests_3.dat");
        //manana.greedySolver(); //391298, 366833, 128461
        //manana.uniformSolver();//664482, 653186, 173438
        manana.generateResultFile("result_greedy.txt");
    }
}
