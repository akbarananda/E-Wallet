import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TugasFrame extends MainFrame {
    private JButton button1, button2, button3, button4, button5;
    private JLabel hasilLabel;
    private int number;

    public TugasFrame(){
        super("Tugas", 415, 560);
        
    }
    
    protected void component(){

        hasilLabel = new JLabel();
        hasilLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setFontStyle(hasilLabel, Font.BOLD);
        setFontSize(hasilLabel, 30);
        boundedAdd(hasilLabel, 145, 44, 116, 102);

        button1 = new JButton("+1");
        boundedAdd(button1, 58, 209, 87, 71);

        button2 = new JButton("+3");
        boundedAdd(button2, 261, 209, 87, 71);

        button3 = new JButton("-1");
        boundedAdd(button3, 58, 341, 87, 71);

        button4 = new JButton("-3");
        boundedAdd(button4, 261, 341, 87, 71);

        button5 = new JButton("x2");
        boundedAdd(button5, 164, 448, 87, 71);
    }

    protected void event(){

        button1.addActionListener((event) -> {
            number += 1;

            String numStr = String.valueOf(number);
            hasilLabel.setText(numStr);
        });

        button2.addActionListener((event) -> {
            number += 3;

            String numStr = String.valueOf(number);
            hasilLabel.setText(numStr);
        });

        button3.addActionListener((event) -> {
            number -= 1;

            String numStr = String.valueOf(number);
            hasilLabel.setText(numStr);
        });

        button4.addActionListener((event) -> {
            number -= 3;

            String numStr = String.valueOf(number);
            hasilLabel.setText(numStr);
        });

        button5.addActionListener((event) -> {
            number *= 2;

            String numStr = String.valueOf(number);
            hasilLabel.setText(numStr);
        });
    }
}
