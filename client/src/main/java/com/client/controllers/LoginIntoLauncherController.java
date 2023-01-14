package com.client.controllers;

<<<<<<< Updated upstream
=======
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.client.ClientCore;
import com.client.helpers.Routes;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

>>>>>>> Stashed changes
/**
 * Class responsible for controlling the layout of the login screen and the
 * functionality.
 */
<<<<<<< Updated upstream
public class LoginIntoLauncherController {
    
    @FXML
    private Button LoginButton, RegisteryButton;
    @FXML
    private TextField LoginField, PasswordField;
=======
public class LoginIntoLauncherController implements Initializable {

    @FXML
    private Button LoginButton;
    private Button RegisteryButton;
    @FXML
    private TextField LoginField;
    private TextField PasswordField;
>>>>>>> Stashed changes
    @FXML
    private URL location;
    @FXML
    private Pane ErrorPane;

    private static Stage stage;
    private static Parent root;

    /**
     * Method for initialize controller and send it to server
     * 
     * @param url            users url
     * @param resourceBundle users resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
<<<<<<< Updated upstream

=======
        ClientCore.getInstance().setLoginIntoLauncherController(this);
>>>>>>> Stashed changes
    }

    /**
     * Method which is responsible for loading the login screen or register screen
     * 
     * @param event what event
     * @throws Exception
     */
    @FXML
<<<<<<< Updated upstream
    private void LoginLauncherControllerButtons(ActionEvent event) throws Exception {
=======
    private void loginLauncherControllerButtons(ActionEvent event) throws Exception {
        try {
            if (event.getSource() == LoginButton) {
                ClientCore.getInstance().reqLogin(LoginField.getText(), PasswordField.getText());
            } else if (event.getSource() == RegisteryButton) {
                loadRegisteryScene();
            }
        } catch (Exception ignored) {
        }
>>>>>>> Stashed changes

    }

    /**
     * Method which is responsible for close error notification after click X on
     * error pane.
     * Also invokes animation
     * 
     * @param e keyEvent
     */
    @FXML
    private void errorButton(ActionEvent e) {
<<<<<<< Updated upstream
 
=======
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(ErrorPane);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method which invokes error pane, and animation
     */
<<<<<<< Updated upstream
    public void ErrorNotification() {

=======
    public void errorNotification() {
        TranslateTransition transition = new TranslateTransition();
        ErrorPane.setVisible(true);
        transition.setNode(ErrorPane);
        transition.setToX(-285);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method responsible for loade the dasboard view scene
     * 
     */
<<<<<<< Updated upstream
    public void LoadDashboardScene() {
        
=======
    public void loadDashboardScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    stage = (Stage) LoginButton.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(Routes.viewsRoute("DashboardView.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root, 1200, 800);
                    scene.getStylesheets().add(Routes.styleRoute("app.css"));
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception ignored) {

                }
            }
        });
>>>>>>> Stashed changes
    }

    /**
     * Method responsible for loading the register view scene
     * 
     * @throws IOException throws if an error occurs
     */
<<<<<<< Updated upstream
    private void LoadRegisteryScene() throws IOException {
);
=======
    private void loadRegisteryScene() throws IOException {
        stage = (Stage) RegisteryButton.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("RegisterView.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));
        stage.setScene(scene);
        stage.show();
>>>>>>> Stashed changes
    }

}
