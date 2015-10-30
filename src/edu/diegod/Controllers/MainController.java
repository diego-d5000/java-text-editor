package edu.diegod.Controllers;

import edu.diegod.Models.TextDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.File;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by diego-d on 10/29/15.
 */
public class MainController {
    private TextDocument textDocument;
    @FXML private Label labelDocumentName;
    @FXML private TextArea textAreaEditor;
    @FXML private Button buttonSave;
    @FXML private Button buttonSaveAs;
    @FXML private Button buttonRename;
    @FXML private Button buttonDelete;

    @FXML protected void buttonOpenAction(ActionEvent e) {
        textDocument = new TextDocument();

        textDocument.openFile();
        textAreaEditor.setText(textDocument.getContents());
        labelDocumentName.setText(textDocument.getFileName());

        toggleButtonsWhenFileIsPresent(true);
    }

    @FXML protected void buttonNewFileAction(ActionEvent e){
        textDocument = new TextDocument();

        String fileName = "noname.txt";
        String fileContents = "";
        textDocument.setFileName(fileName);
        textDocument.setContents(fileContents);
        labelDocumentName.setText(fileName);
        textAreaEditor.setText(fileContents);

        toggleButtonsWhenFileIsPresent(false);
        buttonSaveAs.setVisible(true);
        textAreaEditor.setVisible(true);
    }

    @FXML protected void buttonSaveAction(ActionEvent e){
        textDocument.setContents(textAreaEditor.getText());
        textDocument.saveFile();
    }

    @FXML protected void buttonSaveAsAction(ActionEvent e){
        textDocument.setContents(textAreaEditor.getText());

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Como...");
        fileChooser.showSaveDialog(null);
        File fileSelected = fileChooser.getSelectedFile();

        textDocument.setFile(fileSelected);
        textDocument.setFileName(fileSelected.getName());
        labelDocumentName.setText(fileSelected.getName());
        textDocument.saveFileAs(fileSelected.getPath());

        toggleButtonsWhenFileIsPresent(true);
    }

    @FXML protected void buttonRenameAction(ActionEvent e){
        TextInputDialog textInputDialog = new TextInputDialog(textDocument.getFileName());
        textInputDialog.setTitle("Renombrar");
        textInputDialog.setHeaderText("Introduce el nuevo nombre...");
        textInputDialog.setContentText("Renombrar a: ");

        Optional<String> result = textInputDialog.showAndWait();
        result.ifPresent(new Consumer<String>() {
            @Override
            public void accept(String newName) {
                textDocument.renameFile(newName);
                labelDocumentName.setText(textDocument.getFileName());
            }
        });
    }

    @FXML protected void buttonDeleteAction(ActionEvent e){
        textDocument.deleteFile();
        textAreaEditor.setText("");
        labelDocumentName.setText("");

        toggleButtonsWhenFileIsPresent(false);
    }

    private void toggleButtonsWhenFileIsPresent(boolean areVisible){
        textAreaEditor.setVisible(areVisible);
        buttonSave.setVisible(areVisible);
        buttonSaveAs.setVisible(areVisible);
        buttonRename.setVisible(areVisible);
        buttonDelete.setVisible(areVisible);
    }


}
