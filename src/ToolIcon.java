
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class ToolIcon {

    ImageIcon uRLIcon;
    ImageIcon resumeIcon;
    ImageIcon stopIcon;
    ImageIcon stopAllIcon;
    ImageIcon deleteIcon;
    ImageIcon delComIcon;
    ImageIcon optIcon;
    ImageIcon schIcon;
    ImageIcon sQIcon;
    ImageIcon stQIcon;
    ImageIcon grabIcon;
    ImageIcon friendIcon;

    public ToolIcon() {
        uRLIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\URL.jpg"));
        resumeIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Resume.jpg"));
        stopIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Stop.jpg"));
        stopAllIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\StopAll.jpg"));
        deleteIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Delete.jpg"));
        delComIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\DeleteAll.jpg"));
        optIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Option.jpg"));
        schIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Schedular.jpg"));
        sQIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\StartQueue.jpg"));
        stQIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\StopQueue.jpg"));
        grabIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Grabber.jpg"));
        friendIcon = new ImageIcon(ToolIcon.class.getResource("Icons\\Friend.jpg"));
    }
}
