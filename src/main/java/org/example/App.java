package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ubuntu");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add("/org/example/Styles.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}