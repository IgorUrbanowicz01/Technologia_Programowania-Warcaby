package com.client.controllers;

<<<<<<< Updated upstream
=======
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.client.ClientCore;
import com.client.helpers.Routes;

import javafx.animation.TranslateTransition;
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
public class StartViewController {
    @FXML
    public Button connectServerButton, errorButton;
    @FXML
    public TextField IP, PORT;
=======
public class StartViewController implements Initializable {

    @FXML
    public Button connectServerButton;
    public Button  errorButton;
    @FXML
    public TextField IP; 
    public TextField PORT;
>>>>>>> Stashed changes

    @FXML
    private Pane ErrorPane;

    /**
     * Method for initialize controller and send it to server
     * 
     * @param url            users url
     * @param resourceBundle users resourceBundle
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
<<<<<<< Updated upstream
        
=======
        ClientCore.getInstance().setStartViewController(this);
>>>>>>> Stashed changes
    }

    /**
     * Method for initialize try to connect to server
     * 
     * @param event users event
     */
    @FXML
<<<<<<< Updated upstream
    private void StartViewControllerButtons(ActionEvent event) {

=======
    private void startViewControllerButtons(ActionEvent event) {
        try {
            ClientCore.getInstance().reqServerConnection(IP.getText(), PORT.getText());
            loadNewScene();
        } catch (Exception e) {
            showError();
        }
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
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
     * Method to show the error pane when any error occurs
     */
    public void showError() {
<<<<<<< Updated upstream
=======
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(ErrorPane);
        transition.setToX(-285);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method which load the Login and Registery view
     * 
     * @throws IOException throws if an error occurs
     */
<<<<<<< Updated upstream
    public void LoadNewScene() throws IOException {
=======
    public void loadNewScene() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) connectServerButton.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("loginIntoLauncher.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));

        stage.setScene(scene);
        stage.show();
>>>>>>> Stashed changes

    }

    /**
     * Getter for the IP
     * 
     * @return String IP which put users
     */
    public String getIP() {
        return this.IP.getText();
    }

}
