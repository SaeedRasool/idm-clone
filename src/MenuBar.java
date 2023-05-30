
import javax.swing.JMenuBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class MenuBar {

    JMenuBar menu;
    Menu m;

    public MenuBar() {
        menu = new JMenuBar();
        m = new Menu();
        menu.add(m.tasks);
        menu.add(m.file);
        menu.add(m.download);
        menu.add(m.view);
        menu.add(m.help);
        menu.add(m.reg);
        menu.setVisible(true);

    }
}
