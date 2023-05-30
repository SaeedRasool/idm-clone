
import java.awt.ComponentOrientation;
import javax.swing.Box;
import javax.swing.JToolBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class ToolBar {

    JToolBar toolBar;
    ToolAction action;

    public ToolBar() {
        action = new ToolAction();
        toolBar = new JToolBar();
        toolBar.add(Box.createHorizontalGlue());
        toolBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //toolBar.setBorder(null);
        //toolBar.setBorderPainted(false);
        toolBar.add(action.friendAction);
        toolBar.add(action.grabAction);
        toolBar.add(action.stQAction);
        toolBar.add(action.sQAction);
        toolBar.add(action.schAction);
        toolBar.add(action.optAction);
        toolBar.add(action.delComAction);
        toolBar.add(action.deleteAction);
        toolBar.add(action.stopAllAction);
        toolBar.add(action.stopAction);
        toolBar.add(action.resumeAction);
        toolBar.add(action.uRLAction);
        toolBar.setIgnoreRepaint(false);
        toolBar.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
}
