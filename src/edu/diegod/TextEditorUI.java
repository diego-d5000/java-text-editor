package edu.diegod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by diego-d on 10/17/15.
 */
public class TextEditorUI {
    private JFrame mainFrame;
    private JTextArea textArea;
    private JPanel headerPanel;
    private JPanel bodyPanel;

    public TextEditorUI(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        textArea = new JTextArea();
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        initHeaderPanel();
        initBodyPanel();
    }

    public void showView() {
        mainFrame.add(headerPanel);
        mainFrame.add(Box.createRigidArea(new Dimension(0, 5)));
        mainFrame.add(bodyPanel);
        mainFrame.setVisible(true);
    }

    private void initHeaderPanel(){
        JLabel titleLabel = new JLabel("Lectura de Arcvhvos: ");
        JButton openButton = new JButton("Abrir Archivo...");
        openButton.addActionListener(this::openButtonActionPerformed);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.PAGE_AXIS));
        headerPanel.add(titleLabel);
        headerPanel.add(openButton);
    }

    private void initBodyPanel(){
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.X_AXIS));
        bodyPanel.add(textArea);
    }

    private void openButtonActionPerformed(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        try {
            FileReader fileReader = new FileReader(selectedFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = "";
            String line = "";
            while (((line = bufferedReader.readLine()) != null)) {
                text += line + "\n";
            }
            textArea.setText(text);
        } catch (Exception e) {
        }
    }
}
