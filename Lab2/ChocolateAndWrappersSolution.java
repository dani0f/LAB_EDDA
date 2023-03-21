public class ChocolateAndWrappersSolution {
  
    public static int countChoc(int chocolate, int wrap){
        if (chocolate < wrap){
            return 0;
        }
        int newChocolate = chocolate / wrap;
        return newChocolate + countChoc(newChocolate + chocolate % wrap , wrap);  
    }
    
    public static int maxChoc(int money, int price, int wrap){
        int chocolate = money / price;
        return chocolate + countChoc(chocolate, wrap);
    }
    
    public static void main(String[] args) {
        int money = 17;
        int price = 3;
        int wrap = 2;
        int result = maxChoc(money,price,wrap);
        System.out.println(result);
    }
    
}
