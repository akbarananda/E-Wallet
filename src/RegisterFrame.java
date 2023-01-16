import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controler.Auth;
import entity.User;

import java.awt.Font;

public class RegisterFrame extends MainFrame {

    private JLabel namaLabel, userLabel, noTelpLabel, passLabel, pinLabel, daftarLabel;
    private JTextField namaField, userField, noTelpField, passField, pinField;
    private JButton daftarButton;

    public RegisterFrame(){
        super("Register", 400, 400);
        component();
        event();
    }

    protected void component(){

        namaLabel = new JLabel("Nama");
        setFontSize(namaLabel, 15);
        setFontStyle(namaLabel, Font.PLAIN);
        boundedAdd(namaLabel, 33, 47, 43, 21);

        namaField = new JTextField();
        boundedAdd(namaField, 145, 44, 217, 28);

        userLabel = new JLabel("Username");
        setFontSize(userLabel, 15);
        setFontStyle(userLabel, Font.PLAIN);
        boundedAdd(userLabel, 34, 90, 72, 21);

        userField = new JTextField();
        boundedAdd(userField, 145, 83, 217, 28);

        noTelpLabel = new JLabel("No Telp");
        setFontSize(noTelpLabel, 15);
        setFontStyle(noTelpLabel, Font.PLAIN);
        boundedAdd(noTelpLabel, 33, 132, 73, 21);

        noTelpField = new JTextField();
        boundedAdd(noTelpField, 145, 125, 217, 28);

        passLabel = new JLabel("Password");
        setFontSize(passLabel, 15);
        setFontStyle(passLabel, Font.PLAIN);
        boundedAdd(passLabel, 34, 170, 67, 21);

        passField = new JTextField();
        boundedAdd(passField, 145, 167, 217, 28);

        pinLabel = new JLabel("PIN");
        setFontSize(pinLabel, 15);
        setFontStyle(pinLabel, Font.PLAIN);
        boundedAdd(pinLabel, 34, 211, 26, 21);

        pinField = new JTextField();
        boundedAdd(pinField, 145, 208, 217, 28);

        daftarButton = new JButton("Daftar");
        boundedAdd(daftarButton, 252, 291, 84, 25);
    }

    protected void event(){
        
        daftarButton.addActionListener(e -> {
            String nama = namaField.getText();
            String username = userField.getText();
            String noTelp = noTelpField.getText();
            String password = passField.getText();
            String pin = pinField.getText();
            User akunBaru = new User(nama, username, noTelp, password, pin);

            if (Auth.register(akunBaru)) {
                new LoginFrame().setVisible(true);
                dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Akun sudah pernah dibuat !");
            }
        });

    }
    
}
