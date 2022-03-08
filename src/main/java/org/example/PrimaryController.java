package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PrimaryController {
    @FXML
    private ImageView IconMusic, IconNavigator, IconPhotos, IconShell, IconTextEditor;
    @FXML
    private ImageView IconUbuntu, dirDocuments, dirMusic, dirPhotos;
    @FXML
    private Button btnMenu, btnAddUser, btnLogout, btnShutdown;
    @FXML
    private Pane desktop, paneMenu;

    public void initialize() {

    }

    @FXML
    void editorClicked(MouseEvent event) {

    }

    @FXML
    void musicClicked(MouseEvent event) {

    }

    @FXML
    void navigatorClicked(MouseEvent event) {

    }

    @FXML
    void photosClicked(MouseEvent event) {

    }

    @FXML
    void shellClicked(MouseEvent event) {

    }

    @FXML
    void ubuntuClicked(MouseEvent event) {
        paneMenu.setVisible(!paneMenu.isVisible());
    }

    @FXML
    void btnShutDownClicked(MouseEvent event) {
        System.exit(0);
    }
}
