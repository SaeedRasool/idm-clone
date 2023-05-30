
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class Tree {

    JTree tree;
    Node root;

    public Tree() {
        root = new Node();
        tree = new JTree((TreeNode)(root.root));
        TreeAction act = new TreeAction();
        tree.addTreeSelectionListener(act);
    }
}
