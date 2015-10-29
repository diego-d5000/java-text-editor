package edu.diegod.Controllers;

import edu.diegod.Models.TextDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * Created by diego-d on 10/29/15.
 */
public class MainController {
    private TextDocument textDocument = new TextDocument();
    @FXML private Text textDocumentName;
    @FXML private TextArea textAreaEditor;
    @FXML private Button buttonNew;

    @FXML protected void buttonOpenAction(ActionEvent e) {
        textDocument.openFile();
        textAreaEditor.setText(textDocument.getContents());
        textDocumentName.setText(textDocument.getFileName());
    }

}
