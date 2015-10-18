package edu.diegod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by diego-d on 10/17/15.
 */
public class Main {
    private static JFrame mainFrame;
    private static TextEditorUI textEditorUI;

    public static void main(String[] args){
        createMainFrame();
        textEditorUI = new TextEditorUI(mainFrame);
        textEditorUI.showView();
    }

    private static void createMainFrame() {
        mainFrame = new JFrame("Sistema Restaurante");
        mainFrame.setSize(1024, 600);
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
