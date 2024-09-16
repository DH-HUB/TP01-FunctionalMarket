package test;
import org.junit.jupiter.api.Test;

import fruitstore.FruitStock;

import static org.junit.jupiter.api.Assertions.*;


class FruitStockTest {

    @Test
    void testInitialStock() {
        FruitStock stock = new FruitStock();
        stock.addFruit("Pomme", 10);
        stock.addFruit("Poire", 5);
        stock.addFruit("Ananas", 8);

        assertEquals(10, stock.getQuantity("Pomme"));
        assertEquals(5, stock.getQuantity("Poire"));
        assertEquals(8, stock.getQuantity("Ananas"));
    }

    @Test
    void testAddFruit() {
        FruitStock stock = new FruitStock();
        stock.addFruit("Pomme", 10);
        stock.addFruit("Pomme", 5);     // Réassort
        
        assertEquals(15, stock.getQuantity("Pomme"));
    }

    @Test
    void testSellFruit() {
        FruitStock stock = new FruitStock();
        stock.addFruit("Ananas", 8);
        stock.sellFruit("Ananas", 2);  // vente

        assertEquals(6, stock.getQuantity("Ananas"));
    }

    @Test
    void testRemoveFruit() {
        FruitStock stock = new FruitStock();
        stock.addFruit("Ananas", 8);
        stock.removeFruit("Ananas");  // supp

        assertNull(stock.getQuantity("Ananas"));
    }

    @Test
    void testCheckStockBeforeSelling() {
        FruitStock stock = new FruitStock();
        stock.addFruit("Ananas", 8);
        
        assertTrue(stock.isAvailable("Ananas", 2)); // Disponible
        assertFalse(stock.isAvailable("Ananas", 10)); // Pas assez
    }
}
