package edu.diegod;/**
 * Created by diego-d on 10/29/15.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFxApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/main_view.fxml"));

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Open DiegoTextEditor");
        stage.setScene(scene);
        stage.show();
    }
}
