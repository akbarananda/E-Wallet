package view;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Utility.Rupiah;
import controler.Auth;

import entity.*;

public class HomeFrame extends MainFrame {
    private JLabel namaLabel, saldoLabel, selamatLabel, uangLabel;
    private JButton topUpButton, pulsaButton, transButton, refreshButton, logButton;
    private ImageIcon icon = new ImageIcon("topup.png");
    private ImageIcon icon2 = new ImageIcon("pulsa.png");
    private ImageIcon icon3 = new ImageIcon("transaksi.png");
    private ImageIcon refresh = new ImageIcon("refresh.png");

    public HomeFrame() {
        super("Home", 415, 560);
        // component();
        // event();
    }

    protected void component() {

        selamatLabel = new JLabel("Selamat Datang");
        setFontSize(selamatLabel, 20);
        setFontStyle(selamatLabel, Font.BOLD);
        boundedAdd(selamatLabel, 19, 26, 150, 27);

        namaLabel = new JLabel(Auth.getUserLogged().getNama());
        setFontSize(namaLabel, 15);
        setFontStyle(namaLabel, Font.PLAIN);
        boundedAdd(namaLabel, 46, 66, 50, 20);

        saldoLabel = new JLabel("Rp.");
        setFontSize(saldoLabel, 15);
        setFontStyle(saldoLabel, Font.PLAIN);
        boundedAdd(saldoLabel, 19, 122, 40, 20);

        uangLabel = new JLabel();
        setFontSize(uangLabel, 15);
        setFontStyle(uangLabel, Font.PLAIN);
        boundedAdd(uangLabel, 59, 122, 183, 21);

        topUpButton = new JButton();
        topUpButton.setIcon(icon);
        topUpButton.setFocusable(false);
        topUpButton.setText("Top Up");
        topUpButton.setHorizontalTextPosition(JButton.CENTER);
        topUpButton.setVerticalTextPosition(JButton.BOTTOM);
        setFontSize(topUpButton, 10);
        setFontStyle(topUpButton, Font.BOLD);
        boundedAdd(topUpButton, 46, 209, 75, 75);

        pulsaButton = new JButton();
        pulsaButton.setIcon(icon2);
        pulsaButton.setFocusable(false);
        pulsaButton.setText("Pulsa");
        pulsaButton.setHorizontalTextPosition(JButton.CENTER);
        pulsaButton.setVerticalTextPosition(JButton.BOTTOM);
        setFontSize(pulsaButton, 10);
        setFontStyle(pulsaButton, Font.BOLD);
        boundedAdd(pulsaButton, 172, 209, 75, 75);

        transButton = new JButton();
        transButton.setIcon(icon3);
        transButton.setFocusable(false);
        transButton.setText("Transaksi");
        transButton.setHorizontalTextPosition(JButton.CENTER);
        transButton.setVerticalTextPosition(JButton.BOTTOM);
        setFontSize(transButton, 10);
        setFontStyle(transButton, Font.BOLD);
        boundedAdd(transButton, 298, 209, 75, 75);

        refreshButton = new JButton();
        refreshButton.setIcon(refresh);
        refreshButton.setBackground(color("#F0F0F0"));
        refreshButton.setForeground(color("#003A5A"));
        refreshButton.setFocusable(false);
        refreshButton.setFocusPainted(false);
        refreshButton.setBorderPainted(false);
        boundedAdd(refreshButton, 339, 117, 29, 30);

        logButton = new JButton("Logout");
        logButton.setFocusable(false);
        boundedAdd(logButton, 299, 509, 91, 29);
    }

    protected void event() {

        User akun = Auth.getUserLogged();

        topUpButton.addActionListener(e -> {
            new TopupFrame().setVisible(true);
        });

        refreshButton.addActionListener(e -> {

            int saldo = akun.dompet.getSaldo().getSaldo();

            String numStr = Rupiah.format(saldo);
            uangLabel.setText(numStr);
        });

        pulsaButton.addActionListener(e -> {
            new PulsaFrame().setVisible(true);
            dispose();
        });

        transButton.addActionListener(e -> {
            new TransaksiFrame().setVisible(true);
        });

        logButton.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });

    }

}
