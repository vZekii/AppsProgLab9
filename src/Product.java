import javafx.beans.property.*;

import java.util.LinkedList;

public class Product {
    private final LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private final String name;
    private final DoubleProperty price = new SimpleDoubleProperty();
    private final IntegerProperty stock = new SimpleIntegerProperty();

    public final ReadOnlyIntegerProperty stockProperty() { return stock; }
    public final int getStock() { return stock.get(); }
    public final String getName() { return name; }
    public final ReadOnlyDoubleProperty priceProperty() { return price; }
    public final double getPrice() { return price.get(); }

    public Product(String name, int stock, double price) {
        this.name = name;
        this.price.set(price);
        this.stock.set(stock);
    }

    public void sell(int n) {
        stock.set(stock.get() - n);
        double money = n * price.get();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock.set(stock.get() + n);
    }

    public boolean has(int n) {
        return stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
