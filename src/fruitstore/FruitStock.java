package fruitstore;

import java.util.HashMap;
import java.util.Map;

public class FruitStock {
    private Map<String, Fruit> stock = new HashMap<>();
    private Logger logger = new Logger();

    // Ajouter un fruit ou réassort
    public void addFruit(String name, int quantity) {
        stock.merge(name, new Fruit(name, quantity), 
            (existing, newFruit) -> {
                existing.setQuantity(existing.getQuantity() + newFruit.getQuantity());
                return existing;
            });
        logger.log("Ajout de " + quantity + " " + name + "(s)");
    }

    // vendre un fruit
    public void sellFruit(String name, int quantity) {
        Fruit fruit = stock.get(name);
        if (fruit != null && fruit.getQuantity() >= quantity) {
            fruit.setQuantity(fruit.getQuantity() - quantity);
            logger.log("Vente de " + quantity + " " + name + "(s)");
        }
    }

    // Supprimer un fruit
    public void removeFruit(String name) {
        stock.remove(name);
        logger.log(name + " supprimé du stock");
    }

    // Obtenir la quant d'un fruit
    public Integer getQuantity(String name) {
        return stock.getOrDefault(name, null) != null ? stock.get(name).getQuantity() : null;
    }

    // vérifier si un fruit est dispo
    public boolean isAvailable(String name, int quantity) {
        Fruit fruit = stock.get(name);
        return fruit != null && fruit.getQuantity() >= quantity;
    }


    public void displayStock() {
        stock.forEach((name, fruit) -> 
            System.out.println(name + ": " + fruit.getQuantity()));
    }
}
