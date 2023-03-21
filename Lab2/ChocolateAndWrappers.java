//Code with bugs
public class ChocolatesAndWrappers {

    public static int countChoc(int chocolate, int wrap){
        int newChocolate = chocolate / wrap;
        if(newChocolate < 1){
            return 0;
        } else{
          return countChoc(newChocolate, wrap);  
        }
    }
    
    public static int maxChoc(int money, int price, int wrap){
        int chocolate = money / price;
        int newChocolate = countChoc(chocolate, wrap);
        return chocolate + newChocolate;
    }
    
    
    public static void main(String[] args) {
        int money = 17;
        int price = 3;
        int wrap = 2;
        int result = maxChoc(money,price,wrap);
        System.out.println(result);
    }
}
