
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class ToolAction {

    ToolIcon icon;

    Action uRLAction;
    Action resumeAction;
    Action stopAction;
    Action stopAllAction;
    Action deleteAction;
    Action delComAction;
    Action optAction;
    Action schAction;
    Action sQAction;
    Action stQAction;
    Action grabAction;
    Action friendAction;
    String uRL;
    String userName;
    String passWord;

    public ToolAction() {

        icon = new ToolIcon();
        uRLAction = new AbstractAction("URL", icon.uRLIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = new JCheckBox();

                JLabel ur = new JLabel(" URL Address : ");
                JLabel un = new JLabel(" Username : ");
                JLabel pw = new JLabel(" Password : ");
                JLabel cb = new JLabel(" Use Authorization ");
                JTextField URLf = new JTextField("", 20);

                JTextField username = new JTextField("");
                JTextField password = new JPasswordField("", 10);

                username.setEnabled(false);
                password.setEnabled(false);
                pw.setEnabled(false);
                un.setEnabled(false);

                JPanel pane = new JPanel();
                pane.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();

                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 0;

                pane.add(ur, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.gridwidth = 6;
                //gbc.gridwidth = 2;

                pane.add(URLf, gbc);

                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.ipady = 20;

                pane.add(checkBox, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.ipady = 1;

                pane.add(cb, gbc);

                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 2;

                pane.add(un, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;

                pane.add(username, gbc);

                gbc.gridx = 3;
                gbc.gridy = 2;
                gbc.weightx = 1.5;
                //gbc.fill = GridBagConstraints.HORIZONTAL;  

                pane.add(pw, gbc);

                gbc.gridx = 4;
                gbc.gridy = 2;

                pane.add(password, gbc);

                checkBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            username.setEnabled(true);
                            password.setEnabled(true);
                            pw.setEnabled(true);
                            un.setEnabled(true);
                        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                            username.setEnabled(false);
                            password.setEnabled(false);
                            pw.setEnabled(false);
                            un.setEnabled(false);
                        }

                        pane.validate();
                        pane.repaint();
                    }
                });

                int option = JOptionPane.showConfirmDialog(null, pane, "Enter New Address To Download", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    if (URLf.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter download URL!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Thread t;
                        t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ProgressMonitor prog = new ProgressMonitor();
                                prog.fieldURL.setText(URLf.getText());
                                prog.fr.setVisible(true);
                            }
                        });
                        t.start();
                    }
                } else {
                }
            }
        };
        resumeAction = new AbstractAction("Resume", icon.resumeIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Resume");
            }
        };
        resumeAction.setEnabled(false);
        stopAction = new AbstractAction("Stop", icon.stopIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open File");
            }
        };
        stopAction.setEnabled(false);
        stopAllAction = new AbstractAction("StopAll", icon.stopAllIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open File");
            }
        };
        stopAllAction.setEnabled(false);
        deleteAction = new AbstractAction("Delete", icon.deleteIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open File");
            }
        };
        deleteAction.setEnabled(false);
        delComAction = new AbstractAction("DelCom", icon.delComIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are You Sure you want to delete all completed Downloads from IDM list of Downloads?", "Confirm Deletion Of Downloads", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    TableRenderer.row = 0;
                    int i = 0;
                    while (MainFrame.table.table.getRowCount() > i) {
                        new TableRenderer(null, null, null, null, null, 0, null, null, null, null, null);
                        i++;
                    }
                    TableRenderer.row = 0;
                } else {
                }
            }
        };
        optAction = new AbstractAction("Option", icon.optIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This Option is under Development! You can only use Default Options", "Options", JOptionPane.OK_OPTION);
            }
        };
        schAction = new AbstractAction("Schedular", icon.schIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This Option is under Development!", "Schedular", JOptionPane.OK_OPTION);
            }
        };
        sQAction = new AbstractAction("StartQueue", icon.sQIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This Option is under Development!", "Start Queue", JOptionPane.OK_OPTION);
            }
        };
        stQAction = new AbstractAction("StopQueue", icon.stQIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This Option is under Development!", "Stop Queue", JOptionPane.OK_OPTION);
            }
        };
        grabAction = new AbstractAction("Grabber", icon.grabIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This Option is under Development!", "Grabber Project", JOptionPane.OK_OPTION);
            }
        };
        friendAction = new AbstractAction("Friend", icon.friendIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI("https://www.facebook.com/saeed.rasool.714"));
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(ToolAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }
}
