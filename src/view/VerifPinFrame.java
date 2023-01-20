package view;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import controler.Auth;
import entity.User;

public class VerifPinFrame extends MainFrame{
    private JLabel pinLabel;
    private JTextField pinField;
    private JButton lanjutButton;
    private String pin;

    public VerifPinFrame(){
        super("Verif PIN", 355, 260);
        // component();
        // event();
    }

    protected void component(){

        pinLabel = new JLabel("Masukan PIN");
        setFontSize(pinLabel, 20);
        setFontStyle(pinLabel, Font.BOLD);
        boundedAdd(pinLabel, 114, 42, 125, 27);

        pinField = new JTextField();
        boundedAdd(pinField, 136, 98, 83, 40);

        lanjutButton = new JButton("Lanjut");
        setFontSize(lanjutButton, 14);
        setFontStyle(lanjutButton, Font.PLAIN);
        lanjutButton.setFocusable(false);
        boundedAdd(lanjutButton, 143, 188, 70, 25);


    }

    protected void event(){

        lanjutButton.addActionListener(e -> {
           
            
            if (Auth.verifPin(pinField.getText())) {
                new HomeFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "PIN Yang Anda Masukan Salah !",
                        "PIN Salah",
                        JOptionPane.ERROR_MESSAGE);
                        new LoginFrame().setVisible(true);
                        dispose();
            }
        });
    }
}
