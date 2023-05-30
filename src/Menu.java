
import javax.swing.JMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class Menu {

    JMenu tasks;
    JMenu exp;
    JMenu imp;

    MenuItems task;

    JMenu file;
    JMenu download;
    JMenu view;
    JMenu help;
    JMenu reg;


    public Menu() {
        tasks = new JMenu("Tasks");
        task = new MenuItems();
        exp = new JMenu("Export");
        imp = new JMenu("Import");

        tasks.add(task.nDownload);
        tasks.add(task.bDownload);
        tasks.add(task.bcDownload);
        tasks.add(task.sGrabber);
        tasks.add(task.dTarget);

        tasks.add(exp);
        exp.add(task.toIDM);
        exp.add(task.toTxt);

        tasks.add(imp);
        imp.add(task.fIDM);
        imp.add(task.fTxt);

        tasks.add(task.exit);

        file = new JMenu("File");

        file.add(task.sDownload);
        file.add(task.remove);
        file.add(task.dNow);
        file.add(task.reDownload);

        download = new JMenu("Download");
        view = new JMenu("View");
        help = new JMenu("Help");
        reg = new JMenu("Registration");

    }

}
