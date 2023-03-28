import java.util.*;
class Example{
    public static void main(String args[]){

        LinkedHashMap<Integer,String> LHM=new LinkedHashMap<Integer,String>();

        LHM.put(100,"Alberto");
        LHM.put(21,"Jim");
        LHM.put(102,"Pia");

        Iterator<Integer> it = LHM.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            System.out.println(key + ": " + LHM.get(key));
        }
    }
}

