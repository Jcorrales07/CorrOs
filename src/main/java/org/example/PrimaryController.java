package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;

public class PrimaryController {
    @FXML
    private ImageView IconMusic, IconNavigator, IconPhotos, IconShell, IconTextEditor,
                        IconUbuntu, dirDocuments, dirMusic, dirPhotos, IconBubuntu;
    @FXML
    private AnchorPane main, desktop, login;
    @FXML
    private Button btnMenu, btnAddUser, btnLogout, btnShutdown, btnSignIn;
    @FXML
    private Pane desktopPrincipal, paneMenu, loginForm, panelAddUser;
    @FXML
    private TextField txtUsername, txtUser, txtPass;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TreeView treeSystem;

    public static User userLogged;

    public void initialize() {

    }

    void login() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        try {
            if(Administrator.loggin(username, password)) {
                desktop.setVisible(true);
                loginForm.setVisible(false);
                userLogged = Administrator.searchUser(username);
                btnAddUser.setVisible(userLogged instanceof Admin); // <- If an Admin is logged, he can add users
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("[!][!][!][!][!][!][!]");
                alert.setHeaderText("Wrong password");
                alert.setContentText("Your password/username doesn't match");
                alert.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSignInClicked(MouseEvent event) {
        login();
    }


    @FXML
    void btnSignInPressed(KeyEvent event) {
        login();
    }

    @FXML
    void btnAddClicked(MouseEvent event) {

    }

    @FXML
    void btnAddPressed(KeyEvent event) {

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

    void logout() {
        desktop.setVisible(false);
        login.setVisible(true);
        loginForm.setVisible(true);
    }

    @FXML
    void btnLogoutClicked(MouseEvent event) {
        logout();
    }

    @FXML
    void btnLogoutPressed(KeyEvent event) {
        logout();
    }

    void addUser(String username, String password) throws IOException {
        panelAddUser.setVisible(true);
        File rootFile = new File("C:\\Users\\Corra\\NetBeansProjects\\LinuxOs\\Z");
        String path = "C:\\Users\\Corra\\NetBeansProjects\\LinuxOs\\Z";
        //TreeView
//        TreeItem<File> root = createNode(new File(path));
//        treeSystem = new TreeView<File>(root);
            TreeItem<String> rootItem = new TreeItem<>("files");
            treeSystem.setRoot(rootItem);

//        Administrator.addUsers(username, password);
        //Hacer la manipulacion del treeview
    }


    private TreeItem<File> createNode(final File f) {
        return new TreeItem<File>(f) {
            private boolean isLeaf;
            private boolean isFirstTimeChildren = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
                if (isFirstTimeChildren) {
                    isFirstTimeChildren = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    File f = (File) getValue();
                    isLeaf = f.isFile();
                }
                return isLeaf;
            }

            private ObservableList<TreeItem<File>> buildChildren(TreeItem<File> TreeItem) {
                File f = TreeItem.getValue();
                if (f == null) {
                    return FXCollections.emptyObservableList();
                }
                if (f.isFile()) {
                    return FXCollections.emptyObservableList();
                }
                File[] files = f.listFiles();
                if (files != null) {
                    ObservableList<TreeItem<File>> children = FXCollections
                            .observableArrayList();
                    for (File childFile : files) {
                        children.add(createNode(childFile));
                    }
                    return children;
                }
                return FXCollections.emptyObservableList();
            }
        };
    }



    @FXML
    void btnAddUserClicked(MouseEvent event) throws IOException {

        addUser(txtUser.getText(), txtPass.getText());
    }

    @FXML
    void btnAddUserPressed(KeyEvent event) throws IOException {
        addUser(txtUser.getText(), txtPass.getText());
    }

    @FXML
    void btnExitClicked(MouseEvent event) {
        panelAddUser.setVisible(false);
    }
}
