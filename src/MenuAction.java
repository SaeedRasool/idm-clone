
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class MenuAction implements ActionListener {

    //MenuItems ref;
    ToolAction t;

    public MenuAction(MenuItems ref) {
        //this.ref = ref;
        t = new ToolAction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        }
        if (e.getActionCommand().equalsIgnoreCase("Add New Download")) {
            System.out.println("Hahah");
            t.uRLAction.actionPerformed(e);

        }
    }

}
