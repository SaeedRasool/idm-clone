
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class FileChooser {

    String textFieldLabel;
    String buttonLabel;
    JLabel label;
    JTextField textField;
    JButton button;
    JFileChooser fileChooser;
    int mode;
    public static int MODE_OPEN = 1;
    public static int MODE_SAVE = 2;

    JPanel pane;

    public FileChooser(String textFieldLabel, String buttonLabel) {
        pane = new JPanel();
        this.textFieldLabel = textFieldLabel;
        this.buttonLabel = buttonLabel;

        fileChooser = new JFileChooser();

        pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        label = new JLabel(textFieldLabel);

        textField = new JTextField(30);
        button = new JButton(buttonLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        pane.add(label);
        pane.add(textField);
        pane.add(button);
    }

    void buttonActionPerformed(ActionEvent evt) {
        if (mode == MODE_OPEN) {
            if (fileChooser.showOpenDialog(pane) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        } else if (mode == MODE_SAVE) {
            if (fileChooser.showSaveDialog(pane) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }
}
