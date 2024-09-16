package fruitstore;

public class Main {
    public static void main(String[] args) {
       
        FruitStock stock = new FruitStock();


        stock.addFruit("Pomme", 10);
        stock.addFruit("Poire", 5);
        stock.addFruit("Ananas", 8);

     
        stock.addFruit("Pomme", 5);

   
        stock.addFruit("Poire", 8);// à modifier


        stock.sellFruit("Ananas", 2);

     
        System.out.println("Stock actuel :");
        stock.displayStock();

      
        stock.removeFruit("Ananas");


        System.out.println("\nStock après suppression de l'ananas :");
        stock.displayStock();
    }
}
