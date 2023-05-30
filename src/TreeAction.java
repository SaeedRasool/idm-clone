
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class TreeAction implements TreeSelectionListener{
    public TreeAction() {
        
    }

    
    public void TableValueChanged(TreeSelectionEvent tse) {
        System.out.println(tse.getNewLeadSelectionPath().toString());
        String node = tse.getNewLeadSelectionPath().toString();
        if (node.equals("[Categories, All Downloads]")) {
            
        }
        if (node.equals("[Categories, All Downloads, Compressed]")) {
            
        }
        if (node.equals("[Categories, All Downloads, Documents]")) {
            
        }
        if (node.equals("[Categories, All Downloads, Music]")) {
            
        }
        if (node.equals("[Categories, All Downloads, Programs]")) {
            
        }
        if (node.equals("[Categories, All Downloads, Videos]")) {
            
        }
        if (node.equals("[Categories, Unfinished]")) {
            
        }
        if (node.equals("[Categories, Unfinished, Compressed]")) {
            
        }
        if (node.equals("[Categories, Unfinished, Documents]")) {
            
        }
        if (node.equals("[Categories, Unfinished, Music]")) {
            
        }
        if (node.equals("[Categories, Unfinished, Programs]")) {
            
        }
        if (node.equals("[Categories, Unfinished, Videos]")) {
            
        }
        if (node.equals("[Categories, Finished]")) {
            
        }
        if (node.equals("[Categories, Finished, Compressed]")) {
            
        }
        if (node.equals("[Categories, Finished, Documents]")) {
            
        }
        if (node.equals("[Categories, Finished, Music]")) {
            
        }
        if (node.equals("[Categories, Finished, Programs]")) {
            
        }
        if (node.equals("[Categories, Finished, Videos]")) {
            
        }
        if (node.equals("[Categories, Grabber Projects]")) {
            
        }
        if (node.equals("[Categories, Queues]")) {
            
        }
        if (node.equals("[Categories, Queues, Main Download Queue]")) {
            
        }
        if (node.equals("[Categories, Queues, Synchronization Queue]")) {
            
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TableValueChanged(e);
    }
}