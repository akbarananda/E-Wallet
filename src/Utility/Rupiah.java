package Utility;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Rupiah {
    public static String format(int harga){
        DecimalFormat rupiah = new DecimalFormat();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setGroupingSeparator('.');
        rupiah.setDecimalFormatSymbols(formatRp);

        return rupiah.format(harga);
    }
}
