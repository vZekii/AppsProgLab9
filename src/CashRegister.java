import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class CashRegister implements ProductObserver {
    private final DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0.0);
    }

    public final ReadOnlyDoubleProperty cashProperty() { return cash; }
    public double getCash() { return cash.get(); }

    public void add(double money) {
        cash.set(cash.get() + money);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
