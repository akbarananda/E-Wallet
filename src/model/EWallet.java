package model;

import entity.TopUp;
import entity.Transaksi;
import entity.User;
import controler.Auth;

import java.util.ArrayList;

//class core
public class EWallet {
    private static ArrayList<User> akunTerdaftar = new ArrayList<>();

    public static void initialUser() {
        User user = new User("Test", "user", "1", "081", "123");

        Auth.register(user);

    }

    public static int cekSaldo(User user) {
        return user.dompet.getSaldo().getSaldo();
    }

    public static void topUp(User user, TopUp transaksi) {
        user.dompet.tambahTransaksi(transaksi);
        user.dompet.getSaldo().tambahSaldo(transaksi.getNominalHarga());
    }

    public static boolean beliPulsa(User user, Transaksi transaksi) {
        boolean status = user.dompet.getSaldo().ambilSaldo(transaksi.getNominalHarga());
        if (status) {
            user.dompet.tambahTransaksi(transaksi);
        }
        return status;
    }

    public static ArrayList<User> getAkunTerdaftar() {
        return akunTerdaftar;
    }

}