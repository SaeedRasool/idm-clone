
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
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
public class ProgressMonitor implements PropertyChangeListener {

    JLabel labelURL;
    JTextField fieldURL;
    FileChooser file;
    JButton buttonDownload;
    JButton buttonPause;
    JButton buttonCancel;
    JLabel labelFileName;
    JTextField fieldFileName;
    JLabel labelFileSize;
    JTextField fieldFileSize;
    JLabel labelProgress;
    JProgressBar progressBar;
    JFrame fr;
    int progress;
    Download d;

    public ProgressMonitor() {
        fr = new JFrame("Download File Info");
        labelURL = new JLabel("Download URL: ");
        fieldURL = new JTextField(30);
        fieldURL.setEditable(false);
        file = new FileChooser("Save As", "...");
        buttonDownload = new JButton("Download");
        buttonPause = new JButton("Pause");
        buttonCancel = new JButton("Cancel");
        labelFileName = new JLabel("File name: ");
        fieldFileName = new JTextField(20);
        labelFileSize = new JLabel("File size (MB): ");
        fieldFileSize = new JTextField(20);
        labelProgress = new JLabel("Progress:");
        progressBar = new JProgressBar(0, 100);
        fr.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        file.mode = FileChooser.MODE_SAVE;
        file.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        buttonDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonDownloadActionPerformed(event);
            }
        });
        buttonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPauseActionPerformed(e);
            }
        });
        
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCancelActionPerformed(e);
            }
        });
        buttonPause.setVisible(false);
        buttonCancel.setVisible(false);
        fieldFileName.setEditable(false);
        fieldFileSize.setEditable(false);
        progressBar.setPreferredSize(new Dimension(200, 30));
        progressBar.setStringPainted(true);
        constraints.gridx = 0;
        constraints.gridy = 0;

        fr.add(labelURL, constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        fr.add(fieldURL, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        fr.add(file.pane, constraints);

        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        fr.add(buttonDownload, constraints);

        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        fr.add(buttonPause, constraints);

        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        fr.add(buttonCancel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        fr.add(labelFileName, constraints);

        constraints.gridx = 1;
        fr.add(fieldFileName, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        fr.add(labelFileSize, constraints);

        constraints.gridx = 1;
        fr.add(fieldFileSize, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        fr.add(labelProgress, constraints);

        constraints.gridx = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        fr.add(progressBar, constraints);
        fr.pack();
        fr.setLocationRelativeTo(null);
    }

    void buttonDownloadActionPerformed(ActionEvent event) {
        String downloadURL = fieldURL.getText();
        String saveDir = file.textField.getText();
        if (saveDir.equals("")) {
            JOptionPane.showMessageDialog(fr, "Please choose a directory save file!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            progressBar.setValue(0);
            //Downloader down= new Downloader(new URL(downloadURL), saveDir, 1);
            d = new Download(downloadURL, saveDir, ProgressMonitor.this);
            d.addPropertyChangeListener(this);
            d.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fr, "Error executing upload task: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void buttonPauseActionPerformed(ActionEvent event) {
        try {
            d.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgressMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void buttonCancelActionPerformed(ActionEvent event) {
        d.cancel(true);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("progress")) {
            int progres = (int) evt.getNewValue();
            progressBar.setValue(progres);
        }
    }
}
