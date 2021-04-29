import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class StoreController {
    private Store store = new Store();

    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;

    public final Store getStore() { return store; }

    private int getAmount() { return Integer.parseInt(amountTf.getText()); }
    private void setAmount(int amount) { amountTf.setText("" + amount); }

    private String getCash() { return store.getCashRegister().getCash(); }
    private void setCash(String text) { cashTxt.setText(text); }

    @FXML private void initialize() {
        amountTf.setText("0");
    }

    @FXML private void handleSell(ActionEvent event) {
        if (store.getProduct().has(getAmount())) {
            store.getProduct().sell(getAmount());
            setCash(getCash());
        }
        setAmount(0);
    }

}
