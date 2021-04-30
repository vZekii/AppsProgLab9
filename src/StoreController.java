import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class StoreController {
    private Store store = new Store();
    public final Store getStore() { return store; }

    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;

    private int getAmount() { return Integer.parseInt(amountTf.getText()); }
    private void setAmount(int amount) { amountTf.setText("" + amount); }

    @FXML private void initialize() {
        amountTf.setText("0");
        priceTxt.textProperty().bind(store.getProduct().priceProperty().asString("$%.2f"));
        cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));
        stockTxt.textProperty().bind(store.getProduct().stockProperty().asString().concat(" items"));
    }

    @FXML private void handleSell(ActionEvent event) {
        if (store.getProduct().has(getAmount())) {
            store.getProduct().sell(getAmount());
        }
        setAmount(0);
    }
}
