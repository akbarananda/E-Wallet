import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class VerifPinFrame extends MainFrame{
    private JLabel pinLabel;
    private JButton lanjutButton;

    public VerifPinFrame(){
        super("Verif PIN", 355, 260);
        component();
        event();
    }

    protected void component(){

        pinLabel = new JLabel("Masukan PIN");
        setFontSize(pinLabel, 20);
        setFontStyle(pinLabel, Font.BOLD);
        boundedAdd(pinLabel, 114, 42, 125, 27);

        lanjutButton = new JButton("Lanjut");
        setFontSize(lanjutButton, 14);
        setFontStyle(lanjutButton, Font.PLAIN);
        lanjutButton.setFocusable(false);
        boundedAdd(lanjutButton, 143, 188, 70, 25);


    }

    protected void event(){

        lanjutButton.addActionListener(e -> {
            new HomeFrame().setVisible(true);
            dispose();
        });
    }
}
