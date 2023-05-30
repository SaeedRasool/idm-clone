
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saeed
 */
public class Driver {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        System.out.println("Testing Driver Class For IDM Project.");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MainFrame frame = new MainFrame();
    }
}
