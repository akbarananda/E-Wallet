package view;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.*;
import controler.*;
import entity.*;

public class TopupFrame extends MainFrame{
    private JLabel masukanLabel;
    private JTextField masukanField;
    private JButton tambahButton;
    
    public TopupFrame(){
        super("TopupFrame", 310, 200);
        // component();
        // event();
    }

    protected void component(){

        masukanLabel = new JLabel("Masukan Jumlah");
        setFontSize(masukanLabel, 15);
        setFontStyle(masukanLabel, Font.BOLD);
        boundedAdd(masukanLabel, 25, 28, 120, 20);
    
        masukanField = new JTextField();
        boundedAdd(masukanField, 29, 70, 240, 30);

        tambahButton = new JButton("Tambah");
        setFontSize(tambahButton, 10);
        setFontStyle(tambahButton, Font.BOLD);
        tambahButton.setFocusable(false);
        boundedAdd(tambahButton, 192, 145, 70, 30);


    }

    protected void event(){

        tambahButton.addActionListener(e -> {            
            User akun = Auth.getUserLogged();
            int nominal = Integer.parseInt(masukanField.getText());
            
            

            if (nominal >= 10000) {
                TopUp topUp = new TopUp(nominal);
                EWallet.topUp(akun, topUp);
                
            } else {
                JOptionPane.showMessageDialog(null,
                        "Mininal top up harus diatas Rp.10.000",
                        "TopUp Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });
    }
}
