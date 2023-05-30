
import javax.swing.JInternalFrame;
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
public class InternalFrame {

    JInternalFrame inFrame;
    Tree tree;

    public InternalFrame() {
        tree = new Tree();
        inFrame = new JInternalFrame("Categories", true, true, false, false);
        inFrame.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 2));
        inFrame.setVisible(true);
        
        inFrame.add(new JScrollPane(tree.tree));
        inFrame.setResizable(true);
    }
}
