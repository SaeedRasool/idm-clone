
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class MainFrame {

    JFrame mainFrame;
    ToolBar bar;
    InternalFrame inFrame;
    public static Table table;
    MenuBar menu;
    JPanel pane;

    public MainFrame() {
        init();
    }

    void init() {

        table = new Table();
        bar = new ToolBar();
        mainFrame = new JFrame("Internet Download Manager");
        inFrame = new InternalFrame();
        menu = new MenuBar();

        pane = new JPanel(new BorderLayout());
        pane.add(menu.menu, BorderLayout.NORTH);
        pane.add(bar.toolBar, BorderLayout.CENTER);

        mainFrame.add(pane, BorderLayout.NORTH);
        mainFrame.add(inFrame.inFrame, BorderLayout.WEST);
        mainFrame.add(new JScrollPane(table.table), BorderLayout.CENTER);

        mainFrame.setSize(870, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);
    }
}
