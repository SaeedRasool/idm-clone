
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
public class Table {

    JTable table;
    DefaultTableModel dtm;
    String st[] = new String[]{"ID", "File name", "Q", "Size", "Status", "Time Left", "Transfer rate",
        "Last Try Date", "Description", "Date Added", "Save To", "Referer"};

    public Table() {
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //table.setSurrendersFocusOnKeystroke(true);

        dtm = new DefaultTableModel(st, 0) {
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        
        
        
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(18);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(140);
        table.getColumnModel().getColumn(9).setPreferredWidth(75);
        table.getColumnModel().getColumn(10).setPreferredWidth(75);
        table.getColumnModel().getColumn(11).setPreferredWidth(75);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(20);
        table.setAutoCreateRowSorter(true);
        table.addColumnSelectionInterval(0, 11);
        
        table.setVisible(true);
    }
}
