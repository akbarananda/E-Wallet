import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controler.Auth;

import java.awt.Font;

public class LoginFrame extends MainFrame {
    private JLabel userLabel, passLabel, logoLabel, registLabel;
    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JButton loginButton, registButton;
    private ImageIcon logo = new ImageIcon("logo.png");

    public LoginFrame(){
        super("Login",415, 560);
        // component();
        // event();
    }

    protected void component(){

            logoLabel = new JLabel();
            logoLabel.setText("My-Wallet");
            logoLabel.setIcon(logo);
            setFontSize(logoLabel, 20);
            setFontStyle(logoLabel, Font.BOLD);
            logoLabel.setHorizontalTextPosition(JLabel.CENTER);
            logoLabel.setVerticalTextPosition(JLabel.BOTTOM);
            boundedAdd(logoLabel, 140, 30, 200, 200);

            userLabel = new JLabel("Username");
            setFontSize(userLabel, 15);
            setFontStyle(userLabel, Font.BOLD);
            boundedAdd(userLabel, 41, 245, 67, 20);

            UsernameField = new JTextField();
            boundedAdd(UsernameField, 41, 270, 334, 38);

            passLabel = new JLabel("Password");
            setFontSize(passLabel, 15);
            setFontStyle(passLabel, Font.PLAIN);
            boundedAdd(passLabel, 41, 320, 62, 20);

            PasswordField = new JPasswordField();
            boundedAdd(PasswordField, 41, 345, 334, 38);

            registLabel = new JLabel("Belum punya account?");
            setFontSize(registLabel, 13);
            setFontStyle(registLabel, Font.PLAIN);
            boundedAdd(registLabel, 160, 410, 150, 20);

            loginButton = new JButton("Login");
            loginButton.setBackground(color("#00D4FF"));
            loginButton.setForeground(color("#FFFFFF"));
            loginButton.setFocusPainted(false);
            boundedAdd(loginButton, 165, 480, 85, 30);

            registButton = new JButton("Daftar");
            registButton.setBackground(color("#F0F0F0"));
            registButton.setForeground(color("#003A5A"));
            setFontSize(registButton, 10);
            setFontStyle(registButton, Font.BOLD);
            registButton.setFocusPainted(false);
            registButton.setBorderPainted(false);
            boundedAdd(registButton, 310, 405, 65, 30);
            
    }

    protected void event(){

        loginButton.addActionListener(e -> {
            String username = UsernameField.getText();
            String password = String.valueOf(PasswordField.getPassword());

            if(Auth.login(username, password)){
                new VerifPinFrame().setVisible(true);
                dispose();
            } else{
                JOptionPane.showMessageDialog(null,
                        "Username atau Password Salah",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }
            
        });

        registButton.addActionListener(e -> {
            new RegisterFrame().setVisible(true);
            dispose();
        });
    }

}
