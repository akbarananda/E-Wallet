import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PulsaFrame extends MainFrame{

    private JLabel titleLabel,voc1Label,voc2Label,voc3Label,voc4Label,voc5Label;
    private JButton bayarButton;
    private JRadioButton pil1Button, pil2Button, pil3Button, pil4Button, pil5Button;
    private ButtonGroup group = new ButtonGroup();

    public PulsaFrame(){
        super("Pulsa", 415, 560);
        component();
        event();
    }
    
    public void component(){

        titleLabel = new JLabel("Silahkan Pilih Voucher");
        setFontSize(titleLabel, 20);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 35, 45, 241, 27);

        voc1Label = new JLabel("Voucher Pulsa Senilai 5.000");
        setFontSize(voc1Label, 15);
        setFontStyle(voc1Label, Font.BOLD);
        boundedAdd(voc1Label, 99, 112, 270, 35);

        pil1Button = new JRadioButton();
        group.add(pil1Button);
        boundedAdd(pil1Button, 35, 116, 29 , 28);
        
        voc2Label = new JLabel("Voucher Pulsa Senilai 10.000");
        setFontSize(voc2Label, 15);
        setFontStyle(voc2Label, Font.BOLD);
        boundedAdd(voc2Label, 99, 178, 270, 35);

        pil2Button = new JRadioButton();
        group.add(pil2Button);
        boundedAdd(pil2Button, 35, 182, 29 , 28);

        voc3Label = new JLabel("Voucher Pulsa Senilai 20.000");
        setFontSize(voc3Label, 15);
        setFontStyle(voc3Label, Font.BOLD);
        boundedAdd(voc3Label, 99, 244, 270, 35);

        pil3Button = new JRadioButton();
        group.add(pil3Button);
        boundedAdd(pil3Button, 35, 248, 29 , 28);

        voc4Label = new JLabel("Voucher Pulsa Senilai 25.000");
        setFontSize(voc4Label, 15);
        setFontStyle(voc4Label, Font.BOLD);
        boundedAdd(voc4Label, 99, 310, 270, 35);

        pil4Button = new JRadioButton();
        group.add(pil4Button);
        boundedAdd(pil4Button, 35, 314, 29 , 28);

        voc5Label = new JLabel("Voucher Pulsa Senilai 50.000");
        setFontSize(voc5Label, 15);
        setFontStyle(voc5Label, Font.BOLD);
        boundedAdd(voc5Label, 99, 376, 270, 35);

        pil5Button = new JRadioButton();
        group.add(pil5Button);
        boundedAdd(pil5Button, 35, 380, 29 , 28);

        bayarButton = new JButton();
        bayarButton.setFocusable(false);
        bayarButton.setText("Bayar");
        bayarButton.setHorizontalTextPosition(JButton.CENTER);
        bayarButton.setVerticalTextPosition(JButton.BOTTOM);
        setFontSize(bayarButton, 10);
        setFontStyle(bayarButton, Font.BOLD);
        boundedAdd(bayarButton, 240, 480, 93 , 32);
    }

    public void event(){

        bayarButton.addActionListener(e -> {
            new HomeFrame().setVisible(true);
            dispose();
        });
    }
}
