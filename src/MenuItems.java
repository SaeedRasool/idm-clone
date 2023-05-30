
import javax.swing.JMenuItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class MenuItems {

    JMenuItem nDownload;
    JMenuItem bDownload;
    JMenuItem bcDownload;
    JMenuItem sGrabber;
    JMenuItem dTarget;
    JMenuItem exit;
    JMenuItem toIDM;
    JMenuItem toTxt;
    JMenuItem fIDM;
    JMenuItem fTxt;

    JMenuItem sDownload;
    JMenuItem remove;
    JMenuItem dNow;
    JMenuItem reDownload;

    MenuAction m;

    public MenuItems() {
        m = new MenuAction(this);
        nDownload = new JMenuItem("Add New Download");
        nDownload.addActionListener(m);

        bDownload = new JMenuItem("Add Batch Download");
        bcDownload = new JMenuItem("Add Batch Download From ClipBoard");
        sGrabber = new JMenuItem("Run Site Grabber");
        dTarget = new JMenuItem("Show Dropdown Target");
        exit = new JMenuItem("Exit");
        exit.addActionListener(m);

        toIDM = new JMenuItem("To IDM Export File");
        toTxt = new JMenuItem("To Text File");
        fIDM = new JMenuItem("From IDM Export File");
        fTxt = new JMenuItem("From Text File");

        sDownload = new JMenuItem("Stop Download");
        sDownload.setEnabled(false);
        remove = new JMenuItem("Remove");
        remove.setEnabled(false);
        dNow = new JMenuItem("Download Now");
        dNow.setEnabled(false);
        reDownload = new JMenuItem("Redownload");
        reDownload.setEnabled(false);
    }
}
