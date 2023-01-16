package entity;

import entity.Transaksi;

//class entitas
public class TopUp extends Transaksi {

    public TopUp(int nominalTopup) {
        super("Top Up", nominalTopup, nominalTopup);
    }

}