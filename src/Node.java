
import javax.swing.tree.DefaultMutableTreeNode;
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
public class Node {

    DefaultMutableTreeNode root;
    DefaultMutableTreeNode all;
    DefaultMutableTreeNode unFinished;
    DefaultMutableTreeNode finished;

    TreeNode allComp;
    TreeNode allDoc;
    TreeNode allMusic;
    TreeNode allProg;
    TreeNode allVid;

    TreeNode unComp;
    TreeNode unDoc;
    TreeNode unMusic;
    TreeNode unProg;
    TreeNode unVid;

    TreeNode fComp;
    TreeNode fDoc;
    TreeNode fMusic;
    TreeNode fProg;
    TreeNode fVid;

    TreeNode grabberPro;
    DefaultMutableTreeNode CQueues;

    TreeNode mQueues;
    TreeNode sQueues;

    public Node() {
        all = new DefaultMutableTreeNode("All Downloads");

        allComp = new DefaultMutableTreeNode("Compressed");
        allDoc = new DefaultMutableTreeNode("Documents");
        allMusic = new DefaultMutableTreeNode("Music");
        allProg = new DefaultMutableTreeNode("Programs");
        allVid = new DefaultMutableTreeNode("Videos");

        unComp = new DefaultMutableTreeNode("Compressed");
        unDoc = new DefaultMutableTreeNode("Documents");
        unMusic = new DefaultMutableTreeNode("Music");
        unProg = new DefaultMutableTreeNode("Programs");
        unVid = new DefaultMutableTreeNode("Videos");

        fComp = new DefaultMutableTreeNode("Compressed");
        fDoc = new DefaultMutableTreeNode("Documents");
        fMusic = new DefaultMutableTreeNode("Music");
        fProg = new DefaultMutableTreeNode("Programs");
        fVid = new DefaultMutableTreeNode("Videos");

        all.add((DefaultMutableTreeNode)allComp);
        all.add((DefaultMutableTreeNode)allDoc);
        all.add((DefaultMutableTreeNode)allMusic);
        all.add((DefaultMutableTreeNode)allProg);
        all.add((DefaultMutableTreeNode)allVid);

        unFinished = new DefaultMutableTreeNode("Unfinished");

        unFinished.add((DefaultMutableTreeNode)unComp);
        unFinished.add((DefaultMutableTreeNode)unDoc);
        unFinished.add((DefaultMutableTreeNode)unMusic);
        unFinished.add((DefaultMutableTreeNode)unProg);
        unFinished.add((DefaultMutableTreeNode)unVid);

        finished = new DefaultMutableTreeNode("Finished");

        finished.add((DefaultMutableTreeNode)fComp);
        finished.add((DefaultMutableTreeNode)fDoc);
        finished.add((DefaultMutableTreeNode)fMusic);
        finished.add((DefaultMutableTreeNode)fProg);
        finished.add((DefaultMutableTreeNode)fVid);
        root = new DefaultMutableTreeNode("Categories");

        grabberPro = new DefaultMutableTreeNode("Grabber Projects");

        CQueues = new DefaultMutableTreeNode("Queues");
        mQueues = new DefaultMutableTreeNode("Main Download Queue");
        sQueues = new DefaultMutableTreeNode("Synchronization Queue");

        CQueues.add((DefaultMutableTreeNode)mQueues);
        CQueues.add((DefaultMutableTreeNode)sQueues);
        root.add((DefaultMutableTreeNode)all);
        root.add((DefaultMutableTreeNode)unFinished);
        root.add((DefaultMutableTreeNode)finished);
        root.add((DefaultMutableTreeNode)grabberPro);
        root.add((DefaultMutableTreeNode)CQueues);
    }
}
