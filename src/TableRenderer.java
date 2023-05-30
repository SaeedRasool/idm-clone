
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class TableRenderer {

    public static int row = 0;

    public TableRenderer(String fName, String Q, String size, String status, Date timeLeft, int tRate, String lTDate, String discription, Date dateAdded, String saveTo, String reference) {
        MainFrame.table.dtm.insertRow(MainFrame.table.dtm.getRowCount(), new Object[]{null,null,null,null,null,null,null,null,null,null,null,null});
        MainFrame.table.table.getModel().setValueAt(row + 1, row, 0);
        MainFrame.table.table.getModel().setValueAt(fName, row, 1);
        MainFrame.table.table.getModel().setValueAt(Q, row, 2);
        MainFrame.table.table.getModel().setValueAt(size, row, 3);
        MainFrame.table.table.getModel().setValueAt(status, row, 4);
        MainFrame.table.table.getModel().setValueAt(timeLeft, row, 5);
        if (tRate > 0) {
            MainFrame.table.table.getModel().setValueAt(tRate, row, 6);
        } else {
            MainFrame.table.table.getModel().setValueAt("", row, 6);
        }
        MainFrame.table.table.getModel().setValueAt(lTDate, row, 7);
        MainFrame.table.table.getModel().setValueAt(discription, row, 8);
        MainFrame.table.table.getModel().setValueAt(dateAdded, row, 9);
        MainFrame.table.table.getModel().setValueAt(saveTo, row, 10);
        MainFrame.table.table.getModel().setValueAt(reference, row, 11);
        row = row + 1;

    }
}
