import controler.LoginPage;
import model.EWallet;
import model.Storage;
import view.LoginFrame;


public class App {
    public static void main(String[] args) {

        Storage.setInitialItem();
        EWallet.initialUser();

        
        new LoginFrame().setVisible(true);
        // new HomeFrame().setVisible(true);
        // new TugasFrame().setVisible(true);

    }
}
