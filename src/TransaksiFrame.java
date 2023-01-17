import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;

import org.w3c.dom.events.MouseEvent;

import controler.Auth;
import entity.Dompet;
import entity.Transaksi;
import entity.User;

public class TransaksiFrame extends MainFrame {

    private JLabel transLabel;
    private JTable transtable;
    private JScrollPane scrollPane;
    private JTextField selectedField = new JTextField();

    public TransaksiFrame (){
        super("Transaksi", 415, 560);
    }
    
    public void component(){

        transLabel = new JLabel("Daftar Transaksi");
        setFontSize(transLabel, 15);
        setFontStyle(transLabel, Font.BOLD);
        boundedAdd(transLabel, 32, 35, 165, 20);

        transtable = new JTable();
        TableModel model = createTableModel();
        transtable.setModel(model);

        scrollPane = new JScrollPane(transtable);
        boundedAdd(scrollPane, 34, 78, 347, 420);
        
    }

    public void event(){

        transtable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = transtable.getSelectedRow();
                String selectedId = transtable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });
    }

    private TableModel createTableModel(){
        DefaultTableModel dataTable = new DefaultTableModel();

        Object[] column = {
            "Jenis Transaksi",
            "Tanggal Transaksi",
            "Nominal",
            "Total Bayar"
        };
        dataTable.setColumnIdentifiers(column);

        User akun = Auth.getUserLogged();
        Dompet dompet = akun.dompet;
        
        ArrayList<Transaksi> transaksiList = dompet.getDaftarTransaksi();
        
        for (Transaksi transaksi : transaksiList) {
            Object[] data = new String[] {
                transaksi.getJenisTransaksi(),
                transaksi.getTanggalTransaksi(),
                String.valueOf(transaksi.getNominalHarga()),
                String.valueOf(transaksi.getTotalBayar())

            };

            dataTable.addRow(data);
            
        }
        return dataTable;
    }
}
